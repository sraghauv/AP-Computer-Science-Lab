import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameRunner extends JFrame {
    public static final int WIDTH = 580;
    public static final int HEIGHT = 600;

    public GameRunner(Tile[][] tiles){
        super("Carcassonne");
        setSize(WIDTH, HEIGHT);
        getContentPane().add(new BoardCanvas(tiles));
        setVisible(true);
    }

    public static void main(String[] args) {
        //Uncomment the lines below as you are ready to test your code.

        Carcassonne carcassonne = new Carcassonne();
        GameRunner run = new GameRunner(carcassonne.getTiles());

        //RoadBuilder roadBuilder = new RoadBuilder();
        //GameRunner run = new GameRunner(roadBuilder.getTiles());

       // RoadCounter roadCounter = new RoadCounter();
         //GameRunner run = new GameRunner(roadCounter.getTiles());

    }


    public static Tile[][] testTiles(){
        Tile[][] tiles = new Tile[5][5];
        tiles[0][0] = new Tile(new char[]{'C','C','C','C'});
        tiles[0][1] = new Tile(new char[]{'R','F','F','F'});
        tiles[0][2] = new Tile(new char[]{'F','R','F','F'});
        tiles[0][3] = new Tile(new char[]{'F','F','R','F'});
        tiles[0][4] = new Tile(new char[]{'F','F','F','R'});

        tiles[1][0] = new Tile(new char[]{'R','R','R','F'});
        tiles[1][1] = new Tile(new char[]{'R','R','F','F'});
        tiles[1][2] = new Tile(new char[]{'F','R','R','F'});
        tiles[1][3] = new Tile(new char[]{'F','F','R','R'});
        tiles[1][4] = new Tile(new char[]{'R','F','F','R'});

        tiles[2][0] = new Tile(new char[]{'F','R','R','R'});
        tiles[2][1] = new Tile(new char[]{'R','F','R','R'});
        tiles[2][2] = new Tile(new char[]{'R','R','F','R'});
        tiles[2][3] = new Tile(new char[]{'C','F','F','F'});
        tiles[2][4] = new Tile(new char[]{'F','C','F','F'});

        tiles[3][0] = new Tile(new char[]{'F','F','C','F'});
        tiles[3][1] = new Tile(new char[]{'F','F','F','C'});
        tiles[3][2] = new Tile(new char[]{'C','C','F','F'});
        tiles[3][3] = new Tile(new char[]{'F','C','C','F'});
        tiles[3][4] = new Tile(new char[]{'F','F','C','C'});

        tiles[4][0] = new Tile(new char[]{'C','F','F','C'});
        tiles[4][1] = new Tile(new char[]{'F','C','C','C'});
        tiles[4][2] = new Tile(new char[]{'C','F','C','C'});
        tiles[4][3] = new Tile(new char[]{'C','C','F','C'});
        tiles[4][4] = new Tile(new char[]{'C','C','C','F'});
        return tiles;
    }
}

class BoardCanvas extends Canvas implements Runnable {
    private Tile[][] tiles;

    public BoardCanvas(Tile[][] tiles){
        this.tiles = tiles;
        setBackground(Color.WHITE);
    }
    public void paint(Graphics window){
        window.setColor(Color.GREEN);
        int x = 10;
        int y = 10;
        //tiles = testTiles(); //tester
        for(Tile[] row : tiles){
            for(Tile tile : row){
                if(tile == null){
                    window.setColor(Color.black);
                    window.drawRect(x,y,100,100);
                }else{
                    drawTile(window,  x, y);
                    drawRoads(window, tile, x, y);
                    drawCities(window,tile, x, y);
                    drawTileId(window, tile,x, y);
                }
                x+= 110;
            }
            x = 10;
            y+=110;
        }
    }

    public void drawTile(Graphics window, int x, int y){
        window.setColor(Color.GREEN);
        window.fillRect(x,y,100,100);
    }

    public void drawRoads(Graphics window, Tile tile, int x, int y){
        window.setColor(Color.LIGHT_GRAY);
        ArrayList list = new ArrayList<>();
        if(tile.getDownEdge() == 'R'){
            window.fillRect(x+40, y+40, 20, 60);
            list.add(true);
        }
        if(tile.getLeftEdge() == 'R'){
            window.fillRect(x, y+40, 60, 20);
            list.add(true);
        }
        if(tile.getUpEdge() == 'R'){
            window.fillRect(x+40, y, 20, 60);
            list.add(true);
        }
        if(tile.getRightEdge() == 'R'){
            window.fillRect(x+40, y+40, 60, 20);
            list.add(true);
        }
        if(list.size() == 1){
            window.setColor(new Color(100,20,50));
            window.fillRect(x+30, y+30, 40,40);
        }
    }

