#include<iostream>
using namespace std;

class LinkedList{
    struct Node{
        int data;
        Node *next;
    };
    Node *head;
    Node *current;
    public:
    LinkedList(){
        head = NULL;
    }
    int size(){
        int count = 0;
        Node *temp = head;
        while(temp != NULL){
            count++;
            temp = temp->next;
        }
        return count;
    }
    void print(){
        Node *temp = head;
        while(temp!=NULL){
            cout<<temp->data<<"->";
        }
        cout<<"NULL"<<endl;
    }
    void rev(){
        Node *prev = NULL;
        Node *curr = head;
        while(curr!=NULL){
            Node *next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    void addLast(int data){
        if(head == NULL){
            head = new Node;
            head->data = data;
            head->next = NULL;
            current = head;
        }
        else{
            current->next = new Node;
            current->next->data = data;
            current->next->next = NULL;
            current = current->next;
        }
    }
};

int main(){
    LinkedList l = LinkedList();
    l.addLast(1);
    l.addLast(2);
    l.addLast(3);
    l.addLast(4);
    l.addLast(5);
    
    l.print();
    l.rev();  
    l.print(); 
    return 0;
}