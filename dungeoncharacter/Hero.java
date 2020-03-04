

import java.util.Scanner;
public abstract class Hero extends DungeonCharacter
{
	private double chanceToBlock;
	private int numTurns;

//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
  public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
  {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
	
   setChanceToBlock(chanceToBlock);
	readName();
  }
  
  public void setChanceToBlock(final double chanceToBlock) { this.chanceToBlock = chanceToBlock;}
  public void setNumTurns(final int numTurns) {this.numTurns = numTurns;}
  
  public double getChanceToBlock() {return this.chanceToBlock;}
  public int getNumTurns() {return this.numTurns;}


  public void readName()
  {
      Scanner kb = new Scanner(System.in);
		System.out.print("Enter character name: ");
		super.setName(kb.nextLine());
      
      kb.close();
  }//end readName method

  public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }//end defend method

public void subtractHitPoints(int hitPoints)
	{
		if (defend())
		{
			System.out.println(super.getName() + " BLOCKED the attack!");
		}
		else
		{
			super.subtractHitPoints(hitPoints);
		}


	}//end method

/*-------------------------------------------------------
battleChoices will be overridden in derived classes.  It computes the
number of turns a hero will get per round based on the opponent that is
being fought.  The number of turns is reported to the user.  This stuff might
go better in another method that is invoked from this one...

Receives: opponent
Returns: nothing

This method calls: getAttackSpeed()
This method is called by: external sources
---------------------------------------------------------*/
	public void battleChoices(DungeonCharacter opponent)
	{
	    numTurns = super.getAttackSpeed()/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}//end battleChoices

}//end Hero class