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
	<script type="text/javascript">
    
		function Mudarestado(el) {     
    		var display = document.getElementById(el).style.display;
        	if (display == "none")
            	document.getElementById(el).style.display = 'block';
        	else
            	document.getElementById(el).style.display = 'none';
    	}    	
		
		function ocultaResposta() {
        	document.getElementById('resposta').style.display = 'none';
    	}
		
	       function Apenas_Numeros(caracter) {
	            var nTecla = 0;
	            if (document.all) {
	                nTecla = caracter.keyCode;
	            } else {
	                nTecla = caracter.which;
	            }
	            if ((nTecla > 47 && nTecla < 58)
	                    || nTecla == 8 || nTecla == 127
	                    || nTecla == 0 || nTecla == 9  // 0 == Tab
	                    || nTecla == 13) { // 13 == Enter
	                return true;
	            } else {
	                return false;
	            }
	        }    	
        function mascaraTelefone(obj) {
            //function mascaraTelefone(obj, prox) {
                
                switch (obj.value.length) {
                    case 1:
                        obj.value = "(" + obj.value;
                        break;
                    case 3:
                        obj.value = obj.value + ")";
                        break;
                    case 8:
                        obj.value = obj.value + "-";
                        break;
                    case 14:
                        //prox.focus();
                        break;
                }
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
            function mascaraCPF(cpf) {
                var evento = window.event;
                codigo = evento.keycode;
                if (codigo == 8) return;
                if (cpf.value.length == 3) { cpf.value = cpf.value + "."; }
                if (cpf.value.length == 7) { cpf.value = cpf.value + "."; }
                if (cpf.value.length == 11) { cpf.value = cpf.value + "-"; }
            }
            function mascaraCNPJ(cnpj) {
                var evento = window.event;
                codigo = evento.keycode;
                if (codigo == 8) return;
                if (cnpj.value.length == 2) { cnpj.value = cnpj.value + "."; }
                if (cnpj.value.length == 6) { cnpj.value = cnpj.value + "."; }
                if (cnpj.value.length == 10) { cnpj.value = cnpj.value + "/"; }
                if (cnpj.value.length == 15) { cnpj.value = cnpj.value + "-"; }
            }            
	</script>			
</head>
<body onload="setTimeout(ocultaResposta, 3000)">
<form id="form">
		<% // List<CadastroOficinaForm> oficinas =  (List<CadastroOficinaForm>) request.getAttribute("lista");%>   	
  <input type='hidden' name='acao' id='acao' />
  <input type='hidden' name='metodo' id='metodo' />
		
  <div class="header">
	 <h1>Qi Auto Peças - Oficina </h1>  		
	 <p> Sua melhor opção em peças automotivas </p>
  </div>
  <div class="conteudo-form">
		<div class="col-3 col-s-3 menu">
			<ul>
				<li id="voltar" onclick="javascript:load('form','Oficina','principal');"  >
					Voltar
				</li>				
			</ul>		
		</div>								
		 <div class="col-6 col-s-9">
			<div class="w3-content w3-display-container">
					
						<h2>Nova Oficina</h2>
									
							<p><%//=loginForm.getNomeForm() %>
								<div id="resposta"  >${mensagem}</div> 
								<div id="msg"></div>
							</p>
								<div class="row" > 	
									<span class="coluna-25" >Pessoa Juridica*</span>
									<input type="text" name="nome" id="nome" class="coluna-75" >  
								</div>

								<div class="row" > 	
									<span class="coluna-25" >Nome Fantasia*</span>
									<input type="text" name="nomeFantasia" id="nomeFantasia" class="coluna-75" >  
								</div>
								
								<div class="row" > 	
									<span class="coluna-25" >CNPJ*</span>
									<input type="text" name="CNPJ" id="CNPJ" class="coluna-75" 
									onKeyPress="return Apenas_Numeros(event);"  MaxLength="18"
									 onkeyup="mascaraCNPJ(this)">  
								</div>															
																
								<div class="row" > 	
									<span class="coluna-25" >Telefone*</span>
									<input type="text" name="telefone" id="telefone" class="coluna-75" 
											onKeyPress="return Apenas_Numeros(event);" MaxLength="13"	
											onkeyup="mascaraTelefone(this);" >  
								</div>																
								<div class="row" > 	
									<span class="coluna-25" >Celular*</span>
									<input type="text" name="celular" id="celular" class="coluna-75" 
										onKeyPress="return Apenas_Numeros(event);" MaxLength="14" 
										onkeyup="mascaraTelefone(this);"  >  
								</div>									
								<div class="row" > 	
									<span class="coluna-25" >Email*</span>
									<input type="text" name="email" id="email" class="coluna-75" 
									onblur="validacaoEmail(this);"  > 
								</div>
								<div class="row" > 	
									<span class="coluna-25" >Endereço*</span>
									<input type="text" name="endereco" id="endereco" class="coluna-75" > 
								</div>
								<!--								
								<div class="row" > 	
									<span class="coluna-25" >Logo</span>									
									 <input type="file" name="imagem" id="imagem"  class="coluna-75" >
								</div>
								-->
								<!--div class="row" > 
								  <span class="coluna-25" >Senha*</span>
									<input type="password" name="senha" id="senha" class="coluna-75" >
								</div-->
								
								<!--div class="row" > 
									<span class="coluna-25" >Confirmar Senha*</span>
									<input type="password" name="csenha" class="coluna-75" >
								</div -->			
									
								<div class="row"> 																		
									<input type="submit" value="Enviar" onclick="javascript:load('form','Oficina','form');" >  
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