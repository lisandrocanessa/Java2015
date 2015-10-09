package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import entidades.Jugador;
import entidades.Partida;
import negocio.ControladorLogin;
import negocio.ControladorPartida;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtDniJugadorUno;
	private JTextField txtDniJugadorDos;

	/**
	 * Launch the application.
	 */
	//Este es el login
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 173);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDniJugadorUno = new JLabel("DNI JUGADOR UNO: ");
		lblDniJugadorUno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDniJugadorUno.setBounds(10, 11, 129, 21);
		contentPane.add(lblDniJugadorUno);
		
		JLabel lblDniJugadorDos = new JLabel("DNI JUGADOR DOS: ");
		lblDniJugadorDos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDniJugadorDos.setBounds(10, 43, 129, 21);
		contentPane.add(lblDniJugadorDos);
		
		txtDniJugadorUno = new JTextField();
		txtDniJugadorUno.setBounds(149, 11, 275, 20);
		contentPane.add(txtDniJugadorUno);
		txtDniJugadorUno.setColumns(10);
		
		txtDniJugadorDos = new JTextField();
		txtDniJugadorDos.setBounds(149, 42, 275, 20);
		contentPane.add(txtDniJugadorDos);
		txtDniJugadorDos.setColumns(10);
		
		JButton btnIniciarNuevaPartida = new JButton("INICIAR NUEVA PARTIDA");
		btnIniciarNuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIniciarNuevaPartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				iniciarPartida();
			}

		});
		btnIniciarNuevaPartida.setBounds(220, 73, 214, 23);
		contentPane.add(btnIniciarNuevaPartida);
		
		JButton btnRegistrarNuevoJugador = new JButton("REGISTRAR NUEVO JUGADOR");
		btnRegistrarNuevoJugador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				registrarJugador();
			}

		});
		btnRegistrarNuevoJugador.setBounds(220, 107, 214, 23);
		contentPane.add(btnRegistrarNuevoJugador);
	}
	
	private void iniciarPartida() {
		// TODO Auto-generated method stub
		if (!this.txtDniJugadorUno.getText().equals("") && !this.txtDniJugadorDos.getText().equals("")) {
		
			ControladorLogin cl = new ControladorLogin();
			int dni1 = Integer.parseInt(txtDniJugadorUno.getText());
			int dni2 = Integer.parseInt(txtDniJugadorDos.getText());
			try {
				Jugador j1 = cl.buscarJugador(dni1);
				Jugador j2 = cl.buscarJugador(dni2);
				if (j1 == null) {
					JOptionPane.showMessageDialog(null,
							"El jugador 1 no esta registrado");
				} else if (j2 == null) {
					JOptionPane.showMessageDialog(null,
							"El jugador 2 no esta registrado");
				} else {
					ControladorPartida cp = new ControladorPartida();
					Partida p = cp.partidaAnterior(j1, j2);
					if (p == null){
						// inicia nueva partida
						p = cp.iniciarPartida(j1,j2);
						p.setTablero(cp.inicializarTablero(p));
						PartidaEnCurso pec = new PartidaEnCurso(p);
						pec.setVisible(true);
					}
					else {
						// si existen partidas anteriores pregunta si se desea continuar alguna
						// sino inicia una nueva
						int rta = JOptionPane.showConfirmDialog(null, "Existe una partida anterior, desea continuarla?", 
								"Partidas Anteriores", JOptionPane.YES_NO_OPTION);
						if (rta == JOptionPane.YES_OPTION){
							p.setTablero(cp.cargarTablero(p));
							PartidaEnCurso pec = new PartidaEnCurso(p);
							pec.setVisible(true);
						}
						else if(rta==JOptionPane.NO_OPTION){
							p = cp.sobreescribirPartida(p);
							PartidaEnCurso pec = new PartidaEnCurso(p);
							pec.setVisible(true);
						}
					}
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Ha ocurrido un problema");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Hay campos incompletos");
		}
		
	}
	private void registrarJugador() {
		Registro r=new Registro();
		r.setVisible(true);
	}
}
