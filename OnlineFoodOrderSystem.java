import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class OnlineFoodOrderSystem extends JFrame implements ActionListener ,Runnable {
    private CardLayout cardLayout;
    private JPanel cards;
    private JTextField nameField, phoneNumberField, addressField, emailField;
    public Font tf,lf,txf;
    Color panelColor ;
    ImageIcon veg,nveg,Fastfood,jui,Icecream,Sweet,greenIcon,anim,payment;
    JButton nextButton,vegb,nvegb,Fastfoodb,juib,Icecreamb,Sweetb,confirmPaymentButton;
    JButton vegb1,vegb2,vegb3,vegb4,vegb5,vegb6;
    JButton nvegb1,nvegb2,nvegb3,nvegb4,nvegb5,nvegb6;
    JButton Fastfoodb1,Fastfoodb2,Fastfoodb3,Fastfoodb4,Fastfoodb5,Fastfoodb6;
    JButton juiceb1,juiceb2,juiceb3,juiceb4,juiceb5,juiceb6;
    JButton Icecreamb1,Icecreamb2,Icecreamb3,Icecreamb4,Icecreamb5,Icecreamb6;
    JButton Sweetb1,Sweetb2,Sweetb3,Sweetb4,Sweetb5,Sweetb6;
    JLabel imgl;
    JCheckBox vegcb1,vegcb2,vegcb3,vegcb4,vegcb5,vegcb6,nvegcb1,nvegcb2,nvegcb3,nvegcb4,nvegcb5,nvegcb6,
            ffcb1,ffcb2,ffcb3,ffcb4,ffcb5,ffcb6,juicecb1,juicecb2,juicecb3,juicecb4,juicecb5,juicecb6,
            icecreamcb1,icecreamcb2,icecreamcb3,icecreamcb4,icecreamcb5,icecreamcb6,
            sweetcb1,sweetcb2,sweetcb3,sweetcb4,sweetcb5,sweetcb6;
    JLabel vegprice1,vegprice2,vegprice3,vegprice4,vegprice5,vegprice6,nvegprice1,nvegprice2,nvegprice3,nvegprice4,nvegprice5,nvegprice6,
            ffprice1,ffprice2,ffprice3,ffprice4,ffprice5,ffprice6,juiceprice1,juiceprice2,juiceprice3,juiceprice4,juiceprice5,juiceprice6,
            icecreamprice1,icecreamprice2,icecreamprice3,icecreamprice4,icecreamprice5,icecreamprice6,
            sweetprice1,sweetprice2,sweetprice3,sweetprice4,sweetprice5,sweetprice6,paymentl;

    ImageIcon veg1,veg2,veg3,veg4,veg5,veg6,nveg1,nveg2,nveg3,nveg4,nveg5,nveg6,
            ff1,ff2,ff3,ff4,ff5,ff6,juice1,juice2,juice3,juice4,juice5,juice6,
            icecream1,icecream2,icecream3,icecream4,icecream5,icecream6,
            sweet1,sweet2,sweet3,sweet4,sweet5,sweet6;
    JMenuBar menuBar;
    JMenu fileMenu;

    JMenuItem vegcateg,nvegcateg,ffcateg,juicecateg,icecreamcateg,sweetcateg;

    JButton backButton1,confirmButton1,backButton2,confirmButton2,backButton3,confirmButton3,backButton4,confirmButton4,backButton5,confirmButton5,backButton6,confirmButton6;
    JTextArea disp1,disp2,disp3,disp4,disp5,disp6,paymentdetails;
    JSpinner veg1q,veg2q,veg3q,veg4q,veg5q,veg6q,nveg1q,nveg2q,nveg3q,nveg4q,nveg5q,nveg6q,
            ff1q,ff2q,ff3q,ff4q,ff5q,ff6q,juice1q,juice2q,juice3q,juice4q,juice5q,juice6q,
            icecream1q,icecream2q,icecream3q,icecream4q,icecream5q,icecream6q,
            sweet1q,sweet2q,sweet3q,sweet4q,sweet5q,sweet6q;
    int vegp1,vegp2,vegp3,vegp4,vegp5,vegp6,nvegp1,nvegp2,nvegp3,nvegp4,nvegp5,nvegp6,ffp1,ffp2,ffp3,ffp4,ffp5,ffp6,
            juicep1,juicep2,juicep3,juicep4,juicep5,juicep6,icecreamp1,icecreamp2,icecreamp3,icecreamp4,icecreamp5,icecreamp6,
            sweetp1,sweetp2,sweetp3,sweetp4,sweetp5,sweetp6;

    // You can add more fields for menu items and payment details as needed

    public OnlineFoodOrderSystem() {
        setTitle("7th Table Food Order System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tf = new Font("arial", Font.BOLD, 25);
        lf =new  Font("arial", Font.PLAIN, 20);
        txf =new  Font("arial", Font.PLAIN, 16);
        panelColor = new Color(53, 59, 72);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        JPanel userDetailsPanel = createUserDetailsPanel();
        JPanel menuPanel = createMenuPanel();
        JPanel vegPanel = createVegPanel();
        JPanel nvegPanel = createNVegPanel();
        JPanel FastfoodPanel = createFastfoodPanel();
        JPanel juicePanel = createJuicePanel();
        JPanel IcecreamPanel = createIcecreamPanel();
        JPanel snakePanel = createSweetPanel();
        JPanel paymentPanel = createPaymentPanel();

        cards.add(userDetailsPanel, "UserDetails");
        cards.add(menuPanel, "Menu");
        cards.add(vegPanel, "VegPanel");
        cards.add(nvegPanel, "NVegPanel");
        cards.add(FastfoodPanel, "FastfoodPanel");
        cards.add(juicePanel, "JuicePanel");
        cards.add(IcecreamPanel, "IcecreamPanel");
        cards.add(snakePanel, "SweetPanel");
        cards.add(paymentPanel, "Payment");

        menuBar = new JMenuBar();
        fileMenu = new JMenu("Categories");
        vegcateg = new JMenuItem("VEG");
        nvegcateg = new JMenuItem("NON VEG");
        ffcateg = new JMenuItem("FAST FOOD");
        juicecateg = new JMenuItem("JUICE");
        icecreamcateg = new JMenuItem("ICECREAM");
        sweetcateg = new JMenuItem("SWEETS");

        vegcateg.addActionListener(this);
        nvegcateg.addActionListener(this);
        ffcateg.addActionListener(this);
        juicecateg.addActionListener(this);
        icecreamcateg.addActionListener(this);
        sweetcateg.addActionListener(this);

        fileMenu.add(vegcateg);
        fileMenu.add(nvegcateg);
        fileMenu.add(ffcateg);
        fileMenu.add(juicecateg);
        fileMenu.add(icecreamcateg);
        fileMenu.add(sweetcateg);
        menuBar.add(fileMenu);

        greenIcon = new ImageIcon("D:\\Food Images\\checkmark.png");
        Image resizedImage = greenIcon.getImage();
        resizedImage = resizedImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Adjust the width and height as needed
        greenIcon = new ImageIcon(resizedImage);

        add(cards);
        setVisible(true);
    }


    private JPanel createUserDetailsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        ImageIcon bg = new ImageIcon("D:\\Food Images\\menucard.jpg");
        Image img1 = bg.getImage();
        img1= img1.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        bg = new ImageIcon(img1);
        JLabel l=new JLabel(bg);
        l.setBounds(0,0,900,600);


        JLabel nameLabel = new JLabel("Name : ");
        nameLabel.setBounds(200,100,100,30);
        nameLabel.setFont(lf);
        nameLabel.setForeground(Color.WHITE);

        nameField = new JTextField();
        nameField.setFont(txf);
        nameField.setBounds(350,100,300,30);

        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberLabel.setBounds(200,150,150,30);
        phoneNumberLabel.setFont(lf);
        phoneNumberLabel.setForeground(Color.WHITE);

        phoneNumberField = new JTextField();
        phoneNumberField.setFont(txf);
        phoneNumberField.setBounds(350,150,300,30);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(200,200,150,30);
        addressLabel.setFont(lf);
        addressLabel.setForeground(Color.WHITE);

        addressField = new JTextField();
        addressField.setFont(txf);
        addressField.setBounds(350,200,300,30);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(200,250,150,30);
        emailLabel.setFont(lf);
        emailLabel.setForeground(Color.WHITE);

        emailField = new JTextField();
        emailField.setFont(txf);
        emailField.setBounds(350,250, 300, 30);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(phoneNumberLabel);
        panel.add(phoneNumberField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(emailLabel);
        panel.add(emailField);

        nextButton = new JButton("Next");
        nextButton.setBounds(400,350,150,30);
        nextButton.setBackground(Color.BLUE);
        nextButton.setForeground(Color.WHITE);
        nextButton.addActionListener(this);

        panel.add(new JLabel());
        panel.add(nextButton);

        panel.add(l);
        return panel;
    }

    private JPanel createMenuPanel() {
        JPanel panel = new JPanel(null);
        panel.setBackground(panelColor);

        veg = new ImageIcon("D:\\Food Images\\veg.jpg");
        Image img1 = veg.getImage();
        img1= img1.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        veg = new ImageIcon(img1);
        vegb = new JButton(veg);
        vegb.addActionListener(this);
        vegb.setBounds(50, 20, 180, 180);
        JLabel l1=new JLabel("Vegetarian");
        l1.setFont(lf);
        l1.setForeground(Color.WHITE);
        l1.setBounds(90,210,100,20);

        nveg = new ImageIcon("D:\\Food Images\\nveg.jpg");
        Image img2 = nveg.getImage();
        img2= img2.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        nveg = new ImageIcon(img2);
        nvegb = new JButton(nveg);
        nvegb.addActionListener(this);
        nvegb.setBounds(250, 20, 180, 180);
        JLabel l2=new JLabel("Non Vegetarian");
        l2.setFont(lf);
        l2.setForeground(Color.WHITE);
        l2.setBounds(270,210,150,20);

        Fastfood = new ImageIcon("D:\\Food Images\\fastfood.jpeg");
        Image img3 = Fastfood.getImage();
        img3= img3.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        Fastfood = new ImageIcon(img3);
        Fastfoodb = new JButton(Fastfood);
        Fastfoodb.addActionListener(this);
        Fastfoodb.setBounds(450, 20, 180, 180);
        JLabel l3=new JLabel("Fastfood");
        l3.setFont(lf);
        l3.setForeground(Color.WHITE);
        l3.setBounds(500,210,100,20);

        jui = new ImageIcon("D:\\Food Images\\juice.jpg");
        Image img4 = jui.getImage();
        img4= img4.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        jui = new ImageIcon(img4);
        juib = new JButton(jui);
        juib.addActionListener(this);
        juib.setBounds(50, 280, 180, 180);
        JLabel l4=new JLabel("Juices");
        l4.setFont(lf);
        l4.setForeground(Color.WHITE);
        l4.setBounds(110,470,100,20);

        Icecream = new ImageIcon("D:\\Food Images\\icecream.jpg");
        Image img5 = Icecream.getImage();
        img5= img5.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        Icecream = new ImageIcon(img5);
        Icecreamb = new JButton(Icecream);
        Icecreamb.addActionListener(this);
        Icecreamb.setBounds(250, 280, 180, 180);
        JLabel l5=new JLabel("Icecream");
        l5.setFont(lf);
        l5.setForeground(Color.WHITE);
        l5.setBounds(290,470,100,20);

        Sweet = new ImageIcon("D:\\Food Images\\sweet.jpg");
        Image img6 = Sweet.getImage();
        img6= img6.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        Sweet = new ImageIcon(img6);
        Sweetb = new JButton(Sweet);
        Sweetb.addActionListener(this);
        Sweetb.setBounds(450, 280, 180, 180);
        JLabel l6=new JLabel("Sweets");
        l6.setFont(lf);
        l6.setForeground(Color.WHITE);
        l6.setBounds(510,470,100,20);

        anim = new ImageIcon("D:\\Food Images\\anim.jpg");
        Image img7 = anim.getImage();
        img7= img7.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        anim = new ImageIcon(img7);
        imgl=new JLabel(anim);

        JLabel l=new JLabel("Top Selling Foods");
        l.setBounds(670,30,200,20);
        l.setFont(lf);
        l.setForeground(Color.WHITE);



        panel.add(vegb);
        panel.add(nvegb);
        panel.add(Fastfoodb);
        panel.add(juib);
        panel.add(Icecreamb);
        panel.add(Sweetb);
        panel.add(imgl);
        panel.add(l);

        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);
        panel.add(l5);
        panel.add(l6);

        return panel;
    }

    private JPanel createVegPanel() {
        JPanel panel = new JPanel(null);
        panel.setBackground(panelColor);

        veg1 = new ImageIcon("D:\\Food Images\\idly.jpg");
        Image img1 = veg1.getImage();
        img1= img1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        veg1 = new ImageIcon(img1);
        vegb1 = new JButton(veg1);
        vegb1.addActionListener(this);
        vegb1.setBounds(50, 20, 150, 150);
        vegcb1=new JCheckBox("IDLI");
        vegcb1.setBounds(100,175,50,20);
        vegcb1.setBackground(panelColor);
        vegcb1.setForeground(Color.WHITE);
        vegprice1=new JLabel("Price : $10");
        vegprice1.setBounds(75,200,150,20);
        vegprice1.setFont(lf);
        vegprice1.setForeground(Color.WHITE);
        JLabel l1=new JLabel("Quantity :");
        l1.setBounds(50,230,100,20);
        l1.setFont(lf);
        l1.setForeground(Color.WHITE);
        veg1q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        veg1q.setBounds(150,230,40,20);

        veg2 = new ImageIcon("D:\\Food Images\\dosai.jpg");
        Image img2 = veg2.getImage();
        img2= img2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        veg2 = new ImageIcon(img2);
        vegb2 = new JButton(veg2);
        vegb2.addActionListener(this);
        vegb2.setBounds(250, 20, 150, 150);
        vegcb2=new JCheckBox("DOSA");
        vegcb2.setBounds(300,175,150,20);
        vegcb2.setBackground(panelColor);
        vegcb2.setForeground(Color.WHITE);
        vegprice2=new JLabel("Price : $30");
        vegprice2.setBounds(275,200,150,20);
        vegprice2.setFont(lf);
        vegprice2.setForeground(Color.WHITE);
        JLabel l2=new JLabel("Quantity :");
        l2.setBounds(250,230,100,20);
        l2.setFont(lf);
        l2.setForeground(Color.WHITE);
        veg2q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        veg2q.setBounds(350,230,40,20);

        veg3 = new ImageIcon("D:\\Food Images\\parotta.png");
        Image img3 = veg3.getImage();
        img3= img3.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        veg3 = new ImageIcon(img3);
        vegb3 = new JButton(veg3);
        vegb3.addActionListener(this);
        vegb3.setBounds(450, 20, 150, 150);
        vegcb3=new JCheckBox("PAROTTA");
        vegcb3.setBounds(490,175,140,20);
        vegcb3.setBackground(panelColor);
        vegcb3.setForeground(Color.WHITE);
        vegprice3=new JLabel("Price : $20");
        vegprice3.setBounds(475,200,150,20);
        vegprice3.setFont(lf);
        vegprice3.setForeground(Color.WHITE);
        JLabel l3=new JLabel("Quantity :");
        l3.setBounds(450,230,100,20);
        l3.setFont(lf);
        l3.setForeground(Color.WHITE);
        veg3q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        veg3q.setBounds(550,230,40,20);

        veg4 = new ImageIcon("D:\\Food Images\\butter naan.jpg");
        Image img4 = veg4.getImage();
        img4= img4.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        veg4 = new ImageIcon(img4);
        vegb4 = new JButton(veg4);
        vegb4.addActionListener(this);
        vegb4.setBounds(50, 290, 150, 150);
        vegcb4=new JCheckBox("BUTTER NAAN");
        vegcb4.setBounds(70,445,150,20);
        vegcb4.setBackground(panelColor);
        vegcb4.setForeground(Color.WHITE);
        vegprice4=new JLabel("Price : $30");
        vegprice4.setBounds(75,470,150,20);
        vegprice4.setFont(lf);
        vegprice4.setForeground(Color.WHITE);
        JLabel l4=new JLabel("Quantity :");
        l4.setBounds(50,500,100,20);
        l4.setFont(lf);
        l4.setForeground(Color.WHITE);
        veg4q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        veg4q.setBounds(150,500,40,20);


        veg5 = new ImageIcon("D:\\Food Images\\paneer butter masala.jpg");
        Image img5 = veg5.getImage();
        img5= img5.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        veg5 = new ImageIcon(img5);
        vegb5 = new JButton(veg5);
        vegb5.addActionListener(this);
        vegb5.setBounds(250, 290, 150, 150);
        vegcb5=new JCheckBox("PANEER BUTTER MASALA");
        vegcb5.setBounds(240,445,180,20);
        vegcb5.setBackground(panelColor);
        vegcb5.setForeground(Color.WHITE);
        vegprice5=new JLabel("Price : $70");
        vegprice5.setBounds(275,470,150,20);
        vegprice5.setFont(lf);
        vegprice5.setForeground(Color.WHITE);
        JLabel l5=new JLabel("Quantity :");
        l5.setBounds(250,500,100,20);
        l5.setFont(lf);
        l5.setForeground(Color.WHITE);
        veg5q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        veg5q.setBounds(350,500,40,20);

        veg6 = new ImageIcon("D:\\Food Images\\noodles.jpg");
        Image img6 = veg6.getImage();
        img6= img6.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        veg6 = new ImageIcon(img6);
        vegb6 = new JButton(veg6);
        vegb6.addActionListener(this);
        vegb6.setBounds(450, 290, 150, 150);
        vegcb6=new JCheckBox("PANEER NOODLES");
        vegcb6.setBounds(460,445,150,20);
        vegcb6.setBackground(panelColor);
        vegcb6.setForeground(Color.WHITE);
        vegprice6=new JLabel("Price : $100");
        vegprice6.setBounds(475,470,150,20);
        vegprice6.setFont(lf);
        vegprice6.setForeground(Color.WHITE);
        JLabel l6=new JLabel("Quantity :");
        l6.setBounds(450,500,100,20);
        l6.setFont(lf);
        l6.setForeground(Color.WHITE);
        veg6q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        veg6q.setBounds(550,500,40,20);

        backButton1=new JButton("Go to MenuCard");
        backButton1.setBounds(650,400,190,40);
        backButton1.setFont(txf);
        backButton1.setBackground(Color.BLUE);
        backButton1.setForeground(Color.WHITE);
        backButton1.addActionListener(this);

        confirmButton1=new JButton("Confirm");
        confirmButton1.setBounds(650,450,190,40);
        confirmButton1.setFont(txf);
        confirmButton1.setBackground(Color.BLUE);
        confirmButton1.setForeground(Color.WHITE);
        confirmButton1.addActionListener(this);

        disp1=new JTextArea();
        disp1.setForeground(Color.WHITE);
        disp1.setBackground(panelColor);
        disp1.setFont(txf);
        disp1.setEditable(false);
        JScrollPane scrollPane=new JScrollPane(disp1);
        scrollPane.setBounds(630,20,230,350);
        panel.add(scrollPane);


        panel.add(vegb1);
        panel.add(vegb2);
        panel.add(vegb3);
        panel.add(vegb4);
        panel.add(vegb5);
        panel.add(vegb6);

        panel.add(vegcb1);
        panel.add(vegcb2);
        panel.add(vegcb3);
        panel.add(vegcb4);
        panel.add(vegcb5);
        panel.add(vegcb6);

        panel.add(vegprice1);
        panel.add(vegprice2);
        panel.add(vegprice3);
        panel.add(vegprice4);
        panel.add(vegprice5);
        panel.add(vegprice6);

        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);
        panel.add(l5);
        panel.add(l6);

        panel.add(veg1q);
        panel.add(veg2q);
        panel.add(veg3q);
        panel.add(veg4q);
        panel.add(veg5q);
        panel.add(veg6q);

        panel.add(backButton1);
        panel.add(confirmButton1);

        return panel;
    }

    private JPanel createNVegPanel() {
        JPanel panel = new JPanel(null);
        panel.setBackground(panelColor);

        nveg1 = new ImageIcon("D:\\Food Images\\chicken biryani.jpg");
        Image img1 = nveg1.getImage();
        img1= img1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        nveg1 = new ImageIcon(img1);
        nvegb1 = new JButton(nveg1);
        nvegb1.addActionListener(this);
        nvegb1.setBounds(50, 20, 150, 150);
        nvegcb1=new JCheckBox("Chicken Biryani");
        nvegcb1.setBounds(70,175,150,20);
        nvegcb1.setBackground(panelColor);
        nvegcb1.setForeground(Color.WHITE);
        nvegprice1=new JLabel("Price : $120");
        nvegprice1.setBounds(75,200,150,20);
        nvegprice1.setFont(lf);
        nvegprice1.setForeground(Color.WHITE);
        JLabel l1=new JLabel("Quantity :");
        l1.setBounds(50,230,100,20);
        l1.setFont(lf);
        l1.setForeground(Color.WHITE);
        nveg1q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        nveg1q.setBounds(150,230,40,20);

        nveg2 = new ImageIcon("D:\\Food Images\\mutton briyani.jpg");
        Image img2 = nveg2.getImage();
        img2= img2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        nveg2 = new ImageIcon(img2);
        nvegb2 = new JButton(nveg2);
        nvegb2.addActionListener(this);
        nvegb2.setBounds(250, 20, 150, 150);
        nvegcb2=new JCheckBox("Mutton Briyani");
        nvegcb2.setBounds(270,175,150,20);
        nvegcb2.setBackground(panelColor);
        nvegcb2.setForeground(Color.WHITE);
        nvegprice2=new JLabel("Price : $180");
        nvegprice2.setBounds(275,200,150,20);
        nvegprice2.setFont(lf);
        nvegprice2.setForeground(Color.WHITE);
        JLabel l2=new JLabel("Quantity :");
        l2.setBounds(250,230,100,20);
        l2.setFont(lf);
        l2.setForeground(Color.WHITE);
        nveg2q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        nveg2q.setBounds(350,230,40,20);

        nveg3 = new ImageIcon("D:\\Food Images\\chicken noodles.jpg");
        Image img3 = nveg3.getImage();
        img3= img3.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        nveg3 = new ImageIcon(img3);
        nvegb3 = new JButton(nveg3);
        nvegb3.addActionListener(this);
        nvegb3.setBounds(450, 20, 150, 150);
        nvegcb3=new JCheckBox("Chicken Noodles");
        nvegcb3.setBounds(470,175,150,20);
        nvegcb3.setBackground(panelColor);
        nvegcb3.setForeground(Color.WHITE);
        nvegprice3=new JLabel("Price : $100");
        nvegprice3.setBounds(475,200,150,20);
        nvegprice3.setFont(lf);
        nvegprice3.setForeground(Color.WHITE);
        JLabel l3=new JLabel("Quantity :");
        l3.setBounds(450,230,100,20);
        l3.setFont(lf);
        l3.setForeground(Color.WHITE);
        nveg3q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        nveg3q.setBounds(550,230,40,20);

        nveg4 = new ImageIcon("D:\\Food Images\\fishfry.jpg");
        Image img4 = nveg4.getImage();
        img4= img4.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        nveg4 = new ImageIcon(img4);
        nvegb4 = new JButton(nveg4);
        nvegb4.addActionListener(this);
        nvegb4.setBounds(50, 290, 150, 150);
        nvegcb4=new JCheckBox("Fish Fry");
        nvegcb4.setBounds(80,445,150,20);
        nvegcb4.setBackground(panelColor);
        nvegcb4.setForeground(Color.WHITE);
        nvegprice4=new JLabel("Price : $70");
        nvegprice4.setBounds(75,470,150,20);
        nvegprice4.setFont(lf);
        nvegprice4.setForeground(Color.WHITE);
        JLabel l4=new JLabel("Quantity :");
        l4.setBounds(50,500,100,20);
        l4.setFont(lf);
        l4.setForeground(Color.WHITE);
        nveg4q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        nveg4q.setBounds(150,500,40,20);


        nveg5 = new ImageIcon("D:\\Food Images\\grilled chicken.jpg");
        Image img5 = nveg5.getImage();
        img5= img5.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        nveg5 = new ImageIcon(img5);
        nvegb5 = new JButton(nveg5);
        nvegb5.addActionListener(this);
        nvegb5.setBounds(250, 290, 150, 150);
        nvegcb5=new JCheckBox("Grilled Chicken");
        nvegcb5.setBounds(260,445,180,20);
        nvegcb5.setBackground(panelColor);
        nvegcb5.setForeground(Color.WHITE);
        nvegprice5=new JLabel("Price : $150");
        nvegprice5.setBounds(275,470,150,20);
        nvegprice5.setFont(lf);
        nvegprice5.setForeground(Color.WHITE);
        JLabel l5=new JLabel("Quantity :");
        l5.setBounds(250,500,100,20);
        l5.setFont(lf);
        l5.setForeground(Color.WHITE);
        nveg5q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        nveg5q.setBounds(350,500,40,20);

        nveg6 = new ImageIcon("D:\\Food Images\\prawn fry.jpg");
        Image img6 = nveg6.getImage();
        img6= img6.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        nveg6 = new ImageIcon(img6);
        nvegb6 = new JButton(nveg6);
        nvegb6.addActionListener(this);
        nvegb6.setBounds(450, 290, 150, 150);
        nvegcb6=new JCheckBox("Prawn Fry");
        nvegcb6.setBounds(480,445,150,20);
        nvegcb6.setBackground(panelColor);
        nvegcb6.setForeground(Color.WHITE);
        nvegprice6=new JLabel("Price : $70");
        nvegprice6.setBounds(475,470,150,20);
        nvegprice6.setFont(lf);
        nvegprice6.setForeground(Color.WHITE);
        JLabel l6=new JLabel("Quantity :");
        l6.setBounds(450,500,100,20);
        l6.setFont(lf);
        l6.setForeground(Color.WHITE);
        nveg6q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        nveg6q.setBounds(550,500,40,20);

        backButton2=new JButton("Go to MenuCard");
        backButton2.setBounds(650,400,190,40);
        backButton2.setFont(txf);
        backButton2.setBackground(Color.BLUE);
        backButton2.setForeground(Color.WHITE);
        backButton2.addActionListener(this);

        confirmButton2=new JButton("Confirm");
        confirmButton2.setBounds(650,450,190,40);
        confirmButton2.setFont(txf);
        confirmButton2.setBackground(Color.BLUE);
        confirmButton2.setForeground(Color.WHITE);
        confirmButton2.addActionListener(this);

        disp2=new JTextArea();
        disp2.setForeground(Color.WHITE);
        disp2.setBackground(panelColor);
        disp2.setFont(txf);
        disp2.setEditable(false);
        JScrollPane scrollPane=new JScrollPane(disp2);
        scrollPane.setBounds(630,20,230,350);
        panel.add(scrollPane);

        panel.add(nvegb1);
        panel.add(nvegb2);
        panel.add(nvegb3);
        panel.add(nvegb4);
        panel.add(nvegb5);
        panel.add(nvegb6);

        panel.add(nvegcb1);
        panel.add(nvegcb2);
        panel.add(nvegcb3);
        panel.add(nvegcb4);
        panel.add(nvegcb5);
        panel.add(nvegcb6);

        panel.add(nvegprice1);
        panel.add(nvegprice2);
        panel.add(nvegprice3);
        panel.add(nvegprice4);
        panel.add(nvegprice5);
        panel.add(nvegprice6);

        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);
        panel.add(l5);
        panel.add(l6);

        panel.add(nveg1q);
        panel.add(nveg2q);
        panel.add(nveg3q);
        panel.add(nveg4q);
        panel.add(nveg5q);
        panel.add(nveg6q);

        panel.add(backButton2);
        panel.add(confirmButton2);


        return panel;
    }

    private JPanel createFastfoodPanel() {
        JPanel panel = new JPanel(null);
        panel.setBackground(panelColor);

        ff1 = new ImageIcon("D:\\Food Images\\burger.jpg");
        Image img1 = ff1.getImage();
        img1= img1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ff1 = new ImageIcon(img1);
        Fastfoodb1 = new JButton(ff1);
        Fastfoodb1.addActionListener(this);
        Fastfoodb1.setBounds(50, 20, 150, 150);
        ffcb1=new JCheckBox("Burger");
        ffcb1.setBounds(90,175,150,20);
        ffcb1.setBackground(panelColor);
        ffcb1.setForeground(Color.WHITE);
        ffprice1=new JLabel("Price : $60");
        ffprice1.setBounds(75,200,150,20);
        ffprice1.setFont(lf);
        ffprice1.setForeground(Color.WHITE);
        JLabel l1=new JLabel("Quantity :");
        l1.setBounds(50,230,100,20);
        l1.setFont(lf);
        l1.setForeground(Color.WHITE);
        ff1q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        ff1q.setBounds(150,230,40,20);

        ff2 = new ImageIcon("D:\\Food Images\\pizza.jpg");
        Image img2 = ff2.getImage();
        img2= img2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ff2 = new ImageIcon(img2);
        Fastfoodb2 = new JButton(ff2);
        Fastfoodb2.addActionListener(this);
        Fastfoodb2.setBounds(250, 20, 150, 150);
        ffcb2=new JCheckBox("Pizza");
        ffcb2.setBounds(300,175,150,20);
        ffcb2.setBackground(panelColor);
        ffcb2.setForeground(Color.WHITE);
        ffprice2=new JLabel("Price : $170");
        ffprice2.setBounds(275,200,150,20);
        ffprice2.setFont(lf);
        ffprice2.setForeground(Color.WHITE);
        JLabel l2=new JLabel("Quantity :");
        l2.setBounds(250,230,100,20);
        l2.setFont(lf);
        l2.setForeground(Color.WHITE);
        ff2q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        ff2q.setBounds(350,230,40,20);

        ff3 = new ImageIcon("D:\\Food Images\\shawarma.jpg");
        Image img3 = ff3.getImage();
        img3= img3.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ff3 = new ImageIcon(img3);
        Fastfoodb3 = new JButton(ff3);
        Fastfoodb3.addActionListener(this);
        Fastfoodb3.setBounds(450, 20, 150, 150);
        ffcb3=new JCheckBox("Shawarma");
        ffcb3.setBounds(490,175,120,20);
        ffcb3.setBackground(panelColor);
        ffcb3.setForeground(Color.WHITE);
        ffprice3=new JLabel("Price : $80");
        ffprice3.setBounds(470,200,150,20);
        ffprice3.setFont(lf);
        ffprice3.setForeground(Color.WHITE);
        JLabel l3=new JLabel("Quantity :");
        l3.setBounds(450,230,100,20);
        l3.setFont(lf);
        l3.setForeground(Color.WHITE);
        ff3q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        ff3q.setBounds(550,230,40,20);

        ff4 = new ImageIcon("D:\\Food Images\\frenchfries.jpg");
        Image img4 = ff4.getImage();
        img4= img4.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ff4 = new ImageIcon(img4);
        Fastfoodb4 = new JButton(ff4);
        Fastfoodb4.addActionListener(this);
        Fastfoodb4.setBounds(50, 290, 150, 150);
        ffcb4=new JCheckBox("Frenchfries");
        ffcb4.setBounds(80,445,150,20);
        ffcb4.setBackground(panelColor);
        ffcb4.setForeground(Color.WHITE);
        ffprice4=new JLabel("Price : $70");
        ffprice4.setBounds(75,470,150,20);
        ffprice4.setFont(lf);
        ffprice4.setForeground(Color.WHITE);
        JLabel l4=new JLabel("Quantity :");
        l4.setBounds(50,500,100,20);
        l4.setFont(lf);
        l4.setForeground(Color.WHITE);
        ff4q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        ff4q.setBounds(150,500,40,20);


        ff5 = new ImageIcon("D:\\Food Images\\kfc.jpg");
        Image img5 = ff5.getImage();
        img5= img5.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ff5 = new ImageIcon(img5);
        Fastfoodb5 = new JButton(ff5);
        Fastfoodb5.addActionListener(this);
        Fastfoodb5.setBounds(250, 290, 150, 150);
        ffcb5=new JCheckBox("KFC Chicken");
        ffcb5.setBounds(260,445,180,20);
        ffcb5.setBackground(panelColor);
        ffcb5.setForeground(Color.WHITE);
        ffprice5=new JLabel("Price : $150");
        ffprice5.setBounds(290,470,150,20);
        ffprice5.setFont(lf);
        ffprice5.setForeground(Color.WHITE);
        JLabel l5=new JLabel("Quantity :");
        l5.setBounds(250,500,100,20);
        l5.setFont(lf);
        l5.setForeground(Color.WHITE);
        ff5q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        ff5q.setBounds(350,500,40,20);

        ff6 = new ImageIcon("D:\\Food Images\\panipori.jpg");
        Image img6 = ff6.getImage();
        img6= img6.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ff6 = new ImageIcon(img6);
        Fastfoodb6 = new JButton(ff6);
        Fastfoodb6.addActionListener(this);
        Fastfoodb6.setBounds(450, 290, 150, 150);
        ffcb6=new JCheckBox("Panipori");
        ffcb6.setBounds(485,445,150,20);
        ffcb6.setBackground(panelColor);
        ffcb6.setForeground(Color.WHITE);
        ffprice6=new JLabel("Price : $50");
        ffprice6.setBounds(475,470,150,20);
        ffprice6.setFont(lf);
        ffprice6.setForeground(Color.WHITE);
        JLabel l6=new JLabel("Quantity :");
        l6.setBounds(450,500,100,20);
        l6.setFont(lf);
        l6.setForeground(Color.WHITE);
        ff6q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        ff6q.setBounds(550,500,40,20);

        backButton3=new JButton("Go to MenuCard");
        backButton3.setBounds(650,400,190,40);
        backButton3.setFont(txf);
        backButton3.setBackground(Color.BLUE);
        backButton3.setForeground(Color.WHITE);
        backButton3.addActionListener(this);

        confirmButton3=new JButton("Confirm");
        confirmButton3.setBounds(650,450,190,40);
        confirmButton3.setFont(txf);
        confirmButton3.setBackground(Color.BLUE);
        confirmButton3.setForeground(Color.WHITE);
        confirmButton3.addActionListener(this);

        disp3=new JTextArea();
        disp3.setForeground(Color.WHITE);
        disp3.setBackground(panelColor);
        disp3.setFont(txf);
        disp3.setEditable(false);
        JScrollPane scrollPane=new JScrollPane(disp3);
        scrollPane.setBounds(630,20,230,350);
        panel.add(scrollPane);


        panel.add(Fastfoodb1);
        panel.add(Fastfoodb2);
        panel.add(Fastfoodb3);
        panel.add(Fastfoodb4);
        panel.add(Fastfoodb5);
        panel.add(Fastfoodb6);

        panel.add(ffcb1);
        panel.add(ffcb2);
        panel.add(ffcb3);
        panel.add(ffcb4);
        panel.add(ffcb5);
        panel.add(ffcb6);

        panel.add(ffprice1);
        panel.add(ffprice2);
        panel.add(ffprice3);
        panel.add(ffprice4);
        panel.add(ffprice5);
        panel.add(ffprice6);

        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);
        panel.add(l5);
        panel.add(l6);

        panel.add(ff1q);
        panel.add(ff2q);
        panel.add(ff3q);
        panel.add(ff4q);
        panel.add(ff5q);
        panel.add(ff6q);

        panel.add(backButton3);
        panel.add(confirmButton3);

        return panel;
    }

    private JPanel createJuicePanel() {
        JPanel panel = new JPanel(null);
        panel.setBackground(panelColor);

        juice1 = new ImageIcon("D:\\Food Images\\chocolate milkshake.jpg");
        Image img1 = juice1.getImage();
        img1= img1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        juice1 = new ImageIcon(img1);
        juiceb1 = new JButton(juice1);
        juiceb1.addActionListener(this);
        juiceb1.setBounds(50, 20, 150, 150);
        juicecb1=new JCheckBox("Chocolate Milkshake");
        juicecb1.setBounds(60,175,150,20);
        juicecb1.setBackground(panelColor);
        juicecb1.setForeground(Color.WHITE);
        juiceprice1=new JLabel("Price : $80");
        juiceprice1.setBounds(75,200,150,20);
        juiceprice1.setFont(lf);
        juiceprice1.setForeground(Color.WHITE);
        JLabel l1=new JLabel("Quantity :");
        l1.setBounds(50,230,100,20);
        l1.setFont(lf);
        l1.setForeground(Color.WHITE);
        juice1q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        juice1q.setBounds(150,230,40,20);

        juice2 = new ImageIcon("D:\\Food Images\\oreo milkshake.jpeg");
        Image img2 = juice2.getImage();
        img2= img2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        juice2 = new ImageIcon(img2);
        juiceb2 = new JButton(juice2);
        juiceb2.addActionListener(this);
        juiceb2.setBounds(250, 20, 150, 150);
        juicecb2=new JCheckBox("Oreo Milkshake");
        juicecb2.setBounds(260,175,150,20);
        juicecb2.setBackground(panelColor);
        juicecb2.setForeground(Color.WHITE);
        juiceprice2=new JLabel("Price : $80");
        juiceprice2.setBounds(275,200,150,20);
        juiceprice2.setFont(lf);
        juiceprice2.setForeground(Color.WHITE);
        JLabel l2=new JLabel("Quantity :");
        l2.setBounds(250,230,100,20);
        l2.setFont(lf);
        l2.setForeground(Color.WHITE);
        juice2q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        juice2q.setBounds(350,230,40,20);

        juice3 = new ImageIcon("D:\\Food Images\\vanilla milkshake.jpeg");
        Image img3 = juice3.getImage();
        img3= img3.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        juice3 = new ImageIcon(img3);
        juiceb3 = new JButton(juice3);
        juiceb3.addActionListener(this);
        juiceb3.setBounds(450, 20, 150, 150);
        juicecb3=new JCheckBox("Vanilla Milkshake");
        juicecb3.setBounds(460,175,150,20);
        juicecb3.setBackground(panelColor);
        juicecb3.setForeground(Color.WHITE);
        juiceprice3=new JLabel("Price : $70");
        juiceprice3.setBounds(475,200,150,20);
        juiceprice3.setFont(lf);
        juiceprice3.setForeground(Color.WHITE);
        JLabel l3=new JLabel("Quantity :");
        l3.setBounds(450,230,100,20);
        l3.setFont(lf);
        l3.setForeground(Color.WHITE);
        juice3q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        juice3q.setBounds(550,230,40,20);

        juice4 = new ImageIcon("D:\\Food Images\\orange juice.jpg");
        Image img4 = juice4.getImage();
        img4= img4.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        juice4 = new ImageIcon(img4);
        juiceb4 = new JButton(juice4);
        juiceb4.addActionListener(this);
        juiceb4.setBounds(50, 290, 150, 150);
        juicecb4=new JCheckBox("Orange Juice");
        juicecb4.setBounds(70,445,150,20);
        juicecb4.setBackground(panelColor);
        juicecb4.setForeground(Color.WHITE);
        juiceprice4=new JLabel("Price : $30");
        juiceprice4.setBounds(75,470,150,20);
        juiceprice4.setFont(lf);
        juiceprice4.setForeground(Color.WHITE);
        JLabel l4=new JLabel("Quantity :");
        l4.setBounds(50,500,100,20);
        l4.setFont(lf);
        l4.setForeground(Color.WHITE);
        juice4q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        juice4q.setBounds(150,500,40,20);


        juice5 = new ImageIcon("D:\\Food Images\\lemon juice.jpg");
        Image img5 = juice5.getImage();
        img5= img5.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        juice5 = new ImageIcon(img5);
        juiceb5 = new JButton(juice5);
        juiceb5.addActionListener(this);
        juiceb5.setBounds(250, 290, 150, 150);
        juicecb5=new JCheckBox("Lemon Juice");
        juicecb5.setBounds(240,445,180,20);
        juicecb5.setBackground(panelColor);
        juicecb5.setForeground(Color.WHITE);
        juiceprice5=new JLabel("Price : $20");
        juiceprice5.setBounds(260,470,150,20);
        juiceprice5.setFont(lf);
        juiceprice5.setForeground(Color.WHITE);
        JLabel l5=new JLabel("Quantity :");
        l5.setBounds(250,500,100,20);
        l5.setFont(lf);
        l5.setForeground(Color.WHITE);
        juice5q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        juice5q.setBounds(350,500,40,20);

        juice6 = new ImageIcon("D:\\Food Images\\blueberry mojito.jpg");
        Image img6 = juice6.getImage();
        img6= img6.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        juice6 = new ImageIcon(img6);
        juiceb6 = new JButton(juice6);
        juiceb6.addActionListener(this);
        juiceb6.setBounds(450, 290, 150, 150);
        juicecb6=new JCheckBox("Blueberry Mojito");
        juicecb6.setBounds(468,445,150,20);
        juicecb6.setBackground(panelColor);
        juicecb6.setForeground(Color.WHITE);
        juiceprice6=new JLabel("Price : $70");
        juiceprice6.setBounds(475,470,150,20);
        juiceprice6.setFont(lf);
        juiceprice6.setForeground(Color.WHITE);
        JLabel l6=new JLabel("Quantity :");
        l6.setBounds(450,500,100,20);
        l6.setFont(lf);
        l6.setForeground(Color.WHITE);
        juice6q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        juice6q.setBounds(550,500,40,20);

        backButton4=new JButton("Go to MenuCard");
        backButton4.setBounds(650,400,190,40);
        backButton4.setFont(txf);
        backButton4.setBackground(Color.BLUE);
        backButton4.setForeground(Color.WHITE);
        backButton4.addActionListener(this);

        confirmButton4=new JButton("Confirm");
        confirmButton4.setBounds(650,450,190,40);
        confirmButton4.setFont(txf);
        confirmButton4.setBackground(Color.BLUE);
        confirmButton4.setForeground(Color.WHITE);
        confirmButton4.addActionListener(this);

        disp4=new JTextArea();
        disp4.setForeground(Color.WHITE);
        disp4.setBackground(panelColor);
        disp4.setFont(txf);
        disp4.setEditable(false);
        JScrollPane scrollPane=new JScrollPane(disp4);
        scrollPane.setBounds(630,20,230,350);
        panel.add(scrollPane);


        panel.add(juiceb1);
        panel.add(juiceb2);
        panel.add(juiceb3);
        panel.add(juiceb4);
        panel.add(juiceb5);
        panel.add(juiceb6);

        panel.add(juicecb1);
        panel.add(juicecb2);
        panel.add(juicecb3);
        panel.add(juicecb4);
        panel.add(juicecb5);
        panel.add(juicecb6);

        panel.add(juiceprice1);
        panel.add(juiceprice2);
        panel.add(juiceprice3);
        panel.add(juiceprice4);
        panel.add(juiceprice5);
        panel.add(juiceprice6);

        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);
        panel.add(l5);
        panel.add(l6);

        panel.add(juice1q);
        panel.add(juice2q);
        panel.add(juice3q);
        panel.add(juice4q);
        panel.add(juice5q);
        panel.add(juice6q);

        panel.add(backButton4);
        panel.add(confirmButton4);

        return panel;
    }

    private JPanel createIcecreamPanel() {
        JPanel panel = new JPanel(null);
        panel.setBackground(panelColor);

        icecream1 = new ImageIcon("D:\\Food Images\\vanilla icecream.jpg");
        Image img1 = icecream1.getImage();
        img1= img1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        icecream1 = new ImageIcon(img1);
        Icecreamb1 = new JButton(icecream1);
        Icecreamb1.addActionListener(this);
        Icecreamb1.setBounds(50, 20, 150, 150);
        icecreamcb1=new JCheckBox("Vanilla Icecream");
        icecreamcb1.setBounds(60,175,150,20);
        icecreamcb1.setBackground(panelColor);
        icecreamcb1.setForeground(Color.WHITE);
        icecreamprice1=new JLabel("Price : $70");
        icecreamprice1.setBounds(75,200,150,20);
        icecreamprice1.setFont(lf);
        icecreamprice1.setForeground(Color.WHITE);
        JLabel l1=new JLabel("Quantity :");
        l1.setBounds(50,230,100,20);
        l1.setFont(lf);
        l1.setForeground(Color.WHITE);
        icecream1q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        icecream1q.setBounds(150,230,40,20);

        icecream2 = new ImageIcon("D:\\Food Images\\strawberry icecream.jpg");
        Image img2 = icecream2.getImage();
        img2= img2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        icecream2 = new ImageIcon(img2);
        Icecreamb2 = new JButton(icecream2);
        Icecreamb2.addActionListener(this);
        Icecreamb2.setBounds(250, 20, 150, 150);
        icecreamcb2=new JCheckBox("Strawberry Icecream");
        icecreamcb2.setBounds(250,175,150,20);
        icecreamcb2.setBackground(panelColor);
        icecreamcb2.setForeground(Color.WHITE);
        icecreamprice2=new JLabel("Price : $80");
        icecreamprice2.setBounds(275,200,150,20);
        icecreamprice2.setFont(lf);
        icecreamprice2.setForeground(Color.WHITE);
        JLabel l2=new JLabel("Quantity :");
        l2.setBounds(250,230,100,20);
        l2.setFont(lf);
        l2.setForeground(Color.WHITE);
        icecream2q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        icecream2q.setBounds(350,230,40,20);

        icecream3 = new ImageIcon("D:\\Food Images\\chocolate icecream.jpg");
        Image img3 = icecream3.getImage();
        img3= img3.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        icecream3 = new ImageIcon(img3);
        Icecreamb3 = new JButton(icecream3);
        Icecreamb3.addActionListener(this);
        Icecreamb3.setBounds(450, 20, 150, 150);
        icecreamcb3=new JCheckBox("Chocolate Icecream");
        icecreamcb3.setBounds(460,175,150,20);
        icecreamcb3.setBackground(panelColor);
        icecreamcb3.setForeground(Color.WHITE);
        icecreamprice3=new JLabel("Price : $80");
        icecreamprice3.setBounds(475,200,150,20);
        icecreamprice3.setFont(lf);
        icecreamprice3.setForeground(Color.WHITE);
        JLabel l3=new JLabel("Quantity :");
        l3.setBounds(450,230,100,20);
        l3.setFont(lf);
        l3.setForeground(Color.WHITE);
        icecream3q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        icecream3q.setBounds(550,230,40,20);

        icecream4 = new ImageIcon("D:\\Food Images\\chocolate cookie.jpg");
        Image img4 = icecream4.getImage();
        img4= img4.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        icecream4 = new ImageIcon(img4);
        Icecreamb4 = new JButton(icecream4);
        Icecreamb4.addActionListener(this);
        Icecreamb4.setBounds(50, 290, 150, 150);
        icecreamcb4=new JCheckBox("Chocolate Cookies");
        icecreamcb4.setBounds(60,445,150,20);
        icecreamcb4.setBackground(panelColor);
        icecreamcb4.setForeground(Color.WHITE);
        icecreamprice4=new JLabel("Price : $40");
        icecreamprice4.setBounds(75,470,150,20);
        icecreamprice4.setFont(lf);
        icecreamprice4.setForeground(Color.WHITE);
        JLabel l4=new JLabel("Quantity :");
        l4.setBounds(50,500,100,20);
        l4.setFont(lf);
        l4.setForeground(Color.WHITE);
        icecream4q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        icecream4q.setBounds(150,500,40,20);


        icecream5 = new ImageIcon("D:\\Food Images\\blackcurrant icecream.jpg");
        Image img5 = icecream5.getImage();
        img5= img5.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        icecream5 = new ImageIcon(img5);
        Icecreamb5 = new JButton(icecream5);
        Icecreamb5.addActionListener(this);
        Icecreamb5.setBounds(250, 290, 150, 150);
        icecreamcb5=new JCheckBox("Blackcurrant Icecream");
        icecreamcb5.setBounds(245,445,180,20);
        icecreamcb5.setBackground(panelColor);
        icecreamcb5.setForeground(Color.WHITE);
        icecreamprice5=new JLabel("Price : $50");
        icecreamprice5.setBounds(275,470,150,20);
        icecreamprice5.setFont(lf);
        icecreamprice5.setForeground(Color.WHITE);
        JLabel l5=new JLabel("Quantity :");
        l5.setBounds(250,500,100,20);
        l5.setFont(lf);
        l5.setForeground(Color.WHITE);
        icecream5q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        icecream5q.setBounds(350,500,40,20);

        icecream6 = new ImageIcon("D:\\Food Images\\caramel icecream.jpg");
        Image img6 = icecream6.getImage();
        img6= img6.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        icecream6 = new ImageIcon(img6);
        Icecreamb6 = new JButton(icecream6);
        Icecreamb6.addActionListener(this);
        Icecreamb6.setBounds(450, 290, 150, 150);
        icecreamcb6=new JCheckBox("Caramel Icecream");
        icecreamcb6.setBounds(460,445,150,20);
        icecreamcb6.setBackground(panelColor);
        icecreamcb6.setForeground(Color.WHITE);
        icecreamprice6=new JLabel("Price : $150");
        icecreamprice6.setBounds(475,470,150,20);
        icecreamprice6.setFont(lf);
        icecreamprice6.setForeground(Color.WHITE);
        JLabel l6=new JLabel("Quantity :");
        l6.setBounds(450,500,100,20);
        l6.setFont(lf);
        l6.setForeground(Color.WHITE);
        icecream6q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        icecream6q.setBounds(550,500,40,20);

        backButton5=new JButton("Go to MenuCard");
        backButton5.setBounds(650,400,190,40);
        backButton5.setFont(txf);
        backButton5.setBackground(Color.BLUE);
        backButton5.setForeground(Color.WHITE);
        backButton5.addActionListener(this);

        confirmButton5=new JButton("Confirm");
        confirmButton5.setBounds(650,450,190,40);
        confirmButton5.setFont(txf);
        confirmButton5.setBackground(Color.BLUE);
        confirmButton5.setForeground(Color.WHITE);
        confirmButton5.addActionListener(this);

        disp5=new JTextArea();
        disp5.setForeground(Color.WHITE);
        disp5.setBackground(panelColor);
        disp5.setFont(txf);
        disp5.setEditable(false);
        JScrollPane scrollPane=new JScrollPane(disp5);
        scrollPane.setBounds(630,20,230,350);
        panel.add(scrollPane);


        panel.add(Icecreamb1);
        panel.add(Icecreamb2);
        panel.add(Icecreamb3);
        panel.add(Icecreamb4);
        panel.add(Icecreamb5);
        panel.add(Icecreamb6);

        panel.add(icecreamcb1);
        panel.add(icecreamcb2);
        panel.add(icecreamcb3);
        panel.add(icecreamcb4);
        panel.add(icecreamcb5);
        panel.add(icecreamcb6);

        panel.add(icecreamprice1);
        panel.add(icecreamprice2);
        panel.add(icecreamprice3);
        panel.add(icecreamprice4);
        panel.add(icecreamprice5);
        panel.add(icecreamprice6);

        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);
        panel.add(l5);
        panel.add(l6);

        panel.add(icecream1q);
        panel.add(icecream2q);
        panel.add(icecream3q);
        panel.add(icecream4q);
        panel.add(icecream5q);
        panel.add(icecream6q);

        panel.add(backButton5);
        panel.add(confirmButton5);

        return panel;
    }

    private JPanel createSweetPanel() {
        JPanel panel = new JPanel(null);
        panel.setBackground(panelColor);

        sweet1 = new ImageIcon("D:\\Food Images\\kaju katli.jpg");
        Image img1 = sweet1.getImage();
        img1= img1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        sweet1 = new ImageIcon(img1);
        Sweetb1 = new JButton(sweet1);
        Sweetb1.addActionListener(this);
        Sweetb1.setBounds(50, 20, 150, 150);
        sweetcb1=new JCheckBox("Kaju Katli");
        sweetcb1.setBounds(70,175,150,20);
        sweetcb1.setBackground(panelColor);
        sweetcb1.setForeground(Color.WHITE);
        sweetprice1=new JLabel("Price : $350");
        sweetprice1.setBounds(75,200,150,20);
        sweetprice1.setFont(lf);
        sweetprice1.setForeground(Color.WHITE);
        JLabel l1=new JLabel("Quantity :");
        l1.setBounds(50,230,100,20);
        l1.setFont(lf);
        l1.setForeground(Color.WHITE);
        sweet1q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        sweet1q.setBounds(150,230,40,20);

        sweet2 = new ImageIcon("D:\\Food Images\\rasmalai.png");
        Image img2 = sweet2.getImage();
        img2= img2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        sweet2 = new ImageIcon(img2);
        Sweetb2 = new JButton(sweet2);
        Sweetb2.addActionListener(this);
        Sweetb2.setBounds(250, 20, 150, 150);
        sweetcb2=new JCheckBox("Rasmalai");
        sweetcb2.setBounds(280,175,150,20);
        sweetcb2.setBackground(panelColor);
        sweetcb2.setForeground(Color.WHITE);
        sweetprice2=new JLabel("Price : $200");
        sweetprice2.setBounds(275,200,150,20);
        sweetprice2.setFont(lf);
        sweetprice2.setForeground(Color.WHITE);
        JLabel l2=new JLabel("Quantity :");
        l2.setBounds(250,230,100,20);
        l2.setFont(lf);
        l2.setForeground(Color.WHITE);
        sweet2q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        sweet2q.setBounds(350,230,40,20);

        sweet3 = new ImageIcon("D:\\Food Images\\Gulab Jamun.png");
        Image img3 = sweet3.getImage();
        img3= img3.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        sweet3 = new ImageIcon(img3);
        Sweetb3 = new JButton(sweet3);
        Sweetb3.addActionListener(this);
        Sweetb3.setBounds(450, 20, 150, 150);
        sweetcb3=new JCheckBox("Gulab Jamun");
        sweetcb3.setBounds(470,175,150,20);
        sweetcb3.setBackground(panelColor);
        sweetcb3.setForeground(Color.WHITE);
        sweetprice3=new JLabel("Price : $100");
        sweetprice3.setBounds(475,200,150,20);
        sweetprice3.setFont(lf);
        sweetprice3.setForeground(Color.WHITE);
        JLabel l3=new JLabel("Quantity :");
        l3.setBounds(450,230,100,20);
        l3.setFont(lf);
        l3.setForeground(Color.WHITE);
        sweet3q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        sweet3q.setBounds(550,230,40,20);

        sweet4 = new ImageIcon("D:\\Food Images\\rasgulla.png");
        Image img4 = sweet4.getImage();
        img4= img4.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        sweet4 = new ImageIcon(img4);
        Sweetb4 = new JButton(sweet4);
        Sweetb4.addActionListener(this);
        Sweetb4.setBounds(50, 290, 150, 150);
        sweetcb4=new JCheckBox("Rasgulla");
        sweetcb4.setBounds(85,445,150,20);
        sweetcb4.setBackground(panelColor);
        sweetcb4.setForeground(Color.WHITE);
        sweetprice4=new JLabel("Price : $150");
        sweetprice4.setBounds(75,470,150,20);
        sweetprice4.setFont(lf);
        sweetprice4.setForeground(Color.WHITE);
        JLabel l4=new JLabel("Quantity :");
        l4.setBounds(50,500,100,20);
        l4.setFont(lf);
        l4.setForeground(Color.WHITE);
        sweet4q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        sweet4q.setBounds(150,500,40,20);


        sweet5 = new ImageIcon("D:\\Food Images\\halwa.jpg");
        Image img5 = sweet5.getImage();
        img5= img5.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        sweet5 = new ImageIcon(img5);
        Sweetb5 = new JButton(sweet5);
        Sweetb5.addActionListener(this);
        Sweetb5.setBounds(250, 290, 150, 150);
        sweetcb5=new JCheckBox("Halwa");
        sweetcb5.setBounds(300,445,180,20);
        sweetcb5.setBackground(panelColor);
        sweetcb5.setForeground(Color.WHITE);
        sweetprice5=new JLabel("Price : $120");
        sweetprice5.setBounds(275,470,150,20);
        sweetprice5.setFont(lf);
        sweetprice5.setForeground(Color.WHITE);
        JLabel l5=new JLabel("Quantity :");
        l5.setBounds(250,500,100,20);
        l5.setFont(lf);
        l5.setForeground(Color.WHITE);
        sweet5q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        sweet5q.setBounds(350,500,40,20);

        sweet6 = new ImageIcon("D:\\Food Images\\milk peda.jpg");
        Image img6 = sweet6.getImage();
        img6= img6.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        sweet6 = new ImageIcon(img6);
        Sweetb6 = new JButton(sweet6);
        Sweetb6.addActionListener(this);
        Sweetb6.setBounds(450, 290, 150, 150);
        sweetcb6=new JCheckBox("Milk Peda");
        sweetcb6.setBounds(475,445,150,20);
        sweetcb6.setBackground(panelColor);
        sweetcb6.setForeground(Color.WHITE);
        sweetprice6=new JLabel("Price : $160");
        sweetprice6.setBounds(475,470,150,20);
        sweetprice6.setFont(lf);
        sweetprice6.setForeground(Color.WHITE);
        JLabel l6=new JLabel("Quantity :");
        l6.setBounds(450,500,100,20);
        l6.setFont(lf);
        l6.setForeground(Color.WHITE);
        sweet6q = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        sweet6q.setBounds(550,500,40,20);

        backButton6=new JButton("Go to MenuCard");
        backButton6.setBounds(650,400,190,40);
        backButton6.setFont(txf);
        backButton6.setBackground(Color.BLUE);
        backButton6.setForeground(Color.WHITE);
        backButton6.addActionListener(this);

        confirmButton6=new JButton("Confirm");
        confirmButton6.setBounds(650,450,190,40);
        confirmButton6.setFont(txf);
        confirmButton6.setBackground(Color.BLUE);
        confirmButton6.setForeground(Color.WHITE);
        confirmButton6.addActionListener(this);

        disp6=new JTextArea();
        disp6.setForeground(Color.WHITE);
        disp6.setBackground(panelColor);
        disp6.setFont(txf);
        disp6.setEditable(false);
        JScrollPane scrollPane=new JScrollPane(disp6);
        scrollPane.setBounds(630,20,230,350);
        panel.add(scrollPane);


        panel.add(Sweetb1);
        panel.add(Sweetb2);
        panel.add(Sweetb3);
        panel.add(Sweetb4);
        panel.add(Sweetb5);
        panel.add(Sweetb6);

        panel.add(sweetcb1);
        panel.add(sweetcb2);
        panel.add(sweetcb3);
        panel.add(sweetcb4);
        panel.add(sweetcb5);
        panel.add(sweetcb6);

        panel.add(sweetprice1);
        panel.add(sweetprice2);
        panel.add(sweetprice3);
        panel.add(sweetprice4);
        panel.add(sweetprice5);
        panel.add(sweetprice6);

        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);
        panel.add(l5);
        panel.add(l6);

        panel.add(sweet1q);
        panel.add(sweet2q);
        panel.add(sweet3q);
        panel.add(sweet4q);
        panel.add(sweet5q);
        panel.add(sweet6q);

        panel.add(backButton6);
        panel.add(confirmButton6);

        return panel;
    }


    private JPanel createPaymentPanel() {
        JPanel panel = new JPanel(null);
        panel.setBackground(panelColor);

        paymentdetails=new JTextArea();
        paymentdetails.setForeground(Color.WHITE);
        paymentdetails.setBackground(panelColor);
        paymentdetails.setFont(txf);
        paymentdetails.setEditable(false);
        JScrollPane scrollPane=new JScrollPane(paymentdetails);
        scrollPane.setBounds(20,20,600,300);
        panel.add(scrollPane);

        payment = new ImageIcon("D:\\Food Images\\payment.jpg");
        Image img1 = payment.getImage();
        img1= img1.getScaledInstance(240, 240, Image.SCALE_SMOOTH);
        payment = new ImageIcon(img1);
        paymentl=new JLabel(payment);
        paymentl.setBounds(633,50,240,240);
        panel.add(paymentl);

        confirmPaymentButton = new JButton("Confirm Payment");
        confirmPaymentButton.setForeground(Color.WHITE);
        confirmPaymentButton.setBackground(Color.BLUE);
        confirmPaymentButton.addActionListener(this);
        confirmPaymentButton.setBounds(500,390,180,50);
        panel.add(confirmPaymentButton);


        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            String name = nameField.getText();
            String phno = phoneNumberField.getText();
            String email = phoneNumberField.getText();
            String address = addressField.getText();
            if (name.isEmpty()||phno.isEmpty()||email.isEmpty()||address.isEmpty()){
                JOptionPane.showMessageDialog(this, "Fields cannot be Empty..!!!!\n Please Fill the All Fields","Warning",JOptionPane.ERROR_MESSAGE);

            }else {
                cardLayout.show(cards, "Menu");
                setJMenuBar(menuBar);
            }
        } else if (e.getSource() == vegb) {
            cardLayout.show(cards, "VegPanel");
        } else if (e.getSource() == nvegb) {
            cardLayout.show(cards, "NVegPanel");
        } else if (e.getSource() == Fastfoodb) {
            cardLayout.show(cards, "FastfoodPanel");
        } else if (e.getSource() == juib) {
            cardLayout.show(cards, "JuicePanel");
        } else if (e.getSource() == Icecreamb) {
            cardLayout.show(cards, "IcecreamPanel");
        } else if (e.getSource() == Sweetb) {
            cardLayout.show(cards, "SweetPanel");
        }else if (e.getSource()==vegb1) {
            vegcb1.setSelected(!vegcb1.isSelected());
            if (vegcb1.isSelected())
            {
                veg1q.setValue(1);
            }else
            {
                veg1q.setValue(0);
            }
        }else if (e.getSource()==vegb2) {
            vegcb2.setSelected(!vegcb2.isSelected());
            if (vegcb2.isSelected())
            {
                veg2q.setValue(1);
            }else
            {
                veg2q.setValue(0);
            }
        }else if (e.getSource()==vegb3) {
            vegcb3.setSelected(!vegcb3.isSelected());
            if (vegcb3.isSelected())
            {
                veg3q.setValue(1);
            }else
            {
                veg3q.setValue(0);
            }
        }else if (e.getSource()==vegb4) {
            vegcb4.setSelected(!vegcb4.isSelected());
            if (vegcb4.isSelected())
            {
                veg4q.setValue(1);
            }else
            {
                veg4q.setValue(0);
            }
        }else if (e.getSource()==vegb5) {
            vegcb5.setSelected(!vegcb5.isSelected());
            if (vegcb5.isSelected())
            {
                veg5q.setValue(1);
            }else
            {
                veg5q.setValue(0);
            }
        }else if (e.getSource()==vegb6) {
            vegcb6.setSelected(!vegcb6.isSelected());
            if (vegcb6.isSelected())
            {
                veg6q.setValue(1);
            }else
            {
                veg6q.setValue(0);
            }
        }else if (e.getSource()==nvegb1) {
            nvegcb1.setSelected(!nvegcb1.isSelected());
            if (nvegcb1.isSelected())
            {
                nveg1q.setValue(1);
            }else
            {
                nveg1q.setValue(0);
            }
        }else if (e.getSource()==nvegb2) {
            nvegcb2.setSelected(!nvegcb2.isSelected());
            if (nvegcb2.isSelected())
            {
                nveg2q.setValue(1);
            }else
            {
                nveg2q.setValue(0);
            }
        }else if (e.getSource()==nvegb3) {
            nvegcb3.setSelected(!nvegcb3.isSelected());
            if (nvegcb3.isSelected())
            {
                nveg3q.setValue(1);
            }else
            {
                nveg3q.setValue(0);
            }
        }else if (e.getSource()==nvegb4) {
            nvegcb4.setSelected(!nvegcb4.isSelected());
            if (nvegcb4.isSelected())
            {
                nveg4q.setValue(1);
            }else
            {
                nveg4q.setValue(0);
            }
        }else if (e.getSource()==nvegb5) {
            nvegcb5.setSelected(!nvegcb5.isSelected());
            if (nvegcb5.isSelected())
            {
                nveg5q.setValue(1);
            }else
            {
                nveg5q.setValue(0);
            }
        }else if (e.getSource()==nvegb6) {
            nvegcb6.setSelected(!nvegcb6.isSelected());
            if (nvegcb6.isSelected())
            {
                nveg6q.setValue(1);
            }else
            {
                nveg6q.setValue(0);
            }
        }else if (e.getSource()==Fastfoodb1) {
            ffcb1.setSelected(!ffcb1.isSelected());
            if (ffcb1.isSelected())
            {
                ff1q.setValue(1);
            }else
            {
                ff1q.setValue(0);
            }
        }else if (e.getSource()==Fastfoodb2) {
            ffcb2.setSelected(!ffcb2.isSelected());
            if (ffcb2.isSelected())
            {
                ff2q.setValue(1);
            }else
            {
                ff2q.setValue(0);
            }
        }else if (e.getSource()==Fastfoodb3) {
            ffcb3.setSelected(!ffcb3.isSelected());
            if (ffcb3.isSelected())
            {
                ff3q.setValue(1);
            }else
            {
                ff3q.setValue(0);
            }
        }else if (e.getSource()==Fastfoodb4) {
            ffcb4.setSelected(!ffcb4.isSelected());
            if (ffcb4.isSelected())
            {
                ff4q.setValue(1);
            }else
            {
                ff4q.setValue(0);
            }
        }else if (e.getSource()==Fastfoodb5) {
            ffcb5.setSelected(!ffcb5.isSelected());
            if (ffcb5.isSelected())
            {
                ff5q.setValue(1);
            }else
            {
                ff5q.setValue(0);
            }
        }else if (e.getSource()==Fastfoodb6) {
            ffcb6.setSelected(!ffcb6.isSelected());
            if (ffcb6.isSelected())
            {
                ff6q.setValue(1);
            }else
            {
                ff6q.setValue(0);
            }
        }else if (e.getSource()==juiceb1) {
            juicecb1.setSelected(!juicecb1.isSelected());
            if (juicecb1.isSelected())
            {
                juice1q.setValue(1);
            }else
            {
                juice1q.setValue(0);
            }
        }else if (e.getSource()==juiceb2) {
            juicecb2.setSelected(!juicecb2.isSelected());
            if (juicecb2.isSelected())
            {
                juice2q.setValue(1);
            }else
            {
                juice2q.setValue(0);
            }
        }else if (e.getSource()==juiceb3) {
            juicecb3.setSelected(!juicecb3.isSelected());
            if (juicecb3.isSelected())
            {
                juice3q.setValue(1);
            }else
            {
                juice3q.setValue(0);
            }
        }else if (e.getSource()==juiceb4) {
            juicecb4.setSelected(!juicecb4.isSelected());
            if (juicecb4.isSelected())
            {
                juice4q.setValue(1);
            }else
            {
                juice4q.setValue(0);
            }
        }else if (e.getSource()==juiceb5) {
            juicecb5.setSelected(!juicecb5.isSelected());
            if (juicecb5.isSelected())
            {
                juice5q.setValue(1);
            }else
            {
                juice5q.setValue(0);
            }
        }else if (e.getSource()==juiceb6) {
            juicecb6.setSelected(!juicecb6.isSelected());
            if (juicecb6.isSelected())
            {
                juice6q.setValue(1);
            }else
            {
                juice6q.setValue(0);
            }
        }else if (e.getSource()==Icecreamb1) {
            icecreamcb1.setSelected(!icecreamcb1.isSelected());
            if (icecreamcb1.isSelected())
            {
                icecream1q.setValue(1);
            }else
            {
                icecream1q.setValue(0);
            }
        }else if (e.getSource()==Icecreamb2) {
            icecreamcb2.setSelected(!icecreamcb2.isSelected());
            if (icecreamcb2.isSelected())
            {
                icecream2q.setValue(1);
            }else
            {
                icecream2q.setValue(0);
            }
        }else if (e.getSource()==Icecreamb3) {
            icecreamcb3.setSelected(!icecreamcb3.isSelected());
            if (icecreamcb3.isSelected())
            {
                icecream3q.setValue(1);
            }else
            {
                icecream3q.setValue(0);
            }
        }else if (e.getSource()==Icecreamb4) {
            icecreamcb4.setSelected(!icecreamcb4.isSelected());
            if (icecreamcb4.isSelected())
            {
                icecream4q.setValue(1);
            }else
            {
                icecream4q.setValue(0);
            }
        }else if (e.getSource()==Icecreamb5) {
            icecreamcb5.setSelected(!icecreamcb5.isSelected());
            if (icecreamcb5.isSelected())
            {
                icecream5q.setValue(1);
            }else
            {
                icecream5q.setValue(0);
            }
        }else if (e.getSource()==Icecreamb6) {
            icecreamcb6.setSelected(!icecreamcb6.isSelected());
            if (icecreamcb6.isSelected())
            {
                icecream6q.setValue(1);
            }else
            {
                icecream6q.setValue(0);
            }
        }else if (e.getSource()==Sweetb1) {
            sweetcb1.setSelected(!sweetcb1.isSelected());
            if (sweetcb1.isSelected())
            {
                sweet1q.setValue(1);
            }else
            {
                sweet1q.setValue(0);
            }
        }else if (e.getSource()==Sweetb2) {
            sweetcb2.setSelected(!sweetcb2.isSelected());
            if (sweetcb2.isSelected())
            {
                sweet2q.setValue(1);
            }else
            {
                sweet2q.setValue(0);
            }
        }else if (e.getSource()==Sweetb3) {
            sweetcb3.setSelected(!sweetcb3.isSelected());
            if (sweetcb3.isSelected())
            {
                sweet3q.setValue(1);
            }else
            {
                sweet3q.setValue(0);
            }
        }else if (e.getSource()==Sweetb4) {
            sweetcb4.setSelected(!sweetcb4.isSelected());
            if (sweetcb4.isSelected())
            {
                sweet4q.setValue(1);
            }else
            {
                sweet4q.setValue(0);
            }
        }else if (e.getSource()==Sweetb5) {
            sweetcb5.setSelected(!sweetcb5.isSelected());
            if (sweetcb5.isSelected())
            {
                sweet5q.setValue(1);
            }else
            {
                sweet5q.setValue(0);
            }
        }else if (e.getSource()==Sweetb6) {
            sweetcb6.setSelected(!sweetcb6.isSelected());
            if (sweetcb6.isSelected())
            {
                sweet6q.setValue(1);
            }else
            {
                sweet6q.setValue(0);
            }
        }else if (e.getSource()==backButton1 || e.getSource()==backButton2 || e.getSource()==backButton3 || e.getSource()==backButton4 ||  e.getSource()==backButton5 ||  e.getSource()==backButton6) {
            cardLayout.show(cards, "Menu");
        }else if (e.getSource()==confirmButton1 || e.getSource()==confirmButton2 || e.getSource()==confirmButton3 || e.getSource()==confirmButton4 ||  e.getSource()==confirmButton5 ||  e.getSource()==confirmButton6 ) {
            if (vegcb1.isSelected()||vegcb2.isSelected()||vegcb3.isSelected()||vegcb4.isSelected()||vegcb5.isSelected()||vegcb6.isSelected()||nvegcb1.isSelected()||nvegcb2.isSelected()||nvegcb3.isSelected()||nvegcb4.isSelected()||nvegcb5.isSelected()||nvegcb6.isSelected()||ffcb1.isSelected()||ffcb2.isSelected()||ffcb3.isSelected()||ffcb4.isSelected()||ffcb5.isSelected()||ffcb6.isSelected()||juicecb1.isSelected()||juicecb2.isSelected()||juicecb3.isSelected()||juicecb4.isSelected()||juicecb5.isSelected()||juicecb6.isSelected()||icecreamcb1.isSelected()||icecreamcb2.isSelected()||icecreamcb3.isSelected()||icecreamcb4.isSelected()||icecreamcb5.isSelected()||icecreamcb6.isSelected()||sweetcb1.isSelected()||sweetcb2.isSelected()||sweetcb3.isSelected()||sweetcb4.isSelected()||sweetcb5.isSelected()||sweetcb6.isSelected())
            {
                if (vegcb1.isSelected()) {
                    vegp1=(int)veg1q.getValue();
                }if (vegcb2.isSelected()) {
                vegp2=(int)veg2q.getValue();
            }if (vegcb3.isSelected()) {
                vegp3=(int)veg3q.getValue();
            }if (vegcb4.isSelected()) {
                vegp4=(int)veg4q.getValue();
            }if (vegcb5.isSelected()) {
                vegp5=(int)veg5q.getValue();
            }if (vegcb6.isSelected()) {
                vegp6=(int)veg6q.getValue();
            }if (nvegcb1.isSelected()) {
                nvegp1=(int)nveg1q.getValue();
            }if (nvegcb2.isSelected()) {
                nvegp2=(int)nveg2q.getValue();
            }if (nvegcb3.isSelected()) {
                nvegp3=(int)nveg3q.getValue();
            }if (nvegcb4.isSelected()) {
                nvegp4=(int)nveg4q.getValue();
            }if (nvegcb5.isSelected()) {
                nvegp5=(int)nveg5q.getValue();
            }if (nvegcb6.isSelected()) {
                nvegp6=(int)nveg6q.getValue();
            }if (ffcb1.isSelected()) {
                ffp1=(int)ff1q.getValue();
            }if (ffcb2.isSelected()) {
                ffp2=(int)ff2q.getValue();
            }if (ffcb3.isSelected()) {
                ffp3=(int)ff3q.getValue();
            }if (ffcb4.isSelected()) {
                ffp4=(int)ff4q.getValue();
            }if (ffcb5.isSelected()) {
                ffp5=(int)ff5q.getValue();
            }if (ffcb6.isSelected()) {
                ffp6=(int)ff6q.getValue();
            }if (juicecb1.isSelected()) {
                juicep1=(int)juice1q.getValue();
            }if (juicecb2.isSelected()) {
                juicep2=(int)juice2q.getValue();
            }if (juicecb3.isSelected()) {
                juicep3=(int)juice3q.getValue();
            }if (juicecb4.isSelected()) {
                juicep4=(int)juice4q.getValue();
            }if (juicecb5.isSelected()) {
                juicep5=(int)juice5q.getValue();
            }if (juicecb6.isSelected()) {
                juicep6=(int)juice6q.getValue();
            }if (icecreamcb1.isSelected()) {
                icecreamp1=(int)icecream1q.getValue();
            }if (icecreamcb2.isSelected()) {
                icecreamp2=(int)icecream2q.getValue();
            }if (icecreamcb3.isSelected()) {
                icecreamp3=(int)icecream3q.getValue();
            }if (icecreamcb4.isSelected()) {
                icecreamp4=(int)icecream4q.getValue();
            }if (icecreamcb5.isSelected()) {
                icecreamp5=(int)icecream5q.getValue();
            }if (icecreamcb6.isSelected()) {
                icecreamp6=(int)icecream6q.getValue();
            }if (sweetcb1.isSelected()) {
                sweetp1=(int)sweet1q.getValue();
            }if (sweetcb2.isSelected()) {
                sweetp2=(int)sweet2q.getValue();
            }if (sweetcb3.isSelected()) {
                sweetp3=(int)sweet3q.getValue();
            }if (sweetcb4.isSelected()) {
                sweetp4=(int)sweet4q.getValue();
            }if (sweetcb5.isSelected()) {
                sweetp5=(int)sweet5q.getValue();
            }if (sweetcb6.isSelected()) {
                sweetp6=(int)sweet6q.getValue();
            }
                cardLayout.show(cards, "Payment");
            }
            else{
                JOptionPane.showMessageDialog(null, "Please Select Any Item..!!", "Warning", JOptionPane.ERROR_MESSAGE);
            }
        }else if (e.getSource()==confirmPaymentButton) {
            JOptionPane.showMessageDialog(null, nameField.getText()+" Your Food's has been Successfully Ordered..!!\n       It will be Delivered in 15 Minutes", "Order Placed", JOptionPane.INFORMATION_MESSAGE, greenIcon);
            JFrame f=new JFrame("Invoice");
            JTextArea t=new JTextArea();
            t.setForeground(Color.WHITE);
            t.setBackground(panelColor);
            t.setFont(txf);
            t.setEditable(false);
            JScrollPane scrollPane=new JScrollPane(t);
            scrollPane.setBounds(20,20,530,300);
            StringBuilder sb = new StringBuilder();
            sb.append("   Personal Details").append("\n");
            sb.append("   Name: ").append(nameField.getText()).append("\n");
            sb.append("   Phone Number: ").append(phoneNumberField.getText()).append("\n");
            sb.append("   Address: ").append(addressField.getText()).append("\n");
            sb.append("   Email: ").append(emailField.getText()).append("\n");
            sb.append(paymentdetails.getText());

            t.setText(sb.toString());
            f.add(scrollPane);
            f.setSize(600,330);
            f.setVisible(true);
            try {
                FileWriter writer = new FileWriter("D:\\loozer\\"+nameField.getText()+".txt");
                writer.write(sb.toString());
                writer.close();
                System.out.println("Text successfully written to the file.");
            } catch (IOException ee) {
                ee.printStackTrace();
            }
        }
        String command = e.getActionCommand();

        switch (command) {
            case "VEG":
                cardLayout.show(cards, "VegPanel");
                break;
            case "NON VEG":
                cardLayout.show(cards, "NVegPanel");
                break;
            case "FAST FOOD":
                cardLayout.show(cards, "FastfoodPanel");
                break;
            case "JUICE":
                cardLayout.show(cards, "JuicePanel");
                break;
            case "ICECREAM":
                cardLayout.show(cards, "IcecreamPanel");
                break;
            case "SWEETS":
                cardLayout.show(cards, "SweetPanel");
                break;
        }
        updateSelectedItems();
    }


    public static void main(String[] args) {
        OnlineFoodOrderSystem system = new OnlineFoodOrderSystem();
        Thread t=new Thread(system);
        t.start();
    }

    @Override
    public void run() {
        int y;
        for (y=50;y<=350;y++)
        {
            if(y==350)
                y=50;
            imgl.setBounds(680,y,150,150);
            try {
                Thread.sleep(10);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }

    private void updateSelectedItems() {
        StringBuilder selectedItems = new StringBuilder("   Selected Items: ");
        StringBuilder selectedItems1 = new StringBuilder("  Selected Items                                                Quantity                                      Price\n");
        int total=0;
        if (vegcb1.isSelected()) {
            selectedItems.append("\n    IDLI, ");
            selectedItems1.append("\n   IDLI   $10                                                            "+vegp1+"                                                 "+vegp1*10);
            total=total+(vegp1*10);
        }
        if (vegcb2.isSelected()) {
            selectedItems.append("\n    DOSA, ");
            selectedItems1.append("\n   DOSA   $30                                                        "+vegp2+"                                                 "+vegp2*30);
            total=total+(vegp2*30);
        }
        if (vegcb3.isSelected()) {
            selectedItems.append("\n    PAROTTA, ");
            selectedItems1.append("\n   PAROTTA   $20                                                 "+vegp3+"                                                 "+vegp3*20);
            total=total+(vegp3*20);
        }
        if (vegcb4.isSelected()) {
            selectedItems.append("\n    BUTTER NAAN, ");
            selectedItems1.append("\n   BUTTER NAAN   $30                                        "+vegp4+"                                                 "+vegp4*30);
            total=total+(vegp4*30);
        }
        if (vegcb5.isSelected()) {
            selectedItems.append("\n    PANEER BUTTER MASALA, ");
            selectedItems1.append("\n   PANEER BUTTER MASALA   $70                 "+vegp5+"                                                 "+vegp5*70);
            total=total+(vegp5*70);
        }
        if (vegcb6.isSelected()) {
            selectedItems.append("\n    PANEER NOODLES, ");
            selectedItems1.append("\n   PANEER NOODLES   $100                            "+vegp6+"                                                 "+vegp6*100);
            total=total+(vegp6*100);
        }if (nvegcb1.isSelected()) {
            selectedItems.append("\n    CHICKEN BIRYANI, ");
            selectedItems1.append("\n   CHICKEN BIRYANI   $120                                " + nvegp1 + "                                                 " + nvegp1 * 120);
            total=total+(nvegp1*120);
        }
        if (nvegcb2.isSelected()) {
            selectedItems.append("\n    MUTTON BIRYANI, ");
            selectedItems1.append("\n   MUTTON BIRYANI   $180                                 " + nvegp2 + "                                                 " + nvegp2 * 180);
            total=total+(nvegp2*180);
        }
        if (nvegcb3.isSelected()) {
            selectedItems.append("\n    CHICKEN NOODLES, ");
            selectedItems1.append("\n   CHICKEN NOODLES   $100                           " + nvegp3 + "                                                 " + nvegp3 * 100);
            total=total+(nvegp3*100);
        }
        if (nvegcb4.isSelected()) {
            selectedItems.append("\n    FISH FRY, ");
            selectedItems1.append("\n   FISH FRY   $70                                                  " + nvegp4 + "                                                 " + nvegp4 * 70);
            total=total+(nvegp4*70);
        }
        if (nvegcb5.isSelected()) {
            selectedItems.append("\n    GRILLED CHICKEN, ");
            selectedItems1.append("\n   GRILLED CHICKEN   $150                              " + nvegp5 + "                                                 " + nvegp5 *150 );
            total=total+(nvegp5*150);
        }
        if (nvegcb6.isSelected()) {
            selectedItems.append("\n    PRAWN FRY, ");
            selectedItems1.append("\n   PRAWN FRY   $70                                             " + nvegp6 + "                                                 " + nvegp6 * 70);
            total=total+(nvegp6*70);
        }
        if (ffcb1.isSelected()) {
            selectedItems.append("\n    BURGER, ");
            selectedItems1.append("\n   BURGER   $60                                                    " + ffp1 + "                                                 " + ffp1 * 60);
            total=total+(ffp1*60);
        }
        if (ffcb2.isSelected()) {
            selectedItems.append("\n    PIZZA, ");
            selectedItems1.append("\n   PIZZA   $170                                                        " + ffp2 + "                                                 " + ffp2 * 170);
            total=total+(ffp2*170);
        }
        if (ffcb3.isSelected()) {
            selectedItems.append("\n    SHAWARMA, ");
            selectedItems1.append("\n   SHAWARMA   $80                                             " + ffp3 + "                                                 " + ffp3 * 80);
            total=total+(ffp3*80);
        }
        if (ffcb4.isSelected()) {
            selectedItems.append("\n    FRENCHFRIES, ");
            selectedItems1.append("\n   FRENCHFRIES   $70                                         " + ffp4 + "                                                 " + ffp4 * 70);
            total=total+(ffp4*70);
        }
        if (ffcb5.isSelected()) {
            selectedItems.append("\n    KFC CHICKEN, ");
            selectedItems1.append("\n   KFC CHICKEN   $150                                        " + ffp5 + "                                                 " + ffp5 * 150);
            total=total+(ffp5*150);
        }
        if (ffcb6.isSelected()) {
            selectedItems.append("\n    PANIPORI, ");
            selectedItems1.append("\n   PANIPORI   $50                                                   " + ffp6 + "                                                 " + ffp6 * 50);
            total=total+(ffp6*50);
        }
        if (juicecb1.isSelected()) {
            selectedItems.append("\n    CHOCOLATE MILKSHAKE, ");
            selectedItems1.append("\n   CHOCOLATE MILKSHAKE   $80                    " + juicep1 + "                                                 " + juicep1 * 80);
            total=total+(juicep1*80);
        }
        if (juicecb2.isSelected()) {
            selectedItems.append("\n    OREO MILKSHAKE, ");
            selectedItems1.append("\n   OREO MILKSHAKE   $80                                 " + juicep2 + "                                                 " + juicep2 * 80);
            total=total+(juicep2*80);
        }
        if (juicecb3.isSelected()) {
            selectedItems.append("\n    VANILLA MILKSHAKE, ");
            selectedItems1.append("\n   VANILLA MILKSHAKE   $70                            " + juicep3 + "                                                 " + juicep3 * 70);
            total=total+(juicep3*70);
        }
        if (juicecb4.isSelected()) {
            selectedItems.append("\n    ORANGE JUICE, ");
            selectedItems1.append("\n   ORANGE JUICE   $30                                       " + juicep4 + "                                                 " + juicep4 * 30);
            total=total+(juicep4*30);
        }
        if (juicecb5.isSelected()) {
            selectedItems.append("\n    LEMON JUICE, ");
            selectedItems1.append("\n   LEMON JUICE   $20                                          " + juicep5 + "                                                 " + juicep5 * 20);
            total=total+(juicep5*20);
        }
        if (juicecb6.isSelected()) {
            selectedItems.append("\n    BLUEBERRY MOJITO, ");
            selectedItems1.append("\n   BLUEBERRY MOJITO   $70                             " + juicep6 + "                                                 " + juicep6 * 70);
            total=total+(juicep6*70);
        }
        if (icecreamcb1.isSelected()) {
            selectedItems.append("\n    VANILLA ICECREAM, ");
            selectedItems1.append("\n   VANILLA ICECREAM   $70                             " + icecreamp1 + "                                                 " + icecreamp1 * 70);
            total += icecreamp1 * 70;
        }
        if (icecreamcb2.isSelected()) {
            selectedItems.append("\n    STRAWBERRY ICECREAM, ");
            selectedItems1.append("\n   STRAWBERRY ICECREAM   $80                  " + icecreamp2 + "                                                 " + icecreamp2 * 80);
            total += icecreamp2 * 80;
        }
        if (icecreamcb3.isSelected()) {
            selectedItems.append("\n    CHOCOLATE ICECREAM, ");
            selectedItems1.append("\n   CHOCOLATE ICECREAM   $80                     " + icecreamp3 + "                                                 " + icecreamp3 * 80);
            total += icecreamp3 * 80;
        }
        if (icecreamcb4.isSelected()) {
            selectedItems.append("\n    CHOCOLATE COOKIES, ");
            selectedItems1.append("\n   CHOCOLATE COOKIES   $40                        " + icecreamp4 + "                                                 " + icecreamp4 * 40);
            total += icecreamp4 * 40;
        }
        if (icecreamcb5.isSelected()) {
            selectedItems.append("\n    BLACKCURRANT ICECREAM, ");
            selectedItems1.append("\n   BLACKCURRANT ICECREAM   $50             " + icecreamp5 + "                                                 " + icecreamp5 * 50);
            total += icecreamp5 * 50;
        }
        if (icecreamcb6.isSelected()) {
            selectedItems.append("\n    CARAMEL ICECREAM, ");
            selectedItems1.append("\n   CARAMEL ICECREAM   $150                        " + icecreamp6 + "                                                 " + icecreamp6 * 150);
            total += icecreamp6 * 150;
        }
        if (sweetcb1.isSelected()) {
            selectedItems.append("\n    KAJU KATLI, ");
            selectedItems1.append("\n   KAJU KATLI   $350                                           " + sweetp1 + "                                                 " + sweetp1 * 350);
            total += sweetp1* 350;
        }
        if (sweetcb2.isSelected()) {
            selectedItems.append("\n    RASMALAI, ");
            selectedItems1.append("\n   RASMALAI   $200                                             " + sweetp2+ "                                                 " + sweetp2* 200);
            total += sweetp2* 200;
        }
        if (sweetcb3.isSelected()) {
            selectedItems.append("\n    GULAB JAMUN, ");
            selectedItems1.append("\n   GULAB JAMUN   $100                                     " + sweetp3+ "                                                 " + sweetp3* 100);
            total += sweetp3* 100;
        }
        if (sweetcb4.isSelected()) {
            selectedItems.append("\n    RASGULLA, ");
            selectedItems1.append("\n   RASGULLA   $150                                            " + sweetp4 + "                                                 " + sweetp4* 150);
            total += sweetp4* 150;
        }
        if (sweetcb5.isSelected()) {
            selectedItems.append("\n    HALWA, ");
            selectedItems1.append("\n   HALWA   $120                                                   " + sweetp5+ "                                                 " + sweetp5* 120);
            total += sweetp5* 120;
        }
        if (sweetcb6.isSelected()) {
            selectedItems.append("\n    MILK PEDA, ");
            selectedItems1.append("\n   MILK PEDA   $160                                            " + sweetp6 + "                                                 " + sweetp6* 160);
            total +=sweetp6* 160;
        }

        selectedItems1.append("\n\n\n    TOTAL PRICE  : "+total);

        disp1.setText(selectedItems.toString());
        disp2.setText(selectedItems.toString());
        disp3.setText(selectedItems.toString());
        disp4.setText(selectedItems.toString());
        disp5.setText(selectedItems.toString());
        disp6.setText(selectedItems.toString());
        paymentdetails.setText(selectedItems1.toString());
    }


}

