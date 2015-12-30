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

	public void keyPressed(KeyEvent arg0)
	{
		
	}

	public void keyReleased(KeyEvent arg0)
	{
		
	}

	public void keyTyped(KeyEvent arg0)
	{
		
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
	
	public void mouseClicked(MouseEvent arg0)
	{
		
	}

	public void mouseEntered(MouseEvent arg0)
	{
		
	}

	public void mouseExited(MouseEvent arg0)
	{
		
	}

	public void mousePressed(MouseEvent arg0)
	{
		
	}

	public void mouseReleased(MouseEvent arg0)
	{
		
	}
}
