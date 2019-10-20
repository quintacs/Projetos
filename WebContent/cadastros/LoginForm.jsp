<jsp:include page="../cabecalho.jsp" />


	<head>
	<%  	  		
		//UsuarioForm usuarioForm = (UsuarioForm) request.getAttribute("form");
		//LoginForm loginForm = usuarioForm.getLoginForm();
		 String mensagem = (String)request.getAttribute("mensagem");
	%>		
		<meta name="viewport" content="width=device-width, initial-scale=1.0" ></meta>	
		<!-- link href="css/index.css" rel="stylesheet" /-->
		<link href="css/form.css" rel="stylesheet">
		<script type="text/javascript" src="js/java-script.js"></script>
		
	<script type="text/javascript">
		
			function ocultaResposta() {
        		document.getElementById('resposta').style.display = 'none';
    		}
			
            function validacaoEmail(field) {            
                if (field != "") {                
                    usuario = field.value.substring(0, field.value.indexOf("@"));
                    dominio = field.value.substring(field.value.indexOf("@") + 1, field.value.length);
                    if ((usuario.length >= 1) && (dominio.length >= 3) && (usuario.search("@") == -1) &&
                        (dominio.search("@") == -1) && (usuario.search(" ") == -1) && (dominio.search(" ") == -1) &&
                        (dominio.search(".") != -1) && (dominio.indexOf(".") >= 1) && (dominio.lastIndexOf(".") < dominio.length - 1)) {

                        //document.getElementById("msgemail").innerHTML = "E-mail válido";
                        //alert("E-mail valido");
                        document.getElementById("msg").innerHTML = "";
                        return true;
                    } else {
                    	                     
                    	document.getElementById("msg").innerHTML = "<font color='red'>E-mail inválido </font>";
                        //alert("E-mail invalido");                                        
                        return false;
                    } 
                }
            }
            
	</script>	
	</head>
	<body onload="setTimeout(ocultaResposta, 3000)">
	  <form id="form">			 	
	  <input type='hidden' name='acao' id='acao' />
	  <input type='hidden' name='metodo' id='metodo' />
			
	  <div class="header">
		 <h1>Qi Auto Peças </h1>  		
		 <p> Sua melhor opção em peças automotivas </p>
	  </div>
	    <div class="conteudo-form">
			<div class="col-3 col-s-3 menu">
			<ul>
				<li id="voltar" onclick="javascript:load('form','Login','index');"  >
					Voltar
				</li>				
			</ul>			
			</div>
			<div class="col-6 col-s-9">
				<div class="w3-content w3-display-container">
	  
							<h2>Login</h2>																																					

								<!--div class="row" > 	
									<span class="coluna-25" >Nome*</span>
									<input type="text" name="nome" id="nome" class="coluna-75" >  
								</div-->
							<p><%//=loginForm.getNomeForm() %>
								<div id="resposta"  >${mensagem}</div> 		
								<div id="msg"></div>						
							</p>								
								<div class="row" > 	
									<span class="coluna-25" >E-mail*</span>
									<input type="text" name="email" id="email" class="coluna-75" 
										onblur="validacaoEmail(this);">  
								</div>

								<div class="row" > 
									<span  class="coluna-25">Senha*</span>
									<input type="password" name="senha" id="senha" class="coluna-75" >
								</div>		
								<div class="row">																				
									<input type="submit" value="Enviar"  onclick="javascript:load('form','Login','form');">
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