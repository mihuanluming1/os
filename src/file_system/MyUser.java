package file_system;

public class MyUser {
	private String userName;//�û���
	private String password;//����
	private boolean userFlag;//�û��Ƿ���ڱ�ʶ
	public MyUser(String userName,String password) {
		this.userName=userName;
		this.password=password;
		userFlag=true;

		
	}
	int checkUser(String userName,String password) {//����û��������Ƿ�Ϸ�
		if (this.userName.equals(userName)&&this.password.equals(password))
			return 0;//��ʾ�û���������ȷ
		else if (this.userName.equals(userName))
			return 1;//��ʾ�û��������
		else {
			return 2;//��ʾ�û�������
		}
	}
	void deleteUser() { //ɾ���û�
		userFlag=false;
	}
	public boolean getFlag() {//��ȡ�û����ڱ�ʶ
		// TODO �Զ����ɵķ������
		return userFlag;
	}
	public String getUserName() {//��ȡ�û���
		// TODO �Զ����ɵķ������
		return userName;
	}
}
