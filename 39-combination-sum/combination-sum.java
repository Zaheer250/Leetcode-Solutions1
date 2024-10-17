class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        combinationSumUtil(list, new ArrayList<>(), candidates, target, 0);

        return list;
    }

    public void combinationSumUtil(List<List<Integer>> list, List<Integer> temp, int[] nums, int target, int start){
        if(target < 0){
            return;
        }
        else if(target == 0){
            list.add(new ArrayList<>(temp));
        }
        else{
            for(int i=start;i<nums.length;i++){
                temp.add(nums[i]);
                combinationSumUtil(list, temp, nums, target-nums[i], i);
                temp.remove(temp.size()-1);
            }
        }
    }
}