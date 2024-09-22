class Solution {
    public class Node{
        Node[] children=new Node[26];
        boolean eow=false;

        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }

    public Node root=new Node();

    public void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    
    public boolean search(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow == true;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        for(String str : wordDict){
            insert(str);
        }

         boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;  

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && search(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}