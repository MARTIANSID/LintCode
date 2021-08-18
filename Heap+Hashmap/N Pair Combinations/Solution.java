public class Solution {
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
  
      public int[] solve(int[] nums1, int[] nums2) {
          int n=nums1 .length;
          int k=nums1.length;
          Arrays.sort(nums1);
          Arrays.sort(nums2);
          int[] ans=new int[k];
            PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
                      int sum1=a.no1+a.no2;
                      int sum2=b.no1+b.no2;
                      return sum2-sum1;
              });
              
             for(int i=0;i<nums1.length;i++){
                     pq.add(new pair(nums1[i],nums2[n-1],n-1));
             }
              int i=0;
              while(pq.size()>0&&k-->0){
                 pair p=     pq.poll();
                    
                      ans[i]=p.no1+p.no2;
                      i++;
                      
                      if(p.index+-1>=0){
                              pq.add(new pair(p.no1,nums2[p.index-1],p.index-1));
                      }
              }
              
              
              return ans;
              
  
      }
  }
  