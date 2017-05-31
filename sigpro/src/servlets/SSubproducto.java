package servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dao.ComponenteDAO;
import dao.ProductoDAO;
import dao.SubproductoDAO;
import dao.SubproductoPropiedadDAO;
import dao.SubproductoPropiedadValorDAO;
import dao.SubproductoUsuarioDAO;
import pojo.Producto;
import pojo.Subproducto;
import pojo.SubproductoPropiedad;
import pojo.SubproductoPropiedadValor;
import pojo.SubproductoPropiedadValorId;
import pojo.SubproductoTipo;
import pojo.SubproductoUsuario;
import pojo.SubproductoUsuarioId;
import pojo.UnidadEjecutora;
import utilities.Utils;

@WebServlet("/SSubproducto")
public class SSubproducto extends HttpServlet {
	
	private static final long serialVersionUID = 1457438583225714402L;
	String usuario ="";
	
	static class stsubproducto {
		Integer id;
		String nombre;
		String descripcion;
		Integer idProducto;
		String producto;
		Integer idSubproductoTipo;
		String subproductoTipo;
		Integer unidadEjectuora;
		String nombreUnidadEjecutora;
		Long snip;
		Integer programa;
		Integer subprograma;
		Integer proyecto_;
		Integer actividad;
		Integer obra;
		Integer fuente;
		Integer estado;
		String fechaCreacion;
		String usuarioCreo;
		String fechaactualizacion;
		String usuarioactualizo;
		String latitud;
		String longitud;
		
	}
	class stdatadinamico {
		String id;
		String tipo;
		String label;
		String valor;
		String valor_f;
	}

	public SSubproducto() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesionweb = request.getSession();
		usuario = sesionweb.getAttribute("usuario")!= null ? sesionweb.getAttribute("usuario").toString() : null;

		Map<String, String> parametro = Utils.getParams(request);

