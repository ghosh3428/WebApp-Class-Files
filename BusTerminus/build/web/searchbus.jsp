<%-- 
    Document   : searchbus
    Created on : Jul 14, 2023, 8:38:30 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Bus Page</title>
        <style>
            nav
            {
                background-color: black;
            }
            nav a
            {
                color:white;
                padding:1%;
                margin-left:1%;
                font-size:25px;
            }
            .heading
            {
                color:white;

                text-align: center;

            }
            div
            {
                margin:2%;
            }
            body
            {
                background-color:  lightsalmon;
            }
            tr
            {
                font-size:25px; 
            }
            div
            {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <%@include file="navbar.jsp" %>

        <h1 class="heading"> Search Bus</h1>
        <fieldset>
            <legend>Search By Source </legend>
            <div>
                <form>
                    <label>Select Source</label>
                    <select name="source">
                        <option>Op1
                        <option>op2
                    </select>
                    <input type="submit" value="Search"/>
                </form>

            </div>
        </fieldset>

        <fieldset>
            <legend>Search By Destination </legend>
            <div>
                <form>
                    <label>Select Destination</label>
                    <select name="destination">
                        <option>Op1
                        <option>op2
                    </select>
                    <input type="submit" value="Search"/>
            </div>
        </fieldset>

        <fieldset >
            <legend>Search By Bus Type</legend>
            <div>
                <form>
                    <label>Select Bus Type</label>
                    <select name="bustype">
                        <option>Op1
                        <option>op2
                    </select>
                    <input type="submit" value="Search"/>
            </div>
        </fieldset>

        <fieldset>
            <legend>Search By Traveller </legend>
            <div>
               <form>
                    <label>Select Traveller</label>
                    <select name="traveller">
                        <option>Op1
                        <option>op2
                    </select>
                    <input type="submit" value="Search"/>
            </div>
        </fieldset>
    </body>
</html>
