package dungeoncharacter;

public class MonsterFactory {
	
	public Monster createMonster(final String monsterName) {
		
		if(monsterName == null)
			throw new IllegalArgumentException("Please provide a supported monster type.");
		
		if(monsterName == "Ogre")
			return new Ogre();
		else if(monsterName == "Gremlin")
			return new Gremlin();
		else if(monsterName == "Skeleton")
			return new Skeleton();
		
		return null;
	}
}
