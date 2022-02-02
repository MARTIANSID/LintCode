class Solution {
    
    class pair{
        int end;
        int val;
        
        pair(int end,int val){
            this.end=end;
            this.val=val;
        }
    }
    
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            return a.end-b.end;
        });
        
        int min=(int)1e9,sum=0,ans=(int)1e9;
        
        map.put(0,-1);
        
        for(int i=0;i<n;i++){
            sum+=arr[i];
            
            if(map.containsKey(sum-target)){
                int start=map.get(sum-target)+1;
                while(pq.size()>0&&pq.peek().end<start){
                    min=Math.min(min,pq.poll().val);
                }
                
                if(min!=(int)1e9){
                    ans=Math.min(ans,min+i-(start-1));
                }
                
                pq.add(new pair(i,i-(start-1)));
            }
            
            map.put(sum,i);
            
            
        }
        
        return ans==(int)1e9?-1:ans;
        
        
        
        
    }
}