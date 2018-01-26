<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<t:pageWrapper title="Homepage">
    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header"> New project </h2>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <form:form method="post" modelAttribute="project">
                            <div class="form-group">
                                <label for="name">
                                    Name:
                                </label>
                                <form:input type="text" required="required" path="name" class="form-control" id="name"/>  
                                <form:errors path="name" element="div"/>
                            </div>
                            <div class="form-group">
                                <label for="description">
                                    Description:
                                </label>
                                <form:input type="text" required="required" path="description" class="form-control" id="description"/>  
                                <form:errors path="description" element="div"/>
                            </div>
                            <div class="form-group">
                                <label for="url">
                                    Website:
                                </label>
                                <form:input type="text" required="required" path="url" class="form-control" id="url"/>  
                                <form:errors path="url" element="div"/>
                            </div>
                            <div class="form-group">
                                <label>Users</label>
                                <form:select itemValue="id" itemLabel="name" path="users.id" items="${users}"/>
                            </div>
                            <div>
                                <button type="submit" class="btn btn-success">Create</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:pageWrapper>