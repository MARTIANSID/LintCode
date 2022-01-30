class Solution {
    class pair{
        int position;
        int speed;
        pair(int position,int speed){
            this.position=position;
            this.speed=speed;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        List<pair> cars=new ArrayList<>();
        int n=position.length;
        for(int i=0;i<n;i++){
            cars.add(new pair(position[i],speed[i]));
        }
        
        Collections.sort(cars,(a,b)->{
            return a.position-b.position;
        });
        
        
        int fleet=n;
        double t=((double)target-(double)cars.get(n-1).position)/(double)cars.get(n-1).speed;
        
        for(int i=n-2;i>=0;i--){
              double time=((double)target-(double)cars.get(i).position)/(double)cars.get(i).speed;
            
                if(time<=t){
                    fleet--;
                }else{
                    t=time;
                }
        }
        
        return fleet;
        
    }
}