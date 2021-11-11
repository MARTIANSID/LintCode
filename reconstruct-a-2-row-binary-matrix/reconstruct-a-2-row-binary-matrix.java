class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> ans=new ArrayList<>();
        
          int n=colsum.length;
        
        for(int i=0;i<2;i++){
            List<Integer> a=new ArrayList<>();
            for(int j=0;j<n;j++)a.add(0);
            ans.add(a);
        }
        
      
        
        for(int i=0;i<n;i++){
            int sum=colsum[i];
           if(sum>0){
                if(sum==1){
                if(lower>upper){
                    ans.get(1).set(i,1);
                    ans.get(0).set(i,0);
                    lower--;
                }else{
                    if(upper==0)return new ArrayList<>();
                    ans.get(0).set(i,1);
                    ans.get(1).set(i,0);
                    upper--;
                }
                sum--;
            }else{
                    if(lower>0&&upper>0){
                        ans.get(0).set(i,1);
                        ans.get(1).set(i,1);
                        lower--;
                        upper--;
                    }else{
                        return new ArrayList<>();
                    }
                }
           }else{
               ans.get(1).set(i,0);
                ans.get(0).set(i,0);
           }
        }
        
        if(lower!=0||upper!=0)return new ArrayList<>();
        
        return ans;
        
    }
}