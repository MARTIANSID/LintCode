class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
            
           for(int i=0;i<arr.length;i++){
                   if(map.containsKey(arr[i])){
                          int x =map.get(arr[i]);
                           map.put(arr[i],x+1);
                   }else{
                           map.put(arr[i],1);
                   }
           }
            
            List<Integer> freq=new ArrayList<>();
            
            for (Map.Entry mapElement : map.entrySet()) {
    
            int value = ((int)mapElement.getValue());
                    freq.add(value);
  
            
        }
            Collections.sort(freq);
            
            int sum=0,count=0;
            for(int i=freq.size()-1;i>=0;i--){
                    count++;
                    sum+=freq.get(i);
                    if(sum>=arr.length/2)return count;
            }
            
            return count;
    }
}