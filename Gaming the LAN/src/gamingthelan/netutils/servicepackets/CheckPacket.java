package gamingthelan.netutils.servicepackets;

import gamingthelan.netutils.IPacket;

import java.util.LinkedList;
import java.util.List;

public class CheckPacket implements IPacket {


        private static final long serialVersionUID = 6025429055443141782L;
        
        private String sender;
        private List<String> receiver;
        
        public CheckPacket(String sender, String receiver) {
                
                this.receiver = new LinkedList<String>();
                this.receiver.add(receiver);
                
                this.sender = sender;
                
        }
        
        @Override
        public List<String> getReceiver() {
                return receiver;
        }

        @Override
        public String getSender() {
                return sender;
        }

}
