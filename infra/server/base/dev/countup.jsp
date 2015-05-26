<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.net.*" %>
<%
Integer counter = (Integer)session.getAttribute("counter");

if(counter == null){
    counter = new Integer(1);
}else{
    counter = new Integer(counter.intValue()+1);
}
session.setAttribute("counter", counter);
%>
<%= session.getAttribute("counter") %><br>
from Cluster 1<br>
<%= InetAddress.getLocalHost() %><br>
<%= session.getId() %><br>