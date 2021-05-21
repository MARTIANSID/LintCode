class Solution {
    public int jump(int[] nums) {
        LinkedList<Integer> que=new LinkedList<>();
            
        que.add(0);  
          int level=0;
           
            boolean[] visited=new boolean[nums.length];
            visited[0]=true;
          while(que.size()!=0){
                  int size=que.size();
                  while(size-->0){
                     int index=     que.removeFirst();
                        
                          if(index==nums.length-1)return level;
                         

                          
                       for(int i=1;i<=nums[index]&&i+index<nums.length;i++){
                               if(visited[index+i]!=true){
                                       que.add(index+i);
                                         visited[index+i]=true;
                               }
                       }   
                          
                  }
                  level++;
          }  
            
            return -1;
            
    }
}