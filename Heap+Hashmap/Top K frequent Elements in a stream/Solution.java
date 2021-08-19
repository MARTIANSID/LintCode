class Solution
{ 
     static class  pair{
        int freq;
        int val;
        pair(int freq,int val){
            this.freq=freq;
            this.val=val;
        }
    }
    static ArrayList<Integer> kTop(int[] arr, int n, int k) 
    { 
       HashMap<Integer,Integer> map=new HashMap<>();
       PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
           if(a.freq==b.freq)return a.val-b.val;
           else return b.freq-a.freq;
           
           });
           
           ArrayList<Integer> ans=new ArrayList<>();
           for(int i=0;i<n;i++){
               map.put(arr[i],map.getOrDefault(arr[i],0)+1);
               for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                pq.add(new pair(entry.getValue(),entry.getKey()));
                }
                int size=k;
                while(pq.size()>0&&size-->0){
                   ans.add(pq.poll().val);
                }
                
                pq.clear();
                
           }
           
           return ans;  
       
    }
}
