class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
            
            for(int i=0;i<arr.length;i++){
                    if(map.containsKey(arr[i])){
                          int x=  map.get(arr[i]);
                            map.put(arr[i],x+1);
                    }
                    else map.put(arr[i],1);
            }
          HashMap<Integer,Boolean> map1=new HashMap<>();
            for (Map.Entry mapElement : map.entrySet()) {
            int key = (int)mapElement.getValue();
            
                    if(map1.containsKey(key)){
                            return false;
                    }else{
                            map1.put(key,true);
                    }
                    
         
                    
        }
            
            return true;
    }
}