class FindSumPairs {
     
    HashMap<Integer,Integer> map;
    int[] nums1,nums2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.map=new HashMap<>();
        int n=nums1.length;
        int m=nums2.length;
        this.nums1=new int[n];
        this.nums2=new int[m];
        for(int i=0;i<n;i++){
            this.nums1[i]=nums1[i];
            
        }
        for(int j=0;j<m;j++){
            this.nums2[j]=nums2[j];
            map.put(nums2[j],map.getOrDefault(nums2[j],0)+1);
        }
    }
    
    public void add(int index, int val) {
        if(map.containsKey(nums2[index])){
            map.put(nums2[index],map.get(nums2[index])-1);
            map.put(nums2[index]+val,map.getOrDefault(nums2[index]+val,0)+1);
        }
        this.nums2[index]+=val;
    }
    
    public int count(int tot) {
        int ans=0;
        for(int ele:this.nums1){
            int f=tot-ele;
            if(map.containsKey(f))ans+=map.get(f);
        }
        return ans;
    }
}