class Solution {
    public long[] getDistances(int[] arr) {
        int n=arr.length;
        
        HashMap<Integer,List<Long>> map=new HashMap<>();
        for (int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                map.get(arr[i]).add((long)i);
            }else{
                List<Long> temp=new ArrayList<>();
                temp.add((long)i);
                map.put(arr[i],temp);
                
            }
        }
        
        
        long[] ans=new long[n];
        
        for (Map.Entry<Integer, List<Long>> entry : map.entrySet()) {
               List<Long> temp= entry.getValue();
                int size =temp.size();
                long sum=0;
                
            for(long ele:temp){
                sum+=ele;
            }
            
            long s=0;
            for(int i=0;i<size;i++){
               if(i==0){
                   ans[(int)(long)temp.get(i)]=(sum-(long)((size)*temp.get(i)));
                   s+=temp.get(i);
               }else if(i==size-1){
                    ans[(int)(long)temp.get(i)]=(long)((size-1)*temp.get(i))-s;
               }else{
                   
                  ans[(int)(long)temp.get(i)] =(sum-s-(long)((size-i)*temp.get(i)))+((long)((i)*temp.get(i))-s);
                   s+=temp.get(i);
               }
                
            }
            
            
                
        }
        return ans ;
    }
}