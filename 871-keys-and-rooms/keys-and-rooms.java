class Solution {
    public class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    public void createGraph(ArrayList<Edge>[] graph, List<List<Integer>> rooms){
        for(int i=0;i<rooms.size();i++){
            for(int j=0;j<rooms.get(i).size();j++){
                graph[i].add(new Edge(i,rooms.get(i).get(j)));
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        ArrayList<Edge>[] graph=new ArrayList[rooms.size()];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        createGraph(graph, rooms);
        boolean[] vis=new boolean[graph.length];

        visitRoomsUtil(graph, vis, 0);

        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                return false;
            }
        }

        return true;
    }

    public void visitRoomsUtil(ArrayList<Edge>[] graph, boolean[] vis, int currentRoom) {
        vis[currentRoom] = true;
        for (Edge e : graph[currentRoom]) {
            if (!vis[e.dest]) {
                visitRoomsUtil(graph, vis, e.dest); 
            }
        }
    }
}