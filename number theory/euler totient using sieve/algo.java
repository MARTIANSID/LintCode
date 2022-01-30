

public class algo {
    public static void main(String[] args){
        int maxN=(int)1e6+1;
        int[] prime=new int[(int)1e6+1];

        for(int i=0;i<(int)1e6+1;i++)prime[i]=i;

        for(int i=2;i<=maxN;i++){
            if(prime[i]==i){
                for(int j=i;j<=maxN;j+=i){
                    prime[j]/=i;
                    prime[j]*=(i-1);
                }
            }
        }
        System.out.println(prime[10]);
    }
}
