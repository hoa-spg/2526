import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class Bildschirm {

    private static final String TITLE                   = "Der Spengermat\u2122 - \u00A9 2022 by SLM";
    private static final String LINE                    = "#################################";
    private static final String LINE_EMPTY              = "#\t\t\t\t#";
    private static final String LINE_BREAK              = "\n";
    private static final String MSG_ERROR_MISSING_UNIT  = "Elektronische Einheit fehlt  #";
    private static final Color COLOR_BLUE               = new Color(64, 64, 224);
    private static final Color FONT_COLOR_TERMINAL      = new Color(219, 219, 255);
    private static final Color COLOR_RED_DARK           = new Color(166, 10, 36);
    private static final Color COLOR_RED_LIGHT          = new Color(255, 99, 104);
    private static final Color COLOR_GRAD_START         = new Color(250,30,40,210);
    private static final Color COLOR_GRAD_END           = new Color(250,30,40,40);

    private static final String ICON_BUY                = "icons/buy.png";
    private static final String ICON_CHANGE             = "icons/change.png";
    private static final String ICON_COIN               = "icons/coin.png";

    private static final int FRAME_WIDTH                = 420;
    private static final int FRAME_HEIGHT               = 290;
    private static final int BORDER_WIDTH               = 30;

    private JFrame frame;
    private JFormattedTextField textField;
    private NeuerTicketAutomat ticketautomat;

    
    public Bildschirm() {
        init();
    }

    private void init() {

        frame = new JFrame( Bildschirm.TITLE );
        textField = new JFormattedTextField("");

        JPanel contentPanel = new JPanel(new BorderLayout(0,0)) {
            protected void paintComponent(Graphics g) {
                if (g instanceof Graphics2D) {
                    Graphics2D g2d = (Graphics2D)g;
                    g2d.setPaint(COLOR_RED_DARK);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                    g2d.setPaint(new GradientPaint(0.0f, 0.0f, COLOR_GRAD_START,
                                 getWidth(), getHeight(), COLOR_GRAD_END, true));
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                } else {
                    super.paintComponent(g);
                }
            }
        };

        contentPanel.setBorder(BorderFactory.createEmptyBorder(BORDER_WIDTH, BORDER_WIDTH, BORDER_WIDTH, BORDER_WIDTH));

        textField.setBorder(
                new CompoundBorder(
                        BorderFactory.createMatteBorder(0, 0, 2, 2, COLOR_RED_LIGHT),
                        BorderFactory.createMatteBorder(2, 2, 0, 0, COLOR_RED_DARK)
                )
        );

        textField.setFont(new Font("Courier", Font.PLAIN, 20));
        textField.setForeground( FONT_COLOR_TERMINAL);
        textField.setEditable(false);

        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setVgap(BORDER_WIDTH);
        flowLayout.setHgap(BORDER_WIDTH);

        JPanel buttonPanel = new JPanel( flowLayout );
        buttonPanel.setOpaque(false);
        textField.setOpaque(false);

        JButton btnGeldEinwerfen = createButton(ICON_COIN, "Geld einwerfen", 38);
        btnGeldEinwerfen.addActionListener(e -> geldEinwerfen());

        JButton btnWechselgeld = createButton(ICON_CHANGE, "Wechselgeld auszahlen", 38);
        btnWechselgeld.addActionListener(e -> wechselGeldAuszahlen());

        JButton btnTicketKaufen = createButton(ICON_BUY, "Ticket kaufen", 38);
        btnTicketKaufen.addActionListener(e -> ticketKaufen());

        buttonPanel.add(btnGeldEinwerfen);
        buttonPanel.add(btnWechselgeld);
        buttonPanel.add(btnTicketKaufen);

        enableButton(false, btnGeldEinwerfen, btnWechselgeld, btnTicketKaufen);

        JPanel textFieldPanel = new JPanel( new BorderLayout(0,0)) {
            protected void paintComponent(Graphics g) {
                if (g instanceof Graphics2D) {
                    Graphics2D g2d = (Graphics2D)g;
                    g2d.setPaint( COLOR_BLUE );
                    g2d.fillRect(0, 0, getWidth(), getHeight());

                    g2d.setPaint(new GradientPaint( 0.0f, 0.0f, new Color(255, 255, 255, 10),
                                 getWidth()/2, (float) (getHeight()/2), new Color(255, 255, 255, 80), true));
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                } else {
                    super.paintComponent(g);
                }
            }
        };
        textFieldPanel.add(textField, BorderLayout.CENTER);

        contentPanel.add(textFieldPanel, BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(FRAME_WIDTH + (BORDER_WIDTH * 2), FRAME_HEIGHT + (BORDER_WIDTH * 3));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(contentPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        javax.swing.SwingUtilities.invokeLater(this::boot);
        enableButton(true, btnGeldEinwerfen, btnWechselgeld, btnTicketKaufen);
    }

    public void geldEinwerfen(){
        if (ticketautomat != null) {
            try {
                String betragStr = JOptionPane.showInputDialog(frame, "Betrag in Cent eingeben");
                ticketautomat.einwerfen(Integer.parseInt(betragStr));
                showInfos();
            } catch (NumberFormatException e) {
                showErrors("Währung ungültig");
            } catch (Exception e) {
                showErrors("Unerwarteter Fehler");
            }
        } else {
            showErrors(MSG_ERROR_MISSING_UNIT);
        }
    }

    private JButton createButton(String icon, String tooltip, int size) {
        JButton button = new JButton(loadImageIcon(icon));
        button.setToolTipText(tooltip);
        button.setSize(size, size);
        button.setPreferredSize(button.getSize());
        return button;
    }

    private ImageIcon loadImageIcon(String iconName) {
        ImageIcon icon = new ImageIcon(iconName);
        Image img = icon.getImage();
        return new ImageIcon(img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
    }

    private void showErrors(String message) {
        textField.setText(
                LINE + LINE_BREAK + LINE_EMPTY + LINE_BREAK +
                        "#  E R R O R !\t\t\t#\n" +
                        LINE_EMPTY + LINE_BREAK +
                        "#  " + message + "!\t\t#\n" +
                        LINE_EMPTY + LINE_BREAK + LINE);
    }

    private void showInfos() {
        if (ticketautomat != null) {
            textField.setText(ticketautomat.status() + "\n\t\t\tREADY...");
        } else {
            showErrors(MSG_ERROR_MISSING_UNIT);
        }
    }

    private void enableButton(boolean enable, JButton ... buttons) {
        for (JButton btn: buttons) {
            btn.setEnabled(enable);
        }
    }

    private void boot() {
        new Thread( () -> {
            String booting = "BOOTING SYSTEM ";
            StringBuilder points = new StringBuilder(".");
            for (int i = 0; i < 12; i++) {
                try {
                    textField.setText("\n\n   " + booting + points);
                    Thread.sleep(120);
                    if (i % 4 == 0) {
                        points.append(".");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            showInfos();
        }).start();
    }

    private void ticketKaufen() {
        if(ticketautomat != null) {
            new Thread( () -> {
                try {
                    ticketautomat.ticketDrucken();
                    String ticket = ticketautomat.ticketString();
                    textField.setText(ticket);
                    Thread.sleep(2500);
                    showInfos();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }).start();
        } else {
            showErrors( MSG_ERROR_MISSING_UNIT );
        }
    }

    private void wechselGeldAuszahlen() {
        if(ticketautomat != null) {
            new Thread( () -> {
                try {
                    int wechselgeld = ticketautomat.wechselGeldAuszahlen();
                    textField.setText("Zahle Wechselgeld " + wechselgeld + " Cent aus.");
                    Thread.sleep(2500);
                    showInfos();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }).start();
        } else {
            showErrors(MSG_ERROR_MISSING_UNIT);
        }
    }

    public NeuerTicketAutomat getTicketautomat() {
        return ticketautomat;
    }

    public void setTicketautomat(NeuerTicketAutomat ticketautomat) {
        this.ticketautomat = ticketautomat;
        if (ticketautomat != null) {
            textField.setText(ticketautomat.status() + "\n\t\t\tREADY...");
        } else {
            showErrors(MSG_ERROR_MISSING_UNIT);
        }
    }

    public static void main(String[] args) {
        Bildschirm b = new Bildschirm();
        NeuerTicketAutomat t = new NeuerTicketAutomat("Praterstern", 20);
        b.setTicketautomat(t);
    }
    
}
