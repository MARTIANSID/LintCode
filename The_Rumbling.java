import java.util.*;
class The_Rumbling{
    public static void main(String[] args){
        int t=0;
        Scanner sys=new Scanner(System.in);
        if(sys.hasNext())t=sys.nextInt();

        while(t-->0){
            int n=sys.nextInt();
            String s=sys.next();
            long x=sys.nextInt();
            long y=sys.nextInt();
            long[] leftEast=new long[n];
            long[] rightWest=new long[n];
            long sum=0;
            for(int i=0;i<n;i++){
                char ch=s.charAt(i);
                if(ch=='N'){
                    long val1=x;
                    long val2=3*(long)y;
                    sum+=Math.min(val1,val2);
                }else if(ch=='W'){
                        sum+=2*Math.min((long)x,(long)y);
                }else if(ch=='S'){
                    long val1=y;
                    long val2=3*x;
                    sum+=Math.min(val1,val2);
                }
                leftEast[i]=sum;
            }
            sum=0;
            for(int i=n-1;i>=0;i--){
                char ch=s.charAt(i);    
                if(ch=='N'){
                    long val1=y;
                    long val2=3*(long)x;
                    sum+=Math.min(val1,val2);
                }else if(ch=='E'){
                        sum+=2*Math.min((long)x,(long)y);
                }else if(ch=='S'){
                    long val1=x; 
                    long val2=3*(long)y;
                    sum+=Math.min(val1,val2);
                }
                rightWest[i]=sum; 

            }

            long min=Long.MAX_VALUE;
            for(int i=0;i<n;i++){
                if(i+1<n)
                min=Math.min(min,leftEast[i]+rightWest[i+1]);
            }
            min=Math.min(rightWest[0],min);
            min=Math.min(min,leftEast[n-1]);
            System.out.println(min);
        }
    }
}