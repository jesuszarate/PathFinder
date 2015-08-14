package com.company;

public class Main {

    public static void main(String[] args) {

        PathFinder pathFinder = new PathFinder();
        //pathFinder.setMaze("/Users/jesuszarate/PathFinder/src/com/company/tinyMaze.txt");

        PathFinder.solveMaze("/Users/jesuszarate/PathFinder/src/com/company/tinyMaze.txt",
                "/Users/jesuszarate/PathFinder/src/com/company/tinyMazeSol.txt");
    }
}
