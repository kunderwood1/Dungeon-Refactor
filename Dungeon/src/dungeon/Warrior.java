package Dungeon.src.dungeon;

import java.util.Scanner;

public class Warrior extends Hero implements Attack {

	public Warrior()
	{

		super("Warrior", 125, 4, .8, 35, 60, .2);


    }//end constructor


	public void crushingBlow(DungeonCharacter opponent)
	{
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(getName() + " lands a CRUSHING BLOW for " + blowPoints
								+ " damage!");
			opponent.subtractHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(getName()+ " failed to land a crushing blow");
			System.out.println();
		}//blow failed

	}//end crushingBlow method

	public void characterAttack(DungeonCharacter opponent)
	{
		System.out.println(getName ()+ " swings a mighty sword at " +
							opponent.getName() + ":");
		superAttack(opponent);
	}//end override of attack method




    public void battleChoices(DungeonCharacter opponent)
	{
		int choice;

		super.battleChoices(opponent);
		Scanner kb = new Scanner(System.in);

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Crushing Blow on Opponent");
		    System.out.print("Choose an option: ");
		   // choice = Keyboard.readInt();
		    choice = kb.nextInt();
		    switch (choice)
		    {
			    case 1: characterAttack(opponent);
			        break;
			    case 2: crushingBlow(opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			numTurns--;
			if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);
		kb.close();
    }//end battleChoices method

}
