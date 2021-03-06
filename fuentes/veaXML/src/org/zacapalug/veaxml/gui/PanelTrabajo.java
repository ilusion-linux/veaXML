/*
 * Copyright (C) 2015 ilusion-linux
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
package org.zacapalug.veaxml.gui;

import java.awt.BorderLayout;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import org.zacapalug.veaxml.gui.componentes.PnlAreaDeTrabajo;
import org.zacapalug.veaxml.gui.componentes.PnlPanelDeTrabajo;

/**
 *
 * @author ilusion-linux
 */
public class PanelTrabajo extends PnlPanelDeTrabajo
{
    private JEditorPane editor;
    private JScrollPane scroll;
    
    /**
     * Creates new form PanelTrabajo
     * @param panelTabs
     */
    public PanelTrabajo(PnlAreaDeTrabajo panelTabs)
    {
        super(panelTabs);
        initComponents();
        crearVistaCodigo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        vistaGrafica = new javax.swing.JPanel();
        vistaCodigo = new javax.swing.JPanel();

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        javax.swing.GroupLayout vistaGraficaLayout = new javax.swing.GroupLayout(vistaGrafica);
        vistaGrafica.setLayout(vistaGraficaLayout);
        vistaGraficaLayout.setHorizontalGroup(
            vistaGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 709, Short.MAX_VALUE)
        );
        vistaGraficaLayout.setVerticalGroup(
            vistaGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Vista Grafica", vistaGrafica);

        javax.swing.GroupLayout vistaCodigoLayout = new javax.swing.GroupLayout(vistaCodigo);
        vistaCodigo.setLayout(vistaCodigoLayout);
        vistaCodigoLayout.setHorizontalGroup(
            vistaCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 709, Short.MAX_VALUE)
        );
        vistaCodigoLayout.setVerticalGroup(
            vistaCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Vista de Codigo", vistaCodigo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel vistaCodigo;
    private javax.swing.JPanel vistaGrafica;
    // End of variables declaration//GEN-END:variables
    private void crearVistaCodigo()
    {
        editor=new JEditorPane();
        scroll=new JScrollPane(editor);
        
        editor.setContentType("text/xml");
        editor.setText("<humano pais='Guatemala'>soy humano</humano>");
        
        vistaCodigo.setLayout(new BorderLayout());
        vistaCodigo.add(scroll, BorderLayout.CENTER);
    }
}
