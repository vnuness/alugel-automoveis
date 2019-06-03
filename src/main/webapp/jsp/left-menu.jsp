<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="left side-menu">
    <div class="sidebar-inner slimscrollleft">
        <!--- Divider -->
        <div id="sidebar-menu">
            <ul>
                <li class="menu-title">Home</li>

                <li>
                    <a href="home" class="waves-effect waves-primary"><i
                            class="ti-home"></i><span> Home </span></a>
                </li>
                <c:if test="${sessionScope.idCargo != 2 && sessionScope.idCargo != 4}">
                    <li class="menu-title">Dashboard</li>

                    <li>
                        <a href="dashboard" class="waves-effect waves-primary"><i
                                class="ti-stats-up"></i><span> Dashboard </span></a>
                    </li>

                    <li class="menu-title">Relatórios</li>

                    <li>

                    <li>
                        <a href="relatorios" class="waves-effect waves-primary"><i
                                class="ti-receipt"></i><span> Locações </span></a>
                    </li>

                </c:if>

                <c:if test="${sessionScope.idCargo == 4}">

                    <li class="menu-title">Credenciais</li>

                    <li>

                    <li>
                        <a href="funcionarios" class="waves-effect waves-primary"><i
                                class="mdi mdi-account-multiple"></i><span> Usuários </span></a>
                    </li>

                </c:if>

                <c:if test="${sessionScope.idCargo != 3}">

                    <li class="menu-title">Cliente</li>

                    <li>
                        <a href="clientes" class="waves-effect waves-primary"><i
                                class="ti-user"></i><span> Gerenciamento </span></a>
                    </li>

                    <li class="menu-title">Veículos</li>

                    <li>
                        <a href="veiculos" class="waves-effect waves-primary"><i
                                class="ti-car"></i><span> Gerenciamento </span></a>
                    </li>

                    <li class="menu-title">Aluguel</li>

                    <li>
                        <a href="locacoes" class="waves-effect waves-primary"><i
                                class="ti-money"></i><span>Realizar Locação</span></a>
                    </li>

                    <li>
                        <a href="devolutivas" class="waves-effect waves-primary"><i
                                class="ti-back-left"></i><span> Devolutivas </span></a>
                    </li>

                </c:if>

            </ul>

            <div class="clearfix"></div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
