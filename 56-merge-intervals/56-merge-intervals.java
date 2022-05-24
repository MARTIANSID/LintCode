class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->{
           return a[0]-b[0]; 
        });
        
        List<int[]> result=new ArrayList<>();
        
        int l=intervals[0][0],u=intervals[0][1];
        
        for(int i=1;i<n;i++){
            int nL=intervals[i][0],nU=intervals[i][1];
            
            if(u<nL){
                result.add(new int[]{l,u});
                l=nL;
                u=nU;
            }else if(u>=nL && u<=nU){
                l=Math.min(nL,l);
                u=nU;
            }
        }
        result.add(new int[]{l,u});
        
        int[][] ans=new int[result.size()][2];
        
        for(int i=0;i<ans.length;i++){
            ans[i]=result.get(i);
        }
        
        return ans;
    }
}