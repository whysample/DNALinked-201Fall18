

public class LinkStrand implements IDnaStrand{
	private class Node {
	   	String info;
	   	Node next;
	   	public Node(String s) {
	      	info = s;
	      	next = null;
	   	}
	   }
	   private Node myFirst,myLast;
	   private long mySize;
	   private int myAppends;
	   private Node myCurrent;
	   private int myIndex;
	   private int myLocalIndex;
	
	/**
	 * This constructor without parameters calls the constructor with parameters to create a LinkStrand object that
	 * is initialized with a String "".
	 */
	public LinkStrand() {
		this("");
	}
	
	/**
	 * This constructor with a parameter of type String calls the function initialize to create a LinkStrand object
	 * that is initialized using the String in the object parameters.
	 * @param y is of type String which is used to initialize the node of dna
	 */
	public LinkStrand(String y) {
		initialize(y);
	}
	
	/**
	 * This acts as a getter function to return this object's variable mySize which is the number of nucleotides
	 * in the list.
	 */
	@Override
	public long size() {
		return this.mySize;
	}
	
	/**
	 * This is used to initialize the object. Through its parameter, it initializes the object's instance variables.
	 * @param source is a String which represents the list of nucleotides first creating the node
	 */
	@Override
	public void initialize(String source) {
		this.myFirst=new Node(source);
		this.myLast=this.myFirst;
		this.mySize=source.length();
		this.myAppends=0;
		this.myIndex=0;
		this.myCurrent=null;
		this.myLocalIndex=0;
	}
	
	/**
	 * Returns a newly created LinkStrand object by calling the constructor LinkStrand(String).
	 * @param source is a String that represents the nucleotide list.
	 */
	@Override
	public IDnaStrand getInstance(String source) {
		return new LinkStrand(source);
	}
	
	/**
	 * This function adds on a new node to the linked list of this object. It then adjusts the int 
	 * variables mySize and myAppends.
	 * @param dna is a String that represents the nucleotides of a new node to the linkedlist.
	 */
	@Override
	public IDnaStrand append(String dna) {
		this.myLast.next= new Node(dna);
		this.myLast=this.myLast.next;
		this.mySize+=dna.length();
		this.myAppends+=1;
		return this;
	}
	
	/**
	 * Reverse the linked list of dna nucleotides of the this object. It works by reversing each node.info and then 
	 * reversing the order of the nodes. A new object is returned that represents the reversed list of this object. 
	 */
	@Override
	public IDnaStrand reverse() {
		Node q=this.myFirst;
		StringBuilder e=new StringBuilder(this.myFirst.info);
		LinkStrand i= new LinkStrand(e.reverse().toString());
		q=q.next;
		while(q!=null) {
			StringBuilder u=new StringBuilder(q.info);
			i.append((u.reverse().toString()));
			q=q.next;
		}
		Node c=i.myFirst;
		LinkStrand b = new LinkStrand(c.info);
		c=c.next;
		while(c!=null) {
			Node x=new Node(c.info);
			x.next=b.myFirst;
			b.myFirst=x;
			c=c.next;
		}
		Node r=b.myFirst;
		while (r.next!=null) {
			r=r.next;
		}
		b.myLast=r;
		b.myAppends=i.myAppends;
		b.mySize=i.mySize;
		return b;
	}
	
	/**
	 * Creates a new string from all the nodes in the linkedlist of the object. It utilizes the StringBuilder(object) to create the string.
	 */
	@Override
	public String toString() {
		StringBuilder b= new StringBuilder();
		Node y= this.myFirst;
		while (y!=null) {
			b.append(y.info);
			y=y.next;
		}
		return b.toString();
	}
	
	/**
	 * Functions as a getter method to return the int variable myAppends. Which represents the number of times a new node was added to the list. 
	 */
	@Override
	public int getAppendCount() {
		
		return this.myAppends;
	}
	
	/**
	 * returns the nucleotide of type char that is in the index of the dna list. It utilizes the three private instance variables: myLocalIndex, myCurrent, myIndex. 
	 * The if statement checks if the index has already been passed through. If it has already been passed the count, dex, and node are all restarted at the beginning.
	 */
	@Override
	public char charAt(int index) {
		if (index>myIndex) {
			int count = myIndex;
			int dex = myLocalIndex;
			if (myCurrent==null) {
				myCurrent = this.myFirst;
			}
			while (count != index) {
				count++;
				dex++;
				if (dex >= myCurrent.info.length()) {
					dex = 0;
					myCurrent = myCurrent.next;
				if(count>=mySize) {
					throw new IndexOutOfBoundsException();
				}
				}
			}
			myIndex=count;
			myLocalIndex=dex;
		}
		else {
			int count = 0;
			int dex = 0;
			Node list = myFirst;
			while (count != index) {
				count++;
				dex++;
				if (dex >= list.info.length()) {
					dex = 0;
					list = list.next;
				}
				if(count>=mySize) {
					throw new IndexOutOfBoundsException();
				}
			}
			myIndex=count;
			myLocalIndex=dex;
			myCurrent=list;
		}
		return myCurrent.info.charAt(myLocalIndex);	
	}

}
