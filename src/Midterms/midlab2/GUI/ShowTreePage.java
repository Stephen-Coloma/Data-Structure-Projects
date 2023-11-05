package Midterms.midlab2.GUI;

import Midterms.midlab2.Huffman;
import Midterms.midlab2.tree.TreeNode;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.*;

import javax.swing.JComponent;
import java.awt.*;

public class ShowTreePage extends JComponent {
    private TreeNode root;

    public ShowTreePage(TreeNode root) {
        this.root = root;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (root != null) {
            Graphics2D g2d = (Graphics2D) g;
            BasicStroke boldStroke = new BasicStroke(2); // Set the line thickness to 2 pixels
            g2d.setStroke(boldStroke);
            drawTreeNode(g2d, getWidth() / 2, 30, root, getWidth() / 4, "");
        }
    }

    private void drawTreeNode(Graphics2D g, int x, int y, TreeNode node, int xOffset, String path) {
        if (node != null) {
            g.setColor(Color.BLACK);
            g.drawOval(x - 15, y - 15, 30, 30);
            g.drawString(String.valueOf(node.getSymbol()), x - 10, y + 7);

            if (node.getLeft() != null) {
                int childX = x - xOffset;
                int childY = y + 60;
                g.setColor(Color.BLACK);
                g.drawLine(x, y + 15, childX, childY - 15);

                // Draw "0" next to the left line with a bold font
                Font boldFont = new Font(g.getFont().getFontName(), Font.BOLD, g.getFont().getSize());
                g.setFont(boldFont);
                g.drawString("0", (x + childX) / 2 - 5, (y + childY) / 2 - 10);
                g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, g.getFont().getSize()));

                drawTreeNode(g, childX, childY, node.getLeft(), xOffset / 2, path + "0");
            }

            if (node.getRight() != null) {
                int childX = x + xOffset;
                int childY = y + 60;
                g.setColor(Color.BLACK);
                g.drawLine(x, y + 15, childX, childY - 15);

                // Draw "1" next to the right line with a bold font
                Font boldFont = new Font(g.getFont().getFontName(), Font.BOLD, g.getFont().getSize());
                g.setFont(boldFont);
                g.drawString("1", (x + childX) / 2 - 5, (y + childY) / 2 - 10);
                g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, g.getFont().getSize()));

                drawTreeNode(g, childX, childY, node.getRight(), xOffset / 2, path + "1");
            }
        }
    }
}
