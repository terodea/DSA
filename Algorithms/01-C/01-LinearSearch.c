#include<stdio.h>
int search(int arr[],int n, int x){
	for(int i =0; i<n; i++){
		if(arr[i]==x)
			return i;
	return -1;
	}
}

int main(){
	int arr []={1,2,3,4,10,40};
	int n = sizeof(arr)/sizeof(arr[0]);
	int x = 40;
	int result = search(arr,n,x);
	(result==-1)? printf("The no is not present in the array"):printf("The no is present at the following index--> %d",result);
	return 0;
}

