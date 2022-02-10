// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class pair {
    int x, y;
    pair() {
        this.x = 0;
        this.y = 0;
    }
    pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nm = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            String[] dr = br.readLine().trim().split(" ");
            int[] duration = new int[dr.length];
            for (int i = 0; i < dr.length; i++) {
                duration[i] = Integer.parseInt(dr[i]);
            }
            ArrayList<pair> dependency = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                String[] xy = br.readLine().trim().split(" ");
                dependency.add(
                    new pair(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])));
            }
            Solution sln = new Solution();
            System.out.println(sln.minTime(dependency, duration, n, m));
        }
    }
}// } Driver Code Ends


// User function Template for Java

// please refer the custom pair class in driver code for more clarification
class Solution {
    
    public int minTime(ArrayList<pair> dependency, int[] duration, int n, int m) {
        // code here
        int[] indegree=new int[n];
        
        
        int[] time=new int[n];
        
        List<List<Integer>> graph=new ArrayList<>();
        
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        
        for(int i=0;i<m;i++){
            int u= dependency.get(i).x;
            int v=dependency.get(i).y;
            
            graph.get(u).add(v);
            
            indegree[v]++;
        }
        
        
        LinkedList<Integer> que=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                que.add(i);
                time[i]=duration[i];
            }
        }
        
        int ans=0;
        
        while(que.size()!=0){
            int size=que.size();
            int[] arr=new int[n];
            
            while(size-->0){
                int module=que.removeFirst();
                
                
                for(int child:graph.get(module)){
                    indegree[child]--;
                    
                    time[child]=Math.max(time[child],time[module]+duration[child]);


                    if(indegree[child]==0){
                        que.add(child);
                    }
                }
                
            }
            
           
            
           
            
        }
        for(int ele:indegree){
            if(ele!=0)return -1;
        }
        
         for(int i=0;i<n;i++){
                ans=Math.max(ans,time[i]);
        }
        
        return ans;
        
    }
}