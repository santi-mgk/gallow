package MainGame;

public class Gallow {

    public static void drawGallow(String[][] gallow, int count) {

        switch (count) {
            case (6):
                for (int i = 0; i < gallow.length; i++) {
                    for (int j = 0; j < gallow[i].length; j++) {
                        gallow[i][j] = " ";
                    }
                }
                for (int i = 0; i < gallow[0].length; i++) {
                    gallow[0][i] = "_";
                }
                gallow[1][gallow[1].length - 2] = "|";
                for (int i = 1; i < gallow.length - 1; i++) {
                    gallow[i][0] = "|";
                }
                break;
            case (5):
                gallow[2][9] = "0";
                break;
            case (4):
                gallow[3][9] = "|";
                break;
            case (3):
                gallow[3][8] = "/";
                break;
            case (2):
                gallow[3][10] = "\\";
                break;
            case (1):
                gallow[4][8] = "/";
                break;
            case (0):
                gallow[4][10] = "\\";
                break;
        }
    }

    public static void showGallow(String[][] gallow) {
        for (int i = 0; i < gallow.length; i++) {
            for (int j = 0; j < gallow[i].length; j++) {
                System.out.print(gallow[i][j]);
            }
            System.out.println("");
        }
    }
}
