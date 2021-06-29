package dungeoncharacter;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Skeleton extends Monster
{

    public Skeleton()
	{
		super("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);

    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(name + " slices his rusty blade at " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack

	@Override
	public int addHP(int amountHealed) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int subHP(int damageDealt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void specialAttack(DungeonCharacter oppontent) {
		// TODO Auto-generated method stub
		
	}


}//end class Skeleton