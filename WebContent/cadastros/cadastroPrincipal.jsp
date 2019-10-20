<%@page import="br.com.qi.form.*"%>
<jsp:include page="../cabecalho.jsp" />
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Principal</title>

  <!-- link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script -->

	<link href="css/index.css" rel="stylesheet" />
	<script type="text/javascript" src="js/java-script.js"></script>
	<script type="text/javascript" src="js/fontes-jquery.js"></script >	
<style type="text/css">
/*
.grid-container{
	display:grid;
	paddin:10px;
}*/

</style>  
<script type="text/javascript">
		
			function ocultaResposta() {
        		document.getElementById('resposta').style.display = 'none';
    		}            
</script>	
<%  	LoginForm loginForm = (LoginForm) request.getSession().getAttribute("form");
		String mensagem = (String)request.getAttribute("mensagem");
		
		if(loginForm == null )
			request.getSession().setAttribute("form", null);
		else
			request.getSession().setAttribute("form", loginForm);
%>
</head>
<body onload="setTimeout(ocultaResposta, 3000)">
  <form id="form">
	  	<input type='hidden' name='acao' id='acao' />
  		<input type='hidden' name='metodo' id='metodo' />
  		
		<div class="header">
		  		<h1>Qi Auto Peças</h1>  		
				<p> Sua melhor opção em peças automotivas </p>
		</div>	
		<div class="conteudo">
			<div class="col-3 col-s-3 menu">
				<ul>
					<li id="voltar" onclick="javascript:load('form','Fale','index');"  >
						Voltar
					</li>				
				</ul>
			</div>		
			<div class="col-6 col-s-9">
				<div class="w3-content w3-display-container">
				
				<h3>Cadastre-se!</h3>
				<br /><br />
				
				<!-- br /><br /-->
					<p><%//=loginForm.getNomeForm() %>
						<div id="resposta"  >${mensagem}</div> 		
						<div id="msg"></div>						
					</p>				
					<div class="grid-container">
					 <div class="row">
			           <div class="col-4  col-s-4"> 
			              <a href="#" onclick="javascript:load('form','Loja','loadForm');" >
		  						 <img src="images/mm_product_sm.gif" alt="small product photo" width="110" height="110" border="0" />
		  						<br />
		  						 	Loja	 				   		    						  
		   		    			<br />	
		   		    			   			
	 						</a>
	 					</div>
			           <div  class="col-4  col-s-4"> 
			              <a href="#" onclick="javascript:load('form','Oficina','loadForm');">
		  						 <img src="images/mm_product_sm.gif" alt="small product photo" width="110" height="110" border="0" />
		  						<br />
		  						 	Oficina	 				   		    						  
		   		    			<br />	
		   		    			   		
	 						</a>
	 					</div>
			           <div class="col-4  col-s-4" > 
			              <a href="#" onclick="javascript:load('form','Usuario','loadForm');">
		  						 <img src="images/mm_product_sm.gif" alt="small product photo" width="110" height="110" border="0" />
		  						<br />
		  						 	Usuário				   		    						  
		   		    			<br />	
		   		    			   			
	 						</a>
	 					</div>	
	 				  </div>
	 				  <div class="row">
			           <div class="col-4  col-s-4"> 
			              <a href="#" onclick="javascript:load('form','Peca','loadForm');" >
		  						 <img src="images/mm_product_sm.gif" alt="small product photo" width="110" height="110" border="0" />
		  						<br />
		  						 	Peças	 				   		    						  
		   		    			<br />	
		   		    			   			
	 						</a>
	 					</div>
			           <div  class="col-4  col-s-4"> 
			              <a href="#" onclick="javascript:load('form','Produto','loadForm');">
		  						 <img src="images/mm_product_sm.gif" alt="small product photo" width="110" height="110" border="0" />
		  						<br />
		  						 	Produtos e Acessórios	 				   		    						  
		   		    			<br />	
		   		    			   		
	 						</a>
	 					</div>
			           <div class="col-4  col-s-4" > 
			              <a href="#" onclick="javascript:load('form','Servico','loadForm');">
		  						 <img src="images/mm_product_sm.gif" alt="small product photo" width="110" height="110" border="0" />
		  						<br />
		  						 	Serviços				   		    						  
		   		    			<br />	
		   		    			   			
	 						</a>
	 					</div>	
	 				  </div>	 							 											
					</div>
				</div>
		  </div>
		<div class="col-3 col-s-12">
			<!--espaco para anuncio -->
			<div class="aside">
				<h2>Promoções</h2>
				<p>As melhores ofertas estão aqui.</p>
				<h2></h2>
				<p>Não deixe de nos consultar</p>
				<h2></h2>
			 	<p></p>
			 </div>
		  </div>							
	  </div>
	</form>	  
</body>
<jsp:include page="../rodape.jsp" />