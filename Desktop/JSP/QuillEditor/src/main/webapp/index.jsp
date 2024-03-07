<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv = "X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=deice-width, initial-scale=1.0">
<title>Quill editor</title>
<script src="http://cdn.quilljs.com/1.3.6/quill.js"></script>
<script src="http://cdn.quilljs.com/1.3.6/quill.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<link href = "http://cdn.quilljs.com/1.3.6/quill.snow.css" rel = "stylesheet">
<link href = "http://cdn.quilljs.com/1.3.6/quill.bubble.css" rel = "stylesheet">
<link rel="stylesheet" href = "https://cdn.quilljs.com/1.3.6/quill.core.css">

</head>
<body>
	 <button id = "savedelta">저장</button>
	 <div id="editor" style="height: 400px"></div>
	 <div id="toolbar" style="height: 400px"></div>
	  
   	 <script scr="./index.js"></script>
   	 <script> 
	 	var toolbarOptions = [
   	 		['bold','italic','underline','strike'],
   	 		['blockquote','code-block'],
   	 		[{'header' : [1, 2, 3, 4, 5, 6, false] }],
   	 		[{'list' : 'ordered' }, {'list' : 'bullet'}],
   	 		[{'script' : 'sub' }, {'script' : 'super'}],
   	 		[{'direction' : 'rt1' }],
   	 		[{'size' : ['samll', false , 'large' , 'huge'] }],
   	 		[{'color' : [] } , {'background' : [] }],
   	 		[{ 'font' : [] }],
   	 	];
   	 	
   	 
   	 	var quill = new Quill('#editor',{
   	 		modules:{ 
   	 			toolbar: toolbarOptions
   	 		},
   	 		
   	 		theme: 'snow'
   	 	});
   	 	
   	 	$('#savedelta').click(function (){
   	 		var delta = quill.getContents();
   	 		console.log(delta);
   	 		
   	 	})
   	 	
   	 	
   	 	
   	 
   	 </script>
</body>
</html>