import java.util.Random;
import java.util.Scanner;

public class Room {
    public boolean visited=false;
	private Random rand;
	private Monster monst;
	private Scanner scan=new Scanner(System.in);
	private Player player;

	public Room(){rand = new Random();}
	
    public void enter(Player player) {
		boolean playing=false;
		this.player=player;
		if(visited==false){
			visited=true;
			if(rand.nextInt(2)==0){
				monst = getMonster();
				playing =true;
			}else{
				if(rand.nextInt(2)==0){
					int gold = rand.nextInt(27)+1;
					System.out.println("You find a bag of "+gold+" gold pieces");
					player.onLoot(gold);
				}else{
					int health = rand.nextInt(20)+1;
					player.onHeal(health);
					System.out.println("You find a healing elixir and are healed by "+health+" hp!!");
				}
			}
		}
		if(monst!=null && monst.health>0) playing=true;
		if(playing){
			System.out.println("A "+monst.monsterType+" appears!!");
			while(playing){
				System.out.print("Select an action: [1] Attack, [2] Run ==> ");
				int choice = getInt();
				if(choice==1){
					monst.attack(player);
					if(FightOver()) return;
					player.attack(monst);
					if(FightOver()) return;
				}else{
					System.out.println("You try to run...");
					monst.attack(player);
					return;
				}
			}
		}
    }
	
	private boolean FightOver(){
		if(monst.health<=0) return true;
		if(player.health<=0) return true;
		return false;
	}
	
	private int getInt(){
		while(true){
			boolean test=false;
			if(scan.hasNextInt()){
				 int num = scan.nextInt();
				 test=true;
				 if(num ==1 || num==2) return num;
			}
			if(!test)
			scan.next();
			System.out.println("Invalid input.");
		}
	}
	
	private Monster getMonster(){
		Monster monst = new Monster();
		int num = rand.nextInt(4);
		if(num==0){
				monst.monsterType = "Goblin";
				monst.health = 6;
				monst.damage = 10;
		}else if(num==1){
				monst.monsterType = "Zombie";
				monst.health = 12;
				monst.damage = 15;
		}else if(num==2){
				monst.monsterType = "Orc";
				monst.health = 18;
				monst.damage = 20;
		}else{
				monst.monsterType = "Deneke";
				monst.health = 55;
				monst.damage = 5;
		}
		return monst;
	}

    public boolean hasVisited() {
        return this.visited;
    }
}
