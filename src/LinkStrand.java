

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
		StringBuilder e=new StringBuilder(this.myFirst.info);
		LinkStrand i= new LinkStrand(e.reverse().toString());
		Node r=this.myFirst;
		System.out.println(i.myFirst.info);
		r=r.next;
		while(r!=null) {
			StringBuilder p=new StringBuilder(r.info);
			Node o=new Node(p.reverse().toString());
			o.next=i.myFirst;
			System.out.println(o.next.info);
			i.myFirst=o;
			r=r.next;
		}
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
