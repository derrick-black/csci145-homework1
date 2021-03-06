import java.util.Random;

public class Monster {
    private int health;
    private int damage;
    private String monsterType;
    private Random r = new Random();

    public Monster(){
        Random choice_generator = new Random();
        int monsterChoice = choice_generator.nextInt(4);
        switch(monsterChoice) {
            case 0:
                monsterType = "Deneke";
                health = 55;
                damage = 5;
                break;
            case 1:
                monsterType = "Orc";
                health = 18;
                damage = 20;
                break;
            case 2:
                monsterType = "Goblin";
                health = 6;
                damage = 10;
                break;
            case 3:
                monsterType = "Zombie";
                health = 12;
                damage = 15;
                break;
        }
    }

    public void attack(Player target) {
        int hitDamage = r.nextInt(damage + 1);
        target.onHit(hitDamage);
        System.out.println("The " + monsterType + " deals " + hitDamage + " damage to you!");
    }

    public void escapeAttack(Player target) {
        int hitDamage = r.nextInt(damage + 1);
        target.onHit(hitDamage);
        System.out.println("The " + monsterType + " deals " + hitDamage + " damage to you as you escape!");
    }

    public void onHit(int damage) {
        health -= damage;
    }

    // accessor methods

    public String getType() {
        return monsterType;
    }

    public int getHealth() {
        return health;
    }


}
