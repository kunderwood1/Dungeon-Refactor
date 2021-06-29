package dungeoncharacter;

/**
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public abstract class DungeonCharacter implements Action
{
	//Need to change into factory pattern strategy
	
	protected String name;
	protected int hitPoints;
	protected int attackSpeed;
	private double chanceToHit;
	private int damageMin;
	private int damageMax;
	public DungeonCharacter(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax)
	{
		setName(name);
		setHP(hitPoints);
		setAS(attackSpeed);
		setChanceToHit(chanceToHit);
		setDamageVariance(damageMin, damageMax);
	}//end constructor
	
	public void setName(final String name) { this.name = name; }
	public void setHP(final int hitPoints) { this.hitPoints = hitPoints; }
	public void setAS(final int attackSpeed) { this.attackSpeed = attackSpeed; }
	public void setChanceToHit(final double chanceToHit) { this.chanceToHit = chanceToHit; }
	public void setDamageVariance(final int damageMin, final int damageMax) { this.damageMin = damageMin; this.damageMax = damageMax; }

	public String getName() { return name; }
	public int getHitPoints() { return hitPoints; }
	public int getAttackSpeed() { return attackSpeed; }


	public void addHitPoints(int hitPoints)
	{
		if (hitPoints <=0)
			System.out.println("Hitpoint amount must be positive.");
		else
		{
			this.hitPoints += hitPoints;
			//System.out.println("Remaining Hit Points: " + hitPoints);

		}
	}//end addHitPoints method

public void subtractHitPoints(int hitPoints)
	{
		if (hitPoints <0)
			System.out.println("Hitpoint amount must be positive.");
		else if (hitPoints >0)
		{
			this.hitPoints -= hitPoints;
			if (this.hitPoints < 0)
				this.hitPoints = 0;
			System.out.println(getName() + " hit " +
								" for <" + hitPoints + "> points damage.");
			System.out.println(getName() + " now has " +
								getHitPoints() + " hit points remaining.");
			System.out.println();
		}//end else if

		if (this.hitPoints == 0)
			System.out.println(name + " has been killed :-(");


	}//end method

    public boolean isAlive()
	{
	  return (hitPoints > 0);
	}//end isAlive method

	public void attack(DungeonCharacter opponent)
	{
		boolean canAttack;
		int damage;

		canAttack = Math.random() <= chanceToHit;

		if (canAttack)
		{
			damage = (int)(Math.random() * (damageMax - damageMin + 1))
						+ damageMin ;
			opponent.subtractHitPoints(damage);



			System.out.println();
		}//end if can attack
		else
		{

			System.out.println(getName() + "'s attack on " + opponent.getName() +
								" failed!");
			System.out.println();
		}//end else

	}//end attack method
}
