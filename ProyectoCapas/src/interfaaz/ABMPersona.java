package interfaaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import entidades.Persona;
import negocio.ControladorPersona;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class ABMPersona extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ControladorPersona cp=new ControladorPersona();

	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JTextField txtApellido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMPersona frame = new ABMPersona();
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
	public ABMPersona() {
		setTitle("ABM Persona");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 294);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setForeground(new Color(255, 255, 255));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(255, 255, 255));
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(255, 255, 255));
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setForeground(new Color(255, 255, 255));
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscar();
			}
		});
		
		JLabel lblTitulo = new JLabel("ABM Personas");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				borrar();
			}
		});
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				guardar();
			}

			
		});
		
		JLabel lblBottom = new JLabel("*Todos los campos son obligatorios.");
		lblBottom.setForeground(new Color(255, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(157, Short.MAX_VALUE)
					.addComponent(lblTitulo)
					.addGap(168))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEmail)
						.addComponent(lblDni)
						.addComponent(lblNombre))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtDni)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(27)
									.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addGap(41))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(lblApellido)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
									.addGap(1)))
							.addContainerGap(38, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(126, Short.MAX_VALUE)
					.addComponent(btnBorrar)
					.addGap(36)
					.addComponent(btnGuardar)
					.addContainerGap(128, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(252, Short.MAX_VALUE)
					.addComponent(lblBottom))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitulo)
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDni)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnBuscar)
							.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNombre))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblApellido)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGuardar)
						.addComponent(btnBorrar))
					.addGap(18)
					.addComponent(lblBottom)
					.addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void guardar() {
		try{
			if (validarCampos()){
				Persona p=new Persona();
				p.setDni(Integer.parseInt(txtDni.getText()));
				p.setNombre(txtNombre.getText());
				p.setApellido(txtApellido.getText());
				p.setEmail(txtEmail.getText());
				boolean flag = cp.validarExistencia(Integer.parseInt(txtDni.getText()));
				if (flag){
					if(JOptionPane.showConfirmDialog(null, "La persona ingresada ya existe.\n Desea modificarla?")==JOptionPane.YES_OPTION){
						cp.modificarPersona(p);
						borrarCampos();
						JOptionPane.showMessageDialog(null, "La persona ha sido modificada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else{
					cp.guardarPersona(p);
					borrarCampos();
					JOptionPane.showMessageDialog(null, "La persona ha sido registrada","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}					
			}
		}
		catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(null, "El dni debe contener solo números","Aviso",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private void borrarCampos() {
		txtDni.setText("");
		txtNombre.setText("");
		txtEmail.setText("");
		txtApellido.setText("");
		
	}

	private boolean validarCampos() {
		if (txtDni.getText().length()==0 || txtNombre.getText().length()==0 || txtApellido.getText().length()==0 || txtEmail.getText().length()==0){
			JOptionPane.showMessageDialog(null, "Existen campos incompletos","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else 
			return true;		
	}	

	private void buscar() {
		ControladorPersona cp=new ControladorPersona();
		Persona p;
		p=cp.buscarPersona(Integer.parseInt(txtDni.getText()));
		if (p != null){
			txtNombre.setText(p.getNombre());
			txtApellido.setText(p.getApellido());
			txtEmail.setText(p.getEmail());
		}
		else
			JOptionPane.showMessageDialog(null, "No existe Persona","Error",JOptionPane.ERROR_MESSAGE);
	}
	
	private void borrar(){
		if(validarCampos()){
			if(cp.borrarPersona(Integer.parseInt(txtDni.getText()))){
				int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro?");
				if(respuesta == JOptionPane.YES_OPTION){
					borrarCampos();
					JOptionPane.showMessageDialog(null, "Persona borrada","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else
				JOptionPane.showMessageDialog(null, "No existe Persona para borrar","Error",JOptionPane.ERROR_MESSAGE);			
		}
	}	
}
