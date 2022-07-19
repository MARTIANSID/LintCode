class Solution {
    HashMap<String,Integer> map=new HashMap<>();
    public int minCost(int n, int[] cuts) {
        
        
        return dfs(cuts,0,n);
    }
    public int dfs(int[] cuts,int si,int ei){
        
        if(ei-si==1)return 0;
        
        String key=si+"."+ei;
        
        if(map.containsKey(key))return map.get(key);

        
        int min=(int)1e9;
        for(int cut:cuts){
           if(cut>=ei || cut<=si)continue; 
            int left=dfs(cuts,si,cut);
            int right=dfs(cuts,cut,ei);
            min=Math.min(min,left+right);
        }
        if(min==(int)1e9)return 0;
        map.put(key,min+ei-si);
        return min+(ei-si);
    }
}