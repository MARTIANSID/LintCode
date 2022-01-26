class MyCalendar {

    public MyCalendar() {
        
    }
    
    TreeMap<Integer,Integer> endKey=new TreeMap<>();
    HashMap<Integer,Integer> map=new HashMap<>();
    public boolean book(int start, int end) {
        
        
        Integer startVal=endKey.higherKey(start);
        
        if((startVal!=null&&map.get(startVal)<end))return false;
       
        map.put(end,start);
        endKey.put(end,start);        
        return true;
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */