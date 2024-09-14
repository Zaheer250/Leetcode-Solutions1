class Solution {
    public String convertDateToBinary(String date) {
        String a="";
        String b="";
        String c="";
        int i=0;
        while(date.charAt(i) != '-'){
            a+=date.charAt(i);
            i+=1;
        }
        i+=1;
        while(date.charAt(i) != '-'){
            b+=date.charAt(i);
            i+=1;
        }
        i+=1;
        while(i!=date.length()){
            c+=date.charAt(i);
            i+=1;
        }

        int a1 = Integer.parseInt(a);
        int b1 = Integer.parseInt(b);
        int c1 = Integer.parseInt(c);

        String a2=Integer.toBinaryString(a1);
        String b2=Integer.toBinaryString(b1);
        String c2=Integer.toBinaryString(c1);

        String ans = a2 + "-" + b2 + "-" + c2;
        return ans;
    }
}