package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import vo.User;
import util.DBConnection;
import util.DateConvert;


public class IUserDAOImp implements IUserDAO {
    private DBConnection dbc = null;
    private Connection conn = null;

    public IUserDAOImp() {
        this.dbc = new DBConnection();
        this.conn = dbc.getConnection();
    }

    //������Ա
    public boolean doInsert(User user) {
        boolean flag = false;
        PreparedStatement pstmt = null;
        String sql = "insert into user(id,name,sex,birthday) values(?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getSex());
            pstmt.setDate(4, new DateConvert().uDToSD(user.getBirthday()));
            if (pstmt.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;

    }

    //����idɾ��
    public boolean doDelete(int id) throws Exception {
        boolean flag = false;
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM user WHERE id=? ";
        try {
            pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id); // ���е����ݴ�user����ȡ��
            if (pstmt.executeUpdate() > 0) {// �����Ѿ�������һ��
                flag = true;
            }
        } catch (Exception e) {
            throw e;
        } finally { // ��������׳������տ϶���Ҫ�������ݿ�Ĺرղ�����
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (Exception e1) {

                }
            }
        }
        return flag;
    }


    // �޸���Ա��Ϣ
    public boolean doUpdate(int id, User user) throws Exception {
        boolean flag = false;
        PreparedStatement pstmt = null;
        String sql = "update user set name=?,sex=?,birthday=? WHERE id=?";//set��where֮����пո�

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getSex());
            pstmt.setDate(3, new DateConvert().uDToSD(user.getBirthday()));
            pstmt.setInt(4, user.getId());
            if (pstmt.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;

    }


    //��id��ѯ
    public User findById(int id) throws Exception {
        User user = null;
        PreparedStatement pstmt = null;
        String sql = "SELECT id,name,sex,birthday FROM user WHERE id=?";
        try {
            pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery(); // ִ�в�ѯ����
            if (rs.next()) {
                user = new User(id);
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setSex(rs.getString(3));
                user.setBirthday(rs.getDate(4));
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        } finally { // ��������׳������տ϶���Ҫ�������ݿ�Ĺرղ�����
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (Exception e1) {

                }
            }
        }
        return user;
    }

    //���չؼ��ֲ�ѯ
    public List<User> findByKey(String keyword) throws Exception {
        List<User> list = new ArrayList<User>();
        PreparedStatement pstmt = null;

        String sql1 = "select * from user where name like ? or sex like ?";

        try {
            pstmt = this.conn.prepareStatement(sql1);
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User(keyword);
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setSex(rs.getString(3));
                user.setBirthday(rs.getDate(4));
                list.add(user); // ���е������򼯺��в���
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally { // ��������׳������տ϶���Ҫ�������ݿ�Ĺرղ�����
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (Exception e1) {

                }
            }
        }
        return list;
    }

}

		
