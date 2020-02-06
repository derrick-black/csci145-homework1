
public class Main {
    public static void main(String[] args) {
		DungeonGame game;
		if(args.length==1){
			int s = Integer.parseInt(args[0]);
			game = new DungeonGame(s,s);
		}
		else if(args.length==2){
			int w = Integer.parseInt(args[0]);
			int h = Integer.parseInt(args[1]);
			game = new DungeonGame(w,h);
		}
		else{
			game = new DungeonGame(10,10);
		}
		game.play(); 
    }
}
