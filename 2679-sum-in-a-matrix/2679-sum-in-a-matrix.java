class Solution {
    public int matrixSum(int[][] nums) {
        int n=nums.length;
        int m=nums[0].length;
        
        HashMap<Integer,PriorityQueue<Integer>> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            map.put(i,new PriorityQueue<>());
            for(int j=0;j<m;j++){
                map.get(i).add(nums[i][j]);
            }
        }
        int score=0;
        while(map.get(0).size()>0){
            int max=0;
             for(int i=0;i<n;i++){
             max=Math.max(max,map.get(i).poll());
        }
            score+=max;
            
        }
        return score;
       
    }
}