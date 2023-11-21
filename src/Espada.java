public class Espada extends ImagemMovida implements Runnable {

	public static int Size = 50;
	private static final double Velocity = 10;
	private static final int SleepTime = 20;
	private static final int StopMargin = 3;
	
	private final int StartX;
	private final int StartY;
	private static int TargetX;
	private static int TargetY;

	public Thread thread;

	public Espada(int containerWidth, int containerHeight)
	{
		
		StartX = containerWidth / 2;
		StartY = containerHeight / 2;
		SetTarget(StartX, StartY);
		
	 	thread = new Thread(this);
		thread.start();
	}
	
	
	public static void SetTarget(int x, int y)
	{
		TargetX = x;
		TargetY = y;
	}
	
	private void ChaseTarget()
	{
		var xDiff = TargetX - getX() - Size/2;
		var yDiff = TargetY - getY() - Size/2;
		
		if (Math.abs(xDiff) < StopMargin && Math.abs(yDiff) < StopMargin) return;
		
		var velocityModule = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
		
		var xStep = (double)xDiff * Velocity / velocityModule;
		var yStep = (double)yDiff * Velocity / velocityModule;
		
		try
		{
			moverDireita((int)xStep);
			moverBaixo((int)yStep);			
		}
		catch(Exception exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	

	@Override
	public void run() {
		try {
			while (true)
			{
				ChaseTarget();
				
				Thread.sleep(SleepTime);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
}

// public void moverDireita(int shift) {
// 	this.setX(this.getX() + shift);
// }

// public void moverEsquerda(int shift) {
// 	this.setX(this.getX() - shift);
// }

// public void moverCima(int shift) {
// 	this.setY(this.getY() - shift);
// }

// public void moverBaixo(int shift) {
// 	this.setY(this.getY() + shift);
// }