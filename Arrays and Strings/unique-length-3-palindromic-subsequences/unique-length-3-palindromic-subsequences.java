class Solution {
    public int countPalindromicSubsequence(String s) {
        
       HashMap<Character,Integer> map=new HashMap<>();


        
        int[] last=new int[26];

        int ans=0;
        
        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i;
        }
        
        
//         for(int i=0;i<s.length;i++){
//             char ch=s.charAt(i);
//             if(!map.containsKey()){
                
                
//             }
//         }
        
        
        
        
        for( int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!map.containsKey(ch)){
                
               int x= last[s.charAt(i)-'a'];
            if(i<x&&x-i-1>=1)
          ans+= s.substring(i + 1, x).chars().distinct().count();
                map.put(ch,0);
            }
        }
        
        return ans;
       
        
    }
}