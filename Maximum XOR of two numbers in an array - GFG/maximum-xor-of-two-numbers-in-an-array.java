// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[n];
            for(int i = 0; i < n; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
           System.out.println(ob.max_xor(v, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static class TrieNode{
        TrieNode[] children=new TrieNode[2];
        boolean isEnd=false;
    }
    
   static class  Trie{
        TrieNode root;
        Trie(){
            this.root=new TrieNode();
        }
        
        public void insert(int no){
            TrieNode node=this.root;
            for(int i=31;i>=0;i--){
                int x=1<<i;
                int bit=(no&x)==0?0:1;
                if(node.children[bit]==null){
                    node.children[bit]=new TrieNode();
                }
                node=node.children[bit];
            }
            node.isEnd=true;
        }
        
        public int findMax(int no){
            TrieNode node=this.root;
            int ans=0;
            for(int i=31;i>=0;i--){
                int x=1<<i;
                int bit=(no&x)==0?0:1;
                int findBit=bit==0?1:0;
               
                if(node.children[findBit]!=null){
                    node=node.children[findBit];
                        ans+=(x);
                }else{
                    node=node.children[bit];
        
                }
            }
            
            return ans;
            
        }
    }
    
    public static int max_xor(int arr[], int n)
    {
        Trie t=new Trie();
        for(int ele:arr){
            t.insert(ele);
        }
        int max=0;
        
        for(int ele:arr){
            int m=t.findMax(ele);
            max=Math.max(max,m);
        }
        return max;
        
    }
}