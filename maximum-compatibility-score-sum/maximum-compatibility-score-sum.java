class Solution {
    int max=-(int)1e9;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        
        
        boolean[] visited=new boolean[students.length];
        HashMap<Integer,Integer> map=new HashMap<>();
        solve(students,mentors,visited,0,map);
        return max;
        
    }
    
    public void solve(int[][] students,int[][] mentors,boolean[] visited,int index,HashMap<Integer,Integer> map){
        
        if(index==students.length){
           max=Math.max(max,calculate(students,mentors,map));
            return;
        }
        
        for(int i=0;i<mentors.length;i++){
            
            if(!visited[i]){
                visited[i]=true;
                map.put(index,i);
                solve(students,mentors,visited,index+1,map);
                visited[i]=false;
                map.remove(index);
            }
            
        }
      
    }
    
    public int calculate(int[][] students,int[][] mentors,HashMap<Integer,Integer> map){
        int count=0;
        for(int i=0;i<students.length;i++){
            for(int j=0;j<students[0].length;j++){
              int index=  map.get(i);
              int val1=  mentors[index][j];
                int val2=students[i][j];
                if(val1==val2)count++;
            }
        }
        return count;
        
    }
}