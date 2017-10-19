package net.cb.dcm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.cb.dcm.jpa.DeviceDAO;
import net.cb.dcm.jpa.entities.Device;

/**
 * Servlet implementing a simple JPA based persistence sample application for SAP Cloud Platform.
 */
public class DeviceLoader extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger moLogger = LoggerFactory.getLogger(DeviceLoader.class);

    /** {@inheritDoc} */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String loIp = request.getParameter("IP");
    	if (loIp == null || loIp.isEmpty()) {
    		response.getWriter().println("<p>Here you need to build the initial page, which will be used by all devices</p>");
    	} else {
    		try {
    			Device loDevice = DeviceDAO.findDeviceByIp(loIp);
    			if (loDevice == null){
// Register device ID in the database
// Maybe registering only the IP, then the system opearator should see it in the 
// list as a device without data, and maintain it. 
//    				Load device default playlist
    			} else {
//    				Get device playlist and load it  
    			}
    		} catch (Exception e){
    			moLogger.error("Error rendering the page: " + e.getMessage());
    		}
    		
    	}
    }

    /** {@inheritDoc} */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
    	doGet(request, response);
    }
}
