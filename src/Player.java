
public class Player {
    private int health;
    private int gold;
    private int damage;
    private String playerClass;
    private double lootModifier;

    public void attack(Monster target) {

    }

    public Player(){}

    public void onHit(int damage) {

    }

    public void onHeal(int health) {

    }

    public void onLoot(int gold) {

    }

    // accessor methods

    public int getHealth() {
        return 0;
    }

    public int getGold() {
        return 0;
    }

    public String getPlayerClass() {
        return null;
    }
}
