// class Solution {
//     public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
//         int i=0,j=0;
//         long cnt = 0L;
//         long res = 0L;

//         while(j<nums.size()) {
//             if(nums.get(j)%modulo==k) {
//                 cnt++;
//                 if(cnt%modulo==k) {
//                     res++;
//                 }
//             }
//             // while(cnt>1 && i<nums.size()) {
//             //     if(nums.get(i)%modulo==k) {
//             //         cnt--;
//             //         if(cnt%modulo==k) {
//             //             res++;
//             //         }
//             //     }
//             //     i++;
//             // }
//             if(cnt%modulo==k) {
//                 res+=1;
//             }
//             j++;
//         }
//         return res;
//     }
// }

class Solution {

    public long countInterestingSubarrays(
        List<Integer> nums,
        int modulo,
        int k
    ) {
        int n = nums.size();
        HashMap<Integer, Integer> cnt = new HashMap<>();
        long res = 0;
        int prefix = 0;
        cnt.put(0, 1);
        for (int i = 0; i < n; i++) {
            prefix += nums.get(i) % modulo == k ? 1 : 0;
            res += cnt.getOrDefault((prefix - k + modulo) % modulo, 0);
            cnt.put(prefix % modulo, cnt.getOrDefault(prefix % modulo, 0) + 1);
        }
        return res;
    }
}