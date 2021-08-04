# include<stdio.h>
# include<stdlib.h>
# include<math.h>

void merge(int arr[], int p, int q, int r){
    int i, j, k;
    int n1 = q - p + 1;
    int n2 = r - q;
    int L[n1], R[n2];
    for (i=0; i< n1; i++){
        L[i] = arr[p+i];
    }
    for (j=0; j<n2; j++){
        R[j] = arr[q+1+j];
    }

    i = 0;
    j = 0;
    k = p;

    while (i < n1 && j < n2){
        if (L[i]<= R[j]){
            arr[k] = L[i];
            i++;
        }
        else{
            arr[k] = R[j];
            j++;
        }
        k++;
    }
    while(i < n1){
        arr[k] = L[i];
        i++;
        k++;
    }
    while (j < n2){
        arr[k] = R[j];
        j++;
        k++;
    }
}
void mergeSort(int arr[], int p, int r){
    if (p < r) {
        // Same as (q+r)/2, but avoids overflow for
        // large q and r
        int q = p + (r - p) / 2;
 
        // Sort first and second halves
        mergeSort(arr, p, q);
        mergeSort(arr, q + 1, r);
        merge(arr, p, q, r);
    }
}

void printArray(int A[], int size){
    int i;
    for (i = 0; i < size; i++)
        printf("%d ", A[i]);
    printf("\n");
}

int main(){
    int arr [] = {12, 11, 13, 5, 6, 7};
    int arr_size = sizeof(arr) / sizeof(arr[0]);
    printf("Given array is \n");
    printArray(arr, arr_size);
    mergeSort(arr, 0, arr_size-1);
    printf("\n Sorted Array is \n");
    printArray(arr, arr_size);
    return 0;
}