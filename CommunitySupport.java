import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;
public class CommunitySupport {
    private static int currentImageIndex = 0; 
    private static final String[] imagePaths = {
        "C:\\Users\\Hello\\Downloads\\VVV.jpg",
        "C:\\Users\\Hello\\Downloads\\ROMBAROMBA.jpg",
        "C:\\Users\\Hello\\Downloads\\NVA.jpg",
        "C:\\Users\\Hello\\Downloads\\ADHD CELB.jpg"
    };
    public static void main(String[] args) {
        JFrame frame = new JFrame("Community Links");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 650);
        frame.getContentPane().setBackground(new Color(0x00b4c5));
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
        panel.setBackground(new Color(0x00b4c5));  
        JLabel headingLabel = new JLabel("Community Support On Its way For You! ❤", SwingConstants.CENTER);
        headingLabel.setFont(new Font("Roboto Slab", Font.BOLD, 26)); 
        headingLabel.setForeground(new Color(0x2e2929)); 
        headingLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        headingLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10)); 
        ImageIcon facebookIcon = new ImageIcon("C:\\Users\\Hello\\Downloads\\FACEBOOK.png");
        ImageIcon discordIcon = new ImageIcon("C:\\Users\\Hello\\Downloads\\DISCORD.png");
        ImageIcon quoraIcon = new ImageIcon("C:\\Users\\Hello\\Downloads\\Quora_icon.svg.png");
        facebookIcon = resizeIcon(facebookIcon, 24, 24);
        discordIcon = resizeIcon(discordIcon, 24, 24);
        quoraIcon = resizeIcon(quoraIcon, 24, 24);
        JLabel facebookLabel = new JLabel(facebookIcon);
        facebookLabel.setText("<html><a href=\"https://web.facebook.com/groups/neurodivergentmemes\">Facebook</a></html>");
        facebookLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        facebookLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        facebookLabel.setForeground(new Color(0x495c69)); 
        facebookLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        facebookLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openLink("https://web.facebook.com/groups/neurodivergentmemes");
            }
        });
        JLabel discordLabel = new JLabel(discordIcon);
        discordLabel.setText("<html><a href=\"https://discord.com/invite/adhd-dopamine\">Discord</a></html>");
        discordLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        discordLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        discordLabel.setForeground(new Color(0x495c69)); 
        discordLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        discordLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openLink("https://discord.com/invite/adhd-dopamine");
            }
        });
        JLabel quoraLabel = new JLabel(quoraIcon);
        quoraLabel.setText("<html><a href=\"https://attentiondeficitdisorder.quora.com/?q=ADHD\">Quora</a></html>");
        quoraLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        quoraLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        quoraLabel.setForeground(new Color(0x495c69)); 
        quoraLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        quoraLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openLink("https://attentiondeficitdisorder.quora.com/?q=ADHD");
            }
        });
        panel.add(headingLabel);
        panel.add(facebookLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); 
        panel.add(discordLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); 
        panel.add(quoraLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel secondHeadingLabel = new JLabel("Happy Socializing With Like-minded People Who Genuinely Understand You.", SwingConstants.CENTER);
        secondHeadingLabel.setFont(new Font("Agu Display Uzo", Font.BOLD, 22)); 
        secondHeadingLabel.setForeground(new Color(0x495c69)); 
        secondHeadingLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        secondHeadingLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10)); 

        panel.add(secondHeadingLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setPreferredSize(new Dimension(350, 250)); 
        panel.add(imageLabel);

        updateImage(imageLabel);

        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndex = (currentImageIndex + 1) % imagePaths.length;
                updateImage(imageLabel);
            }
        });
        timer.start();
        JLabel finalText = new JLabel("This is YOUR Space, YOUR World! Neurotypicals Can Never Understand US But Together We Can.");
        finalText.setFont(new Font("Roboto Slab", Font.BOLD, 22)); 
        finalText.setForeground(new Color(0x112058)); 
        finalText.setHorizontalAlignment(SwingConstants.CENTER);
        finalText.setAlignmentX(Component.CENTER_ALIGNMENT); 
        finalText.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10)); 
        panel.add(finalText);
        frame.add(panel);
        frame.setVisible(true);
    }
    private static void updateImage(JLabel imageLabel) {
        ImageIcon imageIcon = new ImageIcon(resizeImage(imagePaths[currentImageIndex], 350, 250));
        imageLabel.setIcon(imageIcon);
    }
    private static Image resizeImage(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        return icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    private static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage(); 
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH); 
        return new ImageIcon(newImg); 
    }

    public static void openLink(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

