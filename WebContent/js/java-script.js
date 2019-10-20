        

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

