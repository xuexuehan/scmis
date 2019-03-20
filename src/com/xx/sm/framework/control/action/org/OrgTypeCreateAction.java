package com.xx.sm.framework.control.action.org;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;

import com.xx.sm.framework.model.dao.impl.IOrgTypeDAO;
import com.xx.sm.framework.model.dao.impl.IOrgTypeDAOImpl;
import com.xx.sm.framework.model.entity.OrgType;

public class OrgTypeCreateAction implements FunctionAction, ActionListener {
	private JTextField orgTypeIdField = null;
	private JTextField orgTypeNameField = null;
	private JTextArea orgTypeMemoField = null;
	private JTabbedPane tabbedPane = null;
	
	public void excute(JPanel panelRight) {
		panelRight.removeAll();
		panelRight.repaint();
		panelRight.setLayout(new BorderLayout());
		
		this.tabbedPane = new JTabbedPane();
		
		Container workSpace = panelRight;
		
		JPanel body = new JPanel();
		
		body.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel orgTypeIdLabel = new JLabel("机构类别代号:");
		body.add(orgTypeIdLabel,gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		orgTypeIdField = new JTextField(20);
		body.add(orgTypeIdField,gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel orgTypeNameLabel = new JLabel("机构类别名称:");
		body.add(orgTypeNameLabel,gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		orgTypeNameField = new JTextField(20);
		body.add(orgTypeNameField,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel orgTypeMemoLabel = new JLabel("机构类别备注:");
		body.add(orgTypeMemoLabel,gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		JScrollPane orgTypeMemoScroll = new JScrollPane();
		JViewport orgTypeMemoScrollView = orgTypeMemoScroll.getViewport();
		orgTypeMemoField = new JTextArea(10,50);
		orgTypeMemoScrollView.add(orgTypeMemoField);
		body.add(orgTypeMemoScroll,gbc);
		
		JPanel buttonJPanle = new JPanel();
		buttonJPanle.setLayout(new FlowLayout());
		JButton addOrgType = new JButton("增加");
		addOrgType.addActionListener(this);
		
		JButton clearOrgType = new JButton("清空");
		clearOrgType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				orgTypeIdField.setText("");
				orgTypeNameField.setText("");
				orgTypeMemoField.setText("");
			}
		});
		buttonJPanle.add(addOrgType);
		buttonJPanle.add(clearOrgType);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		body.add(buttonJPanle,gbc);
		body.repaint();
		tabbedPane.addTab("增加机构类别", body);
		
		JPanel help = new JPanel();
		tabbedPane.addTab("增加机构类别帮助", help);
		workSpace.add(tabbedPane,BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e) {
		String id = this.orgTypeIdField.getText();
		String name = this.orgTypeNameField.getText();
		String memo = this.orgTypeMemoField.getText();
		OrgType orgType = new OrgType();
		orgType.setOrgTypeId(id);
		orgType.setOrgTypeName(name);
		orgType.setOrgTypeMemo(memo);
		IOrgTypeDAO daoImpl = new IOrgTypeDAOImpl();
		if(daoImpl.add(orgType)) {
			JOptionPane.showMessageDialog(null, "增加成功！");
		}
	}

	@Override
	public void execute(JPanel workPanel) {
		this.excute(workPanel);
	}

}
