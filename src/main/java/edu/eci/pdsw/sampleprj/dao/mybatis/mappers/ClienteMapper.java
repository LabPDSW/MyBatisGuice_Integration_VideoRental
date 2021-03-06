package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Cliente;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2106913
 */
public interface ClienteMapper {
    
    default Cliente consultarCliente(Long id){
        return consultarClienteGeneral(id).get(0);
    }
    
    /**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param id
     * @param idit
     * @param fechainicio
     * @param fechafin 
     */
    public void agregarItemRentadoACliente(@Param("idcli") long id, 
            @Param("idi") int idit, 
            @Param("fini") Date fechainicio,
            @Param("ffin") Date fechafin);
    
    /**
     * Consultar todos los clientes
     * @return 
     */

    default List<Cliente> consultarClientes(){
        return consultarClienteGeneral(null);
    }
      
    public List<Cliente> consultarClienteGeneral(@Param("idcli") Long id);
    
    public void agregarCliente(@Param("doc") long documento, 
            @Param("nom") String nombre, 
            @Param("tel") String telefono,
            @Param("dir") String direccion, 
            @Param("mail") String email, 
            @Param("vetado") boolean vetado       
    );

    public void vetarCliente(@Param("doc") long doc, @Param("vet") boolean estado);
    
}
