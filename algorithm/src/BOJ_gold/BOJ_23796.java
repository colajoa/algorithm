package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_23796 {
    static long[][] board = new long[8][8];

    static void print() {

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }

    static void command(char command) {
        switch (command) {
            case 'U':
                for (int c = 0; c < 8; c++) {
                    for (int r = 0; r < 7; r++) {
                        if (board[r][c] != 0) {
                            for (int i = r + 1; i < 8; i++) {
                                if (board[i][c] != 0 && board[r][c] != board[i][c])
                                    break;
                                if (board[r][c] == board[i][c]) {
                                    board[r][c] += board[r][c];
                                    board[i][c] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                for (int c = 0; c < 8; c++) {
                    for (int r = 0; r < 7; r++) {
                        if (board[r][c] == 0) {
                            for (int i = r + 1; i < 8; i++) {
                                if (board[i][c] != 0) {
                                    board[r][c] = board[i][c];
                                    board[i][c] = 0;
                                    break;
                                }
                            }

                        }
                    }
                }

                break;

            case 'D':
                for (int c = 0; c < 8; c++) {
                    for (int r = 7; r > 0; r--) {
                        if (board[r][c] != 0) {
                            for (int i = r - 1; i > -1; i--) {
                                if (board[i][c] != 0 && board[r][c] != board[i][c])
                                    break;
                                if (board[r][c] == board[i][c]) {
                                    board[r][c] += board[r][c];
                                    board[i][c] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                for (int c = 0; c < 8; c++) {
                    for (int r = 7; r > 0; r--) {
                        if (board[r][c] == 0) {
                            for (int i = r - 1; i > -1; i--) {
                                if (board[i][c] != 0) {
                                    board[r][c] = board[i][c];
                                    board[i][c] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                break;

            case 'L':
                for (int r = 0; r < 8; r++) {
                    for (int c = 0; c < 7; c++) {
                        if (board[r][c] != 0) {
                            for (int i = c + 1; i < 8; i++) {
                                if (board[r][i] != 0 && board[r][c] != board[r][i])
                                    break;
                                if (board[r][c] == board[r][i]) {
                                    board[r][c] += board[r][c];
                                    board[r][i] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                for (int r = 0; r < 8; r++) {
                    for (int c = 0; c < 7; c++) {
                        if (board[r][c] == 0) {
                            for (int i = c + 1; i < 8; i++) {
                                if (board[r][i] != 0) {
                                    board[r][c] = board[r][i];
                                    board[r][i] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }

                break;

            case 'R':
                for (int r = 0; r < 8; r++) {
                    for (int c = 7; c > 0; c--) {
                        if (board[r][c] != 0) {
                            for (int i = c - 1; i > -1; i--) {
                                if (board[r][i] != 0 && board[r][c] != board[r][i])
                                    break;
                                if (board[r][c] == board[r][i]) {
                                    board[r][c] += board[r][c];
                                    board[r][i] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                for (int r = 0; r < 8; r++) {
                    for (int c = 7; c > 0; c--) {
                        if (board[r][c] == 0) {
                            for (int i = c - 1; i > -1; i--) {
                                if (board[r][i] != 0) {
                                    board[r][c] = board[r][i];
                                    board[r][i] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        for (int r = 0; r < 8; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < 8; c++) {
                board[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        char command = br.readLine().charAt(0);

        command(command);

        print();
    }
}
