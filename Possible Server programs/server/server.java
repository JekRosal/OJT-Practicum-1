
import javax.xml.ws.Endpoint;
import game.*;

public class server {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/game/mygame",new CardGame());
    }
}