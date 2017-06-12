//************************************************************************************************************************************
// public class RubiksCube
// Author: Rohit M.
// Description: Stores the colors of a Rubik's Cube puzzle and has methods to turn the sides and solve the cube recrusively.
//              Also contains a toString() method that prints out the current position of the cube.
//              Face 0 is the front face. Face 1 is the face above Face 0. Face 2 is the Face to the right of Face 0.
//              Face 3 is below Face 0. Face 4 is to the left of Face 0. Face 5 is found by turning the cube 180 degrees from Face 0.
//************************************************************************************************************************************

import java.awt.*;
// Imports the package needed for the Color class.

public class RubiksCube
{
  // 3D Color array stores the colors on the cube.
  // Stores face (0-5), row (0-2), and column (0-2).
  private Color[][][] cube;
  
  // Insance variables to store the center color of each face.
  private Color centerColor0;
  private Color centerColor1;
  private Color centerColor2;
  private Color centerColor3;
  private Color centerColor4;
  private Color centerColor5;
  
  // String variables that store the solutions for each step
  private String crossSolution = "";
  private String allignCenterSolution = "";
  private String solveCornerSolution = "";
  private String solveSecondLayerSolution = "";
  private String solveOppositeFace = "";
  private String finishCube = "";
  
  // final static variables that make storing colors variables
  public static final Color p = Color.pink;
  public static final Color r = Color.red;
  public static final Color g = Color.green;
  public static final Color b = Color.blue;
  public static final Color w = Color.white;
  public static final Color y = Color.yellow;
  public static final Color o = Color.orange;
  
  // Default constructor, sets up a default cube.
  public RubiksCube()
  {
    cube = new Color [][][]
    {
      {
        {w,w,w},
        {w,w,w},
        {w,w,w}
      },
      {
        {o,g,y},
        {g,g,g},
        {g,g,g}
      },
      {
        {b,b,r},
        {b,b,o},
        {b,b,o}
      },
      {
        {y,y,y},
        {y,y,y},
        {g,o,b}
      },
      {
        {g,r,r},
        {y,r,r},
        {b,r,r}
      },
      {
        {o,o,r},
        {b,o,o},
        {y,r,o}
      }
    };
    // Stores the center colors.
    centerColor0 = cube[0][1][1];
    centerColor1 = cube[1][1][1];
    centerColor2 = cube[2][1][1];
    centerColor3 = cube[3][1][1];
    centerColor4 = cube[4][1][1];
    centerColor5 = cube[5][1][1];
  }
  
  // Constructor that takes a 3D Color array to
  public RubiksCube(Color [][][] cube)
  {
    // Stores the cube from the parameter in the instance variable.
    this.cube = cube;
    // Stores the center colors.
    centerColor0 = cube[0][1][1];
    centerColor1 = cube[1][1][1];
    centerColor2 = cube[2][1][1];
    centerColor3 = cube[3][1][1];
    centerColor4 = cube[4][1][1];
    centerColor5 = cube[5][1][1];
  }
  
  // Solves the RubiksCube using random turns. NOT RECOMMENDED!
//  public void solve()
//  {
//    Random random = new Random();
//    while(((cube[0][0][0] != centerColor0) && (cube[0][0][1] != centerColor0) && (cube[0][0][2] != centerColor0) &&
//          (cube[0][1][0] != centerColor0) && (cube[0][1][1] != centerColor0) && (cube[0][1][2] != centerColor0) && 
//          (cube[0][2][0] != centerColor0) && (cube[0][2][1] != centerColor0) && (cube[0][2][2] != centerColor0) && 
//          (cube[1][0][0] != centerColor1) && (cube[1][0][1] != centerColor1) && (cube[1][0][2] != centerColor1) &&
//          (cube[1][1][0] != centerColor1) && (cube[1][1][1] != centerColor1) && (cube[1][1][2] != centerColor1) && 
//          (cube[1][2][0] != centerColor1) && (cube[1][2][1] != centerColor1) && (cube[1][2][2] != centerColor1) && 
//          (cube[2][0][0] != centerColor2) && (cube[2][0][1] != centerColor2) && (cube[2][0][2] != centerColor2) &&
//          (cube[2][1][0] != centerColor2) && (cube[2][1][1] != centerColor2) && (cube[2][1][2] != centerColor2) && 
//          (cube[2][2][0] != centerColor2) && (cube[2][2][1] != centerColor2) && (cube[2][2][2] != centerColor2) && 
//          (cube[3][0][0] != centerColor3) && (cube[3][0][1] != centerColor3) && (cube[3][0][2] != centerColor3) &&
//          (cube[3][1][0] != centerColor3) && (cube[3][1][1] != centerColor3) && (cube[3][1][2] != centerColor3) && 
//          (cube[3][2][0] != centerColor3) && (cube[3][2][1] != centerColor3) && (cube[3][2][2] != centerColor3) && 
//          (cube[4][0][0] != centerColor4) && (cube[4][0][1] != centerColor4) && (cube[4][0][2] != centerColor4) &&
//          (cube[4][1][0] != centerColor4) && (cube[4][1][1] != centerColor4) && (cube[4][1][2] != centerColor4) && 
//          (cube[4][2][0] != centerColor4) && (cube[4][2][1] != centerColor4) && (cube[4][2][2] != centerColor4) && 
//          (cube[5][0][0] != centerColor5) && (cube[5][0][1] != centerColor5) && (cube[5][0][2] != centerColor5) &&
//          (cube[5][1][0] != centerColor5) && (cube[5][1][1] != centerColor5) && (cube[5][1][2] != centerColor5) && 
//          (cube[5][2][0] != centerColor5) && (cube[5][2][1] != centerColor5) && (cube[5][2][2] != centerColor5)) == false)
//    {
//      turn(random.nextInt(6));
//    }
//  }
  
  // First calls the methods to solve the cross, then returns a String with the solution.
  public String crossSolution()
  {
    makeUpperCross(false);
    makeRightCross(false);
    makeLowerCross(false);
    makeLeftCross(false);
    return crossSolution;
  }
  
  // First calls all the methods to allign the centers, then returns a String with the solution.
  public String allignCenterSolution()
  {
    allignCenter1();
    allignCenter234();
    return allignCenterSolution;
  }
  
  // First calls all the methods to solve the corners on Face 0, then returns a String with the solution.
  public String solveCornerSolution()
  {
    solveCorners(false,false,false,false);
    return solveCornerSolution;
  }
  
  // First calls all the methods to solve the second layer, and then returns a String with the solution.
  public String solveSecondLayerSolution()
  {
    solveSecondLayer(false,false,false,false);
    return solveSecondLayerSolution;
  }
  
  // First calls the methods to solve Face 5, then returns a String with the solution.
  public String solveOppositeFaceSolution()
  {
    makeOppositeCross(false);
    finishOppositeFace(false);
    return solveOppositeFace;
  }
  
  // First calls the methods to finish the cube, then returns a String with the solution.
  public String solveFinishCubeSolution()
  {
    positionOppositeCorners(false);
    allignOppositeEdges(false);
    return finishCube;
  }
  
  // Calls all the methods and prints out the String with the solution in the interactions pane.
  public void solve()
  {
    System.out.println(crossSolution()+
                       allignCenterSolution()+
                       solveCornerSolution()+
                       solveSecondLayerSolution()+
                       solveOppositeFaceSolution()+
                       solveFinishCubeSolution());
  }
  
