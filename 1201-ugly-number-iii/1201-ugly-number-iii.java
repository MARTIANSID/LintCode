class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        
        if(a == 1 || b==1 || c==1)return n;
        
        //apply binary search over n
        //make a functi-on that finds no. of ugly numbers less  than equal to current mid
        
        int si=1,ei=(int)1e19;
        
        long ab=lcm(a,b),ac=lcm(a,c),bc=lcm(b,c),abc=lcm(a,bc);
        
        while(si<=ei){
            int mid=si+(ei-si)/2;
            
            long count=(mid/a)+(mid/b)+(mid/c)-(mid/ab)-(mid/ac)-(mid/bc)+(mid/abc);
            System.out.println(mid);
            
            if(count>=n){
                ei=mid-1;
            }else{
                si=mid+1;
            }
            
        }
        
        return si;
        
    }
    
    public long gcd(long a,long b){
        if(b == 0){
            return a;
        }
        return gcd(b,a%b);
    }
    public long lcm(long a,long b){
        return a*b/gcd(a,b);
    }
}