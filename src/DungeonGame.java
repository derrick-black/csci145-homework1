import java.util.Scanner;

public class DungeonGame {
    private DungeonMap map;
    private Player player;
	private int width;
	private int height;

    public DungeonGame(int width, int height){
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
    	playIntro();
		Scanner scan = new Scanner(System.in);
		System.out.println("Select your class:\n[1] Warrior\n[2] Thief");
		int playerClass = getInt(scan);
		String[] classes = {"Warrior", "Thief"};
		player = new Player(classes[playerClass-1]);
		map = new DungeonMap(width,height,player);
		Room currentPlayerRoom = null;

		boolean running=true;
		while(running){
			map.print();
			System.out.println("GP = "+player.getGold());
			System.out.println("HP = "+player.getHealth());
			char choice;
			System.out.print("\nSelect a door: [W] up, [S] down, [A] left, [D] right ==> ");
			choice = getChar(scan);
			switch (choice) {
				case 'w':
					currentPlayerRoom = map.movePlayer(0,-1);
					break;
				case 's':
					currentPlayerRoom = map.movePlayer(0, 1);
					break;
				case 'a':
					currentPlayerRoom = map.movePlayer(-1, 0);
					break;
				case 'd':
					currentPlayerRoom = map.movePlayer(1,0);
					break;
			}
			if(currentPlayerRoom != null) {
				currentPlayerRoom.enter(player);
			}

			if(player.getHealth()<=0){
				System.out.println("Your hp hit 0. You died.");
				running=false;
			}
			if(player.getGold()>=100){
				System.out.println("You have successfully exited the dungeon. Congratulations!!");
				running=false;
			}
		}
    }

    private void playIntro() {
    	System.out.println("Oh no! You've been captured by the nefarious evil professor and placed into his dungeon!");
    	System.out.println("To escape, you must find 100 gold before you run out of health to pay the doorman!");
    	System.out.println("Good luck, adventurer!");
	}
}