class Solution {
    class pair{
        int freq;
        int val;
        pair(int freq,int val){
            this.freq=freq;
            this.val=val;
        }
    }
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            return a.freq-b.freq;
        });
         for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
                pq.add(new pair(entry.getValue(),entry.getKey()));
        } 
    
        while(k>0){
          pair p=  pq.poll();
          int freq=p.freq;
            if(freq > k){
                pq.add(p);
                break;
            }
            k-=freq;
        }
    
    return pq.size();
    }
}