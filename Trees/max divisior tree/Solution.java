import java.util.*;
public class Solution {
    
 static  class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val){
            this.val=val;
        }
    }

   public static void main(String[] args){

    int n=48;
    TreeNode root=null;
       root= makeTree(null,n);
       System.out.println(solve(root));
   }
    public static TreeNode makeTree(TreeNode root,int v){


        TreeNode node=new TreeNode(v);

        for (int i = 2 ; i < v/2 ; i++)
        {
          if (v % i != 0)
            continue;
          node.left = makeTree(((node).left), i);
          node.right =  makeTree(((node).right), v/i);
          return node;
         
        }
        return node;

    }

    public static int solve(TreeNode root){

        if(root==null)return 0;

       
        int left=solve(root.left);
        int right=solve(root.right);

        return Math.max(left,right)+1;

    }
}