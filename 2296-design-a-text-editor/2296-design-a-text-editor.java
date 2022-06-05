class TextEditor {
    
    
    StringBuilder sb;
    
    int currentIndex=0;

    public TextEditor() {
        this.sb=new StringBuilder();
        
    }
    
    public void addText(String text) {
    
       sb.insert(currentIndex,text);
        currentIndex+=text.length();
    
  
    }
    
    public int deleteText(int k) {
        if(currentIndex>=k){
            int g=k;
            int index=currentIndex-1;
            while(k-->0){
                sb.deleteCharAt(index--);
            }
            currentIndex=index+1;
            return g;
        }else{
            int l=currentIndex;
            int x=l;
            int index=currentIndex-1;
            while(l-->0){
                sb.deleteCharAt(index--);
            }
            currentIndex=index+1;
            return x;
        }
       
    }
    
    public String cursorLeft(int k) {
        int chs=currentIndex;
        
        if(currentIndex>=k){
            currentIndex-=k;
        }else{
            currentIndex=0;
        }
        
          int  toBePrinted = Math.min(10,currentIndex);
        
        StringBuilder s=new StringBuilder();

        for(int i=currentIndex-toBePrinted;i<=currentIndex-1;i++){
            s.append(sb.charAt(i));
        }

        return new String(s);
        
    }
    
    public String cursorRight(int k) {
        
        
       int chs= sb.length()-currentIndex;
        

        
       if(chs>=k){
            currentIndex=currentIndex+k;
          
       }else{
           currentIndex=sb.length();
       }
        
       int  toBePrinted = Math.min(10,currentIndex);
        
        StringBuilder s=new StringBuilder();
        

        for(int i=currentIndex-toBePrinted;i<=currentIndex-1;i++){
            s.append(sb.charAt(i));
        }

        return new String(s);
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */