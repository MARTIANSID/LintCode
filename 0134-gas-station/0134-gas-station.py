class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        fuel=0
        trackLength=len(gas)
        n=0
        index=0
        for i in range(0,2*len(gas)):
            if n == trackLength:
                return index
            fuel+=gas[i%trackLength]
            if fuel<cost[(i)%trackLength]:
                n=0
                fuel=0
                index=(i+1)%trackLength
            else:
                fuel-=cost[(i)%trackLength]
                n+=1
                
        return -1