  // Makes the upper cross of the cube.
  public boolean makeUpperCross(boolean done)
  {
    // If the parameter is true, or if the upper cross is done, returns true.
    if(done == true)
      return true;
    if(cube[0][0][1] == centerColor0)
      return true;
    // Based on where a piece matching the center color of Face 0 is, makes a turn. Adds the step(s) to the crossSolution.
    if(cube[0][1][0] == centerColor0)
    {
      crossSolution += turnc(0);
    }
    else if(cube[0][2][1] == centerColor0)
    {
      crossSolution += turnc(0);
    }
    else if(cube[0][1][2] == centerColor0)
    {
      crossSolution += turncc(0);
    }
    else if(cube[2][0][1] == centerColor0)
    {
      crossSolution += turnc(1);
    }
    else if(cube[2][1][0] == centerColor0)
    {
      crossSolution += turnc(2);
    }
    else if(cube[2][2][1] == centerColor0)
    {
      crossSolution += turnc(2);
    }
    else if(cube[2][1][2] == centerColor0)
    {
      crossSolution += turncc(2);
    }
    else if(cube[5][0][1] == centerColor0)
    {
      crossSolution += turnc(1);
    }
    else if(cube[5][1][0] == centerColor0)
    {
      crossSolution += turnc(5);
    }
    else if(cube[5][2][1] == centerColor0)
    {
      crossSolution += turnc(5);
    }
    else if(cube[5][1][2] == centerColor0)
    {
      crossSolution += turncc(5);
    }
    else if(cube[4][0][1] == centerColor0)
    {
      crossSolution += turncc(1);
    }
    else if(cube[4][1][0] == centerColor0)
    {
      crossSolution += turnc(4);
    }
    else if(cube[4][2][1] == centerColor0)
    {
      crossSolution += turnc(4);
    }
    else if(cube[4][1][2] == centerColor0)
    {
      crossSolution += turncc(4);
    }
    else if(cube[1][0][1] == centerColor0)
    {
      crossSolution += turnc(5);
    }
    else if(cube[1][1][0] == centerColor0)
    {
      crossSolution += turnc(4);
    }
    else if(cube[1][2][1] == centerColor0)
    {
      crossSolution += turnc(0);
    }
    else if(cube[1][1][2] == centerColor0)
    {
      crossSolution += turncc(2);
    }
    else if(cube[3][0][1] == centerColor0)
    {
      crossSolution += turnc(0);
    }
    else if(cube[3][1][0] == centerColor0)
    {
      crossSolution += turncc(4);
    }
    else if(cube[3][2][1] == centerColor0)
    {
      crossSolution += turnc(5);
    }
    else if(cube[3][1][2] == centerColor0)
    {
      crossSolution += turnc(2);
    }
    // Makes a recursive call to the method.
    return makeUpperCross(false);
  }
  
  // Makes the right cross of the cube.
  public boolean makeRightCross(boolean done)
  {
    // If the parameter is true, or if the right cross is done, returns true.
    if(done == true)
      return true;
    if(cube[0][1][2] == centerColor0)
      return true;
    // Based on where a piece matching the center color of Face 0 is, makes a turn. Doesn't check impossible locations and doesn't check solved positions. Adds the step(s) to the crossSolution.
    if(cube[0][1][0] == centerColor0)
    {
      crossSolution += turnc(0);
    }
    else if(cube[0][2][1] == centerColor0)
    {
      crossSolution += turnc(1);
      crossSolution += turncc(0);
      crossSolution += turncc(1);
    }
    else if(cube[1][0][1] == centerColor0)
    {
      crossSolution += turnc(1);
      crossSolution += turncc(2);
      crossSolution += turncc(1);
    }
    else if(cube[1][1][0] == centerColor0)
    {
      crossSolution += turnc(4);
    }
    else if(cube[1][1][2] == centerColor0)
    {
      crossSolution += turncc(2);
    }
    else if(cube[5][0][1] == centerColor0)
    {
      crossSolution += turnc(5);
    }
    else if(cube[5][1][0] == centerColor0)
    {
      crossSolution += turnc(2);
    }
    else if(cube[5][1][2] == centerColor0)
    {
      crossSolution += turnc(4);
    }
    else if(cube[5][2][1] == centerColor0)
    {
      crossSolution += turnc(5);
    }
    else if(cube[3][0][1] == centerColor0)
    {
      crossSolution += turnc(3);
    }
    else if(cube[3][1][0] == centerColor0)
    {
      crossSolution += turnc(3);
    }
    else if(cube[3][1][2] == centerColor0)
    {
      crossSolution += turnc(2);
    }
    else if(cube[3][2][1] == centerColor0)
    {
      crossSolution += turnc(3);
    }
    else if(cube[4][1][0] == centerColor0)
    {
      crossSolution += turncc(5);
    }
    else if(cube[4][0][1] == centerColor0)
    {
      crossSolution += turnc(4);
    }
    else if(cube[4][1][2] == centerColor0)
    {
      crossSolution += turnc(4);
    }
    else if(cube[4][2][1] == centerColor0)
    {
      crossSolution += turnc(4);
    }
    else if(cube[2][0][1] == centerColor0)
    {
      crossSolution += turnc(2);
    }
    else if(cube[2][1][0] == centerColor0)
    {
      crossSolution += turnc(2);
    }
    else if(cube[2][2][1] == centerColor0)
    {
      crossSolution += turnc(2);
    }
    else if(cube[2][1][2] == centerColor0)
    {
      crossSolution += turnc(5);
    }
    // Makes a recursive call to the method.
    return makeRightCross(false);
  }
  
  // Makes the lower cross of the cube.
  public boolean makeLowerCross(boolean done)
  {
    // If the parameter is true, or if the lower cross is done, returns true.
    if(done == true)
      return true;
    if(cube[0][2][1] == centerColor0)
      return true;
    // Based on where a piece matching the center color of Face 0 is, makes a turn. Doesn't check impossible locations and doesn't check solved positions. Adds the step(s) to the crossSolution.
    if(cube[0][1][0] == centerColor0)
    {
      crossSolution += turnc(0);
    }
    else if(cube[5][2][1] == centerColor0)
    {
      crossSolution += turnc(3);
    }
    else if(cube[5][0][1] == centerColor0)
    {
      crossSolution += turnc(5);
    }
    else if(cube[5][1][0] == centerColor0)
    {
      crossSolution += turncc(5);
    }
    else if(cube[5][1][2] == centerColor0)
    {
      crossSolution += turnc(5);
    }
    else if(cube[3][1][0] == centerColor0)
    {
      crossSolution += turncc(4);
      crossSolution += turnc(0);
    }
    else if(cube[3][0][1] == centerColor0)
    {
      crossSolution += turnc(3);
    }
    else if(cube[3][1][2] == centerColor0)
    {
      crossSolution += turnc(3);
    }
    else if(cube[3][2][1] == centerColor0)
    {
      crossSolution += turnc(3);
    }
    else if(cube[4][2][1] == centerColor0)
    {
      crossSolution += turnc(3);
    }
    else if(cube[4][1][0] == centerColor0)
    {
      crossSolution += turnc(4);
    }
    else if(cube[4][0][1] == centerColor0)
    {
      crossSolution += turnc(4);
    }
    else if(cube[4][1][2] == centerColor0)
    {
      crossSolution += turnc(4);
    }
    else if(cube[2][0][1] == centerColor0)
    {
      crossSolution += turnc(2);
      crossSolution += turnc(5);
      crossSolution += turncc(2);
    }
    else if(cube[2][2][1] == centerColor0)
    {
      crossSolution += turncc(3);
    }
    else if(cube[2][1][2] == centerColor0)
    {
      crossSolution += turnc(5);
    }
    else if(cube[1][0][1] == centerColor0)
    {
      crossSolution += turnc(5);
    }
    else if(cube[1][1][0] == centerColor0)
    {
      crossSolution += turnc(4);
    }
    else if(cube[1][1][2] == centerColor0)
    {
      crossSolution += turnc(1);
      crossSolution += turnc(1);
      crossSolution += turnc(4);
      crossSolution += turnc(1);
      crossSolution += turnc(1);
    }
    // Makes a recursive call to the method.
    return makeLowerCross(false);
  }
  
