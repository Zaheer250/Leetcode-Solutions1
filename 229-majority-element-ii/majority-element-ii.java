import java.util.*;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> lt=new ArrayList<>();
        Hashtable<Integer,Integer> ht=new Hashtable<>();
        for(int i=0;i<nums.length;i++){
            ht.put(nums[i],ht.getOrDefault(nums[i],0)+1);
        }

        for(Integer key : ht.keySet()){
            if(ht.get(key) > nums.length/3){
                lt.add(key);
            }
        }

        return lt;
    }
}