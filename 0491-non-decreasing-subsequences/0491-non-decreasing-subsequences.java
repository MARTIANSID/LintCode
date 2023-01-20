class Solution {
     List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
       
        List<Integer> result=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]))continue;
            result.add(nums[i]);
            set.add(nums[i]);
            solve(nums,i+1,result);
            result.remove(result.size()-1);
        }
        
        
        return ans;
    }
    
    public void solve(int[] nums,int index,List<Integer> result){
        
     
            if(result.size()>=2){
                ans.add(new ArrayList<>(result));
            }
        
        
        HashSet<Integer> set=new HashSet<>();
        
        for(int i=index;i<nums.length;i++){
            if(set.contains(nums[i]) || nums[i]<result.get(result.size()-1))continue;
            set.add(nums[i]);
            result.add(nums[i]);
            solve(nums,i+1,result);
            result.remove(result.size()-1);
        }
    }
}
