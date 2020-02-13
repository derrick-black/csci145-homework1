import java.awt.*;

// This class object represents a map of a dungeon for the DungeonGame class.
// It contains an array of Room objects and keeps track of a Player object.
// It also contains a method to create a visual representation of the map.
public class DungeonMap {
    private Room[][] rooms;
    private Player player;
    private final String WALL_MAP_POSITION = "|";
    private final String CEILING_FLOOR_MAP_POSITION = "-";
    private final String EMPTY_MAP_POSITION = " ";
    private final String VISITED_MAP_POSITION = "*";
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
        initMap();
    }

    private void initMap() {
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[i].length; j++) {
                rooms[i][j] = new Room();
            }
        }
        rooms[0][0].setVisited(true);
    }

    public void print() {
        for (int i = 0; i < rooms.length + 2; i++) {
            System.out.print(CEILING_FLOOR_MAP_POSITION);
        }
        System.out.println();

        for (int i = 0; i < rooms.length; i++) {
            System.out.print(WALL_MAP_POSITION);
            for (int j = 0; j < rooms[i].length; j++) {
                if (player.getY() == i && player.getX() == j) {
                    System.out.print(playerToken);
                }
                else if (rooms[i][j].hasVisited()){
                    System.out.print(VISITED_MAP_POSITION);
                } else {
                    System.out.print(EMPTY_MAP_POSITION);
                }
            }
            System.out.println(WALL_MAP_POSITION);
        }

        for (int i = 0; i < rooms.length + 2; i++) {
            System.out.print(CEILING_FLOOR_MAP_POSITION);
        }
        System.out.println();
    }

    public Room movePlayer(int xDistance, int yDistance) {
        Point newPosition = new Point(player.getX() + xDistance, player.getY() + yDistance);
        Room currentPlayerRoom;

        if(isValidPosition(newPosition)) {
            player.setCoordinates(newPosition);
            currentPlayerRoom = rooms[player.getY()][player.getX()];
        } else {
            System.out.println("There is a wall blocking your path.");
            currentPlayerRoom = null;
        }
        return currentPlayerRoom;
    }

    public boolean isValidPosition(Point newPosition) {
        return !(newPosition.getX() < 0) && !(newPosition.getY() < 0) &&
                !(newPosition.getX() >= rooms[0].length) && !(newPosition.getY() >= rooms.length);
    }

}
