// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return 1;
                        else
                            return 0;
                    }
                
                    if(index1 < index2)
                        return 1;
                    else
                        return 0;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static String findOrder(String [] dict, int n, int k)
    {
        // Write your code here
        List<List<Integer>> graph=new ArrayList<>(); 
        
        for(int i=0;i<k;i++)graph.add(new ArrayList<>());
        
        
        int[] indegree=new int[k];
        for(int i=0;i<n-1;i++){
            String first=dict[i];
            String next=dict[i+1];

            for(int j=0;j<Math.min(first.length(),next.length());j++){
                if(first.charAt(j)!=next.charAt(j)){
                    graph.get(first.charAt(j)-'a').add(next.charAt(j)-'a');
                    indegree[next.charAt(j)-'a']++;
                    break;
                }
            }
        }
        
        LinkedList<Integer> que=new LinkedList<>();
         String ans="";
        for(int i=0;i<k;i++){
            if(indegree[i]==0){
            	ans+=(char)(i+'a');
                que.add(i);
            }
        }
        
       
        while(que.size()!=0){
            int node=que.removeFirst();
            
            for(int child:graph.get(node)){
                indegree[child]--;
                if(indegree[child]==0){
                    que.add(child);
                    ans+=(char)(child+'a');
                }
            }
        }
        
        return ans;
        
    }
}