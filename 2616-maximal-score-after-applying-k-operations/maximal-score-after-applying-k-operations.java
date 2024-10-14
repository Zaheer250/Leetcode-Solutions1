class Solution {
    public class Pair implements Comparable<Pair>{
        int val;
        int idx;

        public Pair(int val, int idx){
            this.val=val;
            this.idx=idx;
        }

        @Override 
        public int compareTo(Pair p2){
            return p2.val-this.val;  //Descending order
        }
    }
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        long ans=0;
        for(int i=0;i<nums.length;i++){
            pq.add(new Pair(nums[i],i));
        }
        while(k!=0){
            Pair curr=pq.remove();
            ans+=(long)curr.val;
            int temp = curr.val / 3;
            if (curr.val % 3 != 0) {
                temp += 1;  
            }
            pq.add(new Pair(temp, curr.idx));
            k-=1;
        }

        return ans;
    }
}