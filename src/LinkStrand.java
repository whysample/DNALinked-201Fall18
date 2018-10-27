

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

	public LinkStrand() {
		this("");
	}
	public LinkStrand(String y) {
		initialize(y);
	}
	@Override
	public long size() {
		// TODO Auto-generated method stub
		return this.mySize;
	}

	@Override
	public void initialize(String source) {
		this.myFirst=new Node(source);
		this.myLast=this.myFirst;
		this.mySize=source.length();
		this.myAppends=0;
	}

	@Override
	public IDnaStrand getInstance(String source) {
		return new LinkStrand(source);
	}

	@Override
	public IDnaStrand append(String dna) {
		this.myLast.next= new Node(dna);
		this.myLast=this.myLast.next;
		this.mySize+=dna.length();
		this.myAppends+=1;
		return this;
	}

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
	@Override
	public int getAppendCount() {
		
		return this.myAppends;
	}

	@Override
	public char charAt(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

}
