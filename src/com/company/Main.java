package com.company;

import com.company.FindCharacterPattern.FindPattern;

public class Main {

    public static void main(String[] args) {

        PathFinder pathFinder = new PathFinder();
        //pathFinder.setMaze("/Users/jesuszarate/PathFinder/src/com/company/tinyMaze.txt");


        //PathFinder.solveMaze("/Users/jesuszarate/PathFinder/src/com/company/tinyMaze.txt",
        //        "/Users/jesuszarate/PathFinder/src/com/company/tinyMazeSol.txt");

//        PathFinder.solveMaze("/Users/jesuszarate/PathFinder/src/com/company/mediumMaze.txt",
//                "/Users/jesuszarate/PathFinder/src/com/company/mediumMazeSol.txt");

       System.out.println( FindPattern.findPattern("microsost",
                "/Users/jesuszarate/PathFinder/src/com/company/FindCharacterPattern/charArray.txt"));
    }
}
