import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.stream.Location;

public class Gui extends JPanel {
    private JFrame frame;
    private JButton whites[];
    private JButton blacks[];
    private JPanel panel;
    private Icon blackQueenIcon;
    private Icon whiteQueenIcon;

    protected void createUIComponents()
    {
        frame = new JFrame();
        Initialize();
        createBoard();
        frame.setVisible(true);
    }

    protected void Initialize()
    {
        whites = new JButton[4];
        Point whitePoints[] = {
                new Point(190, 7),
                new Point(370, 7),
                new Point(7, 190),
                new Point(550, 190)
        };
        whiteQueenIcon = new ImageIcon("C:\\Users\\rotem\\Desktop\\White.png");
        for (int i = 0; i < 4; i++) {
            whites[i] = new JButton(whiteQueenIcon);
            whites[i].setSize(42, 42);
            whites[i].setLocation(whitePoints[i]);
            frame.add(whites[i]);
        }

        blacks = new JButton[4];
        Point blackPoints[] = {
                new Point(190, 550),
                new Point(370, 550),
                new Point(7, 370),
                new Point(550, 370)
        };
        blackQueenIcon = new ImageIcon("C:\\Users\\rotem\\Desktop\\Black.png");
        for (int i = 0; i < 4; i++) {
            blacks[i] = new JButton(blackQueenIcon);
            blacks[i].setSize(42, 42);
            blacks[i].setLocation(blackPoints[i]);
            frame.add(blacks[i]);
        }
    }

    protected void createBoard()
    {
        ImageIcon icon2 = new ImageIcon("C:\\Users\\rotem\\Desktop\\Board.png");
        JTextArea text = new JTextArea() {
            Image img = icon2.getImage();

            {
                setOpaque(false);
            }

            public void paintComponent(Graphics graphics) {
                graphics.drawImage(img, 0, 0, this);
                super.paintComponent(graphics);
            }
        };
        JScrollPane pane = new JScrollPane(text);
        Container content = frame.getContentPane();
        content.add(pane, BorderLayout.CENTER);
        frame.setSize(620, 640);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}