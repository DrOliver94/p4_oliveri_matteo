package estraz_norm;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Lista di DatiElement per la gestione dei dati
 * 
 * @author Matteo Oliveri
 */
public class DatiList extends DatiElement {
	ArrayList<DatiElement> list;
	HashMap<String, Integer> index;	//Per trovare i DatiElement dal nome
	
	
	public DatiList(String name) {
		super(name);
		list = new ArrayList<>();
		index = new HashMap<>();
	}
	
	
	/**
	 * Aggiunge un DatiList a list
	 */
	@Override
	public void add(String name) {
		if(index.get(name) == null) {	//Se key non presente				
			list.add(new DatiList(name));
			index.put(name, list.size()-1);
		}
	}
	
	
	/**
	 * Aggiunge un DatiInteger a list
	 */
	@Override
	public void addInt(String name, int value) {
		list.add(new DatiInteger(name, value));
		index.put(name, list.size()-1);
	}
	
	
	/**
	 * Aggiunge un DatiDouble a list
	 */
	@Override
	public void addDouble(String name, double value) {
		list.add(new DatiDouble(name, value));
		index.put(name, list.size()-1);
	}

	
	/**
	 * Ottiene un DatiElement a partire dal nome
	 */
	@Override
	public DatiElement get(String name) {
		if(index.get(name) != null) {
			return list.get(index.get(name));
		}
		return new DatiElement("");
	}
	
	
	/**
	 * Stampa ricorsivamente tutti i DatiElement presenti in list.
	 * Se richiamata per la prima volta, passare 0 come level, o richiamarla
	 * 		senza parametro.
	 */
	@Override
	public void printRecursive(int level) {
		for(int i=0; i<level; i++) {
			System.out.print("\t");			
		}
		System.out.println(name);
		for(DatiElement e : list) {
			e.printRecursive(level+1);
		}
	}
	
	
}