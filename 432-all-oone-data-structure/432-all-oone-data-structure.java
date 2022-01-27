class AllOne {
    
    HashMap<String,Integer> count;
    HashMap<String,Node> keyToNode;
    
    class Node{
        String key;
        Node prev;
        Node next;
        Node(String key){
            this.key=key;
        }
    }
    
    
    Node tail; //maximum
    Node head; //minimum
    
    
    private int size=0;
        
        
    private void addFirst(Node node){
        if(head==null){
            head=node;
            tail=node;
           
        }else{
            head.prev=node;
            node.next=head;
            head=node;
        }
        size++;
    }
    
    private void addLast(Node node){
        if(head==null){
            head=node;
            tail=node;
        }else{
            tail.next=node;
            node.prev=tail;
            tail=node;
        }
        size++;
    }
    
    private Node delete(Node node){
        
        if(size==0)return null;
        
        if(size==1){
            head=null;
            tail=null;
        }else{
            if(node.prev==null){
                head=node.next;
                node.next.prev=null;
                node.next=null;
            }else if(node.next==null){
                tail=node.prev;
                node.prev.next=null;
                node.prev=null;
            }else{
                node.prev.next=node.next;
                node.next.prev=node.prev;
                node.prev=null;
                node.next=null;
            }
        }
        size--;
        
        return node;
    }
    
    
    private void swapInc(Node node){
        Node next=node.next;
        String temp=next.key;
        next.key=node.key;
        node.key=temp;
        
        keyToNode.put(node.key,node);
        keyToNode.put(next.key,next);
    }
    
    private  void swapDec(Node node){
         Node prev=node.prev;
        String temp=prev.key;
        prev.key=node.key;
        node.key=temp;
        
        keyToNode.put(node.key,node);
        keyToNode.put(prev.key,prev);
    }
    

    public AllOne() {
        count =new HashMap<>();
        keyToNode=new HashMap<>();
    }
    
    public void inc(String key) {
        if(count.containsKey(key)){
           int newCount= count.get(key)+1;
          int maxCount=  count.get(tail.key);
             Node incNode= keyToNode.get(key);
           
            
            
            if(newCount>=maxCount){
                delete(incNode);
                addLast(incNode);
                keyToNode.put(key,incNode);
                
            }
            
           else if(incNode.next!=null){
              Node next=  keyToNode.get(incNode.next.key);
                
                if(newCount>count.get(next.key)){
                    swapInc(incNode);
                }
                
            }
            
            
            count.put(key,newCount);
              
            
        }else{
            Node node=new Node(key);
            addFirst(node);
            count.put(key,1);
            keyToNode.put(key,node);
        }
    }
    
    public void dec(String key) {
        
        int newCount= count.get(key)-1;
        
        if(newCount==0){
           Node n= keyToNode.get(key);
            delete(n);
            keyToNode.remove(key);
            count.remove(key);
        }else{
            Node n= keyToNode.get(key);
             int minCount=  count.get(head.key);
            if(newCount<=minCount){
                delete(n);
                addFirst(n);
                keyToNode.put(key,n);
                
            }
           else if(n.prev!=null){ 
               Node prev=  keyToNode.get(n.prev.key);
               int cnt=count.get(prev.key);
               if(cnt>newCount){
                   swapDec(n);
               }
               
           }
            count.put(key,newCount);
        }
        
    }
    
    public String getMaxKey() {
        if(tail==null)return "";
        return tail.key;
    }
    
    public String getMinKey() {
        if(head==null)return "";
        return head.key;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */