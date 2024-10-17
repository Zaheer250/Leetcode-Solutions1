class Solution {
    public int maximumSwap(int num) {
        char[] arr=Integer.toString(num).toCharArray();
        int maxIdx=-1, low=-1, high=-1;

        for(int i=arr.length-1;i>=0;i--){
            if(maxIdx == -1 || arr[i] > arr[maxIdx]){
                maxIdx=i;
            }
            else if(arr[i] < arr[maxIdx]){
                low=i;
                high=maxIdx;
            }
        }

        if(low != -1 && high != -1){
            char temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
        }

        return Integer.parseInt(new String(arr));
    }
}