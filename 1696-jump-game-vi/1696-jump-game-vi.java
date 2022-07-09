class Solution {
    public int maxResult(int[] nums, int k) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(k,
                Comparator.comparing(o -> -o.getValue())) {{
            offer(new Pair<>(0, nums[0]));
        }};

        int max = nums[0], ans;
        for (int i = 1; i < nums.length; i++) {
            while (pq.peek().getKey() < i - k) { // We just compare the top node and see if it is outside of window or not.
                pq.poll();
            }

            max = nums[i] + pq.peek().getValue();
            pq.offer(new Pair<>(i, max));
        }

        return max;
    }
}