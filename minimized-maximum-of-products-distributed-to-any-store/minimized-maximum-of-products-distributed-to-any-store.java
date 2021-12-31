class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int size=quantities.length;
        int lo=0,hi=(int)1e9;
        
        while(lo<=hi){
            int mid=(lo+hi)/2;;
            if(isPossible(mid,n,quantities)){
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        
        return lo;
    }
    public boolean isPossible(int val,int n,int[] quantities){
        int index=0;
        
        int x =quantities[index];
        for(int i=0;i<n;i++){
           
           if(x>=val){
               x-=val;
           }else{
               x=0;
           }
            if(x==0){
                index++;
                if(index==quantities.length)return true;
                x=quantities[index];
            }
        }
        if(x!=0){
            return false;
        }
        return true;
    }
}