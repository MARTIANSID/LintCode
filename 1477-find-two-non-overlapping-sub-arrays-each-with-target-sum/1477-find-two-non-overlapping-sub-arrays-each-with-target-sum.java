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
        
        // PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
        //     return a.end-b.end;
        // });
        
        int min=(int)1e9,sum=0,ans=(int)1e9;
        
        map.put(0,-1);
        
        int[] left=new int[n];
        
        Arrays.fill(left,(int)1e9);
        
        for(int i=0;i<n;i++){
            sum+=arr[i];
            
            boolean flag=false;
            
            if(map.containsKey(sum-target)){
              int s=map.get(sum-target);
                if(s==-1){
                    left[i]=i-s;
                    map.put(sum,i);
                    continue;
                }
                
                int val=left[s];
                
                if(val!=(int)1e9){
                    ans=Math.min(ans,val+i-s);
                }
                
                left[i]=Math.min(left[i-1],i-s);    
                flag=true;
            }
            if(!flag&&i>0){
                left[i]=left[i-1];
            }
            
            map.put(sum,i);
            
            
        }
        
        return ans==(int)1e9?-1:ans;
        
        
        
        
    }
}