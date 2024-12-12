class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int val : gifts){
            pq.add(val);
        }

        while(k!=0){
            int temp = pq.remove();
            pq.add((int)Math.sqrt(temp));
            k-=1;
        }

        long ans=0;
        while(!pq.isEmpty()){
            ans+=(long)pq.remove();
        }

        return ans;
    }
}