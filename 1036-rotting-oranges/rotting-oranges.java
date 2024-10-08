class Solution {
    public class Ele{  //This class keeps the track of the Position of the oranges
        int x;         //(In this case, only the ROTTEN ORANGES)
        int y;

        public Ele(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public boolean isValid(int i, int j, int R, int C){ //To check if the position is within the grid or not
        return (i>=0 && j>=0 && i<R && j<C);
    }

    public boolean isDelim(Ele temp){  //To detect for the delimiter
        return (temp.x==-1 && temp.y==-1);
    }

    public boolean freshOrangeLeft(int[][] arr){  //To check if any fresh oranges are left in the grid
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
        Queue<Ele> q=new LinkedList<>(); //Keeps the track of the positions of the rotten oranges
        Ele temp;
        int time=0; 
        int R=grid.length;
        int C=grid[0].length;

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j] == 2){
                    q.add(new Ele(i,j)); //Add all positions of rotten oranges in the queue
                }
            }
        }

        q.add(new Ele(-1,-1)); //Add delimitter in the queue

        while(!q.isEmpty()){
            boolean flag=false; //To increment time only once 

            while(!isDelim(q.peek())){
                temp=q.peek();

                //Right orange
                if(isValid(temp.x+1,temp.y,R,C) && grid[temp.x+1][temp.y] == 1){
                    if(!flag){
                        time++;
                        flag=true;
                    }
                    grid[temp.x+1][temp.y]=2;
                    q.add(new Ele(temp.x+1, temp.y));
                }

                //Left Orange
                if(isValid(temp.x-1,temp.y,R,C) && grid[temp.x-1][temp.y] == 1){
                    if(!flag){
                        time++;
                        flag=true;
                    }
                    grid[temp.x-1][temp.y]=2;
                    q.add(new Ele(temp.x-1, temp.y));
                }

                //Bottom Orange
                if(isValid(temp.x,temp.y+1,R,C) && grid[temp.x][temp.y+1] == 1){
                    if(!flag){
                        time++;
                        flag=true;
                    }
                    grid[temp.x][temp.y+1]=2;
                    q.add(new Ele(temp.x, temp.y+1));
                }

                //Top Orange
                if(isValid(temp.x,temp.y-1,R,C) && grid[temp.x][temp.y-1] == 1){
                    if(!flag){
                        time++;
                        flag=true;
                    }
                    grid[temp.x][temp.y-1]=2;
                    q.add(new Ele(temp.x, temp.y-1));
                }

                q.remove(); //Remove the rotten orange from queue after its infection
            }

            q.remove();//Remove delimiter after the loop

            if(!q.isEmpty()){
                q.add(new Ele(-1,-1));  //Check if any rotten oranges are left in the queue for further process
            }                           //If so, add the delimitter again 
        }

        return freshOrangeLeft(grid) ? -1 : time;  //Check for any fresh oranges
    }                                              //If present return -1, if not, return the time(in minutes)
}