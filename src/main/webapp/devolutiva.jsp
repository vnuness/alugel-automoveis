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

                        <div class="row">
                            <div class="col-sm-12">
                                <div class="portlet">
                                    <div class="portlet-heading bg-inverse">
                                        <h3 class="portlet-title">
                                            <i class="ion-search"></i> PESQUISAR CLIENTE
                                        </h3>

                                        <div class="clearfix"></div>
                                    </div>
                                    <div id="bg-inverse" class="panel-collapse collapse show">
                                        <div class="portlet-body">
                                                    <form class="form-horizontal" role="form" action="" type="POST">
                                                        <div class="form-group row col-md-3">
                                                            <label class="col-form-label">CPF :</label>
                                                            <input type="text" class="form-control" id="cpf_cnpj" placeholder="Exp: 111.111.111-11">
                                                        </div>
                                                        <div class="form-group row col-md-3">
                                                            <label class="col-form-label">Avaliação:</label>
                                                            <select name="avaliacao" id="avaliacao" class="form-group col-md-5">
                                                                <option value="" selected>Opinião </option>
                                                                <option value="1">Muito Satisfeito </option>
                                                                <option value="2">Satisfeito</option>
                                                                <option value="3">Insatisfeito</option>
                                                            </select>
                                                        </div>

                                                        <div class="row" >
                                                            <label class="col-md-3 col-form-label"> Tipo de devolutiva: <span class="required">*</span></label>

                                                            <div class="col-md-3 form-group row col-form-label">
                                                                <div class="col-12">
                                                                    <div class="radio radio-primary">
                                                                        <input name="categoria_devolutiva" id="sem-avarias" checked="checked" value="1" type="radio">
                                                                        <label for="sem-avarias">
                                                                            Sem Avarias
                                                                        </label>
                                                                    </div>

                                                                </div>
                                                            </div>
                                                            <div class="col-md-3 form-group row col-form-label">
                                                                <div class="col-12">
                                                                    <div class="radio radio-primary">
                                                                        <input name="categoria_devolutiva" id="com-avarias" value="2" type="radio">
                                                                        <label for="com-avarias">
                                                                            Com Avarias
                                                                        </label>
                                                                    </div>

                                                                </div>
                                                            </div>
                                                            <div class="col-md-3 form-group row col-form-label">
                                                                <div class="col-12">
                                                                    <div class="radio radio-primary">
                                                                        <input name="categoria_devolutiva" id="limpeza" value="3" type="radio">
                                                                        <label for="limpeza">
                                                                            Limpeza
                                                                        </label>
                                                                    </div>

                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="input-daterange input-group col-md-10">
                                                            <label class="row col-md-3 col-form-label">Observações: <span class="required">*</span></label>
                                                            <textarea placeholder="Ex: Entrega normal, ocorrência de batida, necessidade de limpeza, etc" class="form-control" rows="4" cols="6"></textarea>
                                                        </div>
                                                        <br>
                                                        <div class="form-group align-self-center">
                                                            <div class="row align-self-center ">
                                                                <div class="col-sm-6 align-self-center">
                                                                    <button type="button" class="btn btn-primary btn-lg btn-block" style="position: relative; left: 54%;">Enviar</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form> 
                                        </div>
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

                $('#avaliacao').select2();

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
            $('#cpf_cnpj').mask('000.000.000-00');
            
        </script>

        <!-- Plugins  -->

    </body>
</html>