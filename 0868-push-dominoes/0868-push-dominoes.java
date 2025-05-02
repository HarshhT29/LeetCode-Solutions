class Solution {
    public String pushDominoes(String dominoes) {
        int p1 = 0, p2 = 2;
        if (dominoes.length() == 1 || dominoes.length() == 0) {
            return dominoes;
        }
        
        while (true) {
            StringBuilder sb = new StringBuilder();
            p1 = 0;
            p2 = 2;

            if (dominoes.charAt(0) == '.') {
                if (dominoes.charAt(1) == 'L') {
                    sb.append('L');
                } else
                    sb.append('.');
            } else {
                sb.append(dominoes.charAt(0));
            }

            while (p2 < dominoes.length()) {
                char c1 = dominoes.charAt(p1);
                char c2 = dominoes.charAt(p2);

                if (dominoes.charAt(p1 + 1) == '.') {
                    if ((c1 == '.' && c2 == '.') || (c1 == '.' && c2 == 'R') || (c1 == 'L' && c2 == '.')
                            || (c1 == 'R' && c2 == 'L') || (c1 == 'L' && c2 == 'R')) {
                        sb.append(dominoes.charAt(p1 + 1));
                    } else if (c1 == 'R') {
                        sb.append('R');
                    } else if (c2 == 'L') {
                        sb.append('L');
                    }
                } else
                    sb.append(dominoes.charAt(p1 + 1));
                p1++;
                p2++;
            }

            if (dominoes.charAt(dominoes.length() - 1) == '.') {
                if (dominoes.charAt(dominoes.length() - 2) == 'R') {
                    sb.append('R');
                } else
                    sb.append('.');
            } else {
                sb.append(dominoes.charAt(dominoes.length() - 1));
            }

            if (sb.toString().equals(dominoes))
                return sb.toString();

            dominoes = sb.toString();
        }
    }
}