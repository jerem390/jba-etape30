<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<h1>latest news  from the Java World:</h1>


  
    
    <h1>${blog.name}</h1>
    

 	

	<table  class="table table-hover table-bordered table-striped">
		<thead>
			<tr>
				<th>date</th>
				<th>item</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${items }" var="item">
				<tr>
					<td><c:out value="${item.publishedDate }"/>
					<br/>
					<c:out value="${item.blog.name} "></c:out>
					</td>
					<td>
					<strong>
					<a href="<c:out value="${item.link }"/>"  target="_blank"><c:out value="${item.title }"/></a>
					</strong>
					<br/>
					${item.description }
					</td>
				</tr>

			</c:forEach>
		</tbody>


	</table>
    
    
 