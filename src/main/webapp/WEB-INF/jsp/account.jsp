<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>
<style>
.images_petit{
width:150px;
height:150px;
cursor:pointer;
}

</style>


<h1>${user.name}</h1>
<!-- <img src="/images/user.png" class="images_petit"/>  -->
<!-- <img src="account/photo.html"/> -->
<img src="account/photo.html?id=${user.id }" class="img-thumbnail images_petit" id="image" onerror="imgError();" onclick="changePic()" />

<br/><br/>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  New Blog
</button>




<form:form commandName="blog" cssClass="form-horizontal" id="blogForm">
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">New Blog</h4>
      </div>
      <div class="modal-body">
        
        
        
        <div class="form-group">
		<label for="name" class="col-sm-2 control-label">Name</label>
		
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control" placeholder="Name" />
			<form:errors path="name" />
		</div>

</div>

    <div class="form-group">
		<label for="name" class="col-sm-2 control-label">URL</label>
		
		<div class="col-sm-10">
			<form:input path="url" cssClass="form-control" placeholder="URL" />
				<form:errors path="url" />
		</div>
        
        </div>
        
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" value="Save Blog" class="btn btn-primary"/>
       
      </div>
    </div>
  </div>
</div>
</form:form>

<br/><br/>
<script type="text/javascript">
function imgError(){
	$('#image').attr('src','/images/user.png');
}
function changePic(){
	alert('d');
}
$(document).ready(function(){

	
	
	$('.nav-tabs a:first').tab('show') ;// Select first tab
	$('.triggerRemove').click(function(e){
		
		e.preventDefault();

		$('#modalRemove .removeBtn').attr("href",$(this).attr("href"));	
			
		$('#modalRemove').modal();

		});

	$("#blogForm").validate({
		rules:{
			name:{			
				required:true,
				minlength:1
	
				},
			url:{
				required:true,
				url: true
				}	


			}
			,
		highlight:function(element){
			$(element).closest(".form-group").removeClass('has-success').addClass('has-error');
			$('.removeBtn').click(function(e){
				e.preventDefault();
				});
			}
			,
			unhighlight:function(element){
				$(element).closest(".form-group").removeClass('has-error').addClass('has-success');

				}
		});


	
});

</script>

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
				<th>date</th>
				<th>item</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${blog.items }" var="item">
				<tr>
					<td><c:out value="${item.publishedDate }"/></td>
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




