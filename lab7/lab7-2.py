class Solution(object):
    def leastInterval(self, tasks, n):
        task_counts = Counter(tasks) 
        max_freq = max(task_counts.values())
        max_count = list(task_counts.values()).count(max_freq)
        intervals = max(len(tasks), (max_freq - 1) * (n + 1) + max_count)
        
        return intervals
