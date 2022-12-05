import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) throws FileNotFoundException {
        // RULES:
        // Every elf keeps a log of how many calories they are carrying in a file
        // Every line is a food item, elves separate themselves with blank newlines
        // Example:
        // 100
        // 200
        //
        // 540
        //
        // The first elf has 300 calories, the second has 540.

        // Part 1 Objective: Find how many calories the elf with the most calories has
        // Part 2 Objective: Find how many calories the top 3 elves with the most calories have

        Scanner calorieLog = new Scanner(new FileReader("inputs/input1.txt"));
        int firstCalories = 0;
        int firstElf = 0;
        int secondCalories = 0;
        int secondElf = 0;
        int thirdCalories = 0;
        int thirdElf = 0;
        int elf = 0;
        while (calorieLog.hasNextLine()) {
            elf++;
            int calories = 0;

            while (calorieLog.hasNextLine()) {
                String line = calorieLog.nextLine();
                if (line.isBlank()) break;
                int number = Integer.parseInt(line);
                if (number != 0) calories += number;
            }

            if (calories > firstCalories) {
                firstCalories = calories;
                firstElf = elf;
            } else if (calories > secondCalories) {
                secondCalories = calories;
                secondElf = elf;
            } else if (calories > thirdCalories) {
                thirdCalories = calories;
                thirdElf = elf;
            }
            System.out.println("Elf " + elf + " has " + calories + " calories.");
        }
        System.out.println("Calorie rankings:");
        System.out.println("1. Elf " + firstElf + " with " + firstCalories + " calories.");
        System.out.println("2. Elf " + secondElf + " with " + secondCalories + " calories.");
        System.out.println("3. Elf " + thirdElf + " with " + thirdCalories + " calories.");
        System.out.println("Sum of top 3: " + (firstCalories + secondCalories + thirdCalories));
    }

}
