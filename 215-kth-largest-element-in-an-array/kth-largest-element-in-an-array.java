import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i:nums){
            pq.add(i);
        }
        int ans=0;
        while(k!=0){
            ans = pq.remove();
            k-=1;
        }
        return ans;


    }
}