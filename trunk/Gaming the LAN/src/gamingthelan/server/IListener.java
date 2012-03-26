package gamingthelan.server;

public interface IListener {
	
	/**
	 * Crea una nuova partita
	 * @param porta La porta su cui mettere in ascolto il server
	 */
	public void creaPartita(int porta);
	
}