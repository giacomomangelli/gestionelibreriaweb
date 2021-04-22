<!doctype html>
<%@page import="it.gestionelibreriaweb.model.Libro"%>
<%@page import="java.text.SimpleDateFormat"%>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Modifica Libro</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
	
	<% Libro libroEdit = (Libro) request.getAttribute("update_libro_attr"); %>
	
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Inserisci le modifiche dell'elemento</h5> 
		    </div>
		    <div class='card-body'>

					<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>

					<form method="post" action="ExecuteUpdateLibroServlet" novalidate="novalidate">
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Titolo <span class="text-danger">*</span></label>
								<input type="text" name="titoloEdit" id="titolo" class="form-control" value = "<%=  libroEdit.getTitolo() %>" placeholder="Inserire il titolo" required>
							</div>
							
							<div class="form-group col-md-6">
								<label>Genere <span class="text-danger">*</span></label>
								<input type="text" name="genereEdit" id="descrizione" class="form-control" value = "<%=  libroEdit.getGenere() %>" placeholder="Inserire la genere" required>
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label>Pagine <span class="text-danger">*</span></label>
								<input type="number" class="form-control" name="pagineEdit" id="pagine" value = "<%=  libroEdit.getPagine() %>" placeholder="Inserire le pagine" required>
							</div>
							<div class="form-group col-md-3">
								<label>Data di Pubblicazione<span class="text-danger">*</span></label>
                        		<input class="form-control" id="dataPubblicazione" type="date" placeholder="dd/MM/yy"  
                        		value = "<%=libroEdit.getDataDiPubblicazione()!=null? new SimpleDateFormat("yyyy-MM-dd").format(libroEdit.getDataDiPubblicazione()):""%>" 
                        		title="formato : gg/mm/aaaa"  name="dataPubblicazioneEdit" required>
							</div>
							
						</div>
						
						<input type = "hidden" name = "idLibroEdit" value = "<%= libroEdit.getId() %>">
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>

					</form>
		    
			<!-- end card-body -->			   
		    </div>
		</div>	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>