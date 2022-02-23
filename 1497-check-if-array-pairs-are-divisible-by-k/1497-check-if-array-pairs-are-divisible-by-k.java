class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            int rem=arr[i]%k;
            if(rem<0)rem=rem+k;
            int needed=(k-rem)%k;
            if(map.containsKey(needed)){
                int f=map.get(needed);
                f--;
                if(f==0)map.remove(needed);
                else map.put(needed,f);
            }else
            map.put(rem,map.getOrDefault(rem,0)+1);
            
        }
        
       
        
        return map.size()==0?true:false;
    }
}