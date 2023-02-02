class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n=words.length;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<26;i++){
            map.put(order.charAt(i),i);
        }
        
        List<String> arr=new ArrayList<>();
        
        for(String str:words){
            arr.add(str);
        }
        
        Collections.sort(arr,(a,b)->{
            for(int i=0;i<Math.min(a.length(),b.length());i++){
                int val1=map.get(a.charAt(i));
                int val2=map.get(b.charAt(i));
               
                if(val1<val2)return -1;
                if(val2<val1)return 1;                
            }
            if(a.length()>b.length())return 1;
            else return -1;
        });
        
        
        // System.out.println(arr);
        
        for(int i=0;i<n;i++){
            if(!words[i].equals(arr.get(i)))return false;
        }
        return true;
        
    }
}