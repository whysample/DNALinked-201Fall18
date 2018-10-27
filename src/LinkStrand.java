

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
		Node d= new Node(e.reverse().toString());
		Node y=d;
		LinkStrand i= new LinkStrand();
		q=q.next;
		while(q!=null) {
			StringBuilder u=new StringBuilder(q.info);
			Node t=new Node(u.reverse().toString());
			t.next=d;
			d=t;
			q=q.next;
		}
		i.myFirst=d;
		i.myLast=y;
		return i;
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
