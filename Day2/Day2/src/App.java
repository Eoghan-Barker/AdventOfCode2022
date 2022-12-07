import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        File input = new File("C:/Coding/AdventOfCode2022/Day2/Day2/input.txt");
        Scanner reader = new Scanner(input);

        part1(reader);
        reader = new Scanner(input);
        part2(reader);
    }

    public static void part1(Scanner reader) {
        // A + X = Rock = 1pt
        // B + Y = Paper = 2pts
        // C + Z = Scissors = 3pts
        // Win = 6pts, Draw = 3pts, Loss = 0pts
        int totalPoints = 0;
        while (reader.hasNextLine()) {
            // Read in one line at a time
            String data = reader.nextLine();
            char opponent = data.charAt(0);
            char player = data.charAt(2);
            // Check what player is playing
            switch (player) {
                case 'X':
                    totalPoints += 1;
                    // check if win/lose/draw
                    if (opponent == 'C') {
                        totalPoints += 6;
                    } else if (opponent == 'A') {
                        totalPoints += 3;
                    }
                    break;
                case 'Y':
                    totalPoints += 2;
                    // check if win/lose/draw
                    if (opponent == 'A') {
                        totalPoints += 6;
                    } else if (opponent == 'B') {
                        totalPoints += 3;
                    }
                    break;
                case 'Z':
                    totalPoints += 3;
                    // check if win/lose/draw
                    if (opponent == 'B') {
                        totalPoints += 6;
                    } else if (opponent == 'C') {
                        totalPoints += 3;
                    }
                    break;
            }
        }
        reader.close();

        System.out.println(totalPoints);

    }

    public static void part2(Scanner reader) {
        // x = lose, y = draw, z = win

        int totalPoints = 0;
        while (reader.hasNextLine()) {
            // Read in one line at a time
            String data = reader.nextLine();
            char opponent = data.charAt(0);
            char player = data.charAt(2);
            // Check what player supposed to do
            switch (player) {
                case 'X':
                    // lose
                    if (opponent == 'A') {
                        // rock > Scissors=3
                        totalPoints += 3;
                    } else if (opponent == 'B') {
                        // paper > rock=1
                        totalPoints += 1;
                    } else if (opponent == 'C') {
                        // Scissors > paper=2
                        totalPoints+= 2;
                    }
                    break;
                case 'Y':
                    // Draw
                    totalPoints += 3;
                    if (opponent == 'A') {
                        // rock = 1
                        totalPoints += 1;
                    } else if (opponent == 'B') {
                        // paper =2
                        totalPoints += 2;
                    } else if (opponent == 'C') {
                        // Scissors =3
                        totalPoints+= 3;
                    }
                    break;
                case 'Z':
                    // win
                    totalPoints += 6;
                    if (opponent == 'A') {
                        // rock < paper=2
                        totalPoints += 2;
                    } else if (opponent == 'B') {
                        // paper < scissors=3
                        totalPoints += 3;
                    } else if (opponent == 'C') {
                        // Scissors < rock=1
                        totalPoints+= 1;
                    }
                    break;
            }
        }
        reader.close();

        System.out.println(totalPoints);
    }
}
