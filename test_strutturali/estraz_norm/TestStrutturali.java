package estraz_norm;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	TestStrAccesso.class,
	TestStrApp.class,
	TestStrGruppo.class,
	TestStrSistema.class,
	TestStrDati.class
})

public class TestStrutturali { }

/**
 * La Test Suite non ha copertura del 100%
 * poiché non sono stati testati i metodi
 * che implementano l'interfaccia a riga di comando,
 * alcuni metodi getter e setter, e alcuni metodi
 * che non sono stati implementati non essendo
 * necessari agli Use Case di questa implementazione
 * del sistema
 */