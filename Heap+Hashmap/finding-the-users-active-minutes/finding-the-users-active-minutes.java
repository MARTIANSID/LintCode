class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        
        int[] ans=new int[k];
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
        
        for(int[] log:logs){
            int id=log[0];
            int act=log[1];
          HashSet<Integer> set=   map.getOrDefault(id,new HashSet<>());
            set.add(act);
            map.put(id,set);
        }
    for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
      
	    ans[entry.getValue().size()-1]++;
}
        return ans;
    }
}