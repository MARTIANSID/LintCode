class Solution {
    
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        
        int n = word.length();
        
        HashMap<String,Integer> map = new HashMap<>();
        
        int cnt = n / k;
        
        int max = 0;
        
        for(int i = 0; i < n; i+=k) {
            String sub = word.substring(i,i+k);
            map.put(sub,map.getOrDefault(sub,0)+1);
            max = Math.max(max,map.get(sub));
        }
        return cnt - max;
    }
}