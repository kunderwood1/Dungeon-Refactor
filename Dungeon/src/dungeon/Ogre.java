package Dungeon.src.dungeon;

public class Ogre extends Monster implements Attack{

	 public Ogre()
		{
			super("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50);


	    }//end constructor

	@Override
	public void characterAttack(DungeonCharacter opponant) {
		System.out.println(getName() + " slowly swings a club toward's " +
				opponant.getName() + ":");
			super.superAttack(opponant);
	}

	

}
