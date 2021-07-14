class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
           if(intervals.length==0){
                   int[][] p=new int[1][2];
                   p[0]=newInterval;
                   return p;
           } 
            
            
       int si=0,n=intervals.length,hi=n-1,index=-1;
           
            while(si<=hi){
                    int mid=(si+hi)/2;
                    if(intervals[mid][0]==newInterval[0]){
                            index=mid;
                            break;
                    }else if(intervals[mid][0]>newInterval[0])hi=mid-1;
                    else si=mid+1;
            }
            
         
            
            
            if(index==-1)index=si;
            
            // System.out.println(index);
            
            List<int[]> result=new ArrayList<>();
            
            for(int i=0;i<n;i++){
                  if(index==i){
                          result.add(newInterval);
                          result.add(intervals[i]);
                  }else{
                          result.add(intervals[i]);
                  }
            }
            if(index==n)result.add(newInterval);
            
            
            List<int[]> ans=new ArrayList<>();
            
             int start=result.get(0)[0];
                  int end=result.get(0)[1];
            
          for(int i=1;i<result.size();i++){
                  int  beginNext=result.get(i)[0];
                  int endNext=result.get(i)[1];
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
            
            
            int[][] r=new int[ans.size()][2];
            
            for(int i=0;i<ans.size();i++){
                    r[i][0]=ans.get(i)[0];
                    r[i][1]=ans.get(i)[1];
            }
            
            return r;
            
              
           
    }
}