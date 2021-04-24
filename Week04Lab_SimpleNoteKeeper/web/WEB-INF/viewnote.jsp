<%-- 
    Document   : viewnote
    Created on : Apr 23, 2021, 5:55:20 PM
    Author     : rizz4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>First Note Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        
        <h2>View Note</h2>
        
        
        <b>Title: </b> ${note.title}<br>
        <b>Contents: </b><br>
        ${note.content}<br>
        
        
        <a href="note?edit">Edit</a>
    </body>
</html>
