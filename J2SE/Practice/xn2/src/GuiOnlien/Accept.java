package GuiOnlien;
import java.net.Socket;
public class Accept implements Runnable {
	private Socket  socket;
	public Accept(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
