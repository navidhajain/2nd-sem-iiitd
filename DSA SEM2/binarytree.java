import java.util.*;

public class binarytree {

    public binarytree left;
    public binarytree right;
    public int data;

    binarytree(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }

    public void print(binarytree root){
        if(root==null){
            return;
        }

        System.out.println(root.data +": " + "L: " + root.left.data + "R: " + root.right.data);
        print(root.left);
        print(root.right);
    }

    public binarytree input(){
        Scanner s=new Scanner(System.in);
        int rootdata=s.nextInt();
        if(rootdata==-1){
            s.close();
            return null;
        }

        binarytree root=new binarytree(data);
        binarytree leftchild=input();
        binarytree rightchild= input();
        root.left=leftchild;
        root.right=rightchild;
        s.close();
        
        return root;
    }

    public int numberofbinarytrees(binarytree root){
        if(root==null){
            return 0;
        }
        return numberofbinarytrees(root.right)+numberofbinarytrees(root.left)+1;
    }
    
    public int greaterthanx(binarytree root, int x){
        if (root==null){
            return 0;
        }

        int count=(root.data>x) ? 1:0;
        if(root.left!=null){
            count=count+greaterthanx(root.left, x);
        }
        if(root.right!=null){
            count=count+greaterthanx(root.right, x);
        }
        return count;    

    }
    public int height(binarytree root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.right), height(root.left))+1;
    }

    public int numleaves(binarytree root){
        if(root==null){
            return 0;
        }
        if(root.right==null || root.left==null){
            return 1;
        }
        return numleaves(root.right)+numleaves(root.left)+1;
    }

    public void mirror(binarytree root){
        if(root==null){
            return ;
        }
        mirror( root.left);
        mirror(root.right);
        binarytree roottemp= new binarytree(root.data);
        roottemp=root.left;
        root.left=root.right;
        root.right=roottemp;
    }

    public int diameter(binarytree root){
        if(root==null){
            return 0;
        }
        int o1= height(root.right)+height(root.left);
        int o2= diameter(root.left);
        int o3= diameter(root.right);

        return Math.max(o1, Math.max(o2, o3));

    }

    public boolean search(binarytree root, int x){
        if (root==null){
            return false;
        }
        if(x==root.data){
            return true;
        }
        else if(x>root.data){
            return search(root.right, x);
        }
        else{
            return search(root.left, x);
        }
    }

    public binarytree makebst(int arr[], int start, int end){
        if (start>end){
            return null;
        }
        int mid= (end+start)/2;
        binarytree root=new binarytree(mid);
        root.left=makebst(arr, start, mid-1);
        root.right=makebst(arr, mid+1, end);

        return root;
    }

    public ArrayList<Integer> binarytreetopath(binarytree root, int x){
        if (root==null){
            return null;
        }
        if (root.data==x){
            ArrayList<Integer> output=new ArrayList<Integer>();
            output.add(root.data);
            return output;
        }
        ArrayList<Integer> leftout= binarytreetopath(root.left, x);
        if (leftout!=null){
            leftout.add(root.data);
            return leftout;
        }
        ArrayList<Integer> rightout= binarytreetopath(root.right, x);
        if (rightout!=null){
            rightout.add(root.data);
            return rightout;
        }

        return null;

    }

    public binarytree delete(binarytree root, int data){
        if (root == null)
            return root;

        if (data < root.data)
            root.left = delete(root.left, data);
        else if (data > root.data)
            root.right = delete(root.right, data);

        else {
            // binarytree with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // binarytree with two children
            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }
 
        return root;
    }

    public int minValue(binarytree root)
    {
        int minv = root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public boolean isMinHeap(binarytree root, int i, int n)
    {
        if (root == null) {
            return true;
        }
        if (i >= n) {
            return false;
        }
        if ((root.left != null && root.left.data <= root.data) ||
                    (root.right != null && root.right.data <= root.data)) {
            return false;
        }
        return isMinHeap(root.left, 2*i + 1, n) && isMinHeap(root.right, 2*i + 2, n);
    }
 
    public static boolean isHeap(binarytree root)
    {
        int i = 0;
        return isHeap(root, i, size(root));
    }

    public static binarytree copy(binarytree root) {
        if (root==null) {
            return root;
        }
        binarytree temp= new binarytree(root.data);
        temp.left=copy(root.left);
        temp.right=copy(root.right);

        return temp;
    }

    public static binarytree insert(binarytree root, int value) {
        if (root==null) {
            root= new binarytree(value);
        }
        else{
            if (value<roo.data) {
                root.left=insert(root.left, value);
            }
            else{
                root.right=insert(root.right, value);
            }
        }
        return root;
    }

    public static boolean isbst(binarytree root, int min, int max) {
        if (root==null) {
            return true;
        }
        return root.data>min && root.data <max && isbst(root.left, min, root.data) && isbst(root.right, root.data, max);
    }

    public static void main(String[] args) {
        binarytree bt= new binarytree(2);
    }

}
