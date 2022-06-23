class Solution {

    
    /*
    
    do xor of start and goal different bits will give 1 and same bits will give 0
    now we need to count only set bits in it (as we need flip only at the place where the bits are different)
    
    */
    public int minBitFlips(int start, int goal) {
         int xor=start^goal;
        
        int bits=0;
        for(int i=0;i<32;i++){
            int x=(1<<i);
            int bit=(xor&x)==0?0:1;
            if(bit==1)bits++;
        }
        return bits;
        
    }
}