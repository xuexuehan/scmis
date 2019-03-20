package com.xx.sm.framework.control.action.org;

import com.xx.sm.framework.model.dao.impl.IOrgTypeDAO;
import com.xx.sm.framework.model.dao.impl.IOrgTypeDAOImpl;
import com.xx.sm.framework.model.entity.OrgType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OrgTypeModifyAction implements FunctionAction, ActionListener {
	private JPanel workspace = null;
	private JTabbedPane tabbedPane = null;
	private JPanel modifyPanel = null;
	private JPanel bottomPanel = null;
	private JPanel testPanel = null;


	private JTable bodyTable = null;
	private DefaultTableModel bodyTableModel = null;
	private JButton modifyButton = null;
	private JButton refrashButton = null;


	private String[][] getTableData() {
		String[][] data = null;
		IOrgTypeDAO orgTypeDAO = new IOrgTypeDAOImpl();
		List<OrgType> list = orgTypeDAO.findByLike(new OrgType());
		data = new String[list.size()][3];
		for(int i =0; i < list.size(); i++) {
			OrgType orgType = list.get(i);
			data[i][0] = orgType.getOrgTypeId();
			data[i][1] = orgType.getOrgTypeName();
			data[i][2] = orgType.getOrgTypeMemo();
		}
		return data;
	}

	private void refrashTableData() {
		this.bodyTable.removeAll();
		this.bodyTable.repaint();

		this.bodyTableModel = new DefaultTableModel(this.getTableData(), new String[] {"编号", "名称", "描述"});
		this.bodyTable.setModel(this.bodyTableModel);
	}


	private void initModifyPanel() {
		this.modifyPanel = new JPanel(new BorderLayout());

		this.bodyTableModel = new DefaultTableModel(this.getTableData(), new String[] {"编号", "名称", "描述"});
		this.bodyTable = new JTable(this.bodyTableModel);

		JScrollPane scrollPane = new JScrollPane(this.bodyTable);
		this.modifyPanel.add(scrollPane, BorderLayout.CENTER);

		this.bottomPanel = new JPanel();
		this.modifyButton = new JButton("修改");
		this.modifyButton.addActionListener(this);
		this.refrashButton = new JButton("刷新");
		this.refrashButton.addActionListener(this);
		this.bottomPanel.add(this.modifyButton);
		this.bottomPanel.add(this.refrashButton);

		this.modifyPanel.add(this.bottomPanel, BorderLayout.SOUTH);

		this.tabbedPane.add("机构类别修改", this.modifyPanel);
	}

	private void initTestPanel() {
		this.testPanel = new JPanel();
		this.testPanel.setBackground(Color.BLUE);

		this.tabbedPane.add("test", this.testPanel);

	}
	private void init() {
		this.workspace.setLayout(new BorderLayout());
		this.tabbedPane = new JTabbedPane();

		this.initModifyPanel();
		this.initTestPanel();

		this.workspace.add(this.tabbedPane, BorderLayout.CENTER);

	}

	@Override
	public void execute(JPanel workspace) {
		this.workspace = workspace;
		this.init();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.modifyButton) {
			if(this.bodyTable.getSelectedRowCount() == 1) {
				String orgTypeId = this.bodyTableModel.getValueAt(this.bodyTable.getSelectedRow(), 0).toString();
				modifyDialog dialog = new modifyDialog(this, orgTypeId);
				dialog.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "请选择一条数据！");
			}
		} else if(e.getSource() == this.refrashButton) {
			this.refrashTableData();
		}
	}


	public class modifyDialog extends JDialog implements ActionListener {//java内部类
		private OrgTypeModifyAction action = null;
		private OrgType orgType = null;

		private JLabel orgTypeIdLabel = null;
		private JTextField orgTypeIdField = null;
		private JLabel orgTypeNameLabel = null;
		private JTextField orgTypeNameField = null;
		private JLabel orgTypeMemoLabel = null;
		private JScrollPane orgTypeMemoScroll = null ;
		private JTextArea orgTypeMemoField = null;
		private JPanel buttonJPanle = null;
		private JButton modifyOrgType = null;
		private JButton restoreOrgType = null;

		private OrgType findOrgType(String orgTypeId) {
			OrgType orgType = null;
			IOrgTypeDAO dao = new IOrgTypeDAOImpl();
			orgType = dao.findById(orgTypeId);
			return orgType;
		}

		private void init() {
			Container container = this.getContentPane();
			container.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			//机构类别代号
			gbc.gridx = 0;
			gbc.gridy = 0;
			this.orgTypeIdLabel = new JLabel("机构类别代号:");
			container.add(this.orgTypeIdLabel, gbc);
			gbc.gridx = 1;
			gbc.gridy = 0;
			this.orgTypeIdField = new JTextField(20);
			this.orgTypeIdField.setEditable(false);
			this.orgTypeIdField.setText(this.orgType.getOrgTypeId());
			container.add(this.orgTypeIdField, gbc);
			//机构类别名称
			gbc.gridx = 0;
			gbc.gridy = 1;
			this.orgTypeNameLabel = new JLabel("机构类别名称");
			container.add(this.orgTypeNameLabel, gbc);
			gbc.gridx = 1;
			gbc.gridy = 1;
			this.orgTypeNameField = new JTextField(20);
			this.orgTypeNameField.setText(this.orgType.getOrgTypeName());
			container.add(this.orgTypeNameField, gbc);
			gbc.gridx = 0;
			gbc.gridy = 2;
			this.orgTypeMemoLabel = new JLabel("机构类别备注:");
			container.add(this.orgTypeMemoLabel, gbc);
			gbc.gridx = 1;
			gbc.gridy = 2;
			this.orgTypeMemoField = new JTextArea(8, 20);
			this.orgTypeMemoField.setText(this.orgType.getOrgTypeMemo());

			this.orgTypeMemoScroll = new JScrollPane();
			this.orgTypeMemoScroll.getViewport().add(this.orgTypeMemoField);

			container.add(this.orgTypeMemoScroll, gbc);

			this.buttonJPanle = new JPanel();
			this.buttonJPanle.setLayout(new FlowLayout());
			this.modifyOrgType = new JButton("保存");
			this.modifyOrgType.setActionCommand("save");
			this.modifyOrgType.addActionListener(this);
			this.restoreOrgType = new JButton("还原");
			this.restoreOrgType.setActionCommand("fade");
			this.restoreOrgType.addActionListener(this);

			this.buttonJPanle.add(this.modifyOrgType);
			this.buttonJPanle.add(this.restoreOrgType);

			gbc.gridx = 1;
			gbc.gridy = 3;
			container.add(this.buttonJPanle,gbc);

			this.setBounds(100, 100, 450, 550);
			this.setTitle("修改");

		}

		public modifyDialog() {
		}

		public modifyDialog(OrgTypeModifyAction action, String orgTypeId) {
			this.action = action;
			this.orgType = this.findOrgType(orgTypeId);
			this.init();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == this.modifyOrgType) {
				String id = this.orgTypeIdField.getText();
				String name = this.orgTypeNameField.getText();
				String memo = this.orgTypeMemoField.getText();

				OrgType orgType = new OrgType(id, name, memo);
				IOrgTypeDAO orgTypeDAO = new IOrgTypeDAOImpl();
				if(orgTypeDAO.modify(orgType)) {
					JOptionPane.showMessageDialog(this, "修改成功！");
					this.action.refrashTableData();
				}

			} else if(e.getSource() == this.restoreOrgType) {
				this.orgTypeNameField.setText(this.orgType.getOrgTypeName());
				this.orgTypeMemoField.setText(this.orgType.getOrgTypeMemo());

			}
		}
	}

}
