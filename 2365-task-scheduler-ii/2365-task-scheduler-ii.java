class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        int n=tasks.length;
        long days=1;
        HashMap<Integer,Long> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
           
            int taskId=tasks[i];
            if(!map.containsKey(taskId)){
                map.put(taskId,days);
                days++;
                continue;
            }
           long day= map.get(taskId);
           if((days-day-1)>=space){
               map.put(taskId,days);
               days++;
           }else{
               days+=(space-(days-day-1));
               map.put(taskId,days);
               days++;
           }  
        }

        
        return days-1;
    }
}