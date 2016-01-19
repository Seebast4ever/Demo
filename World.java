import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Polygon;

public class World implements ActionListener {
    private JFrame f;
    private JPanel p;
    private JTextField t;
    private JButton b1, b2;
    private JLabel l1, l2;
    

    public World() {
	f = new JFrame();
	f.setTitle("Settlers of GUI");
	f.setSize(1000, 600);
	f.setLocation(50, 50);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);

	p = new JPanel(new GridBagLayout());

	//instantiate button and label
	b1 = new JButton("This is part of the menu!!");
	b2 = new JButton("It's a ongoing process...");
	l1 = new JLabel("Hopefully this works :D");
	l2 = new JLabel("Yayyy!!!!");

	GridBagConstraints c = new GridBagConstraints();

	
	//puts button and label onto panel

	//spacing between buttons is 10
	c.insets = new Insets(10, 10, 10, 10);
	//puts on location (0,5) of pane
	c.gridx = 0;
	c.gridy = 0;
	p.add(b1, c);

	c.gridx = 0;
	c.gridy = 1;
	p.add(b2, c);

	c.gridx = 2;
	c.gridy = 2;
	p.add(l1, c);

	c.gridx = 2;
	c.gridy = 0;
	p.add(l2, c);
	//puts this panel (and all its features) west
	f.add(p, BorderLayout.WEST);


    }
    /*    public World(String title, int sizex, int sizey, int locationx, int locationy) {
	this.setTitle(title);
	this.setSize(sizex, sizey);
	this.setLocation(locationx, locationy);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
	} */


    
    public void actionPerformed(ActionEvent e) {
	
    }
}
