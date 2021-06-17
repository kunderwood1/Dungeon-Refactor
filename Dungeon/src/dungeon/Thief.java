package Dungeon.src.dungeon;

import java.util.Scanner;

public class Thief extends Hero implements Attack{
	
	

	public Thief()
	{
		super("Thief", 75, 6, .8, 20, 40, .5);



    }//end constructor

	@Override
	public void characterAttack(DungeonCharacter opponent)
	{
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								getName ()+ " gets an additional turn.");
			numTurns++;
			super.superAttack(opponent);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		    super.superAttack(opponent);


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
		    // changing Keyboard clas to Scanner 
		    
		    //choice = Keyboard.readInt();
		    choice = kb.nextInt();
		    switch (choice)
		    {
			    case 1: characterAttack(opponent);
			        break;
			    case 2: superAttack(opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			numTurns--;
			if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);
		kb.close();
    }

}
