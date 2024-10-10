import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>();
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>();
        
        int left = 0, right = costs.length - 1;

        while (left < candidates) {
            leftQueue.add(costs[left++]);
        }
        
        while (right >= costs.length - candidates && right >= left) {
            rightQueue.add(costs[right--]);
        }
        
        long totalCost = 0;
        
        for (int i = 0; i < k; i++) {
            if (!leftQueue.isEmpty() && (rightQueue.isEmpty() || leftQueue.peek() <= rightQueue.peek())) {
                totalCost += leftQueue.poll();
                if (left <= right) {
                    leftQueue.add(costs[left++]);
                }
            } else {
                totalCost += rightQueue.poll();
                if (left <= right) {
                    rightQueue.add(costs[right--]);
                }
            }
        }
        
        return totalCost;
    }
}
