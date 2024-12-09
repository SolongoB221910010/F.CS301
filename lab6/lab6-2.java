public class MinCostSearch {
    public static int minCostSearch(int[] k, int[] f) {
        int n = k.length;
        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            cost[i][i] = f[i];
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                cost[i][j] = Integer.MAX_VALUE;

                int totalFreq = 0;
                for (int x = i; x <= j; x++) {
                    totalFreq += f[x];
                }

                for (int r = i; r <= j; r++) {
                    int leftCost = (r > i) ? cost[i][r - 1] : 0;
                    int rightCost = (r < j) ? cost[r + 1][j] : 0;
                    cost[i][j] = Math.min(cost[i][j], leftCost + rightCost + totalFreq);
                }
            }
        }

        return cost[0][n - 1];
    }

    public static void main(String[] args) {
        // Example data
        int[] k = {5, 6};  
        int[] f = {17, 25};  

        int minCost = minCostSearch(k, f);
        System.out.println("Хамгийн бага өртөг: " + minCost);
    }
}
