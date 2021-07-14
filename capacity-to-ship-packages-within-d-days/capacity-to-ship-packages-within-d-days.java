class Solution {
    
    public boolean isPossible(int[] weights,int days,int max){
        
        int d=1;
        int sum=0;
        
    
        for(int i=0;i<weights.length;i++){
               
            
            if(weights[i]>max)return false;
                if(sum+weights[i]>max){
                    sum=weights[i];
                    d++;
                }else{
                    sum+=weights[i];
                }
            
        }
        
        // if(max==2)System.out.println(d);
        
        
        if(d>days)return false;
        else return true;
        
        
        
    }
    public int shipWithinDays(int[] weights, int days) {
        
        
        
        int low=0,high=(int)1e9;
        
        while(low<=high){
            int mid=(low+high)/2;
            
            if(isPossible(weights,days,mid)){
                high=mid-1;
                
            }else{
                low=mid+1;
            }
            
            
        }
        
        return low;
    }
}