import java.util.*;
class Team_Formation{
    public static void main(String[] args){
        Scanner sys=new Scanner(System.in);
        int t=0;
        if(sys.hasNextInt())
        t=sys.nextInt();

        while(t-->0){
            int n=sys.nextInt();
            String str1=sys.next();
            String str2=sys.next();

           int  prog=0,eng=0,both=0,none=0;

           for(int i=0;i<n;i++){
               char ch1=str1.charAt(i);
               char ch2=str2.charAt(i);
               if(ch1=='1'&&ch2=='1'){
                   both++;
               }else if(ch1=='1'&&ch2=='0')prog++;
               else if(ch1=='0'&&ch2=='1')eng++;
               else{
                   none++;
               }
           }
           int count=0;
           while(eng>0&&prog>0){
               eng--;
               prog--;
               count++;
           }
           while(none>0&&both>0){
               none--;
               both--;
               count++;

           }
           while(both>0&&eng>0){
               both--;
               eng--;
               count++;
           }

           while(both>0&&prog>0){
               both--;
               prog--;
               count++;
           }

           System.out.println(count);


        }


        

    }
}