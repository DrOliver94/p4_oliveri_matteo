package estraz_norm;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe per la definizione del Sistema
 */
public class Sistema { 
    /** Associazioni */
	//private ElementAppStore listAppStore;
	private AppleStore appleStore;
	private GoogleStore googleStore;
	private WinStore winStore;
    
	private ArrayList<App> apps;
    private ArrayList<Gruppo> gruppi;
    
    private Scanner scan;
    
    /** Identifica nel Sistema i tipi di store gestiti */
    public static enum AppStore {GOOGLESTORE, APPLESTORE, WINSTORE};
    
    public Sistema() {
    	scan = new Scanner(new InputStreamReader(System.in));
    	
    	apps = new ArrayList<>();
    	gruppi = new ArrayList<>();
	}
    
    public static void main(String[] args) {
    	Sistema sistema = new Sistema();
    	
    	App a = new App(1, "MyApp1", new GoogleStore());
    	Gruppo g = new Gruppo(1, "MyGroup1");
    	g.getListApp().add(a);

    	sistema.mainLoop();
    }
    
    /**
     * Loop del menu principale del sistema
     */
    public void mainLoop() {
    	while(true) {
    		System.out.println("");
    		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
	    	System.out.println(" Sistema di aggregazione dati da App Store");
	    	System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
	    	System.out.println("1. Aggiungere un App Store");
	    	System.out.println("2. Rimuovere un App Store");
	    	System.out.println("3. Aggiungere una App");
	    	System.out.println("4. Estrarre e normalizzare i dati di una App");
	    	System.out.println("5. Lista app");
	    	System.out.println("");
	    	System.out.println("9. Esci");
	    	System.out.print("Scelta: ");
	    	int choice = scan.nextInt();
	    	scan.nextLine();	//Esaurisce \n
	    	
	    	switch(choice) {
	    	case 1:
	    		switchAddCredenziali();
	    		break;
	    	case 2:
	    		switchRemoveCredenziali();
	    		break;
	    	case 3:
	    		switchAddApp();
	    		break;
	    	case 4:
	    		switchVisualizzaDati();
	    		break;
	    	case 5:
	    		switchListApps();
	    		break;
	    	case 9:
	    		return;
	    	default:
	    		System.out.println("Scelta errata");
	    		break;
	    	}
    	}
    	
//    	scan.close();
    }
    
    
    /**
     * CLI per inserire una nuova applicazione nel Sistema
     */
    private void switchAddApp() {
    	System.out.print("Inserire App Store (Google, Apple, Win): ");
    	String asName = scan.nextLine();
    	switch(asName){
    	case "Apple":
    		inserimentoApp(AppStore.APPLESTORE);
			break;
    	case "Google":
    		inserimentoApp(AppStore.GOOGLESTORE);
    		break;
    	case "Win":
    		inserimentoApp(AppStore.WINSTORE);
    		break;
		default:
			System.out.print("Scelta errata");
			break;
    	}
	}

	/**
	 * CLI per aggiungere le credenziali di un AppStore <p>
	 * Implementa l'UC1
	 */
	public void switchAddCredenziali() {
		AppStore as = null;
		String user = null;
		String pass = null;
		
		boolean flag = false;
		do {
    		System.out.print("Inserire App Store (Google, Apple, Win): ");
	    	String asName = scan.nextLine();
	    	
	    	switch(asName){
	    	case "Apple":
    			as = AppStore.APPLESTORE;
    			break;
	    	case "Google":
	    		as = AppStore.GOOGLESTORE;
	    		break;
	    	case "Win":
	    		as = AppStore.WINSTORE;
	    		break;
    		default:
    			System.out.println("Scelta errata");
    			return;
	    	}
    		
	    	System.out.print("Inserire Username: ");
	    	user = scan.nextLine();
	    	
	    	System.out.print("Inserire Password: ");
	    	pass = scan.nextLine();
	    	
	    	if(aggiuntaCredenziali(as, user, pass)) {
	    		//Credenziali corrette
	    		System.out.println("Credenziali inserite correttamente");
	    		flag = true;
	    	} else {	//credenziali non corrette
	    		System.out.println("Credenziali non corrette");
		    	System.out.print("Vuoi annullare? (y/n): ");
		    	String exit = scan.nextLine();
		    	if(exit.equals("y")) {
		    		flag = true;
		    	}
	    	}
		} while(!flag);
    }
    
