import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day5 {
    public static char[][] origCrates = new char[9][8];
    public static char[][] crates = new char[9][50];
    public static Scanner scanner;

    public static void initializeCrates() {
        // initialize big crates array
        for (int i = 0; i < crates[0].length; i++) {
            for (int j = 0; j < crates.length; j++) {
                crates[j][i] = ' ';
            }
        }

        // copy original crates array to big crates array
        for (int i = 0; i < origCrates.length; i++) {
            System.arraycopy(origCrates[i], 0, crates[i], crates[0].length - 8,
                    origCrates[0].length);
        }
    }

    public static void crateMover9000(int numCrates, int srcCol, int destCol) {
        int movedCrates = 0;

        for (int i = 0; i < crates[0].length; i++) {
            if (movedCrates == numCrates) {
                break;
            }
            if (crates[srcCol][i] == ' ') continue;
            char temp = crates[srcCol][i];
            crates[srcCol][i] = ' ';
            for (int j = crates[0].length - 1; j > 0; j--) {
                if (crates[destCol][j] == ' ') {
                    crates[destCol][j] = temp;
                    movedCrates++;
                    break;
                }
            }
        }
    }

    public static void crateMover9001(int numCrates, int srcCol, int destCol) {
        int movedCrates = 0;

        for (int i = 0; i < crates[0].length; i++) {
            if (movedCrates == numCrates) {
                break;
            }
            if (crates[srcCol][i] == ' ') continue;
            char temp = crates[srcCol][i];
            crates[srcCol][i] = ' ';
            for (int j = crates[0].length - 1; j > 0; j--) {
                if (crates[destCol][j] == ' ') {
                    crates[destCol][j - numCrates + movedCrates + 1] = temp;
                    movedCrates++;
                    break;
                }
            }
        }
    }

    public static void moveCrates(int crateMover) {
        // move crates
        while (scanner.hasNextLine()) {
            scanner.next();
            int numCrates = scanner.nextInt();
            scanner.next();
            int srcCol = scanner.nextInt();
            scanner.next();
            int destCol = scanner.nextInt();
            scanner.nextLine();
            if (crateMover == 9000) {
                crateMover9000(numCrates, srcCol - 1, destCol - 1);
            } else {
                crateMover9001(numCrates, srcCol - 1, destCol - 1);
            }
            System.out.println("Moved " + numCrates + " crates from column " + srcCol + " to " +
                    "column " + destCol);
            printCrates();
        }
    }

    public static void printCrates() {
        for (int i = 0; i < crates[0].length; i++) {
            StringBuilder buffer = new StringBuilder();
            for (char[] crate : crates) {
                if (crate[i] != ' ') {
                    buffer.append("[").append(crate[i]).append("] ");
                } else {
                    buffer.append("    ");
                }
            }
            if (buffer.toString().trim().length() > 0) {
                System.out.println(buffer);
            }
        }
        for (int i = 0; i < crates.length; i++) {
            System.out.print(" " + (i + 1) + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {
        // RULES
        // Some crates are stacked on top of each other
        // They are stored in a file, along with some moves
        // X number of crates must be moved from one column to another
        // You need to find the topmost crate in every column after all moves
        // Part 1: Solve if crates are moved one at a time
        // Part 2: Solve if crates are moved all at once
        scanner = new Scanner(new FileReader("inputs/input5.txt"));

        // initialize original crates array from file
        for (int i = 0; i < origCrates[0].length; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < origCrates.length; j++) {
                origCrates[j][i] = line.charAt(j * 4 + 1);
            }
        }

        System.out.println("===Solving for Part 1===");

        initializeCrates();

        scanner.nextLine();
        scanner.nextLine();

        // move crates
        moveCrates(9000);

        StringBuilder solution1 = new StringBuilder();

        solution1.append("Solution 1: ");
        for (char[] crate : crates) {
            for (int j = 0; j < crates[0].length; j++) {
                if (crate[j] != ' ') {
                    solution1.append(crate[j]);
                    break;
                }
            }
        }

        System.out.println("===Solving for Part 2===");

        initializeCrates();

        scanner = new Scanner(new FileReader("inputs/input5.txt"));

        for (int i = 0; i < 10; i++) scanner.nextLine();

        moveCrates(9001);

        StringBuilder solution2 = new StringBuilder();

        solution2.append("Solution 2: ");
        for (char[] crate : crates) {
            for (int j = 0; j < crates[0].length; j++) {
                if (crate[j] != ' ') {
                    solution2.append(crate[j]);
                    break;
                }
            }
        }

        System.out.println(solution1);
        System.out.println(solution2);
    }

}
