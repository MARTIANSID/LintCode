// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        
        //using binary search solve
        int si=1,ei=Integer.MAX_VALUE-1;
        
        while(si<=ei){
            int mid=si-(si-ei)/2;
            if(count(mid,arr1,arr2)>=k){
                ei=mid-1;
            }else{
                si=mid+1;
            }
            
        }
        return si;
    }
    
    public int cnt(int val,int[] arr){
        
        int si=0,ei=arr.length-1;
        
        while(si<=ei){
            int mid=(si+ei)/2;
            if(arr[mid]<=val){
                si=mid+1;
            }else{
                ei=mid-1;
            }
        }
        return si;
    }

    public int count(int mid,int[] arr1,int[] arr2){
        return cnt(mid,arr1)+cnt(mid,arr2);
    }
}