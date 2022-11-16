package com.example.demo;

import android.content.Context;
import android.os.StrictMode;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectionDatabase {
    Connection con;
    Context ct;
    String uname, pass, ip, port, database;
    public ArrayList<User> UserArr = new ArrayList<>();

    // Kết nối database dữ liệu
    public Connection connectionDB(){
        Connection con = null;
        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://10.10.1.48;databaseName=AppForecast;user=khoa123;password=12345;");

        }catch (SQLException | ClassNotFoundException e){
            e.getMessage();
        } catch (IllegalAccessException e) {
            e.getMessage();
        } catch (InstantiationException e) {
            e.getMessage();
        } catch (Exception e){
            e.getMessage();
        }
        return con;
    }

    //============User===========///
    // Lấy danh sách người dùng
    public String getListUser(){
        String result = null;
        Connection connection = connectionDB();
        try{
            if(connection!=null){
                String sqlStatment = "Select * from users FOR JSON AUTO";
                Statement st = connection.createStatement();
                ResultSet re = st.executeQuery(sqlStatment);

                while (re.next()){
                    result ="{\"user\":"+ re.getString(1).replace("   ","").replace("  ","")+"}";
                }
            }
        }catch (Exception e){
            result = e.toString();
        }
        return result;
    }

    // Lấy thông tin người dùng
    public String getUser(String id){
        Connection connection = connectionDB();
        String result = null;
        try{
            if(connection!=null){
                String sqlStatment = "Select * from users where users.userID = "+Integer.parseInt(id)+" FOR JSON AUTO";

                Statement st = connection.createStatement();
                ResultSet re = st.executeQuery(sqlStatment);

                while (re.next()){
                    result ="{\"user\":"+ re.getString(1).replace("   ","").replace("  ","")+"}";
                }
            }
        }catch (Exception e){
            Toast.makeText(ct, e.toString(), Toast.LENGTH_SHORT).show();
        }
        return result;

    }

    // Lấy người dùng theo tài khoản và mật khẩu
    public String getUserByUserNamePass(String taikhoan, String matkhau){
        String result = null;
        Connection connection = connectionDB();

        try{
            if(connection!=null){
                String sqlStatment = "Select * from users where users.taikhoan = '"+taikhoan+"' and users.matkhau = '"+matkhau+"' FOR JSON AUTO";

                Statement st = connection.createStatement();
                ResultSet re = st.executeQuery(sqlStatment);

                while (re.next()){
                    result ="{\"user\":"+ re.getString(1).replace("   ","").replace("  ","")+"}";
                }
            }
        }catch (Exception e){
            result = e.toString();
        }
        return result;
    }

    // Thêm người dùng
    public String addUser(String ho, String ten, String email, String sdt, String chucvu, String taikhoan, String matkhau){
        Connection connection = connectionDB();
        String result = null;
        try{
            if(connection!=null){
                String sqlStatment = "Insert into users " +
                        "values("+
                        "'"+ho+
                        "','"+ten+
                        "','"+email+
                        "','"+sdt+
                        "','"+chucvu+
                        "','"+taikhoan+
                        "','"+matkhau+"')";

                Statement st = connection.createStatement();
                ResultSet re = st.executeQuery(sqlStatment);
                while (re.next()){
                    result = "Chào "+ten+", bạn đã đăng ký thành công vui lòng đăng nhập để vào trang chủ.";
                }
            }
        } catch (Exception e){
            result = "Lỗi: "+ e.toString();
        }
        return result;
    }

    // Chỉnh sửa người dùng
    public String UpdateUser(String id,String ho, String ten, String email, String sdt, String chucvu, String taikhoan, String matkhau){
        Connection connection = connectionDB();
        String result = null;
        try{
            if(connection!=null){
                String sqlStatment = "update users " +
                        "set "+
                        "ho = '"+ho+
                        "', ten = '"+ten+
                        "', email = '"+email+
                        "', sdt = '"+sdt+
                        "', chucvu = '"+chucvu+
                        "', taikhoan = '"+taikhoan+
                        "', matkhau = '"+matkhau+
                        "' where userID = "+Integer.parseInt(id);

                Statement st = connection.createStatement();
                ResultSet re = st.executeQuery(sqlStatment);
                while (re.next()){
                    result = "Cập nhật thành công!";
                    Toast.makeText(ct, result, Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e){
            if(result!=null) {
                result = e.toString();
                Toast.makeText(ct, result, Toast.LENGTH_SHORT).show();
            }
        }
        return result;
    }

    // Xóa người dùng
    public String deleteUser(Context ct, String id){
        String result = null;
        Connection connection = connectionDB();
        try{
            if(connection!=null){
                String sqlStatment = "delete from users where userID = "+Integer.parseInt(id)+";";
                Statement st = connection.createStatement();
                ResultSet re = st.executeQuery(sqlStatment);
                while(re.next()){
                    result = "Đã xóa thành công!";
                    Toast.makeText(ct, result, Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e){
            if(result!=null) {
                result = e.toString();
                Toast.makeText(ct, result, Toast.LENGTH_SHORT).show();
            }
        }
        return result;
    }

    //=====================Forecast===========//
    // Lấy danh sách dự báo
    public String getListForecast(){
        String result = null;
        Connection connection = connectionDB();
        try{
            if(connection!=null){
                String sqlStatment = "Select * from forecast FOR JSON AUTO";
                Statement st = connection.createStatement();
                ResultSet re = st.executeQuery(sqlStatment);

                while (re.next()){
                    result ="{\"forecast\":"+ re.getString(1).replace("   ","").replace("  ","")+"}";
                }
            }
        }catch (Exception e){
            result = null;
        }
        return result;
    }

    //=====================Station==============//
    // Lấy danh sách trạm
    public String getListStation(){
        String result = null;
        Connection connection = connectionDB();
        try{
            if(connection!=null){
                String sqlStatment = "Select * from station FOR JSON AUTO";
                Statement st = connection.createStatement();
                ResultSet re = st.executeQuery(sqlStatment);

                while (re.next()){
                    result ="{\"station\":"+ re.getString(1).replace("   ","").replace("  ","")+"}";
                }
            }
        }catch (Exception e){
            result = null;
        }
        return result;
    }

    //=================Construction===========//
    // Lấy danh sách công trình
    public String getListConstruction(){
        String result = null;
        Connection connection = connectionDB();
        try{
            if(connection!=null){
                String sqlStatment = "Select * from construction FOR JSON AUTO";
                Statement st = connection.createStatement();
                ResultSet re = st.executeQuery(sqlStatment);

                while (re.next()){
                    result ="{\"construction\":"+ re.getString(1).replace("   ","").replace("  ","")+"}";
                }
            }
        }catch (Exception e){
            result = null;
        }
        return result;
    }
}