class FreqStack {

    HashMap<Integer,Integer> dataToFreq;
    HashMap<Integer,Stack<Integer>> freqToData;
    int maxFrequency=1;
public FreqStack() {
        dataToFreq=new HashMap<>();
        freqToData=new HashMap<>();
    
}

public void push(int val) {
        if(dataToFreq.containsKey(val)){
                int x=dataToFreq.get(val);
                dataToFreq.put(val,x+1);
                maxFrequency=Math.max(maxFrequency,x+1);
                if(freqToData.containsKey(x+1)){
                      Stack<Integer> f=  freqToData.get(x+1);
                        f.push(val);
                                  freqToData.put(x+1,f);                  
                }else{
                        Stack<Integer> f=new Stack<Integer>();
                        f.add(val);
                        freqToData.put(x+1,f);
                        
                }
        }else{
                
                dataToFreq.put(val,1);
             if(freqToData.containsKey(1)){
                      Stack<Integer> f=  freqToData.get(1);
                        f.push(val);
                       freqToData.put(1,f);  
             }else{
                      Stack<Integer> f=new Stack<Integer>();
                        f.add(val);
                        freqToData.put(1,f);
                     
             }
        }
    
}

public int pop() {
        
        
   Stack<Integer> f=     freqToData.get(maxFrequency);
       int data= f.pop();
      if(f.size()==0){
           maxFrequency--;
              
      }
       int freqq= dataToFreq.get(data);
        dataToFreq.put(data,freqq-1);
        
        return data;
    
}
}

/**
* Your FreqStack object will be instantiated and called as such:
* FreqStack obj = new FreqStack();
* obj.push(val);
* int param_2 = obj.pop();
*/