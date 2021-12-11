import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameLogic {

    private Field field;

    GameLogic(Field field) {
        this.field = field;
    }



    public void description() {
        System.out.println();
        System.out.println("       Добро пожаловать в игру Камень, Ножницы, Бумага! ");
        System.out.println();
        System.out.println("            ====MENU====");
        System.out.println();
    }



    private void pcChoice() {
        field.setPcChoice((int)((Math.random()*3)+1));
    }

    public void gameChoice(Field f) throws IOException {

        int switchChoice;
        switchChoice = field.getHumanChoice();
        pcChoice();


        if(field.getPcChoice() == 1)
        {
            if(field.getHumanChoice() == 1)
                field.setHumanChoice(3);
            else if(field.getHumanChoice() == 2)
                field.setHumanChoice(2);
            else field.setHumanChoice(1);
        }

        else if(field.getPcChoice() == 2)
        {
            if(field.getHumanChoice() == 1)
                field.setHumanChoice(1);
            else if(field.getHumanChoice() == 2)
                field.setHumanChoice(3);
            else field.setHumanChoice(2);
        }

        else if(field.getPcChoice() == 3)
        {
            if(field.getHumanChoice() == 1)
                field.setHumanChoice(2);
            else if(field.getHumanChoice() == 2)
                field.setHumanChoice(1);
            else field.setHumanChoice(3);
        }

        if(switchChoice == 1)
            System.out.println("Вы выбрали: Камень");
        else if(switchChoice == 2)
            System.out.println("Вы выбрали: Ножницы");
        else if(switchChoice == 3)
            System.out.println("Вы выбрали: Бумагу");
        if(field.getPcChoice() == 1)
            System.out.println("ПК выбрал: Камень");
        else if(field.getPcChoice() == 2)
            System.out.println("ПК выбрал: Ножницы");
        else if(field.getPcChoice() == 3)
            System.out.println("ПК выбрал: Бумагу");


        switch (field.getHumanChoice()) {
            case 1 -> System.out.println("Победитель: ВЫ");
            case 2 -> System.out.println("Победитель: ПК");
            case 3 -> {
                System.out.println("НИЧЬЯ");
                start();
                gameChoice(field);
            }
        }
    }

    public void menuChoice() throws IOException {
        do {
            System.out.println("(1) : Ознакомиться с правилами игры");
            System.out.println("(2) : Приступить к игре");
            field.setHumanChoice(GameLogic.getInt());
        } while (field.getHumanChoice() < 1 || field.getHumanChoice() > 2);
    }



    public void launch() throws IOException {
        if(field.getHumanChoice() == 1)
        {
            System.out.println();
            System.out.println("""
                    Победитель определяется по правилам:
                    — камень побеждает ножницы (камень затупляет ножницы)
                    — ножницы побеждают бумагу (ножницы разрезают бумагу)
                    — бумага побеждает камень (бумага заворачивает камень)
                    — ничья, если у всех игроков одновременно показан одинаковый знак

                    Играют до тех пор, пока не останется один игрок. Он и будет победителем.""");
            System.out.println();
            start();
            gameChoice(field);
        }
        else if(field.getHumanChoice() == 2)
        {
            start();
            gameChoice(field);
        }
    }

    public void start() throws IOException {
        do {
            System.out.println("Для выбора, введите цифру: 1 - (Камень), 2 - (Ножницы), 3 - (Бумага)");
            field.setHumanChoice(GameLogic.getInt());
        } while(field.getHumanChoice() < 1 || field.getHumanChoice() > 3);
    }



    public static Integer getInt() throws IOException {
        return Integer.parseInt(getString());
    }

    public static String getString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }





}
