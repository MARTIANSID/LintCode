class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int n=points.length;
        
        int[] distances=new int[n];
        
        int index=0;
        for(int[] p:points){
            distances[index++]=p[0]*p[0]+p[1]*p[1];
        }
        
        int si=0,ei=(int)3e8;
        
        while(si<=ei){
            int mid=(si+ei)/2;
            if(count(mid,distances)>=k){
                ei=mid-1;
            }else{
                si=mid+1;
            }
        }
        
        //ans->si
        
        // System.out.println(si);
        
        int[][] ans=new int[k][2];
        
        index=0;
        
        for(int i=0;i<n;i++){
            if(distances[i]<=si)
            ans[index++]=points[i];
        }
        
        return ans;
        
        
    }
    
    public int count(int mid,int[] distances){
        int count=0;
        for(int ele:distances){
            if(ele<=mid)count++;
        }
        return count;
    }
}

