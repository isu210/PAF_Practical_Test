package net.healthcare.paymentManagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.healthcare.paymentManagement.dao.PaymentDAO;
import net.healthcare.paymentManagement.model.Payment;







public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    private PaymentDAO paymentDAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
      this.paymentDAO = new PaymentDAO();
    	  
     	
    }
    
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doGet(request, response);
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	
	String action = request.getServletPath();
	 
   
    
    	switch (action) {
             case "/new":
            	 
                 showNewForm(request, response);
                 break;
                 
             case "/insert":
            	 try {
                 insertPayment(request, response);
            	 }catch (SQLException e) {
            		 e.printStackTrace();
            	 }
            	 
                 break;
             case "/delete":
            	 try {
                 deletePayment(request, response);
            	 }catch (SQLException e) {
            		 e.printStackTrace();	 
            	 }
            	 break;
            	 
             case "/edit":
            	 try {
            		 showEditForm(request, response);
            	 }catch (SQLException e) {
            	 e.printStackTrace();
            	 }
                break;
               
             case "/update":
            	 try {
                 updatePayment(request, response);
            	 }catch (SQLException e) {
            		 e.printStackTrace();
            	 }
                 break;
                 
             default:
             try {
                 listPayment(request, response);
             }catch(SQLException e ) {
            	 e.printStackTrace();
             }
                 break;
         }
    	
    
   }
	  
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("payment-form.jsp");
		        
		        dispatcher.forward(request, response);
		    }
	
	 private void insertPayment(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        String amount = request.getParameter("amount");
			        String type = request.getParameter("type");
			        String patient_name = request.getParameter("patient_name");
			        Payment newPayment = new Payment(amount, type, patient_name);
			        paymentDAO.insertPayment(newPayment);
			        response.sendRedirect("list");
			    }
	 
	 private void deletePayment(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        paymentDAO.deleteUser(id);
			        response.sendRedirect("list");

			    }
	 private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, ServletException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        Payment existingPayment = paymentDAO.selectPayment(id);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("payment-form.jsp");
			        request.setAttribute("user", existingPayment);
			        dispatcher.forward(request, response);

			    }
	 private void updatePayment(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        String amount = request.getParameter("amount");
			        String type = request.getParameter("email");
			        String patient_name = request.getParameter("country");

			        Payment book = new Payment(id, amount, type, patient_name);
			        paymentDAO.updateUser(book);
			        response.sendRedirect("list");
			    }
	
	  private void listPayment(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
			         List <Payment> listPayment = paymentDAO.selectAllPayments();
			        request.setAttribute("listPayment", listPayment);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("payment-list.jsp");
			        dispatcher.forward(request, response);
			    }
	
	
	
}
