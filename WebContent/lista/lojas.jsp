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
		<%  
			List<LojaForm> lojas =  (List<LojaForm>) request.getSession().getAttribute("lista");
			LoginForm loginForm = (LoginForm) request.getSession().getAttribute("form");
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
				<li id="novo" onclick="javascript:load('form','Loja','loadForm');" >
					Novo
				</li>
				<li id="voltar" onclick="javascript:load('form','Loja','index');"  >
					Voltar
				</li>				
			</ul>
		</div>
		<div class="col-6 col-s-9">
			<div class="w3-content w3-display-container">
				<h1>Lojas</h1>		
				
				<p><%//=loginForm.getNomeForm() %>
					${loginForm.nome}
				</p>
				
				<%for(LojaForm loja:lojas) {%>
						<div class="conteudo-form" > 
						  <a href="#">	
							  <span class="coluna-25" >
								<img src="images/mm_product_sm.gif" alt="small product photo" width="110" height="110" border="0" />
							  </span>
							  <section class="coluna-75" >
								   	<%= loja.getNome()%> - <%= loja.getTelefone()%> <br />
									<%= loja.getEmail()%> -   <%= loja.getEndereco()%> 								
							  </section>
						   </a>   
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