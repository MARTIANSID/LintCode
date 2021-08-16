/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		int ans=0;
		for(int i=0;i<t;i++){
		    String str= scn.nextLine();
		    String[] arr=str.split(" ");
		    int n=Integer.parseInt(arr[0]);
		    int p=Integer.parseInt(arr[1]);
		    int k=Integer.parseInt(arr[2]);
		    for(int j=0;j<p;j++){
		        int num=j;
		        while(num<n){
		            ans++;
		            num+=k;
		        }
		    }
		}
		
		return ans+1;
		
	}
}
