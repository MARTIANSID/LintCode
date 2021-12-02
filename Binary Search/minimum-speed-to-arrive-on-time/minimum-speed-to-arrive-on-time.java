class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        
        int  si=1,ei=(int)1e9;
        
        while(si<=ei){
            int mid=(si+ei)/2;
            if(solve(dist,mid,hour)){
                 ei=mid-1;
            }else{
                si=mid+1;
            }
        }
        return si>=(int)1e9?-1:si;
        
    }
    
    public boolean solve(int[] dist,int speed,double hour){
        double t=0;
        for(int i=0;i<dist.length;i++){
            if(i<dist.length-1)
              t+=Math.ceil((double)(((double)dist[i]/(double)speed)));
            else
                t+=(double)(((double)dist[i]/(double)speed));
        }
        if(t<=hour)return true;
        return false;
    }
}