package StackAndQueue;

public class NormalQueue {
    int []data;
    int front;
    int size;
    public NormalQueue(int cap){
        data = new int[cap];
        front = 0;
        size = 0;
    }
    int size(){
        return size;
    }
    
    void display(){
        for (int i = 0; i < size; i++) {
            int idx = (front+i)%data.length;
            System.out.print(data[idx] + " ");
        }
        System.out.println("");
    }
    void add(int val){
        if(size == data.length){
            System.out.println("Queue Overflow");
        }
        else{
            int idx = (front + size)%data.length;
            data[idx] = val;
            size++;
        }
    }
    void remove(){
        if(size == 0){
            System.out.println("Queue Underflow");
        }
        else{
            front = (front+1)%data.length;
            size--;
        }
    }
    int peek(){
        if(size == 0){
            System.out.println("Queue underflow");
            return -1;
        }
        else{
            int val = data[front];
            return val;
        }
    }
    public static void main(String[] args) {
        
    }
}
