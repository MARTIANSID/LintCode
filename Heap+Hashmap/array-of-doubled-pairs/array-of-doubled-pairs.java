class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        
        Arrays.sort(arr);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int ele:arr){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        
        for(int ele:arr){
            if(!map.containsKey(ele))continue;
            if(ele<0){
                if(ele%2!=0)return false;
                if(map.containsKey(ele/2)){
                  int x=  map.get(ele);
                    x--;
                    if(x==0)map.remove(ele);
                    else map.put(ele,x);
                   x= map.get(ele/2);
                    
                      x--;
                    if(x==0)map.remove(ele/2);
                    else map.put(ele/2,x);
                }
                
            }else if(ele>0){
                if(map.containsKey(2*ele)){
                    
                     int x=  map.get(ele);
                    x--;
                    if(x==0)map.remove(ele);
                    else map.put(ele,x);
                   x= map.get(2*ele);
                    
                      x--;
                    if(x==0)map.remove(2*ele);
                    else map.put(2*ele,x);
                        
                }else return false;
            }else{
              int x= map.get(ele);
                if(x>=2){
                    
                    x--;
                    if(x==0)map.remove(ele);
                    else map.put(ele,x);
                   x= map.get(2*ele);
                    
                      x--;
                    if(x==0)map.remove(2*ele);
                    else map.put(2*ele,x);
                }else return false;
            }
        }
        return  map.size()==0? true:false;
    }
}