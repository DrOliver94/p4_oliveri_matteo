package estraz_norm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import estraz_norm.Sistema.AppStore;

public class TestStrGruppo {

	private Sistema s;
	
	@Before
	public void setUp() {
		s = new Sistema();
		s.aggiuntaCredenziali(AppStore.APPLESTORE, "a@b.com", "password");
	}
	
	@Test
	public void testEstrazioneGruppo() {
		s.inserimentoApp(AppStore.APPLESTORE);
		App a1 = s.getApps().get(0);
		s.inserimentoApp(AppStore.APPLESTORE);
		App a2 = s.getApps().get(1);
		
		Gruppo g = new Gruppo(1, "Gruppo");
		
		g.getListApp().add(a1);
		g.getListApp().add(a2);
		
		g.estrazioneDatiGruppo();
		
		assertNotNull(a1.getDati());
		assertNotNull(a2.getDati());
		
	}

}
