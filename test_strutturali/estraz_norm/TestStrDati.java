package estraz_norm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test per DatiElement, DatiList,
 * 	DatiInteger, DatiDouble
 */
public class TestStrDati {

	private DatiElement d;
	
	@Before
	public void setUp() {
		d = new DatiList("test");
	}
	
	@Test
	public void testAddList() {
		d.add("testList");
		
		assertEquals("testList", d.get("testList").name);
	}
	
	@Test
	public void testAddInt() {
		d.add("testInt", 5);
		
		assertEquals(5, (int)d.get("testInt").getInt());
	}
	
	@Test
	public void testAddDouble() {
		d.add("testDouble", 5.4);
		
		assertEquals(5.4, (double)d.get("testDouble").getDouble(), 0.0);
	}
	
	@Test
	public void testGetWrong() {
		assertNull(d.get("testList"));
	}
	
	@Test
	public void testGetDoubleFromInt() {
		d.add("testInt", 5);
		
		assertEquals(5.0, (double)d.get("testInt").getDouble(), 0.0);
	}

}

