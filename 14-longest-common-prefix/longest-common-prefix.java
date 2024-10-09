class Solution {
    public class Node{
        Node[] children=new Node[26];
        boolean eow;
        int cnt;

        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            eow=false;
            cnt=0;
        }
    }
    public Node root=new Node();
    public void insert(String str){
        Node curr=root;
        for(int i=0;i<str.length();i++){
            int idx=str.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx]=new Node();
            }
            curr.cnt+=1;
            curr=curr.children[idx];
            
        }
        curr.eow=true;
    }

   public String helper(Node root, StringBuilder ans) {
    Node curr = root;

    while (true) {
        int count = 0;
        int idx = -1;
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                count++;
                idx = i;
            }
        }
        if (count != 1 || curr.eow) {
            break;
        }
        
        ans.append((char) (idx + 'a'));
        curr = curr.children[idx];
    }

    return ans.toString();
}

    
    public String longestCommonPrefix(String[] strs) {

        for (String str : strs) {
            if (str.isEmpty()) {
                return ""; 
            }
        }
        for(int i=0;i<strs.length;i++){
            insert(strs[i]);
        }
        return helper(root, new StringBuilder());

    }
}