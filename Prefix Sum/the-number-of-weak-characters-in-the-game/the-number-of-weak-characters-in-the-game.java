class Solution {
    public int numberOfWeakCharacters(int[][] power) {
        Arrays.sort(power,(a,b)->{
            if(a[0]==b[0])return b[1]-a[1];
            return a[0]-b[0];
        });
        int[] right=new int[power.length];
        int[] r=new int[power.length];
        int max=-(int)1e9;
        
        for(int i=power.length-1;i>=0;i--){
            max=Math.max(max,power[i][1]);
            
            right[i]=max;
        }
        int ans=0;
        for(int i=0;i<power.length-1;i++){
            if(power[i][1]<right[i+1])ans++;
        }
        return ans;
    }
    
}