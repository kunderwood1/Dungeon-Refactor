

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

import java.util.Scanner;

public class Thief extends Hero
{

    public Thief()
	{
		super("Thief", 75, 6, .8, 20, 40, .5);



    }//end constructor

	public void surpriseAttack(DungeonCharacter opponent)
	{
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								super.getNumTurns() + " gets an additional turn.");
			
         super.setNumTurns(super.getNumTurns() + 1);
			attack(opponent);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		    attack(opponent);


	}//end surpriseAttack method


    public void battleChoices(DungeonCharacter opponent)
	 {
      Scanner kb = new Scanner(System.in);
		super.battleChoices(opponent);
		int choice;


		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Surprise Attack");
		    System.out.print("Choose an option: ");
		    choice = Integer.getInteger(kb.nextLine());
          kb.nextLine();

		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: surpriseAttack(opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			super.setNumTurns(super.getNumTurns() - 1);
			if (super.getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + super.getNumTurns());

		} while(super.getNumTurns() > 0);
      
      kb.close();

    }
}