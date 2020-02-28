import java.util.Scanner;

public class Dungeon  {

    public static void main(String[] args){
            Hero theHero;
            Monster theMonster;
            String playGame;
            Scanner kb = new Scanner(System.in);
            do {
                theHero = chooseHero();
                theMonster = generateMonster();
                battle(theHero,theMonster);
                System.out.println("Play again (y/n)?");
                playGame = kb.nextLine();
            } while (playGame == "y");
        }//end main method

/*-------------------------------------------------------------------
chooseHero allows the user to select a hero, creates that hero, and
returns it.  It utilizes a polymorphic reference (Hero) to accomplish
this task
---------------------------------------------------------------------*/
        public static Hero chooseHero(){
            Scanner kb = new Scanner(System.in);
            int choice;

            System.out.println("Choose a hero:\n" +
                    "1. Warrior\n" +
                    "2. Sorceress\n" +
                    "3. Thief");
            choice = kb.nextInt();

            switch(choice)
            {
                case 1: return new Warrior();

                case 2: return new Sorceress();

                case 3: return new Thief();

                default: System.out.println("invalid choice, returning Thief");
                    return new Thief();
            }//end switch
        }//end chooseHero method

/*-------------------------------------------------------------------
generateMonster randomly selects a Monster and returns it.  It utilizes
a polymorphic reference (Monster) to accomplish this task.
---------------------------------------------------------------------*/
        public static Monster generateMonster()
        {
            int choice;

            choice = (int)(Math.random() * 3) + 1;

            switch(choice)
            {
                case 1: return new Ogre();

                case 2: return new Gremlin();

                case 3: return new Skeleton();

                default: System.out.println("invalid choice, returning Skeleton");
                    return new Skeleton();
            }//end switch
        }//end generateMonster method


/*-------------------------------------------------------------------
battle is the actual combat portion of the game.  It requires a Hero
and a Monster to be passed in.  Battle occurs in rounds.  The Hero
goes first, then the Monster.  At the conclusion of each round, the
user has the option of quitting.
---------------------------------------------------------------------*/
        public static void battle(Hero theHero, Monster theMonster)
        {
            Scanner kb = new Scanner(System.in);
            String pause = "p";
            System.out.println(theHero.getName() + " battles " +
                    theMonster.getName());
            System.out.println("---------------------------------------------");

            //do battle
            while (theHero.hitPoints > 0 && theMonster.hitPoints > 0 && !pause.equals("q"))
            {
                //hero goes first
                theHero.battleChoices(theMonster);

                //monster's turn (provided it's still alive!)
                if (theMonster.hitPoints > 0)
                    theMonster.attack(theHero);

                //let the player bail out if desired
                System.out.print("\n-->q to quit, anything else to continue: ");
                pause = kb.nextLine();

            }//end battle loop

            if (theMonster.hitPoints == 0)
                System.out.println(theHero.getName() + " was victorious!");
            else if (theHero.hitPoints == 0)
                System.out.println(theHero.getName() + " was defeated :-(");
            else//both are alive so user quit the game
                System.out.println("Quitters never win ;-)");

        }//end battle method
    }

