import java.util.*;
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1=s1.split(" ");
        String[] arr2=s2.split(" ");
        Hashtable<String,Integer> ht=new Hashtable<>();

        for(int i=0;i<arr1.length;i++){
            if(ht.containsKey(arr1[i])){
                ht.replace(arr1[i],ht.get(arr1[i])+1);
            }
            else{
                ht.put(arr1[i],1);
            }
        }

        for(int i=0;i<arr2.length;i++){
            if(ht.containsKey(arr2[i])){
                ht.replace(arr2[i],ht.get(arr2[i])+1);
            }
            else{
                ht.put(arr2[i],1);
            }
        }
        List<String> temp=new ArrayList<>();
        for(String str : ht.keySet()){
            if(ht.get(str) < 2){
                temp.add(str);
            }
        }
        String[] ans=new String[temp.size()];
        int idx=0;
        for(String i:temp){
            ans[idx]=temp.get(idx);
            idx++;
        }
        return ans;
    }
}