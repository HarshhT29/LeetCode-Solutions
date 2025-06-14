class Solution {
    public int minMaxDifference(int num) {
        int temp = num;
        int toGetMax = 0, toGetMin = 9;
        boolean maxFlag = false;
        boolean minFlag = false;
        while(temp>0) {
            int rem = temp % 10;
            if(rem!=9 && !maxFlag) {
                toGetMax = rem;
                maxFlag = true;
            }
            if(rem!=0 && !minFlag) {
                toGetMin = rem;
                minFlag = true;
            }
            if(maxFlag && minFlag) {
                break;
            }
            temp /= 10;
        }
        temp = num;
        int maxDigit = 0;
        int minDigit = 0;
        int place = 1;
        while(temp > 0) {
            int rem = temp % 10;
            int max = rem!=toGetMax?rem:9;
            int min = rem!=toGetMin?rem:0;

            maxDigit += max*place;
            minDigit += min*place;

            place *= 10;
            temp /= 10;
        }
        return maxDigit - minDigit;
    }
}