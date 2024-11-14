import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CheckableMenuApp extends JFrame {

    private List<MenuItem> menuItems;
    private DefaultListModel<MenuItem> listModel;
    private JList<MenuItem> itemList;
    private JTextField inputField;

    static class MenuItem {
        private String name;
        private boolean completed;

        public MenuItem(String name) {
            this.name = name;
            this.completed = false;
        }

        public String getName() {
            return name;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public CheckableMenuApp() {
        setTitle("Меню с возможностью отметки выполнения");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        menuItems = new ArrayList<>();
        listModel = new DefaultListModel<>();
        itemList = new JList<>(listModel);
        itemList.setCellRenderer(new CheckBoxListRenderer());
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        itemList.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int index = itemList.locationToIndex(evt.getPoint());
                MenuItem item = listModel.getElementAt(index);
                item.setCompleted(!item.isCompleted());
                itemList.repaint();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        inputField = new JTextField(20);

        JButton addButton = new JButton("Добавить пункт");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newItem = inputField.getText();
                if (!newItem.trim().isEmpty()) {
                    MenuItem menuItem = new MenuItem(newItem);
                    menuItems.add(menuItem);
                    listModel.addElement(menuItem);
                    inputField.setText("");
                }
            }
        });

        JButton exitButton = new JButton("Выход");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Введите пункт:"));
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        panel.add(new JScrollPane(itemList), BorderLayout.CENTER);
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(exitButton, BorderLayout.SOUTH);

        add(panel);
    }
    private class CheckBoxListRenderer extends JCheckBox implements ListCellRenderer<MenuItem> {
        @Override
        public Component getListCellRendererComponent(JList<? extends MenuItem> list, MenuItem value, int index, boolean isSelected, boolean cellHasFocus) {
            setEnabled(list.isEnabled());
            setSelected(value.isCompleted());
            setFont(list.getFont());
            setBackground(list.getBackground());
            setForeground(list.getForeground());
            setText(value.getName());
            return this;
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CheckableMenuApp app = new CheckableMenuApp();
                app.setVisible(true);
            }
        });
    }
}
