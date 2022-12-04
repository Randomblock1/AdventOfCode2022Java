import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner guide = new Scanner(new FileReader("inputs/input2.txt"));
        int score = 0;
        while (guide.hasNextLine()) {
            int lastScore = score;
            String line = guide.nextLine();
            char opponent = line.charAt(0);
            char you = line.charAt(2);
            System.out.println("Opponent: " + opponent + ", You: " + you);
            switch (you) {
                case 'X' -> score += 1;
                case 'Y' -> score += 2;
                case 'Z' -> score += 3;
                default -> System.out.println("Invalid input: " + you);
            }
            System.out.print('\t');
            if (((int) opponent + 23) == (int) you) {
                score += 3;
                System.out.print("Tied. ");
            } else if ((opponent == 'A' && you == 'Y') || (opponent == 'B' && you == 'Z') || (opponent == 'C' && you == 'X')) {
                score += 6;
                System.out.print("Won. ");
            } else {
                System.out.print("Lost. ");
            }
            System.out.println("+" + (score - lastScore) + " points");

        }
        System.out.println("Your score is " + score + ".");
    }

}