	/**
	 * CLI per l'eliminazione delle credenziali di un App Store
	 * Implementa l'UC10
	 */
	private void switchRemoveCredenziali() {
		System.out.println("Elenco App Store collegati:");
		boolean isAppStorePresent = false;
		if(appleStore != null) {
			System.out.println("1. AppleStore");
			isAppStorePresent = true;
		}
		if(googleStore != null) {
			System.out.println("2. GoogleStore");
			isAppStorePresent = true;
		}
		if(winStore != null) {
			System.out.println("3. WinStore");
			isAppStorePresent = true;
		}
		if(!isAppStorePresent) {
			System.out.println("Nessuno store presente nel sistema");
			return;
		}
		
		System.out.print("Scelta: ");
    	int choice = scan.nextInt();
    	scan.nextLine();	//Esaurisce \n
		
    	AppStore chosenAppStore = null;
    	switch(choice) {
    	case 1:
    		chosenAppStore = AppStore.APPLESTORE;
    		break;
    	case 2:
    		chosenAppStore = AppStore.GOOGLESTORE;
    		break;
    	case 3:apps.get(0).visualizzazioneDati();
    		chosenAppStore = AppStore.WINSTORE;
    		break;
    	default:
    		System.out.println("Scelta errata");
    		return;
    	}
    	
    	if(cancellazioneCredenziali(chosenAppStore)) {
    		System.out.println("Store eliminato");
    	}
    	
	}
	
	
	/**
	 * CLI per visualizzare i dati di un'App scelta
	 */
	private void switchVisualizzaDati() {
		//Stampa lista numerata delle app presenti nel sistema
		for(int i = 0; i<apps.size(); i++) {
			System.out.println((i+1) + ". " + apps.get(i).getNomeApp() + "(" + apps.get(i).getAppStore() + ")");
		}
		
		System.out.print("Scelta: ");
    	int choice = scan.nextInt();
    	scan.nextLine();	//Esaurisce \n
		
    	//Se la scelta è valida, mostra i dati di quell'app
		if(choice > 0 && choice<=apps.size()) {
			apps.get(choice-1).visualizzazioneDati();
		}

	}
	
	
	/**
	 * CLI per ottenere la lista delle App nel Sistema
	 */
	public void switchListApps() {
		for(App a:apps) {
			System.out.println("App: " + a.getAppStore() + " " + a.getNomeApp());
		}
	}
	
    
    /**
     * Tenta il login a uno store e in caso positivo memorizza le credenziali
     *
     * @param appStore Store a cui accedere
     * @param user username per l'accesso
     * @param password password per l'accesso
     *
     * @return <b>true</b> se le credenziali sono state inserite correttamente e salvate
     * 				nel sistema<p>
     * 			<b>false</b> altrimenti
     */
    public boolean aggiuntaCredenziali(AppStore appStore, String user, String password) {
    	ElementAppStore as = null;
    	
    	Credenziali c = new Credenziali(user, password);
    	
    	switch(appStore) {
    	case APPLESTORE:
    		as = new AppleStore();
    		break;
    	case GOOGLESTORE:
    		as = new GoogleStore();
    		break;
    	case WINSTORE:
    		as = new WinStore();
    		break;
		default:
			return false;
    	}
    	
    	//Verifica le credenziali
    	boolean result = (boolean)as.accept(new Accesso(c, this));
    	
    	//Comunica esito dell'evento
    	return result;
    }
    
    
    /**
     * Funzione per inserire App nel Sistema
     * 
     * @param selStore Store da cui inserire l'App
     */
    public void inserimentoApp(AppStore selStore) {
    	ElementAppStore appStore = null;
    	switch(selStore) {
    	case APPLESTORE:
    		appStore = appleStore;
    		break;
    	case GOOGLESTORE:
    		appStore = googleStore;
    		break;
    	case WINSTORE:
    		appStore = winStore;
    		break;
		default:
			return;
    	}
    	
    	if(appStore == null) {
    		System.out.println("AppStore non presente");
    		return;
    	}
    	
    	//Creazione mock app
    	App a = new App(apps.size()+1, "MyApp" + (apps.size()+1), appStore);
    	apps.add(a);
    	System.out.println("App aggiunta");
    }
    
    
    /**
     * Elimina una App dal Sistema
     */
    public void cancellazioneApp() { }
    
    
    /**
     * Crea un nuovo Gruppo nel Sistema
     *
     */
    public void creazioneGruppo() { }
    
    
    /**
     * Elimina un Gruppo dal Sistema
     *
     */
    public void cancellazioneGruppo() { }
    
    
    /**
     * Funzione per cancellare le credenziali di un'AppStore 
     *
     * @param choice AppStore di cui cancellare le credenziali
     * @return true se è andata a buon fine, false altrimenti
     */
    public boolean cancellazioneCredenziali(AppStore choice) {
    	//Selezione dello store da cancellare
    	ElementAppStore deletingStore = null;
    	switch(choice) {
    	case APPLESTORE:
    		deletingStore = appleStore;
    		appleStore = null;
    		break;
    	case GOOGLESTORE:
    		deletingStore = googleStore;
    		googleStore = null;
    		break;
    	case WINSTORE:
    		deletingStore = winStore;
    		winStore = null;
    		break;
    	default:
    		System.out.println("Scelta errata");
    		return false;
    	}
    	
    	//Se è stato scelto erroneamente uno store vuoto
    	if(deletingStore == null) {	
    		System.out.println("Scelta errata");
    		return false;
    	}
    	
    	//Ricerca ed eliminazione di ogni app legata all'AppStore da cancellare
    	ArrayList<Integer> removingApps = new ArrayList<>();
    	for(App a:apps) {
    		if(a.getAppStore().equals(deletingStore)) {
//    			apps.remove(a);
    			removingApps.add(apps.indexOf(a));
    		}
    	}
    	for(Integer i:removingApps) {
    		System.out.println("Elimino app " + i);
    		apps.remove(i);
    	}
    	
    	return true;
    }
    
    
    /**
     * Modifica le credenziali di un AppStore presente nel Sistema
     */
    public void modificaCredenziali() { }
    
    
    /**
     * Aggiunge una App a un Gruppo
     */
    public void aggiuntaAppGruppo() { }
    
    
    /**
     * Elimina una App da un Gruppo
     */
    public void cancellazioneAppGruppo() { }
    
	public GoogleStore getGoogleStore() {
		return googleStore;
	}

	public void setGoogleStore(GoogleStore googleStore) {
		this.googleStore = googleStore;
	}

	public AppleStore getAppleStore() {
		return appleStore;
	}

	public void setAppleStore(AppleStore appleStore) {
		this.appleStore = appleStore;
	}

	public WinStore getWinStore() {
		return winStore;
	}

	public void setWinStore(WinStore winStore) {
		this.winStore = winStore;
	}
	
}