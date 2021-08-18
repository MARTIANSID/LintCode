class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->{
            return b[1]-a[1]; 
        });
        
        int n=boxTypes.length,ans=0;
        for(int i=0;i<n;i++){
          int numberOfBoxes=  boxTypes[i][0];
        int numberOfUnits=boxTypes[i][1];
            if(numberOfBoxes<=truckSize){
                ans+=numberOfUnits*numberOfBoxes;
                truckSize-=numberOfBoxes;
            }else{
                ans+=truckSize*numberOfUnits;
                break;
            }
        }
        return ans;
    }
}