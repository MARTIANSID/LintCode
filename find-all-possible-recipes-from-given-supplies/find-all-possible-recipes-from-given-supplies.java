class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
  
        
        
        HashMap<String,List<String>> map=new HashMap<>();
        HashMap<String,Integer> indegree=new HashMap<>();
        
        //make graph
        
        int n=recipes.length;
        for(int i=0;i<n;i++){
       List<String> ing= ingredients.get(i);
        String dish=recipes[i];
        
            for(String in:ing){
                if(map.containsKey(in)){
                    map.get(in).add(dish);
                    
                }else{
                    List<String> temp=new ArrayList<>();
                    temp.add(dish);
                    map.put(in,temp);
                }
                indegree.put(dish,indegree.getOrDefault(dish,0)+1);
            }
    }
        
        List<String> ans=new ArrayList<>();
        
        LinkedList<String> que=new LinkedList<>();
        
        for(String sup:supplies){
            que.add(sup);
        }
        //apply khans algo
        
        while(que.size()!=0){
            int size=que.size();
            while(size-->0){
                String d=que.removeFirst();
                if(map.containsKey(d))
                for(String op:map.get(d)){
                    indegree.put(op,indegree.get(op)-1);
                    if(indegree.get(op)==0){
                        que.add(op);
                        ans.add(op);
                    }
                }
            }
        }
        
        
        return ans ;
        
        
    }
}