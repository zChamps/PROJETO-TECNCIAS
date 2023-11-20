//Item 3 (TROCAR ESSA CLASSE PELA SUA)
public class AviaoAnimado extends ImagemAnimada {

	private Thread t = new Thread(this);
	
	public AviaoAnimado() {
		t.start();
	}
	
	@Override
	public void run() {
		 while(true) {
			
			 this.setX(this.getX() + 10);
			 try {
				 Thread.sleep(80);
			 } catch (InterruptedException e) {
				 e.printStackTrace();
			 }
		  }
	}
	
}
