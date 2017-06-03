package estraz_norm;

/**
 * Coppia chiave-valore con valore di tipo double.
 * Inseribile in un DatiList
 * 
 * @author Matteo Oliveri
 */
public class DatiDouble extends DatiElement {
	private double value;
	
	public DatiDouble(String name, double data) {
		super(name);
		this.value = data;
	}
	
	
	/**
	 * Ottieni il valore double
	 */
	@Override
	public Double getDouble() {
		return value;
	}
	
	
	@Override
	public void printRecursive() {
		printRecursive(0);
	}
	
	
	/**
	 * Stampa indentando di level volte
	 */
	@Override
	public void printRecursive(int level) {
		for(int i=0; i<level; i++) {
			System.out.print("\t");			
		}
		System.out.println(name + " : " + value);
	}
	
	
	public String toString() {
		return Double.toString(value);
	};
	
}