class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<intervals.length;i++){
            if(!pq.isEmpty() && pq.peek()<intervals[i][0]){
                pq.remove();
            }
            pq.add(intervals[i][1]);
        }

        return pq.size();
    }
}