/**
 * 
 */
package client.view;

import javax.swing.JTable;

/**
 * @author SOD
 *
 */
public class MyTable extends JTable{

	public MyTable(Object[][] gMessage, String[] names) {
		super(gMessage,names);
	}

	public MyTable(int i, int j) {
		super(i,j);
	}

	@Override
    public boolean isCellEditable(int row, int column) {
        if (!isCellEditable(0, 0)) {
            return isCellEditable(0, 0);
        } else {
            return super.isCellEditable(row, column);
        }
	}
}


