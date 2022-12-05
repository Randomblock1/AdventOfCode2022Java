import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner guide = new Scanner(new FileReader("inputs/input2.txt"));
        int score1 = 0;
        int score2 = 0;
        while (guide.hasNextLine()) {
            // Game Rules: you earn points based on your hand played and outcome
            // Rock +1 point, Paper +2 points, Scissors +3 points
            // Lose +0 points, Draw +3 points, Win +6 points
            // A/B/C = Rock/Paper/Scissors
            // your opponent's move is ABC and your instructions are XYZ
            // Stored in the format "A X\n" in a file

            // Objective: Calculate the score if you play by the guide
            // Part 1: if X/Y/Z is Rock/Paper/Scissors
            // Part 2: if X/Y/Z is Lose/Draw/Win

            String line = guide.nextLine();
            char opponent = line.charAt(0);
            char you = line.charAt(2);
            System.out.println("Opponent: " + opponent + ", You: " + you);

            // PART 1 BEGIN //
            switch (you) {
                case 'X' -> score1 += 1;
                case 'Y' -> score1 += 2;
                case 'Z' -> score1 += 3;
                default -> System.out.println("Invalid input: " + you);
            }
            if (((int) opponent + 23) == (int) you) {
                score1 += 3;
            } else if ((opponent == 'A' && you == 'Y') || (opponent == 'B' && you == 'Z') || (opponent == 'C' && you == 'X')) {
                score1 += 6;
            }

            // PART 2 BEGIN //
            switch (you) {
                case 'X' -> {
                    if (opponent == 'A') {
                        score2 += 3;
                    } else if (opponent == 'B') {
                        score2 += 1;
                    } else if (opponent == 'C') {
                        score2 += 2;
                    }
                }
                case 'Y' -> {
                    score2 += 3;
                    if (opponent == 'A') {
                        score2 += 1;
                    } else if (opponent == 'B') {
                        score2 += 2;
                    } else if (opponent == 'C') {
                        score2 += 3;
                    }
                }
                case 'Z' -> {
                    score2 += 6;
                    if (opponent == 'A') {
                        score2 += 2;
                    } else if (opponent == 'B') {
                        score2 += 3;
                    } else if (opponent == 'C') {
                        score2 += 1;
                    }
                }
                default -> System.out.println("Invalid input: " + you);
            }
        }
        System.out.println("Part 1 score is " + score1 + ".");
        System.out.println("Part 2 score is " + score2 + ".");
    }
}
