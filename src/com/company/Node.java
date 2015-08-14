package com.company;

import java.util.ArrayList;

/**
 * Created by Jesus Zarate on 8/14/15.
 */
public class Node
{
    char data;
    ArrayList<Node> neighbors;
    boolean visited = false;
    Node cameFrom;

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

    public ArrayList<Node> getNeighbors()
    {
        return neighbors;
    }

    public void setNeighbors(ArrayList<Node> neighbors)
    {
        this.neighbors = neighbors;
    }

    public void addNeighbor(Node node)
    {
        this.neighbors.add(node);
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
