class Solution(object):
    def detectCapitalUse(self, word):
        upperCount=0
        lowerCount=0
        for char in word:
            if char.isupper():
                upperCount+=1
            elif char.islower():
                lowerCount+=1
        if lowerCount > 0 and upperCount > 0 :
            if upperCount == 1 and word[0].isupper():
                return True
            else:
                return  False
        return True