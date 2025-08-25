class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] res = new int[mat.length*mat[0].length];
        int resIdx = 0;
        List<Integer> helperList = new ArrayList<>();
        for(int i=0;i<(mat.length+mat[0].length-1);i++) {
            helperList.clear();
            int row = i < mat[0].length? 0: i-mat[0].length+1;
            int col = i < mat[0].length ? i: mat[0].length - 1;

            while(row < mat.length && col >= 0) {
                helperList.add(mat[row][col]);
                row++;
                col--;
            }
            if((i&1)==0) {
                Collections.reverse(helperList);
            }
            for(int j=0;j<helperList.size();j++) {
                res[resIdx++] = helperList.get(j);
            }
        }
        return res;
    }
}