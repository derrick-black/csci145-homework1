
public class Player {
    public int health;
	public int x;
	public int y;
    public int gold;
    public int damage;
    public String playerClass;
    public double lootModifier=1d;

    public void attack(Monster target) {
		target.onHit(damage);
    }

    public Player(){
		x=0; y=0;
	}

    public void onHit(int damage) {
		health-=damage;
    }

    public void onHeal(int health) {
		this.health+=health;
    }

    public void onLoot(int gold) {
		this.gold+=(int)(gold*lootModifier);
    }
}
