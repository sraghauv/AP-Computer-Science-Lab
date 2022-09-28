/** This class represents a single tile from the game Carcassonne.
 *  A tile in Carcassonne has on each of its four edges a feature. An edge can be a field, road, or city.
 *  The edges array stores the values for each of the edges of the tile as 'F', 'R', or 'C'.
 *  You can expect edges array to look something like {'R','F','C','R'}
 *  where the order of edges is [up, right, down, left]. In this example, the down edge is a city.
 *
 *  This class contains accessor methods to return the value of each edge.
 *
 *  getTileId() will return the order in which the tile object was created.
 *
 *  toString() returns a text representation of the object with all four edges and the tileId.
 *
 *  rotateTile() will perform a clockwise rotation of the edges on the tile.
 *      {'R','F','C','R'} after one rotation -> {'R','R','F','C'}
 *       Up   Ri  Dn  Lf                         Up   Ri  Dn  Lf
 */
public class Tile {
    private char[] edges;
    private static int numTiles = 0; //This static value is increased when any Tile object is created and assigned to tileId.
    private int tileId;

    public Tile(char[] edges){
        this.edges = edges;
        numTiles++;
        tileId = numTiles;
    }

    public int getTileId(){
        return tileId;
    }
    public char getUpEdge(){
        return edges[0];
    }
    public char getRightEdge(){
        return edges[1];
    }
    public char getDownEdge(){
        return edges[2];
    }
    public char getLeftEdge(){
        return edges[3];
    }


    /** rotateTile()
     *  postcondition: the tile has been rotated 90deg clockwise.
     */
    public void rotateTile(){
        char temp = edges[3];
        for(int i = edges.length-1; i > 0; i--){
            edges[i] = edges[i-1];
        }
        edges[0] = temp;
    }

    public String toString(){
        return "U:" + getUpEdge() + " Ri:" + getRightEdge() + " D:" + getDownEdge() + " L:" + getLeftEdge() + " #" +tileId;
    }
}
