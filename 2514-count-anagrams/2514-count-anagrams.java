import java.util.*;

class Solution {
    int mod = (int) 1e9 + 7;

    public int countAnagrams(String s) {
        int n = s.length();
        long count = 1;
        String[] words = s.split(" ");
        for (String str : words) {
            count = (count * permutation(str)) % mod;
        }
        return (int) (count % mod);
    }

    public long permutation(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        Set<Character> set = map.keySet();
        long repeat = 1;

        for (char ch : set) {
            repeat = (repeat * fact(map.get(ch)))%mod;
        }
        
       
        return (fact(n)*modInverse(repeat, mod))%mod;

    }

    public long fact(int n) {
        long f = 1;
        for (int i = 2; i <= n; i++) {
            f = (f * i) % mod;
        }
        return f;
    }

    public int modInverse(long b, int m) {
        long g = gcd(b, m);
        if (g != 1)
            return -1;
        else {
            return pow(b, m,m-2);
        }
    }
    public int  pow(long no,int mod,int p){
       if(no==1 || no==0) return 1;
        long res=1;        
       while(p>0){
            if(p%2==0){
                no=(no*no)%mod;
                p=p/2;
            }else{
                p--;
                res=(res*no)%mod;
            }
       }
        
       return (int)(res%mod);
    }

    public long gcd(long a, long b) {

        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}