package estraz_norm;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.*;
import org.junit.runners.Parameterized.Parameters;

import estraz_norm.Sistema.AppStore;

@RunWith(Parameterized.class)
public class TestStrApp {

	private Sistema s;
	private AppStore chosenAppStore;
	
	public TestStrApp(AppStore as) {
		chosenAppStore = as;
	}
	
	@Parameters
	public static Collection<AppStore> data() {
		return Arrays.asList(new AppStore[]{
			AppStore.APPLESTORE,
			AppStore.GOOGLESTORE,
			AppStore.WINSTORE
		});
	}

	@Before
	public void setUp() {
		s = new Sistema();
	}
	
	@Test
	public void testVisual() {
		s.aggiuntaCredenziali(chosenAppStore, "a@b.com", "password");
		s.inserimentoApp(chosenAppStore);
		App a = s.getApps().get(0);
		
		a.visualizzazioneDati();
		
    	assertNotNull(a.getDati());
	}
}
