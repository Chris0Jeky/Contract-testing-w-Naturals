import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

@Invariant("data >= 0 && data <= Integer.MAX_VALUE")
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

	@Requires("d >= 0") // Constructor should only accept non-negative integers.
	public Natural(int d) {
		data = d;
	}

	@Requires("data < Integer.MAX_VALUE")
	@Ensures("data == old(data) + 1")
	public void increment() {
		data++;
	}

	@Requires("data > 0") // Can't decrement 0 or negative number.
	@Ensures("data == old(data) - 1")
	public void decrement() {
		data--;
	}

	@Requires("n != null && data + n.data <= Integer.MAX_VALUE") // Check for overflow.
	@Ensures("data == old(data) + n.data")
	public void add(Natural n) {
		data += n.data;
	}

	@Requires("n != null && data >= n.data") // Check to ensure no negative results.
	@Ensures("data == old(data) - n.data")
	public void subtract(Natural n) {
		data -= n.data;
	}

	@Requires("n != null && Integer.MAX_VALUE / n.data >= data") // Check for overflow.
	@Ensures("data == old(data) * n.data")
	public void multiply(Natural n) {
		data *= n.data;
	}

	@Requires("n != null && n.data > 0") // Cannot divide by zero.
	@Ensures("data == old(data) / n.data")
	public void divide(Natural n) {
		data /= n.data;
	}
}
