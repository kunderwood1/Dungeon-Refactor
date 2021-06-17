package Dungeon.src.dungeon;

public class Gremlin extends Monster implements Attack {
	
	 public Gremlin()
		{
			super("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);

	    }//end constructor

	@Override
	public void characterAttack(DungeonCharacter opponant) {
		
		System.out.println(getName() + " jabs his kris at " +
				opponant.getName() + ":");
				super.superAttack(opponant);
	}

	

}
