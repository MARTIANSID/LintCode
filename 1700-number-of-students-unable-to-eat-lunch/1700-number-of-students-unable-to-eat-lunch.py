class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        
        countOfOnes = 0
        countOfZeros = 0
        
        for ele in students:
            if ele == 1:
                countOfOnes+=1 
            else:
                countOfZeros+=1
        
        for ele in sandwiches:          
            if ele == 1:
                if countOfOnes > 0:
                    countOfOnes-=1
                else:
                    return countOfZeros
            else:
                if countOfZeros > 0:
                    countOfZeros-=1
                else:
                    return countOfOnes
        return 0
        