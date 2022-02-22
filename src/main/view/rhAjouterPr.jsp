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

<title>Dashboard</title>

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

						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>

						<div class="topbar-divider d-none d-sm-block"></div>

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
						<h1 class="h3 mb-0 text-gray-800">Ajouter personne</h1>

					</div>
						<p style="color: red;">
								<%
									try {
									String msg = (String) request.getAttribute("msg");
									if (msg == null) {
										msg = "";
									}
									out.print(" " + msg);
								} catch (NullPointerException e) {
									out.print("");
								}
								%>
							</p>

					<!-- Content Row -->
					<form action="/rhsavepr" method="POST">
						<div class="form-group">
							<label for="exampleInputEmail1">nomeEmploye</label> <input
								class="form-control" aria-describedby="emailHelp"
								name="nomeEmploye" required="required">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">prenomEmploye</label> <input
								class="form-control" aria-describedby="emailHelp"
								name="prenomEmploye" required="required">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">diplomeEmploye</label> <input
								class="form-control" aria-describedby="emailHelp"
								name="diplomeEmploye" required="required">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">emailEMPLOYE</label> <input
								class="form-control" aria-describedby="emailHelp"
								name="emailEMPLOYE" required="required">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">ageEmploye</label> <input
								class="form-control" aria-describedby="emailHelp"
								name="ageEmploye" type="number" required="required">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">adressEmploye</label> <input
								class="form-control" aria-describedby="emailHelp"
								name="adressEmploye" required="required">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">telEmploye</label> <input
								class="form-control" aria-describedby="emailHelp"
								name="telEmploye" required="required">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">cinEmploye</label> <input
								class="form-control" aria-describedby="emailHelp"
								name="cinEmploye" required="required">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">username</label> <input
								class="form-control" aria-describedby="emailHelp"
								name="username" required="required">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">pwd</label> <input
								class="form-control" aria-describedby="emailHelp" type="password" name="pwd"
								required="required">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Post</label> <input
								class="form-control" aria-describedby="emailHelp" name="Post"
								required="required">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">ROLE</label> <select
								class="form-control" aria-describedby="emailHelp" id="monselect"
								name="role">
								<option value="USER">USER</option>
								<option value="ADMIN">ADMIN</option>
								<option value="RH">RH</option>
							</select>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>


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
						<h5 class="modal-title" id="exampleModalLabel">Ready to
							Leave?</h5>
					</div>
					<div class="modal-body">Select "Logout" below if you are
						ready to end your current session.</div>
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

		<!-- Page level custom scripts -->
		<script src="js/demo/chart-area-demo.js"></script>
		<script src="js/demo/chart-pie-demo.js"></script>
</body>

</html>
