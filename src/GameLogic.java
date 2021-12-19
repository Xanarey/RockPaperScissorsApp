import java.util.Scanner;

public class GameLogic {
    enum MenuPoints { FIRSTPOINT, SECONDPOINT }
    private static MenuPoints menuPoints;

    private enum Figure { ROCK, PAPER, SCISSORS }
    private static Figure figure;

    private enum Winner { HUMANWON, PCWON, DRAW }
    private static Winner winner;

    private final Scanner sc = new Scanner(System.in);
    private Field field;

    GameLogic(Field field) {
        this.field = field;
    }



    public void start() {
        menuChoice();
        if(getByPoints(field.getHumanChoice()) == MenuPoints.FIRSTPOINT)
        {
            System.out.println(RULES);
            launch();
            gameChoice();
        }
        else if(getByPoints(field.getHumanChoice()) == MenuPoints.SECONDPOINT)
        {
            launch();
            gameChoice();
        }
    }

    private void menuChoice() {
        description();
        do {
            System.out.println(CHOICEMENU);
            field.setHumanChoice(sc.nextInt());

        } while (getByPoints(field.getHumanChoice()) != MenuPoints.FIRSTPOINT &&
                getByPoints(field.getHumanChoice()) != MenuPoints.SECONDPOINT);
    }

    private void launch() {
        do {
            System.out.println(CHOICE);
            field.setHumanChoice(sc.nextInt());
        } while(getByFigure(field.getHumanChoice()) != Figure.ROCK &&
                getByFigure(field.getHumanChoice()) != Figure.PAPER &&
                getByFigure(field.getHumanChoice()) != Figure.SCISSORS);
    }

    private void gameChoice() {
        pcChoice();

        if(getByFigure(field.getPcChoice()) == Figure.ROCK)
            if(getByFigure(field.getHumanChoice()) == Figure.ROCK)
                winner = Winner.DRAW;
            else if(getByFigure(field.getHumanChoice()) == Figure.SCISSORS)
                winner = Winner.PCWON;
            else
                winner = Winner.HUMANWON;
        if(getByFigure(field.getPcChoice()) == Figure.SCISSORS)
            if(getByFigure(field.getHumanChoice()) == Figure.SCISSORS)
                winner = Winner.DRAW;
            else if(getByFigure(field.getHumanChoice()) == Figure.PAPER)
                winner = Winner.PCWON;
            else
                winner = Winner.HUMANWON;
        if(getByFigure(field.getPcChoice()) == Figure.PAPER)
            if(getByFigure(field.getHumanChoice()) == Figure.PAPER)
                winner = Winner.DRAW;
            else if(getByFigure(field.getHumanChoice()) == Figure.ROCK)
                winner = Winner.PCWON;
            else
                winner = Winner.HUMANWON;

        System.out.println("HumanChoice: " + getByFigure(field.getHumanChoice()));
        System.out.println("PcChoice: " + getByFigure(field.getPcChoice()));

        switch (winner) {
            case HUMANWON -> System.out.println("Победитель: ВЫ");
            case PCWON -> System.out.println("Победитель: ПК");
            case DRAW -> {
                System.out.println("НИЧЬЯ");
                launch();
                gameChoice();
            }
        }
    }





    public Figure getByFigure(int i) {
        if(i == 1) figure = Figure.ROCK;
        if(i == 2) figure = Figure.PAPER;
        if(i == 3) figure = Figure.SCISSORS;
        return figure;
    }

    public MenuPoints getByPoints(int i) {
        if(i == 1) menuPoints = MenuPoints.FIRSTPOINT;
        if(i == 2) menuPoints = MenuPoints.SECONDPOINT;
        return menuPoints;
    }








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

    private void pcChoice() {
        field.setPcChoice((int)((Math.random()*3)+1));
    }

    private void description() {
        System.out.println(GREETINGS);
    }
}
