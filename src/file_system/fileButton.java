package file_system;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class fileButton extends JButton{
	MyJPopupMenu jPopupMenu;
	public fileButton(int x,int y, File file) {
		// TODO �Զ����ɵĹ��캯�����
		super(file.getFileName().toString());
		setBounds(x, y, 80, 80);
		jPopupMenu=new MyJPopupMenu(file);
		//FileJFrame fileJFrame=new FileJFrame(file);
		addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e)
			{
				if(e.isPopupTrigger()){
					jPopupMenu.show(e.getComponent(), e.getX(),e.getY());
				}
				else if (e.getButton()==e.BUTTON1) {
					FileJFrame fileJFrame=new FileJFrame(file);
				}
			}
		});
	}

}
