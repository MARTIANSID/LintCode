class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        
        List<List<Integer>> ans=new ArrayList<>();
        
        boolean[] visited=new boolean[n];
        
        dfs(ans,new ArrayList<>(),visited,nums);
        
        return ans;
    }
    
    public void dfs(List<List<Integer>> ans,List<Integer> result,boolean[] visited,int[] nums){
        
        if(result.size() == nums.length){
            ans.add(new ArrayList<>(result));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(visited[i])continue;
            result.add(nums[i]);
            visited[i]=true;
            dfs(ans,result,visited,nums);
            result.remove(result.size()-1);
            visited[i]=false;
        }
        
    }
}