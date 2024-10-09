class RandomizedSet {
    List<Integer> lt;
    public RandomizedSet() {
        lt=new ArrayList<>();
    }
    public boolean insert(int val) {
       if(lt.contains(val)){
        return false;
       }
       lt.add(val);
       return true; 
    }
    
    public boolean remove(int val) {
        if(!lt.contains(val)){
            return false;
        }
        lt.remove(Integer.valueOf(val));
        return true;
    }
    
    public int getRandom() {
        Random rand=new Random();
        int idx=rand.nextInt(lt.size());

        return lt.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */