<%@page import="java.util.*" %>
<%@page import="br.com.qi.form.*"%>
<jsp:include page="cabecalho.jsp" />
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" ></meta>	
	<!-- link href="css/index.css" rel="stylesheet" /-->
	<!-- link href="css/mm_restaurant1.css" rel="stylesheet" /-->
	<!-- link href="css/table.css" rel="stylesheet" / -->
	<!-- script type="text/javascript" src="js/java-script.js"></script-->
	<%  
	   List<Form> lista =  (List<Form>) request.getAttribute("lista");		
	%>
<style type="text/css">

table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

tr:hover {background-color:#f5f5f5;}

.celula a:hover{
	box-shadow: 10px 10px 10px 10px grey;
	}
	
body {
	margin:0px;
	}

td {
	font:11px arial;
	color:#333333;
	}
	
a {
	color: #400040;
	text-decoration:none;
	font-weight:bold;
	}
	
a:hover {
	color: #400040;
	text-decoration:underline;
	}
	
/* ID Styles */

#navigation a {
	font:10px arial;
	color: #ffffff;
	text-decoration:none;
	letter-spacing:.1em;
	}
	
#navigation a:hover {
	color: #99CCFF;
	}

#padding {
	padding:20px 5px 20px 5px;
	}
	
#calendar td {
	border: 1px solid rgb(0,51,153);
	}
	
#noborder td {
	border: 0px;
	}
	
#weekdays th {
	font:11px arial;
	color: #ffffff;
	font-weight:bold;
	border: 0px;
	padding:2px;
	}

#calheader td {
	font-weight:bold;
	}

/* Class Styles */

.logo {
	font:18px times new roman;
	color: #0E177C;
	letter-spacing:.3em;
	font-weight:bold;
	line-height:22px;
	}

.tagline {
	font:11px times new roman;
	color: #CC3300;
	letter-spacing:.2em;
	}

.smallText {
	font:12px times new roman;
	color: #CC3300;
	line-height:18px;
	}

.pageHeader {
	font:30px times new roman;
	color: #CC3300;
	letter-spacing:.1em;
	line-height:38px;
	}
	
.bodyText {
	font:11px arial;
	color:#333333;
	line-height:24px;
	}
	
.pageName {
	font:20px georgia;
	color: #CC3300;
	letter-spacing:.1em;
	line-height:26px;
	}
	
.subHeader {
	font:14px times new roman;
	color: #003399;
	font-weight:bold;
	line-height:20px;
	letter-spacing:.1em;
	}
	
.navText {
	font:10px arial;
	color: #333300;
	letter-spacing:.1em;
	}

* {
    box-sizing: border-box;
}
.conteudo::after {
    content: "";
    clear: both;
    display: table;
}
[class*="col-"] {
    float: left;
    padding: 15px;
}
html {
    font-family: "Lucida Sans", sans-serif;
}
.header {
    background-color: #9933cc;
    color: #ffffff;
    padding: 15px;
}
.menu ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
}
.menu li {
    padding: 8px;
    margin-bottom: 7px;
    background-color: #33b5e5;
    color: #ffffff;
    box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
}
.menu li:hover {
    background-color: #0099cc;
}

.aside {
		background-color: #33b5e5;
		padding: 15px;
		color: #ffffff;
		text-align: center;
		font-size: 14px;
		box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
	}
.footer {
    background-color: #0099cc;
    color: #ffffff;
    text-align: center;
    font-size: 12px;
    padding: 15px;
}

/* menu-superior */
nav#menu-superior li{
	display:inline;
	list-style-type:none;
	background-color:#9933cc;	
	color: #ffffff;
	/*text-transform:uppercase;*/
	padding:10;
	margin:5;				
	float: right;	
}

nav#menu-superior a:hover{
	/*background-color:#0000CD;*/
	color: #ffffff;
	text-transform:uppercase;
	text-decoration:underline;
	font-weight:bold;
	}


nav#menu-superior a{
	color: #ffffff;
	text-decoration: none;
	}
	
/* menu-inferior */
nav#menu-inferior li{
	display:inline;
	list-style-type:none;
	background-color:#9933cc;	
	color: #ffffff;
	/*text-transform:uppercase;*/
	padding:10;
	margin:5;				
	align-items:center;
	float: inherit;	
}

nav#menu-inferior a:hover{
	/*background-color:#0000CD;*/
	color: #ffffff;
	text-transform:uppercase;
	text-decoration:underline;
	font-weight:bold;
	}

nav#menu-inferior a{
	color: #ffffff;
	text-decoration: none;
	}	
		
/* For mobile phones: */
[class*="col-"] {
    width: 100%;
}
@media only screen and (min-width: 600px) {
    /* For tablets: */
       
    
    .col-s-1 {width: 8.33%;}
    .col-s-2 {width: 16.66%;}
    .col-s-3 {width: 25%;}
    .col-s-4 {width: 33.33%;}
    .col-s-5 {width: 41.66%;}
    .col-s-6 {width: 50%;}
    .col-s-7 {width: 58.33%;}
    .col-s-8 {width: 66.66%;}
    .col-s-9 {width: 75%;}
    .col-s-10 {width: 83.33%;}
    .col-s-11 {width: 91.66%;}
    .col-s-12 {width: 100%;}
}
@media only screen and (min-width: 768px) {
    /* For desktop: */
        
    
    .col-1 {width: 8.33%;}
    .col-2 {width: 16.66%;}
    .col-3 {width: 25%;}
    .col-4 {width: 33.33%;}
    .col-5 {width: 41.66%;}
    .col-6 {width: 50%;}
    .col-7 {width: 58.33%;}
    .col-8 {width: 66.66%;}
    .col-9 {width: 75%;}
    .col-10 {width: 83.33%;}
    .col-11 {width: 91.66%;}
    .col-12 {width: 100%;}
}

</style>
<script type="text/javascript">



function showHideNodes(parentId)
{
	/* Exibe ou oculta um atributo com o id passado */
	
	/*alert('id '+parentId);*/
	
  var display = document.getElementById(parentId).style.display;
  
  if (display == "none")
    document.getElementById(parentId).style.display = 'block';
  else
    document.getElementById(parentId).style.display = 'none';

}

function loadNodes(parentId)
{   
	/* Exibe ou oculta uma lista de atributos com o id passado */

	var i = 1;
	var id = parentId + "_" + i;
	var node = document.getElementById(id);
	
	/*alert('id '+parentId);*/
	
	while(node!=null)
	{
		/*alert('id '+id);*/
		
		if(node.style.display=="none")
			node.style.display="block";
		else  
			node.style.display="none";

		i++;
		id = parentId + "_" + i;
		node = document.getElementById(id);
	}
	
}

/* *********************************************************
	Alterna as imagens que estão com a classe "mySlides"
  *********************************************************
*/
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  
  if (n > x.length) {
	  slideIndex = 1;
	  n = 1;
	}    
  if (n < 1) {
	  slideIndex = x.length;
	}
	  
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";  
   }
  x[slideIndex-1].style.display = "block";  
	
  setTimeout(function(){ plusDivs(n); }, 5000);	
  
}

function load(formulario,classe,metodo){
	
	var frm;
	
	//alert("load ");
	
	frm = document.getElementById(formulario);
	frm.acao.value = classe;
	frm.metodo.value = metodo;	
	frm.action = 'controler';
	frm.method = "post";
	
	
	/*alert("formulario: "+formulario+"\n"+		  
		  "metodo: "+frm.metodo.value+"\n"+
		  "acao: "+frm.acao.value+"\n"+
		  "action: "+frm.action+"\n"
			);*/
	frm.submit();
	/*frm.submit();*/

}

function usuario(formulario,classe,metodo){
	
	var frm;
	
	frm = document.getElementById(formulario);
	frm.acao.value = classe;
	frm.metodo.value = metodo;	
	frm.action = 'usuario';
	frm.method = "post";
	
	frm.submit();
}

function loadLista(formulario,classe,metodo,tipo){
	
	var frm;
	
	frm = document.getElementById(formulario);
	frm.acao.value = classe;
	frm.metodo.value = metodo;
	frm.tipoLista.value = tipo; 
	frm.action = 'controler';
	frm.method = "post";
	
	
/*	alert("formulario: "+formulario+"\n"+		  
		  "metodo: "+frm.metodo.value+"\n"+
		  "tipoLista: "+frm.tipoLista.value+"\n"+
		  "acao: "+frm.acao.value+"\n"+
		  "action: "+frm.action+"\n"
			);*/
	frm.submit();
	/*frm.submit();*/
}


function loadPagina(formulario,classe,metodo,pagina){
	
	var frm;
	
	frm = document.getElementById(formulario);
	frm.acao.value = classe;
	frm.metodo.value = metodo;
	frm.pagina.value = pagina;
	frm.action = 'controler';
	frm.method = "post";
	
	
	/*alert("formulario: "+formulario+"\n"+		  
		  "metodo: "+frm.metodo.value+"\n"+
		  "acao: "+frm.acao.value+"\n"+
		  "action: "+frm.action+"\n"
			);*/
	frm.submit();	
	
}



</script>

