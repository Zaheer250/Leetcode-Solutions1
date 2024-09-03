class Solution {
    public int getLucky(String s, int k) {
        char[] arr=s.toCharArray();
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i] - 'a'+1);
        }
        String t=sb.toString();
        char[] arr1=t.toCharArray();
        while(k>0){
            int temp=0;
            char[] tem=sb.toString().toCharArray();
            for(int i=0;i<tem.length;i++){
                temp += tem[i] - '0';
            }
            sb=new StringBuilder(String.valueOf(temp));
            k--;
        }
        return Integer.parseInt(sb.toString());
    }
}