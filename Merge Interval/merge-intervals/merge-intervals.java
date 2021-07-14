class Solution {
    public int[][] merge(int[][] intervals) {
        
            if(intervals.length==0)return intervals;
            
        Arrays.sort(intervals,(a,b)->{
                return a[0]-b[0];
        });
            List<int[]> ans=new ArrayList<>();
            
             int start=intervals[0][0];
                  int end=intervals[0][1];
            
          for(int i=1;i<intervals.length;i++){
                  int  beginNext=intervals[i][0];
                  int endNext=intervals[i][1];
                  if(end>=beginNext){
                          int newStart=start;
                          int newEnd=Math.max(end,endNext);
                         int[] a=new int[2];
                          a[0]=newStart;
                          a[1]=newEnd;
                          if(ans.size()>=1)
                          ans.remove(ans.size()-1);
                          ans.add(a);
                          start=newStart;
                          end=newEnd;
                          
                  }else{
                          if(i==1){
                                  int[] b=new int[2];
                                  b[0]=start;
                                  b[1]=end;
                                  ans.add(b);
                          }
                           int[] a=new int[2];
                          a[0]=beginNext;
                          a[1]=endNext;
                          ans.add(a);
                          
                           start=beginNext;
                          end=endNext;
                  }
                  
          }
            
            if(ans.size()==0){
                    int[] b=new int[2];
                                  b[0]=start;
                                  b[1]=end;
                                  ans.add(b);
            }
            
            
            int[][] result=new int[ans.size()][2];
            
            for(int i=0;i<ans.size();i++){
                    result[i][0]=ans.get(i)[0];
                    result[i][1]=ans.get(i)[1];
            }
            
            return result;
            
              
    }
   
}

      
//         [1,3],[2,6] ,[5,7]
//         [1,6]   [5,7]
        
// [1,7]