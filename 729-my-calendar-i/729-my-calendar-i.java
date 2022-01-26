class MyCalendar {

    public MyCalendar() {
        
    }
    
    TreeMap<Integer,Integer> endKey=new TreeMap<>();
    TreeMap<Integer,Integer> startKey=new TreeMap<>();
    public boolean book(int start, int end) {
        
        //solving with respect to end
        
        
        Integer startVal=endKey.higherKey(start);
        Integer endVal=startKey.lowerKey(end);
        
    
        
        
        if((startVal!=null&&endKey.get(startVal)<end)||(endVal!=null&&startKey.get(endVal)>start))return false;
       
        startKey.put(start,end);
        endKey.put(end,start);        
        return true;
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */