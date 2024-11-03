class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones){
            pq.add(i);
        }

        while(!pq.isEmpty() && pq.size() > 1){
            int a = pq.remove();
            int b = pq.remove();
            int diff = Math.abs(a-b);
            if(diff != 0){
                pq.add(diff);
            }
        }

        if(pq.isEmpty()){
            return 0;
        }

        return pq.remove();
    }
}