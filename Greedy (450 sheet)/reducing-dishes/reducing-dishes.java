class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int currSum=0, sumCumalative=0,max=0;
        for(int i=satisfaction.length-1;i>=0;i--){
            currSum+=satisfaction[i];
            sumCumalative+=currSum;
            max=Math.max(sumCumalative,max);
            
        }
        return max;
    }
}


// -9,-8,-1,0,5