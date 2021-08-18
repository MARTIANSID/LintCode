class Solution {
    
    HashMap<Pair<Integer, Long>, Integer> memo = new HashMap<>();
    public int numberOfArithmeticSlices(int[] nums) {
        
        
        int max=-(int)1e9,min=(int)1e9;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans+=solve(nums,i,(long)max-min+1,1,(long)max-min+1);
        }
        
        return ans;
        
    }
    
    
    public int solve(int[] nums,int index,long diff,int size,long x){
        
        if(index+1>=nums.length){
           return 0;
        }
        
        Pair<Integer,Long>  pair=new Pair(index,diff);
        if(memo.containsKey(pair))return memo.get(pair);
         
        
        int count=0;
        for(int i=index+1;i<nums.length;i++){
            if(diff==x){
                count+=solve(nums,i,(long)nums[i]-nums[index],size+1,x);
                
            }else{
                if((long)nums[i]-nums[index]==diff){
                    count+=solve(nums,i,diff,size+1,x);
                    if(size>=2){
                        count++;
                        
                    }
                    
                   
                }
            }
        }
        
        memo.put(pair,count);
        return count;
        
    }
}