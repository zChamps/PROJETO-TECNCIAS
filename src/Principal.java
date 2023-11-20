import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Principal extends JFrame
	implements MouseMotionListener {
	
	private ImagemMovida aviao;
	private Imagem background;
	private Thread threadImgMovida;

	private static final int Width = 1300;
    private static final int Height = 700;

	private AviaoAnimado aviao2;
	
	public Principal() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseMotionListener(this);

		threadImgMovida = new Thread();
		threadImgMovida.start();
	
		aviao = new AviaoMovido(Width, Height);
		aviao2 = new AviaoAnimado();
		background = new Imagem();
		
		aviao.setX(50);
		aviao.setY(300);
		aviao.setImg("aviao.png");
		
		
		
		aviao2.setX(50);
		aviao2.setY(60);
		aviao2.setImg("aviao.png");
		
		
		background.setX(0);
		background.setY(0);
		background.setImg("background image.jpeg");
		
	}

	



	
	//ESSE EH O METODO QUE DEVE SER ADAPTADO AO PROJETO
	public void renderizarImagens(Graphics g2) {
		//Desenhando as imagens
		background.desenhar(g2);
		g2.drawImage(background.getImg(), 0, 0, getWidth(), getHeight(), null);
		aviao.desenhar(g2);
		aviao2.desenhar(g2);
		if(aviao.getRectangle().intersects(aviao2.getRectangle()));
	}
	
	//EVITAR ALTERAR ESSE METODO
	public static void main(String[] args) {
		//Criando uma instancia da classe principal
		Principal t = new Principal();
		t.setSize(1300, 750);
		t.createBufferStrategy(1);		
		t.setVisible(true);
		t.createBufferStrategy(2);
	}
	
	//EVITAR ALTERAR ESSE METODO
	public void renderizarGraphics() {
		if (!getBufferStrategy().contentsLost()) getBufferStrategy().show();
	    Graphics g = getBufferStrategy().getDrawGraphics();
	    //Criando um contexto grafico
	    Graphics g2 = g.create();
	    //Limpando a tela
	    g2.setColor(Color.WHITE);        
	    g2.fillRect(0, 0, getWidth(), getHeight());
	    renderizarImagens(g2);
	    //Liberando os contextos criados
	    g.dispose(); 
	    g2.dispose();
	}
	
	//EVITAR ALTERAR ESSE METODO
	public void paint(Graphics g) {
		this.renderizarGraphics();
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {}
	@Override
    public void mouseMoved(MouseEvent e)
    {
        AviaoMovido.SetTarget(e.getX(), e.getY());
    }
	// @Override
	// public void run() {

	// 	MouseEvent e
    // 	while (true) {
    //     if(e.getX() > aviao.getX()) {
	// 		aviao.moverDireita(1);			
	// 	}
	// 	else {
	// 		aviao.moverEsquerda(1);			
	// 	}
		
	// 	if(e.getY() > aviao.getY()) {
	// 		aviao.moverBaixo(1);			
	// 	}
	// 	else {
	// 		aviao.moverCima(1);			
	// 	}
    //     try {
    //         Thread.sleep(100); // ou qualquer intervalo desejado
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    // }
}


	// while(true){

	// 	MouseEvent e;
	// 	if(e.getX() > aviao.getX()) {
	// 		aviao.moverDireita(1);			
	// 	}
	// 	else {
	// 		aviao.moverEsquerda(1);			
	// 	}
		
	// 	if(e.getY() > aviao.getY()) {
	// 		aviao.moverBaixo(1);			
	// 	}
	// 	else {
	// 		aviao.moverCima(1);			
	// 	}
	// }
















	// public void mouseMoved(MouseEvent e) {
	// 	System.out.println("[" + e.getX() + ";" + e.getY() + "]");
		
	// 	if(e.getX() > aviao.getX()) {
			
	// 			try {
	// 				if(aviao.getX() > getWidth() - 250){
	// 					throw new PosicaoInvalidaException();
	// 				}
	// 				aviao.moverDireita(1);
					
	// 			} catch (PosicaoInvalidaException e1) {
					
	// 				System.out.println("Posição Inválida");
	// 			}
			
			
						
	// 	}
	// 	else {
	// 		aviao.moverEsquerda(1);			
	// 	}
		
	// 	if(e.getY() > aviao.getY()) {
	// 		aviao.moverBaixo(1);			
	// 	}
	// 	else {
	// 		aviao.moverCima(1);			
	// 	}
	// }
