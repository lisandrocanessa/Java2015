package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import negocio.ControladorLogin;
import entidades.Jugador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtApellido;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registro() {
		setTitle("REGISTRO JUGADOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 172);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 37, 46, 14);
		contentPane.add(lblDni);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setBounds(10, 62, 61, 14);
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("APELLIDO:");
		lblNewLabel.setBounds(10, 87, 61, 14);
		contentPane.add(lblNewLabel);
		
		txtDni = new JTextField();
		txtDni.setBounds(77, 34, 172, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		txtDni.setText("");
		
		txtApellido = new JTextField();
		txtApellido.setBounds(77, 84, 172, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		txtApellido.setText("");
		
		txtNombre = new JTextField();
		txtNombre.setBounds(77, 59, 172, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setText("");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registrarJugador();
			}
		});
		btnAceptar.setBounds(287, 33, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrar();
			}
		});
		btnAtras.setBounds(287, 67, 89, 23);
		contentPane.add(btnAtras);
	}
	
	private void registrarJugador() {
		if (validarCampos()){
			ControladorLogin cl = new ControladorLogin();
			try {
				Jugador j = cl.buscarJugador(Integer.parseInt(this.txtDni.getText()));
				if (j==null){
					j = new Jugador();
					j.setDni(Integer.parseInt(this.txtDni.getText()));
					j.setNombre(this.txtNombre.getText());
					j.setApellido(this.txtApellido.getText());
					cl.guardarJugador(j);
					JOptionPane.showMessageDialog(null, "El jugador ha sido registrado");
				}
				else {
					JOptionPane.showMessageDialog(null, "El jugador ya existe");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "El jugador no pudo registrarse.");
			}
			
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Hay uno o mas campos en blanco.");
		}
	}
	
	private boolean validarCampos(){
//		if (this.txtApellido.getText()!="" && this.txtDni.getText()!="" && this.txtNombre.getText()!="")
//			return true;
//		else
//			return false;
		boolean rta = (!this.txtApellido.getText().equals("") || !this.txtDni.getText().equals("") || !this.txtNombre.getText().equals(""));
		return rta;
	}

	private void cerrar(){
		this.dispose();
	}
}
