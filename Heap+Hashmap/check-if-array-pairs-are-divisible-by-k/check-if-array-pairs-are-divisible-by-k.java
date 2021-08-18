class Solution {
    public boolean canArrange(int[] arr, int k) {
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            int rem=arr[i]%k;
            if(rem<0)rem+=k;
            
            
            if(map.containsKey((k-rem)%k)){
               int x= map.get((k-rem)%k);
                x--;
                if(x==0)map.remove((k-rem)%k);
                else map.put((k-rem)%k,x);
            }else{
                map.put(rem,map.getOrDefault(rem,0)+1);
            }
            
        }
        
        if(map.size()==0)return true;
        return false;
        
    }
}

