class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max=0;
        while(left<right){
            
            if(height[left] == height[right]){
                if(max < (right-left)*height[left]) 
                max=(right-left)*height[left];
                left++;
                right--;
            }
            else if(height[left] < height[right]){
                if(max < (right-left)*height[left]) 
                max=(right-left)*height[left];
                left++;
            }
            else if(height[left] > height[right]){
                if(max < (right-left)*height[right]) 
                max=(right-left)*height[right];
                right--;
            }
            
        }
        return max;
    }
}