class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        
        int n=nums.length,sum=0,max=0;
        int[] left=new int[n];  //firstLen
        int[] right=new int[n]; //secondLen
        int overAllMax=0;
        for(int i=0;i<n;i++){
            if(i<firstLen){
                sum+=nums[i];
                if(i==firstLen-1)
                left[i]=sum;
                max=sum;
            }else{
                sum-=nums[i-firstLen];
                sum+=nums[i];
               max= Math.max(max,sum);
                left[i]=max;
            }
        }
        

        sum=0;
        max=0;
        for(int i=n-1;i>=0;i--){
            if(i>=(n-secondLen)){
                sum+=nums[i];
                right[i]=sum;
                max=sum;
            }else{
                sum-=nums[i+secondLen];
                sum+=nums[i];
                max=Math.max(sum,max);
                right[i]=max;
            }
        }
        
        // for(int ele:right)System.out.println(ele);
     
        max=0;
        for(int i=firstLen-1;i<n-secondLen;i++){
            overAllMax=Math.max(overAllMax,left[i]+right[i+1]);
        }
        
        // System.out.println(overAllMax);
        
        left=new int[n];
        right=new int[n];
        max=0;
        sum=0;
        for(int i=0;i<n;i++){
            if(i<secondLen){
                sum+=nums[i];
                left[i]=sum;
                max=sum; 
            }else{
                sum-=nums[i-secondLen];
                sum+=nums[i];
               max= Math.max(max,sum);
                left[i]=max;
            }
        }

        max=0;
        sum=0;
        for(int i=n-1;i>=0;i--){
            if(i>=(n-firstLen)){
                sum+=nums[i];
                right[i]=sum;
                max =sum;
            }else{
                sum-=nums[i+firstLen];
                sum+=nums[i];
                max=Math.max(sum,max);
                right[i]=max;
            }
        }
      
        for(int i=secondLen-1;i<n-firstLen;i++){
            overAllMax=Math.max(overAllMax,left[i]+right[i+1]);
        }

        return  overAllMax;
    }
}