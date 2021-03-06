<%@page import="dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Vastaukset" %>   
  <%@ page import="data.Kysymys" %> 
 <%@ page import="dao.Dao" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<!DOCTYPE html>
<html lang="fi">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style><%@include file="/WEB-INF/css/style.css"%></style>
    <title>Vaalikone</title>
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    
</head>
<body>
<div class="grid-container">
  <div class="grid-left"></div>
  <div class="grid-item">
 <%

 	Dao dao = (Dao)request.getAttribute("dao"); 
 	Kysymys k=(Kysymys)request.getAttribute("kysymys");
 	Vastaukset q = dao.readVastaus(request.getParameter("id"));
 	if(request.getParameter("Perustelu")!=null && request.getParameter("Vastaus")!=null){
 		
 		int vastasi=Integer.parseInt(request.getParameter("Vastaus"));
 		String perustelu = request.getParameter("Perustelu");
 		q.setVastasi(vastasi);
 		q.setPerustelu(perustelu);	
 		q=dao.updateVastaus(q);
 	}
	if(q==null){
		out.println("<b>Jokin meni vikaan</b>");
	}
	else {
		int vnum= q.getVastasi();
		out.println("<h2>"+k.getKysymys()+"</h2>");
		out.println("<form action='editVastaus' method='get'>");

		out.println("<input type='hidden' value='"+request.getParameter("id")+"' name='id'>");

		if(vnum==-2)out.println("<input type='radio' id='q_op1' name='Vastaus' value='-'checked=2'checked'>");
		else out.println("<input type='radio' id='q_op1' name='Vastaus' value='-2'");
		out.println("<label for='q_op1'>Täysin eri mieltä</label>");
	    		
		out.println("<br>");
				
		if(vnum==-1)out.println("<input type='radio' id='q_op2' name='Vastaus' value='-1' checked='checked'>");
		else out.println("<input type='radio' id='q_op2' name='Vastaus' value='-1'");
	    out.println("<label for='q_op2'>Hieman eri mieltä</label>");
	    		
	    out.println("<br>");
	    
	    if(vnum==0)out.println("<input type='radio' id='q_op3' name='Vastaus' value='0' checked='checked'>");
		else out.println("<input type='radio' id='q_op3' name='Vastaus' value='0'");
	    out.println("<label for='q_op3'>En osaa sanoa</label>");
	
	    out.println("<br>");
	    		
	    if(vnum==1)out.println("<input type='radio' id='q_op4' name='Vastaus' value='1' checked='checked'>");
		else out.println("<input type='radio' id='q_op4' name='Vastaus' value='1'");
	    out.println("<label for='q_op4'>Jokseenkin samaa mieltä</label>");
	    	
	    out.println("<br>");
	    		
	    if(q.getVastasi()==2)out.println("<input type='radio' id='q_op5' name='Vastaus' value='2' checked='checked'>");
		else out.println("<input type='radio' id='q_op5' name='Vastaus' value='2'");
	    out.println("<label for='q_op5'>Täysin samaa mieltä</label>");
	    
	    out.println("<br>");
	    		
	   	out.println("<textarea name='Perustelu' rows='4' cols='20' Required >"+q.getPerustelu()+"</textarea >");
	   	
	   	out.println("<br>");
	   	
	   	out.println("<input type='submit' value='Päivitä'>");
	   	
	   	out.println("<br>");
	}
   	out.println("<a href='./vastaukset'>Palaa</a>");

%>
		
		</div>
  <div class="grid-right"></div>  
</div>

</body>
</html>