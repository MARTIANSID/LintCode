class Solution {
    
    public int[] convert(int mask){
        int[] arr=new int[8];
        for(int i=0;i<8;i++){
            arr[i]=((1<<i)&mask) == 0 ? 0 :1 ;
        }
        return arr;
    }
    
    public int[] nextState(int[] cells){
        int[] arr=new int[8];
        arr[0]=0;
        arr[7]=0;
        for(int i=1;i<cells.length-1;i++){
            if((cells[i+1]==0 && cells[i-1]==0) || (cells[i+1]==1 && cells[i-1]==1)){
                arr[i]=1;
            }else{
                arr[i]=0;
            }
        }
        return arr;
    }
    
    public int[] prisonAfterNDays(int[] cells, int n) {
        int nn=8;
        
        HashMap<Integer,Integer> map=new HashMap<>();
        HashMap<Integer,Integer> m=new HashMap<>();
        
        
        int index=0;
        
        int repeatedMask=-1;
        int repeatedAt=0;
        
        while(index<=n){
            int mask=0;
            
            for(int i=0;i<nn;i++){
                if(cells[i] == 1){
                    mask|=(1<<i);
                }
            }
            if(map.containsKey(mask)){
                repeatedMask=mask;
                repeatedAt=index;
                break;
            }
            m.put(index,mask); 
            if(index == n)return convert(mask);
            map.put(mask,index++);
            cells=nextState(cells);
        }

        n=n-map.get(repeatedMask);
        index=map.get(repeatedMask);
         repeatedAt=repeatedAt-index;
        
        return convert((m.get((n%repeatedAt)+index)));
    }
}