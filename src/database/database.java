package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;

public class database {

    Connection conn;
    PreparedStatement p;
    Statement statement;
    ResultSet resultSet;
    boolean f = false;

    public database() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");

        f = true;
    }

    public boolean re() {

        return f;
    }

    // methode to check the database 
    public boolean check_to_login(String username, String password, String specialization) throws SQLException {

        boolean ff = false;

        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from `user`");

        while (resultSet.next()) {
            String name = resultSet.getString("username");
            String pass = resultSet.getString("password");
            String spec = resultSet.getString("specialization");
            if (name.equals(username) && pass.equals(password) && spec.equals(specialization)) {

                ff = true;
                break;
            }

        }

        return ff;

    }

    // check when add user 
    public boolean check_to_user(String username, String specualization) throws SQLException {
        boolean f = false;

        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from `user`");

        while (resultSet.next()) {

            String user = resultSet.getString("username");
            String spec = resultSet.getString("specialization");

            if (user.equals(username) && specualization.equals(spec)) {

                f = true;
                break;

            }

        }
        return f;
    }

    // insert into user table 
    public boolean insert_user(String name, String pass, String spec) throws SQLException {

        p = conn.prepareStatement("insert into `user` values (?,?,?)");
        p.setString(1, name);

        p.setString(2, pass);
        p.setString(3, spec);

        p.execute();
        return true;

    }
// check id for stuff stage in admin

    public boolean check_id_admin(String id) throws SQLException {
        f = false;
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from `admin`");

        while (resultSet.next()) {

            String iid = resultSet.getString("id");

            if (iid.equals(id)) {

                f = true;

            }

        }
        return f;
    }

    // insert into admin table from stage stuff
    public boolean insert_admin(int id, String f_name, String l_name, String mobil, String email, String address, Date d, String speci, String gender, String blood) throws SQLException {

        p = conn.prepareStatement("insert into `admin` values (?,?,?,?,?,?,?,?,?,?)");
        p.setInt(1, id);
        p.setString(2, f_name);
        p.setString(3, l_name);
        p.setString(4, mobil);
        p.setString(5, email);
        p.setString(6, address);
        p.setDate(7, d);
        p.setString(8, speci);
        p.setString(9, gender);
        p.setString(10, blood);
        p.execute();
        return true;
    }
