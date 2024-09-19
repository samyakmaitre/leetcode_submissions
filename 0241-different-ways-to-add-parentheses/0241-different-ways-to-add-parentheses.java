class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> memo = new HashMap<>();
        return compute(expression, memo);
    }

    private List<Integer> compute(String expression, Map<String, List<Integer>> memo) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> leftResults = compute(expression.substring(0, i), memo);
                List<Integer> rightResults = compute(expression.substring(i + 1), memo);

                for (int left : leftResults) {
                    for (int right : rightResults) {
                        if (c == '+') {
                            result.add(left + right);
                        } else if (c == '-') {
                            result.add(left - right);
                        } else if (c == '*') {
                            result.add(left * right);
                        }
                    }
                }
            }
        }

        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        memo.put(expression, result);
        return result;
    }
}