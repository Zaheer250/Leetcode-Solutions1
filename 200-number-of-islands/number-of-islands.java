class Solution {
    class Pair{
        int row;
        int col;

        public Pair(int r, int c){
            this.row=r;
            this.col=c;
        }
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        HashSet<String> visited = new HashSet<>();
        int islands=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == '1' && !visited.contains(i+","+j)){
                    islands+=1;
                    bfs(grid,i,j,visited,rows,cols);
                }
            }
        }

        return islands;
    }

    public void bfs(char[][] grid, int i, int j, HashSet<String> visited, int rows, int cols){
        Queue<Pair> q=new LinkedList<>();
        visited.add(i+","+j);
        q.add(new Pair(i,j));

        while(!q.isEmpty()){
            Pair curr = q.remove();
            int currRow=curr.row;
            int currCol=curr.col;

            fourDirections(grid, q, visited, currRow+1, currCol);
            fourDirections(grid, q, visited, currRow, currCol+1);
            fourDirections(grid, q, visited, currRow-1, currCol);
            fourDirections(grid, q, visited, currRow, currCol-1);
        }
    }

    public void fourDirections(char[][] grid, Queue<Pair> q, HashSet<String> visited, int newRow, int newCol){
        int rows=grid.length;
        int cols=grid[0].length;
        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1' && !visited.contains(newRow+","+newCol)){
            q.add(new Pair(newRow,newCol));
            visited.add(newRow+","+newCol);
        }

    }
}