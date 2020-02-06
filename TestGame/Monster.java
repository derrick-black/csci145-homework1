import java.util.Random;

public class Monster {
    public int health;
    public int damage;
    public String monsterType;
	private static Random r = new Random();

	public Monster(){}
	
    public void attack(Player target) {
		int dam = r.nextInt(damage)+1;
		target.onHit(dam);
		System.out.println("The "+monsterType+" attacks you for "+dam+" damage.");
    }

    public void onHit(int damage) {
		health-=damage;
		System.out.println("You attack and hit the "+monsterType+" for "+damage+" damage.");
    }
}
