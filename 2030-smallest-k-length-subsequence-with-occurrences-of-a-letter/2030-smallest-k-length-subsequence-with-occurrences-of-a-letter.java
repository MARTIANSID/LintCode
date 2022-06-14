class Solution {

    /*
    two conditons to be taken care of
    1.the length of the substring (we should not pop extra elements)
    2.the repetiton required (just by checking frequency in hashmap)
    */

    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int repetitions = 0;

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.get(ch) - 1); //decrement the frequency of the character
            if (map.get(ch) == 0) map.remove(ch);

            while (st.size() > 0 && st.peek() > ch && (st.size() - 1 + (n - i)) >= k) {
                if (st.peek() == letter) {
                    int freq = map.getOrDefault(letter, 0);
                    if (freq >= (repetition - repetitions + 1)) {
                        st.pop();
                        repetitions--;
                    } else {
                        break;
                    }
                } else {
                    st.pop();
                }
            }
            if (ch == letter) repetitions++;
            st.push(ch);
        }
       
        
      

        StringBuilder sb = new StringBuilder();

        while (st.size() > k) {
            if (st.peek() == letter) {

                if (repetitions > repetition) {
                    repetitions--;
                } else {
                    break;
                }
            }
            st.pop();
        }

        if (st.size() > k) {
            while (st.peek() == letter) sb.append(st.pop());
            while (st.size() + sb.length() > k) {
                if(st.peek()==letter){
                    sb.append(st.pop());
                }else{
                    st.pop();
                }
                
            }
        }

        while (st.size() > 0) sb.append(st.pop());

        return new String(sb.reverse());
    }
}
