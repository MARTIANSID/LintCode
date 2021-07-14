class Solution {
    public int mySqrt(int x) {
        if(x==0)return 0;
        
     int si=1,hi=(int)1e9;
    
        while(si<=hi){
            int mid=(si+hi)/2;
            if(mid==x/mid)return mid;
            else if(mid>x/mid)hi=mid-1;
            else{
                si=mid+1;
            }
        }
        
        return si-1;
    }
}