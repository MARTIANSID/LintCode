// { Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
	ArrayList <Integer> boundary(Node root)
	{
	    if(root==null)return new ArrayList<>();
        if(root.left== null && root.right == null){
             ArrayList<Integer> temp=new ArrayList<>();
             temp.add(root.data);
             return temp;
        }
        // write your code here
        ArrayList<Integer> leftBoundary=new ArrayList<>();

        leftBoundary.add(root.data);
       Node node=root.left;
       while(node!=null){
           if(node.left==null && node.right==null){
           }else{
               leftBoundary.add(node.data);
           }
           if(node.left!=null)
           node=node.left;
           else node=node.right;
       }
        ArrayList<Integer> leaf=new ArrayList<>();
        node=root;
        dfs(leaf,node,0);
        Stack<Integer> rightBoundary=new Stack<>();
        node=root.right;
      
        while(node!=null){
        if(node.left==null && node.right==null){
        }else{
          rightBoundary.push(node.data);

        }
        if(node.right!=null)
         node=node.right;  
         else node=node.left;         
       }
       leftBoundary.addAll(leaf);
       while(rightBoundary.size()>0){
           leftBoundary.add(rightBoundary.pop());
       }
       return leftBoundary;

	}
	public void dfs(List<Integer> leaf,Node root,int level){
        if(root==null)return;
        if(root.left==null && root.right==null)
        leaf.add(root.data);
        dfs(leaf,root.left,level+1);
        dfs(leaf,root.right,level+1);
    }
}
