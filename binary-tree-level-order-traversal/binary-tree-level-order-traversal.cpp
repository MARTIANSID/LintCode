/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
 vector<vector<int>> levelOrder(TreeNode* node) {
        if(node == nullptr)
        return {};
        
      vector<vector<int>>ans;
      queue<TreeNode*> q;
      q.push(node);
      while(q.size() != 0){
          int s = q.size();
          vector<int>smallAns;
          while(s-- > 0){
              TreeNode* t = q.front();
              q.pop();
              if(t==nullptr)continue;
              smallAns.push_back(t->val);
              if(t->left != nullptr)
              q.push(t->left);
              if(t->right != nullptr);
              q.push(t->right);
          }
          if(smallAns.size()!=0)
          ans.push_back(smallAns);
      }
        
        
        return ans;
    }
};