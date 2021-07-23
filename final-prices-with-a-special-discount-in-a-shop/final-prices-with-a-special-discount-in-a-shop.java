class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st=new Stack<>();
        int n=prices.length;
        int[] left=new int[n];
        Arrays.fill(left,-1);
       for(int i=n-1;i>=0;i--){
           while(st.size()!=0&&st.peek()>prices[i]){
               st.pop();
           }
           if(st.size()>0){
               left[i]=st.peek();
           }
           st.push(prices[i]);
       }
        
        int[] ans=new int[n];
        for(int i=0;i<prices.length;i++){
            int disc=left[i];
            if(left[i]!=-1)ans[i]=prices[i]-left[i];
            else ans[i]=prices[i];
        }
        
        return ans;
        
    }
}