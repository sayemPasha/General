package basic;

import java.util.*;

 class Driver_Puzzle {

    /**
     * This class demonstrate basic OOP, array and ArrayList
     */
    public static void main(String[] args)
    {
        Puzzle p = new Puzzle(Puzzle.how_to_init.FROM_ONE_TO_TOTAL_CELL);
        //System.out.println(p);
        Puzzle puzzle = new Puzzle(p);
        System.out.println(puzzle);

    }

}

/**
 * A puzzle configuration consisting of cell status and border info
 */
public class Puzzle{
    public static final int Row_Column = 5;
    int [][] board = new int [Row_Column][Row_Column];
    public enum how_to_init{ WITH_ZERO, FROM_ONE_TO_TOTAL_CELL};

    /*Basic constructor, init with all zero*/
    Puzzle()
    {
        for(int i = 0; i< Row_Column; i++){
            Arrays.fill(board[i], -1);
        }
    }

    /*Clone constructor*/
    Puzzle( Puzzle p)
    {
        for(int i = 0; i < Row_Column; i++){
            for(int j = 0; j < Row_Column; j++){
                board[i][j] = p.board[i][j];
            }
        }

    }

    /*Standard Constructor*/
    Puzzle(how_to_init choice)
    {
        switch (choice){

            case FROM_ONE_TO_TOTAL_CELL:
                int cnt = 0;
                for(int i = 0; i < Row_Column; i++){
                    for(int j = 0; j < Row_Column; j++){
                        board[i][j] = cnt++;
                    }
                }

                break;
            //end of case form 0 to total cell

            case WITH_ZERO:
                for(int i = 0; i < Row_Column; i++){
                    for(int j = 0; j < Row_Column; j++){
                        board[i][j] = 0;
                    }
                }

                break;
            //end of case with zero
        }

    }

    public String toString()
    {
        return generate_Display_String();
    }

    private String generate_Display_String()
    {

        String temp = "";
        for(int i = 0; i < Row_Column; i++){
            for(int j = 0; j < Row_Column; j++){
                temp +=  Integer.toString(board[i][j]);
                temp +=  " ";
            }
            temp += "\n";
        }
        return temp;
    }


}
