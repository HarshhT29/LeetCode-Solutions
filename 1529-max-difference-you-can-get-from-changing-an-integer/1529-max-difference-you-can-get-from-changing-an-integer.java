class Solution {
    public int maxDiff(int num) {
        String numString = Integer.toString(num);
        char toGetMax = ' ';
        for(char ns : numString.toCharArray()) {
            if(ns != '9') {
                toGetMax = ns;
                break;
            }
        }
        char toReplaceInMin = ' ';
        char replaceWithInMin = ' ';
        if(numString.charAt(0)!='1') {
            toReplaceInMin = numString.charAt(0);
            replaceWithInMin = '1';
        } else {
            boolean first = true;
            for(char ns:numString.toCharArray()) {
                if(first) {
                    first = false;
                    continue;
                }
                if(ns!='0' && ns!='1') {
                    toReplaceInMin = ns;
                    replaceWithInMin = '0';
                    break;
                }
            }
        }

        String maxString = numString;
        if(toGetMax != ' ') {
            maxString = maxString.replace(toGetMax, '9');
        }
        String minString = numString;
        if(toReplaceInMin != ' ') {
            minString = minString.replace(toReplaceInMin, replaceWithInMin);
        }

        return Integer.parseInt(maxString) - Integer.parseInt(minString);
    }
}
