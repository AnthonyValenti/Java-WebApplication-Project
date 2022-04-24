<%-- 
    Document   : userMovies
    Created on : Jan 24, 2021, 1:00:48 AM
    Author     : student
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="ryerson.ca.helper.Movie"%>
<!DOCTYPE html>


<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Screenings</title>
    </head>
    <style>

    body {
        background: #222D32;
        font-family: 'Roboto', sans-serif;

    }
</style>
<% 
    ArrayList<Movie> movies= (ArrayList)request.getAttribute("moviesInfo");
  
%>

<center><h2>Welcome back <%=request.getAttribute("username")%>!</h2></center>
<br>
<center><h3>Movie Screenings</h3></center>
<br>
<form action="BuyTicket" method="get">
<table border="2" align="center" cellpadding="5" cellspacing="5">

<tr>
   
<th> Title </th>
<th> Seats </th>
<th> Times </th>
<th> Date </th>
<th> Location </th>
<th> More Info </th>

</tr>

    <% for(Movie movie: movies){
    %>
<tr>
<td> <%=movie.getName()%> </td>
<td> <%=movie.getOpenSeats() %></td>
<td> <%=movie.getTime() %></td>
<td> <%=movie.getDate() %></td>
<td> <%=movie.getAddress() %></td>
<% if (movie.getOpenSeats()>0){
%>
<td> <input type="submit" value="Buy Ticket"></td>
<%}

else {
%>


<td> N/A </td>
<% }}
%>

</tr>
</table>
</form>
</body>
</html>
