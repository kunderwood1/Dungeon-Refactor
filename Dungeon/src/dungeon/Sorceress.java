package Dungeon.src.dungeon;

import java.util.Scanner;

public class Sorceress extends Hero implements Attack{
	Hero chara;
	private final int MIN_ADD = 25;
	private final int MAX_ADD = 50;

//-----------------------------------------------------------------
    public Sorceress()
	{
		super("Sorceress", 75, 5, .7, 25, 50, .3);


    }//end constructor

//-----------------------------------------------------------------
	public void increaseHitPoints()
    {
	    int hPoints;

		hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		addHitPoints(hPoints);
		System.out.println(getName ()+ " added [" + hPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ getHitPoints());
		 System.out.println();

    }//end increaseHitPoints method


	@Override
	public void characterAttack(DungeonCharacter opponent)
	{
		System.out.println(getName()+ " casts a spell of fireball at " +
							opponent.getName() + ":");
		superAttack(opponent);
	}//end override of attack method

//-----------------------------------------------------------------
    public void battleChoices(DungeonCharacter opponent)
	{
    	Scanner kb = new Scanner(System.in);
		super.battleChoices(opponent);
		int choice;

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Increase Hit Points");
		    System.out.print("Choose an option: ");
		    
		    choice = kb.nextInt();
		    switch (choice)
		    {
			    case 1: characterAttack(opponent);
			        break;
			    case 2: increaseHitPoints();
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			numTurns--;
		    if (getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + getNumTurns());

		} while(getNumTurns() > 0 && getHitPoints() > 0 && opponent.getHitPoints() > 0);
		kb.close();
    }//end overridden method


	
}
