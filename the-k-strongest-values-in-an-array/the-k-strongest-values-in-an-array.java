class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int n=arr.length;
        Arrays.sort(arr);
        int median=arr[(n-1)/2];
        
        
        if(n==1)return arr;
        
        int i=0,j=n-1;
        
        List<Integer> result=new ArrayList<>();
        
        while(i<=j&&k-->0){
            int x=Math.abs(arr[i]-median);
            int y=Math.abs(arr[j]-median);
            
            if(x>y){
                
                result.add(arr[i]);
                i++;
            }
            else if(y>=x){
                
                result.add(arr[j]);
                j--;
            }
        }
        
        int[] ans=new int[result.size()];
        for( i=0;i<ans.length;i++)ans[i]=result.get(i);
        return ans;
        
    }
}