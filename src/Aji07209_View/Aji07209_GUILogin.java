package Aji07209_View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Aji07209_GUILogin extends JFrame{
    JLabel login1;
    JTextField textniklogin,textnamalogin;
    JLabel niklabel,namalabel;
    JButton login,back;
    
    public Aji07209_GUILogin(){
        setSize(500, 500);
        setLayout(null);
        getContentPane().setBackground(Color.GRAY);
        login1 = new JLabel("Login Korban");
        login1.setBounds(140, 30, 600, 50);
        login1.setFont(new Font("Eras Demi ITC",Font.BOLD,30));
        login1.setForeground(Color.cyan);
        add(login1);        
        niklabel = new JLabel("NIK");
        niklabel.setBounds(150, 80, 100, 30);
        niklabel.setFont(new Font("Arial Black",Font.BOLD,15));
        add(niklabel);
        textniklogin = new JTextField();
        textniklogin.setBounds(150, 120, 200, 30);
        textniklogin.setFont(new Font("Arial ",Font.PLAIN,13));
        add(textniklogin);
        namalabel = new JLabel("Nama");
        namalabel.setBounds(150, 160, 200, 30);
        namalabel.setFont(new Font("Arial Black",Font.BOLD,15));
        add(namalabel);
        textnamalogin = new JTextField();
        textnamalogin.setBounds(150, 200, 200, 30);
        textnamalogin.setFont(new Font("Arial ",Font.PLAIN,13));
        add(textnamalogin);        
        login = new JButton("Login");
        login.setBounds(200, 260, 100, 40);
        login.setFont(new Font("Comic Sans MS",Font.BOLD,17));
        login.setBackground(Color.yellow);
        add(login);
        back = new JButton("Back");
        back.setBounds(30, 360, 80, 30);
        back.setFont(new Font("Comic Sans MS",Font.BOLD,13));
        back.setBackground(Color.red);
        back.setForeground(Color.white);
        add(back);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        
        
         login.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    try{
                        Aji07209_allobjctrl.korban.login(textniklogin.getText(), textnamalogin.getText());
                        String nama = Aji07209_allobjctrl.korban.getData().getAji07209_nama();
                        JOptionPane.showMessageDialog(null,"Selamat Datang "+nama,"information",JOptionPane.INFORMATION_MESSAGE);
                        Aji07209_GUIView view = new Aji07209_GUIView();
                        dispose();
                    }catch(Exception exception){
                        JOptionPane.showMessageDialog(null,"NIK atau Nama Salah","information",JOptionPane.INFORMATION_MESSAGE);
                        kosong();
                }
            }
            
        });
         back.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Aji07209_GUIBeranda gui = new Aji07209_GUIBeranda();
            }         
        });
    }
    void kosong(){
        textniklogin.setText(null);
        textnamalogin.setText(null);
    }
}