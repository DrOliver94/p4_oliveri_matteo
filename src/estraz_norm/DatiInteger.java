package estraz_norm;

/**
 * Coppia chiave-valore con valore di tipo int.
 * Inseribile in un DatiList
 * 
 * @author Matteo Oliveri
 */
public class DatiInteger extends DatiElement {
	private int value;
	
	public DatiInteger(String name, int data) {
		super(name);
		this.value = data;
	}
	
	/**
	 * Ottiene il valore intero
	 */
	@Override
	public Integer getInt() {
		return value;
	}
	
	/**
	 * Ottiene il valore come double
	 */
	@Override
	public Double getDouble() {
		return ((double)value);
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

	@Override
	public String toString() {
		return Integer.toString(value);
	}
	
}
