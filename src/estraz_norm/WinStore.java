package estraz_norm;

import java.io.File;
import java.util.ArrayList;

/**
 * App Store specifico per la connessione allo Store di Microsoft
 */
public class WinStore implements ElementAppStore {
    /** Attributi */
    private Credenziali credenziali;
    
    
    /**
     * Consente la visita da parte di un oggetto che implementi l'interfaccia Visitor
     *
     * @param v Il Visitor
     */
    public Object accept(Visitor v) {
    	return v.visit(this);
    }
    
    
    /**
     * Estrae i dati dall'App Store e li salva in File
     *
     * @param app L'App di cui estrarre i dati
     * @return Il file contenente i dati estratti 
     */
    @Override
    public ArrayList<File> estrazioneDati(App app) {
    	StoreServerMock storeServer = new StoreServerMock();
    	
    	return storeServer.getInstallData();
    }
    
    
    /**
     * Verifica la correttezza delle credenziali dell'App Store
     *
     * @param c Le credenziali per accedere
     * @return true se è andata a buon fine, false altrimenti
     */
    @Override
    public boolean accesso(Credenziali c) {
    	StoreServerMock storeServer = new StoreServerMock();
    	
    	//Se va tutto a buon fine
    	if(storeServer.checkCredenziali(c.getUsername(), c.getPassword())) {
    		credenziali = c;
    		return true;
    	}

    	//Altrimenti	
    	return false;
    }
    
    
    /**
     * Ottiene la lista delle App dell'utente presenti sullo Store
     *
     * @return La lista delle App dell'utente presenti sul WinStore
     */
    @Override
    public ArrayList<App> getListaApp() {
    	return null; 
    }

    
    @Override
    public String toString() {
    	return "WinStore";
    }
    
}