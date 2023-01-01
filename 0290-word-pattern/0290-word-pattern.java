class Solution {

    public boolean wordPattern(String pattern, String s) {
        String[] k = s.split(" ");
        List<String> used = new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();

        if (k.length > pattern.length() || pattern.length() > k.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                String str = map.get(pattern.charAt(i));

                if (k[i].equals(str)) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (used.size() > 0 && i < k.length) if (used.contains(k[i])) return false;
                used.add(k[i]);

                map.put(pattern.charAt(i), k[i]);
            }
        }
        return true;
    }
}