  // Makes the left cross of the cube.
  public boolean makeLeftCross(boolean done)
  {
    // If the parameter is true, or if the left cross is done, returns true.
    if(done == true)
      return true;
    if(cube[0][1][0] == centerColor0)
      return true;
    // Based on where a piece matching the center color of Face 0 is, makes a turn. Doesn't check impossible locations and doesn't check solved positions. Adds the step(s) to the crossSolution.
    if(cube[1][0][1] == centerColor0)
    {
      crossSolution += turncc(1);
      crossSolution += turnc(4);
      crossSolution += turnc(1);
    }
    else if(cube[1][1][2] == centerColor0)
    {
      crossSolution += turnc(1);
      crossSolution += turnc(1);
      crossSolution += turnc(4);
      crossSolution += turnc(1);
      crossSolution += turnc(1);
    }
    else if(cube[1][1][0] == centerColor0)
    {
      crossSolution += turnc(4);
    }
    else if(cube[5][1][2] == centerColor0)
    {
      crossSolution += turnc(4);
    }
    else if(cube[2][0][1] == centerColor0)
    {
      crossSolution += turnc(2);
      crossSolution += turnc(5);
      crossSolution += turncc(2);
    }
    else if(cube[2][2][1] == centerColor0)
    {
      crossSolution += turncc(2);
      crossSolution += turnc(5);
      crossSolution += turnc(2);
    }
    else if(cube[2][1][2] == centerColor0)
    {
      crossSolution += turnc(5);
    }
    else if(cube[5][0][1] == centerColor0)
    {
      crossSolution += turnc(5);
    }
    else if(cube[5][1][0] == centerColor0)
    {
      crossSolution += turnc(5);
    }
    else if(cube[5][2][1] == centerColor0)
    {
      crossSolution += turncc(5);
    }
    else if(cube[3][1][0] == centerColor0)
    {
      crossSolution += turncc(4);
    }
    else if(cube[3][1][2] == centerColor0)
    {
      crossSolution += turnc(3);
      crossSolution += turnc(3);
      crossSolution += turncc(4);
      crossSolution += turnc(3);
      crossSolution += turnc(3);
    }
    else if(cube[3][2][1] == centerColor0)
    {
      crossSolution += turnc(3);
      crossSolution += turncc(4);
      crossSolution += turncc(3);
    }
    else if(cube[4][1][0] == centerColor0)
    {
      crossSolution += turncc(5);
    }
    else if(cube[4][2][1] == centerColor0)
    {
      crossSolution += turnc(4);
    }
    else if(cube[4][0][1] == centerColor0)
    {
      crossSolution += turncc(4);
    }
    else if(cube[4][1][2] == centerColor0)
    {
      crossSolution += turnc(4);
    }
    // Makes a recursive call to the method.
    return makeLeftCross(false);
  }
  
  // Alligns Face 0 so the center of Face 1 is alligned with the right color edge piece.
  public boolean allignCenter1()
  {
    // Returns true when the colors match up.
    if(cube[1][2][1] == centerColor1)
      return true;
    // Turns Face 0 and adds onto allignCenterSollution.
    allignCenterSolution += turnc(0);
    // Recursive call.
    return allignCenter1();
  }
  
  // Alligns the rest of the centers and adds onto allignCenterSolution.
  public void allignCenter234()
  {
    // If any of the edge pieces aren't lined (Face 1 is done in the previous method), they are moved to Face 5.
    if(cube[2][1][0] != centerColor2)
    {
      allignCenterSolution += turnc(2);
      allignCenterSolution += turnc(2);
    }
    if(cube[3][0][1] != centerColor3)
    {
      allignCenterSolution += turnc(3);
      allignCenterSolution += turnc(3);
    }
    if(cube[4][1][2] != centerColor4)
    {
      allignCenterSolution += turnc(4);
      allignCenterSolution += turnc(4);
    }
    // If the have been moved to Face 5, they are properly alligned.
    if(((cube[0][1][2] == centerColor0) && (cube[2][1][0] == centerColor2)) == false)
    {
      while(((cube[5][1][0] == centerColor0) && (cube[2][1][2] == centerColor2)) == false)
      {
        allignCenterSolution += turnc(5);
      }
      allignCenterSolution += turnc(2);
      allignCenterSolution += turnc(2);
    }
    if(((cube[0][2][1] == centerColor0) && (cube[3][0][1] == centerColor3)) == false)
    {
      while(((cube[5][2][1] == centerColor0) && (cube[3][2][1] == centerColor3)) == false)
      {
        allignCenterSolution += turnc(5);
      }
      allignCenterSolution += turnc(3);
      allignCenterSolution += turnc(3);
    }
    if(((cube[0][1][0] == centerColor0) && (cube[4][1][2] == centerColor4)) == false)
    {
      while(((cube[5][1][2] == centerColor0) && (cube[4][1][0] == centerColor4)) == false)
      {
        allignCenterSolution += turnc(5);
      }
      allignCenterSolution += turnc(4);
      allignCenterSolution += turnc(4);
    }
  }
  
