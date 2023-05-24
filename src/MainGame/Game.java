package MainGame;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;
import java.util.Scanner;

public class Game {

    File path = new File(getClass().getClassLoader().getResource("words.csv").getFile());
    String arrayWords = readFile();

    String[][] gallow = new String[7][11];
    int count = 6;

    public void newGame() {

        String word = chooseWord(arrayWords);

        Gallow.drawGallow(gallow, count);
        StringBuilder guessWord = new StringBuilder("*".repeat(word.length()));

        System.out.println("Слово:");
        System.out.println(guessWord);
        System.out.println("У Вас 6 попыток.");
        Gallow.showGallow(gallow);

        Scanner scanner = new Scanner(System.in);
        while (count > 0) {
            System.out.println("Введите букву.");

            String input = scanner.nextLine();

            if (input.equals("") || !Character.isLetter(input.charAt(0)) || input.length() > 1) {
                System.out.println("Введено некорректное значение, попробуйте ещё раз.");
                continue;
            }

            if (word.contains(input)) {
                for (int i = 0; i < word.length(); i++) {
                    if (input.toLowerCase().charAt(0) == word.toLowerCase().charAt(i)) {
                        guessWord.replace(i, i+1, input);
                    }
                }
                Gallow.showGallow(gallow);
                System.out.println(guessWord);
            } else {
                System.out.println("В слове нет такой буквы.");
                count--;
                Gallow.drawGallow(gallow, count);
                Gallow.showGallow(gallow);
                System.out.println(guessWord);

                if (count == 0) {
                    System.out.println("Вы проиграли.");
                    System.out.println("Загаданное слово: " + word);
                } else {
                    System.out.println("Попыток осталось: " + count);
                }
            }
            if (guessWord.toString().equals(word)) {
                System.out.println("Поздравляю, Вы угадали слово.");
                break;
            }
        }
        Main.Menu();
    }

    public String readFile() {
        try {
            return Files.readString(path.toPath());
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл со словами.");
            return null;
        }
    }
    public String chooseWord(String words) {
        String[] splitWord = words.split(",");
        Random random = new Random();
        return splitWord[random.nextInt(splitWord.length)];
    }
}
