class Solution {
    public boolean isHappy(int n) {
        // At the end the number will either stop at one or will form a cycle,so if we apply floyds algorithm we can check if a cycle is there or not,if the fast ptr becomes equal to one we can simply say that the n is a happy number
        
        
        int slow=-2;
        int fast=-1;
        while(fast!=1&&slow!=fast){
            
            slow=get(slow,n);
            fast=get(get(fast,n),n);
        }
        
       return fast==1?true:false;
        
        
    }
    
    public int get(int no,int n){
        if(no==-1||no==-2){
            no=n;
        }
        int total=0;
        while(no!=0){
            int nn=no%10;
            total+=nn*nn;
            no=no/10;
        }
        
        return total;
    }
}