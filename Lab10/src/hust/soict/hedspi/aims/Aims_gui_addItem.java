package hust.soict.hedspi.aims;

import java.awt.*;       // Using AWT layouts
import java.awt.event.*; // Using AWT event classes and listener interfaces
import javax.swing.*;    // Using Swing components and containers

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.*;

public class Aims_gui_addItem extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    private JLabel lblWarning;
    private JTextField txtTitle;
    private JTextField txtCategory;
    private JTextField txtCost;
    private JTextField txtDirector;
    private JTextField txtLength;
    private JTextField txtArtist;
    private JTextField txtNumOfTrack;
    private JTextField txtAuthor;
    private JTextField txtBookContent;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    
    CompactDisc cd; // because: inputting CD needs to be done in 2 frames
    boolean trackInputted = false;
    
    public Aims_gui_addItem(int orderId) {
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
        this.setTitle("Add an item");
        
        // Add layout & components
        GridBagLayout gridBagLayout = new GridBagLayout();
        
        gridBagLayout.columnWidths = new int[]{129, 100, 0};
        gridBagLayout.rowHeights = new int[]{48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);
        
        JLabel lblType = new JLabel("Type:");
        GridBagConstraints gbc_lblType = new GridBagConstraints();
        gbc_lblType.anchor = GridBagConstraints.EAST;
        gbc_lblType.insets = new Insets(0, 0, 5, 5);
        gbc_lblType.gridx = 0;
        gbc_lblType.gridy = 0;
        getContentPane().add(lblType, gbc_lblType);
        
        JPanel pnlRdbtn = new JPanel();
        GridBagConstraints gbc_pnlRdbtn = new GridBagConstraints();
        gbc_pnlRdbtn.anchor = GridBagConstraints.WEST;
        gbc_pnlRdbtn.insets = new Insets(0, 0, 5, 0);
        gbc_pnlRdbtn.gridx = 1;
        gbc_pnlRdbtn.gridy = 0;
        getContentPane().add(pnlRdbtn, gbc_pnlRdbtn);
        pnlRdbtn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JRadioButton rdbtnDVD = new JRadioButton("DVD", true);
        buttonGroup.add(rdbtnDVD);
        pnlRdbtn.add(rdbtnDVD);
        
        JRadioButton rdbtnCD = new JRadioButton("CD");
        buttonGroup.add(rdbtnCD);
        pnlRdbtn.add(rdbtnCD);
        
        JRadioButton rdbtnBook = new JRadioButton("Book");
        buttonGroup.add(rdbtnBook);
        pnlRdbtn.add(rdbtnBook);
        
        JLabel lblTitle = new JLabel("Title:");
        GridBagConstraints gbc_lblTitle = new GridBagConstraints();
        gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
        gbc_lblTitle.anchor = GridBagConstraints.EAST;
        gbc_lblTitle.gridx = 0;
        gbc_lblTitle.gridy = 1;
        getContentPane().add(lblTitle, gbc_lblTitle);
        
        txtTitle = new JTextField();
        GridBagConstraints gbc_txtTitle = new GridBagConstraints();
        gbc_txtTitle.anchor = GridBagConstraints.WEST;
        gbc_txtTitle.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtTitle.insets = new Insets(0, 0, 5, 0);
        gbc_txtTitle.gridx = 1;
        gbc_txtTitle.gridy = 1;
        getContentPane().add(txtTitle, gbc_txtTitle);
        txtTitle.setColumns(10);
        
        JLabel lblCategory = new JLabel("Category:");
        GridBagConstraints gbc_lblCategory = new GridBagConstraints();
        gbc_lblCategory.anchor = GridBagConstraints.EAST;
        gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
        gbc_lblCategory.gridx = 0;
        gbc_lblCategory.gridy = 2;
        getContentPane().add(lblCategory, gbc_lblCategory);
        
        txtCategory = new JTextField();
        GridBagConstraints gbc_txtCategory = new GridBagConstraints();
        gbc_txtCategory.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCategory.insets = new Insets(0, 0, 5, 0);
        gbc_txtCategory.gridx = 1;
        gbc_txtCategory.gridy = 2;
        getContentPane().add(txtCategory, gbc_txtCategory);
        txtCategory.setColumns(10);
        
        JLabel lblCost = new JLabel("Cost:");
        GridBagConstraints gbc_lblCost = new GridBagConstraints();
        gbc_lblCost.anchor = GridBagConstraints.EAST;
        gbc_lblCost.insets = new Insets(0, 0, 5, 5);
        gbc_lblCost.gridx = 0;
        gbc_lblCost.gridy = 3;
        getContentPane().add(lblCost, gbc_lblCost);
        
        txtCost = new JTextField();
        GridBagConstraints gbc_txtCost = new GridBagConstraints();
        gbc_txtCost.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCost.insets = new Insets(0, 0, 5, 0);
        gbc_txtCost.gridx = 1;
        gbc_txtCost.gridy = 3;
        getContentPane().add(txtCost, gbc_txtCost);
        txtCost.setColumns(10);
        
        JPanel blankPanel1 = new JPanel();
        GridBagConstraints gbc_blankPanel1 = new GridBagConstraints();
        gbc_blankPanel1.insets = new Insets(0, 0, 5, 5);
        gbc_blankPanel1.fill = GridBagConstraints.BOTH;
        gbc_blankPanel1.gridx = 0;
        gbc_blankPanel1.gridy = 4;
        getContentPane().add(blankPanel1, gbc_blankPanel1);
        
        JLabel lblArtist = new JLabel("Artist:");
        GridBagConstraints gbc_lblArtist = new GridBagConstraints();
        gbc_lblArtist.anchor = GridBagConstraints.EAST;
        gbc_lblArtist.insets = new Insets(0, 0, 5, 5);
        gbc_lblArtist.gridx = 0;
        gbc_lblArtist.gridy = 5;
        getContentPane().add(lblArtist, gbc_lblArtist);
        lblArtist.setVisible(false);
        
        txtArtist = new JTextField();
        GridBagConstraints gbc_txtArtist = new GridBagConstraints();
        gbc_txtArtist.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtArtist.insets = new Insets(0, 0, 5, 0);
        gbc_txtArtist.gridx = 1;
        gbc_txtArtist.gridy = 5;
        getContentPane().add(txtArtist, gbc_txtArtist);
        txtArtist.setColumns(10);
        txtArtist.setVisible(false);
        
        JLabel lblDirector = new JLabel("Director:");
        GridBagConstraints gbc_lblDirector = new GridBagConstraints();
        gbc_lblDirector.anchor = GridBagConstraints.EAST;
        gbc_lblDirector.insets = new Insets(0, 0, 5, 5);
        gbc_lblDirector.gridx = 0;
        gbc_lblDirector.gridy = 6;
        getContentPane().add(lblDirector, gbc_lblDirector);
        
        txtDirector = new JTextField();
        GridBagConstraints gbc_txtDirector = new GridBagConstraints();
        gbc_txtDirector.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtDirector.insets = new Insets(0, 0, 5, 0);
        gbc_txtDirector.gridx = 1;
        gbc_txtDirector.gridy = 6;
        getContentPane().add(txtDirector, gbc_txtDirector);
        txtDirector.setColumns(10);
        
        JLabel lblAuthor = new JLabel("Author:");
        GridBagConstraints gbc_lblAuthor = new GridBagConstraints();
        gbc_lblAuthor.anchor = GridBagConstraints.EAST;
        gbc_lblAuthor.insets = new Insets(0, 0, 5, 5);
        gbc_lblAuthor.gridx = 0;
        gbc_lblAuthor.gridy = 7;
        getContentPane().add(lblAuthor, gbc_lblAuthor);
        lblAuthor.setVisible(false);
        
        txtAuthor = new JTextField();
        GridBagConstraints gbc_txtAuthor = new GridBagConstraints();
        gbc_txtAuthor.insets = new Insets(0, 0, 5, 0);
        gbc_txtAuthor.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtAuthor.gridx = 1;
        gbc_txtAuthor.gridy = 7;
        getContentPane().add(txtAuthor, gbc_txtAuthor);
        txtAuthor.setColumns(10);
        txtAuthor.setVisible(false);
        
        JPanel blankPanel2 = new JPanel();
        GridBagConstraints gbc_blankPanel2 = new GridBagConstraints();
        gbc_blankPanel2.insets = new Insets(0, 0, 5, 5);
        gbc_blankPanel2.fill = GridBagConstraints.BOTH;
        gbc_blankPanel2.gridx = 0;
        gbc_blankPanel2.gridy = 8;
        getContentPane().add(blankPanel2, gbc_blankPanel2);
        
        JLabel lblLength = new JLabel("Length:");
        GridBagConstraints gbc_lblLength = new GridBagConstraints();
        gbc_lblLength.anchor = GridBagConstraints.EAST;
        gbc_lblLength.insets = new Insets(0, 0, 5, 5);
        gbc_lblLength.gridx = 0;
        gbc_lblLength.gridy = 9;
        getContentPane().add(lblLength, gbc_lblLength);
        
        txtLength = new JTextField();
        GridBagConstraints gbc_txtLength = new GridBagConstraints();
        gbc_txtLength.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtLength.insets = new Insets(0, 0, 5, 0);
        gbc_txtLength.gridx = 1;
        gbc_txtLength.gridy = 9;
        getContentPane().add(txtLength, gbc_txtLength);
        txtLength.setColumns(10);
        
        JLabel lblNumOfTrack = new JLabel("Number of track:");
        GridBagConstraints gbc_lblNumOfTrack = new GridBagConstraints();
        gbc_lblNumOfTrack.anchor = GridBagConstraints.EAST;
        gbc_lblNumOfTrack.insets = new Insets(0, 0, 5, 5);
        gbc_lblNumOfTrack.gridx = 0;
        gbc_lblNumOfTrack.gridy = 10;
        getContentPane().add(lblNumOfTrack, gbc_lblNumOfTrack);
        lblNumOfTrack.setVisible(false);
        
        JPanel pnlAddTrack = new JPanel();
        GridBagConstraints gbc_pnlAddTrack = new GridBagConstraints();
        gbc_pnlAddTrack.anchor = GridBagConstraints.WEST;
        gbc_pnlAddTrack.fill = GridBagConstraints.VERTICAL;
        gbc_pnlAddTrack.insets = new Insets(0, 0, 5, 0);
        gbc_pnlAddTrack.gridx = 1;
        gbc_pnlAddTrack.gridy = 10;
        getContentPane().add(pnlAddTrack, gbc_pnlAddTrack);
        pnlAddTrack.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnlAddTrack.setVisible(false);
        
        txtNumOfTrack = new JTextField();
        pnlAddTrack.add(txtNumOfTrack);
        txtNumOfTrack.setColumns(10);
        
        JButton btnAddTrack = new JButton("Add Track");
        pnlAddTrack.add(btnAddTrack);
        
        JLabel lblBookContent = new JLabel("Book's content:");
        GridBagConstraints gbc_lblBookContent = new GridBagConstraints();
        gbc_lblBookContent.anchor = GridBagConstraints.EAST;
        gbc_lblBookContent.insets = new Insets(0, 0, 5, 5);
        gbc_lblBookContent.gridx = 0;
        gbc_lblBookContent.gridy = 11;
        getContentPane().add(lblBookContent, gbc_lblBookContent);
        lblBookContent.setVisible(false);
        
        txtBookContent = new JTextField();
        GridBagConstraints gbc_txtBookContent = new GridBagConstraints();
        gbc_txtBookContent.insets = new Insets(0, 0, 5, 0);
        gbc_txtBookContent.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtBookContent.gridx = 1;
        gbc_txtBookContent.gridy = 11;
        getContentPane().add(txtBookContent, gbc_txtBookContent);
        txtBookContent.setColumns(10);
        
        lblWarning = new JLabel("Please complete all the text fields!");
        GridBagConstraints gbc_lblWarning = new GridBagConstraints();
        gbc_lblWarning.insets = new Insets(0, 0, 5, 0);
        gbc_lblWarning.gridx = 1;
        gbc_lblWarning.gridy = 12;
        getContentPane().add(lblWarning, gbc_lblWarning);
        lblWarning.setVisible(false);
        
        JPanel pnlAddOrNotBtn = new JPanel();
        GridBagConstraints gbc_pnlAddOrNotBtn = new GridBagConstraints();
        gbc_pnlAddOrNotBtn.fill = GridBagConstraints.BOTH;
        gbc_pnlAddOrNotBtn.gridx = 1;
        gbc_pnlAddOrNotBtn.gridy = 13;
        getContentPane().add(pnlAddOrNotBtn, gbc_pnlAddOrNotBtn);
        pnlAddOrNotBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JButton btnAdd = new JButton("Add");
        pnlAddOrNotBtn.add(btnAdd);
        
        JButton btnCancel = new JButton("Cancel");
        pnlAddOrNotBtn.add(btnCancel);
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        txtBookContent.setVisible(false);
        
        // Add listener
        rdbtnDVD.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    lblDirector.setVisible(true);
                    txtDirector.setVisible(true);
                    lblLength.setVisible(true);
                    txtLength.setVisible(true);
                } else {
                    lblDirector.setVisible(false);
                    txtDirector.setVisible(false);
                    lblLength.setVisible(false);
                    txtLength.setVisible(false);
                }
            }
        });
        
        rdbtnCD.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    lblDirector.setVisible(true);
                    txtDirector.setVisible(true);
                    lblArtist.setVisible(true);
                    txtArtist.setVisible(true);
                    lblNumOfTrack.setVisible(true);
                    pnlAddTrack.setVisible(true);
                } else {
                    lblDirector.setVisible(false);
                    txtDirector.setVisible(false);
                    lblArtist.setVisible(false);
                    txtArtist.setVisible(false);
                    lblNumOfTrack.setVisible(false);
                    pnlAddTrack.setVisible(false);
                }
            }
        });
        
        rdbtnBook.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    lblAuthor.setVisible(true);
                    txtAuthor.setVisible(true);
                    lblBookContent.setVisible(true);
                    txtBookContent.setVisible(true);
                } else {
                    lblAuthor.setVisible(false);
                    txtAuthor.setVisible(false);
                    lblBookContent.setVisible(false);
                    txtBookContent.setVisible(false);
                }
            }
        });
        
        JFrame thisFrame = this;
        btnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thisFrame.dispose();
            }
        });
        
        btnAddTrack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // check empty field -> warning
                if (txtDirector.getText().isBlank() || txtArtist.getText().isBlank() || txtNumOfTrack.getText().isBlank()) {
                    warning(true, "Please complete all fields first!");
                    return;
                }
                // create new CD
                cd = new CompactDisc(Aims.getOrders().get(orderId).getItemsOrdered().size(),
                        txtTitle.getText(),
                        txtCategory.getText(),
                        txtDirector.getText(),
                        Float.parseFloat(txtCost.getText()),
                        txtArtist.getText());
                new Aims_gui_addTrack(cd, Integer.parseInt(txtNumOfTrack.getText())); // open Aims add track gui
                trackInputted = true;
            }
        });
        
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtTitle.getText().isBlank() || txtCategory.getText().isBlank() || txtCost.getText().isBlank()) {
                    warning(true, "Please complete all fields first!");
                    return;
                }
                if (rdbtnDVD.isSelected()) {
                    // check empty field -> warning
                    if (txtDirector.getText().isBlank() || txtLength.getText().isBlank()) {
                        warning(true, "Please complete all fields first!");
                        return;
                    }
                    // add DVD
                    DigitalVideoDisc dvd = new DigitalVideoDisc(Aims.getOrders().get(orderId).getItemsOrdered().size(),
                                                                txtTitle.getText(),
                                                                txtCategory.getText(),
                                                                txtDirector.getText(),
                                                                Float.parseFloat(txtCost.getText()),
                                                                Integer.parseInt(txtLength.getText()));
                     Aims.addItemToOrder(orderId, dvd);
                    // play after add
                    thisFrame.dispose();
                    new Aims_gui_afterAdd(false); // open after_add_gui
                } else if (rdbtnCD.isSelected()) {
                    // check empty field -> warning
                    if (txtDirector.getText().isBlank() || txtArtist.getText().isBlank() || txtNumOfTrack.getText().isBlank()) {
                        warning(true, "Please complete all fields first!");
                        return;
                    }
                    // check if track list is inputed
                    if (!trackInputted) {
                        warning(true, "Please input track(s)!");
                        return;
                    }
                    // add CD
                    Aims.addItemToOrder(orderId, cd);
                    // play after add
                    thisFrame.dispose();
                    new Aims_gui_afterAdd(false);
                } else { // rdbtnBook.isSelected()
                    // check empty field -> warning
                    if (txtAuthor.getText().isBlank() || txtBookContent.getText().isBlank()) {
                        warning(true, "Please complete all fields first!");
                        return;
                    }
                    // add Book
                    // authors name separated by ';'
                    List<String> authors = new ArrayList<String>();
                    String[] authorName = txtAuthor.getText().split(";");
                    for (int i = 0; i < authorName.length; i++) {
                        if (authors.contains(authorName[i].trim())) {
                            warning(true, "Author's name already exists");
                            return;
                        }
                        authors.add(authorName[i]);
                    }
                    Book book = new Book(Aims.getOrders().get(orderId).getItemsOrdered().size(),
                                        txtTitle.getText(),
                                        txtCategory.getText(),
                                        authors,
                                        Float.parseFloat(txtCost.getText()),
                                        txtBookContent.getText());
                    Aims.addItemToOrder(orderId, book);
                    // close frame
                    thisFrame.dispose();
                    new Aims_gui_afterAdd(true);
                }
            }
        });
        
        // Display the window 
        this.setBounds(300, 150, 450, 400);
        this.setVisible(true);
    }
    
    private void warning(boolean isVisible, String warningText) {
        lblWarning.setText(warningText);
        lblWarning.setVisible(isVisible);
    }
}
