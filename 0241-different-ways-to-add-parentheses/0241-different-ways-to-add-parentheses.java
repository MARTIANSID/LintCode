class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();

        return dfs(expression, 0, n - 1);
    }

    public List<Integer> dfs(String expression, int si, int ei) {
        String s = expression.substring(si, ei + 1);
        if (!s.contains("+") && !s.contains("-") && !s.contains("*")) {
            List<Integer> temp = new ArrayList<>();
            temp.add(Integer.parseInt(String.valueOf(s)));
            return temp;
        }

        List<Integer> result = new ArrayList<>();

        for (int i = si; i < ei; i += 1) {
            char c = expression.charAt(i);

            if (c != '+' && c != '-' && c != '*') continue;

            List<Integer> left = dfs(expression, si, i - 1);
            List<Integer> right = dfs(expression, i + 1, ei);

            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    char ch = expression.charAt(i);

                    if (ch == '+') {
                        result.add(left.get(j) + right.get(k));
                    } else if (ch == '-') {
                        result.add(left.get(j) - right.get(k));
                    } else {
                        result.add(left.get(j) * right.get(k));
                    }
                }
            }
        }
        return result;
    }
}
