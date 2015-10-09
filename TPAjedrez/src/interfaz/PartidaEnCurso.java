package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;

import entidades.Ficha;
import entidades.Partida;

import javax.swing.JTextArea;

import negocio.ControladorPartida;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PartidaEnCurso extends JFrame {

	private JPanel contentPane;
	private Partida partida;
	private JTextArea txtJugadorUno;
	private JTextArea txtJugadorDos;
	private JLabel lblJugadorUno;
	private JLabel lblJugadorDos;
	private JLabel lblJugadorTurno;
	private JComboBox cmbFicha;
	private JComboBox cmbPosX, cmbPosY;
	
	
	/**
	 * Launch the application.
	 */
	
	
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PartidaEnCurso frame = new PartidaEnCurso();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public PartidaEnCurso(Partida p) {
		setResizable(false);
		setTitle("PARTIDA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblJugadorUno = new JLabel("JUGADOR UNO");
		lblJugadorUno.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblJugadorUno.setBounds(69, 23, 114, 29);
		contentPane.add(lblJugadorUno);
		
		JLabel lblVs = new JLabel("VS.");
		lblVs.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVs.setBounds(260, 27, 24, 21);
		contentPane.add(lblVs);
		
		lblJugadorDos = new JLabel("JUGADOR DOS");
		lblJugadorDos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblJugadorDos.setBounds(373, 30, 124, 14);
		contentPane.add(lblJugadorDos);
		
		JScrollPane scrTablero = new JScrollPane();
		scrTablero.setBounds(28, 63, 204, 217);
		contentPane.add(scrTablero);
		
		txtJugadorUno = new JTextArea();
		txtJugadorUno.setEnabled(false);
		txtJugadorUno.setRows(16);
		txtJugadorUno.setLineWrap(true);
		scrTablero.setViewportView(txtJugadorUno);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(323, 63, 204, 217);
		contentPane.add(scrollPane);
		
		txtJugadorDos = new JTextArea();
		txtJugadorDos.setEnabled(false);
		txtJugadorDos.setRows(16);
		scrollPane.setViewportView(txtJugadorDos);
		
		JLabel lblTurnoDe = new JLabel("Turno de:");
		lblTurnoDe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTurnoDe.setBounds(193, 305, 60, 14);
		contentPane.add(lblTurnoDe);
		
		lblJugadorTurno = new JLabel("JUGADORTURNO");
		lblJugadorTurno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblJugadorTurno.setBounds(263, 305, 104, 14);
		contentPane.add(lblJugadorTurno);
		
		cmbFicha = new JComboBox();
		cmbFicha.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			}
		});
		cmbFicha.setBounds(118, 337, 114, 20);
		contentPane.add(cmbFicha);
		
		JLabel lblFicha = new JLabel("Ficha:");
		lblFicha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFicha.setBounds(70, 339, 38, 14);
		contentPane.add(lblFicha);
		
		JButton btnRealizarMovimiento = new JButton("REALIZAR MOVIMIENTO");
		btnRealizarMovimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorPartida cp = new ControladorPartida();
				cp.realizarMovimiento(cmbFicha.getSelectedItem().toString(), cmbPosX.getSelectedIndex()+1, cmbPosY.getSelectedIndex()+1);
			}
		});
		btnRealizarMovimiento.setBounds(203, 382, 149, 23);
		contentPane.add(btnRealizarMovimiento);
		
		JComboBox cmbPosY = new JComboBox();
		cmbPosY.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		cmbPosY.setBounds(365, 337, 37, 20);
		contentPane.add(cmbPosY);
		
		JComboBox cmbPosX = new JComboBox();
		cmbPosX.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		cmbPosX.setToolTipText("");
		cmbPosX.setBounds(469, 337, 38, 20);
		contentPane.add(cmbPosX);
		
		JLabel lblX = new JLabel("Fila:");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblX.setBounds(329, 339, 38, 14);
		contentPane.add(lblX);
		
		JLabel lblY = new JLabel("Columna:");
		lblY.setBounds(412, 340, 47, 14);
		contentPane.add(lblY);
		this.partida = p;
		iniciarPartida();
		
	}

	public Partida getPartida() {
		return partida;
	}
	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	// inicializa el tablero
	public void iniciarPartida() {
		// TODO Auto-generated method stub
		this.lblJugadorUno.setText(Integer.toString(this.getPartida().getJ1().getDni()));
		this.lblJugadorDos.setText(Integer.toString(this.getPartida().getJ2().getDni()));
		listarPiezas();
		
		
		// falta llenar los combobox!!
	}

	@SuppressWarnings("unchecked")
	private void listarPiezas(){
		ControladorPartida cp=new ControladorPartida();
		ArrayList<String> piezasCombo=new ArrayList<>();
		for (Ficha f : this.partida.getTablero()){
			if (f.getDni()==this.partida.getJ1().getDni()){
				this.txtJugadorUno.append("  "+f.getNombre() + "     (" + f.getPosX() + ",   " + f.getPosY() + ")"+f.isEstado()+"\n");
			}
			else if (f.getDni()==this.partida.getJ2().getDni()) {
				this.txtJugadorDos.append("  "+f.getNombre() + "     (" + f.getPosX() + ",   " + f.getPosY() + ")"+f.isEstado()+"\n");
			}
		}
		if (this.partida.getTurno()==1){
			this.lblJugadorTurno.setText(Integer.toString(this.partida.getJ1().getDni()));
			try {
				piezasCombo=cp.dameFichasNoComidas(this.partida.getJ1().getDni(),this.partida.getNroPartida());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			this.lblJugadorTurno.setText(Integer.toString(this.partida.getJ2().getDni()));
			try {
				piezasCombo=cp.dameFichasNoComidas(this.partida.getJ2().getDni(),this.partida.getNroPartida());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@SuppressWarnings("rawtypes")
		DefaultComboBoxModel mdlCombo= new DefaultComboBoxModel();
		cmbFicha.setModel(mdlCombo);
		for (int i = 0; i < piezasCombo.size(); i++) {
			mdlCombo.addElement(piezasCombo.get(i));
		}
	}
}
