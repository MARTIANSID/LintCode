
class Solution {
    class pair{
            int no1;
            int no2;
            pair(int no1,int no2){
                    this.no1=no1;
                    this.no2=no2;
            }
    }
    
public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    
        List<List<Integer>> ans=new ArrayList<>();
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
                int sum1=a.no1+a.no2;
                int sum2=b.no1+b.no2;
                return sum1-sum2;
        });
        
        for(int i=0;i<nums1.length;i++){
                for(int j=0;j<nums2.length;j++){
                        pq.add(new pair(nums1[i],nums2[j]));
                }
        }
        
        while(k-->0){
                if(pq.size()==0)return ans;
             pair x=   pq.poll();
                List<Integer> l=new ArrayList<>();
                l.add(x.no1);
                l.add(x.no2);
                ans.add(l);
        }
        return ans;
         
}
}