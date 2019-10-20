<%@page import="java.util.*" %>
<%@page import="br.com.qi.form.*"%>
<jsp:include page="cabecalho.jsp" />
<head>
	
	<!-- CSS QUE ALTERNA ETRE A LIST E A GRID INICIO  -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<!-- CSS QUE ALTERNA ETRE A LIST E A GRID FIM -->
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0" ></meta>	
	<link href="css/index.css" rel="stylesheet" />
	<!--link href="css/mm_restaurant1.css" rel="stylesheet" /-->
	<link href="css/flex-div.css" rel="stylesheet" />	
	<script type="text/javascript" src="js/java-script.js"></script>
	<%  
	   List<Form> lista =  (List<Form>) request.getSession().getAttribute("lista");		
	   LoginForm loginForm = (LoginForm) request.getSession().getAttribute("form");
	%>

</head>
<body onload="javascript:teste();" > <!--   javascript:loadIdLista('lista','<%/*=list*/ %>');-->
<form id="form"> 
		
		<input type='hidden' name='acao' id='acao' />
		<input type='hidden' name='metodo' id='metodo' />
		
	<div class="header">
		  		<h1>Qi Auto Peças</h1>  		
				<p> Sua melhor opção em peças automotivas </p>
												
		<!--nav id="menu-inferior" >
			<ul>
				<li id="Lojas" >
					<a href="#" onclick="javascript:loadLista('usuario','Loja','loadList');" > 
						Lojas		
					</a>													
				</li>
				<li id="Oficinas"  >
					<a href="#" onclick="javascript:loadLista('usuario','Oficina','loadList');"> 
						Oficinas
					</a>				
				</li>			
				<li id="Pecas" > 
					<a href="#" onclick="javascript:loadLista('usuario','Peca','loadList');" >
						Peças
					</a>
				</li>
				<li id="Produtos" > 
					<a href="#" onclick="javascript:loadLista('usuario','Produto','loadList');" >
						Produtos e Acessórios
					</a>
				</li>
				<li id="Servicos" > 
					<a href="#" onclick="javascript:loadLista('usuario','Servico','loadList');"  >
						Serviços
					</a>
				</li>									
			</ul>			
		</nav-->				
	</div>
	<div class="conteudo">

		<div class="col-3 col-s-3 menu">
					
			<ul>																	
				<li id="Lojas" onclick="javascript:load('form','Loja','loadList');" > 
					Lojas															
				</li>
				<li id="Oficinas"  onclick="javascript:load('form','Oficina','loadList');" > 
					Oficinas				
				</li>			
				<li id="Pecas" onclick="javascript:load('form','Peca','loadList');" > 
					Peças
				</li>
				<li id="Produtos" onclick="javascript:load('form','Produto','loadList');" > 
					Produtos e Acessórios
				</li>
				<li id="Servicos" onclick="javascript:load('form','Servico','loadList');" > 
					Serviços
				</li>		
				<li id="voltar" onclick="javascript:load('form','Loja','index');"  >
					Sair
				</li>												
			</ul>
		</div>
	
		<div class="col-6 col-s-9">
			<div class="w3-content w3-display-container">
			
					<p><%//=loginForm.getNomeForm() %> 
						${loginForm.nome}
					</p>
					
	       			<p>As melhores ofertas estão aqui.</p>	       			
					<br>
			        	 <%if(lista!=null)
			        	 for(Form frm:lista ){ %>
								<div class="conteudo-form linha" >						   		  						  
									  <span class="coluna-25" >
										<img src="images/mm_product_sm.gif" alt="small product photo" width="110" height="110" border="0" />
									  </span>
									  <section class="coluna-75" >
										   	${frm.nome} <br />
											${frm.getDescricaoForm} 								
									  </section>
								</div>
								<br />
					    	<%}%>    
					   </div>    								 				    	
	    		</div> 		   
			</div>
	
		<div class="col-3 col-s-12">
			<!--espaco para anuncio -->
			
		</div>
	 </div>
  </form>
</body>
<jsp:include page="rodape.jsp" />