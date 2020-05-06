<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<meta charset="ISO-8859-1">






 <head>
            <title>Payment Management Application</title>
            
          
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Payment Management Application </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" 
                        class="nav-link">payments</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${payment != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${payment == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${payment != null}">
                                    Edit Payment
                                </c:if>
                                <c:if test="${payment == null}">
                                    Add New Payment
                                </c:if>
                            </h2>
                        </caption>
                        

                        <c:if test="${payment != null}">
                            <input type="hidden" name="id" value="<c:out value='${payment.id}' />" />
                        </c:if>
                        
                        <form>

                        <fieldset class="form-group">
                            <label>amount</label> <input type="text" value="<c:out value='${payment.name}' />" class="form-control" name="amount" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>type</label> <input type="text" value="<c:out value='${payment.email}' />" class="form-control" name="type">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>patient_name</label> <input type="text" value="<c:out value='${payment.country}' />" class="form-control" name="patient_name">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>