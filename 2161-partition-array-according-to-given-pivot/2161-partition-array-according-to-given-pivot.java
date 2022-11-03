class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int less=0,grt=0,same=0;
        for(int  i  =0;i<nums.length;i++){
            if(nums[i]>pivot){
                grt++;
            } else if(nums[i]<pivot){
                less++;
            }else {
                same++;
            }
        }
        int []ans  = new int[nums.length];
        int l=0;
        int g=nums.length-grt;
        int mid=less;
         for(int  i  =0;i<nums.length;i++){
            if(nums[i]>pivot){
                ans[g]=nums[i];
                g++;
            } else if(nums[i]<pivot){
                ans[l]=nums[i];
                l++;
            }else {
                ans[mid]=nums[i];
                mid++;
            }
        }
        return ans;
    }
}