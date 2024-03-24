import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

//Add an invariant here.
public class Natural implements Comparable<Natural> {
	private int data;

	// No contracts required for the following methods.

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Natural)) return false;
		Natural n = (Natural) o;
		return data==n.data;
	}
	
	public int compareTo(Natural n) { 
		return Integer.compare(data, n.data); 
	}
	
	public Natural(Natural n) {
		this(n.data);
	}

	@Override
	public String toString() {
		return Integer.toString(data); 
	}

	// Add contracts to all following methods.
	
	public Natural(int d) {
		data = d;
	}
	
	public void increment() {
		data++; 
	}
	
	public void decrement() {
		data--;
	}
	
	public void add(Natural n) {
		data += n.data;
	}
	
	public void subtract(Natural n) {
		data -= n.data;
	}
	
	public void multiply(Natural n) {
		data *= n.data;
	}
	
	public void divide(Natural n) {
		data /= n.data;
	}
}
