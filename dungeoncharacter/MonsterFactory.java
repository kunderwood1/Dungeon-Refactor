public class MonsterFactory {
	
	public Monster createMonster(final int choice) {
		
		if(choice < 0 || choice > 2)
			throw new IllegalArgumentException("Please provide a supported monster type.");
		
		if(choice == 0)
			return new Ogre();
		else if(choice == 1)
			return new Gremlin();
		else if(choice == 2)
			return new Skeleton();
		
		return null;
	}
}
