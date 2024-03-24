import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.java.contract.ContractImport;
import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;


@ContractImport("java.util.ArrayList")
@Invariant({
		"numbers != null", // the list itself must not be null
		"!numbers.contains(null)" // the list must not contain any null elements
})
public class NaturalList {
	private ArrayList<Natural> numbers;
	
	// No contracts required for the following methods.
	public NaturalList(NaturalList o) { 
		numbers = new ArrayList<Natural>();
		for(Natural n : o.numbers) 
			numbers.add(new Natural(n));
	}
	
	public NaturalList() {
		numbers = new ArrayList<Natural>();
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof NaturalList)) return false;
		NaturalList other = (NaturalList) o;
		return numbers.equals(other.numbers);
	}

	@Override
	public String toString() {
		return numbers.toString(); 
	}

	// Add contracts to all following methods.
	public void push(Natural n) {
		numbers.add(n);
	}
	
	public Natural get(int i) {
		return numbers.get(i);
	}
	
	public void set(int i, Natural n) {
		numbers.set(i, n);
	}
	
	public void sort() {
		Collections.sort(numbers);
	}
	
	public int search(Natural n) {
		return Collections.binarySearch(numbers, n);
	}
}
