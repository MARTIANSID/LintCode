// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            

            Solution ob = new Solution();
            
            System.out.println(ob.maxSubarrayXOR(N,arr));
            
            
        }
    }
}
// } Driver Code Ends


class Solution{
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
            int v=0;
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
    
    
    static int maxSubarrayXOR(int n, int arr[]){
        int prefix=0;
        Trie t=new Trie();
        t.insert(0);
        int max=0;
        for(int ele:arr){
            prefix^=ele;
            t.insert(prefix);
            max=Math.max(max,t.findMax(prefix));
        }
        return max;
    }
}