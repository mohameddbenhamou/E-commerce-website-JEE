package cn.supermarche.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import cn.supermarche.connection.DbCon;
import cn.supermarche.dao.CommandeDao;

@WebServlet("/ValiderCommande")
public class ValiderCommandeServelet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(PrintWriter out = response.getWriter()) {
			String id = request.getParameter("id");
			String prix = request.getParameter("prix");
			if(id != null) {
				CommandeDao commandeDao = new CommandeDao(DbCon.getConnection());
				commandeDao.validerCommande	(Integer.parseInt(id),Double.parseDouble(prix));
			}
			response.sendRedirect("gestionCommandes.jsp");
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}


}
