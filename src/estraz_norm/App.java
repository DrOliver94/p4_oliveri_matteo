package estraz_norm;

import java.io.File;
import java.util.ArrayList;

/**
 * Classe per la definizione di App
 */
public class App {
    /** Attributi */
    private int id;
    private String nomeApp;
    
    /** Associazioni */
    private Dati dati;
    private ElementAppStore appStore;
    
    
    public App(int id, String nomeApp, ElementAppStore store) {
    	this.id = id;
    	this.nomeApp = nomeApp;
    	this.appStore = store;
	}
    
    /**
     * Estrae, normalizza e visualizza i dati dell'App
     *
     */
    public void visualizzazioneDati() {
    	//Estrazione
    	ArrayList<File> csv = estrazioneDatiApp();
    	
    	//Normalizzazione
    	normalizzazioneDati(csv);
    }
    
    
    /**
     * Si collega allo Store e recupera i dati dell'App
     *
     * @return lista di file relativi all'App
     */
    public ArrayList<File> estrazioneDatiApp() {
    	ArrayList<File> csv = null;
    	
    	Object obj = appStore.accept(new EstrazioneDati(this));
    	if(obj.getClass().equals(ArrayList.class)) {
    		csv = (ArrayList<File>)obj;
    	}
    	
    	return csv;
    }
    
    
    /**
     * Dall'elenco di file ottiene un oggetto Dati comune agli App Store
     * 		supportati dal Sistema
     * 
     * @param csv elenco di File da normalizzare
     */
    public void normalizzazioneDati(ArrayList<File> csv) {
    	dati = (Dati)appStore.accept(new Normalizzazione(this, csv));
    }
    
    
    /**
     * Salva in locale i dati ottenuti dall'App Store
     *
     * @return Il file contente i dati dell'App
     */
    public File scaricamentoDati(){
    	return null;
    }
    
    public Dati getDati() {
		return dati;
	}

    public ElementAppStore getAppStore() {
    	return appStore;
    }

	public int getNomeApp() {
		return 0;
	}
    
    
}