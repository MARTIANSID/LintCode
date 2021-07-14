class Solution {
    public int totalFruit(int[] fruits) {
        int basket=2;
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int ei=0,si=0,n=fruits.length,ans=0,max=0;
        
        while(ei<n){
            while(ei<n&&basket>=0){
              int x=  fruits[ei];
                if(!map.containsKey(x)){
                    map.put(x,1);
                    basket--;
                }else{
                   int y= map.get(x);
                    y ++;
                    map.put(x,y);
                }
                 ans++;
                // if(basket<0)break;
                ei++;
               
            }
           
            // System.out.println(ans);
            
         max=   Math.max(max,ans-1);
            if(ei==n&&basket>=0)max=Math.max(max,ans);
            
            
        while(basket<0){
            int x=fruits[si];
            
       
               int u= map.get(x);
            
            u--;
        
            if(u>0){
                map.put(x,u);
                
            }else{
                map.remove(x);
                basket++;
            }
        
             ans--;
        
        
           
            si++;
        }
            
            // System.out.println(ans);
            
            
        }
        
        return max;
    }
}


// [3,3,3,1,2]

