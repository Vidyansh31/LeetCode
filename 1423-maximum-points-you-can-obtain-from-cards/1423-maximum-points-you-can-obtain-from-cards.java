class Solution {
    public int maxScore(int[] C, int k) {
          int total = 0;
        for (int i = 0; i < k; i++) total += C[i];
        int best = total;
        for (int i = k - 1, j = C.length - 1; i >= 0; i--, j--) {
            total += C[j] - C[i];
            best = Math.max(best, total);
        }
        return best;
    }
}