<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>


<section class="content-header">
	<h1>Member Form Update</h1>
	<ol class="breadcrumb">
<!-- 		<li><a href="#"><i class="fa fa-book"></i> Home</a></li> -->
<!-- 		<li class="active">Master</li> -->
	</ol>
</section>

<!-- Main content -->
<section class="content">

	<div class="box">

		<div class="form-container">



			<form:form method="POST" modelAttribute="tbl_member"
				class="form-horizontal" action="memberupdated">

				<%-- 		<form action="#" th:action="@{/update}" th:object="${product}" --%>
				<%--             method="post"> --%>
				<div class="box-body">
					<div class="form-group">
						<label class="col-md-3" for="memberid">ID</label>
						<div class="col-md-7">
							<form:input type="text" path="memberid" id="memberid"
								class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="membername" class="help-inline" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3" for="membername">Name</label>
						<div class="col-md-7">
							<form:input type="text" path="membername" id="membername"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="membername" class="help-inline" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3" for="dob">Date</label>
						<div class="col-md-7">
							<form:input type="date" path="dob" id="dob"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="dob" class="help-inline" />
							</div>
						</div>
					</div>

				</div>

				<div class="box-footer">
					<input type="submit" value="Register" class="btn btn-primary btn-sm">
					<a href="/member" class="btn btn-danger btn-sm">Back</a>
				</div>


			</form:form>
		</div>
	</div>
</section>
