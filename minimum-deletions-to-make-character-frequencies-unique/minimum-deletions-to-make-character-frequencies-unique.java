class Solution {
    public int minDeletions(String s) {
        Integer[] freq=new Integer[26];
        Arrays.fill(freq,0);
        int ans=0;
        
        for(int i=0;i<s.length();i++){
            
            freq[s.charAt(i)-'a']++;
        }
    
        
       Arrays.sort(freq,Collections.reverseOrder());
        
    
        int delete=0;
        for(int i=1;i<freq.length;i++){
            int prev=freq[i-1];
            if(freq[i]==0)continue;
            if(prev==0){
                delete+=freq[i];
                freq[i]=0;
                continue;
            }
            if(prev<=freq[i]){
                delete+=-(prev-freq[i]-1);
                freq[i]+=prev-freq[i]-1;
                
                
            }
        }
        
        
        return delete;
    }
}




