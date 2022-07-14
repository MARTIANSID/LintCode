class Solution {
    public long appealSum(String s) {
        int n=s.length();
        long[] dp=new long[n];
        HashMap<Character,Integer> map=new HashMap<>();
        long sum=1;
        dp[0]=1;
        map.put(s.charAt(0),0);
        
        for(int i=1;i<n;i++){
            char ch=s.charAt(i);
            if(!map.containsKey(ch)){
                dp[i]=dp[i-1]+(i)+1;
                sum+=dp[i];
            }else{
                dp[i]=dp[i-1]+(i-map.get(ch));
              
                sum+=dp[i];
            }
            
            map.put(ch,i);
        }
        
       
        return sum;
    }
}

// abbca - > 3
// bbca -> 3
// bca -> 3
// ca - > 2
// a - > 1


// 4+3+2+1

// "abba"
