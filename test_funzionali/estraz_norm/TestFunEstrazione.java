package estraz_norm;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import estraz_norm.Sistema.AppStore;

/**7
 * Test di UC12
 */
public class TestFunEstrazione {

	Sistema s;
	
	@Before
	public void setUp() {
		s = new Sistema();
		s.aggiuntaCredenziali(AppStore.APPLESTORE, "a@b.com", "password");
		s.aggiuntaCredenziali(AppStore.GOOGLESTORE, "a@b.com", "password");
		s.aggiuntaCredenziali(AppStore.WINSTORE, "a@b.com", "password");
	}
	
	@Test
	public void testApple() {
		s.inserimentoApp(AppStore.APPLESTORE);
		ArrayList<File> files = s.getApps().get(0).estrazioneDatiApp();
		
		assertEquals(6, files.size());
	}
	
	@Test
	public void testGoogle() {
		s.inserimentoApp(AppStore.GOOGLESTORE);
		ArrayList<File> files = s.getApps().get(0).estrazioneDatiApp();
		
		assertEquals(6, files.size());
	}
	
	@Test
	public void testWin() {
		s.inserimentoApp(AppStore.WINSTORE);
		ArrayList<File> files = s.getApps().get(0).estrazioneDatiApp();
		
		assertEquals(6, files.size());
	}

	
}

