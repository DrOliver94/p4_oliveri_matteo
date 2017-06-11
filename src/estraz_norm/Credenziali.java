package estraz_norm;

/**
 * Memorizza le credenziali necessarie per l'autenticazione a un AppStore
 */
public class Credenziali {
	/** Attributi */
    private String username;
    private String password;
	
    
    /**
     * Crea un oggetto Credenziali impostando username e password
     * @param username nome utente di un account sviluppatore di un AppStore
     * @param password password dell'account sviluppatore di un AppStore
     */
    public Credenziali(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
    
    
    public String getUsername() {
    	return username;
    }
    
    
    public String getPassword() {
    	return password;
    }
    
}