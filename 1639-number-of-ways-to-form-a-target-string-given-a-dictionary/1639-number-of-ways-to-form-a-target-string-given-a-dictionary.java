class Solution {
    Long[][] dp;

    int mod = (int) 1e9 + 7;

    public int numWays(String[] words, String target) {
        int max = 0;

        HashMap<Integer, HashMap<Character,Integer>> map = new HashMap<>();

        for (String w : words) {
            for (int i = 0; i < w.length(); i++) {
                char ch = w.charAt(i);
                map.putIfAbsent(i, new HashMap<>());
                map.get(i).put(ch,map.get(i).getOrDefault(ch,0)+1);
            }
            max = Math.max(max, w.length());
        }

        dp = new Long[max + 1][target.length() + 1];
        return (int) (solve(words, target, 0, 0, map) % mod);
    }
    
    public long solve(String[] words,String target,int k,int targetIndex,HashMap<Integer, HashMap<Character,Integer>> map){
        
        if(targetIndex == target.length())return 1;
        if(!map.containsKey(k))return 0;
        
        if(dp[k][targetIndex]!=null)return dp[k][targetIndex];
        
        long count=0;
        count=(count+solve(words,target,k+1,targetIndex,map))%mod;
        Integer c=map.get(k).get(target.charAt(targetIndex));
        if(c!=null){
           count=(count+ solve(words,target,k+1,targetIndex+1,map)*c)%mod;
        }
        return dp[k][targetIndex]= count;
    }
}
