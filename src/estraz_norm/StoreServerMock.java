package estraz_norm;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Simula un server di un generico App Store
 * 
 * @author Matteo Oliveri
 */
public class StoreServerMock {
	public HashMap<String, String> credenziali;
	
	public StoreServerMock() {
		credenziali = new HashMap<>();
		credenziali.put("a@b.com", "password");
	}
	
	
	/**
	 * Verifica se le credenziali sono presenti nello Store
	 * @param user nome utente
	 * @param password password dell'account
	 * @return true se le credenziali sono corrette <p>
	 * 		   false altrimenti
	 */
	public boolean checkCredenziali(String user, String password) {
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(password.equals(credenziali.get(user))) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Ottieni file derivanti da una certa App
	 */
	public ArrayList<File> getInstallData() {
		ArrayList<File> array = new ArrayList<>();
		
		array.add(new File("./data/installs_com.letfreex_201705_overview.csv"));
		array.add(new File("./data/installs_com.letfreex_201705_app_version.csv"));
		array.add(new File("./data/installs_com.letfreex_201705_country.csv"));
		array.add(new File("./data/ratings_com.letfreex_201705_overview.csv"));
		array.add(new File("./data/ratings_com.letfreex_201705_country.csv"));
		array.add(new File("./data/ratings_com.letfreex_201705_os_version.csv"));
		
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return array;
	}
	
}