    public void drawCities(Graphics window, Tile tile, int x, int y){
        window.setColor(new Color(100,20,50));
        //All 4
        if(tile.getUpEdge() == 'C' && tile.getRightEdge() == 'C' && tile.getDownEdge() == 'C'  && tile.getLeftEdge()  == 'C'){
            window.fillRect(x,y,100,100);
        }

        //3's
        //bot farm
        else if(tile.getUpEdge() == 'C' && tile.getRightEdge() == 'C' && tile.getLeftEdge() == 'C'){
            window.fillRect(x,y,100,50);
            Polygon p = new Polygon();
            p.addPoint(x,y+100);
            p.addPoint(x+50,y);
            p.addPoint(x,y);
            window.fillPolygon(p);

            Polygon p2 = new Polygon();
            p2.addPoint(x+50,y);
            p2.addPoint(x+100,y);
            p2.addPoint(x+100,y+100);
            window.fillPolygon(p2);
        }
        //left farm
        else if(tile.getUpEdge() == 'C' && tile.getRightEdge() == 'C' && tile.getDownEdge() == 'C'){
            window.fillRect(x+50,y,50,100);
            Polygon p = new Polygon();
            p.addPoint(x+100,y);
            p.addPoint(x+100,y+50);
            p.addPoint(x,y);
            window.fillPolygon(p);

            Polygon p2 = new Polygon();
            p2.addPoint(x,y+100);
            p2.addPoint(x+100,y+50);
            p2.addPoint(x+100,y+100);
            window.fillPolygon(p2);
        }

        //top farm
        else if(tile.getLeftEdge() == 'C' && tile.getRightEdge() == 'C' && tile.getDownEdge() == 'C'){
            window.fillRect(x,y+50,100,50);
            Polygon p = new Polygon();
            p.addPoint(x,y);
            p.addPoint(x+50,y+100);
            p.addPoint(x,y+100);
            window.fillPolygon(p);

            Polygon p2 = new Polygon();
            p2.addPoint(x+100,y);
            p2.addPoint(x+50,y+100);
            p2.addPoint(x+100,y+100);
            window.fillPolygon(p2);
        }
        //right farm
        else if(tile.getLeftEdge() == 'C' && tile.getUpEdge() == 'C' && tile.getDownEdge() == 'C'){
            window.fillRect(x,y,50,100);
            Polygon p = new Polygon();
            p.addPoint(x,y);
            p.addPoint(x+100,y);
            p.addPoint(x,y+50);
            window.fillPolygon(p);

            Polygon p2 = new Polygon();
            p2.addPoint(x,y+50);
            p2.addPoint(x,y+100);
            p2.addPoint(x+100,y+100);
            window.fillPolygon(p2);
        }
        //top right
        else if(tile.getUpEdge() == 'C' && tile.getRightEdge() == 'C'){
            Polygon p = new Polygon();
            p.addPoint(x,y);
            p.addPoint(x+100,y);
            p.addPoint(x+100,y+100);
            window.fillPolygon(p);
        }

        //bot right
        else if(tile.getDownEdge() == 'C' && tile.getRightEdge() == 'C'){
            Polygon p = new Polygon();
            p.addPoint(x+100,y);
            p.addPoint(x,y+100);
            p.addPoint(x+100,y+100);
            window.fillPolygon(p);
        }

        //bot left
        else if(tile.getDownEdge() == 'C' && tile.getLeftEdge() == 'C'){
            Polygon p = new Polygon();
            p.addPoint(x,y);
            p.addPoint(x,y+100);
            p.addPoint(x+100,y+100);
            window.fillPolygon(p);
        }
        //top left
        else if(tile.getUpEdge() == 'C' && tile.getLeftEdge() == 'C'){
            Polygon p = new Polygon();
            p.addPoint(x,y);
            p.addPoint(x,y+100);
            p.addPoint(x+100,y);
            window.fillPolygon(p);
        }
        else {
            if (tile.getUpEdge() == 'C') {
                window.fillArc(x, y - 30, 100, 60, 180, 180);
            }
            if (tile.getRightEdge() == 'C') {
                window.fillArc(x + 70, y, 60, 100, 90, 180);
            }
            if (tile.getDownEdge() == 'C') {
                window.fillArc(x, y + 70, 100, 60, 0, 180);
            }
            if (tile.getLeftEdge() == 'C') {
                window.fillArc(x - 30, y, 60, 100, 270, 180);
            }
        }
    }

    public void drawTileId(Graphics window, Tile tile, int x, int y){
        window.setColor(Color.BLACK);
        window.setFont(new Font("arial", Font.PLAIN, 18));
        window.drawString(""+tile.getTileId(),x+75, y+90 );
    }


    public void run(){
        try{
            Thread.currentThread().sleep(3);
        }catch (Exception e){

        }
    }
}
