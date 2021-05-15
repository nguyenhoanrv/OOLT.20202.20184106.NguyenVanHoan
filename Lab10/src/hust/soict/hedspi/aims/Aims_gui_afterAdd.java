package hust.soict.hedspi.aims;

import java.awt.*;       // Using AWT layouts
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;    // Using Swing components and containers

public class Aims_gui_afterAdd extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    private JLabel lblSuccess;
    @SuppressWarnings("unused")
    private JPanel panel;
    
    public Aims_gui_afterAdd(boolean isBook) {
        setResizable(false);
        setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Information");
        
        getContentPane().setLayout(null);
        
        lblSuccess = new JLabel("Adding new item succeed!");
        lblSuccess.setHorizontalAlignment(SwingConstants.CENTER);
        lblSuccess.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblSuccess.setBounds(0, 20, 236, 31);
        getContentPane().add(lblSuccess);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 61, 246, 31);
        getContentPane().add(panel);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JButton btnOK = new JButton("OK");
        panel.add(btnOK);
        
        JPanel blankPanel = new JPanel();
        panel.add(blankPanel);
        
        JButton btnPlay = new JButton("Play CD/DVD");
        panel.add(btnPlay);
        if (isBook) {
            btnPlay.setVisible(false);
        }
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(10, 10, 214, 91);
        getContentPane().add(textArea);
        textArea.setVisible(false);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 2, 2);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollPane);
        scrollPane.setVisible(false);
        
        JFrame thisFrame = this;
        btnOK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thisFrame.dispose();
            }
        });
        
        btnPlay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblSuccess.setVisible(false);
                panel.setVisible(false);
                textArea.setVisible(true);
                scrollPane.setVisible(true);
                // add text
            }
        });

        this.setBounds(325, 175, 250, 150);
        this.setVisible(true);
    }
    
    
}