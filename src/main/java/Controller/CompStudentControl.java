package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import data.model.CompStudent;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "csControl")

public class CompStudentControl{

    public ArrayList<CompStudent>recordStudent()
    {
        ArrayList<CompStudent>arr=new ArrayList();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Computer_lab","bup_lab");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("Select*from Computer_Student");
            while(rs.next())
            {
                CompStudent cmp=new CompStudent();

                cmp.setId(rs.getInt(1));
                cmp.setSec(rs.getString(2));
                arr.add(cmp);

            }


        }
        catch (Exception e)
        {

        }
        return  arr;

    }


    public String viewStudent()
    {
        return "view";
    }


}



