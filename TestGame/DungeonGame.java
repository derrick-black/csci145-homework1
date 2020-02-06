import java.util.Scanner;

public class DungeonGame {
    private DungeonMap map;
    private Player player;
	private int width;
	private int height;

    public DungeonGame(int width, int height){
		player = new Player();
		map = new DungeonMap(width,height,player);
		this.width=width;
		this.height=height;
    }

    private int getInt(Scanner s){
		while(true){
			boolean test=false;
			if(s.hasNextInt()){
				int num = s.nextInt();
				test=true;
				if(num==1 || num==2) return num;
			}
			System.out.println("Invalid input.");
			if(!test)
			s.next();
		}
	}
	
	private char getChar(Scanner s){
		while(true){
			char temp = s.next().charAt(0);
			char[] chars = {'w','a','s','d','W','A','S','D'};
			for(int i=0; i<chars.length; i++){
				if(chars[i]==temp) return chars[i%4];
			}
			System.out.println("Invalid input.");
		}
	}

    public void play() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Select your class:\n[1] Warrior\n[2] Thief");
		int playerClass = getInt(scan);
		String[] classes = {"Warrior", "Thief"};
		player.playerClass = classes[playerClass-1];
		if(playerClass==1) {player.health=100; player.damage = 15; player.lootModifier=1d;}
		else {player.health=75; player.damage = 10; player.lootModifier=1.2d;}
		boolean running=true;
		while(running){
			map.print();
			System.out.println("GP = "+player.gold);
			System.out.println("HP = "+player.health);
			boolean cantMove=false;
			char choice;
			do{
				cantMove=false;
				System.out.print("\nSelect a door: [W] up, [S] down, [A] left, [D] right ==> ");
				choice = getChar(scan);
				if(player.y==0 && choice=='w') cantMove=true;
				if(player.y==height-1 && choice=='s') cantMove=true;
				if(player.x==0 && choice=='a') cantMove=true;
				if(player.x==width-1 && choice=='d') cantMove=true;
				if(cantMove) System.out.println("There is a wall blocking your path.");
			}while(cantMove);
			if(choice=='w'){
				player.y--;
			}else if(choice=='s'){
				player.y++;
			}else if(choice=='a'){
				player.x--;
			}else if(choice=='d'){
				player.x++;
			}
			map.enterRoom();
			if(player.health<=0){
				System.out.println("Your hp hit 0. You died.");
				running=false;
			}
			if(player.gold>=100){
				System.out.println("You have successfully exited the dungeon. Congratulations!!");
				running=false;
			}
		}
    }
}