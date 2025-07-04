package view;

import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class LayeredPane extends JLayeredPane
{
    public LayeredPane(int width, int height)
    {
        Dimension size = new Dimension(width, height);
        setSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setLayout(null);
        setVisible(true);
    }

    public void addPanel(JPanel panel)
    {
        add(panel);
        panel.setVisible(true);
        revalidate();
        repaint();
    }
}
