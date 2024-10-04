class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        List<List<Integer>> lt=new ArrayList<>();
        int l=0;
        int r=skill.length-1;
        int k = skill[l]+skill[r];
        List<Integer> temp=new ArrayList<>();
        temp.add(skill[l]);
        temp.add(skill[r]);
        lt.add(temp);
        l+=1;
        r-=1;
        while(l<r){
            temp=new ArrayList<>();
            if(skill[l]+skill[r] == k){
                temp.add(skill[l]);
                temp.add(skill[r]);
                lt.add(temp);
                l+=1;
                r-=1;
            }
            else{
                return -1;
            }
           
        }

        
        long sum=0;
        for(int i=0;i<lt.size();i++){
            List<Integer> t=lt.get(i);
            sum+=(t.get(0)*t.get(1));
        }

        return sum;
    }
}