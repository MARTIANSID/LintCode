class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        
        
        HashMap<String,Integer> map=new HashMap<>();
        int index=0,max=0;
        String sender="~";
        for(String mssg:messages){
            int n=mssg.split(" ").length;
            map.put(senders[index],map.getOrDefault(senders[index],0)+n);
            int val=map.get(senders[index]);
            if(val>=max){
                if(val==max && sender.compareTo(senders[index])<0){
                    sender=senders[index];
                }else if(val>max){
                    sender=senders[index];
                }
                max=val;
            }
            index++;
        }
        // System.out.println(map);
        return sender;
        
    }
}