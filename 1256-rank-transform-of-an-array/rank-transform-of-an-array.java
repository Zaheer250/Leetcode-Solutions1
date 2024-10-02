class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int[] tem=arr.clone();
        Arrays.sort(tem);
        int rank=1;
        for(int i=0;i<tem.length;i++){
            if(!hm.containsKey(tem[i])){
                hm.put(tem[i],rank);
                rank+=1;
            }
        }

        List<Integer> temp=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            temp.add(hm.get(arr[i]));
        }

        int[] ans=new int[temp.size()];
        int idx=0;
        for(int val:temp){
            ans[idx]=val;
            idx+=1;
        }
        return ans;
    }
}