  // Solves the corners and adds onto solveCornerSolution
  public boolean solveCorners(boolean done1, boolean done2, boolean done3, boolean done4)
  {
    // If all parameters are true or corners are solved, then returns true.
    if((done1==true) && (done2==true) && (done3==true) && (done4==true))
      return true;
    
    if((cube[0][0][0] == centerColor0) && (cube[0][0][2] == centerColor0) && (cube[0][2][0] == centerColor0) && (cube[0][2][2] == centerColor0) &&
       (cube[1][2][0] == centerColor1) && (cube[1][2][2] == centerColor1) &&
       (cube[2][0][0] == centerColor2) && (cube[2][2][0] == centerColor2) &&
       (cube[3][0][0] == centerColor3) && (cube[3][0][2] == centerColor3) &&
       (cube[4][0][2] == centerColor4) && (cube[4][2][2] == centerColor4))
      return true;
    
    // Checks first corner.
    if(done1 == false)
    {
      // If done, calls the method with the first boolean true.
      if((cube[0][0][0] == centerColor0) && (cube[1][2][0] == centerColor1) && (cube[4][0][2] == centerColor4))
        return solveCorners(true, false, false, false);
      // Else checks to see if the needed corner piece is stuck somwhere. Dislodges it if needed.
      else if (((cube[0][0][0] == centerColor1) || (cube[0][0][0] == centerColor4)) &&
               ((cube[1][2][0] == centerColor0) || (cube[1][2][0] == centerColor4)) &&
               ((cube[4][0][2] == centerColor0) || (cube[4][0][2] == centerColor1)))
      {
        solveCornerSolution += turncc(4);
        solveCornerSolution += turncc(5);
        solveCornerSolution += turnc(4);
        solveCornerSolution += turnc(5);
      }
      else if (((cube[0][0][2] == centerColor0) || (cube[0][0][2] == centerColor1) || (cube[0][0][2] == centerColor4)) &&
               ((cube[1][2][2] == centerColor0) || (cube[1][2][2] == centerColor1) || (cube[1][2][2] == centerColor4)) &&
               ((cube[2][0][0] == centerColor0) || (cube[2][0][0] == centerColor1) || (cube[2][0][0] == centerColor4)))
      {
        solveCornerSolution += turncc(1);
        solveCornerSolution += turncc(5);
        solveCornerSolution += turnc(1);
        solveCornerSolution += turnc(5);
      }
      else if (((cube[0][2][0] == centerColor0) || (cube[0][2][0] == centerColor1) || (cube[0][2][0] == centerColor4)) &&
               ((cube[4][2][2] == centerColor0) || (cube[4][2][2] == centerColor1) || (cube[4][2][2] == centerColor4)) &&
               ((cube[3][0][0] == centerColor0) || (cube[3][0][0] == centerColor1) || (cube[3][0][0] == centerColor4)))
      {
        solveCornerSolution += turncc(3);
        solveCornerSolution += turncc(5);
        solveCornerSolution += turnc(3);
        solveCornerSolution += turnc(5);
      }
      else if (((cube[0][2][2] == centerColor0) || (cube[0][2][2] == centerColor1) || (cube[0][2][2] == centerColor4)) &&
               ((cube[3][0][2] == centerColor0) || (cube[3][0][2] == centerColor1) || (cube[3][0][2] == centerColor4)) &&
               ((cube[2][2][0] == centerColor0) || (cube[2][2][0] == centerColor1) || (cube[2][2][0] == centerColor4)))
      {
        solveCornerSolution += turncc(2);
        solveCornerSolution += turncc(5);
        solveCornerSolution += turnc(2);
        solveCornerSolution += turnc(5);
      }
      // After checking to see if it's stuck, it is moved to the correct position.
      while((((cube[1][0][0] == centerColor0) || (cube[1][0][0] == centerColor1) || (cube[1][0][0] == centerColor4)) &&
             ((cube[5][0][2] == centerColor0) || (cube[5][0][2] == centerColor1) || (cube[5][0][2] == centerColor4)) &&
             ((cube[4][0][0] == centerColor0) || (cube[4][0][0] == centerColor1) || (cube[4][0][0] == centerColor4))) == false)
      {
        solveCornerSolution += turnc(5);
      }
      // Repeats an algorithm to get it into the right position.
      while(((cube[0][0][0] == centerColor0) && (cube[1][2][0] == centerColor1) && (cube[4][0][2] == centerColor4)) == false)
      {
        solveCornerSolution += turncc(4);
        solveCornerSolution += turncc(5);
        solveCornerSolution += turnc(4);
        solveCornerSolution += turnc(5);
      }
      // Calls the method with the first boolean true.
      return solveCorners(true, false, false, false);
    }
    
    // Checks second corner.
    else if(done2 == false)
    {
      // If done, calls the method with the first two boolean true.
      if((cube[0][0][2] == centerColor0) && (cube[1][2][2] == centerColor1) && (cube[2][0][0] == centerColor2))
        return solveCorners(true, true, false, false);
      // Else checks to see if the needed corner piece is stuck somwhere. Dislodges it if needed.
      else if (((cube[0][0][2] == centerColor1) || (cube[0][0][2] == centerColor2)) &&
               ((cube[1][2][2] == centerColor0) || (cube[1][2][2] == centerColor2)) &&
               ((cube[2][0][0] == centerColor0) || (cube[2][0][0] == centerColor1)))
      {
        solveCornerSolution += turncc(1);
        solveCornerSolution += turncc(5);
        solveCornerSolution += turnc(1);
        solveCornerSolution += turnc(5);
      }
      else if (((cube[0][2][0] == centerColor0) || (cube[0][2][0] == centerColor1) || (cube[0][2][0] == centerColor2)) &&
               ((cube[4][2][2] == centerColor0) || (cube[4][2][2] == centerColor1) || (cube[4][2][2] == centerColor2)) &&
               ((cube[3][0][0] == centerColor0) || (cube[3][0][0] == centerColor1) || (cube[3][0][0] == centerColor2)))
      {
        solveCornerSolution += turncc(3);
        solveCornerSolution += turncc(5);
        solveCornerSolution += turnc(3);
        solveCornerSolution += turnc(5);
      }
      else if (((cube[0][2][2] == centerColor0) || (cube[0][2][2] == centerColor1) || (cube[0][2][2] == centerColor2)) &&
               ((cube[3][0][2] == centerColor0) || (cube[3][0][2] == centerColor1) || (cube[3][0][2] == centerColor2)) &&
               ((cube[2][2][0] == centerColor0) || (cube[2][2][0] == centerColor1) || (cube[2][2][0] == centerColor2)))
      {
        solveCornerSolution += turncc(2);
        solveCornerSolution += turncc(5);
        solveCornerSolution += turnc(2);
        solveCornerSolution += turnc(5);
      }
      // After checking to see if it's stuck, it is moved to the correct position.
      while((((cube[1][0][2] == centerColor0) || (cube[1][0][2] == centerColor1) || (cube[1][0][2] == centerColor2)) &&
             ((cube[5][0][0] == centerColor0) || (cube[5][0][0] == centerColor1) || (cube[5][0][0] == centerColor2)) &&
             ((cube[2][0][2] == centerColor0) || (cube[2][0][2] == centerColor1) || (cube[2][0][2] == centerColor2))) == false)
      {
        solveCornerSolution += turnc(5);
      }
      // Repeats an algorithm to get it into the right position.
      while(((cube[0][0][2] == centerColor0) && (cube[1][2][2] == centerColor1) && (cube[2][0][0] == centerColor2)) == false)
      {
        solveCornerSolution += turncc(1);
        solveCornerSolution += turncc(5);
        solveCornerSolution += turnc(1);
        solveCornerSolution += turnc(5);
      }
      // Calls the method with the first two boolean true
      return solveCorners(true, true, false, false);
    }
    
    // Checks third corner.
    else if(done3 == false)
    {
      // If done, calls the method with the first three booleans true.
      if((cube[0][2][0] == centerColor0) && (cube[4][2][2] == centerColor4) && (cube[3][0][0] == centerColor3))
        return solveCorners(true, true, true, false);
      // Else checks to see if the needed corner piece is stuck somwhere. Dislodges it if needed.
      else if (((cube[0][2][0] == centerColor3) || (cube[0][2][0] == centerColor4)) &&
               ((cube[3][0][0] == centerColor0) || (cube[3][0][0] == centerColor4)) &&
               ((cube[4][2][2] == centerColor0) || (cube[4][2][2] == centerColor3)))
      {
        solveCornerSolution += turncc(3);
        solveCornerSolution += turncc(5);
        solveCornerSolution += turnc(3);
        solveCornerSolution += turnc(5);
      }
      else if (((cube[0][2][2] == centerColor0) || (cube[0][2][2] == centerColor3) || (cube[0][2][2] == centerColor4)) &&
               ((cube[3][0][2] == centerColor0) || (cube[3][0][2] == centerColor3) || (cube[3][0][2] == centerColor4)) &&
               ((cube[2][2][0] == centerColor0) || (cube[2][2][0] == centerColor3) || (cube[2][2][0] == centerColor4)))
      {
        solveCornerSolution += turncc(2);
        solveCornerSolution += turncc(5);
        solveCornerSolution += turnc(2);
        solveCornerSolution += turnc(5);
      }
      // After checking to see if it's stuck, it is moved to the correct position.
      while((((cube[3][2][0] == centerColor0) || (cube[3][2][0] == centerColor3) || (cube[3][2][0] == centerColor4)) &&
             ((cube[5][2][2] == centerColor0) || (cube[5][2][2] == centerColor3) || (cube[5][2][2] == centerColor4)) &&
             ((cube[4][2][0] == centerColor0) || (cube[4][2][0] == centerColor3) || (cube[4][2][0] == centerColor4))) == false)
      {
        solveCornerSolution += turnc(5);
      }
      // Repeats an algorithm to get it into the right position.
      while(((cube[0][2][0] == centerColor0) && (cube[4][2][2] == centerColor4) && (cube[3][0][0] == centerColor3)) == false)
      {
        solveCornerSolution += turncc(3);
        solveCornerSolution += turncc(5);
        solveCornerSolution += turnc(3);
        solveCornerSolution += turnc(5);
      }
      // Calls the method with the first three booleans true.
      return solveCorners(true, true, true, false);
    }
    
    // Checks fourth corner.
    else if(done4 == false)
    {
      // If done, calls the method with all boolean true.
      if((cube[0][2][2] == centerColor0) && (cube[2][2][0] == centerColor2) && (cube[3][0][2] == centerColor3))
        return solveCorners(true, true, true, true);
      // Else checks to see if the needed corner piece is stuck somwhere. Dislodges it if needed.
      else if (((cube[0][2][2] == centerColor2) || (cube[0][2][2] == centerColor3)) &&
               ((cube[2][2][0] == centerColor0) || (cube[2][2][0] == centerColor3)) &&
               ((cube[3][0][2] == centerColor0) || (cube[3][0][2] == centerColor2)))
      {
        solveCornerSolution += turncc(2);
        solveCornerSolution += turncc(5);
        solveCornerSolution += turnc(2);
        solveCornerSolution += turnc(5);
      }
      // After checking to see if it's stuck, it is moved to the correct position.
      while((((cube[2][2][2] == centerColor0) || (cube[2][2][2] == centerColor2) || (cube[2][2][2] == centerColor3)) &&
             ((cube[5][2][0] == centerColor0) || (cube[5][2][0] == centerColor2) || (cube[5][2][0] == centerColor3)) &&
             ((cube[3][2][2] == centerColor0) || (cube[3][2][2] == centerColor2) || (cube[3][2][2] == centerColor3))) == false)
      {
        solveCornerSolution += turnc(5);
      }
      // Repeats an algorithm to get it into the right position.
      while(((cube[0][2][2] == centerColor0) && (cube[2][2][0] == centerColor2) && (cube[3][0][2] == centerColor3)) == false)
      {
        solveCornerSolution += turncc(2);
        solveCornerSolution += turncc(5);
        solveCornerSolution += turnc(2);
        solveCornerSolution += turnc(5);
      }
      // Calls the method with all boolean true
      return solveCorners(true, true, true, true);
    }
    // Returns false, but this is never reached if the cube is valid.
    return false;
  }
  
