class MedianFinder {

    /** initialize your data structure here. */
      
        PriorityQueue<Integer> queMin;//min
        PriorityQueue<Integer> queMax;
        
    public MedianFinder() {
        queMin=new PriorityQueue<>((a,b)->{
                return a-b;
        }); 
        queMax=new PriorityQueue<>((a,b)->{
                return b-a;
        });//max   
    }
    
    public void addNum(int num) {
           if(queMin.size()>0&&num>=queMin.peek()){
                   queMin.add(num);
           }else{
                   queMax.add(num);
           }
            
           if(queMax.size()>queMin.size()&&queMax.size()-queMin.size()>1){
                  int x= queMax.poll();
                   queMin.add(x);
           }else if(queMin.size()>queMax.size()&&queMin.size()-queMax.size()>=1){
                   
                   int x=queMin.poll();
                   queMax.add(x);
           } 
            
       
    }
    
    public double findMedian() {
            if(queMax.size()>queMin.size()){
                   return queMax.peek();
            }else{


                    return (double)(queMax.peek()+queMin.peek())/2;
            }
         
    }
}

 //  * Your MedianFinder object will be instantiated and called as such:
 // * MedianFinder obj = new MedianFinder();
 // * obj.addNum(num);
 // * double param_2 = obj.findMedian();
 // */