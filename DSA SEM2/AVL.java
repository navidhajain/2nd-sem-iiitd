class Node {
    int data, height;
    Node left, right;
 
    Node(int d) {
        data = d;
        height = 1;
    }
}
 
class AVLTree {
 
    Node root;
    int height(Node N) {
        if (N == null)
            return 0;
 
        return N.height;
    }
    int max(int a, int b) {
        return (a > b) ? a : b;
    }
 
    Node rightRotate(Node n1) {
        Node n2 = n1.left;
        Node n3 = n2.right; 
        
        n2.right = n1;
        n1.left = n3;  //n1>n3>n2
 
        n1.height =Math.max(height(n1.left), height(n1.right)) + 1;
        n2.height =Math.max(height(n2.left), height(n2.right)) + 1;
 
        return n2;
    }
 
    Node leftRotate(Node n2) {
        Node n1 = n2.right;
        Node n3 = n1.left;

        n1.left = n2;
        n2.right = n3; //n1>n3>n2

        n2.height = Math.max(height(n2.left), height(n2.right)) + 1;
        n1.height =Math.max(height(n1.left), height(n1.right)) + 1;
 
      
        return n1;
    }
 
    int getBalance(Node N) {
        if (N == null)
            return 0;
 
        return height(N.left) - height(N.right);
    }
 
    Node insert(Node node, int data) {
 
        if (node == null)
            return (new Node(data));
 
        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right, data);
        else // Duplicate datas not allowed
            return node;
 
       
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);
 
        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && data < node.left.data)
            return rightRotate(node);
 
        // Right Right Case
        if (balance < -1 && data > node.right.data)
            return leftRotate(node);
 
        // Left Right Case
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
 
        // Right Left Case
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
 
       
        return node;
    }
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
 
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
 
        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);
 
        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Preorder traversal" +
                        " of constructed tree is : ");
        tree.preOrder(tree.root);
    }
}

public static Node delete(Node root, int x){
    if (root == null)
        return root;

    if (x < root.data)
        root.left = delete(root.left, x);
    else if (x > root.data)
        root.right = delete(root.right, x);

    else {
        if (root.left == null)
            return root.right;
        else if (root.right == null)
            return root.left;

        // binarytree with two children
        root.data = minValue(root.right);
        root.right = delete(root.right, root.data);
    }

    if (root == null)
        return root;
    

    root.height = 1+Math.max(height(root.left),height(root.right));


    int balance_factor = 0;
    balance_factor = height(root.left)-height(root.right);

    if(balance_factor>1 && x < root.left.data){
            //left left 
            right_rotations++;
            return rightRotate(root);
    }

    if(balance_factor<-1 && x> root.right.data){
            //right right
            left_rotations++;
            return leftRotate(root);
        }
    if(balance_factor>1 && x > root.left.data){
            //left right
            left_rotations++;
            root.left = leftRotate(root.left);
            right_rotations++;
            return rightRotate(root);
        }

    if(balance_factor<-1 && x<root.right.data){
            //right left
            right_rotations++;
            root.right = rightRotate(root.right);
            left_rotations++;
            return leftRotate(root);
        }

    return root;
}

public static int minValue(Node root)
{
    int minv = root.data;
    while (root.left != null)
    {
        minv = root.left.data;
        root = root.left;
    }
    return minv;
}