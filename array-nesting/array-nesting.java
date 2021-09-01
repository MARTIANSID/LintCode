class Solution {
    public int arrayNesting(int[] nums) {
            int n=nums.length;  
        
        HashSet<Integer> set=new HashSet<>();
        
        boolean[] visited=new boolean[n];
        int max=0;
        for(int i=0;i<n;i++){
               int val=nums[i];
            if(visited[val])continue;
            int count=0;
            while(true){
                
                if(set.contains(val))break;
                set.add(val);
                visited[val]=true;
                
                val=nums[val];
                count++;
            }
            max=Math.max(max ,count);
                
        }
        return max;
    }
}