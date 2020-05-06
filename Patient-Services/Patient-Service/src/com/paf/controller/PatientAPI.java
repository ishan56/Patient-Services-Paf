package com.paf.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paf.bean.Patient;
import com.paf.model.PatientDAO;

/**
 * Servlet implementation class PatientAPI
 */
@WebServlet("/PatientAPI")
public class PatientAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientAPI() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private static Map getParasMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
    	
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			
			String[] params = queryString.split("&");
			for(String param : params) {
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    	return map;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String nic = request.getParameter("nic");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println(nic);
		
		Patient patient = new Patient(nic, firstName, lastName, dob, gender, email, password);
		
		String output = PatientDAO.registerPatient(patient);
		
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map paras = getParasMap(request);
		
		String nic = paras.get("nic").toString();
		String firstName = paras.get("firstName").toString();
		String lastName = paras.get("lastName").toString();
		String dob = paras.get("dob").toString();
		String gender = paras.get("gender").toString();
		String email = paras.get("email").toString();
		String password = paras.get("password").toString();
		
		Patient patient = new Patient(nic, firstName, lastName, dob, gender, email, password);
		
		String output = PatientDAO.updatePatient(patient);
		
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		
		String nic = paras.get("nic").toString();
		
		Patient patient = new Patient(nic);
		
		String output = PatientDAO.deletePatient(patient);
		
		response.getWriter().write(output);
	}

}
