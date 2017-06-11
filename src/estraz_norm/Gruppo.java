package estraz_norm;
import java.io.File;
import java.util.ArrayList;

/**
 * Definisce un insieme di App su cui poter recuperare informazioni ed aggregarle
 */
public class Gruppo {
    /** Attributi */
    private int id;
    private String nomeGruppo; 
    
    /** Associations */
    private Dati dati;
    private ArrayList<App> listApp; 
    
    
    public Gruppo(int id, String nomeGruppo) {
		this.id = id;
		this.nomeGruppo = nomeGruppo;
		this.listApp = new ArrayList<>();
	}

    
	/**
     * Estra, normalizza, aggrega e mostra i dati del Gruppo
     *
     */
    public void visualizzazioneDati() { }
    
    
    /**
     * Funzione per l'estrazione dei dati di un Gruppo<p>
     * Implementa l'UC12
     *
     * @return true se è andata a buon fine, false se non è andata a buon fine
     */
    public boolean estrazioneDatiGruppo() {
    	for(App a : listApp) {
    		ArrayList<File> f = a.estrazioneDatiApp();
    		a.normalizzazioneDati(f);
    	}
    	
    	return true;
    }
    
    
    /**
     * Aggrega i dati delle App contenute nel Gruppo
     *
     */
    public void aggregazioneDati() { }
    
    
    /**
     * Salva in locale le informazioni contenute nell'oggetto Dati del Gruppo
     *
     * @return Il file contente i dati dell'App
     */
    public File scaricamentoDati() {
    	return null;
    }
    
    public ArrayList<App> getListApp() {
		return listApp;
	}
}