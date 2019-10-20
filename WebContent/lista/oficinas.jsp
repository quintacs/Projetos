<%@page import="java.util.*" %>
<%@page import="br.com.qi.form.*"%>
<jsp:include page="../cabecalho.jsp" />
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" ></meta>	
	<link href="css/index.css" rel="stylesheet" />
	<script type="text/javascript" src="js/java-script.js"></script>	
</head>
<body>
<form id="form">
		<%  List<OficinaForm> oficinas =  (List<OficinaForm>) request.getAttribute("lista");
		    LoginForm loginForm = (LoginForm) request.getSession().getAttribute("usuario");
		%>   	
  <input type='hidden' name='acao' id='acao' />
  <input type='hidden' name='metodo' id='metodo' />
		
  <div class="header">
	 <h1>Qi Auto Peças</h1>  		
	 <p> Sua melhor opção em peças automotivas </p>
  </div>
  <div class="conteudo">
		<div class="col-3 col-s-3 menu">
			<ul>
				<li id="novo" onclick="javascript:load('form','Oficina','loadForm');" >
					Novo
				</li>
				<li id="voltar" onclick="javascript:load('form','Oficina','index');" >
					Voltar
				</li>				
			</ul>
		</div>
		<div class="col-6 col-s-9">
			<div class="w3-content w3-display-container">
				
				<h1>Oficinas</h1>
				
				<p><%//=loginForm.getNomeForm() %>
					${loginForm.nome}
				</p>
								
				<%for(OficinaForm oficina:oficinas) {%>
						<div class="conteudo-form" > 	
							<span class="coluna-25" >Imagem</span>
							<section class="coluna-75" >
							      ${oficina.nome} - ${oficina.telefone}<br />
							      ${oficina.email} - ${oficina.endereco}
								<%//= oficina.getNome()%>  <%//= oficina.getTelefone()%>
								<%//= oficina.getEmail()%>  <%//= oficina.getEndereco()%> 				
							 </section>   
						</div>
						<br />						
				<%} %>		
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