package hust.soict.hedspi.aims;

import java.awt.*;       // Using AWT layouts
import java.awt.event.*; // Using AWT event classes and listener interfaces
import java.util.List;

import javax.swing.*;    // Using Swing components and containers

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.order.Order;

public class Aims_gui extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    // label: warning
    JLabel lblOrderId = new JLabel("Order ID"); 
    JLabel lblWarning = new JLabel();
    
    // combo box: order id list
    JComboBox<Integer> cbListOrderId = new JComboBox<Integer>();
    
    // list: item list
    DefaultListModel<String> itemList = new DefaultListModel<>();
    JList<String> showedItemList = new JList<String>(itemList);

    // button: add item, delete item
    JButton btnCreate = new JButton("Create order");
    JButton btnAdd = new JButton("Add item");
    JButton btnDel = new JButton("Delete item");
    
    // Other
    int orderId = -1;
    
    public Aims_gui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Aims");  
        Container contentPane = this.getContentPane();  
        
        // Add layout
        GridBagLayout layout = new GridBagLayout();  
        GridBagConstraints gbc = new GridBagConstraints();
        contentPane.setLayout(layout);
        
        // Add components
        gbc.insets = new Insets(5, 5, 5, 5);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(lblOrderId, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 10;
        this.add(cbListOrderId, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        this.add(btnCreate, gbc);
        
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(new JPanel(), gbc); 
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 350;
        gbc.ipady = 350;
        gbc.gridwidth = 4;
        gbc.gridheight = 3;
        this.add(showedItemList, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(btnAdd, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 4;
        gbc.gridy = 3;
        this.add(btnDel, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        this.add(lblWarning, gbc);
        
        // Add listeners
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (orderId < Order.MAX_LIMITED_ORDERS) {
                    cbListOrderId.addItem(++orderId);    
                }
            }
        });
        
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (cbListOrderId.getSelectedIndex() != -1) {
                    Aims_gui_addItem addItemFrame = new Aims_gui_addItem(cbListOrderId.getSelectedIndex());
                    updateShowedItemList(); //
                    warning(false, "");
                } else {
                    if (orderId == -1) {
                        warning(true, "Please create a new order first");
                    }
                }
            }
        });
        
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (orderId == -1) {
                    warning(true, "Please create a new order first");
                    return;
                }
                
                if (cbListOrderId.getSelectedIndex() == -1) {
                    warning(true, "Please select an item first");
                    return;
                }
                
                Aims.deleteItemById(cbListOrderId.getSelectedIndex(), showedItemList.getSelectedIndex()); // <> //
                updateShowedItemList(); //
                warning(false, "");
            }
        });
        
        // Display the window 
        this.setBounds(250, 75, 550, 520);
        this.setVisible(true);
    }
    
    private void updateShowedItemList() {
        itemList.clear();
        StringBuffer stringBuffer = new StringBuffer();
        int orderID = cbListOrderId.getSelectedIndex();
        List<Media> mediaList = Aims.getOrders().get(orderID).getItemsOrdered();
        
        for (int i = 0; i < mediaList.size(); i++) {
            Media media = mediaList.get(i);
            stringBuffer.append(media.getId() + " - ");
            if (media instanceof DigitalVideoDisc) {
                stringBuffer.append("DVD - ");
                stringBuffer.append(media.getTitle() + " - ");
                stringBuffer.append(media.getCategory() + " - ");
                stringBuffer.append(((DigitalVideoDisc)media).getDirector() + " - ");
                stringBuffer.append(((DigitalVideoDisc)media).getLength() + " - ");
                stringBuffer.append(media.getCost());
            } else if (media instanceof Book) {
                stringBuffer.append("Book - ");
                stringBuffer.append(media.getTitle() + " - ");
                stringBuffer.append(media.getCategory() + " - ");
                stringBuffer.append(((Book)media).getAuthors().get(0));
                for (int j = 1; j < ((Book)media).getAuthors().size(); j++) {
                    stringBuffer.append(", " + ((Book)media).getAuthors().get(j));
                }
                stringBuffer.append(" - " + media.getCost());
            } else { // CD
                stringBuffer.append("CD - ");
                stringBuffer.append(media.getTitle() + " - ");
                stringBuffer.append(media.getCategory() + " - ");
                stringBuffer.append(((CompactDisc)media).getArtist());
                stringBuffer.append(" - " + media.getCost());
            }
            itemList.addElement(stringBuffer.toString());
        }
        showedItemList = new JList<String>(itemList);
    }
    
    private void warning(boolean isVisible, String warningText) {
        lblWarning.setText(warningText);
        lblWarning.setVisible(isVisible);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Aims_gui(); // Let the constructor do the job
            }
        });
    }

}
