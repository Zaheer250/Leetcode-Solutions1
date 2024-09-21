class Solution {
    public class Pair implements Comparable<Pair> {
        int n1;
        int n2;

        public Pair(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }

        public int compareTo(Pair p2) {
            return p2.n2 - this.n2;
        }
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        // Create pairs of (nums1[i], nums2[i])
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < nums1.length; i++) {
            pq.add(new Pair(nums1[i], nums2[i]));
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // To store the k largest nums1 values
        long sum = 0;
        long maxScore = 0;

        while (!pq.isEmpty()) {
            Pair temp = pq.remove();
            minHeap.add(temp.n1);
            sum += temp.n1;

            // Once the heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                sum -= minHeap.remove();
            }

            // If the heap contains exactly k elements, calculate the score
            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * temp.n2);
            }
        }
        return maxScore;
    }
}
