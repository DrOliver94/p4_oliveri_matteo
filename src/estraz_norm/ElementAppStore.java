package estraz_norm;

import java.io.File;
import java.util.ArrayList;

/**
 * Definisce un generico App Store visitabile dalle classi che implementano Visitor
 */
public interface ElementAppStore {
	/**
     * Consente la visita da parte di un oggetto che implementi l'interfaccia Visitor
     *
     * @param v Il Visitor
     */
    public Object accept(Visitor v);
    
    
    /**
     * Estrae i dati dall'App Store e li salva in File
     *
     * @param app L'App di cui estrarre i dati
     * @return Il file contenente i dati estratti 
     */
    public ArrayList<File> estrazioneDati(App app);
    
    
    /**
     * Verifica la correttezza delle credenziali dell'App Store
     *
     * @param c Le credenziali per accedere
     * @return true se è andata a buon fine, false se non è andata a buon fine
     */
    public boolean accesso(Credenziali c);
    
    
    /**
     * Ottiene la lista delle App dell'utente presenti sullo Store
     *
     * @return La lista delle App dell'utente presenti sull'AppleStore
     */
    public ArrayList<App> getListaApp();

}