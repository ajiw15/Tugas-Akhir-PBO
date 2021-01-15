package Aji07209_Model;

import Aji07209_Entity.Aji07209_KorbanEntity;
import java.util.ArrayList;

public class Aji07209_KorbanModel implements Aji07209_ModelInterfaces {
    private ArrayList<Aji07209_KorbanEntity> korbanEntityArrayList;
    
    public Aji07209_KorbanModel(){
        korbanEntityArrayList = new ArrayList<Aji07209_KorbanEntity>();
    }
public void insert(Aji07209_KorbanEntity korban){
    korbanEntityArrayList.add(korban);  
}

    @Override
 public void login(){
        for(Aji07209_KorbanEntity korbanEntity : korbanEntityArrayList){
            System.out.println("===========================================");
            System.out.println(" NIK : "+korbanEntity.getAji07209_nik()+"\n Nama : "
            +korbanEntity.getAji07209_nama()+"\n Pekerjaan : "+korbanEntity.getAji07209_pekerjaan()+
            "\n Golongan Darah : "+korbanEntity.getAji07209_goldarah()+"\n Agama : "+korbanEntity.getAji07209_agama()+
            "\n Jenis Kelamin : "+korbanEntity.getAji07209_jeniskelamin()+"\n No Telp : "
            +korbanEntity.getAji07209_notelp()+"\n Tanggal Lahir : "+korbanEntity.getAji07209_TglLahir());
            System.out.println("===========================================");
        }
    }
 public int cekData(String nik, String nama){
        int loop = 0;
        while (!korbanEntityArrayList.get(loop).getAji07209_nik().equals(nik) && 
                !korbanEntityArrayList.get(loop).getAji07209_nama().equals(nama)){
            loop++;
        }
        return loop;
    }
    public Aji07209_KorbanEntity getkorbanEntityArrayList(int index){
        return korbanEntityArrayList.get(index);
    }
    private int carinik(String Aji07209_nik){
        int index=-1;
        for(int i=0;i <korbanEntityArrayList.size();i++) {
           if(Aji07209_nik.equals(korbanEntityArrayList.get(i).getAji07209_nik()))
               index=i;
           break;
       }
       return index;
    }
    public int hapus(String Aji07209_nik){
            int data;
        if(carinik(Aji07209_nik)!=-1){
             korbanEntityArrayList.remove(carinik(Aji07209_nik));
             data=1;
        }else{
            data=0;
          }        
        return data;
    }
}