// check id for stuff stage in reciption

    public boolean check_id_reciption(String id) throws SQLException {

        f = false;
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from `reciption`");

        while (resultSet.next()) {

            String iid = resultSet.getString("id");

            if (iid.equals(id)) {

                f = true;

            }

        }
        return f;

    }

    // insert into admin table from stage stuff
    public boolean insert_reciption(int id, String f_name, String l_name, String mobil, String email, String address, Date d, String speci, String gender, String blood) throws SQLException {

        p = conn.prepareStatement("insert into `reciption` values (?,?,?,?,?,?,?,?,?,?)");
        p.setInt(1, id);
        p.setString(2, f_name);
        p.setString(3, l_name);
        p.setString(4, mobil);
        p.setString(5, email);
        p.setString(6, address);
        p.setDate(7, d);
        p.setString(8, speci);
        p.setString(9, gender);
        p.setString(10, blood);
        p.execute();
        return true;
    }

    // check id for stuff stage in doctor
    public boolean check_id_doctor(String id) throws SQLException {

        f = false;
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from `doctor`");

        while (resultSet.next()) {

            String iid = resultSet.getString("id");

            if (iid.equals(id)) {

                f = true;

            }

        }
        return f;

    }

    // insert into doctor table from stage stuff
    public void insert_doctor(int id, String f_name, String l_name, String mobil, String email, String address, Date d, String speci, String gender, String blood) throws SQLException {

        p = conn.prepareStatement("insert into `doctor` values (?,?,?,?,?,?,?,?,?,?)");
        p.setInt(1, id);
        p.setString(2, f_name);
        p.setString(3, l_name);
        p.setString(4, mobil);
        p.setString(5, email);
        p.setString(6, address);
        p.setDate(7, d);
        p.setString(8, speci);
        p.setString(9, gender);
        p.setString(10, blood);
        p.execute();
    }

    // check id for stuff stage in accountant
    public boolean check_id_accountant(String id) throws SQLException {

        f = false;
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from `accountant`");

        while (resultSet.next()) {

            String iid = resultSet.getString("id");

            if (iid.equals(id)) {

                f = true;

            }

        }
        return f;

    }

    // insert into accountant table from stage stuff
    public void insert_accountant(int id, String f_name, String l_name, String mobil, String email, String address, Date d, String speci, String gender, String blood) throws SQLException {

        p = conn.prepareStatement("insert into `accountant` values (?,?,?,?,?,?,?,?,?,?)");
        p.setInt(1, id);
        p.setString(2, f_name);
        p.setString(3, l_name);
        p.setString(4, mobil);
        p.setString(5, email);
        p.setString(6, address);
        p.setDate(7, d);
        p.setString(8, speci);
        p.setString(9, gender);
        p.setString(10, blood);
        p.execute();
    }
    // check id for stuff stage in accountant

    public boolean check_id_nurse(String id) throws SQLException {

        f = false;
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from `nurse`");

        while (resultSet.next()) {

            String iid = resultSet.getString("id");

            if (iid.equals(id)) {

                f = true;

            }

        }
        return f;

    }

    // insert into accountant table from stage stuff
    public void insert_nurse(int id, String f_name, String l_name, String mobil, String email, String address, Date d, String speci, String gender, String blood) throws SQLException {

        p = conn.prepareStatement("insert into `nurse` values (?,?,?,?,?,?,?,?,?,?)");
        p.setInt(1, id);
        p.setString(2, f_name);
        p.setString(3, l_name);
        p.setString(4, mobil);
        p.setString(5, email);
        p.setString(6, address);
        p.setDate(7, d);
        p.setString(8, speci);
        p.setString(9, gender);
        p.setString(10, blood);
        p.execute();
    }

    // check id for stuff stage in pharmasist
    public boolean check_id_pharmasist(String id) throws SQLException {

        f = false;
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from `pharmasist`");

        while (resultSet.next()) {

            String iid = resultSet.getString("id");

            if (iid.equals(id)) {

                f = true;

            }

        }
        return f;

    }

    // insert into pharmasist table from stage stuff
    public void insert_pharmasist(int id, String f_name, String l_name, String mobil, String email, String address, Date d, String speci, String gender, String blood) throws SQLException {

        p = conn.prepareStatement("insert into `pharmasist` values (?,?,?,?,?,?,?,?,?,?)");
        p.setInt(1, id);
        p.setString(2, f_name);
        p.setString(3, l_name);
        p.setString(4, mobil);
        p.setString(5, email);
        p.setString(6, address);
        p.setDate(7, d);
        p.setString(8, speci);
        p.setString(9, gender);
        p.setString(10, blood);
        p.execute();
    }

    // check id for stuff stage in xray
    public boolean check_id_xray(String id) throws SQLException {

        f = false;
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from `xray`");

        while (resultSet.next()) {

            String iid = resultSet.getString("id");

            if (iid.equals(id)) {

                f = true;

            }

        }
        return f;

    }

    // insert into xray table from stage stuff
    public void insert_xray(int id, String f_name, String l_name, String mobil, String email, String address, Date d, String speci, String gender, String blood) throws SQLException {

        p = conn.prepareStatement("insert into `xray` values (?,?,?,?,?,?,?,?,?,?)");
        p.setInt(1, id);
        p.setString(2, f_name);
        p.setString(3, l_name);
        p.setString(4, mobil);
        p.setString(5, email);
        p.setString(6, address);
        p.setDate(7, d);
        p.setString(8, speci);
        p.setString(9, gender);
        p.setString(10, blood);
        p.execute();
    }

    // check id for stuff stage in lab
    public boolean check_id_lab(String id) throws SQLException {

        f = false;
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from `lab`");

        while (resultSet.next()) {

            String iid = resultSet.getString("id");

            if (iid.equals(id)) {

                f = true;

            }

        }
        return f;

    }

    // insert into lab table from stage stuff
    public void insert_lab(int id, String f_name, String l_name, String mobil, String email, String address, Date d, String speci, String gender, String blood) throws SQLException {

        p = conn.prepareStatement("insert into `lab` values (?,?,?,?,?,?,?,?,?,?)");
        p.setInt(1, id);
        p.setString(2, f_name);
        p.setString(3, l_name);
        p.setString(4, mobil);
        p.setString(5, email);
        p.setString(6, address);
        p.setDate(7, d);
        p.setString(8, speci);
        p.setString(9, gender);
        p.setString(10, blood);
        p.execute();
    }

    public void delete_admin(int id) throws SQLException {

        p = conn.prepareStatement("delete from `admin` where id=? ");
        p.setInt(1, id);
        p.execute();
    }

    public void delete_reciption(int id) throws SQLException {

        p = conn.prepareStatement("delete from `reciption` where id=? ");
        p.setInt(1, id);
        p.execute();
    }

    public void delete_doctor(int id) throws SQLException {

        p = conn.prepareStatement("delete from `doctor` where id=? ");
        p.setInt(1, id);
        p.execute();
    }

    public void delete_accountant(int id) throws SQLException {

        p = conn.prepareStatement("delete from `accountant` where id=? ");
        p.setInt(1, id);
        p.execute();
    }

    public void delete_nurse(int id) throws SQLException {

        p = conn.prepareStatement("delete from `nurse` where id=? ");
        p.setInt(1, id);
        p.execute();
    }

    public void delete_pharmasist(int id) throws SQLException {

        p = conn.prepareStatement("delete from `pharmasist` where id=? ");
        p.setInt(1, id);
        p.execute();
    }

    public void delete_xray(int id) throws SQLException {

        p = conn.prepareStatement("delete from `xray` where id=? ");
        p.setInt(1, id);
        p.execute();
    }

    public void delete_lab(int id) throws SQLException {

        p = conn.prepareStatement("delete from `lab` where id=? ");
        p.setInt(1, id);
        p.execute();
    }

    public void update_admin(int id, String f_name, String l_name, String mobil, String email, String address, Date date, String spec, String gender, String blood) throws SQLException {
        p = conn.prepareStatement("update `admin` set `f_name`=? , `l_name`=? ,`mobil`=? ,`email`=?,`address`=?,date_of_join=?,`specialization`=?,`gender`=?,`blood_group`=? where id=" + id + " ");
        p.setString(1, f_name);
        p.setString(2, l_name);
        p.setString(3, mobil);
        p.setString(4, email);
        p.setString(5, address);
        p.setDate(6, date);
        p.setString(7, spec);
        p.setString(8, gender);
        p.setString(9, blood);

        p.execute();

    }

    //"admin", "reciption", "doctor", "accountant", "nurse", "pharmasist", "xray", "lab"
    public void update_reciption(int id, String f_name, String l_name, String mobil, String email, String address, Date date, String spec, String gender, String blood) throws SQLException {
        p = conn.prepareStatement("update `reciption` set `f_name`=? , `l_name`=? ,`mobil`=? ,`email`=?,`address`=?,date_of_join=?,`specialization`=?,`gender`=?,`blood_group`=? where id=" + id + " ");
        p.setString(1, f_name);
        p.setString(2, l_name);
        p.setString(3, mobil);
        p.setString(4, email);
        p.setString(5, address);
        p.setDate(6, date);
        p.setString(7, spec);
        p.setString(8, gender);
        p.setString(9, blood);

        p.execute();

    }

    public void update_doctor(int id, String f_name, String l_name, String mobil, String email, String address, Date date, String spec, String gender, String blood) throws SQLException {
        p = conn.prepareStatement("update `doctor` set `f_name`=? , `l_name`=? ,`mobil`=? ,`email`=?,`address`=?,date_of_join=?,`specialization`=?,`gender`=?,`blood_group`=? where id=" + id + " ");
        p.setString(1, f_name);
        p.setString(2, l_name);
        p.setString(3, mobil);
        p.setString(4, email);
        p.setString(5, address);
        p.setDate(6, date);
        p.setString(7, spec);
        p.setString(8, gender);
        p.setString(9, blood);

        p.execute();

    }

    public void update_accountant(int id, String f_name, String l_name, String mobil, String email, String address, Date date, String spec, String gender, String blood) throws SQLException {
        p = conn.prepareStatement("update `accountant` set `f_name`=? , `l_name`=? ,`mobil`=? ,`email`=?,`address`=?,date_of_join=?,`specialization`=?,`gender`=?,`blood_group`=? where id=" + id + " ");
        p.setString(1, f_name);
        p.setString(2, l_name);
        p.setString(3, mobil);
        p.setString(4, email);
        p.setString(5, address);
        p.setDate(6, date);
        p.setString(7, spec);
        p.setString(8, gender);
        p.setString(9, blood);

        p.execute();

    }

    public void update_nurse(int id, String f_name, String l_name, String mobil, String email, String address, Date date, String spec, String gender, String blood) throws SQLException {
        p = conn.prepareStatement("update `nurse` set `f_name`=? , `l_name`=? ,`mobil`=? ,`email`=?,`address`=?,date_of_join=?,`specialization`=?,`gender`=?,`blood_group`=? where id=" + id + " ");
        p.setString(1, f_name);
        p.setString(2, l_name);
        p.setString(3, mobil);
        p.setString(4, email);
        p.setString(5, address);
        p.setDate(6, date);
        p.setString(7, spec);
        p.setString(8, gender);
        p.setString(9, blood);

        p.execute();

    }

    public void update_pharmasist(int id, String f_name, String l_name, String mobil, String email, String address, Date date, String spec, String gender, String blood) throws SQLException {
        p = conn.prepareStatement("update `pharmasist` set `f_name`=? , `l_name`=? ,`mobil`=? ,`email`=?,`address`=?,date_of_join=?,`specialization`=?,`gender`=?,`blood_group`=? where id=" + id + " ");
        p.setString(1, f_name);
        p.setString(2, l_name);
        p.setString(3, mobil);
        p.setString(4, email);
        p.setString(5, address);
        p.setDate(6, date);
        p.setString(7, spec);
        p.setString(8, gender);
        p.setString(9, blood);

        p.execute();

    }

    public void update_xray(int id, String f_name, String l_name, String mobil, String email, String address, Date date, String spec, String gender, String blood) throws SQLException {
        p = conn.prepareStatement("update `xray` set `f_name`=? , `l_name`=? ,`mobil`=? ,`email`=?,`address`=?,date_of_join=?,`specialization`=?,`gender`=?,`blood_group`=? where id=" + id + " ");
        p.setString(1, f_name);
        p.setString(2, l_name);
        p.setString(3, mobil);
        p.setString(4, email);
        p.setString(5, address);
        p.setDate(6, date);
        p.setString(7, spec);
        p.setString(8, gender);
        p.setString(9, blood);

        p.execute();

    }

    public void update_lab(int id, String f_name, String l_name, String mobil, String email, String address, Date date, String spec, String gender, String blood) throws SQLException {
        p = conn.prepareStatement("update `lab` set `f_name`=? , `l_name`=? ,`mobil`=? ,`email`=?,`address`=?,date_of_join=?,`specialization`=?,`gender`=?,`blood_group`=? where id=" + id + " ");
        p.setString(1, f_name);
        p.setString(2, l_name);
        p.setString(3, mobil);
        p.setString(4, email);
        p.setString(5, address);
        p.setDate(6, date);
        p.setString(7, spec);
        p.setString(8, gender);
        p.setString(9, blood);

        p.execute();

    }
