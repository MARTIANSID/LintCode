import java.util.Scanner;

class Say_No_To_Drugs{
    public static void main(String[] args){
        int t=0;
        Scanner sys=new Scanner(System.in);
        if(sys.hasNext())
        t=sys.nextInt();

        while(t-->0){
            int n=sys.nextInt();
            int k=sys.nextInt();
            int l=sys.nextInt();
            int[] speeds=new int[n];
            int max=0;
            for(int i=0;i<n;i++){
                speeds[i]=sys.nextInt();
                max=Math.max(max,speeds[i]);
            }
            if(speeds[n-1]==max){
                System.out.println("Yes");
                // return;
            }else if(k>0&&speeds[n-1]+k*(l-1)>max){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
            
        
        }
    }
}