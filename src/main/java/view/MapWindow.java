package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MapWindow extends JFrame
{
    private LayeredPane layeredPane;

    public MapWindow(int width, int height)
    {
        setTitle("GTFS Viewer");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        layeredPane = new LayeredPane(width, height);
        setContentPane(layeredPane);
    }
    
    public void addPanel(JPanel panel)
    {
        layeredPane.add(panel);
        revalidate();
        repaint();
    }
}
