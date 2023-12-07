import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import javax.swing.RowSorter;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BrandPage extends JFrame {

	private JPanel contentPane;
	private JTextField searchBar1;
	private JTextField searchBar2;
	private JTable dataTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrandPage frame = new BrandPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
		
	public BrandPage() {
		setBackground(new Color(0, 0, 0));
		setExtendedState(BrandPage.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel upperTitlePanel = new JPanel();
		upperTitlePanel.setBackground(new Color(255, 255, 255));
		upperTitlePanel.setBounds(0, 0, 1920, 155);
		contentPane.add(upperTitlePanel);
		upperTitlePanel.setLayout(null);
		
		JLabel brandLabel = new JLabel("品牌方");
		brandLabel.setForeground(new Color(11, 25, 86));
		brandLabel.setBounds(38, 29, 72, 33);
		upperTitlePanel.add(brandLabel);
		brandLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		
		JLabel statisticLabel = new JLabel("統計");
		statisticLabel.setFont(new Font("微軟正黑體", Font.BOLD, 46));
		statisticLabel.setBounds(62, 70, 115, 70);
		upperTitlePanel.add(statisticLabel);
		
		JButton btnGenerateReport = new JButton("產出報表");
		btnGenerateReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnGenerateReport.setForeground(new Color(255, 255, 255));
		btnGenerateReport.setBackground(new Color(29, 90, 229));
		btnGenerateReport.setFont(new Font("微軟正黑體", Font.BOLD, 40));
		btnGenerateReport.setBounds(1018, 73, 232, 70);
		upperTitlePanel.add(btnGenerateReport);
		
		// 若不需要做查詢功能就把整個SearchbarPanel 至 searchBtn刪掉
		JPanel searchbarPanel = new JPanel();
		searchbarPanel.setBackground(new Color(255, 255, 255));
		searchbarPanel.setBounds(0, 152, 1920, 88);
		contentPane.add(searchbarPanel);
		searchbarPanel.setLayout(null);
		
		searchBar1 = new JTextField();
		searchBar1.setToolTipText("請輸入日期/工廠/門市名稱");
		searchBar1.setForeground(new Color(127, 127, 127));
		searchBar1.setText("請輸入日期/工廠/門市名稱");
		searchBar1.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		searchBar1.setBackground(new Color(239, 239, 239));
		searchBar1.setBounds(65, 25, 470, 41);
		searchbarPanel.add(searchBar1);
		searchBar1.setColumns(10);
		
		searchBar2 = new JTextField();
		searchBar2.setToolTipText("請輸入回報數");
		searchBar2.setText("請輸入回報數");
		searchBar2.setForeground(new Color(127, 127, 127));
		searchBar2.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		searchBar2.setColumns(10);
		searchBar2.setBackground(new Color(239, 239, 239));
		searchBar2.setBounds(545, 25, 470, 41);
		searchbarPanel.add(searchBar2);
		
		JButton btnClear = new JButton("清空");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchBar1.setText("");
				searchBar2.setText("");
			}
		});
		btnClear.setBackground(new Color(123, 157, 236));
		btnClear.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setBounds(1024, 25, 108, 41);
		searchbarPanel.add(btnClear);
		
		JButton btnSearch = new JButton("查詢");	
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchBar1.getText();
				searchBar2.getText();
			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		btnSearch.setBackground(new Color(123, 157, 236));
		btnSearch.setBounds(1142, 25, 108, 41);
		searchbarPanel.add(btnSearch);
		
		
		dataTable = new JTable();
		
		Object[] columnNames = {"ID", "Date", "Factory", "Supplier", "Shop","Goods","回報數"};
        Object[][] data = {
            {"0000001", "20230601", "劉弘製衣廠", "洪劉供應", "琉留門市","印字紋理衫","0"},
            {"0000002", "20230603", "劉弘製衣廠", "洪劉供應", "琉留門市","印字紋理衫","0"},
            {"0000003", "20230605", "劉弘製衣廠", "洪劉供應", "琉留門市","印字紋理衫","2"},
            {"0000004", "20230619", "劉弘製衣廠", "洪劉供應", "琉留門市","印字紋理衫","0"},
            {"0000005", "20230621", "劉弘製衣廠", "洪劉供應", "琉留門市","印字紋理衫","0"},
            {"0000006", "20230623", "劉弘製衣廠", "洪劉供應", "琉留門市","印字紋理衫","0"},
            {"0000007", "20230624", "劉弘製衣廠", "洪劉供應", "琉留門市","印字紋理衫","0"},
            {"0000008", "20230625", "劉弘製衣廠", "洪劉供應", "琉留門市","印字紋理衫","1"},
            {"0000009", "20230628", "劉弘製衣廠", "洪劉供應", "琉留門市","印字紋理衫","0"},
            {"0000010", "20230629", "劉弘製衣廠", "洪劉供應", "琉留門市","印字紋理衫","0"},
            {"0000011", "20230630", "劉弘製衣廠", "洪劉供應", "琉留門市","印字紋理衫","0"}
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        dataTable = new JTable(model) {

           // private static final long serialVersionUID = 1L;
           @Override
           public Class getColumnClass(int column) {
        	   return String.class;
           }
       };
       dataTable.setPreferredScrollableViewportSize(dataTable.getPreferredSize());
       RowSorter<javax.swing.table.TableModel>sorter = new TableRowSorter<TableModel>(dataTable.getModel());	// 排序列
       dataTable.setRowSorter(sorter);
       dataTable.setBounds(0, 276, 1283, 424);
       dataTable.setRowHeight(50);
       dataTable.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
       dataTable.setShowHorizontalLines(true);
       dataTable.setShowVerticalLines(false);
       dataTable.setGridColor(new Color(220,220,220));
       dataTable.setAutoscrolls(false);
       CustomRowRenderer cellRenderer = new CustomRowRenderer();
       dataTable.setDefaultRenderer(Object.class, cellRenderer);
       
       JScrollPane scrollPane = new JScrollPane(dataTable);
       scrollPane.setBounds(64, 250, 1183, 429);
       contentPane.add(scrollPane);
       
	}
	static class CustomRowRenderer extends DefaultTableCellRenderer {
	    public boolean isCellEditable(int row, int column) {
            return false; // 1 corresponds to the "Age" column
        }
	    public Component getTableCellRendererComponent(
	            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	    	
	        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	        setHorizontalAlignment( JLabel.CENTER );
	        // Set different background color based on conditions
	        int reportNum = Integer.parseInt(table.getValueAt(row, 6).toString());

	        if (reportNum > 0) {
	        	setFont(new Font("微軟正黑體", Font.BOLD, 25));
	        	setForeground(new Color(231, 88, 88));
	            setBackground(new Color(239, 235, 235));
	        } else {
	        	setForeground(Color.BLACK);
	        	setBackground(new Color(255, 255, 255));
	        }

	        return this;
	    }
	}
}

