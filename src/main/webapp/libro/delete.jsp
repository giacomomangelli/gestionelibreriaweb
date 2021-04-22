<!DOCTYPE html>
<%@page import="it.gestionelibreriaweb.model.Libro"%>
<%@page import="java.text.SimpleDateFormat"%>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Rimuovi elemento</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">

</head>

<body>
	<jsp:include page="../navbar.jsp" />
		
	<main role="main" class="container">
		
		<div class='card'>
		    <div class='card-header'>
		        Visualizza dettaglio
		    </div>
	    
		    <% Libro LibroInPagina = (Libro) request.getAttribute("delete_libro_attr"); %>
		
		    <div class='card-body'>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Titolo</dt>
				  <dd class="col-sm-9"><%=LibroInPagina.getTitolo() %></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Descrizione:</dt>
				  <dd class="col-sm-9"><%=LibroInPagina.getTitolo() %></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Pagine:</dt>
				  <dd class="col-sm-9"><%=LibroInPagina.getPagine() %></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Data di Pubblicazione:</dt>
				  <dd class="col-sm-9"><%=LibroInPagina.getDataDiPubblicazione()!=null? new SimpleDateFormat("dd/MM/yyyy").format(LibroInPagina.getDataDiPubblicazione()):"N.D."  %></dd>
		    	</dl>
		    	
		    </div>
		    <div class='card-footer'>
		    <form method="post" action="ExecuteDeleteLibroServlet" novalidate="novalidate">	
		        <a href="ListLibriServlet" class='btn btn-outline-secondary' style='width:80px'>
		            <i class='fa fa-chevron-left'></i> Back
		        </a>	
		        <input type = "hidden" name = "idLibro" value = "<%= LibroInPagina.getId() %>">
			    <button type="submit" name="submit" value="submit" id="submit" class="btn btn-outline-danger float-right">Delete
				</button>
		    </form>    

		    </div>
		    
			
		</div>	
		
		
	<!-- end main container -->	
	</main>
	<jsp:include page="../footer.jsp" />

</body>
</html>