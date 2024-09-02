class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int i=0;
        while(true){
            if(k<chalk[i]){
                break;
            }
            k-=chalk[i];
            i+=1;
            if(i == chalk.length){
                i = 0;
            }
        }

        return i;
    }
}