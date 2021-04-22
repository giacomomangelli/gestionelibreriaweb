<%@page import="it.gestionelibreriaweb.model.Libro"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Pagina dei risultati</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
	
		<div class="alert alert-success alert-dismissible fade show ${successMessage==null?'d-none': ''}" role="alert">
		  ${successMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<!---------------------------------->
		<!-- ESEMPI DI ALERT DI BOOTSTRAP -->
		<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
		  Esempio di operazione fallita!
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
		  Aggiungere d-none nelle class per non far apparire
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<!--------   end  ------------------>
		<!---------------------------------->
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Lista dei Libri</h5> 
		    </div>
		    <div class='card-body'>
		    	<a class="btn btn-primary " href="PrepareInsertLibroServlet">Aggiungi Nuovo</a>
		    
		        <div class='table-responsive'>
		            <table class='table table-striped ' >
		                <thead>
		                    <tr>
		                        <th>Id</th>
		                        <th>Titolo</th>
		                        <th>Genere</th>
		                        <th>Pagine</th>
		                        <th>Data di Pubblicazione</th>
		                        <th>Azioni</th>
		                    </tr>
		                </thead>
		                <tbody>
		                	<% List<Libro> libri = (List<Libro>)request.getAttribute("listaLibriAttribute");
		                		for(Libro item : libri){ %>
		                    <tr >
		                        <td><%=item.getId() %></td>
		                        <td><%=item.getTitolo() %></td>
		                        <td><%=item.getGenere() %></td>
		                        <td><%=item.getPagine() %></td>
		                        <td><%=item.getDataDiPubblicazione()!=null? new SimpleDateFormat("dd/MM/yyyy").format(item.getDataDiPubblicazione()):"N.D."%></td>
		                        <td>
									<a class="btn  btn-sm btn-outline-secondary" href="ExecuteVisualizzaLibroServlet?idLibro=<%=item.getId() %>">Visualizza</a>
									<a class="btn  btn-sm btn-outline-primary ml-2 mr-2" href="PrepareUpdateLibroServlet?idLibro=<%=item.getId() %>">Edit</a>
									<a class="btn btn-outline-danger btn-sm" href="PrepareDeleteLibroServlet?idLibro=<%=item.getId() %>">Delete</a>
								</td>
		                    </tr>
		                    <% } %>
		                </tbody>
		            </table>
		        </div>
		   
			<!-- end card-body -->			   
		    </div>
		</div>	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>