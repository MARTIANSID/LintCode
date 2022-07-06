class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> map=new HashMap<>();
        
        for(String domains:cpdomains){
            String[] domain=domains.split(" ");
            int visits=Integer.parseInt(domain[0]);
            for(int i=0;i<domain[1].length();i++){
                String d=domain[1].substring(i,domain[1].length());
                map.put(d,map.getOrDefault(d,0)+visits);
                while(i<domain[1].length() && domain[1].charAt(i)!='.')i++;
            }
        }
        Set<String> set=map.keySet();
        List<String> ans=new ArrayList<>();
        for(String key:set){
            ans.add(map.get(key)+" "+key);
        }
        return ans;
    }
}