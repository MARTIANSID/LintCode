class Solution {
    public int numberOfSubstrings(String s) {
        
        
            int[] freq=new int[4];
            freq[0]++;
            freq[1]++;
            freq[2]++;
            int count=3;
            int ansFound=0;
        int ei=0,si=0,n=s.length(),ans=0;
        
        while(ei<n){
                while(ei<n&&count!=0){
                    freq[s.charAt(ei)-'a']--;
                    if(freq[s.charAt(ei)-'a']==0)count--;
                    
                    ei++;
                }
            
                while(count==0){
                    freq[s.charAt(si)-'a']++;
                    if(freq[s.charAt(si)-'a']==1)count++;
                
                    // System.out.println(n-ei+1);/
                    ans+=(n-ei+1);
                    si++;
                }
            
            
        }
        return ans;
    }
}





// 3 3 4
//    acb
//    accaabb
    
// [aaaaacccbbbb]

// [a,b,c,a,b,c]
