package file_system;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class fileButton extends JButton{
	MyJPopupMenu jPopupMenu; //�Ҽ��˵�
	JLabel jLabel; //��ʾ�ļ�����
	public fileButton(int x,int y, MyFile file, GridJPanel gridJPanel, Dentry currentDentry) {
		// TODO �Զ����ɵĹ��캯�����
		super();
		jLabel=new JLabel(file.getFileName().toString()+".txt",JLabel.CENTER);
		setBounds(x, y, 80, 80);
		jLabel.setBounds(x, y+80, 80, 20);
		gridJPanel.add(jLabel);
		ImageIcon icon;
		try {
			icon = new ImageIcon(ImageIO.read(new File("src\\file_system\\fileImg.png")));
			icon.setImage(icon.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
			setIcon(icon);
		} catch (IOException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		jPopupMenu=new MyJPopupMenu(file, gridJPanel,currentDentry);
		addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e){
				setOpaque(false);
				if(e.isPopupTrigger()){
					jPopupMenu.show(e.getComponent(), e.getX(),e.getY());
				}
				else if (e.getButton()==e.BUTTON1) {
					FileJFrame fileJFrame=new FileJFrame(file);
				}
			}
			public void mousePressed(MouseEvent e) {
				setOpaque(true);
			}
		});
	}

}
