package HW14;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class hw14 {
    public static void main(String[] args) {
        new BMIManager();
    }
}

class BMIManager extends JFrame {
    private static final long serialVersionUID = 1L;
    private JButton addButton, saveButton, listButton;
    private JTextField nameField, heightField, weightField;
    private JTextArea textArea;
    private List<BMIRecord> records;
    private File csvFile;

    public BMIManager() {
        super("BMI 管理器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new FlowLayout());

        records = new ArrayList<>();

        // 获取桌面路径
        String desktopPath = System.getProperty("user.home") + "/Desktop";
        csvFile = Paths.get(desktopPath, "BMI_records.csv").toFile();
        
        // 初始化 CSV 文件
        if (!csvFile.exists()) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
                writer.println("Name,Height,Weight,BMI");
            } catch (IOException ex) {
                textArea.setText("初始化文件时出错: " + ex.getMessage());
            }
        } else {
            loadExistingRecords();
        }

        nameField = new JTextField(10);
        heightField = new JTextField(10);
        weightField = new JTextField(10);

        add(new JLabel("姓名:"));
        add(nameField);
        add(new JLabel("身高 (cm):"));
        add(heightField);
        add(new JLabel("體重 (kg):"));
        add(weightField);

        addButton = new JButton("新增記錄");
        addButton.addActionListener(this::addRecord);
        add(addButton);

        saveButton = new JButton("保存數據");
        saveButton.addActionListener(this::saveData);
        add(saveButton);

        listButton = new JButton("列出記錄");
        listButton.addActionListener(this::listRecords);
        add(listButton);

        textArea = new JTextArea(15, 50);
        add(new JScrollPane(textArea));

        // 添加窗口监听器，在窗口关闭时显示 CSV 文件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                showCSVFile();
                super.windowClosing(e);
            }
        });

        setVisible(true);
    }

    private void loadExistingRecords() {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            reader.readLine(); // 跳过表头
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0];
                    double height = Double.parseDouble(parts[1]);
                    double weight = Double.parseDouble(parts[2]);
                    double bmi = Double.parseDouble(parts[3]);
                    records.add(new BMIRecord(name, height, weight, bmi));
                }
            }
        } catch (IOException e) {
            textArea.setText("加载现有记录时出错: " + e.getMessage());
        }
    }

    private void addRecord(ActionEvent e) {
        String name = nameField.getText();
        double height;
        double weight;
        try {
            height = Double.parseDouble(heightField.getText());
            weight = Double.parseDouble(weightField.getText());
        } catch (NumberFormatException ex) {
            textArea.setText("身高或體重輸入無效。請輸入有效的數字。");
            return;
        }

        double bmi = calculateBMI(height, weight);
        BMIRecord record = new BMIRecord(name, height, weight, bmi);
        records.add(record);
        
        // 保存記錄到 CSV 文件
        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile, true))) {
            writer.printf("%s,%.2f,%.2f,%.2f%n", record.getName(), record.getHeight(), record.getWeight(), record.getBmi());
        } catch (IOException ex) {
            textArea.setText("保存記錄时出错: " + ex.getMessage());
            return;
        }
        
        textArea.setText(String.format("記錄已新增: %s - 身高: %.2f cm, 體重: %.2f kg, BMI: %.2f\n", name, height, weight, bmi));
        
        // 列出所有记录
        listRecords(null);
    }

    private double calculateBMI(double height, double weight) {
        height = height / 100;  // 转换为米
        return Math.round((weight / (height * height)) * 100.0) / 100.0;
    }

    private void saveData(ActionEvent e) {
        textArea.setText("數據已保存到 " + csvFile.getAbsolutePath());
    }

    private void listRecords(ActionEvent e) {
        StringBuilder builder = new StringBuilder("所有記錄:\n");
        for (BMIRecord record : records) {
            builder.append(String.format("姓名: %s, 身高: %.2f cm, 體重: %.2f kg, BMI: %.2f%n",
                    record.getName(), record.getHeight(), record.getWeight(), record.getBmi()));
        }
        textArea.setText(builder.toString());
    }

    private void showCSVFile() {
        try {
            Desktop.getDesktop().open(csvFile);
        } catch (IOException ex) {
            textArea.setText("打开文件时出错: " + ex.getMessage());
        }
    }
}

class BMIRecord {
    private String name;
    private double height;
    private double weight;
    private double bmi;

    public BMIRecord(String name, double height, double weight, double bmi) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getBmi() {
        return bmi;
    }
}
