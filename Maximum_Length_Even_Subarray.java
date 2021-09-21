import java.util.Scanner;

class Maximum_Length_Even_Subarray{


    public static void main(String[] args){


        Scanner sys=new Scanner(System.in);
        int t=0;
        if(sys.hasNext()){
            t=sys.nextInt();
        }

       while(t-->0){
           int n=sys.nextInt();
           int[] dp=new int[n];
           int sum=0,max=0;
           for(int i=1;i<=n;i++){
               sum+=i;
               if(sum%2==0){
                    max=i;
               }else{
                   max=Math.max()
               }
           }
           System.out.println(max);
       }
    }
}