		if (parametro.get("accion").compareTo("cargar") == 0) {
			listar(parametro, response);
		} else if (parametro.get("accion").compareTo("guardar") == 0) {
			guardar(parametro, response,request);
		} else if (parametro.get("accion").compareTo("borrar") == 0) {
			eliminar(parametro, response);
		} else if (parametro.get("accion").compareTo("totalElementos") == 0) {
			total(parametro,response);
		} else if (parametro.get("accion").compareTo("listarTipos") == 0) {
			listarTipos(parametro, response);
		} else if (parametro.get("accion").compareTo("listarSubproductos") == 0) {
			listarSubproductos(parametro, response);
		} else if (parametro.get("accion").compareTo("listarComponentes") == 0) {
			listarComponentes(parametro, response);
		} else if (parametro.get("accion").compareTo("obtenerSubproductoPorId") == 0) {
			obtenerSubproductoPorId(parametro, response);
		}else if (parametro.get("accion").compareTo("getSubproductoPorId") == 0) {
			getSubproductoPorId(parametro, response);
		}else if (parametro.get("accion").compareTo("guardarModal") == 0){
			guardarModal(parametro, response,request);
		}
	}

	private void listar(Map<String, String> parametro, HttpServletResponse response) throws IOException {
		int productoid = Utils.String2Int(parametro.get("productoid"), 0);
		int pagina = Utils.String2Int(parametro.get("pagina"), 1);
		int registros = Utils.String2Int(parametro.get("registros"), 20);
		String filtro_nombre = parametro.get("filtro_nombre");
		String filtro_usuario_creo = parametro.get("filtro_usuario_creo");
		String filtro_fecha_creacion = parametro.get("filtro_fecha_creacion");
		String columna_ordenada = parametro.get("columna_ordenada");
		String orden_direccion = parametro.get("orden_direccion");

		String resultadoJson = "";

		resultadoJson = SubproductoDAO.getJson(pagina, registros,productoid,usuario,filtro_nombre,filtro_usuario_creo
				,filtro_fecha_creacion,columna_ordenada,orden_direccion);

		if (Utils.isNullOrEmpty(resultadoJson)) {
			resultadoJson = "{\"success\":false}";
		} else {
			resultadoJson = "{\"success\":true," + resultadoJson + "}";
		}

		Utils.writeJSon(response, resultadoJson);
	}
	
	private void guardar(Map<String, String> map, HttpServletResponse response, HttpServletRequest request) throws IOException {
		String resultadoJson="";
		boolean esnuevo = map.get("esnuevo").equals("true");
		int id = Utils.String2Int(map.get("id"));
		Subproducto subproducto;
		boolean ret = false;
		if (id>0 || esnuevo){
			try{
			String nombre = map.get("nombre");
			String descripcion = map.get("descripcion");

			Integer productoId = Utils.String2Int(map.get("producto"));
			Integer subproductoPadreId = Utils.String2Int(map.get("subproductoPadre"));
			Integer tiposubproductoId = Utils.String2Int(map.get("tiposubproductoid")); 
			Integer unidadEjecutoraId = Utils.String2Int(map.get("unidadEjecutora"));
			
			Long snip = Utils.String2Long(map.get("snip"), null);
			Integer programa = Utils.String2Int(map.get("programa"), null);
			Integer subprograma = Utils.String2Int(map.get("subprograma"), null);
			Integer proyecto_ = Utils.String2Int(map.get("proyecto_"), null);
			Integer obra = Utils.String2Int(map.get("obra"), null);
			Integer fuente = Utils.String2Int(map.get("fuente"), null);
			Integer actividad = Utils.String2Int(map.get("actividad"), null);
			String latitud = map.get("latitud");
			String longitud = map.get("longitud");
			
			
			Gson gson = new Gson();
		
			Type type = new TypeToken<List<stdatadinamico>>() {
			}.getType();

			List<stdatadinamico> datos = gson.fromJson(map.get("datadinamica"), type);
			Producto producto = ProductoDAO.getProductoPorId(productoId);
			Subproducto subproductoPadre = new Subproducto();
			subproductoPadre.setId(subproductoPadreId);
			SubproductoTipo subproductoTipo = new SubproductoTipo();
			subproductoTipo.setId(tiposubproductoId);
			UnidadEjecutora unidadEjecutora = new UnidadEjecutora();
			unidadEjecutora.setUnidadEjecutora(unidadEjecutoraId);
			
			if (esnuevo){
				
				subproducto = new Subproducto(producto, subproductoTipo, unidadEjecutora, nombre, descripcion, 
						 usuario, null, new DateTime().toDate(), null, 1
						, snip, programa, subprograma, proyecto_, actividad, obra, fuente, latitud, longitud,null, null);
				
			}else{
				subproducto = SubproductoDAO.getSubproductoPorId(id);
				subproducto.setProducto(producto);
				subproducto.setSubproductoTipo(subproductoTipo);
				subproducto.setUnidadEjecutora(unidadEjecutora);
				subproducto.setNombre(nombre);
				subproducto.setDescripcion(descripcion);
				subproducto.setSnip(snip);
				subproducto.setPrograma(programa);
				subproducto.setSubprograma(subprograma);
				subproducto.setProyecto(proyecto_);
				subproducto.setObra(obra);
				subproducto.setActividad(actividad);
				subproducto.setFuente(fuente);
				subproducto.setUsuarioActualizo(usuario);
				subproducto.setFechaActualizacion(new DateTime().toDate());
				subproducto.setLatitud(latitud);
				subproducto.setLongitud(longitud);
			}
			ret = SubproductoDAO.guardarSubproducto(subproducto);
			
			if (ret){
				SubproductoUsuarioId subproductoUsuarioId = new SubproductoUsuarioId(subproducto.getId(), usuario);
				SubproductoUsuario subproductoUsuario =  new SubproductoUsuario(subproductoUsuarioId, subproducto, usuario, null, new DateTime().toDate(),null);
				SubproductoUsuarioDAO.guardarSubproductoUsuario(subproductoUsuario);
				
				for (stdatadinamico data : datos) {
					if (data.valor!=null && data.valor.length()>0 && data.valor.compareTo("null")!=0){
						SubproductoPropiedad producotPropiedad = SubproductoPropiedadDAO.getSubproductoPropiedadPorId(Integer.parseInt(data.id));
						SubproductoPropiedadValorId idValor = new SubproductoPropiedadValorId(Integer.parseInt(data.id),subproducto.getId());
						SubproductoPropiedadValor valor = new SubproductoPropiedadValor(idValor, subproducto, producotPropiedad, null, null, null, null, 
								usuario, null, new DateTime().toDate(), null, 1);
	
						switch (producotPropiedad.getDatoTipo().getId()){
							case 1:
								valor.setValorString(data.valor);
								break;
							case 2:
								valor.setValorEntero(Utils.String2Int(data.valor, null));
								break;
							case 3:
								valor.setValorDecimal(Utils.String2BigDecimal(data.valor, null));
								break;
							case 4:
								break;
							case 5:
								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
								valor.setValorTiempo(data.valor_f.compareTo("")!=0 ? sdf.parse(data.valor_f) : null);
								break;
						}
						ret = (ret && SubproductoPropiedadValorDAO.guardarSubproductoPropiedadValor(valor));
					}
				}
			}
			
			resultadoJson = String.join("","{ \"success\": ",(ret ? "true" : "false"),", "
					+ "\"id\": " + subproducto.getId().toString(), ","
					, "\"usuarioCreo\": \"" , subproducto.getUsuarioCreo(),"\","
					, "\"fechaCreacion\":\" " , Utils.formatDateHour(subproducto.getFechaCreacion()),"\","
					, "\"usuarioactualizo\": \"" , subproducto.getUsuarioActualizo() != null ? subproducto.getUsuarioActualizo() : "","\","
					, "\"fechaactualizacion\": \"" , Utils.formatDateHour(subproducto.getFechaActualizacion()),"\""
					," }");
			}
			catch (Throwable e){
				resultadoJson = "{ \"success\": false }";
			}
			
		}else {
			resultadoJson = "{ \"success\": false }";
		}
		Utils.writeJSon(response, resultadoJson);
	}

	
	private void eliminar(Map<String, String> parametro, HttpServletResponse response) throws IOException {
		int codigo = Utils.String2Int(parametro.get("codigo"), -1);
		boolean eliminado = SubproductoDAO.eliminar(codigo, usuario);
		if (eliminado) {
			listar(parametro, response);
		}
	}

	private void total(Map<String, String> parametro,HttpServletResponse response) throws IOException {
		int productoid = Utils.String2Int(parametro.get("productoid"), 0);
		String filtro_nombre = parametro.get("filtro_nombre");
		String filtro_usuario_creo = parametro.get("filtro_usuario_creo");
		String filtro_fecha_creacion = parametro.get("filtro_fecha_creacion");
		Long total = SubproductoDAO.getTotalSubproductos(productoid,filtro_nombre,filtro_usuario_creo,filtro_fecha_creacion,usuario);

		String resultadoJson = "{\"success\":true, \"total\":" + total + "}";

		Utils.writeJSon(response, resultadoJson);
	}

	private void listarTipos(Map<String, String> parametro, HttpServletResponse response) throws IOException {
		int pagina = Utils.String2Int(parametro.get("pagina"), 1);
		int registros = Utils.String2Int(parametro.get("registros"), 20);
		int componenteid = Utils.String2Int(parametro.get("componenteid"), 0);
		
		String filtro_nombre = parametro.get("filtro_nombre");
		String filtro_usuario_creo = parametro.get("filtro_usuario_creo");
		String filtro_fecha_creacion = parametro.get("filtro_fecha_creacion");
		String columna_ordenada = parametro.get("columna_ordenada");
		String orden_direccion = parametro.get("orden_direccion");

		String resultadoJson = "";

		resultadoJson = SubproductoDAO.getJson(pagina, registros,componenteid,usuario,
				filtro_nombre,filtro_usuario_creo
				,filtro_fecha_creacion,columna_ordenada,orden_direccion);

		if (Utils.isNullOrEmpty(resultadoJson)) {
			resultadoJson = "{\"success\":false}";
		} else {
			resultadoJson = "{\"success\":true," + resultadoJson + "}";
		}

		Utils.writeJSon(response, resultadoJson);
	}

	private void listarSubproductos(Map<String, String> parametro, HttpServletResponse response) throws IOException {
		int pagina = Utils.String2Int(parametro.get("pagina"), 1);
		int registros = Utils.String2Int(parametro.get("registros"), 20);
		int componenteid = Utils.String2Int(parametro.get("componenteid"), 0);
		String filtro_nombre = parametro.get("filtro_nombre");
		String filtro_usuario_creo = parametro.get("filtro_usuario_creo");
		String filtro_fecha_creacion = parametro.get("filtro_fecha_creacion");
		String columna_ordenada = parametro.get("columna_ordenada");
		String orden_direccion = parametro.get("orden_direccion");


		String resultadoJson = "";

		resultadoJson = Utils.getJSonString("subproductos", SubproductoDAO.getSubproductosPagina(pagina, registros,componenteid,usuario,
				filtro_nombre,filtro_usuario_creo
				,filtro_fecha_creacion,columna_ordenada,orden_direccion));

		if (Utils.isNullOrEmpty(resultadoJson)) {
			resultadoJson = "{\"success\":false}";
		} else {
			resultadoJson = "{\"success\":true," + resultadoJson + "}";
		}

		Utils.writeJSon(response, resultadoJson);
	}

	private void listarComponentes(Map<String, String> parametro, HttpServletResponse response) throws IOException {
		int pagina = Utils.String2Int(parametro.get("pagina"), 1);
		int registros = Utils.String2Int(parametro.get("registros"), 20);

		String resultadoJson = "";

		resultadoJson = Utils.getJSonString("subproductos", ComponenteDAO.getComponentesPagina(pagina, registros,usuario));

		if (Utils.isNullOrEmpty(resultadoJson)) {
			resultadoJson = "{\"success\":false}";
		} else {
			resultadoJson = "{\"success\":true," + resultadoJson + "}";
		}

		Utils.writeJSon(response, resultadoJson);
	}
	
	private void obtenerSubproductoPorId(Map<String, String> parametro, HttpServletResponse response) throws IOException {
		Integer id = parametro.get("id")!=null ? Integer.parseInt(parametro.get("id")) : 0;
		Subproducto subproducto = SubproductoDAO.getSubproductoPorId(id,usuario);
		String resultadoJson = "";
		
		resultadoJson = String.join("","{ \"success\": ",(subproducto!=null && subproducto.getId()!=null ? "true" : "false"),", "
			+ "\"id\": " + (subproducto!=null ? subproducto.getId():"0") +", "
			+ "\"nombre\": \"" + (subproducto!=null ? subproducto.getNombre():"Indefinido") +"\" }");
		Utils.writeJSon(response, resultadoJson);	
	}
	
	private void getSubproductoPorId(Map<String, String> parametro, HttpServletResponse response) throws IOException {
		Integer id = parametro.get("id")!=null ? Integer.parseInt(parametro.get("id")) : 0;
		Subproducto subproducto = SubproductoDAO.getSubproductoPorId(id,usuario);
		
		stsubproducto temp = new stsubproducto();
		temp.id = subproducto.getId();
		temp.nombre = subproducto.getNombre();
		temp.subproductoTipo = subproducto.getSubproductoTipo().getNombre();
		temp.idSubproductoTipo = subproducto.getSubproductoTipo().getId();
		temp.nombreUnidadEjecutora = subproducto.getUnidadEjecutora().getNombre();
		temp.unidadEjectuora = subproducto.getUnidadEjecutora().getUnidadEjecutora();
		String resultadoJson = Utils.getJSonString("subproducto", temp);
		resultadoJson = "{\"success\":true," + resultadoJson + "}";
		Utils.writeJSon(response, resultadoJson);	
	}
	
	private void guardarModal(Map<String, String> map, HttpServletResponse response, HttpServletRequest request) throws IOException {
		String resultadoJson="";
		int id = Utils.String2Int(map.get("id"));
		Subproducto subproducto;
		boolean ret = false;
		
		try{
			String nombre = map.get("nombre");
			Integer tiposubproductoId = Utils.String2Int(map.get("tiposubproductoid")); 
			Integer unidadEjecutoraId = Utils.String2Int(map.get("unidadEjecutora"));
			
			SubproductoTipo subproductoTipo = new SubproductoTipo();
			subproductoTipo.setId(tiposubproductoId);
			UnidadEjecutora unidadEjecutora = new UnidadEjecutora();
			unidadEjecutora.setUnidadEjecutora(unidadEjecutoraId);
			
			
			subproducto = SubproductoDAO.getSubproductoPorId(id);
			if (subproducto!=null){	
				subproducto.setSubproductoTipo(subproductoTipo);
				subproducto.setUnidadEjecutora(unidadEjecutora);
				subproducto.setNombre(nombre);
			}
			
			ret = SubproductoDAO.guardarSubproducto(subproducto);
			stsubproducto temp = new stsubproducto();
			if (ret){
				temp.id = subproducto.getId();
				temp.nombre = subproducto.getNombre();
				temp.idSubproductoTipo = subproducto.getSubproductoTipo().getId();
				temp.subproductoTipo = subproducto.getSubproductoTipo().getNombre();
				temp.unidadEjectuora = subproducto.getUnidadEjecutora().getUnidadEjecutora();
				temp.nombreUnidadEjecutora = subproducto.getUnidadEjecutora().getNombre();
			}
			resultadoJson = Utils.getJSonString("subproducto", temp);
			resultadoJson = "{\"success\":true," + resultadoJson + "}";
			
			}
			catch (Throwable e){
				resultadoJson = "{ \"success\": false }";
			}
		Utils.writeJSon(response, resultadoJson);
	}
}
