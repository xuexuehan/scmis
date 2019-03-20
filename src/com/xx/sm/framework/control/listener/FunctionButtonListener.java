package com.xx.sm.framework.control.listener;

import com.xx.sm.framework.control.action.org.FunctionAction;
import com.xx.sm.framework.model.dao.impl.IMisFunctionDAO;
import com.xx.sm.framework.model.dao.impl.IMisFunctionDAOImpl;
import com.xx.sm.framework.model.entity.MisFunction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FunctionButtonListener implements ActionListener {
    private JFrame mainFrame = null;

    public FunctionButtonListener() {
    }

    public FunctionButtonListener(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JPanel bodyPanel = (JPanel)this.mainFrame.getContentPane();
//        Component[] c1 = bodyPanel.getComponents();
//        JPanel welcomePanel = (JPanel) c1[1];
        JPanel welcomePanel = (JPanel) bodyPanel.getComponent(1);
        JPanel workspacePanel = (JPanel) welcomePanel.getComponent(0);//拿到中间区域panel

        workspacePanel.removeAll();
        workspacePanel.repaint();
        String functionId = e.getActionCommand();


        IMisFunctionDAO misFunctionDAO = new IMisFunctionDAOImpl();
        MisFunction misFunction = misFunctionDAO.findById(e.getActionCommand());
        String className = misFunction.getFunctionClass();

        FunctionAction action = null;

        //动态加载代码
        try {
            Class actionClass = null;
            actionClass = getClass().getClassLoader().loadClass(className);
            action = (FunctionAction)actionClass.newInstance();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }

        action.execute(workspacePanel);
        this.mainFrame.setVisible(true);

    }
}
