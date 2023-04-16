class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n=nums.length;
        
        int si=0,ei=(int)1e9;
        
        Arrays.sort(nums);
        
        while(si<=ei){
            int mid=(si+ei)/2;
            if(isPossible(mid,nums,p)){
                ei=mid-1;
            }else{
                si=mid+1;
            }
        }
        return si;
        
    }
    public boolean isPossible(int val,int[] nums,int p){
        int n=nums.length;
        boolean[] visited=new boolean[n];
        
        if(p==0)return true;
        
        for(int i=1;i<n;i++){
            if(visited[i])continue;
            
            if(!visited[i-1] && nums[i]-nums[i-1]<=val){
                visited[i]=true;
                p--;
            }
            if(p==0)return true;
        }
        return false;
    }
} 


/*
Approach is simple use binary search for every number

*/