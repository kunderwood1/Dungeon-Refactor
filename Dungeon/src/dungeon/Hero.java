package Dungeon.src.dungeon;


public abstract class Hero extends DungeonCharacter{
	private double chanceToBlock;
	protected int numTurns;

	
	
	
public double getChanceToBlock() {
		return chanceToBlock;
	}


	public void setChanceToBlock(double chanceToBlock) {
		this.chanceToBlock = chanceToBlock;
	}


	public int getNumTurns() {
		return numTurns;
	}


	public void setNumTurns(int numTurns) {
		this.numTurns = numTurns;
	}


//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
  public Hero(String name, int hitPoints, int attackSpeed,double chanceToHit, int damageMin, int damageMax,double chanceToBlock)
  {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
	this.chanceToBlock = chanceToBlock;
	setName(super.getName());
  }

 
  public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }//end defend method


public void subtractHitPoints(int hitPoints)
	{
		if (defend())
		{
			System.out.println(getName() + " BLOCKED the attack!");
		}
		else
		{
			super.subtractHitPoints(hitPoints);
		}


	}//end method

	public void battleChoices(DungeonCharacter opponent)
	{
	    numTurns = getAttackSpeed()/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}//end battleChoices
}
