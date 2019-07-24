#include <stdio.h>
#include <stdlib.h>

struct Node{
    int data;
    struct Node *next;
};

/* Given a reference (pointer to pointer) to the head of a list
 * and an int, insert a new node on the front of the list 
 * */

void push (struct Node** head_ref, int new_data){
    struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));
    new_node->data = new_data;
    new_node->next = (*head_ref);
    (*head_ref) = new_node;
}

/* Given a reference (pointer to pointer) to the head of a linked list
 * and a key, deletes the first occurence of key in the linked list 
 * */

void deleteNodeGivenKey(struct Node **head_ref, int key){
    
    //Store head node 
    struct Node* temp = *head_ref, *prev;

    //If head node itself holds the key to be deleted 
    if((temp != NULL) && (temp -> data == key)){
        
        *head_ref = temp->next; //Changed head 
        free(temp); // free old head 
        return;
    }

    //Search for the key to be deleted, keep track of the 
    //previous node as we need to change 'prev->node'
    while((temp != NULL) && (temp -> data != key)){
        prev = temp;
        temp = temp -> next;
    }

    //If key was not present in the linked list 
    if(temp == NULL)
        return;

    //Unlink the node from linked list 
    prev->next = temp->next;
    
    free(temp); // Free memory
}

/* Given a reference (pointer to pointer) to the head of a list 
 * and a position, deletes the node at the given position.
 * */
void deleteNodeGivenPosition(struct Node **head_ref, int position){

    // If linked list is empty
    if(*head_ref == NULL)
        return;

    // If head needs to be removed
    if(position == 0){
        *head_ref = temp->next; // Change head 
        free(temp); // free old head 
        return;
    }

    // Find previous node of the node to be deleted 
    for(int i=0; (temp != NULL)&&(i<position-1);i++)
        temp = temp -> next;

    // If position is more than number of nodes
    if(temp == NULL || temp->next == NULL)
        return;

    //Node temp-> next is the node to be deleted 
    //Store pointer to the next of node to be deleted 
    struct Node *next = temp -> next -> next;

    //Unlink the node from linked list 
    free(temp->next); // Free memory

    temp -> next = next; //Unlink the deleted node from list 
}

/* Function to delete the entire linke list
 * */ 
void deleteEntireLinkedList(struct Node** head_ref){
    /* de-referencing head_ref to get the real head*/
    struct Node* current = *head_ref;
    struct Node* next;

    while(current != NULL){
        next= current-> next;
        free(current);
        current = next;
    }
    /*de-referencing head_ref to affect the real head back
     * in the caller.
     * */ 
    *head_ref = NULL;
}

// This function prints contents of the linked list starting from 
// the given node. 
void printList(struct Node *node){
    while(node != NULL){
        printf(" %d ",node -> data);
        node = node -> next;
    }
}

/* Driver program to test above functions*/
int main(){
    
    /* Start with the empty list */ 
    struct Node* head = NULL;

    // 7->1->3->2->8
    push(&head, 7);
    push(&head, 1);
    push(&head, 3);
    push(&head, 2);
    push(&head, 8);

    printf("Created Linked List: ");
    printList(head);
    deleteNodeGivenKey(&head, 1);
    printf("\nLinked List after deletion having value 1: \n");
    printList(head);
    printf("\n");
    deleteNodeGivenPosition(&head, 3);
    printf("\nLinked List after deletion at 3rd position : \n");
    printList(head);
    printf("\nDeleting entire linked list \n");
    deleteEntireLinkedList(&head);
    printf("\nLinked List Deleted");
    return 0;
}
