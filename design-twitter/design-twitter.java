class Twitter {

    class Tweet{
        int id;
        int time;
        Tweet(int id,int time){
            this.id=id;
            this.time=time;
        }
    }
    HashMap<Integer,List<Tweet>> tweets;
    HashMap<Integer,HashSet<Integer>> followers;
     
    static int time=0;
    
    public Twitter() {
        tweets=new HashMap<>();
        followers=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet t=new Tweet(tweetId,time);
        time++;
        if(!tweets.containsKey(userId))tweets.put(userId,new ArrayList<>());
        tweets.get(userId).add(t);
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq=new PriorityQueue<>((a,b)->{
            
           return b.time-a.time; 
        });
        
        
     List<Tweet>  myPost=   tweets.get(userId);
        if(myPost!=null)
        for(Tweet t:myPost)pq.add(t);
        
        Set<Integer> connections=followers.get(userId);
        
        if(connections!=null)
        for(int id:connections){
        List<Tweet> posts=tweets.get(id);
            if(posts!=null)
             for(Tweet t:posts)pq.add(t);
        }
        List<Integer> ans=new ArrayList <>();
        
        int counter=0;
        System.out.println(pq);
        while(pq.size()>0&&counter<10){
            ans.add(pq.poll().id);
            counter++;
        }
        
            return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId)return;
         if(!followers.containsKey(followerId))followers.put(followerId,new HashSet<>());
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        
        if(followerId==followeeId||!followers.containsKey(followerId))return;
      
        followers.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */