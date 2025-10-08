class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n=potions.length;
        
        int []result=new int [spells.length];
        for(int i=0;i<spells.length;i++){
            int count=0;
            int min_potion=(int)Math.ceil((double)success/spells[i]);
            int index=search(potions,min_potion);
           if(index!=-1) count=n-index;
           result[i]=count;
        }
        return result;
    }
    public static int search(int []potions,int min_potion){
        int low=0;
        int ans=-1;
        int high=potions.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(potions[mid]>=min_potion){
                high=mid-1;
                ans=mid;
            }
            else{low=mid+1;}
        }
        return ans;

    }
}