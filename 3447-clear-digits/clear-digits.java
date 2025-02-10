class Solution {
    public String clearDigits(String s) {
        Stack<Character> st=new Stack<>();
        char[] ch=s.toCharArray();
        for(int i=0;i<ch.length;i++){
            char c=ch[i];
            if(Character.isAlphabetic(c)){
                st.push(c);
            }
            else{
                st.pop();
            }
        }

        StringBuilder sb=new StringBuilder("");
        if(st.isEmpty()){
            return sb.toString();
        }

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}