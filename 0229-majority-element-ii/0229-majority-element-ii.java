class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer can1 = null, can2 = null;
        int cnt1 = 0, cnt2 = 0;
        for(int num:nums) {
            if(can1!=null && num==can1) {
                cnt1++;
            } else if(can2!=null && num==can2) {
                cnt2++;
            } else if(cnt1==0) {
                cnt1 = 1;
                can1 = num;
            } else if(cnt2==0) {
                cnt2 = 1;
                can2 = num;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = cnt2 = 0;
        for(Integer num:nums) {
            if(can1!=null && can1.equals(num)) {
                cnt1++;
            } else if(can2!=null && can2.equals(num)) {
                cnt2++;
            }
        }
        List<Integer> li = new ArrayList<>();
        if(cnt1>(nums.length/3)) {
            li.add(can1);
        }
        if(cnt2>(nums.length/3)) {
            li.add(can2);
        }
        return li;
    }
}