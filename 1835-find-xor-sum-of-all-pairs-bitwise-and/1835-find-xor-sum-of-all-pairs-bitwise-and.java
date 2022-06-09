class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        
        int n1=arr1.length;
        int n2=arr2.length;
        
        int[] bits=new int[32];
        
        
        
       for(int ele:arr2){
           for(int i=0;i<32;i++){
               int x=(1<<i);
               int bit=(x&ele)==0?0:1;
               if(bit==1)bits[i]++;
           }
       }
        
        

        
        int ans=0;
        for(int ele:arr1){
            int val=0;
            for(int i=0;i<32;i++){
               int x=(1<<i);
               int bit=(x&ele)==0?0:1;
               if(bit==1){
                   if(bits[i]%2!=0)val+=x;
               }
           }
            ans^=val;
        }
        return ans;
    }
}
