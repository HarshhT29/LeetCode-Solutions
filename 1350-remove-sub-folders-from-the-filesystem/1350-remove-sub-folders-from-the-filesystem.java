class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        res.add(folder[0]);
        boolean flag = false;
        for(String f:folder) {
            if(!flag) {
                flag = true;
                continue;
            }
            String last = res.get(res.size()-1)+'/';
            if(!f.startsWith(last)) {
                res.add(f);
            }
        }
        return res;
    }
}