package dungeoncharacter;

public class HeroFactory {
	
	
	public Hero createHero(String name)
	{
		if(name == null)
			throw new IllegalArgumentException("Please choose a proper class."); //change b4 master commit
		
		
		if(name == "Warrior")
			return new Warrior();
		else if (name == "Thief")
			return new Thief();
		else if(name == "Sorceress")
			return new Sorceress();
		
		return null;
	}
}

