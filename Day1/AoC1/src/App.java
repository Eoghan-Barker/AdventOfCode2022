import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Read in input file
        File input = new File("C:/Coding/AdventOfCode2022/Day1/AoC1/input.txt");
        Scanner reader = new Scanner(input);

        // variables
        int cals = 0;
        int counter = 0;
        String readIn;
        int[] top3 = { 0, 0, 0 };

        // Parse through file
        while (reader.hasNextLine()) {
            readIn = reader.nextLine();

            // if readIn is empty = \n which means move on to a new elf
            if (readIn.isEmpty()) {
                if (counter > top3[0]) {
                    if (top3[0] > top3[1]) {
                        if (top3[1] > top3[2]) {
                            top3[2] = top3[1];
                        }
                        top3[1] = top3[0];
                    } else if (top3[0] > top3[2]) {
                        top3[2] = top3[0];
                    }
                    top3[0] = counter;
                } else if (counter > top3[1]) {
                    if (top3[1] > top3[2]) {
                        top3[2] = top3[1];
                    }
                    top3[1] = counter;
                } else if (counter > top3[2]) {
                    top3[2] = counter;
                }

                // reset on new line
                counter = 0;
            }
            // add calories for this elf
            else {
                cals = Integer.parseInt(readIn);
                counter += cals;
            }
        }

        reader.close();

        // // Output the number of calories the elf with the most calories has
        System.out.println(top3[0]);
        // Output the number of calories held by the top 3 elfs
        System.out.println(top3[0] + top3[1] + top3[2]);
    }
}
