import java.util.Scanner;

public class Dungeon {

    public static void main(String[] args) {
        Hero theHero;
        Monster theMonster;
        String playGame;
        Scanner kb = new Scanner(System.in);
        do {
            theHero = chooseHero();
            theMonster = generateMonster();
            battle(theHero, theMonster);
            System.out.println("Play again (y/n)?");
            playGame = kb.nextLine();
        } while (playGame.equals("y"));
    }

    public static Hero chooseHero() {
        Scanner kb = new Scanner(System.in);
        int choice;

        System.out.println("Choose a hero:\n" +
                "1. Warrior\n" +
                "2. Sorceress\n" +
                "3. Thief");
        choice = kb.nextInt();

        switch (choice) {
            case 1:
                return new Warrior();

            case 2:
                return new Sorceress();

            case 3:
                return new Thief();

            default:
                System.out.println("invalid choice, returning Thief");
                return new Thief();
        }
    }

    public static Monster generateMonster() {
        int choice;

        choice = (int) (Math.random() * 3) + 1;

        switch (choice) {
            case 1:
                return new Ogre();

            case 2:
                return new Gremlin();

            case 3:
                return new Skeleton();

            default:
                System.out.println("invalid choice, returning Skeleton");
                return new Skeleton();
        }
    }

    public static void battle(Hero theHero, Monster theMonster) {
        Scanner kb = new Scanner(System.in);
        String pause = "p";
        System.out.println(theHero.getName() + " battles " +
                theMonster.getName());
        System.out.println("---------------------------------------------");


        while (theHero.hitPoints > 0 && theMonster.hitPoints > 0 && !pause.equals("q")) {
            theHero.battleChoices(theMonster);
            if (theMonster.hitPoints > 0)
                theMonster.attack(theHero);
            System.out.print("\n-->q to quit, anything else to continue: ");
            pause = kb.nextLine();
        }

        if (theMonster.hitPoints == 0)
            System.out.println(theHero.getName() + " was victorious!");
        else if (theHero.hitPoints == 0)
            System.out.println(theHero.getName() + " was defeated :-(");
        else
            System.out.println("Quitters never win ;-)");
    }
}

