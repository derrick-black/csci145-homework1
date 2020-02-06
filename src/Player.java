
public class Player {
    private int health;
    private int gold;
    private int damage;
    private String playerClass;
    private double lootModifier;
    private int[] coordinates;

    public void attack(Monster target) {

    }

    public Player(){}

    public void onHit(int damage) {

    }

    public void onHeal(int health) {

    }

    public void onLoot(int gold) {

    }

    public void setCoordinates(int x, int y) {

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

    public int getX() {
        return 0;
    }

    public int getY() {
        return 0;
    }
}
