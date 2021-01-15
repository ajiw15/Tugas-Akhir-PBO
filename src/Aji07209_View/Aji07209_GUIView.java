package Aji07209_View;

import Aji07209_Entity.Aji07209_StatusEntity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class Aji07209_GUIView extends JFrame{
    JButton back,dftrbtn;
    JTextArea area = new JTextArea();
    JLabel datakorban,daftarstatus;
    JComboBox pilstatus = new JComboBox(Aji07209_StatusEntity.Aji07209_Status);
    int cek = Aji07209_allobjctrl.korban.cekDataKorban(Aji07209_allobjctrl.korban.korban().getAji07209_nik());
    
    public Aji07209_GUIView(){
        setSize(720, 600);
        setLayout(null);
        getContentPane().setBackground(Color.GRAY);
        datakorban = new JLabel("Data Korban");
        datakorban.setFont(new Font("Eras Demi ITC",Font.BOLD,30));
        datakorban.setForeground(Color.cyan);
        datakorban.setBounds(120, 30, 250, 30);
        add(datakorban);
        area.setBounds(30, 90, 400, 300);
        area.setBackground(Color.white);
        area.setFont(new Font("Times New Roman",Font.BOLD,16));
        add(area);
        daftarstatus = new JLabel("Daftar Status");
        daftarstatus.setBounds(455, 30, 250, 30);
        daftarstatus.setFont(new Font("Eras Demi ITC",Font.BOLD,30));
        daftarstatus.setForeground(Color.cyan);
        add(daftarstatus);
        pilstatus.setBounds(450, 90, 230, 30);
        pilstatus.setFont(new Font("Arial Black",Font.BOLD,13));
        pilstatus.setBackground(Color.yellow);
        add(pilstatus);
        dftrbtn = new JButton("Daftar");
        dftrbtn.setBounds(500, 150, 100, 30);
        dftrbtn.setFont(new Font("Comic Sans MS",Font.BOLD,17));
        dftrbtn.setBackground(Color.yellow);
        add(dftrbtn);
        back = new JButton("Back");
        back.setBounds(30, 450, 80, 30);
        back.setFont(new Font("Comic Sans MS",Font.BOLD,13));
        back.setBackground(Color.red);
        back.setForeground(Color.white);
        add(back);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        if(cek==-1){
           JOptionPane.showMessageDialog(null, "Anda Belum Daftar Status","information",JOptionPane.INFORMATION_MESSAGE);
        }else if(cek==-2){
            JOptionPane.showMessageDialog(null, "Anda Belum Daftar Status","information",JOptionPane.INFORMATION_MESSAGE);
        }else{
            area.setText(datakorban());
        }
        dftrbtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int indexstatus = pilstatus.getSelectedIndex();
                Aji07209_allobjctrl.korban.daftarstatus(indexstatus, Aji07209_allobjctrl.korban.getData());
                area.setText(datakorban());                
            }         
        });
        
        back.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Aji07209_GUIBeranda utama = new Aji07209_GUIBeranda();
            }         
        });
    }
        
        String datakorban(){
        int cek = Aji07209_allobjctrl.korban.cekDataKorban(Aji07209_allobjctrl.korban.korban().getAji07209_nik());
        String text = "\n NIK = "+Aji07209_allobjctrl.korban.showDataKorban(cek).getKorban().getAji07209_nik()
        +"\n"+ " Nama = "+Aji07209_allobjctrl.korban.showDataKorban(cek).getKorban().getAji07209_nama()+"\n"
        + " Pekerjaan = "+Aji07209_allobjctrl.korban.showDataKorban(cek).getKorban().getAji07209_pekerjaan()+"\n"
        + " Golongan Darah = "+Aji07209_allobjctrl.korban.showDataKorban(cek).getKorban().getAji07209_goldarah()+"\n"
        + " Agama = "+Aji07209_allobjctrl.korban.showDataKorban(cek).getKorban().getAji07209_agama()+"\n"
        + " Jenis Kelamin = "+Aji07209_allobjctrl.korban.showDataKorban(cek).getKorban().getAji07209_jeniskelamin()+"\n"
        + " No Telp = "+Aji07209_allobjctrl.korban.showDataKorban(cek).getKorban().getAji07209_notelp()+"\n"
        + " Tanggal Lahir = "+new SimpleDateFormat("dd-MM-yyyy").format(Aji07209_allobjctrl.korban.showDataKorban(cek).getKorban().getAji07209_TglLahir())
        +"\n"+ " Bantuan = "+Aji07209_allobjctrl.korban.showDataKorban(cek).getKorban().getAji07209_bantuan()
        +"\n"+ " Status = "+Aji07209_StatusEntity.Aji07209_Status[Aji07209_allobjctrl.korban.showDataKorban(cek).getIndexStatus()];
        return text;
    }
}