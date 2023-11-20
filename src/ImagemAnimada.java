public class ImagemAnimada extends ImagemMovida implements Runnable {
    private Thread t = new Thread(this);

    public ImagemAnimada() {
        t.start();
        }

    public void run() {
        while(true) {
          while(true) {
            if (this.getX() > 1300){
                this.setX(this.getImg().getWidth());
            } else {
                this.setX(this.getX() + 10);
            }

            try{
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
          }
        }
      }
}
