package estraz_norm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import estraz_norm.Sistema.AppStore;

/**
 * Test di UC1
 */
public class TestFunAggiuntaCredenziali {

	private Sistema s;
	
	@Before
	public void setUp() {
		s = new Sistema();
	}
	
	@Test
	public void testApple() {
		boolean res = s.aggiuntaCredenziali(AppStore.APPLESTORE, "a@b.com", "password");
		
		assertEquals(true, res);
	}
	
	@Test
	public void testGoogle() {
		boolean res = s.aggiuntaCredenziali(AppStore.GOOGLESTORE, "a@b.com", "password");
		
		assertEquals(true, res);
	}
	
	@Test
	public void testWin() {
		boolean res = s.aggiuntaCredenziali(AppStore.WINSTORE, "a@b.com", "password");
		
		assertEquals(true, res);
	}
	
	@Test
	public void testAppleTwice() {
		s.aggiuntaCredenziali(AppStore.APPLESTORE, "a@b.com", "password");
		boolean res = s.aggiuntaCredenziali(AppStore.APPLESTORE, "a@b.com", "password");
		
		assertEquals(false, res);
	}
	
	@Test
	public void testGoogleTwice() {
		s.aggiuntaCredenziali(AppStore.GOOGLESTORE, "a@b.com", "password");
		boolean res = s.aggiuntaCredenziali(AppStore.GOOGLESTORE, "a@b.com", "password");
		
		assertEquals(false, res);
	}
	
	@Test
	public void testWinTwice() {
		s.aggiuntaCredenziali(AppStore.WINSTORE, "a@b.com", "password");
		boolean res = s.aggiuntaCredenziali(AppStore.WINSTORE, "a@b.com", "password");
		
		assertEquals(false, res);
	}
	
	@Test
	public void testAppleWrongCred() {
		boolean res = s.aggiuntaCredenziali(AppStore.APPLESTORE, "a@b.com", "wrongpw");
		
		assertEquals(false, res);
	}
	
	@Test
	public void testGoogleWrongCred() {
		boolean res = s.aggiuntaCredenziali(AppStore.GOOGLESTORE, "a@b.com", "wrongpw");
		
		assertEquals(false, res);
	}
	
	@Test
	public void testWinWrongCred() {
		boolean res = s.aggiuntaCredenziali(AppStore.WINSTORE, "a@b.com", "wrongpw");
		
		assertEquals(false, res);
	}
}
