import java.awt.*;

public class Player {
    private int health;
    private int maxHealth;
    private int gold;
    private int damage;
    private String playerClass;
    private double lootModifier;
    private Point coordinates;

    public Player(String playerClass){
        gold = 0;
        coordinates = new Point (0, 0);
        this.playerClass = playerClass;
        switch(playerClass){
            case "Warrior":
                health = 100;
                lootModifier = 1.0;
                damage = 15;
                break;
            case "Thief":
                health = 70;
                lootModifier = 1.2;
                damage = 10;
                break;
        }
        maxHealth = health;
    }

    public void attack(Monster target) {
        target.onHit(damage);
        System.out.println("You attack the " + target.getType() + " dealing " + damage + " damage!");
    }

    public void onHit(int damage) {
        health -= damage;

    }

    public void onHeal(int health) {
        this.health += health;
        if (health > maxHealth) {
            health = maxHealth;
        }
        System.out.println ("You found a healing potion that has restored your vigor, you gained " + health + " health. Your health is now " + this.health + " health!");
    }

    public void onLoot(int gold) {
        this.gold += (gold * lootModifier);
        System.out.println("You found " + gold + " gold! You now have " + this.gold + " gold!");
        if (this.gold < 100) {
            System.out.println ("Only " + (100 - this.gold) + " gold left!");
        }
    }

    public void setCoordinates(Point newPosition) {
        coordinates.setLocation(newPosition);
    }

    // accessor methods

    public int getHealth() {
        return health;
    }

    public int getGold() {
        return gold;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public int getX() {
        return (int)coordinates.getX();
    }

    public int getY() {
        return (int)coordinates.getY();
    }
}
