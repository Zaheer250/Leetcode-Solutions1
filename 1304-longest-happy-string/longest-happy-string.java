class Solution {
    class Pair implements Comparable<Pair>{
        char val;
        int cnt;

        public Pair(char c, int cnt){
            this.val=c;
            this.cnt=cnt;
        }

        @Override
        public int compareTo(Pair p2){
            return p2.cnt-this.cnt;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb=new StringBuilder("");
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        if(a>0){
            pq.add(new Pair('a',a));
        }
        if(b>0){
            pq.add(new Pair('b',b));
        }
        if(c>0){
            pq.add(new Pair('c',c));
        }

        while(!pq.isEmpty()){
            Pair first=pq.remove();
            //check if last two characters are the same as the current
            if(sb.length() >= 2 && sb.charAt(sb.length()-1) == first.val && sb.charAt(sb.length()-2) == first.val){
                if(pq.isEmpty()){ //no more valid characters
                    break;
                }
                
                Pair second = pq.remove();
                sb.append(second.val);
                second.cnt--;

                if(second.cnt > 0){
                    pq.add(second);
                }
                pq.add(first);
            }
            else{
                sb.append(first.val);
                first.cnt--;
                if(first.cnt > 0){
                    pq.add(first);
                }
            }
        }

        return sb.toString();
    }
}