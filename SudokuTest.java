package SudokuSolver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class solveSudokuTest {

  @Test
  void solveTest() {
    int[][] example = { { 0, 9, 0, 0, 0, 0, 0, 1, 0 }, { 5, 0, 1, 0, 0, 3, 0, 0, 6 }, { 0, 7, 0, 0, 5, 0, 0, 0, 0 },
        { 2, 0, 4, 0, 9, 0, 0, 6, 0 }, { 0, 0, 0, 8, 0, 0, 0, 0, 3 }, { 0, 1, 0, 0, 0, 0, 0, 0, 0 },
        { 6, 0, 5, 0, 2, 0, 0, 4, 0 }, { 7, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 9, 2, 0, 0 } };
    
    int[][] solution1 = { { 3, 9, 2, 4, 8, 6, 7, 1, 5 }, { 5, 8, 1, 2, 7, 3, 4, 9, 6 }, { 4, 7, 6, 9, 5, 1, 3, 8, 2 },
        { 2, 5, 4, 3, 9, 7, 8, 6, 1, }, { 9, 6, 7, 8, 1, 4, 5, 2, 3 }, { 8, 1, 3, 5, 6, 2, 9, 7, 4 },
        { 6, 3, 5, 7, 2, 8, 1, 4, 9, }, { 7, 2, 9, 1, 4, 5, 6, 3, 8 }, { 1, 4, 8, 6, 3, 9, 2, 5, 7 } };
    
    int[][] example2 = { { 0, 0, 0, 0, 0, 5, 3, 0, 8 }, { 0, 0, 0, 0, 4, 1, 0, 9, 0 }, { 0, 0, 0, 6, 0, 0, 4, 0, 2 },
        { 0, 3, 0, 0, 0, 0, 7, 0, 0 }, { 0, 0, 0, 8, 6, 7, 0, 0, 0 }, { 0, 0, 9, 0, 0, 0, 0, 5, 0 },
        { 2, 0, 1, 0, 0, 4, 0, 0, 0 }, { 0, 9, 0, 7, 8, 0, 0, 0, 0 }, { 8, 0, 5, 9, 0, 0, 0, 0, 0 } };
    
    int[][] solution2 = { {4, 1, 7, 2, 9, 5, 3, 6, 8}, {6, 8, 2, 3, 4, 1, 5, 9, 7 }, {  9, 5, 3, 6, 7, 8, 4, 1, 2 },
        { 1, 3, 8, 4, 5, 9, 7, 2, 6, }, { 5, 2, 4, 8, 6, 7, 9, 3, 1 }, { 7, 6, 9, 1, 2, 3, 8, 5, 4},
        { 2, 7, 1, 5, 3, 4, 6, 8, 9 }, { 3, 9, 6, 7, 8, 2, 1, 4, 5 }, { 8, 4, 5, 9, 1, 6, 2, 7, 3, } };
    
    int[][] example3 = { { 1, 1, 1, 1, 0, 5, 3, 1, 8 }, { 1, 0, 1, 1, 4, 1, 1, 9, 1 }, { 1, 1, 1, 6, 1, 1, 4, 1, 2 },
        { 1, 3, 1, 1, 1, 1, 7, 0, 1 }, { 1, 1, 1, 8, 6, 7, 0, 1, 1 }, { 1, 1, 9, 1, 1, 1, 1, 5, 1 },
        { 2, 1, 1, 1, 1, 4, 1, 1, 1 }, { 1, 9, 1, 7, 8, 1, 1, 1, 1 }, { 8, 1, 5, 9, 1, 1, 1, 1, 0 } };
    
    boolean solveSudoku = Sudoku.solveSudoku(example);
    String x = Sudoku.toString(example, solveSudoku);
    String y = Sudoku.toString(solution1, true);
    //System.out.println("x:");
    //System.out.println(x);
    //System.out.println("y:");
    //System.out.println(y);
    assertEquals(x, y);
    
    boolean solveSudoku2 = Sudoku.solveSudoku(example2);
    String i = Sudoku.toString(example2, solveSudoku2);
    String j = Sudoku.toString(solution2, true);
    assertEquals(i, j);
    
    boolean solveSudoku3 = Sudoku.solveSudoku(example3);
    System.out.println(solveSudoku3);
    assertTrue(solveSudoku3 == false);
    
  }
}


