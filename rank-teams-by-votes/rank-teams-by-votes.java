class Solution {
    public String rankTeams(String[] votes) {
        int[][] ranks=new int[26][26];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<votes.length;i++){
            String str=votes[i];
            
            for(int j=0;j<str.length();j++){
                ranks[str.charAt(j)-'A'][j]++;
                map.put(str.charAt(j)-'A',1);
            }
        }
        
        Integer[] arr=new Integer[26];
        
        for(int i=0;i<26;i++){arr[i]=i;}
        
        Arrays.sort(arr, (a, b) -> {
          
            for(int i=0;i<26;i++){
                if(ranks[a][i]!=ranks[b][i])return ranks[b][i]-ranks[a][i];
            }
            return a-b;
                  
        });
        
        

        
        String ans="";
        for(int i=0;i<26;i++){
           int x= arr[i];
            if(map.containsKey(x)){
                char ch=(char)(x+'A');
                ans+=ch;
            }
        }
        
        return ans;
    }
}