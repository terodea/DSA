#include<stdio.h>
#include<stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

struct Node *head = NULL;

int length(struct Node *head_ref){
    struct Node *current = head_ref;
    int count = 0;
    if(head_ref == NULL)
        return 0;
    do{
        current = current -> next;
        current++;
    }while(current != head_ref);
    return count;
}

void printList(struct Node * head_ref){
    struct Node *current = head_ref;
    if(head_ref == NULL)
        return;
    do{
        printf("%d-->",current -> data);
        current = current -> next;
    }while(current != head_ref);
}

void insertAtBeginInCLL(struct Node **head_ref, int data){
    struct Node *current = head_ref;
    struct Node *newNode = (struct Node *)(malloc(sizeof(struct Node*)));
    if(!newNode){
        printf("\nMemory Error");
        return;
    }
    newNode -> data = data;
    newNode -> next = newNode;
    if(current == NULL){
        *head_ref = newNode;
        return;
    }
    while (current -> next != *head_ref)
        current = current -> next;
    newNode -> next = *head_ref;
    current -> next = newNode;
    *head_ref = newNode;
}

void insertAtEndInCLL(struct Node **head_ref, int data){
    struct Node *current = head_ref;
    struct Node *newNode = (struct Node *)(malloc(sizeof(struct Node)));
    if(!newNode){
        printf("Memory Error");
        return;
    }
    newNode -> data = data;
    while (current -> next != *head_ref)
        current = current -> next;
    newNode -> next = newNode;
    if(*head_ref == NULL)
        *head_ref = newNode;
    else{
        newNode -> next = *head_ref;
        current -> next = newNode;
    }
}

int main(){
    struct Node *head = NULL;
    printf("%d \n",length(head));
    insertAtBeginInCLL(&head, 30);
    insertAtBeginInCLL(&head, 20);
    insertAtBeginInCLL(&head, 10);
    printf("List length is %d \n", length(head));
    printList(head);
    printf("\n");
    insertAtEndInCLL(&head, 40);
    insertAtEndInCLL(&head, 50);
    insertAtEndInCLL(&head, 60);
    printf("List length is %d \n",length(head));
    printList(head);
    return 0;
}
