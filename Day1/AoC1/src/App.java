import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Read in input file
        File input = new File("C:/Coding/AdventOfCode2022/Day1/AoC1/input.txt");
        Scanner reader = new Scanner(input);

        // variables
        int cals = 0;
        int mostCalories = 0;
        int counter = 0;
        String readIn;
        
        // Parse through file
        while(reader.hasNextLine()){
            readIn = reader.nextLine();
            
            // if readIn is empty = \n which means move on to a new elf
            if(readIn.isEmpty()){
                // check if this elf's calories are higher than the current highest
                if(counter > mostCalories){
                    mostCalories = counter;
                }
                // reset on new line
                counter = 0;
            }
            // add calories for this elf
            else{
                cals = Integer.parseInt(readIn);
                counter += cals;
            }
        }
        // Output the number of calories the elf with the most calories has
        System.out.println(mostCalories);
    }
}