// select all from admin

    public ResultSet select_admin(int id) throws SQLException {

        p = conn.prepareStatement("select * from `admin` where id=" + id + "");
        resultSet = p.executeQuery();
        return resultSet;

    }

    public ResultSet select_reciption(int parseInt) throws SQLException {
        p = conn.prepareStatement("select * from `reciption` where id=" + parseInt + "");
        resultSet = p.executeQuery();
        return resultSet;
    }

    public ResultSet select_doctor(int parseInt) throws SQLException {
        p = conn.prepareStatement("select * from `doctor` where id=" + parseInt + "");
        resultSet = p.executeQuery();
        return resultSet;
    }

    public ResultSet select_accountant(int parseInt) throws SQLException {
        p = conn.prepareStatement("select * from `accountant` where id=" + parseInt + "");
        resultSet = p.executeQuery();
        return resultSet;
    }

    public ResultSet select_nurse(int parseInt) throws SQLException {
        p = conn.prepareStatement("select * from `nurse` where id=" + parseInt + "");
        resultSet = p.executeQuery();
        return resultSet;
    }

    public ResultSet select_pharmasist(int parseInt) throws SQLException {
        p = conn.prepareStatement("select * from `pharmasist` where id=" + parseInt + "");
        resultSet = p.executeQuery();
        return resultSet;
    }

    public ResultSet select_lab(int parseInt) throws SQLException {
        p = conn.prepareStatement("select * from `lab` where id=" + parseInt + "");
        resultSet = p.executeQuery();
        return resultSet;
    }

    public ResultSet select_xray(int parseInt) throws SQLException {
        p = conn.prepareStatement("select * from `xray` where id=" + parseInt + "");
        resultSet = p.executeQuery();
        return resultSet;
    }

    // select from database uer to search password 
    public ResultSet select_user(String name, String spec) throws SQLException {
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from `user` where `username` ='" + name + "' and `specialization`='" + spec + "'");

        return resultSet;
    }

    public boolean check_user_complete(String name, String spec, String old_pass) throws SQLException {

        boolean f = false;
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select `password` from `user` where `username` ='" + name + "' and `specialization`='" + spec + "' ");
        while (resultSet.next()) {
            String pass = resultSet.getString("password");
            if (pass.equals(old_pass)) {

                f = true;
                break;

            }

        }

        return f;
    }
