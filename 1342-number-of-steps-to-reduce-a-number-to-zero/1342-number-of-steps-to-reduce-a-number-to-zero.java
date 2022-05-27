class Solution {
    public int numberOfSteps(int n) {
        int one=0,zero=0;
        boolean flag=false;
        for(int i=31;i>=0;i--){
            int x=(1<<i);
            int bit=(n&x)==0?0:1;
            if(bit==1){
                one++;
                flag=true;
            }else if(flag){
                zero++;
            }
        }
        if(n==0)return 0;
        return (2*one+zero-1);
    }
}