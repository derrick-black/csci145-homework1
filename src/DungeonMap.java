
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
            case "Thief":
                playerToken = 'T';
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
                if (player.getY() == i + 1 && player.getX() == j + 1) {
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
