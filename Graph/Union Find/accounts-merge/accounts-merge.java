class Solution {
        
        private String findParent(String email,HashMap<String,String> map){
                if(email.equals(map.get(email))){
                        return email;
                }
                
               String x=  findParent(map.get(email),map);
                map.put(email,x);
                
                return x;
        }
        
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
     
            
         HashMap<String,String> parent=new HashMap<>();   
         HashMap<String,List<String>> email=new HashMap<>();
           
         for(int i=0;i<accounts.size();i++){
                 List<String> acc=accounts.get(i);
                 String name=acc.get(0);
                 for(int j=1;j<acc.size();j++){
                         parent.put(acc.get(j),acc.get(j));
                         List<String> a=new ArrayList<>();
                         a.add(name);
                         email.put(acc.get(j),a);
                 } 
                 
         }   
            
                 for(int i=0;i<accounts.size();i++){
                 List<String> acc=accounts.get(i);
               
                 for(int j=1;j<acc.size()-1;j++){
                        String p1= findParent(acc.get(j),parent);
                        String p2=findParent(acc.get(j+1),parent);
                        if(p1!=p2){
                                parent.put(p1,p2);
                        }
                 } 
                 
         }   
          Iterator hmIterator = email.entrySet().iterator();
         while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            String e = ((String)mapElement.getKey());
                String p=findParent(e,parent);
            List<String> c=     email.get(p);
               c.add(e);
                 
            
        }
             Iterator hmIt= email.entrySet().iterator();
          List<List<String>> ans=new ArrayList<>();
            
              while (hmIt.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIt.next();
            String e = ((String)mapElement.getKey());
                String p=findParent(e,parent);
                     
          if(p.equals(e)){
                  
                  List<String> toBe=new ArrayList<>();
                  List<String> mails=email.get(e);
                  String name=mails.get(0);
                for(int i=1;i<mails.size();i++){
                        toBe.add(mails.get(i));
                }
                  Collections.sort(toBe);
                  List<String> fin=new ArrayList<>();
                  fin.add(name);
                  for(int i=0;i<toBe.size();i++){
                          fin.add(toBe.get(i));
                  }
                  ans.add(fin);
                  
          }
                 
            
        }
          
            
        return ans;
            
    }
}