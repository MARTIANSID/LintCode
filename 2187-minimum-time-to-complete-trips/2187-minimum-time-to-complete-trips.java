class Solution {
    public long minimumTime(int[] time, int totalTrips) {
       
        int n=time.length;
        
            long si = 1,ei = (long)1e14;
        
        while(si<=ei){
            long mid = si+(ei-si)/2;
            
            if(isPossible(time,mid,totalTrips)){
                ei=mid-1;
            }else{
                si=mid+1;
            }
        }
        

        
        
        
        return si;
    }
    
    public boolean isPossible(int[] time,long mid,int totalTrips){
    
        long rounds=0;
        
        for(int i=0;i<time.length;i++){
            rounds+=(mid/time[i]);
        }
        return rounds>=totalTrips?true:false;
        
    }
}