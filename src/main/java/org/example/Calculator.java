package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
Клас Calculator імплементує ActionListener, для обробки подій
Поля класу: window - основне вікно, inText - текстове поле,
numbers - масив конопок - цифр, operations - операцій,
btnPlus, btnMinus, btnMultiply, btnDivide,
btnEquals, btnDelete, btnDot - самі операції,
panel - панель, у якії розміщено кнопки
 */
public class Calculator implements ActionListener{

    private static final int WINDOW_WIDTH = 410;
    private static final int WINDOW_HEIGHT = 500;

    JFrame window;
    JTextField inText;
    JButton[] numbers = new JButton[10];
    JButton[] operations = new JButton[7];
    JButton btnPlus, btnMinus, btnMultiply, btnDivide;
    JButton btnEquals, btnDelete, btnDot;

    JPanel panel;

    double x=0, y=0, res=0;
    char operation;

    /*
    Конструкотор калькулятора
    Реалізуються вікно, текстове поле (встановлюється розмір, та неможливість писати текст),
    кнопки (на які встановлюється "слухач" подій), панель (GridLayout(5, 4) - у панелі 5 рядків і 4 колонки,
    до панелі додаються кнопки).
    Панель та текстове поле додаються у вікно
     */
    public Calculator(){
        window = new JFrame("Calculator");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setLocationRelativeTo(null);
        window.setLayout(null);

        inText = new JTextField();
        inText.setBounds(50, 30, 300, 50);
        inText.setEditable(false);

        btnPlus = new JButton("+");
        btnMinus = new JButton("-");
        btnMultiply = new JButton("*");
        btnDivide = new JButton("/");
        btnEquals = new JButton("=");
        btnDelete = new JButton("del");
        btnDot = new JButton(".");

        operations[0]=btnPlus;
        operations[1]=btnMinus;
        operations[2]=btnMultiply;
        operations[3]=btnDivide;
        operations[4]=btnEquals;
        operations[5]=btnDelete;
        operations[6]=btnDot;

        for(JButton op : operations){
            op.addActionListener(this);
        }

        for(int i=0; i<10; i++){
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
        }

        panel = new JPanel();
        panel.setBounds(50, 100, WINDOW_WIDTH-100, WINDOW_HEIGHT-250);
        panel.setLayout(new GridLayout(5, 4));

        for(JButton num: numbers){
            panel.add(num);
        }

        for (JButton op: operations){
            panel.add(op);
        }

        window.add(panel);
        window.add(inText);
        window.setVisible(true);
    }

    /*
    Метод для додавання
     */

    public double plus(double a, double b){
        return a+b;
    }

    /*
    Метод для віднімання
     */

    public double minus(double a, double b){
        return a-b;
    }

    /*
    Метод для множення
     */

    public double multiply(double a, double b){
        return a*b;
    }

    /*
    Метод для ділення
     */

    public double divide(double a, double b){
        return a/b;
    }

    /*
    Метод main
    Створюється об'єкт класу Calculator
     */

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }

    /*
    Перевизначений метод для обробки подій

    Якщо натиснута одна з цифр, то у текстове поле встановлюється відповідна цифра

    Крапка - встановлюється крапка

    Якощо + - * /, то х дорівнюватиме значенню, яке знаходиться у текстовому полі,
    у полі встановлюється пустний рядок

    Якщо натиснута кнопка = , у дорівнюватиме значенню із текстового поля,
    switch case відповідно до попередньої операції викликє потрібну функцію,
    записує результат та вставляє у текстове поле

    При натисканні видалення значення х та у дорівнюють 0, у текстовому полі пустий рядок
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<10;i++){
            if(e.getSource()==numbers[i]){
                inText.setText(inText.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==btnDot){
            inText.setText((inText.getText().concat(".")));
        }
        if(e.getSource()==btnPlus){
            x = Double.parseDouble(inText.getText());
            operation = '+';
            inText.setText("");
        }
        if(e.getSource()==btnMinus){
            x = Double.parseDouble(inText.getText());
            operation = '-';
            inText.setText("");
        }
        if(e.getSource()==btnMultiply){
            x = Double.parseDouble(inText.getText());
            operation = '*';
            inText.setText("");
        }
        if(e.getSource()==btnDivide){
            x = Double.parseDouble(inText.getText());
            operation = '/';
            inText.setText("");
        }
        if(e.getSource()==btnEquals){
            y = Double.parseDouble(inText.getText());

            switch (operation){
                case '+':
                    res=plus(x,y);
                    break;
                case '-':
                    res=minus(x,y);
                    break;
                case '*':
                    res=multiply(x,y);
                    break;
                case '/':
                    res=divide(x,y);
            }
            inText.setText(String.valueOf(res));
            x=res;
        }
        if(e.getSource() == btnDelete){
            x=0;
            y=0;
            inText.setText("");
        }
    }
}