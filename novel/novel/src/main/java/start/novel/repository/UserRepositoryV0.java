package start.novel.repository;

import lombok.extern.slf4j.Slf4j;
import start.novel.domain.User;
import start.novel.connection.DBConnectionUtil;

import java.sql.*;
import java.util.NoSuchElementException;

@Slf4j
public class UserRepositoryV0 {
    public User save(User user) throws SQLException {
        String sql = "insert into user(user_id , user_nickname , user_email , user_password) values (?,?,?,?)";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUser_Id());
            pstmt.setString(2, user.getUser_NickName());
            pstmt.setString(3, user.getUser_Email());
            pstmt.setString(4, user.getUser_Password());
            pstmt.executeUpdate();
            return user;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }

    private void close(Connection con, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
    }

    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }

    public User findById(String user_id) throws SQLException {
        String sql = "select * from where user_Id = ?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user_id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setUser_Id(rs.getString("user_id"));
                user.setUser_NickName(rs.getString("user_nickname"));
                user.setUser_Email(rs.getString("user_email"));
                user.setUser_Password(rs.getString("user_password"));
                return user;
            } else {
                throw new NoSuchElementException("member not found user_Id=" + user_id);
            }

        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, rs);
        }


    }

    // 비밀번호 변경하기
    public void updatePassword(String user_Id, String user_Password) throws SQLException {
        String sql = "UPDATE user SET user_Password=? WHERE user_id=?";
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user_Id);
            pstmt.setString(4, user_Password);
            int resultSize = pstmt.executeUpdate();
            log.info("resultSize={}", resultSize);
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }

    // 닉네임 변경하기
    public void updateNickname(String user_Id, String user_NickName) throws SQLException {
        String sql = "UPDATE user SET user_nickname=? WHERE user_id=?";
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user_Id);
            pstmt.setString(2, user_NickName);
            int resultSize = pstmt.executeUpdate();
            log.info("resultSize={}", resultSize);
        } catch (SQLException e) {
        }
    }

    // 삭제하기
    public void delete(String user_id) throws SQLException {

        String sql = " delete from user where user_id=?";
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user_id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            log.error("db error" , e);
            throw e;
        }
        finally {
            close(con , pstmt , null);
        }
    }
}


