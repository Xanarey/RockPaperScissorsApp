import java.util.Scanner;

public class GameLogic {

    private enum Figure {

    }

    private final Scanner sc = new Scanner(System.in);

    public Figure getByValue(int i) {
                                        //TODO вечером
        return null;
    }

    private void gameChoice() {

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
                launch();
                gameChoice();
            }
        }
    }

    private Field field;
    private static final String RULES = "\"\"\"\n" +
            "                    Победитель определяется по правилам:\n" +
            "                    — камень побеждает ножницы (камень затупляет ножницы)\n" +
            "                    — ножницы побеждают бумагу (ножницы разрезают бумагу)\n" +
            "                    — бумага побеждает камень (бумага заворачивает камень)\n" +
            "                    — ничья, если у всех игроков одновременно показан одинаковый знак\n" +
            "\n" +
            "                      Играют до тех пор, пока не останется один игрок. Он и будет победителем.\"\"\"";
    private static final String CHOICEMENU = "(1) : Ознакомиться с правилами игры\n" +
                                   "(2) : Приступить к игре";
    private static final String GREETINGS = "\n"+"       Добро пожаловать в игру Камень, Ножницы, Бумага!\n " +
            "\n" +
            "            ====MENU====";
    private static final String CHOICE = "Для выбора, введите цифру: 1 - (Камень), 2 - (Ножницы), 3 - (Бумага)";




    GameLogic(Field field) {
        this.field = field;
    }

    public void start() {
        menuChoice();
        if(field.getHumanChoice() == 1)
        {
            System.out.println(RULES);
            launch();
            gameChoice();
        }
        else if(field.getHumanChoice() == 2)
        {
            launch();
            gameChoice();
        }
    }

    private void pcChoice() {
        field.setPcChoice((int)((Math.random()*3)+1));
    }



    private void menuChoice() {
        description();
        do {
            System.out.println(CHOICEMENU);
            field.setHumanChoice(sc.nextInt());
        } while (field.getHumanChoice() < 1 || field.getHumanChoice() > 2);
    }

    private void launch() {
        do {
            System.out.println(CHOICE);
            field.setHumanChoice(sc.nextInt());
        } while(field.getHumanChoice() < 1 || field.getHumanChoice() > 3);
    }

    private void description() {
        System.out.println(GREETINGS);
    }
}
