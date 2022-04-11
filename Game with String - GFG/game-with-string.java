// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    
    
    
    static int minValue(String s, int k){
        char[] ch=s.toCharArray();
        
        HashMap<Character,Integer> map=new HashMap<>();
        
        for(char c : ch){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        Set<Character> set=map.keySet();
        
        
        
        
        for(char c:set){
            pq.add(map.get(c));
        }
        
        // System.out.println(pq);
        
        while(k>0){
            int val =pq.poll();
            if(val == 0){
                break;
            }
            pq.add(val-1);
            k--;
        }
        
        int ans=0;
        
       
        
        while(pq.size() !=0){
            int val=pq.poll();
             ans+=(val)*(val);   
        }
        
        return ans;
        
        
    }
}