class cqQueue{
    int[] arr;
    int front;
    int rear;
    int size;
    int currsize;

    cqQueue(int size){
        arr= new int[size];
        front=-1;
        rear=-1;
        currsize=0;
    }

    public void addq(int data){
        if (front==rear+1 || front==0 && rear==size-1) {
            System.out.println("overflow");
            return;
        }
        else{
            rear=rear+1;
            if (rear==size) {
                rear=0;
            }
            arr[rear]=data;
            }
            if (front==-1) {
                front=0;
            }
            currsize++;
    }

    public int delq() {
        int data;
        if (front==-1 || rear==-1) {
            System.out.println("underflow");
            return -1;
        }
        else{
            if (front==rear) { //for single element
                data=arr[front];
                front=-1;
                rear=-1;
            }
            else{
                data=arr[front];
                front++;
                if (front==size) {
                    front=0;
                }
            }
        currsize--;    
        }
        return data;
    }

    public void displayq() {
        if (front==-1 || rear==-1) {
            System.out.println("empty");
        }
        else{
            if (front<=rear) {
                for (int i = front; i <= rear ; i++) {
                    System.out.print(arr[i]+" ");
                }
            }else{
                for (int i = front; i < arr.length; i++) {
                    System.out.print(arr[i]+" ");
                }
                for (int i = 0; i <= rear ; i++) {
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
        }
    }
}

public class cqusingarray {
    public static void main(String[] args) {
        cqQueue cq=new cqQueue(10);
        cq.addq(1);
        cq.addq(2);
        cq.addq(3);
        cq.addq(4);
        cq.displayq();
        System.out.println(cq.delq());
        cq.displayq();
    }

}
