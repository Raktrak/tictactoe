package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static String gameState;

    public static void main(String[] args) {
        gameState = " ".repeat(9);
        int counter = 0;

        System.out.println("Hello, I want to play a game. For years you have burned those around you with your lies, " +
                "cons, and deceits. " +
                "\nNow you will have a chance to redeem yourself, for the games you’ve played with others, " +
                "by playing one of mine.");

        System.out.println("\n---------");
        for (int i = 0; i < 9; i += 3) {
            System.out.print("| ");
            for (int j = i; j < i + 3; j++) {
                System.out.print(gameState.charAt(j) + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        boolean xWins = false;
        boolean oWins = false;
        while (!xWins || !oWins) {
            counter = letsPlayAGame(counter);
            printBoard();

            xWins = checkIfPlayerWins('X');
            oWins = checkIfPlayerWins('O');
            boolean gameNotFinished = gameState.contains(" ");
            boolean draw = !xWins && !oWins && !gameNotFinished;

            if (xWins && oWins || Math.abs(countOccurrences(gameState, 'X') - countOccurrences(gameState, 'O')) >= 2) {
                System.out.println("Impossible");
            } else if (xWins) {
                System.out.println("X wins");
                break;
            } else if (oWins) {
                System.out.println("O wins");
                break;
            } else if (draw) {
                System.out.println("Draw");
                break;
            } else {
                System.out.println("Game not finished");
            }
        }
    }

    private static int letsPlayAGame(int counter) {
        Scanner scanner = new Scanner(System.in);

        String gameStateFirstLine = gameState.substring(0, 3);
        String gameStateSecondLine = gameState.substring(3, 6);
        String gameStateThirdLine = gameState.substring(6, 9);
        String merged;
        int cordOne = 0;
        int cordTwo = 0;

        boolean whoseTurnIsIt = true;
        while (whoseTurnIsIt) {

            boolean validInput1 = false;
            boolean validInput2 = false;
            boolean validInput3 = false;
            while (!validInput1 && !validInput2 && !validInput3) {
                try {
                    cordOne = scanner.nextInt();
                    cordTwo = scanner.nextInt();

                    if (1 > cordOne || cordOne > 3 || 1 > cordTwo || cordTwo > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        scanner.nextLine();
                        continue;
                    }
                    if (cordOne == 1) {
                        if (gameStateFirstLine.charAt(cordTwo - 1) != ' ') {
                            System.out.println("This cell is occupied! Choose another one!");
                            continue;
                        } else {
                            validInput1 = true;
                        }
                    }
                    if (cordOne == 2) {
                        if (gameStateSecondLine.charAt(cordTwo - 1) != ' ') {
                            System.out.println("This cell is occupied! Choose another one!");
                            continue;
                        } else {
                            validInput2 = true;
                        }
                    }
                    if (cordOne == 3) {
                        if (gameStateThirdLine.charAt(cordTwo - 1) != ' ') {
                            System.out.println("This cell is occupied! Choose another one!");
                            continue;
                        } else {
                            validInput3 = true;
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("You should enter numbers!");
                    scanner.next();
                }

                String cordOneS = String.valueOf(cordOne);
                String cordTwoS = String.valueOf(cordTwo);
                if (counter % 2 == 0) {
                    merged = cordOneS + cordTwoS + "x";
                } else {
                    merged = cordOneS + cordTwoS + "o";
                }

                switch (merged) {
                    case "11x" -> {
                        gameStateFirstLine = "X" + gameStateFirstLine.substring(1, 3);
                        gameState = gameStateFirstLine + gameStateSecondLine + gameStateThirdLine;
                    }
                    case "12x" -> {
                        gameStateFirstLine = gameStateFirstLine.charAt(0) + "X" + gameStateFirstLine.charAt(2);
                        gameState = gameStateFirstLine + gameStateSecondLine + gameStateThirdLine;
                    }
                    case "13x" -> {
                        gameStateFirstLine = gameStateFirstLine.substring(0, 2) + "X";
                        gameState = gameStateFirstLine + gameStateSecondLine + gameStateThirdLine;
                    }
                    case "21x" -> {
                        gameStateSecondLine = "X" + gameStateSecondLine.substring(1, 3);
                        gameState = gameStateFirstLine + gameStateSecondLine + gameStateThirdLine;
                    }
                    case "22x" -> {
                        gameStateSecondLine = gameStateSecondLine.charAt(0) + "X" + gameStateSecondLine.charAt(2);
                        gameState = gameStateFirstLine + gameStateSecondLine + gameStateThirdLine;
                    }
                    case "23x" -> {
                        gameStateSecondLine = gameStateSecondLine.substring(0, 2) + "X";
                        gameState = gameStateFirstLine + gameStateSecondLine + gameStateThirdLine;
                    }
                    case "31x" -> {
                        gameStateThirdLine = "X" + gameStateThirdLine.substring(1, 3);
                        gameState = gameStateFirstLine + gameStateSecondLine + gameStateThirdLine;
                    }
                    case "32x" -> {
                        gameStateThirdLine = gameStateThirdLine.charAt(0) + "X" + gameStateThirdLine.charAt(2);
                        gameState = gameStateFirstLine + gameStateSecondLine + gameStateThirdLine;
                    }
                    case "33x" -> {
                        gameStateThirdLine = gameStateThirdLine.substring(0, 2) + "X";
                        gameState = gameStateFirstLine + gameStateSecondLine + gameStateThirdLine;
                    }
                }
                switch (merged) {
                    case "11o" -> {
                        gameStateFirstLine = "O" + gameStateFirstLine.substring(1, 3);
                        gameState = gameStateFirstLine + gameStateSecondLine + gameStateThirdLine;
                    }
                    case "12o" -> {
                        gameStateFirstLine = gameStateFirstLine.charAt(0) + "O" + gameStateFirstLine.charAt(2);
                        gameState = gameStateFirstLine + gameStateSecondLine + gameStateThirdLine;
                    }
                    case "13o" -> {
                        gameStateFirstLine = gameStateFirstLine.substring(0, 2) + "O";
                        gameState = gameStateFirstLine + gameStateSecondLine + gameStateThirdLine;
                    }
                    case "21o" -> {
                        gameStateSecondLine = "O" + gameStateSecondLine.substring(1, 3);
                        gameState = gameStateFirstLine + gameStateSecondLine + gameStateThirdLine;
                    }
                    case "22o" -> {
                        gameStateSecondLine = gameStateSecondLine.charAt(0) + "O" + gameStateSecondLine.charAt(2);
                        gameState = gameStateFirstLine + gameStateSecondLine + gameStateThirdLine;
                    }
                    case "23o" -> {
                        gameStateSecondLine = gameStateSecondLine.substring(0, 2) + "O";
                        gameState = gameStateFirstLine + gameStateSecondLine + gameStateThirdLine;
                    }
                    case "31o" -> {
                        gameStateThirdLine = "O" + gameStateThirdLine.substring(1, 3);
                        gameState = gameStateFirstLine + gameStateSecondLine + gameStateThirdLine;
                    }
                    case "32o" -> {
                        gameStateThirdLine = gameStateThirdLine.charAt(0) + "O" + gameStateThirdLine.charAt(2);
                        gameState = gameStateFirstLine + gameStateSecondLine + gameStateThirdLine;
                    }
                    case "33o" -> {
                        gameStateThirdLine = gameStateThirdLine.substring(0, 2) + "O";
                        gameState = gameStateFirstLine + gameStateSecondLine + gameStateThirdLine;
                    }
                }
                whoseTurnIsIt = false;
            }
        }
        counter++;
        return counter;
    }

    private static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 9; i += 3) {
            System.out.print("| ");
            for (int j = i; j < i + 3; j++) {
                System.out.print(Main.gameState.charAt(j) + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

    }

    private static boolean checkIfPlayerWins(char player) {
        // Sprawdź czy dany gracz wygrał w poziomie, pionie lub na skos
        return gameState.charAt(0) == player && gameState.charAt(1) == player && gameState.charAt(2) == player ||
                gameState.charAt(3) == player && gameState.charAt(4) == player && gameState.charAt(5) == player ||
                gameState.charAt(6) == player && gameState.charAt(7) == player && gameState.charAt(8) == player ||
                gameState.charAt(0) == player && gameState.charAt(3) == player && gameState.charAt(6) == player ||
                gameState.charAt(1) == player && gameState.charAt(4) == player && gameState.charAt(7) == player ||
                gameState.charAt(2) == player && gameState.charAt(5) == player && gameState.charAt(8) == player ||
                gameState.charAt(0) == player && gameState.charAt(4) == player && gameState.charAt(8) == player ||
                gameState.charAt(2) == player && gameState.charAt(4) == player && gameState.charAt(6) == player;
    }

    private static int countOccurrences(String str, char ch) {
        // Zlicz wystąpienia danego znaku w ciągu
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}

