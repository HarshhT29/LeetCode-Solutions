class Solution {
    public long countOfSubstrings(String word, int k) {
        int[] nextCon = getNextConsonant(word.toCharArray());
        Map<Character, Integer> map = new HashMap<>();
        int n = word.length();
        int i=0, j=0;
        long cnt = 0, con=0;

        while(j<n) {
            if(!isVowel(word.charAt(j))) {
                con++;
            } else {
                map.put(word.charAt(j), map.getOrDefault(word.charAt(j), 0)+1);
            }
            while(con>k) {
                if(!isVowel(word.charAt(i))) {
                    con--;
                } else {
                    map.put(word.charAt(i), map.get(word.charAt(i))-1);
                    if(map.get(word.charAt(i))==0) {
                        map.remove(word.charAt(i));
                    }
                }
                i++;
            }
            while(i<n && map.size()==5 && con==k) {
                cnt = cnt + nextCon[j]-j;
                if(!isVowel(word.charAt(i))) {
                    con--;
                } else {
                    map.put(word.charAt(i), map.get(word.charAt(i))-1);
                    if(map.get(word.charAt(i))==0) {
                        map.remove(word.charAt(i));
                    }
                }
                i++;
            }
            j++;
        }
        return cnt;
    }
    private int[] getNextConsonant(char[] arr) {
        int[] nums = new int[arr.length];
        nums[nums.length-1] = nums.length;
        for(int i=nums.length-2;i>=0;i--) {
            if(!isVowel(arr[i+1])) {
                nums[i] = i+1;
            } else {
                nums[i] = nums[i+1];
            }
        }
        return nums;
    }
    private boolean isVowel(char ch) {
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}