import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Boolean;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

public class GUI {

	private JFrame frmWhatDoWe;

	static ArrayList<Restaurant> all_list = new ArrayList<Restaurant>();
	static String current_price = "Any";
	static String current_type = "Any";
	static String result = "";
	
	/*
	 * Add all restaurant in list first
	 */
	public static void get_ready() {
		all_list.add(new DaJiaLe());
		all_list.add(new DaChaFan());
		all_list.add(new XiangYue());
		all_list.add(new XiangCunZhuang());
		all_list.add(new TianMei());
		all_list.add(new HuaCheng());
		all_list.add(new JinYuManTang());
		all_list.add(new FeiChangMian());
		all_list.add(new ItaliaPizza());
		all_list.add(new MonsterChincken());
		all_list.add(new YeChon());
		all_list.add(new HaChi());
		all_list.add(new CarlJr());
		all_list.add(new BurgerFuel());
		all_list.add(new LoneStar());
		all_list.add(new ChuanYue());
		all_list.add(new Cameron());
		all_list.add(new BurgerKing());
		all_list.add(new McDonald());
		all_list.add(new KFC());
		all_list.add(new MadamK());
		all_list.add(new LaoDiFang());
		all_list.add(new MaoCai());
		all_list.add(new SaSeiGay());
		all_list.add(new MeiQiWu());
		all_list.add(new XiaoShiDai());
		all_list.add(new TongYi());
		all_list.add(new DuiZhang());
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		get_ready();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmWhatDoWe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWhatDoWe = new JFrame();
		frmWhatDoWe.setTitle("What do we Eat? -- Writen by Shun Lyu");
		frmWhatDoWe.setBounds(100, 100, 450, 300);
		frmWhatDoWe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWhatDoWe.getContentPane().setLayout(null);
		
		
		/*
		 * Fixed Texts
		 */
		JLabel Price_label_fix = new JLabel("Price :");
		Price_label_fix.setBounds(12, 12, 46, 24);
		frmWhatDoWe.getContentPane().add(Price_label_fix);
		
		JLabel Type_label_fix = new JLabel("Type :");
		Type_label_fix.setBounds(12, 48, 46, 24);
		frmWhatDoWe.getContentPane().add(Type_label_fix);
		
		JLabel Result_Label_fix = new JLabel("Result");
		Result_Label_fix.setFont(new Font("Dialog", Font.BOLD, 16));
		Result_Label_fix.setBounds(273, 16, 70, 15);
		frmWhatDoWe.getContentPane().add(Result_Label_fix);
		
		JLabel Result_Price_label_fix = new JLabel("Price :");
		Result_Price_label_fix.setBounds(273, 43, 46, 24);
		frmWhatDoWe.getContentPane().add(Result_Price_label_fix);
		
		JLabel Result_Type_label_fix = new JLabel("Type :");
		Result_Type_label_fix.setBounds(273, 75, 46, 24);
		frmWhatDoWe.getContentPane().add(Result_Type_label_fix);

		
		/*
		 * Texts change with combobox
		 */
		JLabel Price_label = new JLabel("Any");
		Price_label.setBounds(331, 48, 105, 15);
		frmWhatDoWe.getContentPane().add(Price_label);
		
		JLabel Type_label = new JLabel("Any");
		Type_label.setBounds(331, 80, 105, 15);
		frmWhatDoWe.getContentPane().add(Type_label);
		
		JLabel Final_label = new JLabel("");
		Final_label.setFont(new Font("Khmer OS", Font.BOLD | Font.ITALIC, 15));
		Final_label.setBounds(273, 202, 163, 45);
		frmWhatDoWe.getContentPane().add(Final_label);
		
		
		/*
		 * combobox for price of food
		 */
		JComboBox price_comboBox = new JComboBox();
		price_comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current_price = (String) price_comboBox.getSelectedItem();
				Price_label.setText(current_price);
			}
		});
		price_comboBox.setBounds(76, 12, 117, 24);
		String[] price_name_list = new String[] {"Any", "Cheap Shit", "Nice Shit"};
		price_comboBox.setModel(new DefaultComboBoxModel(price_name_list));
		frmWhatDoWe.getContentPane().add(price_comboBox);
		
		
		
		/*
		 * combobox for type of food
		 */
		JComboBox type_comboBox = new JComboBox();
		type_comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current_type = (String) type_comboBox.getSelectedItem();
				Type_label.setText(current_type);
			}
		});
		type_comboBox.setBounds(76, 48, 117, 24);
		String[] type_name_list = new String[] {"Any", "Chinese", "Japanese", "Korean","Pizza", "Burger", "Western"};
		type_comboBox.setModel(new DefaultComboBoxModel(type_name_list));
		frmWhatDoWe.getContentPane().add(type_comboBox);
		
		
		/*
		 * Button
		 */
		JButton choose_button = new JButton("Choose one");
		choose_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Restaurant> choose_filter_list = get_filter_list(current_price, current_type);
				result = get_random_name(choose_filter_list);
				Final_label.setText(result);
			}
		});
		choose_button.setBounds(12, 187, 243, 75);
		frmWhatDoWe.getContentPane().add(choose_button);
		
	}
	
	/*
	 * get the list after go though the filter.
	 */
	public ArrayList get_filter_list(String price, String type)
	{
		
		String current_price = "Any";
		ArrayList<Restaurant> filter_list = new ArrayList<Restaurant>();
		
		switch(price) {
		case "Cheap Shit": current_price = "0";break;
		case "Nice Shit": current_price = "1";break;
		}
		
		for(int i = 0; i < 24; i++) {
			
			if(price != "Any" && type != "Any") {
				if(all_list.get(i).getPrice() == Integer.parseInt(current_price) && all_list.get(i).getType() == type) {
					filter_list.add(all_list.get(i));
				}
			} else if (price == "Any" && type != "Any") {
				if(all_list.get(i).getType() == type) {
					filter_list.add(all_list.get(i));
				}
			} else if (price != "Any" && type == "Any") {
				if(all_list.get(i).getPrice() == Integer.parseInt(current_price)) {
					filter_list.add(all_list.get(i));
				}
			} else {
				filter_list = all_list;
			}
		}
		
		if(filter_list.size() == 0) {
			filter_list.add(new NOTHING());
		}
		return filter_list;
	}
	
	/*
	 * Based on current list after filter, pick one randomly
	 */
	public static String get_random_name(ArrayList<Restaurant> the_list)
	{
		Random rand = new Random();
		int rand_number = rand.nextInt(the_list.size());
		return the_list.get(rand_number).getName();
	}
}
