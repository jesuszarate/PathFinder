package com.company.FindCharacterPattern;

import java.util.ArrayList;

/**
 * Created by Jesus Zarate on 8/14/15.
 */
public class Node
{
    private char data;
    private ArrayList<Node> neighbors;
    private boolean visited;
    private Node cameFrom;
    private int charIndex;

    public Node(char _data)
    {
        this.data = _data;
        neighbors = new ArrayList<Node>();
    }

    public char getData()
    {
        return data;
    }

    public void setData(char data)
    {
        this.data = data;
    }

    public int getCharIndex()
    {
        return charIndex;
    }

    public void setCharIndex(int charIndex)
    {
        this.charIndex = charIndex;
    }

    public void addNeighbor(Node node)
    {
        this.neighbors.add(node);
    }

    public ArrayList<Node> getNeighbors()
    {
        return neighbors;
    }

    public void setNeighbors(ArrayList<Node> neighbors)
    {
        this.neighbors = neighbors;
    }

    public boolean isVisited()
    {
        return visited;
    }

    public void setVisited(boolean visited)
    {
        this.visited = visited;
    }

    public Node getCameFrom()
    {
        return cameFrom;
    }

    public void setCameFrom(Node cameFrom)
    {
        this.cameFrom = cameFrom;
    }
}
