package test;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import vo.Student;

import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * ���Զ�ȡxls�ļ�
 *
 * @Author menglanyingfei
 * @Created on 2017.12.17 19:42
 */
public class TestXLS {
    public static void main(String[] args) {
        try {
             readXls();

//            String fileContent = readFileContent("data/student.txt");
//            System.out.println("======================================");
//            System.out.println(fileContent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * ��ȡxls�ļ�
     *
     * @throws IOException
     */
    public static void readXls() throws IOException {
//        FileInputStream in = new FileInputStream("data/student.xls");
//        HSSFWorkbook book = new HSSFWorkbook(in);
//
//        HSSFSheet sheet = book.getSheetAt(0);
//        HSSFRow row;
//        String cell;
//
//        for (int i = sheet.getFirstRowNum() + 1; i < sheet.getPhysicalNumberOfRows(); i++) {
//            row = sheet.getRow(i);
//            for (int j = row.getFirstCellNum(); j < row.getPhysicalNumberOfCells(); j++) {
//                cell = row.getCell(j).toString();
//                System.out.print(cell + " \t");
//            }
//            System.out.println("");
//        }
    }

    // ��ȡtxt�ļ�, ���洢��String����, ˼·Ϊ
    // ����Buffered��readLine������һ��, Ȼ���Կո�ָ�!
    private static String readFileContent(String fileName) throws IOException {
//        File file = new File(fileName);
//
//        BufferedReader bf = new BufferedReader(new FileReader(file));
//
//        String content = "";
        StringBuilder sb = new StringBuilder();
//
//        while (content != null) {
//            content = bf.readLine();
//
//            if (content == null) {
//                break;
//            }
//            // �������򽫶���ո�תΪһ���ո�
//            String[] str = content.trim().split("\\s{2,}|\t");
//            for (String s : str) {
//                System.out.println(s);
//            }
//
//
//            sb.append(content.trim() + "\n");
//        }
//
//        bf.close();
        return sb.toString();
    }


}
