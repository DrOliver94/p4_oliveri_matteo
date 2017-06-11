package estraz_norm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import estraz_norm.Sistema.AppStore;

/**
 * Test di UC10
 */
public class TestFunCancellaCredenziali {

	private Sistema s;
	
	@Before
	public void setUp() {
		s = new Sistema();
	}
	
	
	@Test
	public void testApple() {
		s.aggiuntaCredenziali(AppStore.APPLESTORE, "a@b.com", "password");
		s.inserimentoApp(AppStore.APPLESTORE);
		s.inserimentoApp(AppStore.APPLESTORE);
		
		boolean res = s.cancellazioneCredenziali(AppStore.APPLESTORE);
		
		assertEquals(true, res);
	}
	
	@Test
	public void testGoogle() {
		s.aggiuntaCredenziali(AppStore.GOOGLESTORE, "a@b.com", "password");
		s.inserimentoApp(AppStore.GOOGLESTORE);
		s.inserimentoApp(AppStore.GOOGLESTORE);
		
		boolean res = s.cancellazioneCredenziali(AppStore.GOOGLESTORE);
		
		assertEquals(true, res);
	}

	@Test
	public void testWin() {
		s.aggiuntaCredenziali(AppStore.WINSTORE, "a@b.com", "password");
		s.inserimentoApp(AppStore.WINSTORE);
		s.inserimentoApp(AppStore.WINSTORE);
		
		boolean res = s.cancellazioneCredenziali(AppStore.WINSTORE);
		
		assertEquals(true, res);
	}
	
	@Test
	public void testWrong() {
		boolean res = s.cancellazioneCredenziali(AppStore.GOOGLESTORE);
		
		assertEquals(false, res);
	}
}
