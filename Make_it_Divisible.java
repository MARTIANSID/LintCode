import java.util.Scanner;

public class Make_it_Divisible{

    public static void main(String[] args){
        Scanner sys = new Scanner(System.in);

        int t = 0;
        if (sys.hasNext()) {
            t = sys.nextInt();
        }

        while(t-->0){

            int n=sys.nextInt();

            String str="";
            int[] arr=new int[n];
            int sum=0 ;
            for(int i=0;i<n;i++){
                arr[i]=9;
                sum+=arr[i];
            }





         int lastDigit=9;
         int rem=   sum%3;
         sum-=rem;
         lastDigit-=rem; 
         
          
         while(true){
             if(no%2!=0&&no%9!=0){  
                 System.out.println(no);
                 break;
             }else{
                 no-=3;
             }
         }
        }
    }

    public void subtract(int[] arr,int k){

        if(arr[])
    }
}