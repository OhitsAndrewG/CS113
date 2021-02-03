package powerOfTwo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PowerOfTwoTest {

	@Test
	void test() {
		PowerOfTwo Test = new PowerOfTwo();
		
		boolean output = Test.powerOfTwo(10);
		
		assertEquals(true, output);
	}

}
