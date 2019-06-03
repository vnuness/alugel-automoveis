<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
        <meta name="author" content="Coderthemes">
        <%@ page contentType="text/html; charset=UTF-8" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <jsp:include page="imports.jsp"/>


    </head>


    <body class="fixed-left">

        <!-- Begin page -->
        <div id="wrapper">

            <!-- Top Bar Start -->
            <jsp:include page="navbar.jsp" />
            <!-- Top Bar End -->


            <!-- ========== Left Sidebar Start ========== -->

            <jsp:include page="left-menu.jsp"/>
            <!-- Left Sidebar End -->




            <!-- ============================================================== -->
            <!-- Start right Content here -->
            <!-- ============================================================== -->                      
            <div class="content-page">
                <!-- Start content -->
                <div class="content">
                    <div class="container-fluid">

                        <!-- Page-Title -->
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="page-title-box">
                                    <h4 class="page-title">Bem-Vindo ${sessionScope.nome}!!</h4>
                                    <ol class="breadcrumb float-right">
                                        <li class="breadcrumb-item"><a href="#">Minton</a></li>
                                        <li class="breadcrumb-item active">Dashboard</li>
                                    </ol>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div id="bar" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-4">
                                <div class="card-box">
                                    <div id="pie" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
                                </div>
                            </div>
                            <div class="col-lg-8">
                                <div class="card-box">
                                    <h4 class="header-title m-t-0">Últimas Locações</h4>
                                    <p class="text-muted m-b-25 font-13">
                                        Top 5 das Útimas locações realizadas
                                    </p>

                                    <div class="table-responsive">
                                        <table class="table mb-0" id="ultimas-locacoes">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Nome do Cliente</th>
                                                    <th>Data início</th>
                                                    <th>Data Devolução</th>
                                                    <th>Avaliação</th>
                                                </tr>
                                            </thead>

                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">

                            <!-- end col -8 -->


                        </div>
                        <!-- end row -->


                    </div>
                    <!-- end container -->
                </div>
                <!-- end content -->

                <jsp:include page="footer.jsp"/>

            </div>
            <!-- ============================================================== -->
            <!-- End Right content here -->
            <!-- ============================================================== -->


        </div>
        <!-- END wrapper -->



        <script>
            var resizefunc = [];</script>

        <!-- Plugins  -->
        <!--<script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/popper.min.js"></script>Popper for Bootstrap -->
        <!--<script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/detect.js"></script>
        <script src="assets/js/fastclick.js"></script>
        <script src="assets/js/jquery.slimscroll.js"></script>
        <script src="assets/js/jquery.blockUI.js"></script>
        <script src="assets/js/waves.js"></script>
        <script src="assets/js/wow.min.js"></script>
        <script src="assets/js/jquery.nicescroll.js"></script>
        <script src="assets/js/jquery.scrollTo.min.js"></script>
        <script src="plugins/switchery/switchery.min.js"></script>

        Counter Up  -->
        <!--<script src="plugins/waypoints/lib/jquery.waypoints.min.js"></script>-->
        <!--<script src="plugins/counterup/jquery.counterup.min.js"></script>-->

        <!-- circliful Chart -->
        <script src="../plugins/jquery-circliful/js/jquery.circliful.min.js"></script>
        <script src="../plugins/jquery-sparkline/jquery.sparkline.min.js"></script>

        <!-- skycons -->
        <script src="../plugins/skyicons/skycons.min.js" type="text/javascript"></script>

        <!-- Page js  -->
        <script src="../assets/pages/jquery.dashboard.js"></script>

        <!-- Custom main Js -->
        <script src="../assets/js/jquery.core.js"></script>
        <script src="../assets/js/jquery.app.js"></script>


        <script src="../scripts/dashboard-script.js"></script>
    </body>
</html>