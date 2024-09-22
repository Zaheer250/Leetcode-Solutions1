class Solution {
    public int subarraySum(int[] nums, int k) {
        int presum=0, ans=0;
        HashMap<Integer, Integer> hm=new HashMap<>();

        hm.put(0,1);
        int sum=0;
        int cnt=0;

        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            if(hm.containsKey(sum-k)){
                cnt+=hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return cnt;

    }
}