package MainGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Menu();

    }

    public static void Menu() {
        System.out.println("_____________________");
        System.out.println("Меню");
        System.out.println("1. Начать новую игру");
        System.out.println("2. Выход");
        System.out.println("_____________________");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            switch (input) {
                case ("1"): new Game().newGame();
                case ("2"): scanner.close();
                        System.exit(0);
                default:
                    System.out.println("Введено неправильное значение. Попробуйте снова.");
            }
        }
    }

}