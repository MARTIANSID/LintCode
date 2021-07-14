class Solution {
    
    
    
    public boolean isPossible(int[] bloomDay,int m,int k,int day){
        
        int count=0;
        int i=0;
        
        while(m!=0&&i<bloomDay.length){
            if(bloomDay[i]<=day){
                count++;
            }  else{
                count=0;
            }
            
            if(count==k){
                count=0;
                m--;
            }
            i++;
                
        }
        
        if(m==0)return true;
        else return false;
        
    }
    
    
    
    
    public int minDays(int[] bloomDay, int m, int k) {
        
        
        int low=0,high=(int)1e9;
        
        while(low<=high){
            int mid=(low+high)/2;
            if(isPossible(bloomDay,m,k,mid)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low==(int)1e9+1?-1:low;
    }
}



// [7,7,7,12]