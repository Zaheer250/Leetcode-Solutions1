class Solution {
    public class Edge{
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    public void createGraph(ArrayList<Edge>[] graph, int[][] prerequisites){
        for(int i=0;i<prerequisites.length;i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];

            Edge e=new Edge(b,a);
            graph[b].add(e);
        }
    }

    public void calcIndeg(ArrayList<Edge>[] graph, int[] indegree){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                indegree[e.dest]++;
            }
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Edge>[] graph=new ArrayList[numCourses];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        createGraph(graph, prerequisites);
        List<Integer> temp=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        int[] indegree=new int[graph.length];
        calcIndeg(graph, indegree);
        
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int curr=q.remove();
            temp.add(curr);
            
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                indegree[e.dest]--;
                if(indegree[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
        if(temp.size() < numCourses){
            return false;
        }
        
        return true;
    }
}