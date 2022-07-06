class Solution {

    public int fib(int n) {
        
        if(n==0)return 0;
        
        int prev = 1, prevKaPrev = 0;

        for (int i = 2; i <= n; i++) {
            int temp = prev + prevKaPrev;
            prevKaPrev = prev;
            prev = temp;
        }
        return prev;
    }
}
