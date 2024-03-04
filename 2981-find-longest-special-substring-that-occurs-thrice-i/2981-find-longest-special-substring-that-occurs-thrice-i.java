class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        
        HashMap<Character,int[]> map = new HashMap<>();
        
        for(char i='a';i<='z';i++){
            map.put(i,new int[1000]);
        }
        
        int ans=0;
    
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            int freq = 0;
            for(int j=i;j<n;j++){
                if(s.charAt(j) == ch){
                    freq++;
                    map.get(ch)[freq]++;
                    if(map.get(ch)[freq]>=3){
                        ans = Math.max(ans,freq);
                    }
                }else{
                    break;
                }
            }
        }
        
        return ans == 0 ? -1 : ans;
    }
}
