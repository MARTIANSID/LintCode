class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n=capacity.length;
        
        List<int[]> arr=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            arr.add(new int[]{capacity[i],rocks[i]});
        }
        Collections.sort(arr,(a,b)->{
            return (a[0]-a[1])-(b[0]-b[1]); 
        });
        
        
        int b=0;
        for(int[] bags:arr){
            int diff=bags[0]-bags[1];
            if(additionalRocks>=(diff)){
                additionalRocks-=diff;
            }else{
                break;
            }
            b++;
        }
        
        return b;
    }
}