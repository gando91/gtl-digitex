package gamingthelan.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import gamingthelan.netutils.ConnectionHandler;
import gamingthelan.netutils.IConnection;
import gamingthelan.netutils.IPacket;

/**  Generic server interface
 * **/


public interface IServer extends Runnable {
	
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
	 * @param connection target client connection 
	 * 
	 * **/
	
	public void rmConnection(IConnection connessione); //FIXME : Funziona, ma chi lo chiama ? forse è il caso di introdurre anche per qusto metodo l'Id di cui parlavo.
	
	/**Send a packet to every connected client
	 *@param packet packet to send to every connected client 
	 *
	 * **/
	public void broadcastMessage(IPacket pacchetto) throws IOException;
	
	/**Send a packet to target connection
	 * 
	 * @param packet packet to send to target connection
	 * @param connection target client connection
	 * 
	 * **/
	public void sendMessage(IPacket pacchetto);
	
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
	
	public void wakeUp();
}