<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>
<title>AIZANT::View_Study_Volunteer</title>
<link rel="stylesheet"
	href='<x:url value="/resources/css/bootstrap.min.css"></x:url>' />
<script src='<x:url value="/resources/js/jquery.min.js"></x:url>'></script>
<script src='<x:url value="/resources/js/bootstrap.min.js"></x:url>'></script>
<script src='<x:url value="/resources/js/angular.min.js"></x:url>'></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/viewuser.css" />
	

</head>
<body>
	<%@ include file="/WEB-INF/views/template/header.jsp"%>
	<br>
	<br>
	<br/>
	<div class="container">
		<div class="section">


			<div
				class="col-xs-9 col-sm-9 col-md-0 col-lg-4 col-xs-offset-0 col-sm-offset-0 col-md-offset-0 col-lg-offset-0 toppad">


				<div class="panel panel-info">
					<div class="panel-heading">
						
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-3 col-lg-3 " align="center">
								<img alt="User Pic"
									src="http://previews.123rf.com/images/krisdog/krisdog1308/krisdog130800150/21822848-An-illustration-of-a-cartoon-scientist-holding-a-test-tube-and-clipboard-in-a-white-lab-coat-perform-Stock-Vector.jpg"
									class="img-circle img-responsive">
							</div>

							<div class=" col-md-9 col-lg-9 ">
								<table class="table table-user-information">
									<tbody>


										<tr>
											<td>Volunteer ID:</td>
											<td>${study_Volunteer.volunteerId}</td>
										</tr>


										<tr>
											<td>Volunteer Name:</td>
											<td>${study_Volunteer.volunteerName}</td>
										</tr>


									</tbody>
								</table>

								<a href="edit_studyVolunteer?id=${study_Volunteer.id}"
									class="btn btn-primary">EDIT</a> <a
									href="Jasper?id=${study_Volunteer.id}" class="btn btn-primary">Print
									Barcode</a>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
<div class="section right">

<br>

			<div class="col-md-7 col-md-offset-1">

				<div class="panel panel-default panel-table">
					<div class="panel-heading">
						<div class="row">
							<div class="col col-xs-6">
								<h3 class="panel-title">
									<b>Blood Sample Collection Record</b>
								</h3>
							</div>
							<div class="col col-xs-6 text-right">
						<a href="#"><button type="button"
								class="btn btn-sm btn-primary btn-create">Print</button></a>
					</div>

						</div>
					</div>

					<div>

						<table class="table table-hover table-bordered">
							<tr>

								<th>Date</th>
								<th>Time Point (hr)</th>
								<th>Scheduled Time of Collection</th>
								<th>Changed Scheduled Time of Collection</th>
								<th>Actual Time ofCollection</th>
								<th>Comments*</th>

							</tr>
							<tr ng-repeat="a in study.studyVolunteers">

								<td></td>

								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>



								
							</tr>
						</table>
					</div>
				</div>
			</div>
</div>
</div>

</body>
<%@ include file="/WEB-INF/views/template/footer.jsp"%>
</html>