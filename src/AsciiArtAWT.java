import java.awt.*;
import javax.swing.*;

public class AsciiArtAWT extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);
        int[] mountainsX = {0, 50, 100, 150, 200, 250, 300};
        int[] mountainsY = {200, 50, 150, 100, 150, 50, 200};
        g.fillPolygon(mountainsX, mountainsY, 7);

        g.setColor(Color.BLACK);
        for (int y = 200; y < getHeight(); y += 4) {
            for (int x = 0; x < getWidth(); x += 4) {
                g.fillRect(x, y, 2, 2);
            }
        }

        int baseX = 70;
        int baseY = 250;
        int baseWidth = 160;
        int baseHeight = 35;

        g2d.setColor(Color.BLACK);

        int trackRadius = baseHeight / 2;
        g2d.fillArc(baseX - trackRadius, baseY, trackRadius * 2, baseHeight, 90, 180);
        g2d.fillArc(baseX + baseWidth - trackRadius, baseY, trackRadius * 2, baseHeight, 270, 180);

        g2d.fillRect(baseX, baseY, baseWidth, 3);
        g2d.fillRect(baseX, baseY + baseHeight - 3, baseWidth, 3);

        for (int x = baseX; x <= baseX + baseWidth; x += 10) {
            g2d.fillRect(x, baseY, 3, baseHeight);
        }

        int wheelDiameter = 25;
        int[] wheelPositions = {
                baseX + 20,
                baseX + 60,
                baseX + 100,
                baseX + 140
        };

        for (int wheelX : wheelPositions) {
            int wheelY = baseY + (baseHeight - wheelDiameter) / 2;
            g2d.setColor(Color.BLACK);
            g2d.fillOval(wheelX, wheelY, wheelDiameter, wheelDiameter);
            g2d.fillOval(wheelX + 8, wheelY + 8, wheelDiameter - 16, wheelDiameter - 16);
        }

        g2d.setColor(Color.BLACK);
        g2d.fillRoundRect(baseX + 50, baseY - 30, 80, 40, 20, 20);

        int hatchWidth = 30;
        int hatchHeight = 20;
        int hatchX = baseX + 85;
        int hatchY = baseY - 28;
        g2d.drawArc(hatchX, hatchY, hatchWidth, hatchHeight, 0, 180);
        g2d.drawLine(hatchX, hatchY + hatchHeight / 2, hatchX + hatchWidth, hatchY + hatchHeight / 2);

        g2d.fillRect(baseX + 130, baseY - 18, 80, 10); // Увеличенное дуло
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tank Landscape");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        AsciiArtAWT panel = new AsciiArtAWT();
        frame.add(panel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
