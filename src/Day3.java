import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day3 {

    public static int priority(char c) {
        if ((int) c > 96) {
            return (int) c - 96;
        } else {
            return (int) c - 38;
        }
    }

    public static char findCommon(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s2.contains(String.valueOf(s1.charAt(i)))) {
                return s1.charAt(i);
            }
        }
        return '!'; // This should never happen
    }

    public static char findCommon(String s1, String s2, String s3) {
        for (int i = 0; i < s1.length(); i++) {
            if (s2.contains(String.valueOf(s1.charAt(i))) && s3.contains(String.valueOf(s1.charAt(i)))) {
                return s1.charAt(i);
            }
        }
        return '!'; // This should never happen
    }

    public static void main(String[] args) throws FileNotFoundException {
        // RULES:
        // A backpack's contents are represented as a string of random characters
        // Each character represents a different item
        // Each item has a priority, which is the character's position in the alphabet
        // 'a' is 1, 'b' is 2, 'c' is 3, etc.
        // and 'A' is 27, 'B' is 28, 'C' is 29, etc.
        // A compartment is half of the backpack, split in the middle of the string
        // Both compartments in a backpack have a common item
        // Every 3 backpack represents a group, and every group has a common item

        // OBJECTIVES:
        // Part 1: Find the common letter in a backpack's compartments, then sum the priorities
        // of those letters into a total
        // Part 2: Find the common letter in every group , then sum the priority of those letters
        // into a total

        System.out.println("===Solving for part 1===");
        Scanner scanner = new Scanner(new FileReader("inputs/input3.txt"));
        int sumPriorities = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String line1 = line.substring(0, line.length() / 2);
            String line2 = line.substring(line.length() / 2);
            char common = findCommon(line1, line2);
            int num = priority(common);
            sumPriorities += num;
            System.out.println(common + " with " + "priority " + num);
        }

        System.out.println("===Solving for part 2===");
        scanner = new Scanner(new FileReader("inputs/input3.txt"));
        int sumBadges = 0;
        while (scanner.hasNextLine()) {
            String line1 = scanner.nextLine();
            String line2 = scanner.nextLine();
            String line3 = scanner.nextLine();
            char common = findCommon(line1, line2, line3);
            int num = priority(common);
            sumBadges += num;
            System.out.println(common + " with " + "priority " + num);
        }

        System.out.println("Part 1 sum: " + sumPriorities);
        System.out.println("Part 2 sum: " + sumBadges);
    }

}