  // Solves the second layer of Faces 1-4 and adds onto String solveSecondLayer.
  public boolean solveSecondLayer(boolean done1, boolean done2, boolean done3, boolean done4)
  {
    // If all the parameters are true or if the second layer is solved 
    if((done1==true) && (done2==true) && (done3==true) && (done4==true))
      return true;
    if((cube[1][1][0] == centerColor1) && (cube[1][1][2] == centerColor1) && 
       (cube[2][0][1] == centerColor2) && (cube[2][2][1] == centerColor2) &&
       (cube[3][1][2] == centerColor3) && (cube[3][1][0] == centerColor3) &&
       (cube[4][2][1] == centerColor4) && (cube[4][0][1] == centerColor4))
      return true;
    
    // Checks to see if Face 1 is done
    if(done1 == false)
    {
      // If it is done, recursively calls this method with the first boolean true.
      if((cube[1][1][0] == centerColor1) && (cube[4][0][1] == centerColor4))
        return solveSecondLayer(true,false,false,false);
      // Else checks to see if desired edge piece is stuck. Dislodges it if needed.
      else if((cube[1][1][0] == centerColor4) && (cube[4][0][1] == centerColor1))
      {
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(4);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(4);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(1);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(1);
      }
      else if(((cube[1][1][2] == centerColor1) || (cube[1][1][2] == centerColor4)) &&
              ((cube[2][0][1] == centerColor1) || (cube[2][0][1] == centerColor4)))
      {
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(2);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(2);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(1);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(1);
      }
      else if(((cube[3][1][2] == centerColor1) || (cube[3][1][2] == centerColor4)) &&
              ((cube[2][2][1] == centerColor1) || (cube[2][2][1] == centerColor4)))
      {
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(2);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(2);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(3);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(3);
      }
      else if(((cube[3][1][0] == centerColor1) || (cube[3][1][0] == centerColor4)) &&
              ((cube[4][2][1] == centerColor1) || (cube[4][2][1] == centerColor4)))
      {
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(4);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(4);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(3);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(3);
      }
      // Positions the edge piece.
      while((((cube[1][0][1] == centerColor1) || (cube[1][0][1] == centerColor4)) &&
             ((cube[5][0][1] == centerColor1) || (cube[5][0][1] == centerColor4))) == false)
      {
        solveSecondLayerSolution += turnc(5);
      }
      // Does one of two algorithms to get the edge piece to the right place.
      if(cube[1][0][1] == centerColor1)
      {
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(4);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(4);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(1);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(1);
      }
      else
      {
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(1);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(1);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(4);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(4);
      }
      // Recursively calls this method with the first boolean true.
      return solveSecondLayer(true,false,false,false);
    }
    
    // Checks to see if Face 2 is done
    else if(done2 == false)
    {
      // If it is done, recursively calls this method with the first two booleans true.
      if((cube[1][1][2] == centerColor1) && (cube[2][0][1] == centerColor2))
        return solveSecondLayer(true,true,false,false);
      // Else checks to see if desired edge piece is stuck. Dislodges it if needed.
      else if((cube[1][1][2] == centerColor2) && (cube[2][0][1] == centerColor1))
      {
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(2);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(2);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(1);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(1);
      }
      else if(((cube[3][1][2] == centerColor1) || (cube[3][1][2] == centerColor2)) &&
              ((cube[2][2][1] == centerColor1) || (cube[2][2][1] == centerColor2)))
      {
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(2);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(2);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(3);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(3);
      }
      else if(((cube[3][1][0] == centerColor1) || (cube[3][1][0] == centerColor2)) &&
              ((cube[4][2][1] == centerColor1) || (cube[4][2][1] == centerColor2)))
      {
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(4);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(4);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(3);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(3);
      }
      // Positions the edge piece.
      while((((cube[1][0][1] == centerColor1) || (cube[1][0][1] == centerColor2)) &&
             ((cube[5][0][1] == centerColor1) || (cube[5][0][1] == centerColor2))) == false)
      {
        solveSecondLayerSolution += turnc(5);
      }
      // Does one of two algorithms to get the edge piece to the right place.
      if(cube[1][0][1] == centerColor1)
      {
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(2);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(2);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(1);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(1);
      }
      else
      {
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turncc(1);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(1);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(2);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(2);
      }
      // Recursively calls this method with the first two booleans true.
      return solveSecondLayer(true,true,false,false);
    }
    
    // Checks to see if Face 3 is done
    else if(done3 == false)
    {
      // If it is done, recursively calls this method with the first three boolean true.
      if((cube[2][2][1] == centerColor2) && (cube[3][1][2] == centerColor3))
        return solveSecondLayer(true,true,true,false);
      // Else checks to see if desired edge piece is stuck. Dislodges it if needed.
      else if((cube[3][1][2] == centerColor2) && (cube[2][2][1] == centerColor3))
      {
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(2);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(2);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(3);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(3);
      }
      else if(((cube[3][1][0] == centerColor3) || (cube[3][1][0] == centerColor2)) &&
              ((cube[4][2][1] == centerColor3) || (cube[4][2][1] == centerColor2)))
      {
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(4);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(4);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(3);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(3);
      }
      // Positions the edge piece.
      while((((cube[3][2][1] == centerColor3) || (cube[3][2][1] == centerColor2)) &&
             ((cube[5][2][1] == centerColor3) || (cube[5][2][1] == centerColor2))) == false)
      {
        solveSecondLayerSolution += turnc(5);
      }
      // Does one of two algorithms to get the edge piece to the right place.
      if(cube[3][2][1] == centerColor3)
      {
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(2);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(2);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(3);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(3);
      }
      else
      {
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(3);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(3);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(2);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(2);
      }
      // Recursively calls this method with the first three boolean true.
      return solveSecondLayer(true,true,true,false);
    }
    
    // Checks to see if Face 4 is done
    else if(done4 == false)
    {
      // If it is done, recursively calls this method with all the booleans true.
      if((cube[4][2][1] == centerColor4) && (cube[3][1][0] == centerColor3))
        return solveSecondLayer(true,true,true,true);
      // Else checks to see if desired edge piece is stuck. Dislodges it if needed.
      else if((cube[3][1][0] == centerColor4) && (cube[4][2][1] == centerColor3))
      {
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(4);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(4);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(3);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(3);
      }
      // Positions the edge piece.
      while((((cube[3][2][1] == centerColor3) || (cube[3][2][1] == centerColor4)) &&
             ((cube[5][2][1] == centerColor3) || (cube[5][2][1] == centerColor4))) == false)
      {
        solveSecondLayerSolution += turnc(5);
      }
      // Does one of two algorithms to get the edge piece to the right place.
      if(cube[3][2][1] == centerColor3)
      {
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(4);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(4);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(3);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(3);
      }
      else
      {
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turncc(3);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(3);
        solveSecondLayerSolution += turnc(5);
        solveSecondLayerSolution += turnc(4);
        solveSecondLayerSolution += turncc(5);
        solveSecondLayerSolution += turncc(4);
      }
      // Recursively calls this method with all the booleans true
      return solveSecondLayer(true,true,true,true);
    }
    // Returns false, but this is never reached if the cube is valid.
    return false;
  }
  
  // Makes the cross on Face 5 and adds onto String solveOppositeFace
  public boolean makeOppositeCross(boolean done)
  {
    // If the parameter is true or if the cross is made, returns true.
    if(done == true)
      return true; 
    if((cube[5][1][0] == centerColor5) && (cube[5][1][1] == centerColor5) && (cube[5][1][2] == centerColor5) && (cube[5][0][1] == centerColor5) && (cube[5][2][1] == centerColor5))
      return true;
    
    // Else checks the oppsite side and executes appropriate algorithm to approach the cross.
    else if((cube[5][1][0] == centerColor5) && (cube[5][1][1] == centerColor5) && (cube[5][1][2] == centerColor5))
    {
      solveOppositeFace += turnc(1);
      solveOppositeFace += turnc(2);
      solveOppositeFace += turnc(5);
      solveOppositeFace += turncc(2);
      solveOppositeFace += turncc(5);
      solveOppositeFace += turncc(1);
    }
    
    else if((cube[5][0][1] == centerColor5) && (cube[5][1][1] == centerColor5) && (cube[5][2][1] == centerColor5))
    {
      solveOppositeFace += turnc(2);
      solveOppositeFace += turnc(3);
      solveOppositeFace += turnc(5);
      solveOppositeFace += turncc(3);
      solveOppositeFace += turncc(5);
      solveOppositeFace += turncc(2);
    }
    
    else if((cube[5][2][1] == centerColor5) && (cube[5][1][1] == centerColor5) && (cube[5][1][2] == centerColor5))
    {
      solveOppositeFace += turnc(1);
      solveOppositeFace += turnc(5);
      solveOppositeFace += turnc(2);
      solveOppositeFace += turncc(5);
      solveOppositeFace += turncc(2);
      solveOppositeFace += turncc(1);
    }
    
    else if((cube[5][2][1] == centerColor5) && (cube[5][1][1] == centerColor5) && (cube[5][1][0] == centerColor5))
    {
      solveOppositeFace += turnc(4);
      solveOppositeFace += turnc(5);
      solveOppositeFace += turnc(1);
      solveOppositeFace += turncc(5);
      solveOppositeFace += turncc(1);
      solveOppositeFace += turncc(4);
    }
    
    else if((cube[5][1][0] == centerColor5) && (cube[5][1][1] == centerColor5) && (cube[5][0][1] == centerColor5))
    {
      solveOppositeFace += turnc(3);
      solveOppositeFace += turnc(5);
      solveOppositeFace += turnc(4);
      solveOppositeFace += turncc(5);
      solveOppositeFace += turncc(4);
      solveOppositeFace += turncc(3);
    }
    
    else if((cube[5][1][2] == centerColor5) && (cube[5][1][1] == centerColor5) && (cube[5][0][1] == centerColor5))
    {
      solveOppositeFace += turnc(2);
      solveOppositeFace += turnc(5);
      solveOppositeFace += turnc(3);
      solveOppositeFace += turncc(5);
      solveOppositeFace += turncc(3);
      solveOppositeFace += turncc(2);
    }
    
    else
    {
      solveOppositeFace += turnc(1);
      solveOppositeFace += turnc(5);
      solveOppositeFace += turnc(2);
      solveOppositeFace += turncc(5);
      solveOppositeFace += turncc(2);
      solveOppositeFace += turncc(1);
    }
    
    // Recursive call so that the algorithm may be repeated if necessary.
    return makeOppositeCross(false);
  }
  
