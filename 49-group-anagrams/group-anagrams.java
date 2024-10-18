class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm=new HashMap<>();

        for(int i=0;i<strs.length;i++){
            String s=strs[i];

            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String key=new String(ch);

            if(!hm.containsKey(key)){
                hm.put(key, new ArrayList<>());
            }
            hm.get(key).add(s);
        }

        List<List<String>> ans=new ArrayList<>(hm.values());

        return ans;
    }
}