class Solution {
    public int maxDistToClosest(int[] seats) {
        int[] left=new int[seats.length];
        int[] right=new int[seats.length];
            left[0]=0;
       for(int i=0;i<seats.length;i++){
               
                if(seats[i]==1){
                        left[i]=0;
                }else{
                        if(i>0)left[i]=left[i-1]+1;
                }
                                // System.out.println(left[i]);

               
             
       }
            
            
         for(int i=seats.length-1;i>=0;i--){
                 if(seats[i]==1){
                        right[i]=0;
                }else{
                        if(i<seats.length-1)right[i]=right[i+1]+1;
                }
                 
                 // System.out.println(right[i]);
               
                 
                 
         }
            
            int max=-(int)1e9;
            for(int i=0;i<seats.length;i++){
                    if(seats[i]==0){
                          // max=Math.max(max,Math.min(left[i],right[i]));  
                            if(left[i]==0){
                                  max=  Math.max(max,right[i]);
                            }else if(right[i]==0){
                                    max=  Math.max(max,left[i]);
                            }else{
                                                                                        max=Math.max(max,Math.min(left[i],right[i]));  
        
                            }
                    }
            }
            
            
            return max;
    }
}