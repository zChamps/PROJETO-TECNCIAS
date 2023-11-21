//Item 3 (TROCAR ESSA CLASSE PELA SUA)
public class Fruta extends ImagemAnimada {

	private Thread t = new Thread(this);

  // criar uma variavel que caso seja par ou impar, ela vai colocar a fruta em um lugar diferente, dai só acrescer mais 1 após o if ali de baixo ser aplicado
	
	public Fruta() {
		t.start();
	}
	
	@Override
	public void run() {

        while(true) {
          while(true) {
            if (this.getX() > 1100){
                this.setX(this.getImg().getWidth() - 75);
                this.setY(this.getImg().getHeight() + 200);
                
                // System.out.println("em cima");
            } else {
                this.setX(this.getX() + 5);
                System.out.println(this.getX());
            }

            try{
                Thread.sleep(5);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
          }
        }
      }
	
}
