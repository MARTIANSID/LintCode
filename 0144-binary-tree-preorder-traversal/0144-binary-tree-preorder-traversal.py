class Solution(object):
        
        
    def preorderTraversal(self, root):
        preorder=[]
        dfs(root,preorder)
        return preorder

def dfs(root,list):
    if root == None : return
    list.append(root.val)
    dfs(root.left,list)
    dfs(root.right,list)
            