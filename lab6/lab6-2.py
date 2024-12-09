def min_cost_search(k, f):
    n = len(k)  
    cost = [[0] * n for _ in range(n)]  

    for i in range(n):
        cost[i][i] = f[i]  
        
    for length in range(2, n + 1):
        for i in range(n - length + 1):
            j = i + length - 1
            cost[i][j] = float('inf')  
            total_freq = sum(f[i:j + 1])  
            for r in range(i, j + 1):
                left_cost = cost[i][r - 1] if r > i else 0
                right_cost = cost[r + 1][j] if r < j else 0
                cost[i][j] = min(cost[i][j], left_cost + right_cost + total_freq)

    return cost[0][n - 1]

# Жишээ
k = [5, 6]  # Түлхүүрүүд
f = [17, 25]  # Хайлтын тоо

min_cost = min_cost_search(k, f)
print("Хамгийн бага өртөг:", min_cost)
