class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
    int n=cardPoints.length,front=0,end=n-1,ans=0;
     int[] left=new int[n];
    int[] right=new int[n];
        
        int sum=0;
        for(int i=0;i<n;i++){
            
            sum+=cardPoints[i];
            left[i]=sum;
        }
        sum=0;
        for(int i=n-1;i>=0;i--){
            sum+=cardPoints[i];
            right[i]=sum;
        }
        
        
      
      for(int i=k-1;i>=0;i--){
            
          
            int l=   left[front+i];
            int r=right[end-i];
          
          if(front>0){
              l-=left[front-1];
              
          }
          
          if(end<n-1){
              r-=right[end+1];
          }
          
          
            
            if(r>l){
                ans+=cardPoints[end];
                end--;
            }else{
                ans+=cardPoints[front];
                front++;
            }
            
        }
        
        return ans;
        
    }
}
// [100,40,17,9,73,75]
// 3

