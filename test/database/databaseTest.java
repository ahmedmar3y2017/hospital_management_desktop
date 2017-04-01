/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.SQLException;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ahmed
 */
public class databaseTest {
    
    static database data;
    
    public databaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws ClassNotFoundException, SQLException {
        
        data = new database();
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testRe() {
    }
    
    @Test
    public void testCheck_to_login() throws Exception {
        
        assertTrue(data.check_to_login("", "", ""));
        
    }
    
    @Test
    public void testCheck_to_user() throws Exception {
        
        assertTrue(data.check_to_user("", ""));
        
    }
    
    @Test
    public void testInsert_user() throws Exception {
        
        assertTrue(data.insert_user("", "", ""));
        
    }
    
    @Test
    public void testCheck_id_admin() throws Exception {
        
        assertTrue(data.check_id_admin(""));
        
    }
    
    @Test
    public void testInsert_admin() throws Exception {
        assertTrue(data.insert_admin(1, "", "", "", "", "", new java.sql.Date(new Date().getTime()), "", "", ""));
        
    }
    
    @Test
    public void testCheck_id_reciption() throws Exception {
        
        assertTrue(data.check_id_reciption("1"));
    }
    
    @Test
    public void testInsert_reciption() throws Exception {
        
        assertTrue(data.insert_reciption(1, "", "", "", "", "", new java.sql.Date(new Date().getTime()), "", "", ""));
        
    }
    
    @Test
    public void testCheck_id_doctor() throws Exception {
    }
    
    @Test
    public void testInsert_doctor() throws Exception {
    }
    
    @Test
    public void testCheck_id_accountant() throws Exception {
    }
    
    @Test
    public void testInsert_accountant() throws Exception {
    }
    
    @Test
    public void testCheck_id_nurse() throws Exception {
    }
    
    @Test
    public void testInsert_nurse() throws Exception {
    }
    
    @Test
    public void testCheck_id_pharmasist() throws Exception {
    }
    
    @Test
    public void testInsert_pharmasist() throws Exception {
    }
    
    @Test
    public void testCheck_id_xray() throws Exception {
    }
    
    @Test
    public void testInsert_xray() throws Exception {
    }
    
    @Test
    public void testCheck_id_lab() throws Exception {
    }
    
    @Test
    public void testInsert_lab() throws Exception {
    }
    
    @Test
    public void testDelete_admin() throws Exception {
    }
    
    @Test
    public void testDelete_reciption() throws Exception {
    }
    
    @Test
    public void testDelete_doctor() throws Exception {
    }
    
    @Test
    public void testDelete_accountant() throws Exception {
    }
    
    @Test
    public void testDelete_nurse() throws Exception {
    }
    
    @Test
    public void testDelete_pharmasist() throws Exception {
    }
    
    @Test
    public void testDelete_xray() throws Exception {
    }
    
    @Test
    public void testDelete_lab() throws Exception {
    }
    
    @Test
    public void testUpdate_admin() throws Exception {
    }
    
    @Test
    public void testUpdate_reciption() throws Exception {
    }
    
    @Test
    public void testUpdate_doctor() throws Exception {
    }
    
    @Test
    public void testUpdate_accountant() throws Exception {
    }
    
    @Test
    public void testUpdate_nurse() throws Exception {
    }
    
    @Test
    public void testUpdate_pharmasist() throws Exception {
    }
    
    @Test
    public void testUpdate_xray() throws Exception {
    }
    
    @Test
    public void testUpdate_lab() throws Exception {
    }
    
    @Test
    public void testSelect_admin() throws Exception {
    }
    
    @Test
    public void testSelect_reciption() throws Exception {
    }
    
    @Test
    public void testSelect_doctor() throws Exception {
    }
    
    @Test
    public void testSelect_accountant() throws Exception {
    }
    
    @Test
    public void testSelect_nurse() throws Exception {
    }
    
    @Test
    public void testSelect_pharmasist() throws Exception {
    }
    
    @Test
    public void testSelect_lab() throws Exception {
    }
    
    @Test
    public void testSelect_xray() throws Exception {
    }
    
    @Test
    public void testSelect_user() throws Exception {
    }
    
    @Test
    public void testCheck_user_complete() throws Exception {
    }
    
    @Test
    public void testUpdate_user() throws Exception {
    }
    
    @Test
    public void testSelect_user_spec() throws Exception {
    }
    
    @Test
    public void testCheck_id_room() throws Exception {
    }
    
    @Test
    public void testInsert_room() throws Exception {
    }
    
    @Test
    public void testUpdate_room() throws Exception {
    }
    
    @Test
    public void testInsert_reciption_pationt() throws Exception {
    }
    
    @Test
    public void testUpdate_reciption_pationt() throws Exception {
    }
    
    @Test
    public void testSelect_pationt_id() throws Exception {
    }
    
    @Test
    public void testSelect_all_patient() throws Exception {
    }
    
    @Test
    public void testDelete_patient() throws Exception {
    }
    
}