// update user password

    public void update_user(String name, String spec, String old_pass, String con) throws SQLException {

        p = conn.prepareStatement("update `user` set `password` = ? where `username`='" + name + "' and `specialization`='" + spec + "' and `password`='" + old_pass + "'");
        p.setString(1, con);
        p.execute();

    }
// select specialization to fill combobox 

    public ResultSet select_user_spec() throws SQLException {

        statement = conn.createStatement();
        resultSet = statement.executeQuery("select distinct `specialization` from `user` ");

        return resultSet;
    }

    public boolean check_id_room(String text) throws SQLException {

        boolean f = false;
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select room_id from `room` ");
        while (resultSet.next()) {
            if (Integer.parseInt(text) == resultSet.getInt("room_id")) {

                f = true;
                break;
            }

        }

        return f;

    }

    public void insert_room(int parseInt, String toString, String toString0, double parseDouble, String toString1, double parseDouble0) throws SQLException {

        p = conn.prepareStatement("insert into `room` values (?,?,?,?,?,?)");
        p.setInt(1, parseInt);
        p.setString(2, toString);
        p.setString(3, toString0);
        p.setDouble(4, parseDouble);
        p.setString(5, toString1);
        p.setDouble(6, parseDouble0);
        p.execute();
    }

    public void update_room(int parseInt, String toString, String toString0, double parseDouble, String toString1, double parseDouble0) throws SQLException {

        p = conn.prepareStatement("update `room` set `type`=? , `department`=? ,cost=?,`state`=?,service_cost=? where room_id='" + parseInt + "'");
        p.setString(1, toString);
        p.setString(2, toString0);
        p.setDouble(3, parseDouble);
        p.setString(4, toString1);
        p.setDouble(5, parseDouble0);
        p.execute();

    }

    public boolean insert_reciption_pationt(int id, String f_name, String l_name, double age, String mobil, String email, String address, String gender, String blood, String state) throws SQLException {
        p = conn.prepareStatement("insert into patient (id,f_name,l_name ,age,mobil,email,address ,date_of_join ,gender,blood_group, patient_state) values (?,?,?,?,?,?,?,?,?,?,?)");
        p.setInt(1, id);
        p.setString(2, f_name);
        p.setString(3, l_name);
        p.setDouble(4, age);
        p.setString(5, mobil);
        p.setString(6, email);
        p.setString(7, address);
        p.setDate(8, new Date(new java.util.Date().getDate()));
        p.setString(9, gender);
        p.setString(10, blood);
        p.setString(11, state);

        p.execute();

        return true;

    }

    public boolean update_reciption_pationt(int id, String f_name, String l_name, double age, String mobil, String email, String address, String gender, String blood, String state) throws SQLException {
        p = conn.prepareStatement("update patient set f_name=? , l_name=? , age=? , mobil=? , email=? , address=? , gender =? ,blood_group=? , patient_state=? where id=?");
        p.setInt(10, id);
        p.setString(1, f_name);
        p.setString(2, l_name);
        p.setDouble(3, age);
        p.setString(4, mobil);
        p.setString(5, email);
        p.setString(6, address);
//        p.setDate(7, new Date(new java.util.Date().getDate()));
        p.setString(7, gender);
        p.setString(8, blood);
        p.setString(9, state);

        p.execute();

        return true;

    }

//    update_reciption_pationt
    public boolean select_pationt_id(int parseInt) throws SQLException {

        boolean f = false;
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from `patient` where id=" + parseInt + "");
        if (resultSet.next()) {
            f = true;

        }

        return f;

    }

    public ResultSet select_all_patient(int parseInt) throws SQLException {

        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from patient where id=" + parseInt + "");

        return resultSet;
    }

    public boolean delete_patient(int id) throws SQLException {

        p = conn.prepareStatement("delete from `patient` where id=? ");
        p.setInt(1, id);
        p.execute();

        return true;
    }

}