  // Finishes Face 5 and adds onto String solveOppositeFace.
  public boolean finishOppositeFace(boolean done)
  {
    // If parameter is true or if Face 5 is compelte, returns true.
    if(done == true)
      return true;
    if((cube[5][0][0] == centerColor5) && (cube[5][0][2] == centerColor5) &&
       (cube[5][2][0] == centerColor5) && (cube[5][2][2] == centerColor5))
      return true;
    
    // int counter is declared and initialized to 0.
    int counter = 0;
    
    // Checks to see how many corners are in position.
    if(cube[5][0][0] == centerColor5)
      counter++;
    if(cube[5][0][2] == centerColor5)
      counter++;
    if(cube[5][2][0] == centerColor5)
      counter++;
    if(cube[5][2][2] == centerColor5)
      counter++;
    
    // Based on the number of corners in position, Face 5 is turned until the condition is met.
    if(counter==0)
    {
      while(cube[4][0][0] != centerColor5)
      {
        solveOppositeFace += turnc(5);
      }
    }
    
    if(counter==1)
    {
      while(cube[5][0][2] != centerColor5)
      {
        solveOppositeFace += turnc(5);
      }
    }
    
    if(counter>=2)
    {
      while(cube[1][0][0] != centerColor5)
      {
        solveOppositeFace += turnc(5);
      }
    }
    
    // Executes the algorithm for this step.
    solveOppositeFace += turnc(2);
    solveOppositeFace += turnc(5);
    solveOppositeFace += turncc(2);
    solveOppositeFace += turnc(5);
    solveOppositeFace += turnc(2);
    solveOppositeFace += turnc(5);
    solveOppositeFace += turnc(5);
    solveOppositeFace += turncc(2);
    
    // Recursive call with false as a parameter so the step can be done until Face 5 is solved.
    return finishOppositeFace(false);
  }
  
  // Positions the corner pieces of Face 5 and adds onto String finishCube.
  public boolean positionOppositeCorners(boolean done)
  {
    // If paramter is true returns true. 
    if(done == true)
      return true;
    
    // Turns Face 5 until atleast two corners are in position (1 of 6 conditions)
    while(((((cube[5][0][2] == centerColor5) && (cube[1][0][0] == centerColor1) && (cube[4][0][0] == centerColor4)) &&
            ((cube[5][0][0] == centerColor5) && (cube[1][0][2] == centerColor1) && (cube[2][0][2] == centerColor2))) ||
           (((cube[5][0][0] == centerColor5) && (cube[1][0][2] == centerColor1) && (cube[2][0][2] == centerColor2)) &&
            ((cube[5][2][0] == centerColor5) && (cube[3][2][2] == centerColor3) && (cube[2][2][2] == centerColor2))) ||
           (((cube[5][2][2] == centerColor5) && (cube[3][2][0] == centerColor3) && (cube[4][2][0] == centerColor4)) &&
            ((cube[5][2][0] == centerColor5) && (cube[3][2][2] == centerColor3) && (cube[2][2][2] == centerColor2))) ||
           (((cube[5][2][2] == centerColor5) && (cube[3][2][0] == centerColor3) && (cube[4][2][0] == centerColor4)) &&
            ((cube[5][0][2] == centerColor5) && (cube[1][0][0] == centerColor1) && (cube[4][0][0] == centerColor4))) ||
           (((cube[5][2][0] == centerColor5) && (cube[3][2][2] == centerColor3) && (cube[2][2][2] == centerColor2)) &&
            ((cube[5][0][2] == centerColor5) && (cube[1][0][0] == centerColor1) && (cube[4][0][0] == centerColor4))) ||
           (((cube[5][2][2] == centerColor5) && (cube[3][2][0] == centerColor3) && (cube[4][2][0] == centerColor4)) &&
            ((cube[5][0][0] == centerColor5) && (cube[1][0][2] == centerColor1) && (cube[2][0][2] == centerColor2)))) == false)
    {
      finishCube += turnc(5);
    }
    
    // If the corners are in position, returns true.
    if(((cube[5][0][2] == centerColor5) && (cube[1][0][0] == centerColor1) && (cube[4][0][0] == centerColor4)) &&
       ((cube[5][0][0] == centerColor5) && (cube[1][0][2] == centerColor1) && (cube[2][0][2] == centerColor2)) &&
       ((cube[5][2][2] == centerColor5) && (cube[3][2][0] == centerColor3) && (cube[4][2][0] == centerColor4)) &&
       ((cube[5][2][0] == centerColor5) && (cube[3][2][2] == centerColor3) && (cube[2][2][2] == centerColor2)))
      return true;
    
    // Otherwise executes an algorithm based on which corners are in the right position to switch the other corners into the right position.
    if(((cube[5][0][2] == centerColor5) && (cube[1][0][0] == centerColor1) && (cube[4][0][0] == centerColor4)) &&
       ((cube[5][0][0] == centerColor5) && (cube[1][0][2] == centerColor1) && (cube[2][0][2] == centerColor2)))
    {
      finishCube += turncc(4);
      finishCube += turnc(3);
      finishCube += turncc(4);
      finishCube += turnc(1);
      finishCube += turnc(1);
      finishCube += turnc(4);
      finishCube += turncc(3);
      finishCube += turncc(4);
      finishCube += turnc(1);
      finishCube += turnc(1);
      finishCube += turnc(4);
      finishCube += turnc(4);
      finishCube += turncc(5);
    }
    else if(((cube[5][0][0] == centerColor5) && (cube[1][0][2] == centerColor1) && (cube[2][0][2] == centerColor2)) &&
            ((cube[5][2][0] == centerColor5) && (cube[3][2][2] == centerColor3) && (cube[2][2][2] == centerColor2)))
    {
      finishCube += turncc(1);
      finishCube += turnc(4);
      finishCube += turncc(1);
      finishCube += turnc(2);
      finishCube += turnc(2);
      finishCube += turnc(1);
      finishCube += turncc(4);
      finishCube += turncc(1);
      finishCube += turnc(2);
      finishCube += turnc(2);
      finishCube += turnc(1);
      finishCube += turnc(1);
      finishCube += turncc(5);
    }
    else if(((cube[5][2][2] == centerColor5) && (cube[3][2][0] == centerColor3) && (cube[4][2][0] == centerColor4)) &&
            ((cube[5][2][0] == centerColor5) && (cube[3][2][2] == centerColor3) && (cube[2][2][2] == centerColor2)))
    {
      finishCube += turncc(2);
      finishCube += turnc(1);
      finishCube += turncc(2);
      finishCube += turnc(3);
      finishCube += turnc(3);
      finishCube += turnc(2);
      finishCube += turncc(1);
      finishCube += turncc(2);
      finishCube += turnc(3);
      finishCube += turnc(3);
      finishCube += turnc(2);
      finishCube += turnc(2);
      finishCube += turncc(5);
    }
    else if(((cube[5][2][2] == centerColor5) && (cube[3][2][0] == centerColor3) && (cube[4][2][0] == centerColor4)) &&
            ((cube[5][0][2] == centerColor5) && (cube[1][0][0] == centerColor1) && (cube[4][0][0] == centerColor4)))
    {
      finishCube += turncc(3);
      finishCube += turnc(2);
      finishCube += turncc(3);
      finishCube += turnc(4);
      finishCube += turnc(4);
      finishCube += turnc(3);
      finishCube += turncc(2);
      finishCube += turncc(3);
      finishCube += turnc(4);
      finishCube += turnc(4);
      finishCube += turnc(3);
      finishCube += turnc(3);
      finishCube += turncc(5);
    }
    else if(((cube[5][2][0] == centerColor5) && (cube[3][2][2] == centerColor3) && (cube[2][2][2] == centerColor2)) &&
            ((cube[5][0][2] == centerColor5) && (cube[1][0][0] == centerColor1) && (cube[4][0][0] == centerColor4)))
    {
      finishCube += turncc(2);
      finishCube += turnc(1);
      finishCube += turncc(2);
      finishCube += turnc(3);
      finishCube += turnc(3);
      finishCube += turnc(2);
      finishCube += turncc(1);
      finishCube += turncc(2);
      finishCube += turnc(3);
      finishCube += turnc(3);
      finishCube += turnc(2);
      finishCube += turnc(2);
      finishCube += turncc(5);
    }
    else if(((cube[5][2][2] == centerColor5) && (cube[3][2][0] == centerColor3) && (cube[4][2][0] == centerColor4)) &&
            ((cube[5][0][0] == centerColor5) && (cube[1][0][2] == centerColor1) && (cube[2][0][2] == centerColor2)))
    {
      finishCube += turncc(2);
      finishCube += turnc(1);
      finishCube += turncc(2);
      finishCube += turnc(3);
      finishCube += turnc(3);
      finishCube += turnc(2);
      finishCube += turncc(1);
      finishCube += turncc(2);
      finishCube += turnc(3);
      finishCube += turnc(3);
      finishCube += turnc(2);
      finishCube += turnc(2);
      finishCube += turncc(5);
    }
    
    // Recursive call with the parameter as false so the algorithm can be executed again if necessary.
    return positionOppositeCorners(false);
  }
  
