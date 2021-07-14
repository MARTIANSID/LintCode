class Solution {
    class pair{
        int val;
        int index;
        pair(int val,int index){
            this.val=val;
            this.index=index;
        }
    }
    public int maxWidthRamp(int[] nums) {
        
        
        List<pair> l=new ArrayList<>();
    for(int i=0;i<nums.length;i++){
        l.add(new pair(nums[i],i));
    }
        
        
        Collections.sort(l,(a,b)->{
            if(a.val==b.val){
               return  a.index-b.index;
            }else{
               return  a.val-b.val;
            }
        });
        
        
        int[] pre=new int[nums.length];
        
        int min=(int)1e9;
        for(int i=0;i<l.size();i++){
        pair p=l.get(i);
            
            pre[i]=min;
            min=Math.min(min,p.index);
        }
        
        
        int ans=-(int)1e9;
        for(int i=0;i<l.size();i++){
            if(i>0){
    
                ans=Math.max( ans,l.get(i).index-pre[i]);
            }
        }
        
        return ans<0?0:ans;
        
        
    }
}


// [6,0,8,2,1,5]  

// Input: nums = [6,0,8,2,1,5]
// Output: 4
// Explanation: 
// The maximum width ramp is achieved at (i, j) = (1, 5): nums[1] = 0 and nums[5]

// [6,0,8,2,1,5]/




    