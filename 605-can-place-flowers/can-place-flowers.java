class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0){
            return true;
        }
        if(flowerbed.length == 1){
            if(flowerbed[0] == 0){
                return true;
            }
            else{
                return false;
            }
        }
        int k=n,i=1;
        if(flowerbed[0] == 0 && flowerbed[1] == 0){
            flowerbed[0] = 1;
            k-=1;
        }
        if(flowerbed[flowerbed.length-1] == 0 && flowerbed[flowerbed.length-2] == 0 && k>0){
            flowerbed[flowerbed.length-1] = 1;
            k-=1;
        }
        while(i<flowerbed.length-2 && k>0){
            if(flowerbed[i]==0){
                if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                    flowerbed[i]=1;
                    k-=1;
                }
            }
            i+=1;
        }
        if(k == 0){
            return true;
        }
        return false;
    }
}