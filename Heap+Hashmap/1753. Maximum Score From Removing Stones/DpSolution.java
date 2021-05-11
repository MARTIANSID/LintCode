class Solution {
    public int maximumScore(int a, int b, int c) {
        
           HashMap<String,Integer> map=new HashMap<>();
            
            return solve(a,b,c,map);
            
            
            
            
    }
        public int solve(int a,int b,int c,HashMap<String,Integer> map){
                
                
                  StringBuilder sb = new StringBuilder();
    sb.append(a+" ").append(b+ " ").append(c+" ");
                
    String list = sb.toString();
                
                
               if(a==0&&b==0||c==0&&b==0||a==0&&c==0||a==0&&b==0&&c==0){
                       map.put(list,0);
                     return  0;
               } 
                if( map.containsKey(list)) { 
                        // System.out.println("hello");
                       return map.get(list);}
                
                
                int x=-(int)1e9;
                int y=-(int)1e9;
                int z=-(int)1e9;
                
                if(a>0&&c>0)
                x=solve(a-1,b,c-1,map)+1;
                
                if(a>0&&b>0)
                y=solve(a-1,b-1,c,map)+1;
                
                
                if(b>0&&c>0)
                z=solve(a,b-1,c-1,map)+1;
                
                int m= Math.max(Math.max(x,y),z); 
                 map.put(list,m);
               return m;
                
                
        }
        
}