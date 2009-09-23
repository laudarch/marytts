/*
 * ShortDescriptionPanel.java
 *
 * Created on 21. September 2009, 09:33
 */

package marytts.tools.install;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author  marc
 */
public class ShortDescriptionPanel extends javax.swing.JPanel implements Observer
{
    private ComponentDescription desc;
    private VoiceUpdateListener voiceUpdate;
    private Color selectedColor = new Color(102, 153, 255);
    private Color unselectedColor;
    private boolean isSelected = false;
    
    /** Creates new form ShortDescriptionPanel */
    public ShortDescriptionPanel(ComponentDescription desc, VoiceUpdateListener voiceUpdate) {
        this.desc = desc;
        desc.addObserver(this);
        this.voiceUpdate = voiceUpdate;
        initComponents();
        this.unselectedColor = this.getBackground();
        this.setMaximumSize(new Dimension(32767, (int)this.getPreferredSize().getHeight()));
        verifyDisplay();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        cbSelected = new javax.swing.JCheckBox();
        bDetails = new javax.swing.JButton();
        lStatus = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        cbSelected.setText(desc.getName());
        cbSelected.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        cbSelected.setMargin(new java.awt.Insets(0, 0, 0, 0));
        cbSelected.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSelectedItemStateChanged(evt);
            }
        });
        cbSelected.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        bDetails.setText("Details");
        bDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDetailsActionPerformed(evt);
            }
        });
        bDetails.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        lStatus.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        lStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lStatus.setText(desc.getStatus().toString());

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(cbSelected, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 166, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, lStatus, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, bDetails, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(lStatus)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(cbSelected, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(bDetails))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbSelectedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSelectedItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            desc.setSelected(true);
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            desc.setSelected(false);
        }
    }//GEN-LAST:event_cbSelectedItemStateChanged

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.requestFocusInWindow();
    }//GEN-LAST:event_formMouseClicked

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        setSelected(false);
    }//GEN-LAST:event_formFocusLost

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        setSelected(true);
    }//GEN-LAST:event_formFocusGained

    private void bDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDetailsActionPerformed
        showComponentDetails(desc);
    }//GEN-LAST:event_bDetailsActionPerformed
    
    
    private void setSelected(boolean newSelected)
    {
        if (!isSelected && newSelected) {
            isSelected = true;
            this.setBackground(selectedColor);
            if (voiceUpdate != null && desc instanceof LanguageComponentDescription) {
                voiceUpdate.updateVoices((LanguageComponentDescription)desc, false);
            }
        } else if (isSelected && !newSelected) {
            isSelected = false;
            this.setBackground(unselectedColor);
        }
    }
    
    private void showComponentDetails(ComponentDescription desc)
    {
          JPanel p;
          if (desc instanceof LanguageComponentDescription) {
              p = new LanguagePanel((LanguageComponentDescription) desc);
          } else {
              p = new VoicePanel((VoiceComponentDescription)desc);
          }
          JOptionPane.showMessageDialog(null, p, "Component details", JOptionPane.PLAIN_MESSAGE);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDetails;
    private javax.swing.JCheckBox cbSelected;
    private javax.swing.JLabel lStatus;
    // End of variables declaration//GEN-END:variables

    public void update(Observable o, Object arg) {
        verifyDisplay();
    }

    private void verifyDisplay()
    {
        cbSelected.setSelected(desc.isSelected());
        lStatus.setText(desc.getStatus().toString());
    }
}
