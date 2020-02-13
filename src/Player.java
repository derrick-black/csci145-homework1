import java.awt.geom.Point2D;

public class Player {
    private int health;
    private int gold;
    private int damage;
    private String playerClass;
    private double lootModifier;
    private Point2D coordinates;

    public Player(String playerClass){
        gold = 0;
        coordinates.setLocation(0,0);

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
    }

    public void attack(Monster target) {
        target.onHit(damage);
        System.out.println("The player attacks the " + target.getType() + " dealing " + damage + " damage!");
    }

    public void onHit(int damage) {
        health -= damage;

    }

    public void onHeal(int health) {
        this.health += health;
        System.out.println ("You found a healing potion that has restored your vigor, you gained" + health + "health. Your health is now " + this.health + " health!");
    }

    public void onLoot(int gold) {
        this.gold += (gold * lootModifier);
        System.out.println("You found " + gold + " gold! You now have " + this.gold + "gold!");
        if (this.gold < 100) {
            System.out.println ("Only " + (100 - this.gold) + " gold left!");
        }
    }



    public void setCoordinates(int x, int y) {
        coordinates.setLocation(x, y);
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

    public Point2D getPosition() {
        return coordinates;
    }
}
