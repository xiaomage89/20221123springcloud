package driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.StudentDAO;
import vo.Student;

public class Driver {
    //���Ŀǰ�����е�ѧ����Ϣ
    public static List<Student> list = new ArrayList<>();

    public static void main(String args[]) {
        int choice = menuChoice();
        while (choice != 7) {
            switch (choice) {
                case 1:
                    importFromExcel();
                    break;
                case 2:
                    importFromTxt();
                    break;
                case 3:
                    inputFromKeyboard();
                    break;
                case 4:
                    queryStudent();
                    break;
                case 5:
                    exportToExcel();
                    break;
                case 6:
                    exportToTxt();
                    break;
                default:
                    System.out.println("��Ч��ѡ��");

            }
            choice = menuChoice();
        }
        System.out.println("����ɹ��˳�");
        System.exit(0);

    }

    public static int menuChoice() {
        System.out.println("====ѧ���ɼ�����ϵͳ=====");
        System.out.println("1.	��excel�м�������");
        System.out.println("2.	���ı��ļ���������");
        System.out.println("3.	��������");
        System.out.println("4.	�ɼ���ѯ");
        System.out.println("5.	�����excel�ļ�");
        System.out.println("6.	��������ı��ļ�");
        System.out.println("7.	�˳�");
        System.out.println("������ѡ�");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice == 7) {
            System.out.println("ȷ���˳�ϵͳ��");
            String c = scan.next();
            if (c.equals("Y")) {
                return choice;
            } else if (c.equals("N")) {
                return 0;
            }
        }

        return choice;
    }

    public static void importFromExcel() {
        /*
         * ����dao�еķ���
		 */
        StudentDAO dao = new StudentDAO();
        String fileName = "data/student.xls";
        List<Student> list1 = dao.ReadFromExcel(fileName);
        list.addAll(list1); //��list1�����е��������ӵ�list������
        System.out.println("�ɹ���excel�е���" + list1.size() + "��ѧ��");
        printList(list1);
    }

    public static void importFromTxt() {
		/*
		 * ����dao�еķ���
		 */
        StudentDAO dao = new StudentDAO();
        String fileName = "data/student.txt";
        List<Student> list1 = dao.ReadFromTxt(fileName);
        list.addAll(list1); //��list1�����е��������ӵ�list������
        System.out.println("�ɹ���txt�е���" + list1.size() + "��ѧ��");
        printList(list1);
    }

    public static void inputFromKeyboard() {
        StudentDAO dao = new StudentDAO();
        Student student;
        // ��student��Ϊnullʱ����student�������ӵ�������
        System.out.println("����-1�����Ӽ������Ӷ���:");
        while ((student = dao.ReadFromKeyBoard(list)) != null) {
            list.add(student);
            System.out.println("���ӳɹ�");
        }

        printList(list);
    }

    public static void queryStudent() {
        StudentDAO dao = new StudentDAO();
        System.out.println("���������ѯѧ����ѧ�ţ�");
        String id = new Scanner(System.in).nextLine();
        List<Student> list1 = dao.QueryById(id, list);
        if (list1.size() > 0) {
            printList(list1);
        } else {
            System.out.println("û�ҵ���ѧ����صĳɼ�");
        }

    }

    public static void exportToExcel() {
        StudentDAO dao = new StudentDAO();
        String fileName = "data/score.xls";
        dao.WriteExcel(list, fileName);

        System.out.println("�ɹ�д��" + list.size() + "��ѧ����excel");
    }

    public static void exportToTxt() {
        StudentDAO dao = new StudentDAO();
        String fileName = "data/score.txt";
        dao.WriteTxt(list, fileName);
        System.out.println("�ɹ�д��" + list.size() + "��ѧ����txt");
    }

    //��ʾ�����е�ÿһ��ѧ����Ϣ
    public static void printList(List<Student> list) {
        for (Student student : list) {
            System.out.println(student.toString());
        }

    }


}
