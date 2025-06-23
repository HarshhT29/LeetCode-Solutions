//GPT ka solution hai

class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int length = 1;

        while (count < n) {
            for (long half = (long) Math.pow(10, (length - 1) / 2); count < n && half < (long) Math.pow(10, (length + 1) / 2); half++) {
                long palindrome = buildPalindrome(half, length % 2 == 1);
                if (isKPalindrome(palindrome, k)) {
                    sum += palindrome;
                    count++;
                }
            }
            length++;
        }
        return sum;
    }

    private long buildPalindrome(long half, boolean oddLength) {
        String s = Long.toString(half);
        StringBuilder rev = new StringBuilder(s).reverse();
        if (oddLength) rev.deleteCharAt(0);
        return Long.parseLong(s + rev.toString());
    }

    private boolean isKPalindrome(long num, int k) {
        String baseK = toBaseK(num, k);
        return isPalindrome(baseK);
    }

    private String toBaseK(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.reverse().toString();
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
