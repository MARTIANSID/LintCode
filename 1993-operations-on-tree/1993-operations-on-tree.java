class LockingTree {
   
    HashMap<Integer,Integer> map;
    List<List<Integer>> graph;
    int[] parent;

    public LockingTree(int [] parent) {
        this.parent=new int[parent.length];
        for(int i=0;i<parent.length;i++)this.parent[i]=parent[i];
        this.map=new HashMap<>();
        this.graph=new ArrayList<>();
         for(int i=0;i<parent.length;i++){
             graph.add(new ArrayList<>());
         }
        for(int i=0;i<parent.length;i++){
            if(parent[i]!=-1){
                graph.get(parent[i]).add(i);
            }
        }
       
    }
    
    public boolean lock(int num, int user) {
        if(map.containsKey(num))return false;
        map.put(num,user);
        return true;
    }   
    
    public boolean unlock(int num, int user) {
        if(!map.containsKey(num))return false;
        if(map.get(num)!=user)return false;
        map.remove(num);
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        if(map.containsKey(num))return false;
        
        //descendants
        if(!descendants(num))return false;
        
        int cur=num;
        while(cur!=-1){
            if(map.containsKey(cur))return false;
            cur=parent[cur];
        }
        
        // for(int ele:path){
        //     if(map.containsKey(ele))return false;
        // }
        
        unlockAll(num,num);
        map.put(num,user);
        return true;
        
    }
    
    public boolean descendants(int src){
        if(map.containsKey(src))return true;
        for(int child:graph.get(src)){
            if(descendants(child))return true;
        }
        return false;
    }
    
//     public boolean ancestors(int src,int dest,List<Integer> path){
        
//        if(src==dest)return true;
        
//         for(int child:graph.get(src)){
//             if(ancestors(child,dest,path)){
//                 path.add(src);
//             }
//         }
//         return false;
//     }
    
    public void unlockAll(int src,int p){
        if(p!=src&&map.containsKey(src)){
            map.remove(src);
        }
        for(int child:graph.get(src)){
            unlockAll(child,p);
        }
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */