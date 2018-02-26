package basic;


import javafx.util.Pair;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Driver_StandardAlgo{
    public static void main(String[] args) {
        Puzzle p = new Puzzle(Puzzle.how_to_init.FROM_ONE_TO_TOTAL_CELL);
        StandardAlgo test = new StandardAlgo(p);
        test.Bfs(0, 0);
        test.Dfs(0, 0);
    }
}

public class StandardAlgo {
    static final int MAX_VALUE = 1000000000; //1e9
    static int Row_Column = 3;
    int [][] mat;
    enum Move{ LEFT, RIGHT, UP, DOWN};
    //movement specifier
    static final int [] dx = {-1,   1,    0,   0};
    static final int [] dy = { 0,   0,    1,  -1};
    //.......................LEFT  RIGHT  UP  DOWN
    //                        <-    ->     ^    v


    public StandardAlgo()
    {
        mat = new int[Row_Column][Row_Column];
    }

    public StandardAlgo(int Row_Column)
    {
        this.Row_Column = Row_Column;
        mat = new int [Row_Column][Row_Column];
    }

    public StandardAlgo( Puzzle p)
    {
        this.Row_Column = p.Row_Column;
        mat = new int [Row_Column][Row_Column];

        for(int i=0; i < Row_Column; i++){
            for(int j=0; j < Row_Column; j++){
                mat[i][j] = p.board[i][j];
            }
        }
    }

    private String generate_Display_String(int [][] mat)
    {

        String temp = "";
        for(int i = 0; i < Row_Column; i++){
            for(int j = 0; j < Row_Column; j++){
                temp +=  Integer.toString(mat[i][j]);
                temp +=  " ";
            }
            temp += "\n";
        }
        return temp;
    }

    boolean isWithin_boundary(int i, int j)
    {
        if( i >= 0 && i < Row_Column && j >= 0 && j < Row_Column)
        {
            return true;
        }
        return false;
    }
    boolean isValid_Cell(int i, int j)
    {
        if( isWithin_boundary(i,j) == true ){
            return true;
        }

        return false;
    }
    //explore nearest cell first
    void Bfs(int start_i, int start_j) {
        int cell_i = start_i;
        int cell_j = start_j;

        LinkedList < Pair > queue = new LinkedList< Pair >(); //work as queue
        int [][] visited = new int[Row_Column][Row_Column];
        for(int i=0; i < Row_Column; i++){
            Arrays.fill( visited[i], 0);
        }

        visited[ cell_i ][ cell_j ] = 1;
        queue.add( new Pair(cell_i, cell_j));

        while(!queue.isEmpty() == true){
            Pair popped = queue.poll();
            cell_i = (int) popped.getKey();
            cell_j = (int) popped.getValue();

            for(int i=0; i < 4; i++){
                int temp_i = cell_i + dx[i];
                int temp_j = cell_j + dy[i];

                //checking started
                if( isValid_Cell(temp_i, temp_j) == true
                        && visited[ temp_i ][ temp_j ] == 0){

                    visited[ temp_i ][ temp_j ] = 1;
                    queue.add( new Pair(temp_i, temp_j) );

                    /**/
                    System.out.println(generate_Display_String(visited));
                    /***/

                }// end checking
            }
        }


    }

    //explore furthes cell first
    void Dfs(int start_i, int start_j) {

        int [][] visited = new int[Row_Column][Row_Column];
        for(int i=0; i < Row_Column; i++){
            Arrays.fill( visited[i], 0);
        }

        recurstionDFS(start_i, start_j, visited);
        System.out.println(generate_Display_String(visited));
    }

    private void recurstionDFS(int cell_i, int cell_j, int [][] visited)
    {
        if(visited [ cell_i ][ cell_j ] == 1){
            return;
        }
        visited [ cell_i ][ cell_j ] = 1;

        for(int i=0; i < 4; i++){
            int temp_i = cell_i + dx[i];
            int temp_j = cell_j + dy[i];

            //checking started
            if( isValid_Cell(temp_i, temp_j) == true
                    && visited[ temp_i ][ temp_j ] == 0){

                /**/
                System.out.println(generate_Display_String(visited));
                /***/
                //ERROR PRONE : visited[ temp_i ][ temp_j ] = 1;
                // IF YOU MARK VISIT HERE, YOU ARE NOT GOING SEE ADJACENT
                recurstionDFS(temp_i, temp_j, visited);

            }// end checking
        }
    }

    /**
     * edge weight is taken as 1
     *
     * @param source
     * @param destination
     */
    void Dijkstra(Pair source, Pair destination) {
        int [][] visited = new int[Row_Column][Row_Column];
        int [][] distance = new int[Row_Column][Row_Column];
        Pair <Integer, Integer> [][] parent = new Pair[Row_Column][Row_Column];

        for(int i=0; i < Row_Column; i++){
            Arrays.fill(visited[i], 0);
            Arrays.fill(distance[i] , MAX_VALUE);
            Arrays.fill(parent[i] , -1);
        }

        int u_i = (int)source.getKey();
        int u_j = (int)source.getValue();

        int v_i = (int)destination.getKey();
        int v_j = (int)destination.getValue();

        parent[u_i][u_j] = new Pair(u_i, u_j); //parent of source is itself
        //
        PriorityQueue < Pair <Integer, Integer> > pq =
                new PriorityQueue< Pair <Integer, Integer> >();
        ///

        pq.add( new Pair<Integer, Integer>(u_i, u_j) );
        while(!pq.isEmpty()){
            Pair <Integer, Integer> pair = pq.poll();
            int cell_i = pair.getKey();
            int cell_j = pair.getValue();

            /**COPY IN PROGRESS**/

            for(int i=0; i < 4; i++){
                int temp_i = cell_i + dx[i];
                int temp_j = cell_j + dy[i];

                //checking started
                if( isValid_Cell(temp_i, temp_j) == true ){

                    visited[ temp_i ][ temp_j ] = 1;
                    pq.add( new Pair(temp_i, temp_j) );

                    /**/
                    System.out.println(generate_Display_String(visited));
                    /***/

                }// end checking
            }


            /**COPY TERMINATED**/
        }


    }

    void BellmanFord(int source, int destination) {

    }
}


