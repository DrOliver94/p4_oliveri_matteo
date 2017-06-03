package estraz_norm;
/**
 * Effettua il primo accesso a un AppStore e ne salva le credenziali nel 
 * rispettivo oggetto
 */
public class Accesso implements Visitor { 
    
	private Credenziali credenziali;
	private Sistema sistema;	//Per mantenere riferimento al sistema
	
	public Accesso(Credenziali c, Sistema s) {
		super();
		credenziali = c;
		sistema = s;
	}
	
	
	/**
	 * Visita di un AppleStore
	 *
	 * @param apple AppStore specifico
	 */
	@Override
	public Object visit(AppleStore apple) {
		System.out.println("Accesso in corso...");
		
		if(sistema.getAppleStore() != null) {
			System.out.println("Store gia' presente");
			return false;
		}
		
		if(apple.accesso(credenziali)) {
			//Accesso effettuato con successo
			sistema.setAppleStore(apple);
			return true;
		}
		
		//Accesso fallito
		return false;
	}

	
	/**
     * Visita di un GoogleStore
     *
     * @param google AppStore specifico
     */
	@Override
    public Object visit(GoogleStore google) {
    	System.out.println("Accesso in corso...");
    	
    	if(sistema.getGoogleStore() != null) {
			System.out.println("Store gia' presente");
			return false;
		}
    	
    	if(google.accesso(credenziali)) {
    		//Accesso effettuato con successo
    		sistema.setGoogleStore(google);
    		return true;
    	}
    	
    	//Accesso fallito
    	return false;
    }
    
        
    /**
     * Visita di un WinStore
     *
     * @param win AppStore specifico
     */
	@Override
    public Object visit(WinStore win) {
    	System.out.println("Accesso in corso...");
    	
    	if(sistema.getWinStore() != null) {
			System.out.println("Store gia' presente");
			return false;
		}
    	
    	if(win.accesso(credenziali)) {
    		//Accesso effettuato con successo
    		sistema.setWinStore(win);
    		return true;
    	}
    	
    	//Accesso fallito
    	return false;
    }
    
}