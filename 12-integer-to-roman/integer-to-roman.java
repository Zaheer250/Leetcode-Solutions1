class Solution {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i=0;
        String ans="";
        while(num>0){
            if(num>=nums[i]){
                ans+=str[i];
                num-=nums[i];
            }
            else{
                i+=1;
            }
        }

        return ans;
    }
}