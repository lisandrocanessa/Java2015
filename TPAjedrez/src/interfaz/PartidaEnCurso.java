package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;

import entidades.Partida;

public class PartidaEnCurso extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Partida partida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartidaEnCurso frame = new PartidaEnCurso();
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
	public PartidaEnCurso() {
		setResizable(false);
		setTitle("PARTIDA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJugadorUno = new JLabel("JUGADOR UNO");
		lblJugadorUno.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblJugadorUno.setBounds(69, 23, 114, 29);
		contentPane.add(lblJugadorUno);
		
		JLabel lblVs = new JLabel("VS.");
		lblVs.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVs.setBounds(260, 27, 24, 21);
		contentPane.add(lblVs);
		
		JLabel lblJugadorDos = new JLabel("JUGADOR DOS");
		lblJugadorDos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblJugadorDos.setBounds(373, 30, 124, 14);
		contentPane.add(lblJugadorDos);
		
		JScrollPane scrTablero = new JScrollPane();
		scrTablero.setBounds(28, 63, 204, 217);
		contentPane.add(scrTablero);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(323, 63, 204, 217);
		contentPane.add(scrollPane);
		
		JLabel lblTurnoDe = new JLabel("Turno de:");
		lblTurnoDe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTurnoDe.setBounds(193, 305, 60, 14);
		contentPane.add(lblTurnoDe);
		
		JLabel lblJugadorturno = new JLabel("JUGADORTURNO");
		lblJugadorturno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblJugadorturno.setBounds(263, 305, 104, 14);
		contentPane.add(lblJugadorturno);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(118, 337, 114, 20);
		contentPane.add(comboBox);
		
		JLabel lblFicha = new JLabel("Ficha:");
		lblFicha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFicha.setBounds(70, 339, 38, 14);
		contentPane.add(lblFicha);
		
		JLabel lblMoverA = new JLabel("Mover a:");
		lblMoverA.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMoverA.setBounds(273, 339, 52, 14);
		contentPane.add(lblMoverA);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(342, 337, 83, 20);
		contentPane.add(comboBox_1);
		
		JButton btnRealizarMovimiento = new JButton("REALIZAR MOVIMIENTO");
		btnRealizarMovimiento.setBounds(203, 382, 149, 23);
		contentPane.add(btnRealizarMovimiento);
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}
}
