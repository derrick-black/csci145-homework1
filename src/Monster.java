
public class Monster {
    private int health;
    private int damage;
    private String monsterType;

    public void attack(Player target) {

    }

    public void escapeAttack(Player player) {
        // this differs from attack() in its console output
        // it is called when a player chooses to run
        // it is identical in all other ways
    }

    public void onHit(int damage) {

    }

    // accessor methods

    public String getType() {
        return null;
    }

    public int getHealth() {
        return 0;
    }


}
