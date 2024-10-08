class Solution {
    public class Ele{
        int x;
        int y;

        public Ele(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public boolean isValid(int i, int j, int R, int C){
        return (i>=0 && j>=0 && i<R && j<C);
    }

    public boolean isDelim(Ele temp){
        return (temp.x==-1 && temp.y==-1);
    }

    public boolean freshOrangeLeft(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j] == 1){
                    return true;
                }
            }
        }
        return false;
    }

    public int orangesRotting(int[][] grid) {
        Queue<Ele> q=new LinkedList<>();
        Ele temp;
        int time=0; 
        int R=grid.length;
        int C=grid[0].length;

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j] == 2){
                    q.add(new Ele(i,j));
                }
            }
        }

        q.add(new Ele(-1,-1));

        while(!q.isEmpty()){
            boolean flag=false;

            while(!isDelim(q.peek())){
                temp=q.peek();

                if(isValid(temp.x+1,temp.y,R,C) && grid[temp.x+1][temp.y] == 1){
                    if(!flag){
                        time++;
                        flag=true;
                    }
                    grid[temp.x+1][temp.y]=2;
                    q.add(new Ele(temp.x+1, temp.y));
                }

                if(isValid(temp.x-1,temp.y,R,C) && grid[temp.x-1][temp.y] == 1){
                    if(!flag){
                        time++;
                        flag=true;
                    }
                    grid[temp.x-1][temp.y]=2;
                    q.add(new Ele(temp.x-1, temp.y));
                }

                if(isValid(temp.x,temp.y+1,R,C) && grid[temp.x][temp.y+1] == 1){
                    if(!flag){
                        time++;
                        flag=true;
                    }
                    grid[temp.x][temp.y+1]=2;
                    q.add(new Ele(temp.x, temp.y+1));
                }

                if(isValid(temp.x,temp.y-1,R,C) && grid[temp.x][temp.y-1] == 1){
                    if(!flag){
                        time++;
                        flag=true;
                    }
                    grid[temp.x][temp.y-1]=2;
                    q.add(new Ele(temp.x, temp.y-1));
                }

                q.remove();
            }

            q.remove();

            if(!q.isEmpty()){
                q.add(new Ele(-1,-1));
            }
        }

        return freshOrangeLeft(grid) ? -1 : time;
    }
}