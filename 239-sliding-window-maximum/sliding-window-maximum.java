class Solution {
    public class Point implements Comparable<Point>{
        int val;
        int idx;
        public Point(int val, int idx){
            this.val=val;
            this.idx=idx;
        }

        public int compareTo(Point p2){
            return p2.val - this.val;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Point> pq=new PriorityQueue<>();
        int[] ans = new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            pq.add(new Point(nums[i],i));
        }
        ans[0]=pq.peek().val;

        for(int i=k;i<nums.length;i++){
            while(pq.size() > 0 && pq.peek().idx <= i-k){
                pq.remove();
            }
            pq.add(new Point(nums[i],i));
            ans[i-k+1]=pq.peek().val;
        }

        return ans;
    }
}