<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<style>
.images_petit{
width:150px;
height:150px;
}

</style>


<h1>${user.name }</h1>

<img src="photo.html?id=${user.id }" class="img-thumbnail images_petit" id="image" onerror="imgError();"/>

<br/><br/>


<div>

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
  <c:forEach items="${user.blogs}" var="blog">
    <li role="presentation"><a href="#blog_${blog.id}" aria-controls="settings" role="tab" data-toggle="tab">${blog.name}</a></li>
 </c:forEach>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
  <c:forEach items="${user.blogs}" var="blog">
    <div  class="tab-pane" id="blog_${blog.id }">
    
    <h1>${blog.name}</h1>
    
 	<p>
 	
 	<a href='<spring:url value="/blog/remove/${blog.id}.html"/>' class="btn btn-danger triggerRemove">remove blog</a>
 	${blog.url}</p>

	<table  class="table table-hover table-bordered table-striped">
		<thead>
			<tr>
				<th>Title</th>
				<th>Link</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${blog.items }" var="item">
				<tr>
					<td>${item.title }</td>
					<td>${item.link }</td>
				</tr>

			</c:forEach>
		</tbody>


	</table>
    
    
    </div>
</c:forEach>
  </div>

</div>




<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove blog</h4>
      </div>
      <div class="modal-body">
        Are you sure?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>


<script type="text/javascript">
function imgError(){
	$('#image').attr('src','/images/user.png');
}
$(document).ready(function(){
	$('.nav-tabs a:first').tab('show') // Select first tab
	$('.triggerRemove').click(function(e){
		
		e.preventDefault();

		$('#modalRemove .removeBtn').attr("href",$(this).attr("href"));	
			
		$('#modalRemove').modal();

		});


	
});

</script>