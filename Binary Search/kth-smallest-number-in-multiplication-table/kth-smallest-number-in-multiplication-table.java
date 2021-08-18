class Solution {
    public int findKthNumber(int m, int n, int k) {
        
        int l=0,r=m*n;
        
        while(l<=r){
            int mid=(l+r)/2;
            if(getCount(mid,m,n)>=k){
                r=mid-1;
            }else{
                l=mid+1;
            }
            
          
            
        }
        
        return l;
        
    }
    
    public int getCount(int val,int m,int n){
        int row=0,col=n-1,count=0;
        
        while(col>=0&&row<m){
            if((col+1)*(row+1)<=val){
                count+=col+1;
                row++;
            }else{
                col--;
            }
        }
        return count;
    }
    
}
