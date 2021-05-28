class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
           int si=0;
           int ei=0;
           int n=customers.length;
           int sum=0;
            int gsi=-1;
            int max=0;
            int actual=0;
            int s=0;
            while(ei<n){
                    sum+=customers[ei];
                    if(grumpy[ei]==1)actual+=customers[ei];
                   ei++;
                    
                   while(ei-si>minutes){
                           sum-=customers[si];
                             if(grumpy[si]==1)actual-=customers[si];
                           si++;
                   }
                    
                   if(ei-si==minutes){
                          if(max<actual){
                                  
                                gsi=si;
                                  max=actual;
                                  s=sum;
                                  
                          }
                   } 
                    
                    
            }
            
            
            
            // System.out.println(gsi);
            
          int ans=0;
           for(int i=0;i<customers.length;i++){
                   if(i!=gsi&&grumpy[i]==0){
                           // System.out.println(customers[i]);
                           ans+=customers[i];
                   }
                   
                   if(i==gsi){
                           ans+=s;
                           i+=minutes-1;
                   }
           }
            return ans;
            
    }
}