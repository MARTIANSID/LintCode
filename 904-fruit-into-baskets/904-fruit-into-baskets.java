class Solution {
    public int totalFruit(int[] fruits) {
        int count=0;
        
        int ei=0,si=0,n=fruits.length,max=0;
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        while(ei<n){
            int fruit=fruits[ei++];
            if(!map.containsKey(fruit)){
                    //decrease the window
                    while(map.size()==2){
                        int fruitAtSi=fruits[si++];
                    
                        int x= map.get(fruitAtSi);
                        x--;
                        if(x==0){
                            map.remove(fruitAtSi);
                        }else{
                            map.put(fruitAtSi,x);
                        }
                    }
                    
                    map.put(fruit,1);
                
            }else{
                map.put(fruit,map.get(fruit)+1);
              
                
            }
              max=Math.max(max,ei-si);
        }
        return max;
    }
}