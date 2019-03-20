package com.xx.sm.framework.control.listener;

import com.xx.sm.framework.model.dao.impl.IMisFunctionDAO;
import com.xx.sm.framework.model.dao.impl.IMisFunctionDAOImpl;
import com.xx.sm.framework.model.entity.MisFunction;
import com.xx.sm.framework.model.entity.MisUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MenuListener implements ActionListener {
    private MisUser misUser = null;
    private JFrame mainFrame = null;

    public MenuListener() {

    }

    public MenuListener(MisUser misUser, JFrame mainFrame) {
        this.misUser = misUser;
        this.mainFrame = mainFrame;
    }


    private List<JButton> getButtonList(String menuId) {//动态加载button
        List<JButton> list = new ArrayList<JButton>();
        IMisFunctionDAO misFunctionDAO = new IMisFunctionDAOImpl();
       // List<MisFunction> functionList = misFunctionDAO.findByMenuId(menuId);
        List<MisFunction> functionList = misFunctionDAO.findByMenuIdAndRoleId(menuId, this.misUser.getUserName());//加权限
        for(MisFunction misFunction : functionList) {
            JButton tempButton = new JButton();
            tempButton.setActionCommand(misFunction.getFunctionId());
            tempButton.setText(misFunction.getFunctionName());
            tempButton.setToolTipText(misFunction.getFunctionMemo());

            tempButton.addActionListener(new FunctionButtonListener(this.mainFrame));
            list.add(tempButton);
        }

        return list;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JPanel bodyPanel =(JPanel)this.mainFrame.getContentPane();
        Component[] component = bodyPanel.getComponents();
//        System.out.println(component[0]);
//        System.out.println(component[1]);
//        System.out.println(component[2]);
        JPanel welcomePanel = (JPanel)component[1];//拿到welcom面板

        welcomePanel.removeAll();
        welcomePanel.repaint();

        welcomePanel.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        welcomePanel.add(centerPanel, BorderLayout.CENTER);

        JPanel leftPanel = new JPanel();
        leftPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.RED));
        welcomePanel.add(leftPanel, BorderLayout.WEST);

        leftPanel.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(6, 1));
        List<JButton> buttonList = this.getButtonList(e.getActionCommand());//获取点击的menuId
        for(int i = 0; i < buttonList.size(); i++) {
            buttonPanel.add(buttonList.get(i));
        }
        leftPanel.add(buttonPanel, BorderLayout.NORTH);
        this.mainFrame.setVisible(true);

    }
}
