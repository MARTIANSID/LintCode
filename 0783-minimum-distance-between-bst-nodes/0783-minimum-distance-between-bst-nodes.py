class Solution:
    def minDiffInBST(self, root: TreeNode) -> int:
        values = []
        self.inorder(root, values)
        min_diff = float('inf')
        for i in range(1, len(values)):
            diff = values[i] - values[i-1]
            min_diff = min(min_diff, diff)
        return min_diff

    def inorder(self, node, values):
        if node is None:
            return
        self.inorder(node.left, values)
        values.append(node.val)
        self.inorder(node.right, values)