</head>
<body onload="javascript:teste();" > <!--   javascript:loadIdLista('lista','<%/*=list*/ %>');-->
<form id="form"> 
		
		<input type='hidden' name='acao' id='acao' />
		<input type='hidden' name='metodo' id='metodo' />
		
	<div class="header">
		  		<h1>Qi Auto Peças</h1>  		
				<p> Sua melhor opção em peças automotivas </p>
		<nav id="menu-inferior" >
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
				<li id="Pecas" > <!--load('form','Peca');-->
					<a href="#" onclick="javascript:loadLista('usuario','Peca','loadList');" >
						Peças
					</a>
				</li>
				<li id="Produtos" > <!--load('form','Peca');-->
					<a href="#" onclick="javascript:loadLista('usuario','Produto','loadList');" >
						Produtos e Acessórios
					</a>
				</li>
				<li id="Servicos" > <!--load('form','Peca');-->
					<a href="#" onclick="javascript:loadLista('usuario','Servico','loadList');"  >
						Serviços
					</a>
				</li>									
			</ul>			
		</nav>				
	</div>
	<div class="conteudo">

		<div class="col-3 col-s-3 menu">
		
			<p>Espaço para anuncio.</p>
			<!-- ul>
				<li id="Lojas" onclick="javascript:load('form','Loja','loadList');" > 
					Lojas															
				</li>
				<li id="Oficinas"  onclick="javascript:load('form','Oficina','loadList');" > <!--onclick="javascript:showHideNodes('lista_2')" ->
					Oficinas				
				</li>			
				<li id="Pecas" onclick="javascript:load('form','Peca','loadList');" > <!--load('form','Peca');->
					Peças
				</li>
				<li id="Produtos" onclick="javascript:load('form','Produto','loadList');" > <!--load('form','Peca');->
					Produtos e Acessórios
				</li>
				<li id="Servicos" onclick="javascript:load('form','Servico','loadList');" > <!--load('form','Peca');->
					Serviços
				</li>									
			</ul-->
		</div>
	
		<div class="col-6 col-s-9">
			<div class="w3-content w3-display-container">
				<!--texto central 
				<h1>The City</h1>
				<p>Chania is the capital of the Chania region on the island of Crete. The city can be divided in two parts, the old town and the modern city.</p>
		        -->
		        <!--<h1>Lista mista de peças, lojas e oficinas</h1>-->
		
				<table border="0" cellspacing="0" cellpadding="2" width="610">
        			<tr>
	       				<td colspan="7" class="pageName">As melhores ofertas estão aqui.</td>
	       			</tr>
		        	 <%for(Form frm:lista){ %>
		        	      <tr>
		        	       	<%for(int i = 1; i< 5; i+=1 ){%>
		        	        	<!-- linha que contera as imagens  -->
		          				<td width="22%" height="110">
		          					<table>
		          						<tr>		          						
		          						    <td valign="top" class="bodyText" nowrap="nowrap" >
		          						      <div class="celula" >
		          						      	<a href="javascript:;">
		          						 	 		<img src="images/mm_product_sm.gif" alt="small product photo" width="110" height="110" border="0" />
		          						   			<!--/td>
	          							   			<td valign="top" class="bodyText" nowrap="nowrap" -->
	          							   			<br />		        		    					
		        		    						<%=frm.getNomeForm()%>		        		    				   
		        		    				   		<br />
				  									<%=frm.getDescricaoForm()%>
				  								</a>
				  							</div>	          							   
	          							  </td>
		          					    </tr>
		          					</table>
		          				</td>
		          				<!--td>&nbsp;</td -->
		          			<%}%>
		                </tr>
		        	    <tr>
		        		<%//for(int i = 1; i< 5; i+=1 ){%>
		        			<!-- linha que contera as informacoes  ->
		        			<td valign="top" class="bodyText" nowrap="nowrap">
		        		    	<a href="javascript:;">
		        		    		<%//=frm.getNomeForm()%>
		        		    	</a><br />
				  				<%//=frm.getDescricaoForm()%>
				  			 </td>
				  			<td>&nbsp;</td>
				  			<%//}%>
		        		 </tr>
		        		  <tr>
					    		<td colspan="7">&nbsp;</td -->
						</tr>
				    	<%}%>        				
				 </table>
			
		   		<!--div class="row" > 	
					<span class="coluna-25" >Data</span>
					<input type="text" name="data" id="data" class="coluna-75" >  
				</div -->		    	
	    	</div> 		   
		</div>
	
		<div class="col-3 col-s-12">
			<!--espaco para anuncio -->
			<!--p>Espaço para anuncio.</p>
			<div class="aside">				
				<h2>Promoções</h2>
				<p>As melhores ofertas estão aqui.</p>
				<h2>Preços exclusivos</h2>
				<p>Aqui você encontra o melhor custo beneficio</p>
				<h2>Lojas e Oficinas</h2>
				<p>Encontre com um click a loja ou oficina próximo a sua localização</p>
			</div-->
		</div>
	 </div>
  </form>
</body>
<jsp:include page="rodape.jsp" />