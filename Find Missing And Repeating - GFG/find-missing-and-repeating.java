// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        //first find mising number
        for(int i=0;i<n;i++){
            while(arr[arr[i]-1]!=arr[i] && arr[i]!=i+1){
                swap(arr,i,arr[i]-1);
            }
        }
        
        int missingNumber=-1;
        for(int i=0;i<n;i++){
            if(i!=arr[i]-1){
                missingNumber=i+1;
                break;
            }
        }
        
        int[] ans=new int[2];
        
        int xor=0;
        
        for(int ele:arr){
            xor^=ele;
        }
        xor^=missingNumber;
        
        for(int i=1;i<=n;i++){
            xor^=i;
        }
        
        return new int[]{xor,missingNumber};
    }
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}