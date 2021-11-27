class Solution {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int ele:changed){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        
        List<Integer> ans=new ArrayList<>();
        for(int ele:changed){
            if(ele==0){
                if(map.containsKey(ele)){
                   int x= map.get(ele);
                    if(x>=2){
                        ans.add(0);
                    }else{
                        return new int[]{};
                    }
                    
                    x-=2;
                    if(x==0)map.remove(ele);
                    else map.put(ele,x);
                   
                }
                
                continue;
            }
            
            if(map.containsKey(ele)&&map.containsKey(2*ele)){
              int x=  map.get(ele);
                x--;
                map.put(ele,x);
                if(x==0)map.remove(ele);
                
                 x=  map.get(2*ele);
                x--;
                map.put(2*ele,x);
                if(x==0)map.remove(2*ele);
                ans.add(ele);
            }else if(map.containsKey(ele)&&!map.containsKey(2*ele)) {
                return new int[]{};
            }
        }
        
      
        
        int[] result=new int[changed.length/2];
        for(int i=0;i<ans.size();i++)result[i]=ans.get(i);
        
        
        return result;
    }
}