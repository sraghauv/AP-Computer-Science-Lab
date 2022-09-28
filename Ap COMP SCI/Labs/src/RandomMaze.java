public class RandomMaze {
    private char[][] maze;
    private boolean[][] visited;
    private boolean exitFound;
    private int minSteps;


    public RandomMaze(int size) {
        maze = new char[size][size];

        boolean result = false;
        minSteps=100000000;

        setMaze();
        visited = new boolean[size][size];
        int row = (int)(Math.random()*size);
        int col = (int)(Math.random()*size);
        maze[row][col] = 'A';

        int row2 = (int)(Math.random()*size);
        int col2 = (int)(Math.random()*size);
        maze[row2][col2] = 'Z';
        validPath(row,col,0);
        result = exitFound;

        System.out.println("Valid path: "  + result);

    }

    /** This method returns true when there is a valid path from 'A' to 'Z'
     */
    public void validPath(int r, int c, int steps)
    {
        if(isValid(r,c)&&(maze[r][c]=='A'||maze[r][c]=='1')&&!visited[r][c])
        {
            visited[r][c]=true;
            steps++;

            if(maze[r][c]=='Z')
            {

                exitFound = true;
                if(minSteps>steps)
                {
                    minSteps=steps;
                }
            }


                validPath(r + 1, c,steps);
                validPath(r - 1, c,steps);
                validPath(r, c + 1,steps);
                validPath(r, c - 1,steps);
            steps--;
            visited[r][c]=false;
        }


    }

    public boolean isValid(int r, int c){
        return r >= 0 && r < maze.length && c >= 0 && c < maze[0].length;
    }

    public String toString() {
        String output = "";
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[r].length; c++) {
                output += ""+  maze[r][c] + " ";
            }
            output += "\n";
        }
        output+="\n Path: " + exitFound + "\nSteps: " + minSteps;

        return output;
    }

    public void setMaze(){
        for(int r = 0; r < maze.length; r++){
            for(int c = 0; c < maze[0].length; c++){
                if(Math.random() < .7)
                    maze[r][c] = '1';
                else
                    maze[r][c] = '_';
            }
        }
    }

}

class MazeTester {
    public static void main(String[] args) {
        RandomMaze maze = new RandomMaze(10);
        System.out.println(maze);
    }
}