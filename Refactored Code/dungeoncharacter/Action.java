package dungeoncharacter;

public interface Action {
	public abstract int addHP(final int amountHealed);
	public abstract int subHP(final int damageDealt);
	public abstract void attack(final DungeonCharacter opponent);
	public abstract void specialAttack(final DungeonCharacter oppontent);
}
