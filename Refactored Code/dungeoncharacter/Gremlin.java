package dungeoncharacter;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Gremlin extends Monster
{

    public Gremlin()
	{
		super("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);

    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(name + " jabs his kris at " +
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


}//end class Gremlin