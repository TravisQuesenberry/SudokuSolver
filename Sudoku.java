package SudokuSolver;

import java.util.ArrayList;


/**
 * Class for recursively finding a solution to a Sudoku problem.
 *
 * @author Biagioni, Edoardo, Cam Moore
 * @date October 23, 2013
 * @missing solveSudoku and legalValues, to be implemented by the students in ICS 211
 */
public class Sudoku {
  /**
   * Find an assignment of values to sudoku cells that makes the sudoku valid.
   *
   * @param the sudoku to be solved.
   * @return whether a solution was found if a solution was found, the sudoku is filled in with the solution if no
   * solution was found, restores the sudoku to its original value
   */
  public static boolean solveSudoku(int[][] sudoku) {
    // TODO: Implement this method recursively. You may use a recursive
    // helper method.
    boolean empty = true;
    int col = 0;
    int row = 0;
    for (int i = 0; i < 9; i++) {
      row = i;
      //System.out.println("i: " + i);
      for (int j = 0; j < 9; j++) {
        col = j;
        //int[][] index = new int[i][j];
        //System.out.println("index: " + index);
        //System.out.println("j: " + j);
        //System.out.println("Sudoku: " + sudoku[i][j]);
        if (sudoku[i][j] == 0) {
          //System.out.println("Check: " + checkSudoku(sudoku, empty));
          empty = true;
          for (int x = 1; x <= 9; x++) {
            sudoku[row][col] = x;
            System.out.println(Sudoku.toString(sudoku, true));
         
            if (checkSudoku(sudoku, empty) && solveSudoku(sudoku)) {
              //System.out.println("new: " + sudoku[i][j]);
              return true;
            } else {
              sudoku[row][col] = 0;
            }
          }
          return false;
        }
        
      }
    }
    System.out.println("Solution: ");
    System.out.println(Sudoku.toString(sudoku, true));
    return true;
  }


  /**
   * Find the legal values for the given sudoku and cell.
   *
   * @param sudoku, the sudoku being solved.
   * @param row the row of the cell to get values for.
   * @param col the column of the cell.
   * @return an ArrayList of the valid values.
   */
  public static ArrayList<Integer> legalValues(int[][] sudoku, int row, int col) {
    // check that index is not empty.
    if (sudoku[row][col] != 0) {
      return null;
    }
    // initilize array
    ArrayList<Integer> legal = new ArrayList<>();
    boolean empty = true;
    // if index is 0.
    if (sudoku[row][col] == 0) {
      empty = true;
      // loop over 1-9
      for (int x = 1; x <= 9; x++) {
        sudoku[row][col] = x;
        if (checkSudoku(sudoku, empty)) {
          legal.add(x);
        } else {
          sudoku[row][col] = 0;
        }
      }
        
    }
    return legal;
  }

  
  /**
   * checks that the sudoku rules hold in this sudoku puzzle. cells that contain 0 are not checked.
   *
   * @param the sudoku to be checked
   * @param whether to print the error found, if any   
   * @return true if this sudoku obeys all of the sudoku rules, otherwise false
   */
  public static boolean checkSudoku(int[][] sudoku, boolean printErrors) {
    if (sudoku.length != 9) {
      if (printErrors) {
        //System.out.println("sudoku has " + sudoku.length + " rows, should have 9");
      }
      return false;
    }
    for (int i = 0; i < sudoku.length; i++) {
      if (sudoku[i].length != 9) {
        if (printErrors) {
          //System.out.println("sudoku row " + i + " has " + sudoku[i].length + " cells, should have 9");
        }
        return false;
      }
    }
    /* check each cell for conflicts */
    for (int i = 0; i < sudoku.length; i++) {
      for (int j = 0; j < sudoku.length; j++) {
        int cell = sudoku[i][j];
        if (cell == 0) {
          continue; /* blanks are always OK */
        }
        if ((cell < 1) || (cell > 9)) {
          if (printErrors) {
            //System.out.println("sudoku row " + i + " column " + j + " has illegal value " + cell);
          }
          return false;
        }
        /* does it match any other value in the same row? */
        for (int m = 0; m < sudoku.length; m++) {
          if ((j != m) && (cell == sudoku[i][m])) {
            if (printErrors) {
              //System.out.println("sudoku row " + i + " has " + cell + " at both positions " + j + " and " + m);
            }
            return false;
          }
        }
        /* does it match any other value it in the same column? */
        for (int k = 0; k < sudoku.length; k++) {
          if ((i != k) && (cell == sudoku[k][j])) {
            if (printErrors) {
              //System.out.println("sudoku column " + j + " has " + cell + " at both positions " + i + " and " + k);
            }
            return false;
          }
        }
        /* does it match any other value in the 3x3? */
        for (int k = 0; k < 3; k++) {
          for (int m = 0; m < 3; m++) {
            int testRow = (i / 3 * 3) + k; /* test this row */
            int testCol = (j / 3 * 3) + m; /* test this col */
            if ((i != testRow) && (j != testCol) && (cell == sudoku[testRow][testCol])) {
              if (printErrors) {
                //System.out.println("sudoku character " + cell + " at row " + i + ", column " + j
               //     + " matches character at row " + testRow + ", column " + testCol);
              }
              return false;
            }
          }
        }
      }
    }
    return true;
  }


  /**
   * Converts the sudoku to a printable string
   *
   * @param the sudoku to be converted
   * @param whether to check for errors
   * @return the printable version of the sudoku
   */
  public static String toString(int[][] sudoku, boolean debug) {
    if ((!debug) || (checkSudoku(sudoku, true))) {
      String result = "";
      for (int i = 0; i < sudoku.length; i++) {
        if (i % 3 == 0) {
          result = result + "+-------+-------+-------+\n";
        }
        for (int j = 0; j < sudoku.length; j++) {
          if (j % 3 == 0) {
            result = result + "| ";
          }
          if (sudoku[i][j] == 0) {
            result = result + "  ";
          } else {
            result = result + sudoku[i][j] + " ";
          }
        }
        result = result + "|\n";
      }
      result = result + "+-------+-------+-------+\n";
      return result;
    }
    return "illegal sudoku";
  }
//
}
