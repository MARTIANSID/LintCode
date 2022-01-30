import java.util.*;
public class algo {
    public static void main(String[] args){
        //given a number n find prime factorization of n
        //if n is a composite number then there is at least 1 prime divisor of n below sqrt(n)


        //tc sqrt(n)
        Scanner sys=new Scanner(System.in);
        int n=sys.nextInt();

        for (int i=2;i*i<=n;i++){
         if(n%i==0){
             int cnt=0;
             while(n%i==0){
                cnt++;
                n/=i;
             }
             System.out.println(i+"^"+cnt);
         }   
        }
        if(n>1) //prime number condition
        System.out.println(n+"^"+1);

    }
}
