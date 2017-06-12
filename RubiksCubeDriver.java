//************************************************************************************************************************************
// public class RubiksCubeDriver
// Author: Rohit M.
// Description: Driver class for the RubiksCube class.
//************************************************************************************************************************************

import javax.swing.*;
import java.awt.*;
import java.util.*;
// Imports packages for Scanner, Color, and JOptionPane classes.

public class RubiksCubeDriver
{
  // main method
  public static void main(String [] args)
  {
    // Declares needed variables.
    Color square;
    String input;
    Color [][][] cubeColors = new Color[6][3][3];
    int rerun = JOptionPane.NO_OPTION;
    // do-while loop goes on while user wants to test a cube.
    do
    {
      try
      {
        // Introduction messages.
        JOptionPane.showMessageDialog(null, "Hello, welcome to Rubik's Cube Solver!", "Introduction", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "The only colors accepted are red, blue, green, yellow, orange, and white.", "Introduction", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "If a color besides one of the options is entered, you will be asked again.", "Introduction", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "If an invalid cube is entered, the solver might close and result in a run time error, or list an infinite set of repeating steps, or may result in steps that don't solve the cube.", "Introduction", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "Cube's validity is not checked, so please enter the colors correctly.", "Introduction", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "If a blank pop up is displayed, that means the step indicated by the title is already complete.", "Introduction", JOptionPane.PLAIN_MESSAGE);
        // Takes input for a face.
        JOptionPane.showMessageDialog(null, "Face 0 is the face of the Rubik's Cube that is currently facing you. \nPlease select your Face 0.\nAll Faces are relative to Face 0, so between different Faces, return orientation so that Face 0 is facing you.", "Face 0", JOptionPane.PLAIN_MESSAGE);
        // Asks for each position on a face.
        for(int x = 0; x<3; x++)
        {
          for(int y = 0; y<3; y++)
          {
            // Takes inputs until a valid input is given.
            do
            {
              input = JOptionPane.showInputDialog(null, "Enter the color at Face 0, row " + (x+1) + ", column " + (y+1) + ".", "Face 0", JOptionPane.PLAIN_MESSAGE);
              if(input.equalsIgnoreCase("red") || input.equalsIgnoreCase("r"))
                square = Color.red;
              else if(input.equalsIgnoreCase("blue") || input.equalsIgnoreCase("b"))
                square = Color.blue;
              else if(input.equalsIgnoreCase("green") || input.equalsIgnoreCase("g"))
                square = Color.green;
              else if(input.equalsIgnoreCase("yellow") || input.equalsIgnoreCase("y"))
                square = Color.yellow;
              else if(input.equalsIgnoreCase("orange") || input.equalsIgnoreCase("o"))
                square = Color.orange;
              else if(input.equalsIgnoreCase("white") || input.equalsIgnoreCase("w"))
                square = Color.white;
              else
                square = null;
            }
            while(square==null);
            cubeColors[0][x][y] = square;
          }
        }
        // Takes input for a face.
        JOptionPane.showMessageDialog(null, "Face 1 is the top face of the Rubik's Cube. Have Face 0 facing you and look at the cube from a top down view.", "Face 1", JOptionPane.PLAIN_MESSAGE);
        // Asks for each position on a face.
        for(int x = 0; x<3; x++)
        {
          for(int y = 0; y<3; y++)
          {
            // Takes inputs until a valid input is given.
            do
            {
              input = JOptionPane.showInputDialog(null, "Enter the color at Face 1, row " + (x+1) + ", column " + (y+1) + ".", "Face 1", JOptionPane.PLAIN_MESSAGE);
              if(input.equalsIgnoreCase("red") || input.equalsIgnoreCase("r"))
                square = Color.red;
              else if(input.equalsIgnoreCase("blue") || input.equalsIgnoreCase("b"))
                square = Color.blue;
              else if(input.equalsIgnoreCase("green") || input.equalsIgnoreCase("g"))
                square = Color.green;
              else if(input.equalsIgnoreCase("yellow") || input.equalsIgnoreCase("y"))
                square = Color.yellow;
              else if(input.equalsIgnoreCase("orange") || input.equalsIgnoreCase("o"))
                square = Color.orange;
              else if(input.equalsIgnoreCase("white") || input.equalsIgnoreCase("w"))
                square = Color.white;
              else
                square = null;
            }
            while(square==null);
            cubeColors[1][x][y] = square;
          }
        }
        // Takes input for a face.
        JOptionPane.showMessageDialog(null, "Face 2 is the face to the right of Face 0. Face Face 0 and then turn the whole cube 90 degrees clockwise.", "Face 2", JOptionPane.PLAIN_MESSAGE);
        // Asks for each position on a face.
        for(int x = 0; x<3; x++)
        {
          for(int y = 0; y<3; y++)
          {
            // Takes inputs until a valid input is given.
            do
            {
              input = JOptionPane.showInputDialog(null, "Enter the color at Face 2, row " + (x+1) + ", column " + (y+1) + ".", "Face 2", JOptionPane.PLAIN_MESSAGE);
              if(input.equalsIgnoreCase("red") || input.equalsIgnoreCase("r"))
                square = Color.red;
              else if(input.equalsIgnoreCase("blue") || input.equalsIgnoreCase("b"))
                square = Color.blue;
              else if(input.equalsIgnoreCase("green") || input.equalsIgnoreCase("g"))
                square = Color.green;
              else if(input.equalsIgnoreCase("yellow") || input.equalsIgnoreCase("y"))
                square = Color.yellow;
              else if(input.equalsIgnoreCase("orange") || input.equalsIgnoreCase("o"))
                square = Color.orange;
              else if(input.equalsIgnoreCase("white") || input.equalsIgnoreCase("w"))
                square = Color.white;
              else
                square = null;
            }
            while(square==null);
            cubeColors[2][x][y] = square;
          }
        }
        // Takes input for a Face.
        JOptionPane.showMessageDialog(null, "Face 3 is the bottom face of the cube. Look at the cube from a top down view, and turn it so Face 0 is pointing up.\n Face 3 is where Face 0 was before.", "Face 3", JOptionPane.PLAIN_MESSAGE);
        // Asks for each position on a face.
        for(int x = 0; x<3; x++)
        {
          for(int y = 0; y<3; y++)
          {
            // Takes inputs until a valid input is given.
            do
            {
              input = JOptionPane.showInputDialog(null, "Enter the color at Face 3, row " + (x+1) + ", column " + (y+1) + ".", "Face 3", JOptionPane.PLAIN_MESSAGE);
              if(input.equalsIgnoreCase("red") || input.equalsIgnoreCase("r"))
                square = Color.red;
              else if(input.equalsIgnoreCase("blue") || input.equalsIgnoreCase("b"))
                square = Color.blue;
              else if(input.equalsIgnoreCase("green") || input.equalsIgnoreCase("g"))
                square = Color.green;
              else if(input.equalsIgnoreCase("yellow") || input.equalsIgnoreCase("y"))
                square = Color.yellow;
              else if(input.equalsIgnoreCase("orange") || input.equalsIgnoreCase("o"))
                square = Color.orange;
              else if(input.equalsIgnoreCase("white") || input.equalsIgnoreCase("w"))
                square = Color.white;
              else
                square = null;
            }
            while(square==null);
            cubeColors[3][x][y] = square;
          }
        }
        // Takes input for a face.
        JOptionPane.showMessageDialog(null, "Face 4 is the face to the left of Face 0. Face Face 0 and then turn the whole cube 90 degrees counter-clockwise.", "Face 4", JOptionPane.PLAIN_MESSAGE);
        // Asks for each position on a face.
        for(int x = 0; x<3; x++)
        {
          for(int y = 0; y<3; y++)
          {
            // Takes inputs until a valid input is given.
            do
            {
              input = JOptionPane.showInputDialog(null, "Enter the color at Face 4, row " + (x+1) + ", column " + (y+1) + ".", "Face 4", JOptionPane.PLAIN_MESSAGE);
              if(input.equalsIgnoreCase("red") || input.equalsIgnoreCase("r"))
                square = Color.red;
              else if(input.equalsIgnoreCase("blue") || input.equalsIgnoreCase("b"))
                square = Color.blue;
              else if(input.equalsIgnoreCase("green") || input.equalsIgnoreCase("g"))
                square = Color.green;
              else if(input.equalsIgnoreCase("yellow") || input.equalsIgnoreCase("y"))
                square = Color.yellow;
              else if(input.equalsIgnoreCase("orange") || input.equalsIgnoreCase("o"))
                square = Color.orange;
              else if(input.equalsIgnoreCase("white") || input.equalsIgnoreCase("w"))
                square = Color.white;
              else
                square = null;
            }
            while(square==null);
            cubeColors[4][x][y] = square;
          }
        }
        // Takes input for a face.
        JOptionPane.showMessageDialog(null, "Face 5 is the back face of the Rubik's Cube. Face Face 0 and turn the whole cube 180 degrees around.", "Face 5", JOptionPane.PLAIN_MESSAGE);
        // Asks for each position on a face.
        for(int x = 0; x<3; x++)
        {
          for(int y = 0; y<3; y++)
          {
            // Takes inputs until a valid input is given.
            do
            {
              input = JOptionPane.showInputDialog(null, "Enter the color at Face 5, row " + (x+1) + ", column " + (y+1) + ".", "Face 5", JOptionPane.PLAIN_MESSAGE);
              if(input.equalsIgnoreCase("red") || input.equalsIgnoreCase("r"))
                square = Color.red;
              else if(input.equalsIgnoreCase("blue") || input.equalsIgnoreCase("b"))
                square = Color.blue;
              else if(input.equalsIgnoreCase("green") || input.equalsIgnoreCase("g"))
                square = Color.green;
              else if(input.equalsIgnoreCase("yellow") || input.equalsIgnoreCase("y"))
                square = Color.yellow;
              else if(input.equalsIgnoreCase("orange") || input.equalsIgnoreCase("o"))
                square = Color.orange;
              else if(input.equalsIgnoreCase("white") || input.equalsIgnoreCase("w"))
                square = Color.white;
              else
                square = null;
            }
            while(square==null);
            cubeColors[5][x][y] = square;
          }
        }
        
        // Creates a cube using the 3D color array created from the users 
        RubiksCube cube = new RubiksCube(cubeColors);
        
        // Creates a Scanner to process the String from crossSolution()
        Scanner cross = new Scanner(cube.crossSolution());
        // While there is a next line, it displays the next line in a message dialog.
        while(cross.hasNextLine())
        {
          JOptionPane.showMessageDialog(null, cross.nextLine(), "Making the cross", JOptionPane.PLAIN_MESSAGE);
        }
        
        // Creates a Scanner to process the String from allignCenterSolution()
        Scanner allignCenters = new Scanner(cube.allignCenterSolution());
        // While there is a next line, it displays the next line in a message dialog.
        while(allignCenters.hasNextLine())
        {
          JOptionPane.showMessageDialog(null, allignCenters.nextLine(), "Alligning centers", JOptionPane.PLAIN_MESSAGE);
        }
        
        // Creates a Scanner to process the String from solveCornerSolution()
        Scanner corners = new Scanner(cube.solveCornerSolution());
        // While there is a next line, it displays the next line in a message dialog.
        while(corners.hasNextLine())
        {
          JOptionPane.showMessageDialog(null, corners.nextLine(), "Solving the corners", JOptionPane.PLAIN_MESSAGE);
        }
        
        // Creates a Scanner to process the String from solveSecondLayerSolution()
        Scanner secondLayer = new Scanner(cube.solveSecondLayerSolution());
        // While there is a next line, it displays the next line in a message dialog.
        while(secondLayer.hasNextLine())
        {
          JOptionPane.showMessageDialog(null, secondLayer.nextLine(), "Solving the second layer", JOptionPane.PLAIN_MESSAGE);
        }
        
        // Creates a Scanner to process the String from solveOppositeFaceSolution()
        Scanner opposite = new Scanner(cube.solveOppositeFaceSolution());
        // While there is a next line, it displays the next line in a message dialog.
        while(opposite.hasNextLine())
        {
          JOptionPane.showMessageDialog(null, opposite.nextLine(), "Solving the opposite face", JOptionPane.PLAIN_MESSAGE);
        }
        
        // Creates a Scanner to process the String from solveFinishCubeSolution()
        Scanner finish = new Scanner(cube.solveFinishCubeSolution());
        // While there is a next line, it displays the next line in a message dialog.
        while(finish.hasNextLine())
        {
          JOptionPane.showMessageDialog(null, finish.nextLine(), "Finishing the cube", JOptionPane.PLAIN_MESSAGE);
        }
        
        // Congratulation message.
        JOptionPane.showMessageDialog(null, "Congratulations, you're done with the Rubik's Cube!", "Congratulations!", JOptionPane.PLAIN_MESSAGE);
      }
      // If the user tries to click on the "x" and exit, then NullPointerException is caught and nothing is done.
      catch(NullPointerException e) {}
      // Asks the user if they want to run the program again. Sets int rerun according to their input
        rerun = JOptionPane.showConfirmDialog(null, "Would you like to solve another cube?", "Rerun?", JOptionPane.YES_NO_OPTION);
    }
    while(rerun == JOptionPane.YES_OPTION);
  }
}