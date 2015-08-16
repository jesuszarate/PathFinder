package com.company.FindCharacterPattern;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jesus Zarate on 8/14/15.
 */
public class FindPattern
{
    private Node[][] charArray;
    private String goalWord;
    private char goalCharacter;
    char startCharacter;
    private ArrayList<Node> possibleStart;
    private ArrayList<Node> possibleGoal;
    private Node goal;
    private Node start;
    private int height;
    private int width;
    private Queue<Node> queue;

    public static boolean findPattern(String goalWord, String inputFile)
    {
        FindPattern findPattern = new FindPattern();
        findPattern.goalWord = goalWord.toUpperCase();
        findPattern.startCharacter =  findPattern.goalWord.charAt(0);
        findPattern.goalCharacter = findPattern.goalWord.charAt(goalWord.length() - 1);

        findPattern.setArray(inputFile);
        findPattern.queue = new LinkedList<Node>();

        int currentCharIndex = 1;
        boolean foundGoal = false;
        for(Node start : findPattern.possibleStart)
        {
            start.setCharIndex(currentCharIndex);
            findPattern.queue.add(start);
            while (!findPattern.queue.isEmpty())
            {
                Node current = findPattern.queue.remove();
                if(current.getData() == findPattern.goalCharacter
                        && current.getCharIndex() == findPattern.goalWord.length())
                {
                    foundGoal = true;
                    break;
                }

                for(Node neighbor : current.getNeighbors())
                {
                    char currChar = neighbor.getData();
                    if(currChar == findPattern.goalWord.charAt(current.getCharIndex()))
                    {
                        findPattern.queue.add(neighbor);
                        neighbor.setCharIndex(current.getCharIndex() + 1);
                        //neighbor.setCharIndex(currentCharIndex);
                    }
                }
            }
        }
        return foundGoal;
    }

    public void setArray(String inputFile)
    {
        Reader file = null;

        try
        {
            file = new FileReader(inputFile);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(file);

        this.height = 0;
        this.width = 0;
        try
        {
            String[] dimens = reader.readLine().split(" ");
            this.height = Integer.parseInt(dimens[0]);
            this.width = Integer.parseInt(dimens[1]);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        charArray = new Node[height][width];
        possibleGoal = new ArrayList<Node>();
        possibleStart = new ArrayList<Node>();

        try
        {
            for (int row = 0; row < height; row++)
            {
                for (int col = 0; col < width; col++)
                {
                    char current = (char) reader.read();

                    if(current == '\n')
                        current = (char) reader.read();

                    Node node = new Node(current);
                    if(current == startCharacter)
                    {
                        possibleStart.add(node);
                    }
                    if(current == goalCharacter)
                    {
                        possibleGoal.add(node);
                    }
                    charArray[row][col] = node;
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        for (int row = 0; row < height; row++)
        {
            for (int col = 0; col < width; col++)
            {
                addNeighbors(charArray, row, col);
            }
        }
    }

    public void addNeighbors(Node[][] array, int row, int col)
    {
        Node current = array[row][col];

        // West
        if ((row - 1) >= 0 && array[row - 1][col] != null)
            current.addNeighbor(array[row - 1][col]);

        // North West
        if ((row - 1) >= 0  && (col - 1) >= 0 && array[row - 1][col - 1] != null)
            current.addNeighbor(array[row - 1][col - 1]);

        // North
        if ((col - 1) >= 0 && array[row][col - 1] != null)
            current.addNeighbor(array[row][col - 1]);

        // North East
        if ((row + 1) < this.height && (col - 1) >= 0 && array[row + 1][col - 1] != null)
            current.addNeighbor(array[row + 1][col - 1]);

        // East
        if ((row + 1) < this.height && array[row + 1][col] != null) current.addNeighbor(array[row + 1][col]);

        // South East
        if ((row + 1) < this.height && (col + 1) < this.width && array[row + 1][col + 1] != null)
            current.addNeighbor(array[row + 1][col + 1]);

        // South
        if ((col + 1) < this.width && array[row][col + 1] != null)
            current.addNeighbor(array[row][col + 1]);

        // South West
        if ((row - 1) >= 0 && (col + 1) < this.width && array[row - 1][col + 1] != null)
            current.addNeighbor(array[row - 1][col + 1]);
    }
}

// 0  1  2  3

// 1

// 2     h

// 3
