<%@ tag description="Page Wrapper Tag" pageEncoding="UTF-8" %>
<%@ attribute name="title" required="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Project Management - ${title}</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}">Twitterish</a>
            </div>
            
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href='<c:url value="/project/create"/>'><i class="fa fa-plus fa-fw"></i> New project</a>
                        </li>
                        <li>
                            <a href='<c:url value="/user/outbox"/>'><i class="fa fa-send fa-fw"></i> Your projects</a>
                        </li>
                        <c:forEach var="p" items="${createdProjects}">
                            <li>
                                <a href='<c:url value="/project/${p.id}"/>'><i class="fa fa-minus fa-fw"></i> ${p.name}</a>
                            </li>
                        </c:forEach>
                        <li>
                            <a href='<c:url value="/user/outbox"/>'><i class="fa fa-send fa-fw"></i> Projects you participate in</a>
                        </li>
                        <c:forEach var="p" items="${participateProjects}">
                            <li>
                                <a href='<c:url value="/project/${p.id}"/>'><i class="fa fa-minus fa-fw"></i> ${p.name}</a>
                            </li>
                        </c:forEach>
                        <li>
                            <a href='<c:url value="/user/${loggedUser.id}"/>'><i class="fa fa-twitter fa-fw"></i> Notifications</a>
                        </li>
                        <li>
                            <a href='<c:url value="/user/edit"/>'><i class="fa fa-edit fa-fw"></i> Edit profile</a>
                        </li>
                        <li>
                            <a href='<c:url value="/logout"/>'><i class="fa fa-sign-out fa-fw"></i> Log out</a>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <jsp:doBody/>
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/dist/js/sb-admin-2.js"></script>

</body>

</html>
