1class Solution {
2    public int search(int[] nums, int target) {
3        int left = 0;
4        int right = nums.length - 1;
5        
6        while (left <= right) {
7            int mid = left + (right - left) / 2;
8
9            if (nums[mid] == target) {
10                return mid;
11            }
12
13            // Check if the left half is sorted
14            if (nums[left] <= nums[mid]) {
15                if (nums[left] <= target && target < nums[mid]) {
16                    right = mid - 1; // Search in the left half
17                } else {
18                    left = mid + 1;  // Search in the right half
19                }
20            } 
21            // Check if the right half is sorted
22            else {
23                if (nums[mid] < target && target <= nums[right]) {
24                    left = mid + 1;  // Search in the right half
25                } else {
26                    right = mid - 1; // Search in the left half
27                }
28            }
29        }
30        return -1; // Target not found
31    }
32}
33