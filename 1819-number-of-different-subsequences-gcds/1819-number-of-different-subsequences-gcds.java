class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
         int n=nums.length,max=-(int)1e9;
        
        HashMap<Integer,Boolean> map=new HashMap<>();
        for(int ele:nums){
            map.put(ele,true);
           max=Math.max(max,ele);        
        }
        
        int cnt=0;
        for(int i=1;i<=max;i++){
            int prev=-1;
            for(int j=i;j<=max;j+=i){
                
                if(map.containsKey(j)){
                    if(prev!=-1)
                   prev=gcd(j,prev);
                    else
                        prev=j;
                    
                    if(prev==i)break;
                }
            }
        
            if(prev==i)cnt++;
        }
        
        return cnt;
            
    }
    
    public int gcd(int a,int b){
        if(b==0)return a;  
        return gcd(b,a%b);
    }
}