  // Positions the edge pieces of Face 5 and adds onto String finishCube.
  public boolean allignOppositeEdges(boolean done)
  {
    // If the parameter is true or the edge 
    if(done == true)
      return true;
    if((cube[1][0][1] == centerColor1) &&
       (cube[2][1][2] == centerColor2) &&
       (cube[3][2][1] == centerColor3) &&
       (cube[4][1][0] == centerColor4))
      return true;
    
    // If not done, depending on which corner piece is in position, executes an algorithm.
    if(cube[1][0][1] == centerColor1)
    {
      finishCube += turnc(3);
      finishCube += turnc(3);
      finishCube += turnc(5);
      finishCube += turnc(2);
      finishCube += turncc(4);
      finishCube += turnc(3);
      finishCube += turnc(3);
      finishCube += turncc(2);
      finishCube += turnc(4);
      finishCube += turnc(5);
      finishCube += turnc(3);
      finishCube += turnc(3);
    }
    
    else if(cube[2][1][2] == centerColor2)
    {
      finishCube += turnc(4);
      finishCube += turnc(4);
      finishCube += turnc(5);
      finishCube += turnc(3);
      finishCube += turncc(1);
      finishCube += turnc(4);
      finishCube += turnc(4);
      finishCube += turncc(3);
      finishCube += turnc(1);
      finishCube += turnc(5);
      finishCube += turnc(4);
      finishCube += turnc(4);
    }
    
    else if(cube[3][2][1] == centerColor3)
    {
      finishCube += turnc(1);
      finishCube += turnc(1);
      finishCube += turnc(5);
      finishCube += turnc(4);
      finishCube += turncc(2);
      finishCube += turnc(1);
      finishCube += turnc(1);
      finishCube += turncc(4);
      finishCube += turnc(2);
      finishCube += turnc(5);
      finishCube += turnc(1);
      finishCube += turnc(1);
    }
    
    else if(cube[4][1][0] == centerColor4)
    {
      finishCube += turnc(2);
      finishCube += turnc(2);
      finishCube += turnc(5);
      finishCube += turnc(1);
      finishCube += turncc(3);
      finishCube += turnc(2);
      finishCube += turnc(2);
      finishCube += turncc(1);
      finishCube += turnc(3);
      finishCube += turnc(5);
      finishCube += turnc(2);
      finishCube += turnc(2);
    }
    
    else
    {
      finishCube += turnc(1);
      finishCube += turnc(1);
      finishCube += turnc(5);
      finishCube += turnc(4);
      finishCube += turncc(2);
      finishCube += turnc(1);
      finishCube += turnc(1);
      finishCube += turncc(4);
      finishCube += turnc(2);
      finishCube += turnc(5);
      finishCube += turnc(1);
      finishCube += turnc(1);
    }
    
    // Recursive call with paramter as false to run the appropriate algorithm again if needed.
    return allignOppositeEdges(false);
  }
  
  // Turns the Face in the parameter clockwise, and then returns a String based on what was turned.
  public String turnc(int face)
  {
    // Creates a temporary 3D Color array with the clockwise turn.
    Color [][] temp = {
      {cube[face][2][0], cube[face][1][0], cube[face][0][0]},
      {cube[face][2][1], cube[face][1][1], cube[face][0][1]},
      {cube[face][2][2], cube[face][1][2], cube[face][0][2]}};
    
    // Stores replaces the face in teh parameter with the temporary array.
    cube[face] = temp;
    
    // Declares 3 Color variables.
    Color temp1, temp2, temp3;
    
    // Rearranges the other faces depending on which one is being turned.
    if(face == 0)
    {
      temp1 = cube[1][2][0];
      temp2 = cube[1][2][1];
      temp3 = cube[1][2][2];
      
      cube[1][2][0] = cube[4][2][2];
      cube[1][2][1] = cube[4][1][2];
      cube[1][2][2] = cube[4][0][2];
      
      cube[4][2][2] = cube[3][0][2];
      cube[4][1][2] = cube[3][0][1];
      cube[4][0][2] = cube[3][0][0];
      
      cube[3][0][2] = cube[2][0][0];
      cube[3][0][1] = cube[2][1][0];
      cube[3][0][0] = cube[2][2][0];
      
      cube[2][0][0] = temp1;
      cube[2][1][0] = temp2;
      cube[2][2][0] = temp3;
    }
    
    if(face == 1)
    {
      temp1 = cube[0][0][0];
      temp2 = cube[0][0][1];
      temp3 = cube[0][0][2];
      
      cube[0][0][0] = cube[2][0][0];
      cube[0][0][1] = cube[2][0][1];
      cube[0][0][2] = cube[2][0][2];
      
      cube[2][0][0] = cube[5][0][0];
      cube[2][0][1] = cube[5][0][1];
      cube[2][0][2] = cube[5][0][2];
      
      cube[5][0][0] = cube[4][0][0];
      cube[5][0][1] = cube[4][0][1];
      cube[5][0][2] = cube[4][0][2];
      
      cube[4][0][0] = temp1;
      cube[4][0][1] = temp2;
      cube[4][0][2] = temp3;
    }
    
    if(face == 2)
    {
      temp1 = cube[0][0][2];
      temp2 = cube[0][1][2];
      temp3 = cube[0][2][2];
      
      cube[0][0][2] = cube[3][0][2];
      cube[0][1][2] = cube[3][1][2];
      cube[0][2][2] = cube[3][2][2];
      
      cube[3][0][2] = cube[5][2][0];
      cube[3][1][2] = cube[5][1][0];
      cube[3][2][2] = cube[5][0][0];
      
      cube[5][2][0] = cube[1][0][2];
      cube[5][1][0] = cube[1][1][2];
      cube[5][0][0] = cube[1][2][2];
      
      cube[1][0][2] = temp1;
      cube[1][1][2] = temp2;
      cube[1][2][2] = temp3;
    }
    
    if(face == 3)
    {
      temp1 = cube[0][2][0];
      temp2 = cube[0][2][1];
      temp3 = cube[0][2][2];
      
      cube[0][2][0] = cube[4][2][0];
      cube[0][2][1] = cube[4][2][1];
      cube[0][2][2] = cube[4][2][2];
      
      cube[4][2][0] = cube[5][2][0];
      cube[4][2][1] = cube[5][2][1];
      cube[4][2][2] = cube[5][2][2];
      
      cube[5][2][0] = cube[2][2][0];
      cube[5][2][1] = cube[2][2][1];
      cube[5][2][2] = cube[2][2][2];
      
      cube[2][2][0] = temp1;
      cube[2][2][1] = temp2;
      cube[2][2][2] = temp3;
    }
    
    if(face == 4)
    {
      temp1 = cube[0][0][0];
      temp2 = cube[0][1][0];
      temp3 = cube[0][2][0];
      
      cube[0][0][0] = cube[1][0][0];
      cube[0][1][0] = cube[1][1][0];
      cube[0][2][0] = cube[1][2][0];
      
      cube[1][0][0] = cube[5][2][2];
      cube[1][1][0] = cube[5][1][2];
      cube[1][2][0] = cube[5][0][2];
      
      cube[5][2][2] = cube[3][0][0];
      cube[5][1][2] = cube[3][1][0];
      cube[5][0][2] = cube[3][2][0];
      
      cube[3][0][0] = temp1;
      cube[3][1][0] = temp2;
      cube[3][2][0] = temp3;
    }
    
    if(face == 5)
    {
      temp1 = cube[1][0][2];
      temp2 = cube[1][0][1];
      temp3 = cube[1][0][0];
      
      cube[1][0][2] = cube[2][2][2];
      cube[1][0][1] = cube[2][1][2];
      cube[1][0][0] = cube[2][0][2];
      
      cube[2][2][2] = cube[3][2][0];
      cube[2][1][2] = cube[3][2][1];
      cube[2][0][2] = cube[3][2][2];
      
      cube[3][2][0] = cube[4][0][0];
      cube[3][2][1] = cube[4][1][0];
      cube[3][2][2] = cube[4][2][0];
      
      cube[4][0][0] = temp1;
      cube[4][1][0] = temp2;
      cube[4][2][0] = temp3;
    }
    
    // Returns a String with the information of the turn.
    return "Face " + face + " has been turned clockwise.\n";
  }
  
