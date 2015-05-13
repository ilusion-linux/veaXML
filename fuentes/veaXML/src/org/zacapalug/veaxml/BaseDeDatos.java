/*
 * Copyright (C) 2015 ghots
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.zacapalug.veaxml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 *
 * @author ghots
 */
public class BaseDeDatos
{
//<editor-fold defaultstate="collapsed" desc="Variables">
    private final String PROPERTIES="BaseDeDatos";
    private final String NOMBRE_KEY="base_de_datos.nombre";
    private final String DRIVER_KEY="base_de_datos.driver";
    
    private final String NOMBRE_PROPIEDAD="propiedad";
    private final String VALOR_PROPIEDAD="valor";
    
    private final String DOCUMENTO_HISTORIAL="documento";
    private final String ACCION_HISTORIAL="accion";
    
    private final String nombre;
    private final String driver;
    private final String url;
    
    private Connection conexion;
//</editor-fold>
    
    public BaseDeDatos()
    {
        ResourceBundle bundle=ResourceBundle.getBundle(PROPERTIES);
        
        nombre=bundle.getString(NOMBRE_KEY);
        driver=bundle.getString(DRIVER_KEY);
        
        url=driver+nombre;
    }
//<editor-fold defaultstate="collapsed" desc="Manejo de coneccion">
    public boolean conectar()
    {
        try
        {
            conexion=DriverManager.getConnection(url);
        
            if(conexion!=null)
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    public void cerrar()
    {
        try
        {
            conexion.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Obtencion de datos">
    public Map<String, String> obtenerParametros()
    {
        return obtenerConsulta("propiedad", NOMBRE_PROPIEDAD, VALOR_PROPIEDAD);
    }
    
    public Map<String, String> obtenerHistorial()
    {
        return obtenerConsulta("historial", DOCUMENTO_HISTORIAL,
            ACCION_HISTORIAL);
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Ejecucion de SQL">
    private Map<String, String> obtenerConsulta(String tabla, String nombre,
        String valor)
    {
        ResultSet result;
        Map<String, String> retorno=new HashMap<>();
        
        String sql="select "+nombre+", "+valor+" from "+tabla;
        
        try
        {
            PreparedStatement st=conexion.prepareStatement(sql);
            
            result=st.executeQuery();
            
            while(result.next())
            {
                retorno.put(result.getString(nombre), result.getString(valor));
            }
        }
        catch(Exception e)
        {
            retorno.clear();
            
            System.out.println(e.getMessage());
        }
        
        return retorno;
    }
//</editor-fold>
}
