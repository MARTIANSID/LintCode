class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int oneAt=0;
        for(int i=31;i>=0;i--){
            int x=1<<i;
            int bit=(left&x)==0?0:1;
            if(bit==1){
                oneAt=i;
                break;
            }
        }
        
        int val=1<<(oneAt+1);
     
        if(val>=0 && right>=val)return 0;

       
        long and=-1;
        for(long i=left;i<=right;i++){
            and = (and&i);
            
        }
        
        return (int)and;
    }
}