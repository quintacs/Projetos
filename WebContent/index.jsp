<jsp:include page="cabecalho.jsp" />
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" ></meta>	
	<link href="css/index.css" rel="stylesheet" />
	<script type="text/javascript" src="js/java-script.js"></script>
	<script type="text/javascript" src="js/fontes-jquery.js"></script>	
</head>
<body onload="javascript:loadNodes('lista'); showDivs(1);" >
<form id="form"> 
		<input type='hidden' name='acao'   id='acao' />
		<input type='hidden' name='metodo' id='metodo' />
		
		 <div class="header">
		  		<h1>Qi Auto Peças</h1>  		
				<p> Sua melhor opção em peças automotivas </p>
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
			</ul>
		</div>
	
		<div class="col-6 col-s-9">
			<!--texto central 
			<h1>The City</h1>
			<p>Chania is the capital of the Chania region on the island of Crete. The city can be divided in two parts, the old town and the modern city.</p>
	        -->
			<div class="w3-content w3-display-container">
				<img class="mySlides" src="images/banner/banner1.jpg" style="width:100%">
				<img class="mySlides" src="images/banner/banner2.jpg" style="width:100%">
				<img class="mySlides" src="images/banner/banner3.jpg" style="width:100%">
				<img class="mySlides" src="images/banner/banner3.jpg" style="width:100%">
				
				<!--<button class="w3-button w3-black w3-display-left" onclick="plusDivs(-1)"  >&#10094;</button>
				<button class="w3-button w3-black w3-display-right" onclick="plusDivs(1)"  >&#10095;</button>	-->		
			</div>		
		</div>
	
		<div class="col-3 col-s-12">
			<!--espaco para anuncio -->
			<div class="aside">
				<h2>Promoções</h2>
				<p>As melhores ofertas estão aqui.</p>
				<h2>Preços exclusivos</h2>
				<p>Aqui você encontra o melhor custo beneficio</p>
				<h2>Lojas e Oficinas</h2>
				<p>Encontre com um click a loja ou oficina próximo a sua localização</p>
			</div>
		</div>
	
	 </div>
</form>
</body>
<jsp:include page="rodape.jsp" />