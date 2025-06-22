//Editorial ka Solution

class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        int curr = 0;
        while (curr < n) {
            int end = Math.min(curr + k, n);
            res.add(s.substring(curr, end));
            curr += k;
        }
        String last = res.get(res.size() - 1);
        if (last.length() < k) {
            last += String.valueOf(fill).repeat(k - last.length());
            res.set(res.size() - 1, last);
        }
        return res.toArray(new String[0]);
    }
}