class Solution {
           int mod=(int)1e9+7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
     
            HashMap<String,Long> map=new HashMap<>();
            return (int)(solve(locations,start,finish,fuel,map)%mod);
    }
        public long solve(int[] locations,int current,int finish,int fuel,HashMap<String,Long> map){
                
                
               StringBuilder g=new StringBuilder();
                g.append(fuel).append(" ").append(current);
                String key=new String(g);
                if(map.containsKey(key))return map.get(key);
                
                  long count=0;
                
                if(current==finish){
                          for(int i=0;i<locations.length;i++){
                        if(i!=current){
                                if(fuel-Math.abs(locations[i]-locations[current])>=0){
                                        
                                       count=(count + solve(locations,i,finish,fuel-Math.abs(locations[i]-locations[current]),map))%mod;
                                }
                        }
                }
                        return count+1;
                }
                
                
              
                
                for(int i=0;i<locations.length;i++){
                        if(i!=current){
                                if(fuel-Math.abs(locations[i]-locations[current])>=0){
                                        
                                       count=(count+ solve(locations,i,finish,fuel-Math.abs(locations[i]-locations[current]),map))%mod;
                                }
                        }
                }
                map.put(key,count);
                
                return count;
        }
}