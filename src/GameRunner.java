import java.io.*;


public class GameRunner {

    public static void main(String[] args) throws IOException {
        Field field = new Field();
        GameLogic gameLogic = new GameLogic(field);

        System.out.println();
        System.out.println("       Добро пожаловать в игру Камень, Ножницы, Бумага! ");

        do {
            System.out.println("Для выбора, введите цифру: 1 - (Камень), 2 - (Ножницы), 3 - (Бумага)");
            field.setHumanChoice(GameLogic.getInt());
        } while(field.getHumanChoice() < 1 || field.getHumanChoice() > 3);

        gameLogic.gameChoice(field);
    }



}
