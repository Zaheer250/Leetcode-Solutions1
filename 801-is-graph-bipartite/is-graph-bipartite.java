class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph.length == 0) return true;
        int[] colors = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0) {
                if(!dfs(graph, i, colors, 1)){
                    return false;
                } 
            }
        }

        return true;
    }


    public boolean dfs(int[][] graph, int i, int[] colors, int color) {
        // neighbour should not be same as node
        if(colors[i] > 0) {
            return colors[i] == color;
        }
        
        colors[i] = color;

        int neightbourColor = colors[i] == 1 ? 2 : 1;

        for (int j = 0; j < graph[i].length; j++) {
            if(!dfs(graph, graph[i][j], colors, neightbourColor)) {
                return false;
            }
        }

        return true;
    }
}