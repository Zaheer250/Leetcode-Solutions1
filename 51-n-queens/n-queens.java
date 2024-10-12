class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] board=new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        } 

        nQueens(board, ans, 0);
        return ans;
    }

    public void nQueens(char[][] board, List<List<String>> ans, int row){
        if(row == board.length){
            ans.add(createBoard(board, board.length));
            return;
        }

        for(int j=0;j<board.length;j++){
            if(isSafe(board, row, j)){
                board[row][j]='Q';
                nQueens(board,ans, row+1);
                board[row][j]='.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col){
        //Vertically Up
        for(int i=row-1;i>=0;i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //Diagonally Left-Up
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //Diagonally Right-up
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public List<String> createBoard(char[][] board, int n){
        List<String> temp=new ArrayList<>();
        for(int i=0;i<n;i++){
            temp.add(new String(board[i]));
        }
        return temp;
    }
}