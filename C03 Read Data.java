import java.sql.*;

public class C03_ReadData02 {

        public static void main(String[] args) throws SQLException {


            // Use MySql work database from MySql lessons,,,
            // 1- Create Connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/work","root","123456");
            // 2- Create Statement/Query
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            // 3- Execute Statement/Query
            // 4- Store results in ResultSet

            // QUESTION1: Print first record from first column from the personnel table.
            String query1 = "select * from personnel";
            ResultSet rs1 =st.executeQuery(query1);
            rs1.next();
            System.out.println(rs1.getObject(1));

            // QUESTION2: Print all data for the second record (row)


            // QUESTION3: List all records from the personnel table.


            // QUESTION4: List the records from the personnel table where the salaries are over 15000.
            String query2= "select * from personnel where salary >15000";
            ResultSet rs2 = st.executeQuery(query2);
            rs2.absolute(0);
            while (rs2.next()) {
                System.out.println(rs2.getObject(1) + "    " +
                        rs2.getObject(2) + "    " +
                        rs2.getObject(3) + "    " +
                        rs2.getObject(4) + "    " +
                        rs2.getObject(5));
            }
            // QUESTION5: List all information of the personnel who is living in Paris
            String query3= "select * from personnel where city = 'Paris'";
            ResultSet rs3 = st.executeQuery(query3);
            rs3.absolute(0);
            while (rs3.next()) {
                System.out.println(rs3.getObject(1) + "    " +
                        rs3.getObject(2) + "    " +
                        rs3.getObject(3) + "    " +
                        rs3.getObject(4) + "    " +
                        rs3.getObject(5));
            }

            // QUESTION6: List the names of personnel whose second letter of their name is 'e' in the table.
            String query4= "select * from personnel where name like '_e%'";
            ResultSet rs4 = st.executeQuery(query4);
            rs4.absolute(0);
            while (rs4.next()) {
                System.out.println(rs4.getObject("name"));
            }
			
  }

}
