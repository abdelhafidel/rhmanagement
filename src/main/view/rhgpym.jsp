<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.upm.rh.entity.Salaire"%>
<%@page import="java.util.concurrent.TimeUnit"%>
<%@page import="java.time.Period"%>
<%@page import="com.upm.rh.entity.Absences"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.upm.rh.entity.user"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Admin Dashboard</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="/rh">
				<div class="sidebar-brand-text mx-3">RH</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link" href="/rh">
					<i class="fas fa-fw fa-tachometer-alt"></i> <span>Accueil</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Interface</div>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-cog"></i> <span>gestion des employes</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">gestion des employes:</h6>
						<a class="collapse-item" href="/rhgemp">Gestion des comptes</a> <a
							class="collapse-item" href="/rhgpym">Gestion des payments</a> <a
							class="collapse-item" href="/rhgbull">Gestion des bulletins</a> <a
							class="collapse-item" href="/rhgabs">Gestion des absences</a> <a
							class="collapse-item" href="/rhgcng">Gestion des conges</a> <a
							class="collapse-item" href="/rhgform">Demandes formations</a>
					</div>
				</div></li>


			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Addons</div>

			<!-- Nav Item - Pages Collapse Menu -->

			<!-- Nav Item - Tables -->
			<li class="nav-item"><a class="nav-link" href="/rhprofile">
					<i class="fas fa-fw fa-table"></i> <span>Profil</span>
			</a></li>

			<!-- Nav Item - Charts -->
			<li class="nav-item"><a class="nav-link" href="/ajForm"> <i
					class="fas fa-fw fa-chart-area"></i> <span>Ajouter formation</span></a>
			</li>



			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>




					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">


						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">${rh.getNomeEmploye() }
									${rh.getPrenomEmploye() }</span> <img
								class="img-profile rounded-circle" src="img/picProfile.png">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="/rhprofile"> <i
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="/logout" data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div></li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">gestion employes</h1>

					</div>




					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Ajouter
								Paiement</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" width="100%"
									cellspacing="0">
									<thead class="thead-dark">
										<tr>
											<th>Employe</th>
											<th>Date</th>
											<th>SALAIRE de BASE</th>
											<th>gestion</th>
										</tr>
									</thead>
									<tbody>

										<tr>
											<form action="/savePaiement">
												<%
													List<user> users = (List<user>) request.getAttribute("users");
												%>
											
											<td><select class="form-control"
												aria-describedby="emailHelp" id="monselect" name="idemp">
													<%
														for (user u : users) {
															if(u.getSalaire()==null){
													%>
													<option value="<%=u.getId()%>"><%=u.getNomeEmploye() + " " + u.getCinEmploye()%></option>
													<%
															}}
													%>
											</select></td>
											<td><input type="date" name="dateSalaire" required="required"></td>
											<td><input type="text" name="salaireBase" required="required"></td>
											<td><button type="submit" class="btn btn-primary">Ajouter</button></td>
											</form>
										</tr>


									</tbody>
								</table>
							</div>
						</div>
					</div>






					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Gestion
								Paiement</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead class="thead-dark">
										<tr>
											<th>Employe</th>
											<th>Date</th>
											<th>Houre reg.</th>
											<th>Houre sup.</th>
											<th>Non justifié</th>
											<th>SALAIRE de BASE</th>
											<th>Paie total</th>
											<th>gestion</th>
										</tr>
									</thead>
									<tbody>
										<%
										List<Salaire> salaires = (List<Salaire>) request.getAttribute("salaires");
											for (Salaire s : salaires) {
											if (s.getUser().getBulletin() != null) {
												SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
												Date d = s.getDateSalaire();
												String dateSalaire = sdf.format(d);
												
												int HR = s.getUser().getBulletin().getNbHeurs();
												int HB = s.getUser().getBulletin().getNbHeursBenus();
												double P = s.getUser().getBulletin().getPrime();
												double Sal=s.getSalaireBase();
										%>
										<tr>

											<td><%=s.getUser().getNomeEmploye() + " " + s.getUser().getCinEmploye()%></td>
											
											<td><%=dateSalaire %></td>
											<td><%=HR%></td>
											<td><%=HB%></td>
											<td>
												<%
													List<Absences> abs = s.getUser().getAbsences();
												long NonJS = 0;
												for (Absences a : abs) {

													long diffInMillies = Math.abs(a.getDureeAbsence().getTime() - a.getDateAbsence().getTime());
													long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
													long NonJ = diff * 8;
													NonJS = NonJS + NonJ;
												}
												out.print(NonJS);
												double SB = Sal / 160 * (HR - NonJS);
												double PT = SB + (P * HB);
												%>

											</td>
											<td class="bg-success" style="color: white;"><%=SB + " DH"%></td>
											<td class="bg-primary" style="color: white;"><%=PT + " DH"%></td>
											<td><span style="" class="dropdown mb-4">
													<button class="btn btn-primary dropdown-toggle"
														type="button" id="dropdownMenuButton"
														data-toggle="dropdown" aria-haspopup="true"
														aria-expanded="false">Changer</button> <span
													class="dropdown-menu animated--fade-in"
													aria-labelledby="dropdownMenuButton"
													x-placement="bottom-start"
													style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(0px, 38px, 0px);">
														<a class="dropdown-item" href="/delSal?id=<%=s.getIdSalaire()%>">Delete</a>
												</span>
											</span></td>
										</tr>
										<%
											}
										}
										%>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!-- Content Row -->
				<div class="row">

					<!-- Content Column -->
					<div class="col-lg-6 mb-4">





						<div class="col-lg-6 mb-4">


							<!-- Approach -->


						</div>
					</div>

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2019</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">Ã—</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="/logout">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="vendor/chart.js/Chart.min.js"></script>
	<script src="vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/chart-area-demo.js"></script>
	<script src="js/demo/chart-pie-demo.js"></script>
	<script src="js/demo/datatables-demo.js"></script>

</body>

</html>
