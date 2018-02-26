package basic;

import java.util.ArrayList;
import java.util.Scanner;

public class Contest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = Integer.parseInt( sc.nextLine() );

        for(int i=0; i<testCase; i++){

            // input
            String inputString = sc.nextLine();
            String[] splitted = inputString.split(" ");
            int serial = Integer.parseInt(splitted[0]);
            String number = splitted[1];
            /// input

            int[] temp = {8, 10, 16};
            String output = Integer.toString(serial);
            for(int j=0; j < temp.length ; j++){

                try{
                    output += (" " + Integer.toString(Integer.parseInt(number, temp[j]), 10) );
                }
                catch (NumberFormatException e)
                {
                    output += (" 0");
                }
            }
            System.out.println(output);

        }
    }
}
