from collections import Counter
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        if len(nums)==k:
            return nums
        count=Counter(nums)
        print(type(count))
        return heapq.nlargest(k,count.keys(),key=lambda k: count.get(k))

        