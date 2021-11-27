class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
             int n1=nums1.length;
            int n2=nums2.length;
        
        int sum1=0;
        int sum2=0;
        for(int ele:nums1)sum1+=ele;
        for(int ele:nums2)sum2+=ele;
        
        if(sum1==sum2)return 0;
        
        
        
        if(sum1>sum2)
      return  minOps(nums1,nums2,sum1,sum2);
        else
       return minOps(nums2,nums1,sum2,sum1);
        
    }
    
    public int minOps(int[] gs,int[] ls,int sumG,int sumL){
        if(gs.length>ls.length*6)return -1;
        
        PriorityQueue<Integer> pqMax=new PriorityQueue<>((a,b)->{
            return b -a;
        });
        PriorityQueue<Integer> pqMin=new PriorityQueue<>();
        
        for(int ele:ls)pqMin.add(ele);
        for(int ele:gs)pqMax.add(ele);
        
        int operations=0;
        
        while(sumG>sumL){
            
            int min=(int)1e9;
            int max=-(int)1e9;
            if(pqMin.size()>0)
             min=pqMin.peek();
            if(pqMax.size()>0)
             max=pqMax.peek();
            
            
            if(6-min>max-1){
                sumL+=6-min;
                pqMin.poll();
            }else{
                sumG-=max-1;
                pqMax.poll();
            }
            operations++;
            
        }
        
        return operations;
        
        
        
    }
}