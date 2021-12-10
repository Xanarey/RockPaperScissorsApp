import java.io.*;


public class GameRunner {

    public static void main(String[] args) throws IOException {
        Field field = new Field();
        GameLogic gameLogic = new GameLogic(field);


        do {
            System.out.println("Выберите: 1(Камень), 2(Ножницы), 3(Бумага)");
            field.setHumanChoice(getInt());
        } while(field.getHumanChoice() <1 || field.getHumanChoice() > 3);

        gameLogic.gameChoice(field);
    }

    public static Integer getInt() throws IOException {
        return Integer.parseInt(getString());
    }

    public static String getString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

}
