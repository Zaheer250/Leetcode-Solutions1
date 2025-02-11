class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> lt=new ArrayList<>();
        HashSet<Integer> hs=new HashSet<>();
        for(int i : nums){
            hs.add(i);
        }
        for(int i=1;i<=nums.length;i++){
            if(!hs.contains(i)){
                lt.add(i);
            }
        }

        return lt;
    }
}