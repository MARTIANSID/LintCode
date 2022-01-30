// package number theory.euler totieny and gcd sum;

public class algo {
    //video number 28

    int[] phi=new int[(int)1e6+1];

    public int getCount(int d,int n){
        return phi[n/d];  //precalculate this
    }

    public int gcdSum(int n){
        int res=0;
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                int d1=i;
                int d2=n/i;
                res+=d1*getCount(d1,n);
                if(d1!=d2)
                res+=d2*getCount(d2,n);

            }
        }
        return res;
    }
}
