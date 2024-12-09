import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskCounts = new HashMap<>();
        for (char task : tasks) {
            taskCounts.put(task, taskCounts.getOrDefault(task, 0) + 1);
        }

        int maxFreq = 0;
        int maxCount = 0;
        for (int count : taskCounts.values()) {
            if (count > maxFreq) {
                maxFreq = count;
                maxCount = 1;
            } else if (count == maxFreq) {
                maxCount++;
            }
        }

        int maxIntervals = (maxFreq - 1) * (n + 1) + maxCount;

        return Math.max(tasks.length, maxIntervals);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        char[] tasks1 = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n1 = 2;
        System.out.println(solution.leastInterval(tasks1, n1)); // Output: 8

        // Example 2
        char[] tasks2 = { 'A', 'C', 'A', 'B', 'D', 'B' };
        int n2 = 1;
        System.out.println(solution.leastInterval(tasks2, n2)); // Output: 6

        // Example 3
        char[] tasks3 = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n3 = 3;
        System.out.println(solution.leastInterval(tasks3, n3)); // Output: 10
    }
}
