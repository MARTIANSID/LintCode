// { Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            long ans = new Solution().countEvenSum(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    long countEvenSum(int[] arr, int n) {
        // code here
        HashMap<Integer,Long> map=new HashMap<>();
        map.put(0,(long)1);
        long sum=0,ans=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            int rem=(int)(sum%2);
            if(map.containsKey(rem)){
                ans+=map.get(rem);
            }
            map.put((rem),map.getOrDefault(rem,(long)0)+1);
        }
        return ans;
    }
}
