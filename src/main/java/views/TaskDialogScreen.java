/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.TaskController;
import java.awt.Toolkit;
import java.text.ParseException;
import models.Project;
import models.Task;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Héctor França
 */
public class TaskDialogScreen extends javax.swing.JDialog {

    private TaskController taskController;
    private Project project;
    private Task task;
    private boolean isUpdate = false;

    /**
     * Creates new form TaskDialog
     */
    public TaskDialogScreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        taskController = new TaskController();
        initComponents();
        hideErrors();
        setDateMask();
        
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHeader = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelAddTask = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabelDescription = new javax.swing.JLabel();
        jScrollPaneDescription = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jLabelDeadline = new javax.swing.JLabel();
        jFormattedTextFieldDeadline = new javax.swing.JFormattedTextField();
        jLabelNote = new javax.swing.JLabel();
        jScrollPaneNote = new javax.swing.JScrollPane();
        jTextAreaNote = new javax.swing.JTextArea();
        jLabelErrorName = new javax.swing.JLabel();
        jLabelErrorDeadline = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tarefa");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/logo.png")));
        setMinimumSize(new java.awt.Dimension(400, 400));
        setResizable(false);

        jPanelHeader.setBackground(new java.awt.Color(217, 217, 217));

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(116, 69, 196));
        jLabelTitle.setText("Tarefa");

        jLabelAddTask.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAddTask.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jLabelAddTask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddTaskMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelAddTask)
                .addContainerGap())
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAddTask)
                    .addComponent(jLabelTitle))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabelName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelName.setForeground(new java.awt.Color(116, 69, 196));
        jLabelName.setText("Nome:");

        jTextFieldName.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabelDescription.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDescription.setForeground(new java.awt.Color(116, 69, 196));
        jLabelDescription.setText("Descrição:");

        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextAreaDescription.setRows(5);
        jScrollPaneDescription.setViewportView(jTextAreaDescription);

        jLabelDeadline.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDeadline.setForeground(new java.awt.Color(116, 69, 196));
        jLabelDeadline.setText("Prazo:");

        jFormattedTextFieldDeadline.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jFormattedTextFieldDeadline.setToolTipText("dd/MM/yyyy");
        jFormattedTextFieldDeadline.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabelNote.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNote.setForeground(new java.awt.Color(116, 69, 196));
        jLabelNote.setText("Observação:");

        jTextAreaNote.setColumns(20);
        jTextAreaNote.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextAreaNote.setRows(5);
        jScrollPaneNote.setViewportView(jTextAreaNote);

        jLabelErrorName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelErrorName.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErrorName.setText("Campo obrigatório.");

        jLabelErrorDeadline.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelErrorDeadline.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErrorDeadline.setText("Campo obrigatório.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldName)
                    .addComponent(jScrollPaneDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(jScrollPaneNote, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(jFormattedTextFieldDeadline)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelName)
                            .addComponent(jLabelErrorName)
                            .addComponent(jLabelDescription)
                            .addComponent(jLabelNote)
                            .addComponent(jLabelDeadline)
                            .addComponent(jLabelErrorDeadline))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelErrorName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDeadline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextFieldDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelErrorDeadline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelNote)
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneNote)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelAddTaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddTaskMouseClicked
        try {
            if (isValidFieldName() && isValidFieldDeadline()) {
                Task formTask = getFormTask();

                formTask.setUpdateDate(new Date());

                if (isUpdate) {
                    formTask.setId(task.getId());
                    formTask.setCompleted(task.isCompleted());
                    formTask.setCreationDate(task.getCreationDate());

                    taskController.update(formTask);
                    JOptionPane.showMessageDialog(this, "Tarefa atualizada com sucesso!");
                } else {
                    formTask.setCompleted(false);
                    formTask.setCreationDate(new Date());
                    taskController.save(formTask);
                    JOptionPane.showMessageDialog(this, "Tarefa salva com sucesso!");
                }

                this.dispose();
            } else {
                hideErrors();

                if (!isValidFieldName()) {
                    jLabelErrorName.setVisible(true);
                }
                if (!isValidFieldDeadline()) {
                    jLabelErrorDeadline.setVisible(true);
                }
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar a tarefa.");
        }
    }//GEN-LAST:event_jLabelAddTaskMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Java swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TaskDialogScreen dialog = new TaskDialogScreen(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jFormattedTextFieldDeadline;
    private javax.swing.JLabel jLabelAddTask;
    private javax.swing.JLabel jLabelDeadline;
    private javax.swing.JLabel jLabelDescription;
    private javax.swing.JLabel jLabelErrorDeadline;
    private javax.swing.JLabel jLabelErrorName;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNote;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JScrollPane jScrollPaneDescription;
    private javax.swing.JScrollPane jScrollPaneNote;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextArea jTextAreaNote;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables

    public void setProject(Project project) {
        this.project = project;
    }

    public void setTask(Task task) {
        this.task = task;
        this.isUpdate = true;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        jTextFieldName.setText(task.getName());
        jTextAreaDescription.setText(task.getDescription());
        jFormattedTextFieldDeadline.setText(dateFormat.format(task.getDeadline()));
        jTextAreaNote.setText(task.getNotes());
    }

    private void hideErrors() {
        jLabelErrorName.setVisible(false);
        jLabelErrorDeadline.setVisible(false);
    }

    private boolean isValidFieldName() {
        return !jTextFieldName.getText().isEmpty();
    }

    private boolean isValidFieldDeadline() {
        if (jFormattedTextFieldDeadline.getText().equals("__/__/____")) {
            jLabelErrorDeadline.setText("Campo obrigatório.");
            return false;
        } else {
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                format.setLenient(false);
                format.parse(jFormattedTextFieldDeadline.getText());

                return true;
            } catch (ParseException ex) {
                jLabelErrorDeadline.setText("Data inválida.");
                return false;
            }
        }
        
    }

    private Task getFormTask() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Task task = new Task();

        task.setProjectId(project.getId());
        task.setName(jTextFieldName.getText());
        task.setDescription(jTextAreaDescription.getText());
        task.setNotes(jTextAreaNote.getText());

        try {
            task.setDeadline(dateFormat.parse(
                    jFormattedTextFieldDeadline.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(TaskDialogScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return task;
    }

    private void setDateMask() {
        MaskFormatter dateFormatter = new MaskFormatter();
        jFormattedTextFieldDeadline.setColumns(8);

        try {
            dateFormatter.setMask("##/##/####");
            dateFormatter.setPlaceholderCharacter('_');
            dateFormatter.install(jFormattedTextFieldDeadline);
        } catch (ParseException ex) {
            Logger.getLogger(TaskDialogScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
