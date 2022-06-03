class Solution {
    public int[] singleNumber(int[] nums) {
        int n=nums.length;
        
        int xor=0;
        
        for(int ele:nums){
            xor^=ele;
        }
        
        int one=-1;
        for(int i=0;i<32;i++){
            int x =(1<<i);
            int bit=(xor&x) == 0 ? 0 : 1;
            if(bit == 1){
                one=i;
                break;
            }
        }
        
        int xor1=0,xor2=0;
        
        for(int ele:nums){
            int x=(1<<one);
            int bit=(ele&x) == 0 ? 0 : 1;
            if(bit == 0){
                xor1^=ele;
            }else{
                xor2^=ele;
            }
        }
        return new int[]{xor1,xor2};
        
    }
}