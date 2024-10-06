class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lt=new ArrayList<>();
        Arrays.sort(nums);
        getSubsets(lt, new ArrayList<>(), nums, 0);
        return lt;
    }

    public void getSubsets(List<List<Integer>> lt, List<Integer> temp, int[] nums, int start){
        lt.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            getSubsets(lt, temp, nums, i+1);
            temp.remove(temp.size()-1);  //backtracking step
        }
    }
}