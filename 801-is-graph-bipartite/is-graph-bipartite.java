class Solution {
    public class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public boolean isBipartite(int[][] graph) {
        ArrayList<Edge> ad_graph[] = new ArrayList[graph.length];
        for(int i = 0; i < graph.length; i++) {
           ad_graph[i] = new ArrayList<>();
        }
        createGraph(ad_graph, graph);
        return isBipartiteUtil(ad_graph);
    }

    public boolean isBipartiteUtil(ArrayList<Edge> graph[]){
        int col[]=new int[graph.length];
        for(int i=0;i<col.length;i++){
            col[i]=-1;  //No colour
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(col[i]==-1){
                q.add(i);
                col[i]=0; // 0=red, 1=blue, -1=no colour
                while(!q.isEmpty()){
                    int curr=q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        Edge e=graph[curr].get(j);
                        if(col[e.dest] == -1){ // No colour = add colour to node opposite to its parent
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest]=nextCol;
                            q.add(e.dest);
                        }
                        else if(col[e.dest] == col[curr]){  //Adjacent node have same colour = NOT A BIPARTITE
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public void createGraph(ArrayList<Edge> ad_graph[], int[][] graph){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                Edge edge = new Edge(i, graph[i][j]);
                ad_graph[i].add(edge);
            }
        }
    }
}