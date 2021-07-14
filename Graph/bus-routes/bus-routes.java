class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
    
        
        HashMap<Integer,ArrayList<Integer>> graph=new HashMap<>();
        
        
        //creating graph
//         for(int j=0;j<routes.length;j++){
//             int[] route=routes[j];
//             for(int i=1;i<route.length;i++){
//              ArrayList<Integer> node=   graph.getOrDefault(route[i-1],new ArrayList<>());
//                 node.add(route[i]);
//                 if(i==route.length-1){
//                                 ArrayList<Integer> n=   graph.getOrDefault(route[i],new ArrayList<>());
//                     n.add(route[0]);
//                     graph.put(route[i],n);

//                 }
//                 graph.put(route[i-1],node);
                
//             }
            
//         }
        
            for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                ArrayList<Integer> buses = graph.getOrDefault(routes[i][j], new ArrayList<>());
                buses.add(i);
                graph.put(routes[i][j], buses);                
            }       
        }
        
        LinkedList<Integer> que=new LinkedList<>();
    HashSet<Integer> set=new HashSet<>();
        que.add(source);
 
        int level=0;
        while(que.size()!=0){
            int size=que.size();
            while(size-->0){
                int p=que.removeFirst();
            ArrayList<Integer>   node  = graph.get(p);
                 
                 if(p==target)return   level;
                
                for(int i=0;i<node.size();i++){
                    int[] bus=routes[node.get(i)];
                     
                     if(set.contains(node.get(i))){
                         continue;
                     }
                    set.add(node.get(i));
                    for(int j=0;j<bus.length;j++){
                       
                           
                            que.add(bus[j]);
                            // map.put(bus[j],1);
                        
                    }
                    
                }
                
            }
            level++;
        }
        
        return -1;
    }
}