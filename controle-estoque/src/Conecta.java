import org.hibernate.Session;

import com.astoria.sistema.estoque.HibernateUtil;

public class Conecta {
	public static void main(String[] args) {
		
		Session session = null;
		System.out.println("Veja o git no Eclipse com EGit");
		
		try {
			session = HibernateUtil.getSession().openSession();
			System.out.println("Conectou!");
		} finally {
			session.close();
			System.out.println("Fechou conexão!");
		}
	}
}
