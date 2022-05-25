class Solution {

    public int numTilePossibilities(String tiles) {
        HashSet<String> set = new HashSet<>();
        boolean[] visited = new boolean[tiles.length()];
        generator(set, tiles, visited, "");

        return set.size() - 1;
    }

    public void generator(HashSet<String> set, String tiles, boolean[] visited, String asf) {
        set.add(asf);
        if (asf.length() == tiles.length()) {
            return;
        }

        for (int i = 0; i < tiles.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            generator(set, tiles, visited, asf + tiles.charAt(i));
            visited[i] = false;
        }
    }
}
