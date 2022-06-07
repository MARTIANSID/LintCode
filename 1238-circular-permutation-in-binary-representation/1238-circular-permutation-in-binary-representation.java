class Solution {
    public List<Integer> circularPermutation(int n, int start) {
            
        List<Integer> greyCodes=generateGreyCode(n);
        
        int index=-1;
        
        List<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<greyCodes.size();i++){
            if(start == greyCodes.get(i)){
                index=i;
            }
            if(index!=-1){
                ans.add(greyCodes.get(i));
            }
        }
        
        for(int i=0;i<index;i++){
            ans.add(greyCodes.get(i));
        }
        
        return ans;
    }
    
    public List<Integer> generateGreyCode(int n){
        if(n==1){
            List<Integer> temp=new ArrayList<>();
            temp.add(0);
            temp.add(1);
            return temp;
        }
        
        List<Integer> arr= generateGreyCode(n-1);
        
        List<Integer> temp=new ArrayList<>(arr);
        
        for(int i=arr.size()-1;i>=0;i--){
            temp.add(arr.get(i)+(1<<(n-1)));
        }
        
        return temp;
        
    }
    
}