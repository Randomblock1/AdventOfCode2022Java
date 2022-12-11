import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day5 {
    public static char[][] origCrates = new char[9][8];
    public static char[][] crates = new char[9][50];

    public static void moveCrates(int numCrates, int srcCol, int destCol) {
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
        System.out.println(" 1   2   3   4   5   6   7   8   9 ");
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("inputs/input5.txt"));
        // initialize big crates array
        for (int i = 0; i < crates[0].length; i++) {
            for (int j = 0; j < crates.length; j++) {
                crates[j][i] = ' ';
            }
        }

        // initialize original crates array from file
        for (int i = 0; i < origCrates[0].length; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < origCrates.length; j++) {
                origCrates[j][i] = line.charAt(j * 4 + 1);
            }
        }

        // copy original crates array to big crates array
        for (int i = 0; i < origCrates.length; i++) {
            System.arraycopy(origCrates[i], 0, crates[i], crates[0].length - 8,
                    origCrates[0].length);
        }
        scanner.nextLine();
        scanner.nextLine();
        // move crates
        while (scanner.hasNextLine()) {
            scanner.next();
            int numCrates = scanner.nextInt();
            scanner.next();
            int srcCol = scanner.nextInt();
            scanner.next();
            int destCol = scanner.nextInt();
            scanner.nextLine();
            moveCrates(numCrates, srcCol - 1, destCol - 1);
            System.out.println("Moved " + numCrates + " crates from column " + srcCol + " to " +
                    "column " + destCol);
            printCrates();
        }
        System.out.print("Solution: ");
        for (char[] crate : crates) {
            for (int j = 0; j < crates[0].length; j++) {
                if (crate[j] != ' ') {
                    System.out.print(crate[j]);
                    break;
                }
            }
        }
    }

}
