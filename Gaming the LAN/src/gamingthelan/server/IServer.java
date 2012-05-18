package gamingthelan.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IConnection;
import gamingthelan.netutils.IPacket;

/** This is the generic server interface
 * **/


public interface IServer {
	
	/**create a connection from a socket and a valid handler and then add it to Server's list 
	 * 
	 * @param socket socket connection initiation
	 * @param handler handler which handles packets 
	 *  
	 *  **/
	
	public void createConnection(Socket socket, ConnectionHandler handler);
	
	/**add a just created connection to the server connection list
	 * @param connessione target client connection 
	 * 
	 * **/
	
	public void addConnection(IConnection connessione);
	
	/**remove a connection from the Server's List
	 * @param connessione target client connection 
	 * 
	 * **/
	
	public void rmConnection(IConnection connessione); //FIXME : Funziona, ma chi lo chiama ? forse è il caso di introdurre anche per qusto metodo l'Id di cui parlavo.
	
	/**Send a packet to every connected client
	 *@param pacchetto packet to send to every connected client 
	 *
	 * **/
	public void broadcastMessage(IPacket pacchetto) throws IOException;
	
	/**Send a packet to target connection
	 * 
	 * @param pacchetto packet to send to target connection
	 * @param connessione target client connection
	 * 
	 * **/
	public void sendMessage(IPacket pacchetto); //FIXME : Praticamente inutilizzabile dal momento che la singola connection che dovrebbe usarlo nono ha nessun riferimento alla connessione target. Bisogna inventare qualcosa (un ID magari) per identificare una connessione senza tirarci dierteo tutto l'oggetto (che tra parentesi ha poco senso trasmettere, e non è serializzabile)
	
	/**add to the bannned list target address and close his connection
	 * 
	 * @param address internet address of target connection
	 * 
	 * **/ 
	public boolean ban(InetAddress address);
	
	/**remove an address from the banned list
	 * 
	 * @param address internet address of target connection
	 * **/
	public boolean unban(InetAddress address);
	
	
}