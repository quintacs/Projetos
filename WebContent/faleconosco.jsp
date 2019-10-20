<jsp:include page="cabecalho.jsp" />
	<head>
		<title>Qi Auto Peças</title>
				
		<script type="text/javascript">
		
		   function validaForm(){
			   var valido = true; 
				if(document.getElementById("nome").value==""){
					alert("O campo nome é de preenchimento obrigatório.");
					valido = false;			
					return;
				}
				if(document.getElementById("email").value==""){
					alert("O campo email é de preenchimento obrigatório.");
					valido = false;
					return;
				}				
				if(document.getElementById("mensagem").value==""){					
					alert("O campo mensagem é de preenchimento obrigatório.");
					valido = false;
					return;
				}				
				
				if(valido){
					load('form','Fale','form');

					/*document.getElementById("resposta").innerHTML = "Sua mensagem foi enviada com sucesso. \n"+ 
					  												"Em breve entraremos em contato.";*/
					 alert("Sua mensagem foi enviada com sucesso. \n"+ 
					  "Em breve entraremos em contato."); 							
					//submit();
				}
		   }

		   function submit(){

			   //alert("teste 0");
			   
			   var nome = document.getElementById("nome");
			   var email = document.getElementById("email");
			   var mensagem = document.getElementById("mensagem");
			   var acao =  document.getElementById("acao"); //Fale
			   var metodo = document.getElementById("metodo"); //"add"				

			   acao.value =  "Fale"; 
			   metodo.value = "form"; 
			   
			   //alert("teste 1");
			   
			   alert(
					   "acao: "+acao.value+
					   "\n metodo: "+metodo.value+
					   "\n nome: "+nome.value+
					   "\n email: "+email.value+
					   "\n mensagem: "+mensagem.value 
					   );
			   			     
				// alert("teste 2");

				frm = document.getElementById("form");
				frm.acao.value = 'Fale';
				frm.metodo.value = 'form';
				frm.nome.value = nome.value;
				frm.email.value = email.value;
				frm.mensagem.value = mensagem.value;					
				frm.action = 'controler';
				frm.method = "post";
				
				
				/*alert("formulario: "+formulario+"\n"+		  
					  "metodo: "+frm.metodo.value+"\n"+
					  "acao: "+frm.acao.value+"\n"+
					  "action: "+frm.action+"\n"
						);*/
			   // frm.submit();				 				 
			   
		   }
	        		   	
		</script>
	</head>
	<body>
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
					
					<div id="resposta"></div>
					 																																	
					<div class="row" > 	
						<span class="coluna-25" >Nome *</span>
						<input type="text" name="nome" id="nome" class="coluna-75" >  
					</div>

					<div class="row" > 	
						<span class="coluna-25" >E-mail *</span>
						<input type="text" name="email" id="email" class="coluna-75" >  
					</div>				
					<div class="row" > 	
						<span class="coluna-25" >Mensagem *</span>
						<input type="text" name="email" id="email" class="coluna-75" >       
					</div>		
					<div class="row"> 																		
						<input type="submit" value="Enviar" onclick="javascript:validaForm();" > 						  
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
<jsp:include page="rodape.jsp" />
