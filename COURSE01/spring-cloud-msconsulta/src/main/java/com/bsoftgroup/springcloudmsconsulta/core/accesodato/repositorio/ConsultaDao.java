package com.bsoftgroup.springcloudmsconsulta.core.accesodato.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bsoftgroup.springcloudmsconsulta.core.interfaces.ConsultaDaoInterface;
import com.bsoftgroup.springcloudmsconsulta.core.negocio.bean.Cliente;
import com.bsoftgroup.springcloudmsconsulta.core.negocio.bean.Producto;
import com.bsoftgroup.springcloudmsconsulta.core.negocio.bean.Servicio;
import com.bsoftgroup.springcloudmsconsulta.core.util.AppException;
import com.bsoftgroup.springcloudmsconsulta.core.util.Conexion;

@Repository
public class ConsultaDao implements ConsultaDaoInterface {

	public ConsultaDao() {
	}

	@Override
	public String holamicroservicios() {
		// TODO Auto-generated method stub
		return "Hola curso de microservicios";
	}

	@Override
	public List<Servicio> getServicios(Integer idCliente, Integer idEmpresa) throws AppException {
		List<Servicio> servicios = new ArrayList<>();
		Conexion con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = new Conexion();
		} catch (Exception e) {
			throw new AppException(e.getMessage());
		}
		String SQL = "SELECT \r\n" + " c.codigo as cliente, \r\n" + " c.nombres as nombres,\r\n"
				+ " p.codigo as producto, \r\n" + " p.descripcion as descripcion,\r\n" + " p.precio as precio,\r\n"
				+ " cp.codigo as recibo,\r\n" + " cp.monto as deuda,\r\n" + " cp.estado as estado \r\n"
				+ " FROM esqmicroservicios.TBL_CLIENTE c \r\n"
				+ " INNER JOIN esqmicroservicios.TBL_CLIENTE_PRODUCTO cp on c.codigo = cp.cliente \r\n"
				+ " INNER JOIN esqmicroservicios.TBL_PRODUCTO p on p.codigo = cp.producto\r\n"
				+ " and c.codigo = ? and c.empresa = ? ";
		try {
			con.getConexion().setAutoCommit(false);
			pstmt = con.getConexion().prepareStatement(SQL);
			pstmt.setInt(1, idCliente);
			pstmt.setInt(2, idEmpresa);
			rs = pstmt.executeQuery();
			con.getConexion().commit();
			while (rs.next()) {
				Servicio servicio = new Servicio();
				servicio.setCodigo(rs.getInt("recibo"));
				servicio.setEstado(rs.getString("estado"));
				servicio.setCliente(new Cliente(rs.getInt("cliente"), rs.getString("nombres")));
				servicio.setProducto(new Producto(rs.getInt("producto"), rs.getString("descripcion")));
				servicio.setMonto(rs.getInt("deuda"));
				servicios.add(servicio);
				servicio = null;
			}
		} catch (Exception e) {
			throw new AppException(e.getMessage());
		} finally {
			try {
				con.closeResources(con.getConexion(), rs, null, null, pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return servicios;
	}

}
