import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.nio.file.Path;

import javax.swing.JFrame;

public class Principal extends JFrame
	implements MouseMotionListener {
	
	private Espada espada;
	private Fruta fruta;
	private Imagem background;
	private Thread threadImgMovida;
	private ToqueException excecaoToque;
	private int pontuacaoJogo = 0;

	private static final int Width = 1300;
    private static final int Height = 700;

	
	public Principal() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseMotionListener(this);

		threadImgMovida = new Thread();
		threadImgMovida.start();
	
		espada = new Espada(Width, Height);
		fruta = new Fruta();
		background = new Imagem();
		excecaoToque = new ToqueException();
		
		espada.setX(50);
		espada.setY(300);
		espada.setImg("espada.png");
		
		
		
		fruta.setX(50);
		fruta.setY(60);
		fruta.setImg("fruta.png");
		
		
		background.setX(0);
		background.setY(0);
		background.setImg("cenario.png");
		
	}

	



	
	//ESSE EH O METODO QUE DEVE SER ADAPTADO AO PROJETO
	public void renderizarImagens(Graphics g2) {
		
		try {
			//Desenhando as imagens
			background.desenhar(g2);
			g2.drawImage(background.getImg(), 0, 0, getWidth(), getHeight(), null);
			espada.desenhar(g2);
			fruta.desenhar(g2);
			fruta.setImg("fruta.png");
			if(espada.intercepta(fruta)) {
			throw excecaoToque;
		}
		} catch (Exception e) {
			fruta.setImg("explosao.png");
			// fruta.setY(fruta.getY() - 10); 
		}
		
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
        Espada.SetTarget(e.getX(), e.getY() - 170);
    }
}