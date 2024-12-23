import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class Main {

    static BankAccountList BAList = new BankAccountList(50);

    // for mainPage() method initialization
    static JFrame mainFrame;
    static JPanel companyPanel, buttonPanel;
    static JButton createButton, searchButton, displayButton, setInterestButton, exitButton;
    static JLabel symbol;

    // for createAccount() method initialization
    static JFrame createFrame;
    static JPanel leftPanel, rightPanel;
    static JTextField nameField, numberField, depositField;
    static JButton submitButton, backButton;
    static JLabel nameLabel, numberLabel, depositLabel, symbolLabel, titleLabel;

    // for class searchAccount method initialization
    static JFrame searchFrame, indexSearchFrame, nameSearchFrame, numberSearchFrame;
    static JPanel leftPanel2, rightPanel2;
    static JButton submitButton2, submitButton3, submitButton4, submitButton5, backButton2, backButton3, backButton3_2,
            backButton3_3;
    static JTextField searchIndexField, searchNameField, searchNumberField;
    static JLabel searchSymbolLabel, titleLabel2, labelIndex, labelName, labelNumber;
    static JRadioButton indexButton, nameButton, numberButton;
    static BankAccount2 acc;

    // for class accountProfile method initialization
    static JFrame profileFrame;
    static JDialog depositFrame, withdrawFrame, updateFrame, updateFrame2, updateFrame3, historyDialog;
    static JButton depositButton, withdrawButton, updateButton, closeButton, exitButton2, submitButton7, submitButton8,
            submitButton9, historyButton;
    static JPanel accInfoPanel, leftPanel3, rightPanel3, transactionsPanel;
    static JLabel accountSymbolLabel, headerLabel, contentLabel, amountLabel, headerTitle, currentLabel, newLabel,
            changeSymbol;
    static JTextField amountField, amountField2, newField1, newField2;
    static JCheckBox changeBox, changeBox2, changeBox3;

    // for displayAccounts() method initialization
    static JFrame displayFrame;
    static JLabel verticalLabel1;
    static JScrollPane scrollPane;
    static JPanel accountsPanel, contentPanel;
    static Border Border1, Border2;
    static JButton exitButton3;

    // for setInterest() method initialization
    static JDialog interestDialog;
    static JButton setButton, backButton4;
    static JTextField interestField;
    static JLabel interestLabel;

    // for class accountProfile method initialization

    public static void main(String[] marc) {

        BankAccount2.setInterestRate(10);

        BAList.loadUpCSV("backUpFile.csv");

        mainPage();
    }

    public static void mainPage() {

        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setSize(550, 550);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);
        mainFrame.setTitle("Home Page");
        mainFrame.addWindowListener(new MyWindowListener());
        mainFrame.setUndecorated(true);

        createButton = new JButton("Create Account");
        createButton.setBounds(85, 100, 150, 35);
        createButton.setFont(new Font("Montserrat", Font.PLAIN, 12));
        createButton.setFocusable(false);
        createButton.addActionListener(new MyActionListener());

        searchButton = new JButton("Search Account");
        searchButton.setBounds(85, 150, 150, 35);
        searchButton.setFont(new Font("Montserrat", Font.PLAIN, 12));
        searchButton.setFocusable(false);
        searchButton.addActionListener(new MyActionListener());

        displayButton = new JButton("Display All Account");
        displayButton.setBounds(85, 200, 150, 35);
        displayButton.setFont(new Font("Montserrat", Font.PLAIN, 12));
        displayButton.setFocusable(false);
        displayButton.addActionListener(new MyActionListener());

        setInterestButton = new JButton("Set Interest Rate");
        setInterestButton.setBounds(85, 250, 150, 35);
        setInterestButton.setFont(new Font("Montserrat", Font.PLAIN, 12));
        setInterestButton.setFocusable(false);
        setInterestButton.addActionListener(new MyActionListener());

        exitButton = new JButton("Exit");
        exitButton.setBounds(85, 300, 150, 35);
        exitButton.setFont(new Font("Montserrat", Font.PLAIN, 12));
        exitButton.setFocusable(false);
        exitButton.addActionListener(new MyActionListener());

        ImageIcon ginkouSymbol = new ImageIcon("GinkouSymbol.png");

        symbol = new JLabel();
        symbol.setIcon(ginkouSymbol);
        symbol.setBounds(12, 170, 200, 100);

        companyPanel = new JPanel();
        companyPanel.setBackground(new Color(38, 99, 232));
        companyPanel.setLayout(null);
        companyPanel.setBounds(0, 0, 220, 550);
        companyPanel.add(symbol);

        buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 223, 255));
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(220, 0, 330, 550);

        buttonPanel.add(createButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(setInterestButton);
        buttonPanel.add(exitButton);

        mainFrame.add(companyPanel);
        mainFrame.add(buttonPanel);
        mainFrame.setVisible(true);
    }

    public static void createAccount() {

        ImageIcon createSymbol = new ImageIcon("create.png");

        createFrame = new JFrame();
        createFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        createFrame.setResizable(false);
        createFrame.setSize(450, 450);
        createFrame.setLocationRelativeTo(null);
        createFrame.setLayout(null);

        nameLabel = new JLabel();
        nameLabel.setText("Account Name");
        nameLabel.setFont(new Font("Montserrat", Font.PLAIN, 12));
        nameLabel.setBounds(71, 125, 110, 10);

        nameField = new JTextField();
        nameField.setBounds(70, 140, 130, 30);
        nameField.setFont(new Font("Montserrat", Font.PLAIN, 13));
        nameField.setForeground(Color.green);
        nameField.setBackground(Color.black);
        nameField.setCaretColor(Color.white);

        numberLabel = new JLabel();
        numberLabel.setText("Account Number");
        numberLabel.setFont(new Font("Montserrat", Font.PLAIN, 12));
        numberLabel.setBounds(71, 185, 110, 10);

        numberField = new JTextField();
        numberField.setBounds(70, 200, 130, 30);
        numberField.setFont(new Font("Montserrat", Font.PLAIN, 13));
        numberField.setForeground(Color.green);
        numberField.setBackground(Color.black);
        numberField.setCaretColor(Color.white);

        depositLabel = new JLabel();
        depositLabel.setText("Initial Deposit");
        depositLabel.setFont(new Font("Montserrat", Font.PLAIN, 12));
        depositLabel.setBounds(71, 245, 110, 10);

        depositField = new JTextField();
        depositField.setBounds(70, 260, 130, 30);
        depositField.setFont(new Font("Montserrat", Font.PLAIN, 13));
        depositField.setForeground(Color.green);
        depositField.setBackground(Color.black);
        depositField.setCaretColor(Color.white);

        submitButton = new JButton("Submit");
        submitButton.setBounds(140, 320, 70, 25);
        submitButton.setFont(new Font("Montserrat", Font.PLAIN, 10));
        submitButton.setFocusable(false);
        submitButton.addActionListener(new MyActionListener());

        backButton = new JButton("Back");
        backButton.setBounds(60, 320, 70, 25);
        backButton.setFont(new Font("Montserrat", Font.PLAIN, 10));
        backButton.setFocusable(false);
        backButton.addActionListener(new MyActionListener());

        leftPanel = new JPanel();
        leftPanel.setBackground(new Color(38, 99, 232));
        leftPanel.setLayout(null);
        leftPanel.setBounds(0, 0, 175, 450);

        symbolLabel = new JLabel();
        symbolLabel.setIcon(createSymbol);
        symbolLabel.setBounds(10, 100, 175, 100);

        leftPanel.add(symbolLabel);

        titleLabel = new JLabel();
        titleLabel.setText("Create Account");
        titleLabel.setFont(new Font("Montserrat", Font.BOLD, 20));
        titleLabel.setBounds(65, 20, 150, 100);

        rightPanel = new JPanel();
        rightPanel.setBackground(new Color(255, 223, 255));
        rightPanel.setLayout(null);
        rightPanel.setBounds(175, 0, 275, 450);

        rightPanel.add(titleLabel);
        rightPanel.add(nameLabel);
        rightPanel.add(numberLabel);
        rightPanel.add(depositLabel);
        rightPanel.add(submitButton);
        rightPanel.add(nameField);
        rightPanel.add(numberField);
        rightPanel.add(depositField);
        rightPanel.add(backButton);

        createFrame.add(leftPanel);
        createFrame.add(rightPanel);
        createFrame.setVisible(true);
    }

    class searchAccount {

        public static void homeSearch() {

            ImageIcon searchIcon = new ImageIcon("search2.png");

            searchFrame = new JFrame("Search Account Page");
            searchFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            searchFrame.setResizable(false);
            searchFrame.setSize(450, 450);
            searchFrame.setLocationRelativeTo(null);
            searchFrame.setLayout(null);
            searchFrame.setUndecorated(true);

            leftPanel2 = new JPanel();
            leftPanel2.setBackground(new Color(38, 99, 232));
            leftPanel2.setLayout(null);
            leftPanel2.setBounds(0, 0, 175, 450);

            searchSymbolLabel = new JLabel();
            searchSymbolLabel.setIcon(searchIcon);
            searchSymbolLabel.setBounds(0, 75, 200, 200);

            leftPanel2.add(searchSymbolLabel);

            rightPanel2 = new JPanel();
            rightPanel2.setBackground(new Color(255, 223, 255));
            rightPanel2.setLayout(null);
            rightPanel2.setBounds(175, 0, 275, 450);

            indexButton = new JRadioButton("Index");
            indexButton.setFont(new Font("Montserrat", Font.PLAIN, 12));
            indexButton.setBackground(new Color(255, 223, 255));
            indexButton.setBounds(60, 140, 120, 30);
            indexButton.setFocusable(false);

            nameButton = new JRadioButton("Account Name");
            nameButton.setFont(new Font("Montserrat", Font.PLAIN, 12));
            nameButton.setBackground(new Color(255, 223, 255));
            nameButton.setBounds(60, 180, 120, 30);
            nameButton.setFocusable(false);

            numberButton = new JRadioButton("Account Number");
            numberButton.setFont(new Font("Montserrat", Font.PLAIN, 12));
            numberButton.setBackground(new Color(255, 223, 255));
            numberButton.setBounds(60, 220, 120, 30);
            numberButton.setFocusable(false);

            ButtonGroup searchButtons = new ButtonGroup();
            searchButtons.add(indexButton);
            searchButtons.add(nameButton);
            searchButtons.add(numberButton);

            titleLabel2 = new JLabel();
            titleLabel2.setText("Search Account By:");
            titleLabel2.setFont(new Font("Montserrat", Font.BOLD, 20));
            titleLabel2.setBounds(33, 35, 200, 100);

            submitButton2 = new JButton("Submit");
            submitButton2.setBounds(130, 270, 70, 25);
            submitButton2.setFont(new Font("Montserrat", Font.PLAIN, 10));
            submitButton2.setFocusable(false);
            submitButton2.addActionListener(new MyActionListener());

            backButton2 = new JButton("Back");
            backButton2.setBounds(50, 270, 70, 25);
            backButton2.setFont(new Font("Montserrat", Font.PLAIN, 10));
            backButton2.setFocusable(false);
            backButton2.addActionListener(new MyActionListener());

            rightPanel2.add(titleLabel2);
            rightPanel2.add(indexButton);
            rightPanel2.add(nameButton);
            rightPanel2.add(numberButton);
            rightPanel2.add(submitButton2);
            rightPanel2.add(backButton2);

            searchFrame.add(leftPanel2);
            searchFrame.add(rightPanel2);
            searchFrame.setVisible(true);
        }

        public static void searchByIndex() {

            ImageIcon searchIcon = new ImageIcon("search3.png");

            indexSearchFrame = new JFrame();
            indexSearchFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            indexSearchFrame.setLayout(null);
            indexSearchFrame.setResizable(false);
            indexSearchFrame.setSize(450, 450);
            indexSearchFrame.setLocationRelativeTo(null);
            indexSearchFrame.setUndecorated(true);

            leftPanel2 = new JPanel();
            leftPanel2.setBackground(new Color(38, 99, 232));
            leftPanel2.setLayout(null);
            leftPanel2.setBounds(0, 0, 175, 450);

            rightPanel2 = new JPanel();
            rightPanel2.setBackground(new Color(255, 223, 255));
            rightPanel2.setLayout(null);
            rightPanel2.setBounds(175, 0, 275, 450);

            searchSymbolLabel = new JLabel();
            searchSymbolLabel.setIcon(searchIcon);
            searchSymbolLabel.setBounds(0, 75, 200, 200);

            leftPanel2.add(searchSymbolLabel);

            labelIndex = new JLabel();
            labelIndex.setText("Index (e.g. 0, 1, 2)");
            labelIndex.setFont(new Font("Montserrat", Font.PLAIN, 12));
            labelIndex.setBounds(62, 160, 110, 10);

            searchIndexField = new JTextField();
            searchIndexField.setCaretColor(Color.white);
            searchIndexField.setBackground(Color.black);
            searchIndexField.setForeground(Color.green);
            searchIndexField.setFont(new Font("Montserrat", Font.PLAIN, 13));
            searchIndexField.setBounds(60, 175, 130, 30);

            titleLabel2 = new JLabel("<html>Search Account By: <br> <center>Index<center></html>");
            titleLabel2.setFont(new Font("Montserrat", Font.BOLD, 18));
            titleLabel2.setBounds(35, 45, 300, 60);

            submitButton3 = new JButton("Submit");
            submitButton3.setBounds(130, 230, 70, 25);
            submitButton3.setFont(new Font("Montserrat", Font.PLAIN, 10));
            submitButton3.setFocusable(false);
            submitButton3.addActionListener(new MyActionListener());

            backButton3 = new JButton("Back");
            backButton3.setBounds(50, 230, 70, 25);
            backButton3.setFont(new Font("Montserrat", Font.PLAIN, 10));
            backButton3.setFocusable(false);
            backButton3.addActionListener(new MyActionListener());

            rightPanel2.add(submitButton3);
            rightPanel2.add(titleLabel2);
            rightPanel2.add(labelIndex);
            rightPanel2.add(searchIndexField);
            rightPanel2.add(backButton3);

            indexSearchFrame.add(rightPanel2);
            indexSearchFrame.add(leftPanel2);
            indexSearchFrame.setVisible(true);
        }

        public static void searchByAccountName() {

            ImageIcon searchIcon = new ImageIcon("search5.png");

            nameSearchFrame = new JFrame();
            nameSearchFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            nameSearchFrame.setSize(450, 450);
            nameSearchFrame.setResizable(false);
            nameSearchFrame.setLayout(null);
            nameSearchFrame.setLocationRelativeTo(null);
            nameSearchFrame.setUndecorated(true);

            leftPanel2 = new JPanel();
            leftPanel2.setBackground(new Color(38, 99, 232));
            leftPanel2.setLayout(null);
            leftPanel2.setBounds(0, 0, 175, 450);

            rightPanel2 = new JPanel();
            rightPanel2.setBackground(new Color(255, 223, 255));
            rightPanel2.setLayout(null);
            rightPanel2.setBounds(175, 0, 275, 450);

            searchSymbolLabel = new JLabel();
            searchSymbolLabel.setIcon(searchIcon);
            searchSymbolLabel.setBounds(0, 75, 200, 200);

            leftPanel2.add(searchSymbolLabel);

            searchSymbolLabel = new JLabel();
            searchSymbolLabel.setIcon(searchIcon);
            searchSymbolLabel.setBounds(0, 75, 200, 200);

            leftPanel2.add(searchSymbolLabel);

            labelName = new JLabel();
            labelName.setText("Account Name (e.g. John)");
            labelName.setFont(new Font("Montserrat", Font.PLAIN, 10));
            labelName.setBounds(62, 160, 130, 10);

            searchNameField = new JTextField();
            searchNameField.setCaretColor(Color.white);
            searchNameField.setBackground(Color.black);
            searchNameField.setForeground(Color.green);
            searchNameField.setFont(new Font("Montserrat", Font.PLAIN, 13));
            searchNameField.setBounds(60, 175, 130, 30);

            titleLabel2 = new JLabel("<html>Search Account By: <br> <center>Account Name<center></html>");
            titleLabel2.setFont(new Font("Montserrat", Font.BOLD, 18));
            titleLabel2.setBounds(35, 45, 300, 60);

            submitButton4 = new JButton("Submit");
            submitButton4.setBounds(130, 230, 70, 25);
            submitButton4.setFont(new Font("Montserrat", Font.PLAIN, 10));
            submitButton4.setFocusable(false);
            submitButton4.addActionListener(new MyActionListener());

            backButton3_2 = new JButton("Back");
            backButton3_2.setBounds(50, 230, 70, 25);
            backButton3_2.setFont(new Font("Montserrat", Font.PLAIN, 10));
            backButton3_2.setFocusable(false);
            backButton3_2.addActionListener(new MyActionListener());

            rightPanel2.add(submitButton4);
            rightPanel2.add(titleLabel2);
            rightPanel2.add(labelName);
            rightPanel2.add(searchNameField);
            rightPanel2.add(backButton3_2);

            nameSearchFrame.add(rightPanel2);
            nameSearchFrame.add(leftPanel2);
            nameSearchFrame.setVisible(true);
        }

        public static void searchByAccountNumber() {

            ImageIcon searchIcon = new ImageIcon("search4.png");

            numberSearchFrame = new JFrame();
            numberSearchFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            numberSearchFrame.setSize(450, 450);
            numberSearchFrame.setResizable(false);
            numberSearchFrame.setLayout(null);
            numberSearchFrame.setLocationRelativeTo(null);
            numberSearchFrame.setUndecorated(true);

            leftPanel2 = new JPanel();
            leftPanel2.setBackground(new Color(38, 99, 232));
            leftPanel2.setLayout(null);
            leftPanel2.setBounds(0, 0, 175, 450);

            rightPanel2 = new JPanel();
            rightPanel2.setBackground(new Color(255, 223, 255));
            rightPanel2.setLayout(null);
            rightPanel2.setBounds(175, 0, 275, 450);

            searchSymbolLabel = new JLabel();
            searchSymbolLabel.setIcon(searchIcon);
            searchSymbolLabel.setBounds(0, 75, 200, 200);

            leftPanel2.add(searchSymbolLabel);

            searchSymbolLabel = new JLabel();
            searchSymbolLabel.setIcon(searchIcon);
            searchSymbolLabel.setBounds(0, 75, 200, 200);

            leftPanel2.add(searchSymbolLabel);

            labelNumber = new JLabel();
            labelNumber.setText("Account Number (e.g. 00000000)");
            labelNumber.setFont(new Font("Montserrat", Font.PLAIN, 10));
            labelNumber.setBounds(62, 160, 170, 10);

            searchNumberField = new JTextField();
            searchNumberField.setCaretColor(Color.white);
            searchNumberField.setBackground(Color.black);
            searchNumberField.setForeground(Color.green);
            searchNumberField.setFont(new Font("Montserrat", Font.PLAIN, 13));
            searchNumberField.setBounds(60, 175, 130, 30);

            titleLabel2 = new JLabel("<html>Search Account By: <br> <center>Index<center></html>");
            titleLabel2.setFont(new Font("Montserrat", Font.BOLD, 18));
            titleLabel2.setBounds(35, 45, 300, 60);

            submitButton5 = new JButton("Submit");
            submitButton5.setBounds(130, 230, 70, 25);
            submitButton5.setFont(new Font("Montserrat", Font.PLAIN, 10));
            submitButton5.setFocusable(false);
            submitButton5.addActionListener(new MyActionListener());

            backButton3_3 = new JButton("Back");
            backButton3_3.setBounds(50, 230, 70, 25);
            backButton3_3.setFont(new Font("Montserrat", Font.PLAIN, 10));
            backButton3_3.setFocusable(false);
            backButton3_3.addActionListener(new MyActionListener());

            rightPanel2.add(submitButton5);
            rightPanel2.add(titleLabel2);
            rightPanel2.add(labelNumber);
            rightPanel2.add(searchNumberField);
            rightPanel2.add(backButton3_3);

            numberSearchFrame.add(rightPanel2);
            numberSearchFrame.add(leftPanel2);
            numberSearchFrame.setVisible(true);
        }

    }

    class accountProfile {

        public static void homePage(BankAccount2 acc) {

            ImageIcon accountSymbol = new ImageIcon("account.png");
            Border border1 = BorderFactory.createLineBorder(Color.black, 2);

            profileFrame = new JFrame("Account Profile");
            profileFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            profileFrame.setSize(450, 450);
            profileFrame.setResizable(false);
            profileFrame.setLayout(null);
            profileFrame.setLocationRelativeTo(null);
            profileFrame.setUndecorated(true);

            leftPanel2 = new JPanel();
            leftPanel2.setBackground(new Color(38, 99, 232));
            leftPanel2.setLayout(null);
            leftPanel2.setBounds(0, 0, 175, 450);

            accountSymbolLabel = new JLabel();
            accountSymbolLabel.setIcon(accountSymbol);
            accountSymbolLabel.setBounds(0, 50, 200, 200);

            rightPanel2 = new JPanel();
            rightPanel2.setBackground(new Color(255, 223, 255));
            rightPanel2.setLayout(null);
            rightPanel2.setBounds(175, 0, 275, 450);

            headerLabel = new JLabel();
            headerLabel.setText("Account # " + BAList.accountIndex(acc));
            headerLabel.setVerticalAlignment(JLabel.CENTER);
            headerLabel.setHorizontalAlignment(JLabel.CENTER);
            headerLabel.setLayout(null);
            headerLabel.setBounds(0, 0, 200, 30);
            headerLabel.setBackground(new Color(239, 228, 205));
            headerLabel.setFont(new Font("Montserrat", Font.BOLD, 15));
            headerLabel.setBorder(border1);

            contentLabel = new JLabel();
            contentLabel.setText("<html><table>" +
                    "<tr><td><b>Account Name </b></td><td>: <u>" + acc.getAccountName() + "</u></td></tr>" +
                    "<tr><td><b>Account Number </b></td><td>: <u>" + acc.getAccountNumber() + "</u></td></tr>" +
                    "<tr><td><b>Current Balance </b></td><td>: <u>₱" + acc.getBalance() + "</u></td></tr>" +
                    "</table></html>");
            contentLabel.setLayout(null);
            contentLabel.setBounds(11, 30, 200, 90);
            contentLabel.setBackground(new Color(254, 254, 250));
            contentLabel.setFont(new Font("Montserrat", Font.PLAIN, 12));

            accInfoPanel = new JPanel();
            accInfoPanel.setBackground(new Color(252, 243, 211));
            accInfoPanel.setLayout(null);
            accInfoPanel.setBounds(32, 50, 200, 120);
            accInfoPanel.setBorder(border1);
            accInfoPanel.add(headerLabel);
            accInfoPanel.add(contentLabel);

            leftPanel2.add(accountSymbolLabel);

            depositButton = new JButton("Deposit");
            depositButton.setFocusable(false);
            depositButton.setFont(new Font("Montserrat", Font.PLAIN, 11));
            depositButton.setBounds(40, 200, 85, 25);
            depositButton.addActionListener(new MyActionListener());

            withdrawButton = new JButton("Withdraw");
            withdrawButton.setFocusable(false);
            withdrawButton.setFont(new Font("Montserrat", Font.PLAIN, 11));
            withdrawButton.setBounds(40, 240, 85, 25);
            withdrawButton.addActionListener(new MyActionListener());

            historyButton = new JButton("<html><center>Transaction<br>History<center></html>");
            historyButton.setFocusable(false);
            historyButton.setFont(new Font("Montserrat", Font.PLAIN, 10));
            historyButton.setBounds(40, 280, 85, 25);
            historyButton.addActionListener(new MyActionListener());

            updateButton = new JButton("Update");
            updateButton.setFocusable(false);
            updateButton.setFont(new Font("Montserrat", Font.PLAIN, 11));
            updateButton.setBounds(140, 200, 85, 25);
            updateButton.addActionListener(new MyActionListener());

            closeButton = new JButton("Close");
            closeButton.setFocusable(false);
            closeButton.setFont(new Font("Montserrat", Font.PLAIN, 11));
            closeButton.setBounds(140, 240, 85, 25);
            closeButton.addActionListener(new MyActionListener());

            exitButton2 = new JButton("Home");
            exitButton2.setFocusable(false);
            exitButton2.setFont(new Font("Montserrat", Font.PLAIN, 11));
            exitButton2.setBounds(140, 280, 85, 25);
            exitButton2.addActionListener(new MyActionListener());

            rightPanel2.add(accInfoPanel);
            rightPanel2.add(depositButton);
            rightPanel2.add(withdrawButton);
            rightPanel2.add(historyButton);
            rightPanel2.add(updateButton);
            rightPanel2.add(closeButton);
            rightPanel2.add(exitButton2);

            profileFrame.add(leftPanel2);
            profileFrame.add(rightPanel2);
            profileFrame.setVisible(true);
        }

        public static void depositPage() {

            depositFrame = new JDialog(profileFrame, "Deposit", true);
            depositFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            depositFrame.setSize(250, 250);
            depositFrame.setResizable(false);
            depositFrame.setLayout(null);
            depositFrame.setLocationRelativeTo(profileFrame);

            leftPanel3 = new JPanel();
            leftPanel3.setBackground(new Color(255, 223, 255));
            leftPanel3.setLayout(null);
            leftPanel3.setBounds(0, 0, 140, 250);

            rightPanel3 = new JPanel();
            rightPanel3.setBackground(new Color(38, 99, 232));
            rightPanel3.setLayout(null);
            rightPanel3.setBounds(140, 0, 110, 250);

            headerTitle = new JLabel("Deposit");
            headerTitle.setFont(new Font("Montserrat", Font.BOLD, 15));
            headerTitle.setBounds(35, 20, 60, 30);

            amountLabel = new JLabel("Enter Amount: ");
            amountLabel.setFont(new Font("Montserrat", Font.BOLD, 11));
            amountLabel.setBounds(8, 60, 90, 30);

            amountField = new JTextField();
            amountField.setCaretColor(Color.white);
            amountField.setBackground(Color.black);
            amountField.setForeground(Color.green);
            amountField.setFont(new Font("Montserrat", Font.PLAIN, 12));
            amountField.setBounds(5, 85, 100, 30);
            amountField.setToolTipText("<html><font color='red'> Enter desired amount </font></html>");

            submitButton7 = new JButton("Submit");
            submitButton7.setFont(new Font("Montserrat", Font.PLAIN, 9));
            submitButton7.setFocusable(false);
            submitButton7.setBounds(30, 130, 65, 20);
            submitButton7.addActionListener(new MyActionListener());

            leftPanel3.add(headerTitle);
            leftPanel3.add(amountLabel);
            leftPanel3.add(amountField);
            leftPanel3.add(submitButton7);

            depositFrame.add(leftPanel3);
            depositFrame.add(rightPanel3);
            depositFrame.setVisible(true);
        }

        public static void withdrawPage() {

            withdrawFrame = new JDialog(profileFrame, "Withdraw", true);
            withdrawFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            withdrawFrame.setSize(250, 250);
            withdrawFrame.setResizable(false);
            withdrawFrame.setLayout(null);
            withdrawFrame.setLocationRelativeTo(null);

            leftPanel3 = new JPanel();
            leftPanel3.setBackground(new Color(255, 223, 255));
            leftPanel3.setLayout(null);
            leftPanel3.setBounds(0, 0, 140, 250);

            rightPanel3 = new JPanel();
            rightPanel3.setBackground(new Color(38, 99, 232));
            rightPanel3.setLayout(null);
            rightPanel3.setBounds(140, 0, 110, 250);

            headerTitle = new JLabel("Withdraw");
            headerTitle.setFont(new Font("Montserrat", Font.BOLD, 15));
            headerTitle.setBounds(35, 20, 70, 30);

            amountLabel = new JLabel("Enter Amount: ");
            amountLabel.setFont(new Font("Montserrat", Font.BOLD, 11));
            amountLabel.setBounds(8, 60, 90, 30);

            amountField2 = new JTextField();
            amountField2.setCaretColor(Color.white);
            amountField2.setBackground(Color.black);
            amountField2.setForeground(Color.green);
            amountField2.setFont(new Font("Montserrat", Font.PLAIN, 12));
            amountField2.setBounds(5, 85, 110, 30);
            amountField2.setToolTipText("<html><font color='red'> Enter desired amount </font></html>");

            submitButton8 = new JButton("Submit");
            submitButton8.setFont(new Font("Montserrat", Font.PLAIN, 9));
            submitButton8.setFocusable(false);
            submitButton8.setBounds(30, 120, 65, 20);
            submitButton8.addActionListener(new MyActionListener());

            leftPanel3.add(headerTitle);
            leftPanel3.add(amountLabel);
            leftPanel3.add(amountField2);
            leftPanel3.add(submitButton8);

            withdrawFrame.add(leftPanel3);
            withdrawFrame.add(rightPanel3);
            withdrawFrame.setVisible(true);
        }

        public static void historyPage() {

            historyDialog = new JDialog(profileFrame, "Transaction History", true);
            historyDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            historyDialog.setSize(450, 450);
            historyDialog.setResizable(false);
            historyDialog.setLocation(800, 150);

            leftPanel2 = new JPanel();
            leftPanel2.setBackground(new Color(38, 99, 232));
            leftPanel2.setLayout(new BorderLayout());
            leftPanel2.setPreferredSize(new Dimension(175, 450));

            rightPanel2 = new JPanel();
            rightPanel2.setBackground(new Color(255, 223, 255));
            rightPanel2.setLayout(new BorderLayout());
            rightPanel2.setPreferredSize(new Dimension(250, 450));

            scrollPane = new JScrollPane();
            scrollPane.getViewport().setBackground(new Color(255, 223, 255));

            transactionsPanel = new JPanel();
            transactionsPanel.setLayout(new BoxLayout(transactionsPanel, BoxLayout.Y_AXIS));
            transactionsPanel.setBackground(new Color(255, 223, 255));
            transactionsPanel.setPreferredSize(new Dimension(175, Main.acc.getListSize() * 60));

            JLabel headerLabel = new JLabel();
            headerLabel.setText("<html><center>Transaction<br>History<center></html>");
            headerLabel.setVerticalAlignment(JLabel.CENTER);
            headerLabel.setHorizontalAlignment(JLabel.CENTER);
            headerLabel.setPreferredSize(new Dimension(250, 30));
            headerLabel.setBackground(new Color(239, 228, 205));
            headerLabel.setFont(new Font("Montserrat", Font.BOLD, 12));

            Border1 = BorderFactory.createLineBorder(Color.black, 2);
            Border2 = new EmptyBorder(0, 89, 0, 83);

            headerLabel.setOpaque(true);

            CompoundBorder compoundBorder = new CompoundBorder(Border1, Border2);
            headerLabel.setBorder(compoundBorder);

            transactionsPanel.add(headerLabel);

            JLabel headerLabel2 = new JLabel();
            headerLabel2.setText("<html><table>" +
                    "<tr><td><b>" + "Transaction" + "</td><td>:</td><td>" + "Amount" +
                    "</td><td>:</td><td>" + "Date" + "</b></td></tr>" +
                    "</table></html>");
            headerLabel2.setPreferredSize(new Dimension(250, 30));
            headerLabel2.setBackground(new Color(239, 228, 205));
            headerLabel2.setFont(new Font("Montserrat", Font.BOLD, 11));

            Border Border3 = BorderFactory.createLineBorder(Color.black, 2);
            Border Border4 = new EmptyBorder(0, 30, 0, 83);

            headerLabel2.setOpaque(true);

            CompoundBorder compoundBorder2 = new CompoundBorder(Border3, Border4);
            headerLabel2.setBorder(compoundBorder2);

            transactionsPanel.add(headerLabel2);

            for (Transaction log : acc.getList()) {

                if (log != null) {

                    JLabel contentLabel = new JLabel();
                    contentLabel.setText("<html><table>" +
                            "<tr><td style='width: 210px;'><center>" + log.getType()
                            + "</center></td><td style='width: 40px;'>:" +
                            "</td><td style='width: 40px;'><center>" + log.getAmount() +
                            "</center></td><td style='width: 20px;'>:</td><td style='width: 40px;'><center>"
                            + log.getTimeStamp()
                            + "</center></td></tr>" +
                            "</table></html>");
                    contentLabel.setPreferredSize(new Dimension(200, 150));
                    contentLabel.setBackground(new Color(254, 254, 250));
                    contentLabel.setFont(new Font("Montserrat", Font.PLAIN, 11));
                    contentLabel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
                    contentLabel.setOpaque(true);
                    transactionsPanel.add(contentLabel);
                }
            }

            scrollPane.setViewportView(transactionsPanel);

            rightPanel2.add(scrollPane, BorderLayout.CENTER);

            historyDialog.add(leftPanel2, BorderLayout.WEST);
            historyDialog.add(rightPanel2, BorderLayout.EAST);
            historyDialog.setVisible(true);
        }

        public static void updatePage() {

            ImageIcon change = new ImageIcon("change.png");

            updateFrame = new JDialog(profileFrame, "Update", true);
            updateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            updateFrame.setSize(450, 450);
            updateFrame.setResizable(false);
            updateFrame.setLayout(null);
            updateFrame.setLocation(800, 150);

            leftPanel2 = new JPanel();
            leftPanel2.setBackground(new Color(38, 99, 232));
            leftPanel2.setLayout(null);
            leftPanel2.setBounds(0, 0, 175, 450);
            leftPanel2.setLayout(null);

            changeSymbol = new JLabel();
            changeSymbol.setIcon(change);
            changeSymbol.setBounds(0, 50, 200, 200);

            leftPanel2.add(changeSymbol);

            rightPanel2 = new JPanel();
            rightPanel2.setBackground(new Color(255, 223, 255));
            rightPanel2.setLayout(null);
            rightPanel2.setBounds(175, 0, 275, 450);

            headerTitle = new JLabel();
            headerTitle.setText("Update");
            headerTitle.setFont(new Font("Montserrat", Font.BOLD, 23));
            headerTitle.setBounds(85, 20, 80, 80);

            currentLabel = new JLabel();
            currentLabel.setText("<html><table>" +
                    "<tr><td><b>Current Account Name </b></td><td>: <u>" + acc.getAccountName() + "</u></td></tr>" +
                    "<tr><td><b>Current Account Number </b></td><td>: <u>" + acc.getAccountNumber() + "<u></td></tr>" +
                    "</table></html>");
            currentLabel.setFont(new Font("Montserrat", Font.PLAIN, 12));
            currentLabel.setBounds(10, 80, 250, 100);

            newLabel = new JLabel();
            newLabel.setText("<html><table>" +
                    "<tr><td><b>New Account Name </b></td><td>:</td></tr>" +
                    "<tr><td><b>New Account Number </b></td><td>:<u></td></tr>" +
                    "</table></html>");
            newLabel.setFont(new Font("Montserrat", Font.PLAIN, 12));
            newLabel.setBounds(10, 140, 250, 100);

            newField1 = new JTextField();
            newField1.setCaretColor(Color.white);
            newField1.setForeground(Color.green);
            newField1.setBackground(Color.black);
            newField1.setFont(new Font("Montserrat", Font.PLAIN, 11));
            newField1.setBounds(160, 170, 75, 18);

            newField2 = new JTextField();
            newField2.setCaretColor(Color.white);
            newField2.setForeground(Color.green);
            newField2.setBackground(Color.black);
            newField2.setFont(new Font("Montserrat", Font.PLAIN, 11));
            newField2.setBounds(160, 195, 75, 18);

            submitButton9 = new JButton("Submit");
            submitButton9.setFont(new Font("Montserrat", Font.PLAIN, 10));
            submitButton9.setFocusable(false);
            submitButton9.setBounds(92, 250, 70, 22);
            submitButton9.addActionListener(new MyActionListener());

            changeBox = new JCheckBox();
            changeBox.setText("Account Name only");
            changeBox.setFont(new Font("Montserrat", Font.PLAIN, 10));
            changeBox.setBackground(new Color(255, 223, 255));
            changeBox.setFocusable(false);
            changeBox.setBounds(15, 300, 120, 30);
            changeBox.addActionListener(new SecondActionListener());

            changeBox2 = new JCheckBox();
            changeBox2.setText("Account Number only");
            changeBox2.setFont(new Font("Montserrat", Font.PLAIN, 10));
            changeBox2.setBackground(new Color(255, 223, 255));
            changeBox2.setFocusable(false);
            changeBox2.setBounds(15, 330, 140, 30);
            changeBox2.addActionListener(new SecondActionListener());

            changeBox3 = new JCheckBox();
            changeBox3.setText("Account Name and Number");
            changeBox3.setFont(new Font("Montserrat", Font.PLAIN, 10));
            changeBox3.setBackground(new Color(255, 223, 255));
            changeBox3.setFocusable(false);
            changeBox3.setBounds(15, 360, 180, 30);
            changeBox3.setSelected(true);
            changeBox3.addActionListener(new SecondActionListener());

            ButtonGroup group = new ButtonGroup();
            group.add(changeBox);
            group.add(changeBox2);
            group.add(changeBox3);

            rightPanel2.add(headerTitle);
            rightPanel2.add(currentLabel);
            rightPanel2.add(newLabel);
            rightPanel2.add(newField1);
            rightPanel2.add(newField2);
            rightPanel2.add(submitButton9);
            rightPanel2.add(changeBox);
            rightPanel2.add(changeBox2);
            rightPanel2.add(changeBox3);

            updateFrame.add(leftPanel2);
            updateFrame.add(rightPanel2);
            updateFrame.setVisible(true);
        }

        public static void updatePage2() {

            ImageIcon change = new ImageIcon("change.png");

            updateFrame2 = new JDialog(profileFrame, "Update", true);
            updateFrame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            updateFrame2.setSize(450, 450);
            updateFrame2.setResizable(false);
            updateFrame2.setLayout(null);
            updateFrame2.setLocation(800, 150);

            leftPanel2 = new JPanel();
            leftPanel2.setBackground(new Color(38, 99, 232));
            leftPanel2.setLayout(null);
            leftPanel2.setBounds(0, 0, 175, 450);
            leftPanel2.setLayout(null);

            changeSymbol = new JLabel();
            changeSymbol.setIcon(change);
            changeSymbol.setBounds(0, 50, 200, 200);

            leftPanel2.add(changeSymbol);

            rightPanel2 = new JPanel();
            rightPanel2.setBackground(new Color(255, 223, 255));
            rightPanel2.setLayout(null);
            rightPanel2.setBounds(175, 0, 275, 450);

            headerTitle = new JLabel();
            headerTitle.setText("Update");
            headerTitle.setFont(new Font("Montserrat", Font.BOLD, 23));
            headerTitle.setBounds(85, 20, 80, 80);

            currentLabel = new JLabel();
            currentLabel.setText("<html><table>" +
                    "<tr><td><b>Current Account Name </b></td><td>: <u>" + acc.getAccountName() + "</u></td></tr>" +
                    "<tr><td><b>Current Account Number </b></td><td>: <u>" + acc.getAccountNumber() + "<u></td></tr>" +
                    "</table></html>");
            currentLabel.setFont(new Font("Montserrat", Font.PLAIN, 12));
            currentLabel.setBounds(10, 80, 250, 100);

            newLabel = new JLabel();
            newLabel.setText("<html><table>" +
                    "<tr><td><b>New Account Name </b></td><td>:</td></tr>" +
                    "<tr><td><b>New Account Number </b></td><td>:<u></td></tr>" +
                    "</table></html>");
            newLabel.setFont(new Font("Montserrat", Font.PLAIN, 12));
            newLabel.setBounds(10, 140, 250, 100);

            newField1 = new JTextField();
            newField1.setCaretColor(Color.white);
            newField1.setForeground(Color.green);
            newField1.setBackground(Color.black);
            newField1.setFont(new Font("Montserrat", Font.PLAIN, 11));
            newField1.setBounds(160, 170, 75, 18);

            newField2 = new JTextField();
            newField2.setCaretColor(Color.white);
            newField2.setForeground(Color.green);
            newField2.setBackground(Color.black);
            newField2.setFont(new Font("Montserrat", Font.PLAIN, 11));
            newField2.setEditable(false);
            newField2.setBounds(160, 195, 75, 18);

            submitButton9 = new JButton("Submit");
            submitButton9.setFont(new Font("Montserrat", Font.PLAIN, 10));
            submitButton9.setFocusable(false);
            submitButton9.setBounds(92, 250, 70, 22);
            submitButton9.addActionListener(new MyActionListener());

            changeBox = new JCheckBox();
            changeBox.setText("Account Name only");
            changeBox.setFont(new Font("Montserrat", Font.PLAIN, 10));
            changeBox.setBackground(new Color(255, 223, 255));
            changeBox.setFocusable(false);
            changeBox.setSelected(true);
            changeBox.setBounds(15, 300, 120, 30);
            changeBox.addActionListener(new SecondActionListener());

            changeBox2 = new JCheckBox();
            changeBox2.setText("Account Number only");
            changeBox2.setFont(new Font("Montserrat", Font.PLAIN, 10));
            changeBox2.setBackground(new Color(255, 223, 255));
            changeBox2.setFocusable(false);
            changeBox2.setBounds(15, 330, 140, 30);
            changeBox2.addActionListener(new SecondActionListener());

            changeBox3 = new JCheckBox();
            changeBox3.setText("Account Name and Number");
            changeBox3.setFont(new Font("Montserrat", Font.PLAIN, 10));
            changeBox3.setBackground(new Color(255, 223, 255));
            changeBox3.setFocusable(false);
            changeBox3.setBounds(15, 360, 180, 30);
            changeBox3.addActionListener(new SecondActionListener());

            ButtonGroup group = new ButtonGroup();
            group.add(changeBox);
            group.add(changeBox2);
            group.add(changeBox3);

            rightPanel2.add(headerTitle);
            rightPanel2.add(currentLabel);
            rightPanel2.add(newLabel);
            rightPanel2.add(newField1);
            rightPanel2.add(newField2);
            rightPanel2.add(submitButton9);
            rightPanel2.add(changeBox);
            rightPanel2.add(changeBox2);
            rightPanel2.add(changeBox3);

            updateFrame2.add(leftPanel2);
            updateFrame2.add(rightPanel2);
            updateFrame2.setVisible(true);
        }

        public static void updatePage3() {

            ImageIcon change = new ImageIcon("change.png");

            updateFrame3 = new JDialog(profileFrame, "Update", true);
            updateFrame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            updateFrame3.setSize(450, 450);
            updateFrame3.setResizable(false);
            updateFrame3.setLayout(null);
            updateFrame3.setLocation(800, 150);

            leftPanel2 = new JPanel();
            leftPanel2.setBackground(new Color(38, 99, 232));
            leftPanel2.setLayout(null);
            leftPanel2.setBounds(0, 0, 175, 450);
            leftPanel2.setLayout(null);

            changeSymbol = new JLabel();
            changeSymbol.setIcon(change);
            changeSymbol.setBounds(0, 50, 200, 200);

            leftPanel2.add(changeSymbol);

            rightPanel2 = new JPanel();
            rightPanel2.setBackground(new Color(255, 223, 255));
            rightPanel2.setLayout(null);
            rightPanel2.setBounds(175, 0, 275, 450);

            headerTitle = new JLabel();
            headerTitle.setText("Update");
            headerTitle.setFont(new Font("Montserrat", Font.BOLD, 23));
            headerTitle.setBounds(85, 20, 80, 80);

            currentLabel = new JLabel();
            currentLabel.setText("<html><table>" +
                    "<tr><td><b>Current Account Name </b></td><td>: <u>" + acc.getAccountName() + "</u></td></tr>" +
                    "<tr><td><b>Current Account Number </b></td><td>: <u>" + acc.getAccountNumber() + "<u></td></tr>" +
                    "</table></html>");
            currentLabel.setFont(new Font("Montserrat", Font.PLAIN, 12));
            currentLabel.setBounds(10, 80, 250, 100);

            newLabel = new JLabel();
            newLabel.setText("<html><table>" +
                    "<tr><td><b>New Account Name </b></td><td>:</td></tr>" +
                    "<tr><td><b>New Account Number </b></td><td>:<u></td></tr>" +
                    "</table></html>");
            newLabel.setFont(new Font("Montserrat", Font.PLAIN, 12));
            newLabel.setBounds(10, 140, 250, 100);

            newField1 = new JTextField();
            newField1.setCaretColor(Color.white);
            newField1.setForeground(Color.green);
            newField1.setBackground(Color.black);
            newField1.setEditable(false);
            newField1.setFont(new Font("Montserrat", Font.PLAIN, 11));
            newField1.setBounds(160, 170, 75, 18);

            newField2 = new JTextField();
            newField2.setCaretColor(Color.white);
            newField2.setForeground(Color.green);
            newField2.setBackground(Color.black);
            newField2.setFont(new Font("Montserrat", Font.PLAIN, 11));
            newField2.setBounds(160, 195, 75, 18);

            submitButton9 = new JButton("Submit");
            submitButton9.setFont(new Font("Montserrat", Font.PLAIN, 10));
            submitButton9.setFocusable(false);
            submitButton9.setBounds(92, 250, 70, 22);
            submitButton9.addActionListener(new MyActionListener());

            changeBox = new JCheckBox();
            changeBox.setText("Account Name only");
            changeBox.setFont(new Font("Montserrat", Font.PLAIN, 10));
            changeBox.setBackground(new Color(255, 223, 255));
            changeBox.setFocusable(false);
            changeBox.setBounds(15, 300, 120, 30);
            changeBox.addActionListener(new SecondActionListener());

            changeBox2 = new JCheckBox();
            changeBox2.setText("Account Number only");
            changeBox2.setFont(new Font("Montserrat", Font.PLAIN, 10));
            changeBox2.setBackground(new Color(255, 223, 255));
            changeBox2.setFocusable(false);
            changeBox2.setSelected(true);
            changeBox2.setBounds(15, 330, 140, 30);
            changeBox2.addActionListener(new SecondActionListener());

            changeBox3 = new JCheckBox();
            changeBox3.setText("Account Name and Number");
            changeBox3.setFont(new Font("Montserrat", Font.PLAIN, 10));
            changeBox3.setBackground(new Color(255, 223, 255));
            changeBox3.setFocusable(false);
            changeBox3.setBounds(15, 360, 180, 30);
            changeBox3.addActionListener(new SecondActionListener());

            ButtonGroup group = new ButtonGroup();
            group.add(changeBox);
            group.add(changeBox2);
            group.add(changeBox3);

            rightPanel2.add(headerTitle);
            rightPanel2.add(currentLabel);
            rightPanel2.add(newLabel);
            rightPanel2.add(newField1);
            rightPanel2.add(newField2);
            rightPanel2.add(submitButton9);
            rightPanel2.add(changeBox);
            rightPanel2.add(changeBox2);
            rightPanel2.add(changeBox3);

            updateFrame3.add(leftPanel2);
            updateFrame3.add(rightPanel2);
            updateFrame3.setVisible(true);
        }

    }

    public static void displayAccounts() {

        displayFrame = new JFrame("Bank Account List");
        displayFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        displayFrame.setResizable(false);
        displayFrame.setSize(450, 450);
        displayFrame.setLocationRelativeTo(null);
        displayFrame.setUndecorated(true);

        leftPanel2 = new JPanel();
        leftPanel2.setBackground(new Color(38, 99, 232));
        leftPanel2.setLayout(new BorderLayout());
        leftPanel2.setPreferredSize(new Dimension(175, 450));

        rightPanel2 = new JPanel();
        rightPanel2.setBackground(new Color(255, 223, 255));
        rightPanel2.setLayout(new BorderLayout());
        rightPanel2.setPreferredSize(new Dimension(250, 450));

        contentPanel = new JPanel();
        contentPanel.setBackground(new Color(38, 99, 232));
        contentPanel.setLayout(null);
        contentPanel.setPreferredSize(new Dimension(175, 450));

        verticalLabel1 = new JLabel();
        verticalLabel1.setText("<html><center><b>Display<br>Accounts</b></center></html>");
        verticalLabel1.setFont(new Font("Montserrat", Font.BOLD, 26));
        verticalLabel1.setForeground(Color.white);
        verticalLabel1.setBounds(30, 80, 120, 100);

        exitButton3 = new JButton("Back");
        exitButton3.setFont(new Font("Montserrat", Font.PLAIN, 10));
        exitButton3.setFocusable(false);
        exitButton3.setBounds(50, 180, 70, 22);
        exitButton3.addActionListener(new MyActionListener());

        scrollPane = new JScrollPane();
        scrollPane.getViewport().setBackground(new Color(255, 223, 255));

        accountsPanel = new JPanel();
        accountsPanel.setLayout(new BoxLayout(accountsPanel, BoxLayout.Y_AXIS));
        accountsPanel.setBackground(new Color(255, 223, 255));
        accountsPanel.setPreferredSize(new Dimension(250, (24 * (Main.BAList.getList().length + 25))));

        for (BankAccount2 acc : Main.BAList.getList()) {

            if (acc != null) {

                JLabel headerLabel = new JLabel();
                headerLabel.setText("Account # " + BAList.accountIndex(acc));
                headerLabel.setVerticalAlignment(JLabel.CENTER);
                headerLabel.setHorizontalAlignment(JLabel.CENTER);
                headerLabel.setPreferredSize(new Dimension(250, 30));
                headerLabel.setBackground(new Color(239, 228, 205));
                headerLabel.setFont(new Font("Montserrat", Font.BOLD, 12));

                if (String.valueOf(BAList.accountIndex(acc)).length() == 1) {

                    Border1 = BorderFactory.createLineBorder(Color.black, 2);
                    Border2 = new EmptyBorder(0, 95, 0, 84);
                }

                else if (String.valueOf(BAList.accountIndex(acc)).length() == 2) {

                    Border1 = BorderFactory.createLineBorder(Color.black, 2);
                    Border2 = new EmptyBorder(0, 89, 0, 83);
                }

                headerLabel.setOpaque(true);

                CompoundBorder compoundBorder = new CompoundBorder(Border1, Border2);
                headerLabel.setBorder(compoundBorder);

                headerLabel.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseEntered(MouseEvent e) {

                        headerLabel.setBackground(Color.white);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                        headerLabel.setBackground(new Color(239, 228, 205));
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {

                        displayFrame.dispose();
                        Main.accountProfile.homePage(acc);
                    }
                });

                accountsPanel.add(headerLabel);

                JLabel contentLabel = new JLabel();
                contentLabel.setText("<html><table>" +
                        "<tr><td><b>Account Name </b></td><td>: <u>" + acc.getAccountName() + "</u></td></tr>" +
                        "<tr><td><b>Account Number </b></td><td>: <u>" + acc.getAccountNumber() + "</u></td></tr>" +
                        "<tr><td><b>Current Balance </b></td><td>: <u>₱" + acc.getBalance() + "</u></td></tr>" +
                        "</table></html>");
                contentLabel.setPreferredSize(new Dimension(200, 90));
                contentLabel.setBackground(new Color(254, 254, 250));
                contentLabel.setFont(new Font("Montserrat", Font.PLAIN, 11));
                contentLabel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
                contentLabel.setOpaque(true);
                accountsPanel.add(contentLabel);
            }
        }

        scrollPane.setViewportView(Main.accountsPanel);

        rightPanel2.add(scrollPane, BorderLayout.CENTER);

        contentPanel.add(verticalLabel1);
        contentPanel.add(exitButton3);

        leftPanel2.add(contentPanel, BorderLayout.CENTER);

        displayFrame.add(leftPanel2, BorderLayout.WEST);
        displayFrame.add(rightPanel2, BorderLayout.EAST);
        displayFrame.setVisible(true);
    }

    public static void setInterest() {

        interestDialog = new JDialog(Main.mainFrame, "Set Interest Rate", true);
        interestDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        interestDialog.setSize(250, 250);
        interestDialog.setResizable(false);
        interestDialog.setLocationRelativeTo(Main.mainFrame);

        leftPanel3 = new JPanel();
        leftPanel3.setBackground(new Color(255, 223, 255));
        leftPanel3.setLayout(null);
        leftPanel3.setBounds(0, 0, 140, 250);

        rightPanel3 = new JPanel();
        rightPanel3.setBackground(new Color(38, 99, 232));
        rightPanel3.setLayout(null);
        rightPanel3.setBounds(140, 0, 110, 250);

        interestField = new JTextField();
        interestField.setCaretColor(Color.white);
        interestField.setForeground(Color.green);
        interestField.setBackground(Color.black);
        interestField.setFont(new Font("Montserrat", Font.PLAIN, 11));
        interestField.setBounds(20, 80, 90, 20);

        interestLabel = new JLabel();
        interestLabel.setText("Interest Rate");
        interestLabel.setFont(new Font("Montserrat", Font.BOLD, 10));
        interestLabel.setBounds(25, 55, 75, 30);

        setButton = new JButton("Submit");
        setButton.setFont(new Font("Montserrat", Font.PLAIN, 9));
        setButton.setFocusable(false);
        setButton.setBounds(32, 120, 63, 22);
        setButton.addActionListener(new MyActionListener());

        backButton4 = new JButton("Back");
        backButton4.setFont(new Font("Montserrat", Font.PLAIN, 9));
        backButton4.setFocusable(false);
        backButton4.setBounds(32, 150, 63, 22);
        backButton4.addActionListener(new MyActionListener());

        leftPanel3.add(interestField);
        leftPanel3.add(interestLabel);
        leftPanel3.add(setButton);
        leftPanel3.add(backButton4);

        interestDialog.add(leftPanel3);
        interestDialog.add(rightPanel3);
        interestDialog.setVisible(true);
    }

}

class MyActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        // mainPage() listener

        if (e.getSource() == Main.createButton) {

            Main.mainFrame.dispose();
            Main.createAccount();
        }

        if (e.getSource() == Main.searchButton) {

            Main.mainFrame.dispose();
            Main.searchAccount.homeSearch();
        }

        if (e.getSource() == Main.displayButton) {

            Main.mainFrame.dispose();
            Main.displayAccounts();
        }

        if (e.getSource() == Main.setInterestButton) {

            Main.setInterest();
        }

        if (e.getSource() == Main.exitButton) {

            Main.BAList.backUpCSV("backUpFile.csv");
            Main.mainFrame.dispose();

        }

        // createAccount() listener

        if (e.getSource() == Main.submitButton) {

            String nameTemp = Main.nameField.getText();
            String numberTemp = Main.numberField.getText();
            String depositTemp = Main.depositField.getText();

            if (nameTemp.matches("\\d+") || nameTemp.equals("") ||
                    Main.BAList.compareAccountName(nameTemp) ||
                    numberTemp.matches("\\d+") || numberTemp.equals("") ||
                    !numberTemp.matches("^[0-9]\\d{7}$") ||
                    Main.BAList.compareAccountName(numberTemp) || depositTemp.equals("") ||
                    !depositTemp.matches("\\d+")) {

                if (nameTemp.matches("\\d+")) {

                    JOptionPane.showMessageDialog(null, "Account Name should only consist of letters!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);

                }

                else if (nameTemp.equals("")) {

                    JOptionPane.showMessageDialog(null, "Account Name cannot be empty!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (Main.BAList.compareAccountName(nameTemp)) {

                    JOptionPane.showMessageDialog(null, "An Account with the same name already exist!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (numberTemp.equals("") || numberTemp == null) {

                    JOptionPane.showMessageDialog(null, "Account Number cannot be empty!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (!numberTemp.matches("\\d+")) {

                    JOptionPane.showMessageDialog(null, "Account Number should only consist of numbers!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (!numberTemp.matches("^\\d{8}$")) {

                    JOptionPane.showMessageDialog(null, "Account Number should be exactly 8 numbers!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (Main.BAList.compareAccountName(numberTemp)) {

                    JOptionPane.showMessageDialog(null, "An Account with the same number already exist!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (depositTemp.equals("") || depositTemp.equals(null)) {

                    JOptionPane.showMessageDialog(null, "Initial Deposit cannot be empty!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (!depositTemp.matches("\\d+")) {

                    JOptionPane.showMessageDialog(null, "Initial Deposit should be a number!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else {

                    BankAccount2 newAccount = new BankAccount2(nameTemp, numberTemp);
                    newAccount.setBalance(Double.parseDouble(depositTemp));
                    Main.BAList.add(newAccount);

                    Transaction log = new Transaction("Open Account", String.valueOf(newAccount.getBalance()));
                    newAccount.addLog(log);

                    JOptionPane.showMessageDialog(null, "Account Successfully Created! ", "SUCCESS!!!",
                            JOptionPane.INFORMATION_MESSAGE);

                    Main.BAList.expandArray();

                    Main.createFrame.dispose();

                    Main.mainPage();
                }
            }
        }

        if (e.getSource() == Main.backButton) {

            Main.createFrame.dispose();
            Main.mainPage();
        }

        // class SearchAccount listener

        if (e.getSource() == Main.submitButton2) {

            if (Main.indexButton.isSelected()) {

                Main.searchFrame.dispose();
                Main.searchAccount.searchByIndex();
            }

            else if (Main.nameButton.isSelected()) {

                Main.searchFrame.dispose();
                Main.searchAccount.searchByAccountName();
            }

            else if (Main.numberButton.isSelected()) {

                Main.searchFrame.dispose();
                Main.searchAccount.searchByAccountNumber();
            }
        }

        if (e.getSource() == Main.backButton2) {

            Main.searchFrame.dispose();
            Main.mainPage();
        }

        if (e.getSource() == Main.submitButton3) {

            if (!Main.searchIndexField.getText().matches("\\d+")) {

                JOptionPane.showMessageDialog(null, "Index Field input should only be a number!", "ERROR!!!",
                        JOptionPane.ERROR_MESSAGE);
            }

            else if (Main.searchIndexField.getText().equals("") || Main.searchIndexField.getText().equals(null)) {

                JOptionPane.showMessageDialog(null, "Index Field cannot be empty!", "ERROR!!!",
                        JOptionPane.ERROR_MESSAGE);
            }

            else {

                Main.acc = Main.BAList.searchByIndex(Integer.parseInt(Main.searchIndexField.getText()));

                if (Main.acc == null) {

                    JOptionPane.showMessageDialog(null, "An Account placed in that index does not exist!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else {

                    Main.indexSearchFrame.dispose();
                    Main.accountProfile.homePage(Main.acc);
                }
            }
        }

        if (e.getSource() == Main.backButton3) {

            Main.indexSearchFrame.dispose();
            Main.searchAccount.homeSearch();
        }

        if (e.getSource() == Main.backButton3_2) {

            Main.nameSearchFrame.dispose();
            Main.searchAccount.homeSearch();
        }

        if (e.getSource() == Main.backButton3_3) {

            Main.numberSearchFrame.dispose();
            Main.searchAccount.homeSearch();
        }

        if (e.getSource() == Main.submitButton4) {

            if (Main.searchNameField.getText().matches("\\d+")) {

                JOptionPane.showMessageDialog(null, "Account Name should only consist of letters!", "ERROR!!!",
                        JOptionPane.ERROR_MESSAGE);
            }

            else if (Main.searchNameField.getText().equals("") || Main.searchNameField.getText().equals(null)) {

                JOptionPane.showMessageDialog(null, "Account Name Field cannot be empty!", "ERROR!!!",
                        JOptionPane.ERROR_MESSAGE);
            }

            else {

                Main.acc = Main.BAList.searchByAccountName(Main.searchNameField.getText());

                if (Main.acc != null) {

                    Main.nameSearchFrame.dispose();
                    Main.accountProfile.homePage(Main.acc);
                }

                else {

                    JOptionPane.showMessageDialog(null, "An Account with this Account Name do not exist!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if (e.getSource() == Main.submitButton5) {

            if (!Main.searchNumberField.getText().matches("\\d+")) {

                JOptionPane.showMessageDialog(null, "Account Number Field input should only be a number!", "ERROR!!!",
                        JOptionPane.ERROR_MESSAGE);
            }

            else if (Main.searchNumberField.getText().equals("") || Main.searchNumberField.getText().equals(null)) {

                JOptionPane.showMessageDialog(null, "Account Number Field cannot be empty!", "ERROR!!!",
                        JOptionPane.ERROR_MESSAGE);
            }

            else {

                Main.acc = Main.BAList.searchByAccountNumber(Main.searchNumberField.getText());

                if (Main.acc != null) {

                    Main.numberSearchFrame.dispose();
                    Main.accountProfile.homePage(Main.acc);
                }

                else {

                    JOptionPane.showMessageDialog(null, "An Account with this Account Number do not exist!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // class accountProfile method listener

        if (e.getSource() == Main.depositButton)

        {

            Main.accountProfile.depositPage();
        }

        if (e.getSource() == Main.withdrawButton) {

            Main.accountProfile.withdrawPage();
        }

        if (e.getSource() == Main.historyButton) {

            Main.accountProfile.historyPage();
        }

        if (e.getSource() == Main.updateButton) {

            Main.accountProfile.updatePage();
        }

        if (e.getSource() == Main.closeButton) {

            int result = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to close this account?",
                    "Delete Confirm",
                    JOptionPane.YES_NO_OPTION);

            switch (result) {

                case JOptionPane.YES_OPTION:

                    Main.BAList.delete(Main.acc);
                    Main.profileFrame.dispose();
                    Main.mainPage();
                    break;
            }
        }

        if (e.getSource() == Main.exitButton2) {

            Main.profileFrame.dispose();
            Main.mainPage();
        }

        if (e.getSource() == Main.submitButton7) {

            if (!Main.amountField.getText().matches("\\d+")) {

                JOptionPane.showMessageDialog(null, "Deposit Field should only consist of numbers!", "ERROR!!!",
                        JOptionPane.ERROR_MESSAGE);
            }

            else if (Main.amountField.getText().equals(null) || Main.amountField.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "Deposit Field cannot be empty!", "ERROR!!!",
                        JOptionPane.ERROR_MESSAGE);
            }

            else {

                double amount = Double.parseDouble(Main.amountField.getText());
                Main.acc.deposit(amount);

                JOptionPane.showMessageDialog(null, "Deposit Successful!", "SUCCESS!!!",
                        JOptionPane.INFORMATION_MESSAGE);

                if (Main.acc.getBalance() >= 1000) {

                    Main.acc.addInterest();

                    JOptionPane.showMessageDialog(null,
                            "Interest Earned ₱"
                                    + String.format("%.1f", Main.acc.getBalance() * BankAccount2.getInterestRate()),
                            "SUCCESS!!!",
                            JOptionPane.INFORMATION_MESSAGE);
                }

                Main.depositFrame.dispose();
                Main.profileFrame.dispose();
                Main.accountProfile.homePage(Main.acc);
            }
        }

        if (e.getSource() == Main.submitButton8) {

            if (!Main.amountField2.getText().matches("\\d+")) {

                JOptionPane.showMessageDialog(null, "Withdraw Field should only consist of numbers!", "ERROR!!!",
                        JOptionPane.ERROR_MESSAGE);
            }

            else if (Main.amountField2.getText().equals(null) || Main.amountField2.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "Withdraw Field cannot be empty!", "ERROR!!!",
                        JOptionPane.ERROR_MESSAGE);
            }

            else {

                double amount = Double.parseDouble(Main.amountField2.getText());

                if (Main.acc.withdraw(amount)) {

                    JOptionPane.showMessageDialog(null, "Withdraw Successful!", "SUCCESS!!!",
                            JOptionPane.INFORMATION_MESSAGE);

                    if (Main.acc.getBalance() >= 1000) {

                        Main.acc.addInterest();

                        JOptionPane.showMessageDialog(null,
                                "Interest Earned ₱"
                                        + String.format("%.1f", Main.acc.getBalance() * BankAccount2.getInterestRate()),
                                "SUCCESS!!!",
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                    Main.withdrawFrame.dispose();
                    Main.profileFrame.dispose();
                    Main.accountProfile.homePage(Main.acc);
                }

                else {

                    JOptionPane.showMessageDialog(null, "Insufficient Funds!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if (e.getSource() == Main.submitButton9) {

            if (Main.newField1.isEditable() && Main.newField2.isEditable()) {

                if (Main.newField1.getText().equals("") || Main.newField1.getText() == null) {

                    JOptionPane.showMessageDialog(null, "New Account Name cannot be empty!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (Main.newField1.getText().matches("\\d+")) {

                    JOptionPane.showMessageDialog(null, "New Account Name should only consist of letters!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (Main.newField1.getText().equals(Main.acc.getAccountName())) {

                    JOptionPane.showMessageDialog(null, "New Account Name cannot be the same with the current one!",
                            "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (Main.BAList.compareAccountName(Main.newField1.getText())) {

                    JOptionPane.showMessageDialog(null, "An Account with this Name already exist!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (Main.newField2.getText().equals("") || Main.newField2.getText() == null) {

                    JOptionPane.showMessageDialog(null, "New Account Number cannot be empty!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (!Main.newField2.getText().matches("\\d+")) {

                    JOptionPane.showMessageDialog(null, "New Account Number should only consist of numbers!",
                            "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (Main.newField2.getText().matches("^\\d{8}$")) {

                    JOptionPane.showMessageDialog(null, "New Account Number should be exactly 8 numbers!",
                            "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (Main.newField2.getText().equals(Main.acc.getAccountNumber())) {

                    JOptionPane.showMessageDialog(null, "New Account Number cannot be the same with the current one!",
                            "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (Main.BAList.compareAccountNumber(Main.newField2.getText())) {

                    JOptionPane.showMessageDialog(null, "An Account with this Number already exist!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else {

                    Main.acc.setAccountName(Main.newField1.getText());
                    Main.acc.setAccountNumber(Main.newField2.getText());

                    JOptionPane.showMessageDialog(null, "Account Update Successful!", "SUCCESS!!!",
                            JOptionPane.INFORMATION_MESSAGE);

                    if (Main.updateFrame != null) {

                        Main.updateFrame.dispose();
                    }

                    if (Main.updateFrame2 != null) {

                        Main.updateFrame2.dispose();
                    }

                    if (Main.updateFrame3 != null) {

                        Main.updateFrame3.dispose();
                    }

                    Main.profileFrame.dispose();
                    Main.accountProfile.homePage(Main.acc);
                }
            }

            else if (Main.newField1.isEditable()) {

                if (Main.newField1.getText().equals("") || Main.newField1.getText() == null) {

                    JOptionPane.showMessageDialog(null, "New Account Name cannot be empty!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (Main.newField1.getText().matches("\\d+")) {

                    JOptionPane.showMessageDialog(null, "New Account Name should only consist of letters!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (Main.newField1.getText().equals(Main.acc.getAccountName())) {

                    JOptionPane.showMessageDialog(null, "New Account Name cannot be the same with the current one!",
                            "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (Main.BAList.compareAccountName(Main.newField1.getText())) {

                    JOptionPane.showMessageDialog(null, "An Account with this Name already exist!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else {

                    Main.acc.setAccountName(Main.newField1.getText());

                    JOptionPane.showMessageDialog(null, "Account Update Successful!", "SUCCESS!!!",
                            JOptionPane.INFORMATION_MESSAGE);

                    if (Main.updateFrame != null) {

                        Main.updateFrame.dispose();
                    }

                    if (Main.updateFrame2 != null) {

                        Main.updateFrame2.dispose();
                    }

                    if (Main.updateFrame3 != null) {

                        Main.updateFrame3.dispose();
                    }

                    Main.profileFrame.dispose();
                    Main.accountProfile.homePage(Main.acc);
                }
            }

            else if (Main.newField2.isEditable()) {

                if (Main.newField2.getText().equals("") || Main.newField2.getText() == null) {

                    JOptionPane.showMessageDialog(null, "New Account Number cannot be empty!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (!Main.newField2.getText().matches("\\d+")) {

                    JOptionPane.showMessageDialog(null, "New Account Number should only consist of numbers!",
                            "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (Main.newField2.getText().matches("^\\d{8}$")) {

                    JOptionPane.showMessageDialog(null, "New Account Number should be exactly 8 numbers!",
                            "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (Main.newField2.getText().equals(Main.acc.getAccountNumber())) {

                    JOptionPane.showMessageDialog(null, "New Account Number cannot be the same with the current one!",
                            "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (Main.BAList.compareAccountNumber(Main.newField2.getText())) {

                    JOptionPane.showMessageDialog(null, "An Account with this Number already exist!", "ERROR!!!",
                            JOptionPane.ERROR_MESSAGE);
                }

                else {

                    Main.acc.setAccountNumber(Main.newField2.getText());

                    JOptionPane.showMessageDialog(null, "Account Update Successful!", "SUCCESS!!!",
                            JOptionPane.INFORMATION_MESSAGE);

                    if (Main.updateFrame != null) {

                        Main.updateFrame.dispose();
                    }

                    if (Main.updateFrame2 != null) {

                        Main.updateFrame2.dispose();
                    }

                    if (Main.updateFrame3 != null) {

                        Main.updateFrame3.dispose();
                    }

                    Main.profileFrame.dispose();
                    Main.accountProfile.homePage(Main.acc);
                }
            }
        }

        // displayAccount() method listener

        if (e.getSource() == Main.exitButton3) {

            Main.displayFrame.dispose();
            Main.mainPage();
        }

        // setInterest() method listener

        if (e.getSource() == Main.setButton) {

            if (Main.interestField.getText().equals("") || Main.interestField.getText() == null) {

                JOptionPane.showMessageDialog(null, "Interest Rate Field cannot be empty!",
                        "ERROR!!!",
                        JOptionPane.ERROR_MESSAGE);
            }

            else if (!Main.interestField.getText().matches("\\d+")) {

                JOptionPane.showMessageDialog(null, "Interest Rate should only consist of one number!",
                        "ERROR!!!",
                        JOptionPane.ERROR_MESSAGE);
            }

            else {

                BankAccount2.setInterestRate(Double.parseDouble(Main.interestField.getText()));

                JOptionPane.showMessageDialog(null, "Setting Interest Rate Successful!", "SUCCESS!!!",
                        JOptionPane.INFORMATION_MESSAGE);

                Main.interestDialog.dispose();
            }
        }

        if (e.getSource() == Main.backButton4) {

            Main.interestDialog.dispose();
            Main.mainPage();
        }
    }
}

class SecondActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        if (Main.changeBox.isSelected()) {

            if (Main.updateFrame != null) {

                Main.updateFrame.dispose();
            }

            if (Main.updateFrame2 != null) {

                Main.updateFrame2.dispose();
            }

            if (Main.updateFrame3 != null) {

                Main.updateFrame3.dispose();
            }

            Main.accountProfile.updatePage2();
        }

        else if (Main.changeBox2.isSelected()) {

            if (Main.updateFrame != null) {

                Main.updateFrame.dispose();
            }

            if (Main.updateFrame2 != null) {

                Main.updateFrame2.dispose();
            }

            if (Main.updateFrame3 != null) {

                Main.updateFrame3.dispose();
            }

            Main.accountProfile.updatePage3();
        }

        else if (Main.changeBox3.isSelected()) {

            if (Main.updateFrame != null) {

                Main.updateFrame.dispose();
            }

            if (Main.updateFrame2 != null) {

                Main.updateFrame2.dispose();
            }

            if (Main.updateFrame3 != null) {

                Main.updateFrame3.dispose();
            }

            Main.accountProfile.updatePage();
        }
    }
}

class MyWindowListener extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent e) {

        Main.BAList.backUpCSV("backUpFile.csv");
    }
}