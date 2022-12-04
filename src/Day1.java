import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner calorieLog = new Scanner(new FileReader("inputs/input1.txt"));
        int mostCalories = 0;
        int mostElf = 0;
        int elf = 0;
        while (calorieLog.hasNextLine()) {
            elf++;
            int calories = 0;

            while (calorieLog.hasNextLine()) {
                String line = calorieLog.nextLine();
                if (line.isBlank()) {
                    break;
                }
                int number = Integer.parseInt(line);
                if (number != 0) {
                    calories += number;
                }
            }

            if (calories > mostCalories) {
                mostCalories = calories;
                mostElf = elf;
            }
            System.out.println("Elf " + elf + " has " + calories + " calories.");
        }
        System.out.println("Elf " + mostElf + " is carrying " + mostCalories + " calories, the " + "highest of any elf.");
    }

}
