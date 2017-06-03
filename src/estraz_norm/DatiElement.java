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
	
	public DatiElement get(String name) { return null; }

	public Double getDouble() { return null; }
	public void addDouble(String name, double value) { }
	
	public Integer getInt() { return null; }
	public void addInt(String name, int value) { }
	
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