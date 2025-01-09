class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> lt=new ArrayList<>();
        String[] copy = words.clone();
        for(int i=0;i<copy.length;i++){
            String str=copy[i];
            for(String s : words){
                if(s.equals(str)){
                    continue;
                }
                if((s.indexOf(str) != -1) && (!lt.contains(str))){
                    lt.add(str);
                    continue;
                }
            }
        }

        return lt;
    }
}