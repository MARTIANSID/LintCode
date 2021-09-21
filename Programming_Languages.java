    import java.util.*;
    import java.lang.*;
    import java.io.*;

    /* Name of the class has to be "Main" only if the class is public. */
    class Programming_Languages
    {
        public static void main (String[] args) throws java.lang.Exception
        {
            Scanner sys=new Scanner(System.in);
            int t=0;
            if(sys.hasNext()){
                t=sys.nextInt();
            }

            while(t-->0){
            int[] arr=new int[6];

                for(int i=0;i<6;i++){
                    arr[i]=sys.nextInt();
                }
                if((arr[0]==arr[2]&&arr[1]==arr[3])||(arr[1]==arr[2]&&arr[0]==arr[3])){
                    System.out.println(1);
                }else if((arr[0]==arr[4]&&arr[1]==arr[5])||(arr[1]==arr[4]&&arr[0]==arr[5])){
                    System.out.println(2);

                }else{
                    System.out.println(0);
                }
            }

        
        }
    }
