import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameLogic {

    private Field field;

    GameLogic(Field field) {
        this.field = field;
        pcChoice();
    }

    private void pcChoice() {
        field.setPcChoice((int)((Math.random()*3)+1));
    }

    public void gameChoice(Field f) {

        int switchChoice;
        switchChoice = field.getHumanChoice();



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
            case 3 -> System.out.println("НИЧЬЯ");
        }
    }

    public static Integer getInt() throws IOException {
        return Integer.parseInt(getString());
    }

    public static String getString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

}
