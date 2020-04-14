package com.bsoftgroup.springcloudmspago.core.accesodato.repositorio;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.bsoftgroup.springcloudmspago.core.interfaces.PagoDaoInterface;
import com.bsoftgroup.springcloudmspago.core.negocio.bean.Servicio;
import com.bsoftgroup.springcloudmspago.core.util.AppException;
import com.bsoftgroup.springcloudmspago.core.util.Conexion;
import com.bsoftgroup.springcloudmspago.core.util.Transaccion;

@Repository
public class PagoDao implements PagoDaoInterface {

	@Override
	public Transaccion pagarServicio(Servicio servicio) throws AppException {
		Transaccion tx = new Transaccion();
		PreparedStatement pstmt = null;
		Conexion con = null;
		String SQL = "UPDATE esqmicroservicios.TBL_CLIENTE_PRODUCTO SET estado = '1' where codigo=? and cliente=? and producto=?";
		try {
			con = new Conexion();
			con.getConexion().setAutoCommit(false);
			pstmt = con.getConexion().prepareStatement(SQL);
			pstmt.setInt(1, servicio.getCodigo());
			pstmt.setInt(2, servicio.getCliente().getCodigo());
			pstmt.setInt(3, servicio.getProducto().getCodigo());
			pstmt.executeUpdate();
			tx.setCodigo("0000");
			tx.setDescripcion("Proceso Conforme");
			con.getConexion().commit();
		} catch (SQLException sqle) {
			throw new AppException(sqle.getMessage());
		} catch (Exception e) {
			throw new AppException(e.getMessage());
		} finally {
			try {
				con.closeResources(con.getConexion(), null, null, null, pstmt);
			} catch (Exception e) {
				throw new AppException(e.getMessage());
			}
		}
		return tx;
	}

}
