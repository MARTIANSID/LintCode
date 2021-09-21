import java.util.*;

class The_Old_Saint_And_Three_Questions{
    public static void main(String[] args){
        int t=0;
        Scanner sys=new Scanner(System.in);
        if(sys.hasNext())t=sys.nextInt();

        while(t-->0){
            int a1=sys.nextInt();
            int a2=sys.nextInt();
            int a3=sys.nextInt();

            int b1=sys.nextInt();
            int b2=sys.nextInt();
            int b3=sys.nextInt();


            int countOfOne=0,countOfZero=0;
            if(a1==1)countOfOne++;
            else countOfZero++;
            if(a2==1)countOfOne++;
            else countOfZero++;

            if(a3==1)countOfOne++;
            else countOfZero++;

            if(b1==1)countOfOne--;
            else countOfZero--;

        
            if(b2==1)countOfOne--;
            else countOfZero--;

            if(b3==1)countOfOne--;
            else countOfZero--;

            if(countOfOne==0&&countOfZero==0)System.out.println("Pass");
            else System.out.println("Fail");
            


        }
    }
}