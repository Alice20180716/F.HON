<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>	
<%
	Cookie[] cookie = request.getCookies();
	//String cName = cookie[i].getName();
	Map<String,Object> smem_name = null;
	for(int i=0;i<cookie.length;i++){
	System.out.print(cookie[i].getName());
	System.out.print(cookie[i].getValue());
	}
	/* String smem_name = null;
		List<Map<String, Object>> memList = (List<Map<String, Object>>) session.getAttribute("memList");
	if ((List<Map<String, Object>>)memList != null) {
		smem_name = memList.get(0).get("MEM_NAME").toString();
	} */
	/* if("memList".equals(cName)){
		smem_name = cookie[i].getValue();
	} */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>메인</title>
</head>
<body>
		<% 
			if(smem_name==null/*  || smem_name=="" */){
		%>	
			<%@ include file="../../include/include/logout_top.jsp" %>
		<% 	
			}else {
		%>
			<%@ include file="../../include/include/top.jsp" %>
		<% 	
			}
		%>

<!--  -->
<div class="ui two column stackable grid" style="height:650px">
    <div class="column">
		<a  id="btn1" style="width:100%; height:100%;"><img src="../../image/person.PNG" style="width:100%; height:100%;"></a>
    </div>
    <div class="column">
 		 <a id="btn2" style="width:100%; height:100%;"><img src="../../image/with.jpg"style="width:100%; height:100%;"></a>
    </div>
</div>
<!--  -->

<%@ include file="../../include/include/bottom.jsp" %>
</body>
</html>