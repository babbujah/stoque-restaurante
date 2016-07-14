import org.hibernate.Session;

import com.astoria.sistema.estoque.HibernateUtil;

public class Conecta {
	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSession().openSession();
			System.out.println("Conectou!");
		} finally {
			session.close();
			System.out.println("Fechou conex�o!");
		}
	}
}