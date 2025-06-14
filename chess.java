

import java.util.*;

public class chess {

    public static void printBoard(String[][] board) {
        System.out.println();
        System.out.print("    ");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + "    ");
        }
        System.out.println();
        System.out.print("    ");
        System.out.println("---------------------------------------");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < 8; j++) {
                System.out.print((board[i][j] == null ? "- " : board[i][j]) + "   ");
            }
            System.out.println("|");
        }
        System.out.print("    ");
        System.out.println("---------------------------------------");
    }

    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static String[][] play(String[][] board, int player, int[] move, int[] to) {

        int row = move[0];
        int col = move[1];
        int rowto = to[0];
        int colto = to[1];

        String selected = board[row][col];
        if (selected == null || selected == "- ") {
            return null;
        }
        print("Selected: " + selected);

        // pawn
        if (selected == "1p" || selected == "2P") {
            if ((row == 1 || row == 6) && (Math.abs(row - rowto) < 3)) {
                board[row][col] = "- ";
                board[rowto][colto] = selected;

            } else if (row < 8 && (Math.abs(row - rowto) < 2) && (row != 0 || row != 6)) {
                board[row][col] = "- ";
                board[rowto][colto] = selected;

            } else {
                return null;
            }
        }

        return board;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[][] board = new String[8][8];
        String[][] result = new String[8][8];

        board[0] = new String[] { "2R", "2N", "2B", "2Q", "2K", "2B", "2N", "2R" };
        Arrays.fill(board[1], "2P");

        board[7] = new String[] { "1r", "1n", "1b", "1q", "1k", "1b", "1n", "1r" };
        Arrays.fill(board[6], "1p");

        int count = 100;
        int player = 1;

        while (count > 0) {
            printBoard(board);
            print("Player: " + player);
            print("Enter your move from (row col):");

            int[] move = new int[2];
            int[] to = new int[2];
            for (int i = 0; i < 2; i++) {
                move[i] = s.nextInt();
            }

            print("Enter your move to (row col):");

            for (int i = 0; i < 2; i++) {
                to[i] = s.nextInt();
            }
            result = play(board, player, move, to);
            if (result == null) {
                print("illegal move");
                continue;
            } else {

                board = result;
            }
            player = (player == 1) ? 2 : 1;
            count--;
        }

        s.close();
    }
}
