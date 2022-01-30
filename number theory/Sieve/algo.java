
public class algo {
    public static void main(String[] args){
        //aim of algo is to generate prime numbers upto 10^6
        //log(log n) +o(n)

        int[] isPrime=new int[(int)1e6+1];
        int maxN=(int)1e6;
        for(int i=1;i<=maxN;i++)isPrime[i]=1;
        isPrime[0]=0;
        isPrime[1]=1;
        for(int i=2;i*i<=maxN;i++){
            if(isPrime[i]==1){
                for(int j=i*i;j<=maxN;j+=i){
                    isPrime[j]=0;
                }
            }
        }

        //appplication finding kth prime number
        //
    }
}
