import java.io.*;
import java.util.*;

public class avltree{
	static node root = null;

	public static int getheight(node root){
		if(root==null){
			return 0;
		}
		return root.height;
	}

	public static int getbalance(node root){
		if(root==null){
			return 0;
		}
		return getheight(root.left) - getheight(root.right);
	}
	// Right rotation of subtree rooted on node root
	public static node rr(node root){
		node root_left = root.left;
		node root_left_right = root_left.right;

		root_left.right = root;
		root.left = root_left_right;

		root.height = 1+Math.max(getheight(root.left), getheight(root.right)) ;
		root_left.height = 1 + Math.max(getheight(root_left.left), getheight(root_left.right)) ;
		
		return root_left;

	}

	// Left Rotation of subtree rooted on node root
	public static node ll(node root){
		node root_right = root.right;
		node root_right_left = root_right.left;

		//Rotating
		root_right.left = root;
		root.right = root_right_left;

		// Root_right is above root now
		// For updating heights first update lower levels
		root.height = 1 + Math.max(getheight(root.left), getheight(root.right));
		//root.size = 1 + getsize(root.left) + getsize(root.right);

		root_right.height = 1 + Math.max(getheight(root_right.left), getheight(root_right.right));
		//root_right.size = 1 + getsize(root_right.left) + getsize(root_right.right);

		return root_right;
	}

	

	static node insert(node root, int val){
		if(root == null){
			return new node(val);
		}
		if(root.data == val){
			return root;
		}
		else if(root.data > val){
			root.left = insert(root.left, val);
			//root.size = 1 + getsize(root.left) + getsize
		}
		else {
			root.right = insert(root.right , val);
		}

		root.height = 1 + Math.max(getheight(root.left), getheight(root.right));
		int factor = getbalance(root);

		if(factor >1 && val < root.left.data){
			return rr(root);
		}

		// Right right case
		if(factor < -1 && val > root.right.data){
			return ll(root);
		}

		// left right case
		if(factor >1 && val > root.left.data){
			root.left = ll(root.left);
			return rr(root);
		}

		// right left case
		if(factor< -1 && val < root.right.data){
			root.right = rr(root.right);
			return ll(root);
		}
		return root;
	}

	static node delete(node root, int val){
		if(root == null){
			return root;
		}
		if(val < root.data){
			root.left = delete(root.left, val);
		}
		else if(val > root.data){
			root.right = delete(root.right, val);
		}
		else{

			if(root.left == null && root.right==null){
				root = null;
				return root;
			}
			else if( root.left == null){
				root = root.right;
			}
			else if (root.right == null){
				root = root.left;
			}
			else{
				node temp = minnode(root.right);

				root.data = temp.data;
				root.right = delete(root.right, temp.data);
			}
		}
		root.height = 1 + Math.max(getheight(root.left), getheight(root.right));
		
		int factor = getbalance(root);

		// Left left case
		if(factor >1 && getbalance(root.left) >= 0){
			return rr(root);
		}

		// Right right case
		if(factor < -1 && getbalance(root.right)<= 0){
			return ll(root);
		}

		// left right case
		if(factor >1 && getbalance(root.left)< 0){
			root.left = ll(root.left);
			return rr(root);
		}

		// right left case
		if(factor< -1 && getbalance(root.right) > 0){
			root.right = rr(root.right);
			return ll(root);
		}
		return root;

	}

	static node minnode(node root)
	{
		if(root == null || root.left==null){
			return root;
		}
		return minnode(root.left);

	}

	static node maxnode(node root){
		if(root == null || root.right == null){
			return root;
		}
		return maxnode(root.right);
	}


public static void main(String[] args) throws IOException {
		
		Reader.init(System.in);
		root = null;
		int q = Reader.nextInt();
		String qry;
		int x;
		for(int i=0; i<q; i++){
			qry = Reader.next();
			//System.out.println(qry+" "+ qry.equals("INSERT"));
			if(qry.equals("INSERT")){
				root = insert(root, Reader.nextInt());
			}
			else if(qry.equals("DELETE")){
				root =  delete(root, Reader.nextInt());
			}
			else if(qry.equals("MIN")){
				if(root == null){
					System.out.println("EMPTY");
				}
				else
				System.out.println(minnode(root).data);
			}
			else{
				if(root == null){
					System.out.println("EMPTY");
				}
				else
				System.out.println(maxnode(root).data);
			}

		}




	}
}

class node{
	int data;
	node left;
	node right;

	int height;
	node(int val){
		left = right = null;
		data = val;
		
		height = 1;
	}
}


class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
          
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
    static String nextLine() throws IOException {
    return reader.readLine();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
