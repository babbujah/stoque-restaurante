package com.astoria.sistema.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;

import com.astoria.sistema.estoque.HibernateUtil;

public class ConexaoHibernateFilter implements Filter {

	private SessionFactory sf;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletFilter, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		try {
			this.sf.getCurrentSession().beginTransaction();
			chain.doFilter(servletFilter, servletResponse);
			this.sf.getCurrentSession().getTransaction().commit();
			this.sf.getCurrentSession().close();
		} catch(Throwable e) {
			try {
				if(this.sf.getCurrentSession().getTransaction().isActive()) {
					this.sf.getCurrentSession().getTransaction().rollback();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void init(FilterConfig conf) throws ServletException {
		this.sf = HibernateUtil.getSession();
		
	}

}
