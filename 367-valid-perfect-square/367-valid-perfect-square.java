class Solution {
    public boolean isPerfectSquare(int num) {
        long leftPtr=1,rightPtr=num;
        
        if(num==1)return true;
        
        while(leftPtr<=rightPtr){
            long mid=leftPtr+(rightPtr-leftPtr)/2;
            
            long square=mid*mid;
            
            if(square==num)return true;
            
            if(square>num){
                rightPtr=mid-1;
            }else{
                leftPtr=mid+1;
            }
        }
        
        return false;
    }
}