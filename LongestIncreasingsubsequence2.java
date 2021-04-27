import java.util.Scanner;

public class LongestIncreasingsubsequence2 {
    

public static void main(String args[]){
// use 3d dp
Scanner sys=new Scanner(System.in);

String s=sys.next();
 System.out.println(solve(s,0,s.length()-1,'*'));

}

public static  int solve(String s,int i,int j, char taken){

if(i==j)return 0;

if(i>j)return 0;


int x=0;
    if(s.charAt(i)==s.charAt(j)){
        if(s.charAt(i)==taken){
        x=    solve(s,i+1,j-1,taken);
        }else{

          x=  solve(s,i+1,j-1,s.charAt(i))+2;
        }

        return x;

    }else{

        if(taken==s.charAt(i)){
          x=  solve(s,i+1,j,taken);
        }

        else if(taken==s.charAt(j)){
          x=  solve(s,i,j-1,taken);
        }else{
        x=    Math.max( solve(s,i+1,j,taken),solve(s,i,j-1,taken));
        }


        return x;

    }



}

}
