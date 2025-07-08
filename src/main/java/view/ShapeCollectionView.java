package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JPanel;

import collection.ShapeCollection;
import model.Shape;

public class ShapeCollectionView extends JPanel
{
    private final ShapeCollection shapeCollection;

    public ShapeCollectionView(ShapeCollection shapeCollection)
    {
        this.shapeCollection = shapeCollection;
        setLayout(null);
        setBackground(new Color(0, 0, 0, 0));
        setSize(new Dimension(1600, 900));
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.RED);
        graphics2D.setStroke(new BasicStroke(2.0f));
        
        List<Shape> shapes = shapeCollection.getShapes();
        ListIterator<Shape> current = shapes.listIterator();
        ListIterator<Shape> next = shapes.listIterator();

        if (current.hasNext()) next.next();

        while (next.hasNext())
        {
            Shape currentNode = current.next();
            Shape nextNode = next.next();

            if (currentNode.getShapeId().equals(nextNode.getShapeId()))
            {
                Position first = Converter.convertCoordinatePosition(currentNode.getCoordinate());
                Position second = Converter.convertCoordinatePosition(nextNode.getCoordinate());

                int firstX = first.getX();
                int firstY = first.getY();
                int secondX = second.getX();
                int secondY = second.getY();

                graphics2D.drawLine(firstX, firstY, secondX, secondY);
            }
        }
    }
}
