class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n=encodedText.length();
        int limit=n/rows;
        int i=0;
        StringBuilder ans=new StringBuilder();
        while(i<limit){
            for(int j=i;j<n;j+=limit+1){
                ans.append(encodedText.charAt(j));
            }
            i++;
        }
        return ans.toString().stripTrailing();
    }
}