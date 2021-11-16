class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        
        int start=intervals[0][0];
        int end=intervals[0][1];
        
        List<int[]> ans =new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            int s=intervals[i][0];
            int e=intervals[i][1];
            
            if(end>=s){
                end=Math.max(end,e);
            }else{
                ans.add(new int[]{start,end});
                start=s;
                end=e;
            }
        }
      
        ans.add(new int[]{start,end});
        
        
        int s1=ans.size();
        int[][] result=new int[s1][2];
        
        for(int i=0;i<s1;i++){
            for(int j=0;j<2;j++){
                result[i][j]=ans.get(i)[j];
            }
        }
        
        return result;
    }
}