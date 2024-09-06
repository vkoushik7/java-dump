public class mergesort {
    public static void merge(int arr[],int p,int q,int r){
        int n1 = q-p+1;
        int n2 = r-q;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i=0;i<n1;i++){
            L[i] = arr[p+i];
        }
        for (int i=0;i<n2;i++){
            R[i] = arr[q+i+1];
        }
        int k=p,i=0,j=0;
        while (i<n1 && j<n2){
            if (L[i]<=R[j]){
                arr[k++] = L[i++];
            }
            else{
                arr[k++] = R[j++];
            }
        }
        while (i<n1){
            arr[k++] = L[i++];
        }
        while (j<n2){
            arr[k++] = R[j++];
        }
    }
    public static void sort(int arr[],int p,int r){
        if (p<r){
            int q = (p+r)/2;
            sort(arr,p,q);
            sort(arr,q+1,r);
            merge(arr,p,q,r);
        }
    }    
    public static void main(String[] args) {
        int arr[] = {5,2,3,1};
        sort(arr,0,arr.length-1);
        for (int a:arr)
            System.out.print(a+" ");

    }
}
