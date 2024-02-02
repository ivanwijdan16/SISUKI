package custom;

import java.awt.Color;
import java.awt.Component;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Combobox<E> extends JComboBox<E> {

    public String getLabelText() {
        return labelText;
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    private String labelText = "Label";
    private Color lineColor = new Color(3, 155, 216);
    private boolean mouseOver;

    public Combobox() {
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(15, 3, 5, 3));
        setUI(new ComboUI(this));
        setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int i, boolean bln, boolean bln1) {
                Component com = super.getListCellRendererComponent(jlist, o, i, bln, bln1);
                setBorder(new EmptyBorder(5, 5, 5, 5));
                if (bln) {
                    com.setBackground(new Color(240, 240, 240));
                }
                return com;
            }
        });
    }

    private class ComboUI extends BasicComboBoxUI {

        private final Animator animator;
        private boolean animateHintText = true;
        private float location;
        private boolean show;
        private Combobox combo;

        public ComboUI(Combobox combo) {
            this.combo = combo;
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent me) {
                    mouseOver = true;
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent me) {
                    mouseOver = false;
                    repaint();
                }
            });
            addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent fe) {
                    showing(false);
                }

                @Override
                public void focusLost(FocusEvent fe) {
                    showing(true);
                }
            });
            addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent ie) {
                    if (!isFocusOwner()) {
                        if (getSelectedIndex() == -1) {
                            showing(true);
                        } else {
                            showing(false);
                        }
                    }
                }
            });
            addPopupMenuListener(new PopupMenuListener() {
                @Override
                public void popupMenuWillBecomeVisible(PopupMenuEvent pme) {
                    arrowButton.setBackground(new Color(200, 200, 200));
                }

                @Override
                public void popupMenuWillBecomeInvisible(PopupMenuEvent pme) {
                    arrowButton.setBackground(new Color(150, 150, 150));
                }

                @Override
                public void popupMenuCanceled(PopupMenuEvent pme) {
                    arrowButton.setBackground(new Color(150, 150, 150));
                }
            });
            TimingTarget target = new TimingTargetAdapter() {
                @Override
                public void begin() {
                    animateHintText = getSelectedIndex() == -1;
                }

                @Override
                public void timingEvent(float fraction) {
                    location = fraction;
                    repaint();
                }

            };
            animator = new Animator(300, target);
            animator.setResolution(0);
            animator.setAcceleration(0.5f);
            animator.setDeceleration(0.5f);
        }

        @Override
        public void paintCurrentValueBackground(Graphics graphics, Rectangle bounds, boolean hasFocus) {
            // Do nothing to disable the default background painting
        }

        @Override
        protected JButton createArrowButton() {
            return new ArrowButton();
        }

        @Override
        protected ComboPopup createPopup() {
            BasicComboPopup popup = new BasicComboPopup(comboBox) {
                @Override
                protected JScrollPane createScroller() {
                    list.setFixedCellHeight(30);
                    JScrollPane scrollPane = new JScrollPane(list);
                    scrollPane.setBackground(Color.WHITE);
                    return scrollPane;
                }
            };
            popup.setBorder(new LineBorder(new Color(200, 200, 200), 1));
            return popup;
        }

        @Override
        public void paint(Graphics graphics, JComponent component) {
            super.paint(graphics, component);
            Graphics2D g2 = (Graphics2D) graphics;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
            int width = getWidth();
            int height = getHeight();

            // Set insets
            Insets insets = getInsets();
            int startX = insets.left;
            int startY = insets.top;
            int endX = width - insets.right;
            int endY = height - insets.bottom;

            // Set rounded corners
            int arcWidth = 15;
            int arcHeight = 15;

            if (mouseOver) {
                g2.setColor(lineColor);
            } else {
                g2.setColor(new Color(150, 150, 150));
            }

            // Draw background with rounded corners
            g2.fillRoundRect(startX, startY, endX - startX, endY - startY, arcWidth, arcHeight);

            createHintText(g2);
            createLineStyle(g2);
            g2.dispose();
        }

        private void createHintText(Graphics2D g2) {
            Insets insets = getInsets();
            g2.setColor(new Color(150, 150, 150));
            FontMetrics fontMetrics = g2.getFontMetrics();
            Rectangle2D bounds = fontMetrics.getStringBounds(combo.getLabelText(), g2);
            double height = getHeight() - insets.top - insets.bottom;
            double textY = (height - bounds.getHeight()) / 2 + insets.top + bounds.getHeight() - 5;
            if (animateHintText) {
                float textX = (float) ((getWidth() - insets.left - insets.right) * location);
                g2.drawString(combo.getLabelText(), textX + insets.left, (float) textY);
            } else {
                g2.drawString(combo.getLabelText(), insets.left + 2, (float) textY);
            }
        }

        private void createLineStyle(Graphics2D g2) {
            Insets insets = getInsets();
            g2.setColor(combo.getLineColor());
            g2.drawLine(insets.left, getHeight() - insets.bottom - 1, getWidth() - insets.right, getHeight() - insets.bottom - 1);
        }

        private void showing(boolean show) {
            if (this.show == show) {
                return;
            }
            if (animator.isRunning()) {
                animator.stop();
            }
            if (show) {
                animator.setStartFraction(1f);
                //animator.setEndFraction(0f);
            } else {
                animator.setStartFraction(0f);
                //animator.setEndFraction(1f);
            }
            this.show = show;
            animator.start();
        }
    }

    private class ArrowButton extends JButton {

        private static final int SIZE = 12;

        public ArrowButton() {
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setPreferredSize(new java.awt.Dimension(SIZE, SIZE));
        }

        @Override
        public void paint(Graphics graphics) {
            Graphics2D g2 = (Graphics2D) graphics;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
            int width = getWidth();
            int height = getHeight();

            // Set rounded corners
            int arcWidth = 6;
            int arcHeight = 6;

            if (getModel().isPressed()) {
                g2.setColor(new Color(200, 200, 200));
            } else if (getModel().isRollover()) {
                g2.setColor(new Color(220, 220, 220));
            } else {
                g2.setColor(new Color(150, 150, 150));
            }

            // Draw background with rounded corners
            g2.fillRoundRect(0, 0, width, height, arcWidth, arcHeight);

            int arrowSize = SIZE / 2;
            int startX = (width - arrowSize) / 2;
            int startY = (height - arrowSize) / 2;

            // Draw arrow
            g2.setColor(Color.WHITE);
            g2.fillPolygon(new int[]{startX, startX + arrowSize, startX + arrowSize / 2}, new int[]{startY, startY, startY + arrowSize}, 3);
        }
    }
}
