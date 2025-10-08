class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:

        potions.sort()
        n=len(potions)
        result=[]
        for num in spells:
            strength=math.ceil(success/num)
            if strength>potions[-1]:
                result.append(0)
                continue
            index=bisect.bisect_left(potions,strength)
            result.append(n-index)
        return result        
