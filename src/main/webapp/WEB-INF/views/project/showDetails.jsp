<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageWrapper title="Project">
    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">${project.name}</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Description: </th><td> ${project.description}</td>
                    </tr>
                    <tr>
                        <th>Created: </th><td> ${project.name}</td>
                    </tr>
                    <tr>
                        <th>Website: </th><td> ${project.url}</td>
                    </tr>
                    <tr>
                        <th>Identifier: </th><td> ${project.identifier}</td>
                    </tr>
                    <tr>
                        <th>Owner: </th><td> ${project.owner.email}</td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                     <div class="panel-heading">
                         <b>Users</b>
                     </div>
                     <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>Email</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="user" items="${project.users}">
                                        <tr>
                                            <td>${user.name}</td>
                                            <td>${user.surname}</td>
                                            <td>${user.email}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                     </div>
                 </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Tasks
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Topic</th>
                                        <th>Description</th>
                                        <th>Status</th>
                                        <th>Priority</th>
                                        <th>User</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="task" items="${tasks}">
                                        <tr>
                                            <td>${task.topic}</td>
                                            <td>${task.description}</td>
                                            <td>${task.status}</td>
                                            <td>${task.priority}</td>
                                            <td>${task.user.email}</td>
                                            <td>action</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:pageWrapper>