import java.io.*;


public class GameRunner {

    public static void main(String[] args) throws IOException {
        Field field = new Field();
        GameLogic gameLogic = new GameLogic(field);

        gameLogic.description();

        gameLogic.menuChoice();

        gameLogic.launch();
    }
}
