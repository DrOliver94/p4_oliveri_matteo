package estraz_norm;

/**
 * Generico elemento di gestione dei dati nella classe Dati
 * 
 * @author Matteo Oliveri
 */
public class DatiElement {
	protected String name;
	
	public DatiElement(String name) {
		this.name = name;
	}
	
	public void add(String name) { }
	public void add(String name, double value) { }
	public void add(String name, int value) { }
	
	public DatiElement get(String name) { return null; }
	public Double getDouble() { return null; }
	public Integer getInt() { return null; }
	
	/**
	 * Stampa ricorsivamente l'albero formato da DatiList e DatiDouble/Integer
	 * 
	 * @param level quante volte indentare la stampa
	 */
	public void printRecursive(int level) {	}
	public void printRecursive() {
		printRecursive(0);
	}
	
	@Override
	public String toString() { return null;	}
}