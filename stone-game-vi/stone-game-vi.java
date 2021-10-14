class Solution {
    class pair{
        int a;
        int b;
        pair(int a,int b){
            this.b=b;
            this.a=a;
        }
    }
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int x=0,y=0;
        
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            return (b.a+b.b)-(a.a+a.b);
        });
        
        for(int i=0;i<aliceValues.length;i++){
            pq.add(new pair(aliceValues[i],bobValues[i]));
        }
        
        
        boolean flag=true;
        while(pq.size()!=0){
            if(flag){
                x+=pq.poll().a;
                flag=false;
            }else{
                y+=pq.poll().b;
                flag=true;
            }
        }
        
        if(x>y)return 1;
        else if(x==y)return 0;
        return -1;
    }
}