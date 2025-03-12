import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MiVentana extends JFrame {

    public MiVentana() {
        // Crear el JFrame
        setTitle("Registro de Usuario");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Crear un JPanel
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null); // Usar layout nulo para posicionar los componentes manualmente

        // JLabel y JTextField para Nombre
        JLabel lblnombre = new JLabel("Nombre:");
        lblnombre.setBounds(10, 20, 100, 25);
        panel.add(lblnombre);
        JTextField tfnombre = new JTextField(20);
        tfnombre.setBounds(120, 20, 165, 25);
        panel.add(tfnombre);

        // JLabel y JTextField para Apellido Paterno
        JLabel lblapellidop = new JLabel("Apellido Paterno:");
        lblapellidop.setBounds(10, 55, 100, 25);
        panel.add(lblapellidop);
        JTextField tfapellidop = new JTextField(20);
        tfapellidop.setBounds(120, 55, 165, 25);
        panel.add(tfapellidop);

        // JLabel y JTextField para Apellido Materno
        JLabel lblapellidom = new JLabel("Apellido Materno:");
        lblapellidom.setBounds(10, 90, 100, 25);
        panel.add(lblapellidom);
        JTextField tfapellidom = new JTextField(20);
        tfapellidom.setBounds(120, 90, 165, 25);
        panel.add(tfapellidom);

        // JLabel y JTextField para Edad
        JLabel lbledad = new JLabel("Edad:");
        lbledad.setBounds(10, 125, 100, 25);
        panel.add(lbledad);
        JTextField tfedad = new JTextField(20);
        tfedad.setBounds(120, 125, 165, 25);
        panel.add(tfedad);

        // JLabel y JTextField para Correo Electrónico
        JLabel lblcorreo = new JLabel("Correo Electrónico:");
        lblcorreo.setBounds(10, 160, 120, 25);
        panel.add(lblcorreo);
        JTextField tfcorreo = new JTextField(20);
        tfcorreo.setBounds(140, 160, 165, 25);
        panel.add(tfcorreo);

        // JLabel y JTextField para Contraseña
        JLabel lblcontrasena = new JLabel("Contraseña:");
        lblcontrasena.setBounds(10, 195, 100, 25);
        panel.add(lblcontrasena);
        JPasswordField pfcontrasena = new JPasswordField(20);
        pfcontrasena.setBounds(120, 195, 165, 25);
        panel.add(pfcontrasena);

        // JLabel para Género
        JLabel lblgenero = new JLabel("Género:");
        lblgenero.setBounds(10, 230, 100, 25);
        panel.add(lblgenero);

        // JRadioButton para Género
        JRadioButton rbMasculino = new JRadioButton("Masculino");
        rbMasculino.setBounds(120, 230, 100, 25);
        panel.add(rbMasculino);

        JRadioButton rbFemenino = new JRadioButton("Femenino");
        rbFemenino.setBounds(220, 230, 100, 25);
        panel.add(rbFemenino);

        // Agrupar los JRadioButton
        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(rbMasculino);
        grupoGenero.add(rbFemenino);

        // Crear un JButton para registrar
        JButton button = new JButton("Registrar");
        button.setBounds(10, 265, 150, 25);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código a ejecutar cuando se haga clic en el botón
                Usuario usuario1= new Usuario(tfnombre.getText(),tfapellidop.getText(),tfapellidom.getText(),Integer.parseInt(tfedad.getText()),tfcorreo.getText(), new String(pfcontrasena.getPassword()));
                System.out.println("¡Usuario registrado!");
                usuario1.imprimirUsuario();
            }
        });

        /* USAR PARA TEXTO
         * button.addActionListener(e -> System.out.println("¡Usuario registrado!"));
        */
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        MiVentana ventana = new MiVentana();
        ventana.setVisible(true);
    }
}
