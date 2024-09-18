import java.util.*;
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> lt=new ArrayList<>();
        Hashtable<Integer,Integer> num1 = new Hashtable<>();
        Hashtable<Integer,Integer> num2 = new Hashtable<>();

        for(int i=0;i<nums1.length;i++){
            if(num1.containsKey(nums1[i])){
                num1.replace(nums1[i],num1.get(nums1[i])+1);
            }
            else{
                num1.put(nums1[i],1);
            }
        }

        for(int i=0;i<nums2.length;i++){
            if(num2.containsKey(nums2[i])){
                num2.replace(nums2[i],num2.get(nums2[i])+1);
            }
            else{
                num2.put(nums2[i],1);
            }
        }
        List<Integer> t1 = new ArrayList<>();
        for(int n1 : nums1){
            if(!num2.containsKey(n1)){
                t1.add(n1);
                num2.put(n1, num2.getOrDefault(n1,0)+1);
            }
        }
        lt.add(t1);

        List<Integer> t2 = new ArrayList<>();
        for(int n2 : nums2){
            if(!num1.containsKey(n2)){
                t2.add(n2);
                num1.put(n2, num1.getOrDefault(n2,0)+1);
            }
        }
        lt.add(t2);

        return lt;
    }
}