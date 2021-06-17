package Dungeon.src.dungeon;

public class Skeleton extends Monster implements Attack{

	public Skeleton () {
		super("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);

	}

	@Override
	public void characterAttack(DungeonCharacter opponant) {
		
		System.out.println(getName() + " slices his rusty blade at " +
				opponant.getName() + ":");
				superAttack(opponant);
	}
}