package gamingthelan.netutils.servicepackets;

import gamingthelan.netutils.IPacket;

import java.util.List;

public class NickPacket implements IPacket{
        
        private static final long serialVersionUID = -3646976227473707241L;

        private String sender;
        private List<String> receiver;  
        private String nickname;
        
        public NickPacket(String nickName){
                this.nickname = nickName;
        }
        
        public void setNickName(String nickname){
                this.nickname = nickname;
        }
        
        public String getNickName(){
                return nickname;
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
