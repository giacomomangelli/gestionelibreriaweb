<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.gestionelibreriaweb.model.Libro"%>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Inserisci nuovo libro</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
	
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Inserisci un nuovo libro</h5> 
		    </div>
		    <div class='card-body'>

					<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>

					<% Libro libroEdit = (Libro) request.getAttribute("insert_libro_attr"); %>
					

					<form method="post" action="ExecuteInsertLibroServlet" novalidate="novalidate">
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Titolo <span class="text-danger">*</span></label>
								<input type="text" name="titoloInsert" id="titolo" class="form-control" placeholder="Inserire il titolo" value = "<%=  libroEdit.getTitolo()!=null? libroEdit.getTitolo():""%>" required>
							</div>
							
							<div class="form-group col-md-6">
								<label>Genere <span class="text-danger">*</span></label>
								<input type="text" name="genereInsert" id="genere" class="form-control" placeholder="Inserire il genere" value = "<%=  libroEdit.getGenere()!=null? libroEdit.getGenere():"" %>" required>
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label>Pagine <span class="text-danger">*</span></label>
								<input type="number" class="form-control" name="pagineInsert" id="pagine" placeholder="Inserire numero pagine" value = "<%=  libroEdit.getPagine() %>"  required>
							</div>
							<div class="form-group col-md-4">
								<label>Data di Pubblicazione<span class="text-danger">*</span></label>
                        		<input class="form-control" id="dataPubblicazione" type="date" value = "<%=libroEdit.getDataDiPubblicazione()!=null? new SimpleDateFormat("yyyy-MM-dd").format(libroEdit.getDataDiPubblicazione()):""%>" 
                        			placeholder="dd/MM/yy"
                            		title="formato : gg/mm/aaaa"  name="dataPubblicazioneInsert" required>
							</div>
							
						</div>
							
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