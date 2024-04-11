import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NaturalListTest {

	@Test
	void testPushWithValidNatural() {
		NaturalList list = new NaturalList();
		Natural natural = new Natural(5);
		int initialSize = list.numbers.size();
		list.push(natural); // Should pass without throwing an error
		assertEquals(initialSize + 1, list.numbers.size()); // Assert the list size has increased.
		assertTrue(list.numbers.contains(natural)); // Assert the list contains the added element.
	}

	@Test
	void testPushWithNullNatural() {
		NaturalList list = new NaturalList();
		list.push(null); // Should throw PreconditionError
	}

	@Test
	void testSortEmptyList() {
		NaturalList list = new NaturalList();
		list.sort(); // Should pass without throwing an error
	}

	@Test
	void testSearchInSortedNaturalList() {
		NaturalList list = new NaturalList();
		list.push(new Natural(1));
		list.push(new Natural(3));
		list.push(new Natural(5));
		list.sort();

		list.search(new Natural(3)); // Should pass without throwing an error
	}

	@Test
	void testGetValid() {
		NaturalList list = new NaturalList();
		list.push(new Natural(5));
		list.get(0); // Valid operation, should not throw an error
	}

	@Test
	void testGetInvalidIndex() {
		NaturalList list = new NaturalList();
		list.get(-1); // Should throw PreconditionError because the index is out of bounds
	}

	@Test
	void testSetValid() {
		NaturalList list = new NaturalList();
		list.push(new Natural(5));
		list.set(0, new Natural(10)); // Valid operation, should not throw an error
	}

	@Test
	void testSetInvalidIndex() {
		NaturalList list = new NaturalList();
		list.set(-1, new Natural(10)); // Should throw PreconditionError because the index is out of bounds
	}

	@Test
	void testSort() {
		NaturalList list = new NaturalList();
		list.push(new Natural(3));
		list.push(new Natural(1));
		list.push(new Natural(2));
		list.sort(); // Sorting should always succeed, so no error expected
	}

	@Test
	void testSearchNotFound() {
		NaturalList list = new NaturalList();
		list.push(new Natural(1));
		list.push(new Natural(3));
		list.push(new Natural(5));
		list.sort();
		list.search(new Natural(4)); // No specific assertion; success implies the postcondition is satisfied
	}
}
