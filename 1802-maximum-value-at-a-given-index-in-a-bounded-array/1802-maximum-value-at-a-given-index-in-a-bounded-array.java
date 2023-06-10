class Solution {
    public int maxValue(int n, int index, int maxSum) {
        
        int si=1,ei=maxSum;
        
        while(si<=ei){
            int mid=(si+ei)/2;
            
            if(isPossible(mid,index,n,maxSum)){
                si=mid+1;
            }else{
                ei=mid-1;
            }
        }
        
     
        
     return ei;
  
    }
    
    public boolean isPossible(int val,int index,int n,int maxSum){
        //here we just calculate the minimum possible sum
        long leftSize=0;
        long start=0;
        if(val>index){
            leftSize=index;
            start=val-1-index+1;
        }
        
        else{
            leftSize=val-1;
            start=1;
        }
        
        
        
            
        long extraOnes=Math.max(0,index-(val-1));
       
        
        long leftSum=((leftSize*(2*start+(leftSize-1)))/2)+extraOnes;
        
        System.out.println(leftSum);
      
        long rightSize=n-index-1;
         start=val-1-rightSize+1;
        if(val-1<(n-index-1)){
            rightSize=val-1;
            start=1;
            
        }
        
        extraOnes=Math.max(0,n-index-1-(val-1));
        
        
        
        
     long rightSum=((rightSize*(2*start+(rightSize-1)))/2)+extraOnes;
        
         // System.out.println(rightSum);
    
    if(leftSum+rightSum+val>maxSum)return false;
    
        
        
        return true;
    }
}
