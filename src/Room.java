import java.util.Random;
import java.util.Scanner;

public class Room {
    private boolean visited;

    // enter
    // if the player has already entered the room, inform the player.
    // if not, begin an encounter
    public void enter(Player player) {
        if(!visited) {
            runEncounter(player);
            visited = true;
        }
        System.out.println("You have already visited this room...");
    }

    // hasVisited
    // returns whether a room has already been visited
    public boolean hasVisited() {
        return this.visited;
    }

    // runEncounter
    // runs an encounter with the given player, randomly choosing from
    // a monster combat, finding a health elixir, and finding a bag of gold
    private void runEncounter(Player player) {
        Random r = new Random();
        int loot;
        int encounter = r.nextInt(99);
        if (encounter < 59) {
            runCombat(player);
        }
        // Player finds a healing elixir
        else if (encounter < 89) {
            loot = r.nextInt(25);
            player.onHeal(loot);
        }
        // Player finds a bag of gold
        else {
            loot = r.nextInt(30);
            player.onLoot(loot);
        }
        this.visited = true;
    }

    // runCombat
    // runs combat using the inputted player stats, ending combat when either one reaches zero health
    private void runCombat(Player player) {
        int action;
        Monster foe = new Monster();
        System.out.println("You open a door and move through ...");
        System.out.println("A " + foe.getType() + " appears!!\n");
        while (foe.getHealth() > 0 && player.getHealth() > 0) {
            switch (getAction()) {
                case 1:
                    foe.attack(player);
                    if (player.getHealth() > 0) {
                        player.attack(foe);
                    }
                    break;
                case 2:
                    System.out.println("You try to run ...");
                    foe.escapeAttack(player);
                    break;
            }
        }

        if (foe.getHealth() < 1) {
            System.out.println("The " + foe.getType() + " dies!");
        }
    }

    // getAction - prompts the user for 1 or 2, giving an error message on invalid input
    private int getAction() {
        Scanner s = new Scanner(System.in);
        int action = 0;
        while(action != 1 && action != 2) {
            System.out.println("Select an action: [1] Attack, [2] Run ==> ");
            if (!s.hasNextInt()) {
                System.out.println("Invalid selection, please try again...");
                s.next();
            } else {
                action = s.nextInt();
                if (action != 1 && action != 2) {
                    System.out.println("Invalid selection, please try again...");
                }
            }
        }
        return action;
    }
}
