
public class Main {
    public static void main(String[] args) {
	DungeonGame game;
	if(args.length==1){
		int s = int.parse(args[0]);
		game = new DungeonGame(s,s);
	}
	else if(args.length==2){
		int w = int.parse(args[0]);
		int h = int.parse(args[1]);
		game = new DungeonGame(w,h);
	}
	else{
		game = new DungeonGame(10,10);
	}
	game.play(); 
    }
}
