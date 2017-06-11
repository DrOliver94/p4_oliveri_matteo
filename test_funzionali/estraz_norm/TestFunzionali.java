package estraz_norm;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	TestFunInserimentoApp.class,
	TestFunAggiuntaCredenziali.class,
	TestFunCancellaCredenziali.class,
	TestFunEstrazione.class,
	TestFunNormalizzazione.class
})

public class TestFunzionali { }

/**
 * La Test Suite dei test funzionali garantisce:
 * - uno statement coverage del 80,2%
 * - un branch coverage del 67,8%
 */
