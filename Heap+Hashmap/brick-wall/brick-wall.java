class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        
        int sum=0;
        for(int i=0;i<wall.get(0).size();i++){
            sum+=wall.get(0).get(i);
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int max=0;
        
        for(List<Integer> row:wall){
            int end=0;
            for(int i=0;i<row.size()-1;i++){
                end+=row.get(i);
                map.put(end,map.getOrDefault(end,0)+1);
                max=Math.max(max,map.get(end));
            }
            
        }
        
      
        return wall.size()-max;
        
        
    }
}