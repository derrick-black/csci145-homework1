
public class DungeonMap {
    public Room[][] rooms;
    private Player player;
	private int width;
	private int height;

    public DungeonMap (int width, int height, Player p){
		rooms = new Room[width][];
		for(int i=0; i<width; i++){
			rooms[i]= new Room[height];
			for(int k=0; k<height; k++){
				rooms[i][k] = new Room();
			}
		}
		this.width=width;
		this.height=height;
		player=p;
		Room r = rooms[player.x][player.y];
		r.visited=true;
    }
	
	public void enterRoom(){
		rooms[player.x][player.y].enter(player);
	}

    public void print() {
		System.out.print("+");
		for(int i=0; i<width; i++){
			System.out.print("-");
		}
		System.out.print("+\n");
		for(int y=0; y<height; y++){
			System.out.print("|");
			for(int x=0; x<width; x++){
				char temp = ' ';
				if(rooms[x][y].visited) temp = '*';
				if(x==player.x && y==player.y) temp = 'W';
				System.out.print(temp);
			}
			System.out.print("|\n");
		}
		System.out.print("+");
		for(int i=0; i<width; i++){
			System.out.print("-");
		}
		System.out.print("+\n");
    }
}
