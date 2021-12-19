import java.io.*;


public class GameRunner {

    public static void main(String[] args) throws IOException {
        Field field = new Field();
        GameLogic gl = new GameLogic(field);
        gl.start();
    }
}
