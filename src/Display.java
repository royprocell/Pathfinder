import javax.swing.JFrame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Display implements KeyListener, MouseListener
{
	private JFrame frame;
	private String title;
	public int width, height;
	private Canvas canvas;
	private static boolean[] keys = new boolean[256];
	public static boolean up, down, left, right;
	private int key;
	
	public Display(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	private void createDisplay()
	{
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		frame.addKeyListener(this);
		frame.addMouseListener(this);
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setVisible(true);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		frame.add(canvas);
		frame.pack();
	}

	public void keyPressed(KeyEvent e)
	{
		key = e.getKeyCode();
		if (key == KeyEvent.VK_ESCAPE && State.getState() == Game.menuState) {
			System.exit(0);
		}

		if (key == KeyEvent.VK_ESCAPE && State.getState() == Game.gameState) {
			State.setState(Game.menuState);
		}

		if (key == KeyEvent.VK_ENTER && State.getState() == Game.menuState) {
			State.setState(Game.gameState);
		}
		
		if (key == KeyEvent.VK_E && State.getState() == Game.gameState) {
			State.setState(Game.bankState);
		}
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e)
	{
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e)
	{
		
	}
	
	public static void updateKeys()
	{
		up = keys[KeyEvent.VK_UP];
		left = keys[KeyEvent.VK_A];
		down = keys[KeyEvent.VK_S];
		right = keys[KeyEvent.VK_D];
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
	
	public void mouseClicked(MouseEvent e)
	{
		
	}

	public void mouseEntered(MouseEvent e)
	{
		
	}

	public void mouseExited(MouseEvent e)
	{
		
	}

	public void mousePressed(MouseEvent e)
	{
		
	}

	public void mouseReleased(MouseEvent e)
	{
		
	}
}
