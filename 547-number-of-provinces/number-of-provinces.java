class Solution {
    public class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    public void createGraph(ArrayList<Edge>[] graph, int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i][j] == 1){
                    graph[i].add(new Edge(i,j));
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<Edge>[] graph=new ArrayList[isConnected.length];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        createGraph(graph, isConnected);
        int cnt=0;
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                cnt++;
                dfs(graph, i, vis);
            }
        }

        return cnt;
    }

    public void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis){
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }
}