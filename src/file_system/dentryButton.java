package file_system;


import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class dentryButton extends JButton {
	MyJPopupMenu jPopupMenu;//右键菜单
	JLabel jLabel;//目录名标签
	dentryButton(int x, int y, Dentry currentDentry, GridJPanel gridJPanel) {
		// TODO 自动生成的构造函数存根
		super();
		jLabel=new JLabel(currentDentry.getDentryName().toString(),JLabel.CENTER);
		jLabel.setBounds(x, y+80, 80, 20);
		gridJPanel.add(jLabel);
		setBounds(x, y, 80, 80);
		jPopupMenu=new MyJPopupMenu(1,currentDentry, gridJPanel);
		setText(currentDentry.getDentryName().toString());
		ImageIcon icon;
		try {
			icon = new ImageIcon(ImageIO.read(new File("src\\file_system\\dentryImg.png")));
			icon.setImage(icon.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
			setIcon(icon);
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e)
			{
				setOpaque(false);
				if(e.isPopupTrigger()){
					jPopupMenu.show(e.getComponent(), e.getX(),e.getY());
				}
				else if (e.getButton()==e.BUTTON1) {
					//open()
					FileSystem.setCurrentDentry(currentDentry);
					gridJPanel.showFile();
				}
			}
			public void mousePressed(MouseEvent e) {
				setOpaque(true);
				
			}
		});
	}

}
