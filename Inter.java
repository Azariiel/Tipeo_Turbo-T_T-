import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.text.*;
import java.util.*;
public class Inter extends JDialog implements ActionListener {
    private JButton volverb;
    private JButton nombre;
    private JTextField texto;
    private JLabel label1;
    private JLabel label2;
    private JLabel temporizador;
    private int palabrasCorrectas;
    private int palabrasIncorrectas;
    private static Set<String> palabrasMostradas = new HashSet<>();
    private static final int MAX_CHARACTERS = 17;
    private Timer tiempo;
    private Integer segundosRestantes = 150;

  public Inter(pantalla parent, boolean modal) {
    super(parent, modal);
    getContentPane().setBackground(Color.BLACK);
    setLayout(null);
    setBounds(0, 0, 800, 415);
    setResizable(false);

    int x = parent.getX() + (parent.getWidth() - getWidth()) / 2;
      int y = parent.getY() + (parent.getHeight() - getHeight()) / 2;
      setLocation(x, y);
    // label1
    label1 = new JLabel(palabras());
    label1.setBounds(0, 75, 800, 415);
    label1.setHorizontalAlignment(SwingConstants.CENTER);
    label1.setVerticalAlignment(SwingConstants.TOP);
    label1.setForeground(Color.WHITE);
    // label2
    label2 = new JLabel("");
    label2.setBounds(0, 100, 800, 415);
    label2.setHorizontalAlignment(SwingConstants.CENTER);
    label2.setVerticalAlignment(SwingConstants.TOP);
    label2.setForeground(Color.WHITE);
    // Botón
    volverb = new JButton("←");
    volverb.setBounds(0, 0, 50, 50);
    volverb.addActionListener(this);
    // nombre
    ImageIcon enviar = new ImageIcon("img/enviar.png");
    nombre = new JButton(enviar);
    nombre.setBounds(335, 252, 125, 25);
    nombre.addActionListener(this);
    //Temporizador
    tiempo = new Timer(1000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          segundosRestantes--;
          temporizador.setText(Integer.toString(segundosRestantes));
          if (segundosRestantes == 0) {
            tiempo.stop();
            JOptionPane.showMessageDialog(Inter.this, "¡Tiempo agotado!");
            palabrasMostradas.clear();
            setVisible(false);
        }
    }
});
  
  // Iniciar el temporizador
  tiempo.start();
  //Label del temporizador
  temporizador = new JLabel();
  temporizador.setBounds(750,10, 125, 25);
  temporizador.setForeground(Color.WHITE);
    // texto
    texto = new JTextField();
    texto.setBounds(275, 197, 250, 25);
    PlainDocument doc = new PlainDocument() {
      @Override
      public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
          if (getLength() + str.length() <= MAX_CHARACTERS) {
              super.insertString(offs, str, a);
          }
      }
    };
    texto.setDocument(doc);
    texto.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          verificarPalabra();
        }
      }
    });
    // añadir
    add(texto);
    add(nombre);
    add(texto);
    add(label1);
    add(label2);
    add(temporizador);
    add(volverb);
  }
 public void actionPerformed(ActionEvent e) {
    if (e.getSource() == volverb) {
      setVisible(false);
    }
    if (e.getSource() == nombre) {
      verificarPalabra();
    }
  }
  public static String palabras() {
    Random rand = new Random();
    String[] palabras = {"Computadora", "Teclado", "Velocidad", "Precisión", "Ejercicio", 
        "Palabras", "Práctica", "Examen", "Habilidad", "Aprendizaje", "Desarrollo",
        "Comunicación", "Profesional", "Proyecto", "Presentación", "Tiburón", "Azulejo", "Ropero"};

    // Elegir una palabra aleatoria que no se haya mostrado
    String palabraAleatoria = "";
    do {
      int indiceAl = rand.nextInt(palabras.length);
      palabraAleatoria = palabras[indiceAl];
    } while (palabrasMostradas.contains(palabraAleatoria));
    
    // Agregar la palabra al conjunto de palabras mostradas
    palabrasMostradas.add(palabraAleatoria);

    return palabraAleatoria;
  }
  private void verificarPalabra() {
    String respuesta = texto.getText();
    label2.setText("");
    if (respuesta.equals(label1.getText())) {
      palabrasCorrectas++;
      if (palabrasCorrectas >= 15) {
        JOptionPane.showMessageDialog(this, "Has ingresado 15 palabras correctamente. El programa ha terminado. Tus errores fueron: "+palabrasIncorrectas);
        palabrasMostradas.clear();
        setVisible(false);
      } else {
        label1.setText(palabras());
        texto.setText(""); // Limpiar el campo de texto
      }
    } else {
      palabrasIncorrectas++;
      label2.setText("Inténtalo de nuevo.");
      texto.setText(""); // Limpiar el campo de texto
      if(palabrasIncorrectas>=25){
        JOptionPane.showMessageDialog(this, "Hiciste 25 errores. Vuelve a intentarlo.");
        palabrasMostradas.clear();
        setVisible(false);
      }
    }
  }
}
