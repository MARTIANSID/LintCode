class Solution {
    public int minFlips(int a, int b, int c) {
        
        int bitA=0,bitB=0,bitC=0,cnt=0;
        
        for(int i=0;i<32;i++){
             bitA=(a&(1<<i))==0?0:1;
             bitB=(b&(1<<i))==0?0:1;
             bitC=(c&(1<<i))==0?0:1;
            
            
            if(bitA==0&&bitB==0){
                if(bitC==1){
                    cnt+=1;
                }
            }else if(bitA==1&&bitB==1){
                if(bitC==0){
                    cnt+=2;
                }
            }else{
                if(bitC!=1){
                    cnt+=1;
                }
            }
            
        }
        return cnt;
    }
}