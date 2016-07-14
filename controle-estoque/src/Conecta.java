import org.hibernate.Session;

import com.astoria.sistema.estoque.HibernateUtil;

public class Conecta {
	public static void main(String[] args) {
		
		Session session = null;
		System.out.println("Veja o git no Eclipse com EGit. Está mudança foi feita a partir do github");
		System.out.println("Bem vindo ao git!!!!");
		
		try {
			session = HibernateUtil.getSession().openSession();
			System.out.println("Conectou!");
		} finally {
			session.close();
			System.out.println("Fechou conexão!");
		}
	}
}
