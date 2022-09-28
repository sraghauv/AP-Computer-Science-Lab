import java.util.Scanner;
import static java.lang.System.*;


public class KittyMap
{
    private boolean[][] kittyGrid;

    /*
    this constructo loads in random true and false values
     */

    public KittyMap(int rows, int cols)
    {
            kittyGrid = new boolean[rows][cols];
            for (int r = 0; r<rows;r++)
            {
                for(int c = 0;c<cols;c++)
                {
                    int a = (int)Math.random()*10;
                    if(a>=5)
                    {
                            kittyGrid[r][c] = false;
                    }

                    if(a<5)
                    {
                        kittyGrid[r][c] = true;
                    }
                }
            }

    }

    /*
    this method will call getKittyCountGrid
    to retrieve the kitty count for the kittyGrid
     */
    public void printKittyCount()
    {
        getKittyCountsGrid();

    }

    /*
    this method will calculate the kitty count for each cell
    if cell is true set int value to 9
    if cell is not true set int value to cnt of kittens in adjacent cells

     */

    private int[][] getKittyCountsGrid()
    {
        int[][] kittyCount = new int[kittyGrid.length][kittyGrid[0].length];
        for (int r = 0; r<kittyGrid.length;r++)
        {
            for(int c = 0;c<kittyGrid[0].length;c++)
            {
                if (kittyGrid[r][c])
                {
                    kittyCount[r][c]=9;
                }
                else
                {
                    for (int j = r-1;j<=r+1;j++)
                    {
                        for (int p = c-1;p<=c+1;p++)
                        {
                            if(j>=0&&j<kittyGrid.length&&p>=0&&p<kittyGrid[0].length)
                            {
                                kittyCount[j][p]+=1;
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    /*
    this method will return the value of the current cell
    if this cell contains a kitty - return 9
    otherwise - return the cent of all kitties in adjacent cells

     */
    public int getKittyCount(int r, int c)
    {
        if(kittyGrid[r][c])
        {
            return 9;
        }
        else return 0;
    }

    /*
        check r and c to ensure they are inside the grid
         */

    private boolean inBounds(int r, int c)
    {
        if(r<=kittyGrid.length&&c<=kittyGrid[0].length)
        {
            return false;
        }
        return true;
    }



    /*
    return the kitty grid as a string
     */

    public String toString()
    {
        String output = "";
        return output.trim();
    }
}
