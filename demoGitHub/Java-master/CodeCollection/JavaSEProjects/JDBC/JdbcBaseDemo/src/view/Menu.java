package view;

import util.InputData;
import dao.IUserDAOImp;
import vo.User;

import java.util.List;

public class Menu {
    IUserDAOImp iu = new IUserDAOImp();
    InputData input = new InputData();

    public Menu() {
        while (true) {
            this.show();
        }
    }

    public void show() {
        System.out.println("--------��Ա��Ϣ����ϵͳ-------");
        System.out.println("1.������Ա");
        System.out.println("2.�����ɾ����Ա");
        System.out.println("3.������޸���Ա��Ϣ");
        System.out.println("4.����Ų�ѯ��Ա��Ϣ");
        System.out.println("5.���ؼ��ֲ�ѯ��Ա��Ϣ");
        System.out.println("0.�˳�");

        User user = null;
        int i = input.getInt("��ѡ��", "��������ȷ��ѡ�");
        switch (i) {
            case 1:
                int id = input.getInt("��������Ա���:", "��ʽ����,����������!");
                String name = input.getString("��������Ա����:");
                String sex = input.getString("�������Ա�:");
                java.util.Date birthday = input.getDate("�������������:", "��ʽ����,����������!");
                user = new User(id, name, sex, birthday);
                if (iu.doInsert(user)) {
                    System.out.println("��ӳɹ���");
                } else {
                    System.out.println("���ʧ�ܣ�");
                }
                break;
            case 2:
                int id2 = input.getInt("��������Ա���:", "��ʽ����,����������!");
                try {
                    if (iu.doDelete(id2)) {
                        System.out.println("ɾ���ɹ���");
                    } else {
                        System.out.println("ɾ��ʧ�ܣ�");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;
            case 3:
                int id3 = input.getInt("��������Ա���:", "��ʽ����,����������!");
                String name3 = input.getString("��������Ա����:");
                String sex3 = input.getString("�������Ա�:");
                java.util.Date birthday3 = input.getDate("�������������:", "��ʽ����,����������!");
                user = new User(id3, name3, sex3, birthday3);
                try {
                    if (iu.doUpdate(id3, user)) {
                        System.out.println("�޸ĳɹ���");
                    } else {
                        System.out.println("�޸�ʧ�ܣ�");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;
            case 4:
                int id4 = input.getInt("��������Ա���:", "��ʽ����,����������!");
                try {
                    user = iu.findById(id4);
                    System.out.println(user);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;
            case 5:
                String keyword5 = input.getString("�������ѯ�ؼ���");
                try {
                    List<User> list = iu.findByKey(keyword5);
                    for (User u : list) {
                        System.out.println(u);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case 0:
                System.exit(1);
                break;
            default:
                System.out.println("��ѡ����ȷ�Ĳ�����");
        }
    }
}
