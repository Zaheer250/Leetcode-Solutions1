class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int ans=0,prev=0;

        ans=1;
        prev=pairs[0][1];

        for(int i=0;i<pairs.length;i++){
            if(pairs[i][0] > prev){
                ans+=1;
                prev=pairs[i][1];
            }
        }

        return ans;

    }
}