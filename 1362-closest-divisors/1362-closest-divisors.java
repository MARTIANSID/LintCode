class Solution {
    public int[] closestDivisors(int num) {
        int min=(int)1e9,val1=0,val2=0;
        for(int i=1;i*i<=(num+1);i++){
            if((num+1)%i==0){
                int diff=((num+1)/i)-i;
                if(diff<min){
                    min=diff;
                    val1=((num+1)/i);
                    val2 =i;
                }
            }
        }
        for(int i=1;i*i<=(num+2);i++){
            if((num+2)%i==0){
                int diff=((num+2)/i)-i;
                if(diff<min){
                    min=diff;
                    val1=((num+2)/i);
                    val2 =i;
                }
            }
        }
        
        return new int[]{val1,val2};
        
    }
}