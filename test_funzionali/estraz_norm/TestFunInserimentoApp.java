package estraz_norm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import estraz_norm.Sistema.AppStore;

public class TestFunInserimentoApp {

	private Sistema s;
	
	@Before
	public void init() {
		s = new Sistema();
	}
	
	@Test
	public void testInserimentoApple() {
		int lastDim = s.getApps().size();
	
		s.setAppleStore(new AppleStore());
		
		s.inserimentoApp(AppStore.APPLESTORE);
		
		assertEquals(lastDim+1, s.getApps().size());
	}
	
	@Test
	public void testInserimentoGoogle() {
		int lastDim = s.getApps().size();
	
		s.setGoogleStore(new GoogleStore());
		
		s.inserimentoApp(AppStore.GOOGLESTORE);
		
		assertEquals(lastDim+1, s.getApps().size());
	}
	
	@Test
	public void testInserimentoWin() {
		int lastDim = s.getApps().size();
	
		s.setWinStore(new WinStore());
		
		s.inserimentoApp(AppStore.WINSTORE);
		
		assertEquals(lastDim+1, s.getApps().size());
	}
	
	@Test
	public void testInserimentoNoStore() {
		int lastDim = s.getApps().size();
	
		s.inserimentoApp(AppStore.APPLESTORE);
		
		assertEquals(lastDim, s.getApps().size());
	}

}
