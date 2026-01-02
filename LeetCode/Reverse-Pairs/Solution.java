1class Solution {
2    private void merge(int [] arr,int l,int mid, int r) {
3        int [] temp =  new int[r-l+1] ;
4        int i =l;
5        int k =0;
6        int j = mid + 1;
7        
8        while(i<=mid && j <=r) {
9            if(arr[i] < arr[j]) {
10                temp[k] = arr[i] ;
11                i++ ;
12                k++ ;
13            }
14            else{
15                temp[k] = arr[j] ;
16                k++ ;
17                j++ ;
18            }
19        }
20        
21        //if left.........
22        while(i<= mid) {
23            temp[k++] = arr[i++] ;
24        }
25        while(j<=r) {
26            temp[k++] = arr[j++] ;
27        }
28        
29        for(k=0,i=l ;k<temp.length;k++,i++) {
30            arr[i] = temp[k] ;
31        }
32    }
33    private int countpairs(int nums[],int l,int mid,int r) {
34        int rt = mid + 1;
35        int ans = 0;
36
37        for (int i = l; i <= mid; i++) {
38            while (rt <= r && (long) nums[i] > 2L * nums[rt]) {
39                rt++;
40            }
41            ans += (rt - (mid + 1));
42        }
43        return ans;
44    }
45    private int mergeSort(int arr[], int l, int r) {
46        // code here
47        int count = 0;
48        int mid = l + (r-l)/2 ;
49        
50        if(l>=r) {
51            return count;
52        }
53        
54        count += mergeSort(arr,l,mid) ;
55        count += mergeSort(arr,mid+1,r) ;
56        count += countpairs(arr,l,mid,r) ;
57        merge(arr,l,mid,r) ;
58
59        return count ;
60    }
61    public int reversePairs(int[] nums) {
62        int ans = mergeSort(nums,0,nums.length-1) ;
63
64        return  ans ;
65    }
66}