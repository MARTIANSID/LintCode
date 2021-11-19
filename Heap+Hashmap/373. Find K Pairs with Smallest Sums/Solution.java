
class Solution {
// this is the optimized solution-in this we ensure that in the pq we have the most minimum element at all times
//     https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/discuss/610701/C%2B%2BJavaPython-Binary-Search-O(m*k*log(m*5000))-MinHeap-O(m*k*logk)-Solutions
//  above link is a follow up for this q

    class pair{
            int no1;
            int no2;
            int index;
            pair(int no1,int no2,int index){
                    this.no1=no1;
                    this.no2=no2;
                    this.index=index;
            }
    }
    
public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        if(nums2.length==0){
                return new ArrayList<>();
        }
        
    
        List<List<Integer>> ans=new ArrayList<>();
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
                int sum1=a.no1+a.no2;
                int sum2=b.no1+b.no2;
                return sum1-sum2;
        });
        
       for(int i=0;i<nums1.length;i++){
               pq.add(new pair(nums1[i],nums2[0],0));
       }
        
        while(pq.size()>0&&k-->0){
           pair p=     pq.poll();
               List<Integer> l=new ArrayList<>();
                l.add(p.no1);
                l.add(p.no2);
                ans.add(l);
                
                if(p.index+1<nums2.length){
                        pq.add(new pair(p.no1,nums2[p.index+1],p.index+1));
                }
        }
        
        
        return ans;
        
        

         
}
}
