package custom;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class PanelRoundedv2 extends JPanel {

    private int roundTopLeft = 0;
    private int roundTopRight = 0;
    private int roundBottomLeft = 0;
    private int roundBottomRight = 0;

    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
    }

    public int getRoundTopRight() {
        return roundTopRight;
    }

    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
    }

    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }

    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
    }

    public int getRoundBottomRight() {
        return roundBottomRight;
    }

    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
    }

    public PanelRoundedv2() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics graphic) {
        Graphics2D g2 = (Graphics2D) graphic.create();
        
        // Membuat efek shadow
        int shadowSize = 5; // Ukuran shadow
        int shadowOpacity = 100; // Opasitas shadow (0-255)

        g2.setColor(new Color(0, 0, 0, shadowOpacity));
        //g2.setRenderingHint(RenderingHints.KEY_BLUR_QUALITY, RenderingHints.VALUE_BLUR_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), roundTopLeft, roundTopLeft);
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());

        Area area = new Area(createRoundTopLeft());

        if (roundTopRight > 0) {
            area.intersect(new Area(createRoundTopRight()));
        }

        if (roundBottomLeft > 0) {
            area.intersect(new Area(createRoundBottomLeft()));
        }

        if (roundBottomRight > 0) {
            area.intersect(new Area(createRoundBottomRight()));
        }

        g2.fill(area);
        g2.dispose();
        super.paintComponent(graphic);
    }

    private RoundRectangle2D createRoundTopLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopLeft);
        int roundY = Math.min(height, roundTopLeft);

        return new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY);
    }

    private Rectangle2D createRoundTopRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopRight);
        int roundY = Math.min(height, roundTopRight);

        return new Rectangle2D.Double(0, 0, width - roundX / 2, width);
    }

    private Rectangle2D createRoundBottomLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomLeft);
        int roundY = Math.min(height, roundBottomLeft);

        return new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height);
    }

    private Rectangle2D createRoundBottomRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomRight);
        int roundY = Math.min(height, roundBottomRight);

        return new Rectangle2D.Double(0, 0, width - roundX / 2, height);
    }
}
