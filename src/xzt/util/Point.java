package xzt.util;

import java.util.LinkedList;
import java.util.List;

/*Revised*/
public class Point {
	private List<Double> data;
	private double label;
	
	public Point() {
		/*garantee the order of the array and initialize the label*/
		this.data = new LinkedList<Double>();  
		this.label = 0;
	}
	
	public Point(LinkedList<Double> data,double label) {
		super();
		this.data = data;
		this.label = label;
	}
	
	/*the real point */
	public Point(double []a) {
		this.data = new LinkedList<Double>();
		for(int i=0; i < a.length-1 ; i++ ) {
			data.add(a[i]);
		}
		this.label = a[a.length-1];
	}
	
	public Point(Point p) {
		this.data = p.data;
		this.label = p.label;
	}
	
	/*the original data */
	public Point(String []a) {
		this.data = new LinkedList<Double>();
		for(int i=0; i < a.length-1 ;i++ ) {
			data.add(Double.parseDouble(a[i]));
		}
		this.label = Double.parseDouble(a[a.length-1]);
	}

	public String toString() {
		StringBuffer str = new StringBuffer("");
		for(int i=0;i<this.data.size();i++) {
			str.append( this.data.get(i)+"," );
		}
		str.append(this.label);
		return str.toString();
	}
	
	/*return the i-th value  */
	public double get(int i) {
		return this.data.get(i);
	}
	public void set(int index,double value) {
		this.data.set(index, value);
	}
	
	/*Euclidean distance   */
	public double dist(Point p) {
		double sum = 0;
		for(int i=0;i<p.data.size();i++) {
			sum += Math.pow(this.data.get(i)-p.get(i), 2);
		}
		return Math.sqrt(sum);
	}
	
	//TODO  Is it meaningful?
	/*point plus point  */
	public void add(Point point) {
		for(int i=0;i<this.data.size();i++) {
			this.data.set(i, this.data.get(i)+point.get(i));
		}
	}
	
	public List<Double> getData() {
		return data;
	}

	public void setData(List<Double> data) {
		this.data = data;
	}
	

	public double getLabel() {
		return label;
	}

	public void setLabel(double label) {
		this.label = label;
	}

	/**
	 * judge if the two points are same
	 * @param point
	 * @return
	 */
	public boolean equal(Point point) {
		for(int i=0;i<this.data.size();i++) {
			if(this.data.get(i) != point.get(i))
				return false;
		}
		if( this.label != point.label )
			return false;
		return true;
	}

	public static void main(String[] args) {
		double x[] = {1.1,2.2,2.3,3.2,1.0};
		double y[] = {1.0,2.2,2.3,3.20,0.0};
		Point a = new Point(x);
		Point b = new Point(y);
		System.out.println(a.equal(b));
		System.out.println(a.dist(b));
	}
	
	
}
