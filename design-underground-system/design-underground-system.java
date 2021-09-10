class UndergroundSystem {
    class check{
        String stationName;
        int time;
        check(String name,int time){
            this.stationName=name;
            this.time=time;
        }
    }
    
   
    HashMap<String,int[]> map;
    HashMap<Integer,check> checkIn;
    
    public UndergroundSystem() {
        map=new HashMap<>();
        checkIn=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
     
            checkIn.put(id,new check(stationName,t));
        
    }
    
    public void checkOut(int id, String stationName, int t) {
         check person=  checkIn.get(id);
        int totalTime=t-person.time;
        String inStation=person.stationName;
        
        if(map.containsKey(inStation+"_"+stationName)){
          int[] arr=  map.get(inStation+"_"+stationName);
        arr[0]+=totalTime;
        arr[1]++;
        map.put(inStation+"_"+stationName,new int[]{arr[0],arr[1]});
        }else{
            map.put(inStation+"_"+stationName,new int[]{totalTime,1});
        }
    }
    
    public double getAverageTime(String inStation, String endStation) {
     int[] arr=   map.get(inStation+"_"+endStation);
        int totalTime=arr[0];
        int count=arr[1];
        return (double) totalTime/count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */