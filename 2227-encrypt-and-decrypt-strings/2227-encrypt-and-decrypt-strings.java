class Encrypter {
    HashMap<Character, Integer> keyToIndex;

    HashMap<String, Integer> enc;
    
    String[] vals;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        this.keyToIndex = new HashMap<>();
        this.enc = new HashMap<>();
        this.vals=values;
        
        // System.out.println(Arrays.toString(keys));

        for (int i = 0; i < keys.length; i++) {
            char ch = keys[i];
            keyToIndex.put(ch, i);
        }

        for (String str : dictionary) {
            String encrypted = this.encrypt(str);
            enc.put(encrypted, enc.getOrDefault(encrypted, 0) + 1);
        }
    }

    public String encrypt(String word1) {
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<word1.length();i++){
            char ch=word1.charAt(i);
            if(keyToIndex.containsKey(ch))
            sb.append(vals[keyToIndex.get(ch)]);
            else
            sb.append('*');
            
        }
        return new String(sb);
    }

    public int decrypt(String word2) {
        return enc.getOrDefault(word2,0);
    }
}
/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */
