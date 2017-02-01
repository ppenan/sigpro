package dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColaboradorDAOTest {
	
	@Test
	public void getColaboradorTest(){
		assertNotNull(ColaboradorDAO.getColaborador(1));
	}
	
	@Test
	public void guardarTest(){
		assertNotNull(ColaboradorDAO.guardar(1, "unit_test", "unit_test", "", "unit_Test", "unit_test", "unit_test", 0L, 1, "admin"));
	}
	
	@Test
	public void actualizarTest(){
		assertNotNull(ColaboradorDAO.actualizar(1, "unit_test", "unit_test", "", "unit_Test", "unit_test", "unit_test", 0L, 1, "admin"));
	}
	
	@Test
	public void getPaginaTest(){
		assertNotNull(ColaboradorDAO.getPagina(1, 1));
	}
	
	@Test
	public void getJsonTest(){
		assertEquals(ColaboradorDAO.getJson(1, 1).getClass(),String.class);
	}
	
	@Test
	public void getTotalTest(){
		assertEquals(ColaboradorDAO.getTotal().getClass(), Long.class);
	}
	
	@Test
	public void validarUsuarioTest(){
		assertNotNull(ColaboradorDAO.validarUsuario("admin"));
	}
}