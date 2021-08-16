class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    
    public static int activitySelection(int start[], int end[], int n)
    {
        List<int[]> tasks=new ArrayList<>();
        for(int i=0;i<n;i++){
            tasks.add(new int[]{start[i],end[i]});
        }
        Collections.sort(tasks,(a,b)->{
            return a[0]-b[0];
            });
            
            
            int e=tasks.get(0)[1];
            int ans=0;
          for(int i=1;i<n;i++){
              if(e<tasks.get(i)[0]){
                  ans++;
                  e=tasks.get(i)[1];
              }else{
                  e=Math.min(e,tasks.get(i)[1]);
              }
              
          }
          
          return ans+1;
       
        
    }
}