package com.sergiubarsa;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MyFancyPdfInvoiceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equalsIgnoreCase("/")) {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print(
                    """
                            <html>
                            <body>
                            <h1>Hello World</h1>
                            <p>This is my very first, embedded Tomcat, HTML Page!</p>
                            </body>
                            </html>
                            
                            """
            );
        } else if (request.getRequestURI().equalsIgnoreCase("/invoices")) {
            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().print("[]");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().equalsIgnoreCase("/invoices")) {

            String userId = req.getParameter("user_id");
            int amount = Integer.parseInt(req.getParameter("amount"));

            Invoice invoice = new InvoiceService().create(userId, amount);

            resp.setContentType("application/json; charset=UTF-8");

            String json = new ObjectMapper().writeValueAsString(invoice);
            resp.getWriter().print(json);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }
    }
}