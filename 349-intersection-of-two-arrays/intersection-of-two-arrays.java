class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs=new HashSet<>();
        List<Integer> lt=new ArrayList<>();
        int idx=0;
        for(int i : nums1){
            hs.add(i);
        }
        for(int i : nums2){
            if(hs.contains(i)){
                hs.remove(i);
                lt.add(i);
            }
        }
        int[] ans = new int[lt.size()];
        for(int val : lt){
            ans[idx]=val;
            idx+=1;
        }
        return ans;
    }
}