/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author oem
 */
@WebFilter(filterName = "AutorizacaoFilter", servletNames = {"DashboardServlet"}, urlPatterns = {"/jsp/*"})
public class AutorizacaoFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        // CAST para objetos do tipo HttpServlet*
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        HttpSession session = httpRequest.getSession();
        if (session.getAttribute("nome") == null) {
            // Redirecionar para tela de login
            httpResponse.sendRedirect(httpRequest.getContextPath() + "");
            return;
        }
        
        int idCargo = Integer.parseInt(session.getAttribute("idCargo").toString());
        
        if (verificarAcesso(idCargo, httpRequest, httpResponse)) {
            // Requisicao pode seguir para o Servlet
            chain.doFilter(request, response);
        } else {
            request.getRequestDispatcher("/jsp/erro-nao-autorizado.jsp").forward(request, response);
        }
        
        
    }
    
    private boolean verificarAcesso(int idCargo,
            HttpServletRequest request,
            HttpServletResponse response) {
        String paginaAcessada = request.getRequestURI();
        System.out.print(idCargo);
        System.out.println(paginaAcessada);
        if (paginaAcessada.endsWith("/jsp/home")) {
            return true;
        }else if (idCargo == 2 && paginaAcessada.endsWith("/jsp/clientes")) {
            return true;
        } else if(idCargo == 2 && paginaAcessada.endsWith("/jsp/veiculos"))  {
            return true;
        } else if(idCargo == 2 && paginaAcessada.endsWith("/jsp/devolutivas")) {
            return true;
        } else if(idCargo == 2 && paginaAcessada.endsWith("/jsp/locacoes")) {
            return true;
        } else if(idCargo == 1 && paginaAcessada.endsWith("/jsp/veiculos")) {
            return true;
        } else if(idCargo == 1 && paginaAcessada.endsWith("/jsp/dashboard")) {
            return true;
        } else if(idCargo == 1 && paginaAcessada.endsWith("/jsp/clientes")) {
            return true;
        } else if(idCargo == 1 && paginaAcessada.endsWith("/jsp/devolutivas")) {
            return true;
        } else if(idCargo == 1 && paginaAcessada.endsWith("/jsp/locacoes")) {
            return true;
        } else if(idCargo == 1 && paginaAcessada.endsWith("/jsp/funcionarios")) {
            return true;
        } else if(idCargo == 1 && paginaAcessada.endsWith("/jsp/relatorios")) {
            return true;
        } else if(idCargo == 3 && paginaAcessada.endsWith("/jsp/dashboard")) {
            return true;
        } else if(idCargo == 3 && paginaAcessada.endsWith("/jsp/relatorios")) {
            return true;
        }

        return false;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void destroy() {        
    
    }
    
}
