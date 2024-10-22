<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container-fluid">
	<h1 class="h3 mb-4 text-gray-800">List</h1>
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>bno</th>
							<th>title</th>
							<th>regdate</th>
							<th>name</th>
							<th>readcnt</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="dto" items="${list}">
							<tr>
								<td>${dto.bno}</td>
								<td>
								<c:if test="${dto.re_lev!=0}">
								<c:forEach begin="0" end="${dto.re_lev*1}">
									&nbsp;
								</c:forEach>
								</c:if>
								<a href="${dto.bno}" class="text-decoration-none text-reset">${dto.title}</a>
								</td>
								<td>${dto.regdate}</td>
								<td>${dto.name}</td>
								<td>${dto.readcnt}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="row">
				<div class="col-sm12 col-md-12">
					<ul class="pagination justify-content-center">
						<li class="paginate_btton page-item previous"></li>
						<a href="" class="page-link">previous</a>
						<li class="paginate_btton page-item"></li>
						<a href="" class="page-link">1</a>
						<li class="paginate_btton page-item next"></li>
						<a href="" class="page-link">next</a>
					</ul>
				</div>
			</div>
			<%-- 페이지 나누기 --%>
			<form action="/read.do" method="get"id="actionForm">
			<input type="hidden" name="bno"value="" />
			</form>
			<script src="/js/custom/list.js"></script>
			<%@ include file="../include/footer.jsp"%>