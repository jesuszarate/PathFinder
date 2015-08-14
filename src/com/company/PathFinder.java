package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jesus Zarate on 8/14/15.
 */
public class PathFinder
{
    Node[][] maze;
    Queue<Node> queue;
    Node start;
    Node goal;
    int width = 0;
    int height = 0;

    public static void solveMaze(String inpuFile, String outputFile)
    {
        PathFinder pf = new PathFinder();
        pf.setMaze(inpuFile);

        pf.queue = new LinkedList<Node>();
        pf.queue.add(pf.start);

        boolean foundGoal = false;
        while (!pf.queue.isEmpty())
        {
            if(pf.queue.peek().equals(pf.goal))
            {
                foundGoal = true;
            }
            else {
                Node current = pf.queue.poll();

                for(Node neighborNode : current.getNeighbors())
                {
                    neighborNode.setCameFrom(current);
                    neighborNode.setVisited(true);
                    pf.queue.add(neighborNode);
                }
            }
        }

    }

    public void setMaze(String inputFile)
    {
        Reader file = null;
        try {
            file = new FileReader(inputFile);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(file);

        // Get the dimensions of the graph
        try
        {
            String[] dimensions = reader.readLine().split(" ");
            height = Integer.parseInt(dimensions[0]);
            width = Integer.parseInt(dimensions[1]);

            maze = new Node[height][width];

            for(int row = 0; row < height; row++)
            {
                for (int col = 0; col < width; col++)
                {
                    char current = (char) reader.read();
                    if(current == '\n')
                        current = (char)reader.read();

                    switch (current)
                    {
                        case 'X':
                            maze[row][col] = null;
                            break;
                        case 'S':
                            maze[row][col] = new Node(current);
                            start = maze[row][col];
                            break;
                        case 'G':
                            maze[row][col] = new Node(current);
                            start = maze[row][col];
                            break;
                        case ' ':
                            maze[row][col] = new Node(current);
                            break;
                    }
                }
            }

            for(int row = 0; row < height; row++)
                for(int col = 0; col < height; col++)
                {
                    if(maze[row][col] != null)
                        addNeighbors(maze, row, col);
                }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addNeighbors(Node[][] maze, int row, int col)
    {
        Node current = maze[row][col];

        // Left
        if((row - 1) >= 0 && maze[row - 1][col] != null)
            current.getNeighbors().add(maze[row - 1][col]);

        // Top
        if((col - 1) >= 0 && maze[row][col - 1] != null)
            current.getNeighbors().add(maze[row][col - 1]);

        // Right
        if((row + 1) < height && maze[row + 1][col] != null)
            current.getNeighbors().add(maze[row + 1][col]);

        // Bottom
        if((col + 1) < width && maze[row][col + 1] != null)
            current.getNeighbors().add(maze[row][col + 1]);
    }

}
