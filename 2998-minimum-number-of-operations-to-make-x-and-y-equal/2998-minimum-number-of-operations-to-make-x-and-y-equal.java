class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        
        HashSet<Integer> set = new HashSet<>();
        
        LinkedList<Integer> que = new LinkedList<>();
        
        int level = 0;
        
        que.add(x);
        
        while(que.size()!=0){
            int size = que.size();
            
            while(size-->0){
                int ele = que.removeFirst();
                
                if(ele == y)return level;
                
                if((ele%11) == 0){
                    if(!set.contains(ele/11)){
                        que.add(ele/11);
                        set.add(ele/11);
                    }
                }
                if((ele%5) == 0){
                    if(!set.contains(ele/5)){
                        que.add(ele/5);
                        set.add(ele/5);
                    }
                }
                 if(!set.contains(ele-1)){
                        que.add(ele-1);
                        set.add(ele-1);
                }
                
                 if(!set.contains(ele+1)){
                        que.add(ele+1);
                        set.add(ele+1);
                }
                
            }
            level++;
        }
        return level;
    }
}