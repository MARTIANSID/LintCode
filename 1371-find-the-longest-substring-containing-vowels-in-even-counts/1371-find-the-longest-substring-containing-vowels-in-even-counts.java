class Solution {
    public int findTheLongestSubstring(String s) {
     
        int xor=0,n=s.length(),max=0;
        
       HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch =='i' || ch == 'o' || ch=='u'){
                xor ^=ch;
            }
            if(map.containsKey(xor)){
                max=Math.max(max,i-map.get(xor));
            }else{
                map.put(xor,i);
            }
            
        }
        
        return max;
        
        
    }
}