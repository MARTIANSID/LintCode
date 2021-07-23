class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
    
        
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        List<int[]> eng=new ArrayList<>();
        for(int i=0;i<speed.length;i++){
            int[] a=new int[2];
            a[0]=speed[i];
            a[1]=efficiency[i];
            eng.add(a);
        }
        
        Collections.sort(eng,(a,b)->{
           return b[1]-a[1];
        });
        
        int mod=(int)1e9+7;
        long sum=0,size=0;
        
        int j=0;
        long ans=0;
        int val=k;
        while(k-->0){
            pq.add(eng.get(j)[0]);
            sum=(sum+eng.get(j)[0]);
            ans=Math.max(ans,((long)(sum*eng.get(j)[1])));
            j++;
        }
        
      // ans=sum*eng.get(val-1)[1];
        for(int i=val;i<eng.size();i++){
         
                if(pq.peek()>=eng.get(i)[0]){
                    continue;
                }else{
                    
                   int x= pq.poll();
                    sum=(sum-x);
                    pq.add(eng.get(i)[0]);
                    sum= (sum+eng.get(i)[0]);
                    ans=Math.max(ans,((long)(sum*eng.get(i)[1])));
                }
            
        }
        
        return (int)(ans%mod);
        
    }
}



