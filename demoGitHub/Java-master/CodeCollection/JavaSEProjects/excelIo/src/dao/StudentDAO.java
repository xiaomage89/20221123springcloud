package dao;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import vo.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class StudentDAO {

    // ʵ�ֶ�ѧ���ļ�������������Ϣ�����student������
    public List<Student> ReadFromExcel(String fileName) {

        List<Student> list = new ArrayList<>();

		/*
         * �벹��
		 */
        FileInputStream in = null;
        try {
            in = new FileInputStream(fileName);
            HSSFWorkbook book = new HSSFWorkbook(in);
            // �õ���һ��Sheetҳ
            HSSFSheet sheet = book.getSheetAt(0);
            HSSFRow row;

            for (int i = sheet.getFirstRowNum() + 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Student student = new Student();

                row = sheet.getRow(i);
                int j = row.getFirstCellNum();
                student.setId(row.getCell(j).toString());
                student.setName(row.getCell(j + 1).toString());
                student.setGender(row.getCell(j + 2).toString());
                student.setJava(Float.parseFloat(row.getCell(j + 3).toString()));
                student.setEnglish(Float.parseFloat(row.getCell(j + 4).toString()));
                student.setMath(Float.parseFloat(row.getCell(j + 5).toString()));
                student.setTotalScore();
                student.setAverage();

                list.add(student);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    // ���ı��ļ��ж��������������ݴ���ڼ�����
    public List<Student> ReadFromTxt(String fileName) {

        List<Student> list = new ArrayList<>();
        /*
		 * �벹��
		 */
        File file = new File(fileName);
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));

            String content = "";

            while (content != null) {
                content = bf.readLine();

                if (content == null) {
                    break;
                }
                // �������򽫶���ո��Tab����תΪһ���ո�
                String[] str = content.trim().split("\\s{2,}|\t");
                Student student = new Student();

                student.setId(str[0]);
                student.setName(str[1]);
                student.setGender(str[2]);
                student.setJava(Float.parseFloat(str[3]));
                student.setEnglish(Float.parseFloat(str[4]));
                student.setMath(Float.parseFloat(str[5]));
                student.setTotalScore();
                student.setAverage();

                list.add(student);
            }

            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    // �Ӽ���������һ�����ݣ������ݴ���ڶ����У���student����Ϊnull����ʾ�������
    public Student ReadFromKeyBoard(List<Student> list) {
        Student student = new Student();
		/*
		 * �벹��
		 */
		// �����������
        Scanner scanner = new Scanner(System.in);
        String first = scanner.next();
        if ("-1".equals(first)) {
            return null;
        }
        for (Student stu : list) {
            if (first.equals(stu.getId())) {
                System.out.println("����ѧ���ظ�, ����������:");
                return null;
            }
        }

        student.setId(first);

        student.setName(scanner.next());
        student.setGender(scanner.next());
        student.setJava(scanner.nextFloat());
        student.setEnglish(scanner.nextFloat());
        student.setMath(scanner.nextFloat());
        student.setTotalScore();
        student.setAverage();

        return student;
    }

    // ����ѧ�Ų�ѯ,���صĽ������ڼ����У�������Ϊ�գ���ʾû�ҵ�
    public List<Student> QueryById(String id, List<Student> list) {

        List<Student> list1 = new ArrayList<>();
        String id1 = id + ".0"; // 1 -> 1.0
		/*
		 * �벹��
		 */
        for (Student student : list) {
            if (id1.equals(student.getId())) {
                list1.add(student);
            }
        }

        return list1;
    }


    /*
     * ��List��������д��excel������sheet��
     *
     * @param excelTitle    �ļ���ͷ
     * @param list          Ҫд������ݼ���
     * @param sheetName     sheet����
     */
    // �������е�����д�뵽excel�ļ���
    public void WriteExcel(List<Student> list, String fileName) {
		/*
		 * �벹��
		 */
        Workbook workbook = new HSSFWorkbook();

        //create sheet
        String sheetName = "student";
        String[] excelTitle = {"ѧ��", "����", "�Ա�", "�ܷ�", "ƽ����"};
        Sheet sheet = workbook.createSheet(sheetName);
        int rowIndex = 0; // ��ʶλ�����ڱ�ʶsheet���к�
        // �������ݼ�������д��excel��
        try {
            // д��ͷ����
            Row titleRow = sheet.createRow(rowIndex);
            for (int i = 0; i < excelTitle.length; i++) {
                // ������ͷ��Ԫ��,��ֵ
                titleRow.createCell(i).setCellValue(excelTitle[i]);
            }
//            System.out.println("��ͷд�����>>>>>>>>");
            rowIndex++;
            // ѭ��д����������
            for (Iterator<Student> iterator = list.iterator();
                 iterator.hasNext(); ) {
                Student student = iterator.next();
                // create sheet row
                Row row = sheet.createRow(rowIndex);
                // create sheet column(��Ԫ��)
                Cell cell0 = row.createCell(0);
                cell0.setCellValue(student.getId());
                Cell cell1 = row.createCell(1);
                cell1.setCellValue(student.getName());
                Cell cell2 = row.createCell(2);
                cell2.setCellValue(student.getGender());
                Cell cell3 = row.createCell(3);
                cell3.setCellValue(student.getTotalScore());
                Cell cell4 = row.createCell(4);
                cell4.setCellValue(student.getAverage());
                rowIndex++;
            }
            FileOutputStream fos = new FileOutputStream(fileName);
            workbook.write(fos);
            fos.close();
//            System.out.println(fileName + "д���ļ��ɹ�>>>>>>>>>>>");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // �������е�����д�뵽txt�ļ���, ˼·: ʹ�ô�ӡ��
    public void WriteTxt(List<Student> list, String fileName) {
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream(fileName));
            printStream.printf("ѧ��\t����\t�Ա�\t�ܷ�\tƽ����\n");
            for (int i = 0; i < list.size(); i++) {
                printStream.printf("%s\t%s\t%s\t%.2f\t%.2f\n", list.get(i).getId(),
                    list.get(i).getName(), list.get(i).getGender(),
                        list.get(i).getTotalScore(), list.get(i).getAverage());
            }
            printStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}





















