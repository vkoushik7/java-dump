class quicksort {
    public static int partition(int arr[],int low,int high) {
        int pivot = arr[high];
        int i = low-1;
        for (int j=low;j<high;j++) {
            if (arr[j]<pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    public static void sort(int arr[],int low,int high) {
        if (low<high) {
            int pivot = partition(arr,low,high);
            sort(arr,low,pivot-1);
            sort(arr,pivot+1,high);
        }
    }
    public static void main(String[] args) {
        int arr[] = {9,8,7,6,5,4,3,2,1,0};
        sort(arr,0,9);
        for (int a:arr)
            System.out.print(a+" ");        
    }    
}
