class Solution {
    public class Row implements Comparable<Row>{
        int soldier;
        int idx;

        public Row(int soldier, int idx){
            this.soldier=soldier;
            this.idx=idx;
        }

        public int compareTo(Row r2){
            if(this.soldier == r2.soldier){
                return this.idx-r2.idx;
            }
            else{
                return this.soldier - r2.soldier;
            }
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Row> pq=new PriorityQueue<>();
        for(int i=0;i<mat.length;i++){
            int cnt=0;
            for(int j=0;j<mat[0].length;j++){
                cnt+=mat[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(cnt, i));
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.remove().idx;
        }
        return ans;
    }
}