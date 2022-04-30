class Solution {

    class pair {
        String vrtx;
        double weight;

        pair(String vrtx, double weight) {
            this.vrtx = vrtx;
            this.weight = weight;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<pair>> graph = new HashMap<>();
        int index = 0;

        for (List<String> e : equations) {
            String u = e.get(0), v = e.get(1);
            double weight = values[index++];
            //it will be a directed graph
            if (graph.containsKey(u)) {
                graph.get(u).add(new pair(v, weight));
            } else {
                List<pair> temp = new ArrayList<>();
                temp.add(new pair(v, weight));
                graph.put(u, temp);
            }
            
             if (graph.containsKey(v)) {
                graph.get(v).add(new pair(u, (1/weight)));
            } else {
                List<pair> temp = new ArrayList<>();
                temp.add(new pair(u, (1/weight)));
                graph.put(v, temp);
            }
        }
     

        double[] ans = new double[queries.size()];
        
        index=0;
        

        for (List<String> q : queries) {
            ans[index++]=dfs(graph,new HashMap<>(),q.get(0),q.get(1),1);
        }
        return ans;
    }
    
    public double dfs(HashMap<String,List<pair>> graph,HashMap<String,Boolean> visited,String src,String dest,double val){
        
        if(src.equals(dest) && graph.containsKey(dest)){
            return val;
        }
        
        visited.put(src,true);
        if(graph.containsKey(src))
        for(pair p:graph.get(src)){
            if(!visited.containsKey(p.vrtx)){
               double v= dfs(graph,visited,p.vrtx,dest,val*p.weight);
                if(v!=-1)return v;
            }
        }
        visited.remove(src);
        return -1;
    }
       
}
