class Solution(object):
    def longestNiceSubstring(self, s):
    
        def isNice(sub):
            seen = set(sub)
            for c in seen:
                if c.swapcase() not in seen:
                    return False
            return True
        
        if len(s) < 2:
            return ""

        for i in range(len(s)):
            if s[i].swapcase() not in s:
                left = self.longestNiceSubstring(s[:i])
                right = self.longestNiceSubstring(s[i + 1:])
                return left if len(left) >= len(right) else right

        return s


