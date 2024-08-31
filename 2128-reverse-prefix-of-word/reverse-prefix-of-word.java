class Solution {
    public String reversePrefix(String word, char ch) {
        char[] arr=word.toCharArray();
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] != ch){
                cnt+=1;;
            }
            else{
                break;
            }
            
        }
        if(cnt == arr.length){
            return word;
        }
        int l=0;
        int r=cnt;
        while(l<=r){
            char temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l+=1;
            r-=1;
        }
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}