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

public class OrgTypeRemoveAction implements FunctionAction, ActionListener {
	private JPanel workspace = null;
	private JTabbedPane tabbedPane = null;
	private JPanel removePanel = null;
	private JPanel bottomPanel = null;
	private JPanel testPanel = null;


	private JTable bodyTable = null;
	private DefaultTableModel bodyTableModel = null;
	private JButton removeButton = null;


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


	private void initRemovePanel() {
		this.removePanel = new JPanel(new BorderLayout());

		this.bodyTableModel = new DefaultTableModel(this.getTableData(), new String[] {"编号", "名称", "描述"});
		this.bodyTable = new JTable(this.bodyTableModel);

		JScrollPane scrollPane = new JScrollPane(this.bodyTable);
		this.removePanel.add(scrollPane, BorderLayout.CENTER);

		this.bottomPanel = new JPanel();
		this.removeButton = new JButton("删除");
		this.removeButton.addActionListener(this);
		this.bottomPanel.add(this.removeButton);

		this.removePanel.add(this.bottomPanel, BorderLayout.SOUTH);

		this.tabbedPane.add("机构类别删除", this.removePanel);
	}

	private void initTestPanel() {
		this.testPanel = new JPanel();
		this.testPanel.setBackground(Color.BLUE);

		this.tabbedPane.add("test", this.testPanel);

	}
	private void init() {
		this.workspace.setLayout(new BorderLayout());
		this.tabbedPane = new JTabbedPane();

		this.initRemovePanel();
		this.workspace.add(this.tabbedPane, BorderLayout.CENTER);

	}

	@Override
	public void execute(JPanel workspace) {
		this.workspace = workspace;
		this.init();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.removeButton) {
			if(this.bodyTable.getSelectedRowCount() == 1) {
				String orgTypeId = this.bodyTableModel.getValueAt(this.bodyTable.getSelectedRow(), 0).toString();
				IOrgTypeDAO orgTypeDAO = new IOrgTypeDAOImpl();
				if(orgTypeDAO.remove(orgTypeId)) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.refrashTableData();
				}
			} else {
				JOptionPane.showMessageDialog(null, "请选择一条数据！");
			}
		}
	}

}
