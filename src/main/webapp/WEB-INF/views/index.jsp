<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Person Page</title>
	<style type="text/css">	
		
		.btn{
			color: white;
			background: green; 
			height: 30px;
			width: 90px;
			margin-left: 10px;
		}
		.inp{
			height: 28px;
			width: 400px;
			background: rgb(247, 239, 239);
		}
		
	</style>
	
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

</head>
<body>
	<h1>
		Add a URL
	</h1>

	<c:url var="addAction" value="/index/add" ></c:url>

	<form:form action="${addAction}" commandName="userurlt">
		<div class ="main">
			<form:input class="inp"  path="url" id="autocomplete"/>
			<button class ="btn">Submit</button>
		</div>
	</form:form>
</body>

<script>

/*	
$(document).ready(function() {
	
	$(function() {
            $("#autocomplete").autocomplete({     
            	source : function(request, response) {
                    $.ajax({
                        url : "/TILAssignment01/index/auto",
                        type : "GET",
                        data : {
                                term : request.term
                        },
                        dataType : "json",
                        success : function(data) {
                                response(data);
                        }
                	});
            	}
            });
    }
	);
});
*/
$(document).ready(function() {
	
	$(function() {
            $("#autocomplete").autocomplete({     
            	source :"/TILAssignment01/index/auto"
            });
    }
	);
});
	
</script>	

</html>
