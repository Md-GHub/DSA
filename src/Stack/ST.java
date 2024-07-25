package Stack;

public class ST {
    private int[] stack;
    private int top;
    private int DEFAULT_CAPACITY;

    public ST(){
        this.DEFAULT_CAPACITY = 20;
        this.top = -1;
        this.stack = new int[DEFAULT_CAPACITY];
    }

    public boolean isFull(){
        return this.top >= this.DEFAULT_CAPACITY-1;
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public void push(int value){
        if(this.isFull()){
            System.out.println("Stack is full");
            return;
        }
        ++this.top;
        stack[top]=value;
    }

    public void pop(){
        if(this.isEmpty()){
            System.out.println("Stack is empty");
            return ;
        }
        top--;
    }

    public int peek(){
        return (!isEmpty())? this.stack[top] : -1;
    }
}
