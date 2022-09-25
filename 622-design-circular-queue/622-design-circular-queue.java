class MyCircularQueue {
    
     class ListNode{
         int val;
         ListNode next;
         ListNode(int val){
             this.val=val;
         }
     }
    
    ListNode head;
    ListNode tail;
    int currSize=0;
    int size=0;
    
    private void addFirst(int val){
        ListNode node=new ListNode(val);
        if(head==null){
            head=node;
            tail=node;   
        }else{
            node.next=head;
            head=node;
        }
    }
    
    private void addLast(int val){
        ListNode node=new ListNode(val);
        if(head==null){
            head=node;
            tail=node;
        }else{
            tail.next=node;
            tail=node;
        }
    }
    
    private void removeFirst(){
        if(head==null)return;
        ListNode temp=head.next;
        head.next=null;
        head=temp;
    }
    
    
    
    
    public MyCircularQueue(int k) {
        this.size=k;
    }
    
    public boolean enQueue(int value) {
        if(isFull())return false;
        currSize++;
        addLast(value);
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())return false;
        currSize--;
        removeFirst();
        return true;
    }
    
    public int Front() {
        if(isEmpty())return -1;
        return head.val;
    }
    
    public int Rear() {
         if(isEmpty())return -1;
         return tail.val;
    }
    
    public boolean isEmpty() {
        if(currSize==0)return true;
        else return false;
    }
    
    public boolean isFull() {
        if(currSize==size)return true;
        else return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */