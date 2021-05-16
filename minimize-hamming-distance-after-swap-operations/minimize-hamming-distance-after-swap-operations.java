class Solution {
        int findParent(int[] parent,int u){
                
                if(parent[u]==u){
                        return u;
                }
                
                int x=findParent(parent,parent[u]);
                
                parent[u]=x;
                return x;
        }
        
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
   
        int[] parent=new int[source.length];
         for(int i=0;i<parent.length;i++){
                 parent[i]=i;
         }   
          
            
         for(int i=0;i<allowedSwaps.length;i++){
                 int u=allowedSwaps[i][0];
                 int v=allowedSwaps[i][1];
                 
                 int p1=findParent(parent,u);
                 int p2=findParent(parent,v);
                 if(p1!=p2){
                         parent[p1]=p2;
                 }
                 
         }
            
            // for(int i=0;i<parent.length;i++){
            //         System.out.println(parent[i]);
            // }    
            
            HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
            
            
            
            for(int i=0;i<source.length;i++){
                   int p= findParent(parent,i);
                   int val=source[i];
                    if(map.containsKey(p)){
                         HashMap<Integer,Integer> c=   map.get(p);
                            if(c.containsKey(val)){
                                   int x= c.get(val);
                                    c.put(val,x+1);
                            }else{
                                    c.put(val,1);
                                    
                            }
                            map.put(p,c);
                    }else{
                            HashMap<Integer,Integer> j=new HashMap<>();
                            j.put(val,1);
                            map.put(p,j);
                    }
            }
            
            
            int ans=0;
            for(int i=0;i<source.length;i++){
                    int p=findParent(parent,i);
                    int val=target[i];
                    
                 HashMap<Integer,Integer> m=   map.get(p);
                    if(m.containsKey(val)){
                        int x=    m.get(val);
                           if(x-1==0){
                                   m.remove(val);
                                   
                                   continue;
                           } else{
                                   m.put(val,x-1);
                                   map.put(p,m);
                           }
                            
                    }else{
                            ans++;
                    }
                    
            }
            
            
            
            return ans;
          
        
                
           
            
    }
}