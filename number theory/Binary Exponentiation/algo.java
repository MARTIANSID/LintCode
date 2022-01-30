import java.util.Scanner;
import java.util.*;
public class algo {
    public static void main(String[] args){
        //complexity log(n)
        Scanner  sys=new Scanner(System.in);
        int a=sys.nextInt();
        int n=sys.nextInt();
        int res=1;
        
        while(n>0){
            if(n%2==1){
                res*=a;
                n--;
            }else{
                a*=a;
                n/=2;
            }
        }
        System.out.println(res);
    }

    //(a^n)%d
    static long power(long a, long n, long d) {
		a = a % d;
		long res = 1;
		while (n > 0) {
			if (n % 2 == 1) {
				res =((res%d)* (a%d))%d;
				n--;
			} else {
				a =((a%d)*(a%d))%d;
				n /= 2;
			}
		}
		return res%d;
	}

}
