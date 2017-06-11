package estraz_norm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import estraz_norm.Sistema.AppStore;

public class TestStrAccesso {

	private Sistema s;
	
	@Before
	public void setUp() {
		s = new Sistema();
	}
	
	@Test
	public void testAccessoApple() {
		boolean res = s.aggiuntaCredenziali(AppStore.APPLESTORE, "a@b.com", "password");
		
		assertEquals(true, res);
	}
	
	@Test
	public void testAccessoGoogle() {
		boolean res = s.aggiuntaCredenziali(AppStore.GOOGLESTORE, "a@b.com", "password");
		
		assertEquals(true, res);
	}
	
	@Test
	public void testAccessoWin() {
		boolean res = s.aggiuntaCredenziali(AppStore.WINSTORE, "a@b.com", "password");
		
		assertEquals(true, res);
	}
	
	@Test
	public void testAccessoApplePresent() {
		s.aggiuntaCredenziali(AppStore.APPLESTORE, "a@b.com", "password");
		boolean res = s.aggiuntaCredenziali(AppStore.APPLESTORE, "a@b.com", "password");
		assertEquals(false, res);
	}
	
	@Test
	public void testAccessoGooglePresent() {
		s.aggiuntaCredenziali(AppStore.GOOGLESTORE, "a@b.com", "password");
		boolean res = s.aggiuntaCredenziali(AppStore.GOOGLESTORE, "a@b.com", "password");
		
		assertEquals(false, res);
	}
	
	@Test
	public void testAccessoWinPresent() {
		s.aggiuntaCredenziali(AppStore.WINSTORE, "a@b.com", "password");
		boolean res = s.aggiuntaCredenziali(AppStore.WINSTORE, "a@b.com", "password");
		
		assertEquals(false, res);
	}
	
	@Test
	public void testWrongCredApple() {
		boolean res = s.aggiuntaCredenziali(AppStore.APPLESTORE, "a@b.com", "wrongpw");
		
		assertEquals(false, res);
	}

	@Test
	public void testWrongCredGoogle() {
		boolean res = s.aggiuntaCredenziali(AppStore.GOOGLESTORE, "a@b.com", "wrongpw");
		
		assertEquals(false, res);
	}
	
	@Test
	public void testWrongCredWin() {
		boolean res = s.aggiuntaCredenziali(AppStore.WINSTORE, "a@b.com", "wrongpw");
		
		assertEquals(false, res);
	}
	
}