  // Turns the Face in the parameter counter-clockwise, and then returns a String based on what was turned.
  public String turncc(int face)
  {
    // Creates a temporary 3D Color array with the counter-clockwise turn.
    Color [][] temp = {
      {cube[face][0][2], cube[face][1][2], cube[face][2][2]},
      {cube[face][0][1], cube[face][1][1], cube[face][2][1]},
      {cube[face][0][0], cube[face][1][0], cube[face][2][0]}};
    
    // Stores replaces the face in teh parameter with the temporary array.
    cube[face] = temp;
    
    // Declares 3 Color variables.
    Color temp1, temp2, temp3;
    
    // Rearranges the other faces depending on which one is being turned.
    if(face == 0)
    {
      temp1 = cube[1][2][0];
      temp2 = cube[1][2][1];
      temp3 = cube[1][2][2];
      
      cube[1][2][0] = cube[2][0][0];
      cube[1][2][1] = cube[2][1][0];
      cube[1][2][2] = cube[2][2][0];
      
      cube[2][0][0] = cube[3][0][2];
      cube[2][1][0] = cube[3][0][1];
      cube[2][2][0] = cube[3][0][0];
      
      cube[3][0][2] = cube[4][2][2];
      cube[3][0][1] = cube[4][1][2];
      cube[3][0][0] = cube[4][0][2];
      
      cube[4][2][2] = temp1;
      cube[4][1][2] = temp2;
      cube[4][0][2] = temp3;
    }
    
    if(face == 1)
    {
      temp1 = cube[0][0][0];
      temp2 = cube[0][0][1];
      temp3 = cube[0][0][2];
      
      cube[0][0][0] = cube[4][0][0];
      cube[0][0][1] = cube[4][0][1];
      cube[0][0][2] = cube[4][0][2];
      
      cube[4][0][0] = cube[5][0][0];
      cube[4][0][1] = cube[5][0][1];
      cube[4][0][2] = cube[5][0][2];
      
      cube[5][0][0] = cube[2][0][0];
      cube[5][0][1] = cube[2][0][1];
      cube[5][0][2] = cube[2][0][2];
      
      cube[2][0][0] = temp1;
      cube[2][0][1] = temp2;
      cube[2][0][2] = temp3;
    }
    
    if(face == 2)
    {
      temp1 = cube[0][0][2];
      temp2 = cube[0][1][2];
      temp3 = cube[0][2][2];
      
      cube[0][0][2] = cube[1][0][2];
      cube[0][1][2] = cube[1][1][2];
      cube[0][2][2] = cube[1][2][2];
      
      cube[1][0][2] = cube[5][2][0];
      cube[1][1][2] = cube[5][1][0];
      cube[1][2][2] = cube[5][0][0];
      
      cube[5][2][0] = cube[3][0][2];
      cube[5][1][0] = cube[3][1][2];
      cube[5][0][0] = cube[3][2][2];
      
      cube[3][0][2] = temp1;
      cube[3][1][2] = temp2;
      cube[3][2][2] = temp3;
    }
    
    if(face == 3)
    {
      temp1 = cube[0][2][0];
      temp2 = cube[0][2][1];
      temp3 = cube[0][2][2];
      
      cube[0][2][0] = cube[2][2][0];
      cube[0][2][1] = cube[2][2][1];
      cube[0][2][2] = cube[2][2][2];
      
      cube[2][2][0] = cube[5][2][0];
      cube[2][2][1] = cube[5][2][1];
      cube[2][2][2] = cube[5][2][2];
      
      cube[5][2][0] = cube[4][2][0];
      cube[5][2][1] = cube[4][2][1];
      cube[5][2][2] = cube[4][2][2];
      
      cube[4][2][0] = temp1;
      cube[4][2][1] = temp2;
      cube[4][2][2] = temp3;
    }
    
    if(face == 4)
    {
      temp1 = cube[0][0][0];
      temp2 = cube[0][1][0];
      temp3 = cube[0][2][0];
      
      cube[0][0][0] = cube[3][0][0];
      cube[0][1][0] = cube[3][1][0];
      cube[0][2][0] = cube[3][2][0];
      
      cube[3][0][0] = cube[5][2][2];
      cube[3][1][0] = cube[5][1][2];
      cube[3][2][0] = cube[5][0][2];
      
      cube[5][2][2] = cube[1][0][0];
      cube[5][1][2] = cube[1][1][0];
      cube[5][0][2] = cube[1][2][0];
      
      cube[1][0][0] = temp1;
      cube[1][1][0] = temp2;
      cube[1][2][0] = temp3;
    }
    
    if(face == 5)
    {
      temp1 = cube[1][0][2];
      temp2 = cube[1][0][1];
      temp3 = cube[1][0][0];
      
      cube[1][0][2] = cube[4][0][0];
      cube[1][0][1] = cube[4][1][0];
      cube[1][0][0] = cube[4][2][0];
      
      cube[4][0][0] = cube[3][2][0];
      cube[4][1][0] = cube[3][2][1];
      cube[4][2][0] = cube[3][2][2];
      
      cube[3][2][0] = cube[2][2][2];
      cube[3][2][1] = cube[2][1][2];
      cube[3][2][2] = cube[2][0][2];
      
      cube[2][2][2] = temp1;
      cube[2][1][2] = temp2;
      cube[2][0][2] = temp3;
    }
    
     // Returns a String with the information of the turn.
    return "Face " + face + " has been turned counter-clockwise.\n";
  }
  
  // Returns a String with all the colors on each face of the cube.
  public String toString()
  {
    // Delcares and instantiates String info.
    String info = new String();
    // Uses nested for loops to cycle through each face, row, and column of the cube.
    for(int x=0; x<6; x++)
    {
      info += "Face " + x + "\n";
      for(int y=0; y<3; y++)
      {
        for(int z=0; z<3; z++)
        {
          info += cube[x][y][z] + " ";
        }
        info += "\n";
      }
    }
    // Returns String info.
    return info;
  }
  
  // Returns the color at a specific position.
  public Color getSquare(int x, int y, int z)
  {
    return cube[x][y][z];
  }
  
  // Sets the color at the position given through parameter.
  public void setSquare(Color color, int x, int y, int z)
  {
    cube[x][y][z] = color;
  }
  
  // Returns the 3D Color array of the cube.
  public Color[][][] getCube()
  {
    return cube;
  }
  
  // Sets the 3D Color array cube to the array given in the parameter.
  public void setCube(Color[][][] cube)
  {
    this.cube = cube;
  }
}