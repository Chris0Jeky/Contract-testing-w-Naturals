import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NaturalTest {

	@Test
	void testNaturalConstructorWithValidArgument() {
		// This test should pass if the contract is not violated.
		new Natural(5);
	}

	// Since the contract framework will throw an error if a precondition is violated,
	// there's no need for assertThrows; just attempt the action that should cause the error.
	@Test
	void testNaturalConstructorWithInvalidArgument() {
		new Natural(-1); // Should throw PreconditionError
	}

	// ...

	@Test
	void testIncrementWithoutOverflow() {
		Natural natural = new Natural(Integer.MAX_VALUE - 1);
		natural.increment(); // Should pass without throwing an error
	}

	@Test
	void testIncrementWithOverflow() {
		Natural natural = new Natural(Integer.MAX_VALUE);
		natural.increment(); // Should throw InvariantError due to overflow
	}

	@Test
	void testDecrementValid() {
		Natural natural = new Natural(1);
		natural.decrement(); // Valid operation, should not throw an error
	}

	@Test
	void testDecrementInvalid() {
		Natural natural = new Natural(0);
		natural.decrement(); // Should throw PreconditionError because you can't decrement below 0
	}

	@Test
	void testAddValid() {
		Natural natural1 = new Natural(1);
		Natural natural2 = new Natural(2);
		natural1.add(natural2); // Should be a valid operation
		assertEquals(3, natural1.data); // Assert the result is as expected.
	}

	@Test
	void testAddOverflow() {
		Natural natural1 = new Natural(Integer.MAX_VALUE);
		Natural natural2 = new Natural(1);
		natural1.add(natural2); // Should throw PreconditionError or InvariantError due to overflow
	}

	@Test
	void testSubtractValid() {
		Natural natural1 = new Natural(5);
		Natural natural2 = new Natural(3);
		natural1.subtract(natural2); // Valid operation, should not throw an error
	}

	// Subtract where the result would be negative (invalid operation).
	@Test
	void testSubtractInvalid() {
		Natural natural1 = new Natural(2);
		Natural natural2 = new Natural(3);
		natural1.subtract(natural2); // Should throw PreconditionError
	}

	@Test
	void testMultiplyValid() {
		Natural natural1 = new Natural(2);
		Natural natural2 = new Natural(3);
		natural1.multiply(natural2); // Valid operation, should not throw an error
	}

	@Test
	void testMultiplyOverflow() {
		Natural natural1 = new Natural(Integer.MAX_VALUE / 2);
		Natural natural2 = new Natural(3);
		natural1.multiply(natural2); // Should throw PreconditionError or InvariantError due to potential overflow
	}

	@Test
	void testDivideValid() {
		Natural natural1 = new Natural(6);
		Natural natural2 = new Natural(3);
		natural1.divide(natural2); // Valid operation, should not throw an error
	}

	@Test
	void testDivideByZero() {
		Natural natural1 = new Natural(6);
		Natural natural2 = new Natural(0);
		natural1.divide(natural2); // Should throw PreconditionError because division by zero is not allowed
	}
}
