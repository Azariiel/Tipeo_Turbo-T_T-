import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class pantalla extends JFrame implements ActionListener {
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton jugarb;
    private JButton creditosb;
    private JButton salir;
    private JButton princ;
    private JButton inter;
    private JButton avan;
    private JButton emp;
    private JButton regresar;
    private int aux = 0;

    public pantalla() {
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        setLayout(null);
        setBounds(0, 0, 800, 415);
        setResizable(false);
        setTitle("T_T");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Crea Label1
        label1 = new JLabel("¡BIENVENIDO!");
        label1.setFont(new Font("Sans_Serif", Font.PLAIN, 18));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setVerticalAlignment(SwingConstants.TOP);
        label1.setBounds(0, 75, 800, 415);
        label1.setForeground(Color.WHITE);
        // Crea Label2
        label2 = new JLabel("");
        label2.setFont(new Font("Sans_Serif", Font.PLAIN, 18));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setVerticalAlignment(SwingConstants.TOP);
        label2.setBounds(0, 100, 800, 415);
        label2.setForeground(Color.WHITE);
        // Crea Label3
        label3 = new JLabel("");
        label3.setFont(new Font("Sans_Serif", Font.PLAIN, 18));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setVerticalAlignment(SwingConstants.TOP);
        label3.setBounds(0, 125, 800, 415);
        label3.setForeground(Color.WHITE);
        // Crea JugarB
        ImageIcon jugar = new ImageIcon("img/jugar.png");
        jugarb = new JButton(jugar);
        jugarb.setBounds(335, 210, 125, 25);
        jugarb.addActionListener(this);
        // Crea CreditosB
        ImageIcon creditos = new ImageIcon("img/creditos.png");
        creditosb = new JButton(creditos);
        creditosb.setBounds(335, 255, 125, 25);
        creditosb.addActionListener(this);
        // Crea Salir
        ImageIcon salirb = new ImageIcon("img/salir.png");
        salir = new JButton(salirb);
        salir.setBounds(335, 300, 125, 28);
        salir.addActionListener(this);
        // Crea Principiante
        ImageIcon principiante = new ImageIcon("img/princip.jpg");
        princ = new JButton(principiante);
        princ.setBounds(315, 162, 172, 40);
        princ.setVisible(false);
        princ.addActionListener(this);
        // Crea Intermedio
        ImageIcon intermedio = new ImageIcon("img/Intermedio.png");
        inter = new JButton(intermedio);
        inter.setBounds(315, 219, 173, 40);
        inter.setVisible(false);
        inter.addActionListener(this);
        // Crea Avanzado
        ImageIcon avanzado = new ImageIcon("img/avanzado.jpg");
        avan = new JButton(avanzado);
        avan.setBounds(315, 280, 172, 40);
        avan.setVisible(false);
        avan.addActionListener(this);
        // Crea Empezar
        ImageIcon empezar = new ImageIcon("img/empezar.jpg");
        emp = new JButton(empezar);
        emp.setBounds(315, 210, 152, 40);
        emp.setVisible(false);
        emp.addActionListener(this);
        // Crea Regresar
        regresar = new JButton("←");
        regresar.setBounds(0, 0, 50, 50);
        regresar.setVisible(false);
        regresar.addActionListener(this);
        // Añadir
        add(label1);
        add(label2);
        add(label3);
        add(jugarb);
        add(creditosb);
        add(salir);
        add(princ);
        add(inter);
        add(avan);
        add(emp);
        add(regresar);
        setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salir) {
            System.exit(0);
        }
        if (e.getSource() == jugarb) {
            creditosb.setVisible(false);
            jugarb.setVisible(false);
            salir.setVisible(false);
            princ.setVisible(true);
            inter.setVisible(true);
            avan.setVisible(true);
            regresar.setVisible(true);
            label1.setText("Selecciona la dificultad");
        }
        if (e.getSource() == regresar) {
            this.setVisible(true);
            jugarb.setVisible(true);
            creditosb.setVisible(true);
            salir.setVisible(true);
            label1.setText("¡BIENVENIDO!");
            label1.setFont(new Font("Sans_Serif", Font.PLAIN, 18));
            label2.setText("");
            label3.setText("");
            princ.setVisible(false);
            inter.setVisible(false);
            avan.setVisible(false);
            emp.setVisible(false);
            regresar.setVisible(false);
        }
        if (e.getSource() == creditosb) {
            label1.setText("Hecho por GoatsCode Team");
            label1.setFont(new Font("Serif", Font.PLAIN, 18));
            label2.setText("Antonio, Miguel, Hernan,");
            label3.setText("Azariel y Leonardo");
            creditosb.setVisible(false);
            jugarb.setVisible(false);
            salir.setVisible(false);
            regresar.setVisible(true);
        }
        if (e.getSource() == princ) {
            Principiante();
        }
        if (e.getSource() == inter) {
            Intermedio();
        }
        if (e.getSource() == avan) {
            Avanzado();
        }
        if (e.getSource() == emp) {
            if(aux == 1){
                principiante princip = new principiante(this, true);
                this.setVisible(false);
                princip.setModal(true);
                princip.setLocationRelativeTo(this);
                princip.setVisible(true);
                this.setVisible(true);
            }
            
            if(aux == 2){
                Inter intermedio = new Inter(this, true);
                this.setVisible(false);
                intermedio.setModal(true);
                intermedio.setLocationRelativeTo(this);
                intermedio.setVisible(true);
                this.setVisible(true);
            }
            if(aux == 3){
                avanzado avanza = new avanzado(this, true);
                this.setVisible(false);
                avanza.setModal(true);
                avanza.setLocationRelativeTo(this);
                avanza.setVisible(true);
                this.setVisible(true);
            }
        }
    }
    public void Principiante(){
            princ.setVisible(false);
            inter.setVisible(false);
            avan.setVisible(false);
            emp.setVisible(true);
            regresar.setVisible(true);
            label1.setText("Bienvenido a la dificultad Principiante.");
            label2.setText("Escribe 10 palabras correctamente en 90 segundos. Solo puedes hacer 40 errores.");
            label3.setText("Haz click en el siguiente botón.");
            aux = 1;
    }
    public void Intermedio(){
            princ.setVisible(false);
            inter.setVisible(false);
            avan.setVisible(false);
            emp.setVisible(true);
            regresar.setVisible(true);
            label1.setText("Bienvenido a la dificultad Intermedia.");
            label2.setText("Escribe 15 palabras correctamente en 150 segundos. Solo puedes hacer 25 errores.");
            label3.setText("Haz click en el siguiente botón.");
            aux = 2;
    }
    public void Avanzado(){
            princ.setVisible(false);
            inter.setVisible(false);
            avan.setVisible(false);
            emp.setVisible(true);
            regresar.setVisible(true);
            label1.setText("Bienvenido a la dificultad Avanzada.");
            label2.setText("Escribe 20 palabras correctamente en 210 segundos. Solo puedes hacer 10 errores.");
            label3.setText("Haz click en el siguiente botón.");
            aux = 3;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            new pantalla();
            
        }
    });
    }
}