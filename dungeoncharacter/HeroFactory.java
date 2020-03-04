public class HeroFactory {
	
	
	public Hero createHero(final int choice)
	{
		if(choice < 1 || choice > 3)
			throw new IllegalArgumentException("Please choose a proper class."); //change b4 master commit
         
     
         
		if(choice == 1)
			return new Warrior();
		else if (choice == 2)
			return new Sorceress();
		else if(choice == 3)
			return new Thief();
		
		return null;
	}
}

