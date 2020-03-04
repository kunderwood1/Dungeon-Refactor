

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

import java.util.Scanner;

public class Sorceress extends Hero
{
	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;

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
		System.out.println(super.getName() + " added [" + hPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ super.getHitPoints());
		 System.out.println();

    }//end increaseHitPoints method

//-----------------------------------------------------------------
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(super.getName() + " casts a spell of fireball at " +
							opponent.getName() + ":");
		super.attack(opponent);
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
		    choice = Integer.getInteger(kb.nextLine());
          kb.nextLine();

		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: increaseHitPoints();
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			super.setNumTurns(super.getNumTurns() - 1);
			if (super.getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + super.getNumTurns());

		} while(super.getNumTurns() > 0 && super.getHitPoints() > 0 && opponent.getHitPoints() > 0);
      
      kb.close();

    }//end overridden method

}//end class