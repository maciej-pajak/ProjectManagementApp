<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<t:pageWrapper title="Homepage">
    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header"> New task </h2>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <form:form method="post" modelAttribute="taskDto">
                            <div class="form-group">
                                <label>Project</label>
                                <p class="form-control-static">${taskDto.project.name}</p>
                                <form:input type="hidden" value="${taskDto.project.id}" path="project.id"/>
                            </div>
                            <div class="form-group">
                                <label for="name">
                                    Topic:
                                </label>
                                <form:input type="text" required="required" path="topic" class="form-control" id="name"/>  
                                <form:errors path="topic" element="div"/>
                            </div>
                            <div class="form-group">
                                <label for="description">
                                    Description:
                                </label>
                                <form:input type="text" required="required" path="description" class="form-control" id="description"/>  
                                <form:errors path="description" element="div"/>
                            </div>
                            <div class="form-group">
                                <label>User: </label>
                                <form:select path="user.id" items="${taskDto.project.users}" itemLabel="email" itemValue="id" class="form-control"/>
                            </div><form:errors path="user" element="div"/>
                            <div class="form-group">
                                <label>Status:</label>
                                <form:select path="status.id" items="${status}" itemLabel="name" itemValue="id" class="form-control"/>
                            </div><form:errors path="status" element="div"/>
                            <div class="form-group">
                                <label>Priority:</label>
                                <form:select path="priority.id" items="${priorities}" itemLabel="name" itemValue="id" class="form-control"/>
                            </div><form:errors path="priority" element="div"/>
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