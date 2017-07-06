

import com.sun.tools.javac.util.Pair;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static GameEngine gameEngine;

    public static void main(String[] args) {
        initGameEngine();
        int choice = 0;
        while (choice != 2) {
            System.out.println("Enter your choice :");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Making move!!");
                    inputMove();
                    break;
                case 2:
                    System.out.println("Closing now!!");
                    break;
            }
        }
    }

    private static void initGameEngine() {
        gameEngine = new GameEngine();
    }

    private static void inputMove() {
        int sx, sy;
        System.out.println("Enter starting piece");
        sx = scanner.nextInt();
        sy = scanner.nextInt();
        int dx, dy;
        System.out.println("Enter destination piece");
        dx = scanner.nextInt();
        dy = scanner.nextInt();
        gameEngine.makeMove(new Pair<Integer, Integer>(sx, sy), new Pair<Integer, Integer>(dx, dy));
    }
}