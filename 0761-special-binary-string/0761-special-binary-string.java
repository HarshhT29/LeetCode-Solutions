class Solution {
    public String makeLargestSpecial(String s) {
        if (s.isEmpty()) return "";
        
        List<String> specials = new ArrayList<>();
        int cnt = 0;
        
        for (char c : s.toCharArray()) {
            if (cnt == 0) specials.add("");
            cnt += (c == '1') ? 1 : -1;
            int idx = specials.size() - 1;
            specials.set(idx, specials.get(idx) + c);
        }
        
        for (int i = 0; i < specials.size(); i++) {
            String special = specials.get(i);
            String middle = special.substring(1, special.length() - 1);
            specials.set(i, '1' + makeLargestSpecial(middle) + '0');
        }
        
        Collections.sort(specials, Collections.reverseOrder());
        
        StringBuilder res = new StringBuilder();
        for (String special : specials) {
            res.append(special);
        }
        return res.toString();
    }
}