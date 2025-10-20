class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String op:operations) {
            switch (op) {
                case "++X":
                    {++x;
                    break;}
                case "X++":
                    {x++;
                    break;}
                case "--X":
                    {--x;
                    break;}
                case "X--":
                    {x--;
                    break;}
                default:
                    {break;}
            }
        }
        return x;
    }
}