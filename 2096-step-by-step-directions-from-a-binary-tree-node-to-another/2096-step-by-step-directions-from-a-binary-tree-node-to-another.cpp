class Solution {
public:
    unordered_map<TreeNode*,TreeNode*> mp;
    TreeNode* start=NULL,*end=NULL;
    void inorder(TreeNode* root,int st,int ed)
    {
        if(root==NULL)
        {
            return;
        }
        inorder(root->left,st,ed);
        if(root->left!=NULL)
        {
            TreeNode* temp=root->left;
            mp[temp]=root;
        }
        if(root->right!=NULL)
        {
            TreeNode* temp=root->right;
            mp[temp]=root;
        }
        if(root->val==st)
        {
            start=root;
        }
        if(root->val==ed)
        {
            end=root;
        }
        inorder(root->right,st,ed);
    }
    vector<char> v;
    string ans;
    void bfs(TreeNode* root,int ed,unordered_map<TreeNode*,bool>& vis)
    {
        if(root==NULL or vis[root])
        {
            return;
        }
        if(root->val==ed)
        {
            for(auto x:v)
                ans+=x;
            return;
        }
        vis[root]=true;
        if(root->left and vis[root->left]==false)
        {
            v.push_back('L');
            bfs(root->left,ed,vis);
            v.pop_back();
        }
        if(root->right and vis[root->right]==false)
        {
            v.push_back('R');
            bfs(root->right,ed,vis);
            v.pop_back();
        }
        if(mp[root] and vis[mp[root]]==false)
        {
            v.push_back('U');
            bfs(mp[root],ed,vis);
            v.pop_back();
        }
    }
    string getDirections(TreeNode* root, int startValue, int destValue) {
        inorder(root,startValue,destValue);
        unordered_map<TreeNode*,bool> vis;
        bfs(start,destValue,vis);
        string s;
        for(char x:v)
            s+=x;
        return ans;
    }
};