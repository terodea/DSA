#include<stdio.h>
#include<stdlib.h>
struct Node{
    /*   ______________________ 
     *  |     |          |     |
     *  |prev |   data   |next |
     *  |_____|__________|_____|
     *  
     */
    int data ;
    struct Node* next;
    struct Node* prev;
};

/* Insert new node on the front the list, given a reference (pointer to pointer)
 * to the head of list and data.
 */ 
void push(struct Node** head_ref, int new_data){

    /* 1. Allocate Node */
    struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));

    /* 2. Put in the data*/
    new_node -> data = new_data;

    /* 3. Make next of new node as head and previous as NULL*/
    new_node -> next = (*head_ref);
    new_node -> prev = NULL;

    /* 4. Change prev of head node to new node*/
    if ((*head_ref) != NULL)
        (*head_ref) -> prev = new_node;

    /* 5. Move the head to point to the new node*/
    (*head_ref) = new_node;
}

/* Given a node as prev_node, insert a new node after the given node. */ 
void insertAfter(struct Node* prev_node, int new_data){
    
    /* 1. Check of the given prev_node is NULL. */
    if(prev_node == NULL){
        printf("The given previous node cannot be NULL");
        return ;
    }
    /* 2. Allocate memory and space to new_node. */
    struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));

    /* 3. Put in the data. */
    new_node -> data = new_data;

    /* 4. Make next of new node as next of prev_node. */
    new_node -> next = prev_node -> next;

    /* 5. Make the next of prev_node as new_node. */ 
    prev_node -> next = new_node;

    /* 6. Make prev_node as previous of new_node. */
    new_node -> prev = prev_node;

    /* 7. Change previous of new_node's next node. */
    if (new_node -> next != NULL)
        new_node -> next -> prev = new_node;
}

/* Given a reference (pointer to pointer) to the head 
 * of a DLL and an int, append a new node at the end.
 */ 
void append(struct Node** head_ref, int new_data){
    
    /* 1. Allocate node*/
    struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));
    struct Node* last = *head_ref;

    /* 2. Put in the data*/
    new_node -> data = new_data;

    /* 3. This new node is going to be the last node, so 
     * make next of it as NULL 
     */ 
    new_node -> next = NULL;

    /* 4. If the LL is empty, then make the new node as head */ 
    if (*head_ref == NULL){
        new_node -> prev = NULL;
        *head_ref = new_node;
        return;
    }

    /* 5. Else traverse till the last node */ 
    while (last -> next != NULL)
        last = last -> next; 

    /* 6. Change the next of the last node */ 
    last -> next = new_node;

    /* 7. Make last node as previous of new node */ 
    new_node -> prev = last;
    return;
}

void printList(struct Node* node){
    struct Node* last ;
    printf("\nTraversal in forward direction \n");
    while(node != NULL){
        printf("%d -> ", node->data);
        last = node;
        node = node -> next;
    }
    printf("NULL");
    printf("\n Traversal in reverse direction \n");
    while(last != NULL){
        printf("%d ->  ",last ->data);
        last = last -> prev;
    }
    printf("NULL \n");
}

void deleteLastNode(struct Node **head_ref){
    struct Node *temp =  *head_ref, *current = *head_ref;
    if(*head_ref == NULL){
        printf("List Empty !");
        return;
    }
    while (current -> next != NULL){
        current = current -> next;
    }
    temp = current -> prev;
    temp -> next = current -> next;
    free(current);
    return;
}

void deleteFrontNode(struct Node **head_ref){
    struct Node *temp = *head_ref;

    if(*head_ref == NULL){
        printf("List is empty.");
        return;
    }
    temp = *head_ref;
    *head_ref = (*head_ref) -> next;
    (*head_ref) -> prev = NULL;
    free(temp);
    return;
}

void delete(struct Node **head_ref, int position){
    struct Node *temp2, *temp = *head_ref;
    int k=1;
    if(*head_ref == NULL){
        printf("List is Empty");
        return;
    }
    if(position == 1){
        *head_ref = (*head_ref) -> next;

    if(*head_ref != NULL)
            (*head_ref)->prev = NULL;
        free(temp);
        return;
        
    }
    while(k < position && temp -> next != NULL){
        temp = temp -> next;
        k++;
    }
    if(k < position -1){
        printf("Desired position does not exist \n");
        return;
    }

    temp2 = temp -> prev;
    temp2 -> next = temp -> next;

    if(temp -> next)
        temp->next->prev = temp2;

    free(temp);
    return;
}


/* Driver program to test above functions */ 
int main(){
    /* Start with the empty list. */ 
    struct Node* head = NULL;

    //Insert 6. DLL is 6 -> NULL
    append(&head, 6);

    //Insert 7 at the beginnning. DLL is 7->6->NULL 
    push(&head, 7);

    //Insert 1 at the beginnning. DLL is 1 -> 7 -> 6 -> NULL 
    push(&head, 1);

    //Insert 4 at the end. DLL is 1 -> 7 -> 6 -> 4 -> NULL 
    append(&head, 4) ;

    //Insert 8, after 7. DLL is 1 -> 7 -> 8 -> 6 -> 4 -> NULL
    insertAfter(head -> next, 8);

    printf("Created DLL is: ");
    printList(head);

    printf("\n Let the deletion begin \n");

    deleteFrontNode(&head);
    printList(head);

    deleteLastNode(&head);
    printList(head);

    delete(&head,2);
    printList(head);
    return 0;
}
