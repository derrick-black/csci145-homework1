// This class object represents a map of a dungeon for the DungeonGame class.
// It contains an array of Room objects and keeps track of a Player object.
// It also contains a method to create a visual representation of the map.
public class DungeonMap {
    private Room[][] rooms;
    private Player player;
    private final String WALL_MAP_POSITION = "*";
    private final String EMPTY_MAP_POSITION = " ";
    private char playerToken;


    public DungeonMap (int rows, int columns, Player player){
        rooms = new Room[rows][columns];
        this.player = player;
        switch(player.getPlayerClass()) {
            case "Warrior":
                playerToken = 'W';
                break;
            case "Thief":
                playerToken = 'T';
                break;
        }
    }

    public void print() {

        for (int i = 0; i < rooms.length + 2; i++) {
            System.out.print("*");
        }
        System.out.println();

        for (int i = 0; i < rooms.length; i++) {
            System.out.print(WALL_MAP_POSITION);
            for (int j = 0; j < rooms[i].length; j++) {
                if (player.getY() == i && player.getX() == j) {
                    System.out.print(playerToken);
                }
                else {
                    System.out.print(EMPTY_MAP_POSITION);
                }
            }
            System.out.println(WALL_MAP_POSITION);
        }

        for (int i = 0; i < rooms.length + 2; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}