
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="ryerson.ca.helper.Movie"%>
<!DOCTYPE html>


<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Options</title>
        <style>
            body {
                background: #222D32;
                font-family: 'Roboto', sans-serif;
                color: white;
            }

        </style>
    </head>

<% 
    ArrayList<Movie> movies= (ArrayList)request.getAttribute("moviesInfo");  
%>



 

<center><h2>Manager Tools</h2></center>
<br>
<center><h3>Movie Screenings</h3></center>
<br>
<table align="center" cellpadding="5" cellspacing="5">

<tr>

<th> ID </th>
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
<td> <%=movie.getId() %> </td>
<td> <%=movie.getName()%> </td>
<td> <%=movie.getOpenSeats() %></td>
<td> <%=movie.getTime() %></td>
<td> <%=movie.getDate() %></td>
<td> <%=movie.getAddress() %></td>
<% String deletemovieService= System.getenv("deletemovieService"); %>
<form action="http://<%=deletemovieService%>/DeleteMovie/webresources/deletemovie/update" method="post">
<input type="hidden" name="id" class="form-control" value="<%=movie.getId()%>">
<td> <input type="submit" value="Delete Movie" ></td>
</form>

<% }
%>

</tr>
</table>
<% String addmovieService= System.getenv("addmovieService"); %>
<form action = "http://<%=addmovieService%>/AddMovie/webresources/addmovie/update" method="post" role="form">
    
<center><div style="padding-top: 2%">
<input name="name" placeholder="Title">
<input name="seats" placeholder="Seats">
<input name="time" placeholder="Time">
<input name="date" placeholder="Date">
<input name="address" placeholder="Address">
<input name="pageName" type="hidden" value="AddMovie">
<button type="submit">Add Movie</button>

</div></center>
</form>





</body>
</html>


