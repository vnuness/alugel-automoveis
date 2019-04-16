<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
        <meta name="author" content="Coderthemes">
        <%@ page contentType="text/html; charset=UTF-8" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="shortcut icon" href="assets/images/favicon.ico">

        <title>Locadora de Automóveis</title>

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
                                    <h4 class="page-title">Bem-Vindo !</h4>
                                    <ol class="breadcrumb float-right">
                                        <li class="breadcrumb-item"><a href="#">Entrada</a></li>
                                        <li class="breadcrumb-item active">Devolutiva</li>
                                    </ol>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>

                        <div class="portlet">
                            <div class="portlet-heading bg-inverse">
                                <h3 class="portlet-title">
                                    <i class="ion-search"></i> PESQUISAR CLIENTE
                                </h3>

                                <div class="clearfix"></div>
                            </div>
                            <div id="bg-inverse" class="panel-collapse collapse show">
                                <div class="portlet-body">
                                    <div class="table-responsive mt-3">
                                        <table id="tbl_veiculos" class="table table-bordered" style="width:100%;">
                                            <form class="form-horizontal" id="cad-veiculos" role="form" action="" type="POST">

                                                <div class="form-group row col-md-3">
                                                    <label class="col-form-label">CPF :</label>
                                                    <input type="CPF/CNPJ" class="form-control" id="exampleInputPassword1" placeholder="Exp: 111222333-00">
                                                </div>
                                                <div class="form-group col-md-3">
                                                    <label class="col-form-label">Avaliação:</label>
                                                    <select name="Avaliação"class="form-group col-md-5">
                                                        <option value="" selected>Opinião </option>
                                                        <option value="M">Muito Satisfeito </option>
                                                        <option value="F">Satisfeito</option>
                                                        <option value="F">Insatisfeito</option>
                                                    </select>
                                                </div>

                                                <div class="row" >
                                                    <label class="col-md-3 col-form-label"> Tipo de devolutiva: <span class="required">*</span></label>

                                                    <div class="col-md-3 form-group row col-form-label">
                                                        <div class="col-12">
                                                            <div class="radio radio-primary">
                                                                <input name="categoria_devolutiva" id="radio-pessoa-fisica" checked="checked" value="1" type="radio">
                                                                <label for="radio-normal">
                                                                    Sem Avarias
                                                                </label>
                                                            </div>

                                                        </div>
                                                    </div>
                                                    <div class="col-md-3 form-group row col-form-label">
                                                        <div class="col-12">
                                                            <div class="radio radio-primary">
                                                                <input name="categoria_devolutiva" id="radio-pessoa-juridica" value="2" type="radio">
                                                                <label for="radio-manutencao">
                                                                    Com Avarias
                                                                </label>
                                                            </div>

                                                        </div>
                                                    </div>
                                                    <div class="col-md-3 form-group row col-form-label">
                                                        <div class="col-12">
                                                            <div class="radio radio-primary">
                                                                <input name="categoria_devolutiva" id="radio-motorista-app" value="3" type="radio">
                                                                <label for="radio-limpeza">
                                                                    Limpeza
                                                                </label>
                                                            </div>

                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="input-daterange input-group col-md-12">
                                                    <label class="col-md-3 col-form-label"> Observações: <span class="required">*</span></label>
                                                    <textarea  id="acessorios" placeholder="Ex: Entrega normal, ocorrência de batida, necessidade de limpeza, etc" class="form-control" rows="4" cols="20"></textarea>
                                                </div>

                                                <button type="submit" class="btn btn-primary">Submit</button>
                                            </form> 
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>






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
            var resizefunc = [];

            $(document).ready(function () {
           
                $('input[name=categoria_devolutiva]').click(function () {
                    var value = $(this).val();

//                    if (value == 1 || value == 3) {
//                        $("#cadastro-pessoa-juridica").hide();
//                        $("#cadastro-pessoa-fisica").show();
//                    } else if (value == 2) {
//                        $("#cadastro-pessoa-fisica").hide();
//                        $("#cadastro-pessoa-juridica").show();
//                    }
                });
            });
        </script>

        <!-- Plugins  -->

    </body>
</html>