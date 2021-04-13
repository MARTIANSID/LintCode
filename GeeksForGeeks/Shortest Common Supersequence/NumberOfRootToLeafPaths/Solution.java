class GfG
{
    
    
    
   static  HashMap<Integer,Integer> map=new HashMap<>();
    
    void countPaths(Node root)
    {
        map=new HashMap<>();
    solve(root,1);
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	System.out.print(entry.getKey()  +" " + entry.getValue()+" $");
}
	// Your code here	
    }
    
    public int solve(Node root,int level){
        
        if(root==null){
            return 0;
        }
        
        if(root.left==null&&root.right==null){
           if(map.containsKey(level)){
            int x=   map.get(level);
            x++;
            map.put(level,x);
           }else{
               map.put(level,1);
           }
            return 1;
        }
        
        int count=0;
            
        count+=solve(root.left,level+1);
        count+=solve(root.right,level+1);
        
        return count;
        
    }
}
