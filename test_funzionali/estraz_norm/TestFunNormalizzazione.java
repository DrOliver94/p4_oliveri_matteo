package estraz_norm;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import estraz_norm.Sistema.AppStore;

/**
 * Test di UC14
 */
@RunWith(Parameterized.class)
public class TestFunNormalizzazione {

	Sistema s;
	private AppStore chosenAppStore;
	
	public TestFunNormalizzazione(AppStore as) {
		chosenAppStore = as;
	}
	
	@Before
	public void setUp() {
		s = new Sistema();
	}
	
	@Parameters
	public static Collection<AppStore> data() {
		return Arrays.asList(new AppStore[]{
			AppStore.APPLESTORE,
			AppStore.GOOGLESTORE,
			AppStore.WINSTORE
		});
	}
	
	@Test
	public void test() {
		s.aggiuntaCredenziali(chosenAppStore, "a@b.com", "password");
		s.inserimentoApp(chosenAppStore);
		App a = s.getApps().get(0);
		ArrayList<File> files = a.estrazioneDatiApp();
		
		a.normalizzazioneDati(files);
		
		assertNotNull(a.getDati());
	}
	
}
