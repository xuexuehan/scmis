package com.xx.sm.framework.control.action.org;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class OrgTypeQueryAction implements FunctionAction {

	@Override
	public void execute(JPanel workspace) {
		JLabel label = new JLabel("查询机构类别");
		workspace.add(label);
	}

}
