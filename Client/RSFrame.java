import java.awt.*;

final class RSFrame extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6411404177667816019L;

	public RSFrame(RSApplet RSApplet_, int i, int j) {
		rsApplet = RSApplet_;
		setTitle("Project");
		setResizable(true);
		setVisible(true);
		toFront();
		setSize(i + 8, j + 28);
		setResizable(true);
		setLocationRelativeTo(null);
	}

	@Override
	public Graphics getGraphics() {
		Graphics g = super.getGraphics();
		g.translate(4, 24);
		return g;
	}

	@Override
	public void update(Graphics g) {
		rsApplet.update(g);
	}

	@Override
	public void paint(Graphics g) {
		rsApplet.paint(g);
	}

	private final RSApplet rsApplet;
}
