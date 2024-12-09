import unittest

# 0-1 Knapsack function
def knapsack(W, weights, values, n):
# 2D dp массивыг тэг утгаар эхлүүлнэ
    dp = [[0] * (W + 1) for _ in range(n + 1)]
    
    for i in range(1, n + 1):
        for w in range(1, W + 1):
            if weights[i - 1] <= w:
                dp[i][w] = max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]])
            else:
                dp[i][w] = dp[i - 1][w]
    
    return dp[n][W]

# Unit test
class TestKnapsack(unittest.TestCase):
    def test_knapsack(self):
        values = [60, 100, 120]
        weights = [10, 20, 30]
        W = 50
        self.assertEqual(knapsack(W, weights, values, len(values)), 220)

if __name__ == "__main__":
    unittest.main()

