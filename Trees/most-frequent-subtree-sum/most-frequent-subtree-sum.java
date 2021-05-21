/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        int maxFreq=0;
    public int[] findFrequentTreeSum(TreeNode root) {
        
            sumInMap(root);
            int[] a=new int[ans.size()];
            for(int i=0;i<a.length;i++){
                    a[i]=ans.get(i);
                    
            }
            return a;
    }
        
        	private int sumInMap(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int leftSum = sumInMap(root.left);
		int rightSum = sumInMap(root.right);
		int sum = leftSum + rightSum + root.val;
        
		if(!map.containsKey(sum)) {
			map.put(sum, 1);
		}
		else {
			map.put(sum, map.get(sum) + 1);
		}
        
		if(map.get(sum) > maxFreq) {
			ans.clear();
                        ans.add(sum);
                        maxFreq=map.get(sum);
		}else if(map.get(sum)==maxFreq){
                        ans.add(sum);
                        
                }
		
		return sum;
	}
}