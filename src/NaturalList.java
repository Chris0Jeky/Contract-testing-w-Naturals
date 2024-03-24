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

	@Requires("n != null") // Can't add a null Natural object.
	@Ensures("numbers.contains(n) && numbers.get(numbers.size() - 1).equals(n)")
	public void push(Natural n) {
		numbers.add(n);
	}

	@Requires("i >= 0 && i < numbers.size()") // Index must be within the list size.
	@Ensures("result.equals(numbers.get(i))")
	public Natural get(int i) {
		return numbers.get(i);
	}

	@Requires({"i >= 0 && i < numbers.size()", "n != null"}) // Index within bounds and Natural is not null.
	@Ensures("numbers.get(i).equals(n)")
	public void set(int i, Natural n) {
		numbers.set(i, n);
	}

	// No preconditions required for sort; can sort an empty list or any list of Natural.
	@Ensures("java.util.Collections.min(numbers).equals(numbers.get(0)) && java.util.Collections.max(numbers).equals(numbers.get(numbers.size() - 1))")
	public void sort() {
		Collections.sort(numbers);
	}

	@Requires({"n != null", "java.util.Collections.min(numbers).compareTo(n) <= 0", "java.util.Collections.max(numbers).compareTo(n) >= 0"}) // Binary search requires sorted list and non-null search object.
	@Ensures("result >= 0 ? numbers.get(result).equals(n) : numbers.indexOf(n) == -1") // Result is index or -(insertion point) - 1.
	public int search(Natural n) {
		return Collections.binarySearch(numbers, n);
	}
}
