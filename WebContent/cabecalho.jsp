<?xml version="1.0" encoding="ISO-8859-1" ?>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
   <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
   <script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0" ></meta>		
	<link href="css/index.css" rel="stylesheet"></link>
	<link href="css/form.css" rel="stylesheet"></link>			
	<script type="text/javascript" src="js/java-script.js"></script>
  
	 <script type="text/javascript">
 
             //  **** funcao de data ****
               $(function() {
                $("#data").datepicker({
                        changeMonth: true,
                        changeYear: true,
                        dateFormat:'dd/mm/yy'
                    });
              });
               

	function faleConosco(){		
		//window.open("faleconosco.jsp", "", "top=500,left=500,width=500,height=500");
		
		}               
    </script>
                   
	<title>Qi Auto Peças</title>
</head>
<body> 
	<nav id="menu-superior">
		<ul>
			<li>
				<!--  a href="#" onclick="javascript:faleConosco();" >--> 
				<a href="#" onclick="javascript:load('form','Fale','loadForm'); " >
					Fale conosco
				</a>
			</li>
			<li>
				<a href="#" onclick="javascript:load('form','Login','loadForm');" >
					Minha conta
				</a> 
			</li>
			<li>
				<a href="#" onclick="javascript:load('form','Login','novo');" >
					Novo
				</a> 
			</li>			
		</ul>
	</nav>			
</body>
</html>
