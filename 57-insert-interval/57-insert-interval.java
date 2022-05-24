class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result=new ArrayList<>();
        int n=intervals.length;
        
        int newL=newInterval[0],newU=newInterval[1];
        
        boolean added=false;
        
        for(int[]  interval:intervals){
            int l=interval[0],u=interval[1];
           
            if(newU < l){
                if(!added)
                result.add(new int[]{newL,newU});
                result.add(new int[]{l,u});
                added=true;
            }else if(newU>=l && newU<=u){
                newL=Math.min(l,newL);
                result.add(new int[]{newL,u});
                added=true;
            }else if(newL<=u){
                newL=Math.min(l,newL);
            }else if(newL>l){
                result.add(interval);
            }
           
        }
        
        if(!added){
            result.add(new int[]{newL,newU});
        }
        
        
        int[][] ans=new int[result.size()][2];
        
        for(int i=0;i<ans.length;i++){
            ans[i]=result.get(i);
        }
        
        return ans;
    }
}