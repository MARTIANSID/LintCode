class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        
        int n1 = nums1.length, n2 = nums2.length;
        
        HashMap<Integer,Integer> map = new HashMap<>(); // prime factors
        
        
        for(int ele: nums1) {
            for(int i = 1; i<=Math.sqrt(ele); i++){
                if(ele%i == 0){
                    map.put(i,map.getOrDefault(i,0)+1);
                    
                    if(ele/i != i)
                    map.put(ele/i,map.getOrDefault(ele/i,0)+1);
                   
                }
            }
        }
        
        long cnt = 0;
        

        
        for(int ele: nums2){
            int no = ele*k;
            if(map.containsKey(no))
            cnt+=map.get(no);
        }
        return cnt;
    }
}


