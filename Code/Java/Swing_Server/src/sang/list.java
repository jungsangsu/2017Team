/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sang;

import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class list extends javax.swing.JFrame {
	
	static Scanner input = new Scanner(System.in);
	BufferedImage image; // 이미지를 저장할 이미지 버퍼.
	static Connection conn = null; // DataBase와 연결을 위한 참조변수 선언.
	static Statement stmt = null; // DataBase에 Query 이용 변수.
	static ResultSet rs = null; // DataBase에 Query 이용 변수.
	static int r = 0;
	static boolean ProgramCondition = true; // 프로그램 UI 전체 흐름제어 변수.
	static Date date = new Date();
	static String dateTime = date.toString();
	
    public list() {
        initComponents();
    }
    
    public list(String name) { //검색에서 보기 위해서
        initComponents(name);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">      
private void initComponents(String Listname) {
    	
    	String totalList = new String("<html>");
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jLabel2.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel2.setText("SHOW LIST");
        jScrollPane1.setViewportView(jLabel1);
        this.setLocation(600, 300);
        
        try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://ssdb.ccijo8xfuwup.ap-northeast-2.rds.amazonaws.com:3306/SSDB?verifyServerCertificate=false&useSSL=true",
					"username", "password"); // DataBase와 연결-> RDS 사용하기.
				
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("select * from info where name like '%" + Listname + "%' ");
					
			if (rs == null)
				System.out.println("No such content found.");
			while (rs.next()) {
				String name2 = rs.getString("name");
				String phoneNumber = rs.getString("phoneNumber");
				String roomNumber2 = rs.getString("roomNumber");
				String EntranceTime = rs.getString("EntranceTime");
				String ExitTime = rs.getString("ExitTime");
				String picture = rs.getString("picture");
				char level = roomNumber2.charAt(0);
				totalList += (name2+"&nbsp;&nbsp;&nbsp;&nbsp;"+phoneNumber+"&nbsp;&nbsp;&nbsp;&nbsp;"+roomNumber2+"&nbsp;&nbsp;&nbsp;&nbsp;"+EntranceTime+"&nbsp;&nbsp;&nbsp;&nbsp;"+ExitTime+"<br/>");
				
			}
			totalList+="</html>";
		} catch (ClassNotFoundException cnfe) {
			System.out.println("The class could not be found." + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		try {
			conn.close();
		} catch (SQLException e2) {
			System.out.println(e2.getMessage());
		}
		jLabel1.setText(Listname);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(jLabel2)
                .addContainerGap(329, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );
        pack();
    }
    
    private void initComponents() {
    	
    	String totalList = new String("<html>");
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jLabel2.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel2.setText("SHOW LIST");
        jScrollPane1.setViewportView(jLabel1);
        this.setLocation(600, 300);
        
        try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://ssdb.ccijo8xfuwup.ap-northeast-2.rds.amazonaws.com:3306/SSDB?verifyServerCertificate=false&useSSL=true",
					"username", "password"); // DataBase와 연결-> RDS 사용하기.
				
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("select * from info");
					
			if (rs == null)
				System.out.println("No such content found.");
			while (rs.next()) {
				String name2 = rs.getString("name");
				String phoneNumber = rs.getString("phoneNumber");
				String roomNumber2 = rs.getString("roomNumber");
				String EntranceTime = rs.getString("EntranceTime");
				String ExitTime = rs.getString("ExitTime");
				String picture = rs.getString("picture");
				char level = roomNumber2.charAt(0);
				totalList += (name2+"&nbsp;&nbsp;&nbsp;&nbsp;"+phoneNumber+"&nbsp;&nbsp;&nbsp;&nbsp;"+roomNumber2+"&nbsp;&nbsp;&nbsp;&nbsp;"+EntranceTime+"&nbsp;&nbsp;&nbsp;&nbsp;"+ExitTime+"<br/>");
			}
			totalList+="</html>";
		} catch (ClassNotFoundException cnfe) {
			System.out.println("The class could not be found." + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		try {
			conn.close();
		} catch (SQLException e2) {
			System.out.println(e2.getMessage());
		}
		jLabel1.setText(totalList);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(jLabel2)
                .addContainerGap(329, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>                       
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new list().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}