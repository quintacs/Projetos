<%@page import="br.com.qi.form.*"%>
<jsp:include page="../cabecalho.jsp" />

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" ></meta>	
	<!--link href="css/index.css" rel="stylesheet"-->
	<link href="css/form.css" rel="stylesheet">	
	<script type="text/javascript" src="js/java-script.js"></script>
	
	<%  	  		
	   LoginForm loginForm = (LoginForm) request.getSession().getAttribute("form");
		String mensagem = (String)request.getAttribute("mensagem");
	%>
		
</head>
<body onload="setTimeout(ocultaResposta, 3000)">
<form id="form">
		<% // List<CadastroOficinaForm> oficinas =  (List<CadastroOficinaForm>) request.getAttribute("lista");%>   	
  <input type='hidden' name='acao' id='acao' />
  <input type='hidden' name='metodo' id='metodo' />
		
  <div class="header" >
	 <h1>Qi Auto Pe�as - Pe�a </h1>  		
	 <p> Sua melhor op��o em pe�as automotivas </p>
  </div>
  <div class="conteudo-form">
		<div class="col-3 col-s-3 menu">
			<ul>
				<li id="voltar" onClick="javascript:load('form','Peca','index');"  >
					Voltar
				</li>				
			</ul>		
		</div>								
		 <div class="col-6 col-s-9">
			<div class="w3-content w3-display-container">					
							
							<h2>Nova Pe�a</h2>	
							
							<p><%//=loginForm.getNomeForm() %>
								<div id="resposta"  >${mensagem}</div> 
								<div id="msg"></div>
							</p>
															
			  					<div class="row" > 	
									<span class="coluna-25" >Nome*</span>
									<input type="text" name="nome" id="nome" class="coluna-75" >  
								</div>				
								<div class="row" > 	
									<span class="coluna-25" >Modelo</span>
									<input type="text" name="modelo" id="modelo" class="coluna-75" >  
								</div>
								
								<div class="row" > 	
									<span class="coluna-25" >Ano</span>
									<input type="text" name="ano" id="ano" class="coluna-75" >  
								</div>								

								<div class="row" > 	
									<span class="coluna-25" >Cor</span>
									<input type="text" name="cor" id="cor" class="coluna-75" >  
								</div>								
																
								<div class="row" > 	
									<span class="coluna-25" >Marca</span>
									<input type="text" name="marca" id="marca" class="coluna-75" >  
								</div>
								
								<!-- <div class="row" > 	
									<span class="coluna-25" >Imagem</span>
									 <input type="file" name="imagem" id="imagem"  class="coluna-75" >
								</div> --> 
								<div class="row" >
									<span class="coluna-25" >																					
										<input type="submit" value="Enviar" onClick="javascript:load('form','Peca','form');" >
									</span>
								</div>
				</div>						
			</div>
		    <div class="col-3 col-s-12">
			    <!--espaco para anuncio -->
			    <div class="aside">
			    	<h2>Anuncie aqui</h2>
		    	</div>				
	    	</div>
	    </div>			
    </form>									 
</body>
<jsp:include page="../rodape.jsp" />

