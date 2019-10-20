<%@page import="java.util.*" %>
<%@page import="br.com.qi.form.ProdutoForm"%>
<jsp:include page="../cabecalho.jsp" />

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" ></meta>	
	<link href="css/index.css" rel="stylesheet" />
	<script type="text/javascript" src="js/java-script.js"></script>	
</head>
<body>
 <form id="form">
		<%  List<ProdutoForm> produtos =  (List<ProdutoForm>) request.getAttribute("lista");%>   	
  <input type='hidden' name='acao' id='acao' />
  <input type='hidden' name='metodo' id='metodo' />
		
  <div class="header">
	 <h1>Qi Auto Pe�as</h1>  		
	 <p> Sua melhor op��o em pe�as automotivas </p>
  </div>
  <div class="conteudo">
		<div class="col-3 col-s-3 menu">
			<ul>
				<li id="novo" onclick="javascript:load('form','Produto','loadForm');" >
					Novo
				</li>
				<li id="voltar" onclick="javascript:load('form','Produto','index');" >
					Voltar
				</li>				
			</ul>
		</div>
		<div class="col-6 col-s-9">
			<div class="w3-content w3-display-container">
				<h1>Produtos e Acess�rios </h1>									
				<%for(ProdutoForm produto:produtos) {%>
						<div class="conteudo-form" > 	
							<span class="coluna-25" >Imagem</span>
							<section class="coluna-75" >
							   	<%= produto.getNome()%> - <%= produto.getMarca() %> <br />
								<%= produto.getDescricao()%>  								
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