/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package test;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;

/**
 *
 * @author Manitra
 */
public class Test extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        PrintWriter out = response.getWriter();
        out.print("test");
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        PrintWriter out = response.getWriter();
        out.print("test");
    }
}
