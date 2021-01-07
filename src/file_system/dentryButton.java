package file_system;


import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class dentryButton extends JButton {
	MyJPopupMenu jPopupMenu;
	dentryButton(int x, int y, Dentry currentDentry) {
		// TODO 自动生成的构造函数存根
		super("dentry");
		setBounds(x, y, 80, 80);
		jPopupMenu=new MyJPopupMenu(1,currentDentry, null);
		setText(currentDentry.getDentryName().toString());
		addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e)
			{
				if(e.isPopupTrigger()){
					jPopupMenu.show(e.getComponent(), e.getX(),e.getY());
				}
				else if (e.getButton()==e.BUTTON1) {
					//open()
				}
			}
		});
	}

}
