// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int e = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] A = new int[2*e];
            int[] B = new int[2*e];
            
            for(int i=0; i<2*e; i++)
            {
                A[i] = Integer.parseInt(S1[i]);
                B[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.checkMirrorTree(n,e,A,B));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkMirrorTree(int n, int e, int[] a, int[] b) {
        List<List<Integer>> graph1=new ArrayList<>();
        List<List<Integer>> graph2=new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            graph1.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
        }
        for(int i=0;i<a.length-1;i+=2){
            int u=a[i],v=a[i+1];
            graph1.get(u).add(v);
        }
        for(int i=0;i<b.length-1;i+=2){
            int u=b[i],v=b[i+1];
            graph2.get(u).add(v);
        }
        for(int i=1;i<=n;i++){
        List<Integer> child1=    graph1.get(i);
        List<Integer> child2=   graph2.get(i);
            if(child1.size()!=child2.size())return 0;
            for(int j=0;j<child1.size();j++){
                if(child1.get(j)!=child2.get(child1.size()-j-1)){
                    return 0;
                }
            }
        }
        return 1;
    
    }
};