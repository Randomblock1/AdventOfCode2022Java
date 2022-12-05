import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day4 {
    public static boolean rangesFullyIntersect(int min1, int max1, int min2, int max2) {
        if (min1 <= min2 && max1 >= max2) {
            return true;
        } else {
            return min2 <= min1 && max2 >= max1;
        }
    }

    public static boolean rangesPartiallyIntersect(int min1, int max1, int min2, int max2) {
        if (min1 <= min2 && max1 >= min2) {
            return true;
        } else {
            return min2 <= min1 && max2 >= min1;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        // RULES
        // 2 pairs of ranges are stored in the format "min-max,min-max\n" in a file
        // OBJECTIVES
        // Part 1: Find the ranges that fully intersect (one is contained within the other)
        // Part 2: Find the ranges that partially intersect (one overlaps within the other)
        Scanner scanner = new Scanner(new FileReader("inputs/input4.txt"));
        int counter1 = 0;
        int counter2 = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String half1 = line.substring(0, line.indexOf(','));
            String half2 = line.substring(line.indexOf(',') + 1);
            int num1 = Integer.parseInt(half1.substring(0, half1.indexOf("-")));
            int num2 = Integer.parseInt(half1.substring(half1.indexOf("-") + 1));
            int num3 =
                    Integer.parseInt(half2.substring(half2.indexOf(",") + 1, half2.indexOf("-")));
            int num4 = Integer.parseInt(half2.substring(half2.indexOf("-") + 1));
            if (rangesFullyIntersect(num1, num2, num3, num4)) counter1++;
            if (rangesPartiallyIntersect(num1, num2, num3, num4)) counter2++;
        }
        System.out.println(counter1 + " assignment pairs fully contain the other");
        System.out.println(counter2 + " assignment pairs partially contain the other");
    }

}
