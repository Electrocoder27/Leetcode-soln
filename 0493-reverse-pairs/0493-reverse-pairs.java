class Solution {
    private void merge(int [] arr,int l,int mid, int r) {
        int [] temp =  new int[r-l+1] ;
        int i =l;
        int k =0;
        int j = mid + 1;
        
        while(i<=mid && j <=r) {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i] ;
                i++ ;
                k++ ;
            }
            else{
                temp[k] = arr[j] ;
                k++ ;
                j++ ;
            }
        }
        
        //if left.........
        while(i<= mid) {
            temp[k++] = arr[i++] ;
        }
        while(j<=r) {
            temp[k++] = arr[j++] ;
        }
        
        for(k=0,i=l ;k<temp.length;k++,i++) {
            arr[i] = temp[k] ;
        }
    }
    private int countpairs(int nums[],int l,int mid,int r) {
        int rt = mid + 1;
        int ans = 0;

        for (int i = l; i <= mid; i++) {
            while (rt <= r && (long) nums[i] > 2L * nums[rt]) {
                rt++;
            }
            ans += (rt - (mid + 1));
        }
        return ans;
    }
    private int mergeSort(int arr[], int l, int r) {
        // code here
        int count = 0;
        int mid = l + (r-l)/2 ;
        
        if(l>=r) {
            return count;
        }
        
        count += mergeSort(arr,l,mid) ;
        count += mergeSort(arr,mid+1,r) ;
        count += countpairs(arr,l,mid,r) ;
        merge(arr,l,mid,r) ;

        return count ;
    }
    public int reversePairs(int[] nums) {
        int ans = mergeSort(nums,0,nums.length-1) ;

        return  ans ;
    }
}