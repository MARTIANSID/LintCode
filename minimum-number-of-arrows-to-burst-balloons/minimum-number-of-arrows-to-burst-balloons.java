class Solution {
    public int findMinArrowShots(int[][] points) {
      Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        
        long start=(long)points[0][0];
        long end=(long)points[0][1];
        int  ans=0;
        for(int i=1;i<points.length;i++){
                long s=(long)points[i][0];
                long e=(long)points[i][1];
          // System.out.println(e);
                if(end<s){
                    ans++;
                    end=points[i][1];
                
                    }
                else if(end>=s){
                    end=Math.min(points[i][1],end);
                    
                    
                  
                }
                
        }
        
        // System.out.println(ans);
    
        return ans+1;
        
        
    }
}

// 1,6   2,8   7,12  10,16 
    


   
    
    