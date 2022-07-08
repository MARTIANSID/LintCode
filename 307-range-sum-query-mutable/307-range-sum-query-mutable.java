class NumArray {
   
    int[] seg;
    int n;
    
    public void build(int index,int low,int high,int[] arr){
        if(low==high){
            seg[index]=arr[low];
            return;
        }
        int mid=(low+high)/2;
        build(2*index+1,low,mid,arr);
        build(2*index+2,mid+1,high,arr);
        seg[index]=seg[2*index+1]+seg[2*index+2];
    }
    
    public int query(int ind,int low,int high,int l,int r){
        if(low>=l && high<=r)return seg[ind];
        
        if(l>high || r<low)return 0;
        
        int mid=(low+high)/2;
        int left=query(2*ind+1,low,mid,l,r);
        int right=query(2*ind+2,mid+1,high,l,r);
        return left+right;
    }
    
    public int updateSeg(int ind,int low,int high,int index,int val){
        
        if(low==high){
            int originalValue=seg[ind];
            int updated=val-originalValue;
            seg[ind]+=updated;
            return updated;
        }        
        
        int mid=(low+high)/2;
        
        int updated=0;
        if(index>=low && index<=mid){
             updated=updateSeg(2*ind+1,low,mid,index,val);
        }else{
             updated=updateSeg(2*ind+2,mid+1,high,index,val);
        }
        
        seg[ind]+=updated;
        
        return updated;
    
    }
    
    public NumArray(int[] nums) {
        int n=nums.length;
        this.seg=new int[4*n];
        this.n=nums.length;
        build(0,0,n-1,nums);
    }
    
    public void update(int index, int val) {
            updateSeg(0,0,n-1,index,val);
    }
    
    public int sumRange(int left, int right) {
        // System.out.println(left+" "+right);
        return query(0,0,n-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */