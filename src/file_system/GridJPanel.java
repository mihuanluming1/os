package file_system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class GridJPanel extends JPanel{
	//GridLayout gridLayout=new GridLayout(6, 6, 20, 20);
	int fileNum;
	int dentryNum;
	MyJPopupMenu jPopupMenu;
	public GridJPanel() {
		// TODO 自动生成的构造函数存根
		super();
		setBackground(Color.white);
		setPreferredSize(new Dimension(600,600));
		setLayout(null);
		fileNum=30;
		dentryNum=10;
		jPopupMenu=new MyJPopupMenu(2);
		addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e)
			{
				if(e.isPopupTrigger()){
					jPopupMenu.show(e.getComponent(), e.getX(),e.getY());
				}
			}
		});
		showFile();
	}
	void showFile(){
		int height=600;
		int num=dentryNum+fileNum;
		height=Math.max(height,(1+num/6)*100);
		setPreferredSize(new Dimension(600,height));
		for (int i=0;i<num;i++) {
			if (i<dentryNum) {
				add(new dentryButton(10+(i%6)*100,10+(i/6)*100));
			}
			else {
				add(new fileButton(10+(i%6)*100,10+(i/6)*100));
			}
		}
	}
}
