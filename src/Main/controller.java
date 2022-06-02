package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class controller {
    model modelTrans;
    view transView;
    public String data;

    public controller(model modelTrans, view transView){
        this.modelTrans = modelTrans;
        this.transView = transView;

        if (modelTrans.getBanyakData()!=0) {
            String dataTrans[][] = modelTrans.readData();
            transView.tabel.setModel((new JTable(dataTrans, transView.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        transView.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Judul = transView.getJudul();
                int Alur = transView.getAlur();
                int Penokohan = transView.getPenokohan();
                int Akting = transView.getAkting();
                int Nilai = (Alur+Penokohan+Akting)/3;

                if(Judul.isEmpty() || Alur==0 || Penokohan==0 || Akting==0 || Nilai==0){
                    JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
                }
                else if(Alur > 5){
                    JOptionPane.showMessageDialog(null, "Input harus antara 0-5");
                }
                else if(Penokohan > 5){
                    JOptionPane.showMessageDialog(null, "Input harus antara 0-5");
                }
                else if(Akting > 5){
                    JOptionPane.showMessageDialog(null, "Input harus antara 0-5");
                }
                else if(Nilai > 5){
                    JOptionPane.showMessageDialog(null, "Input harus antara 0-5");
                }
                else{
                    modelTrans.insertData(Judul, Alur, Penokohan, Akting, Nilai);
                }


                String dataTrans[][] = modelTrans.readData();
                transView.tabel.setModel((new JTable(dataTrans, transView.namaKolom)).getModel());
            }
        });

        transView.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String Judul = transView.getJudul();
                int Alur = transView.getAlur();
                int Penokohan = transView.getPenokohan();
                int Akting = transView.getAkting();
                int Nilai = (Alur+Penokohan+Akting)/3;
                if(Judul.isEmpty() || Alur==0 || Penokohan==0 || Akting==0 || Nilai==0){
                    JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
                }
                else if(Alur > 5){
                    JOptionPane.showMessageDialog(null, "Input harus antara 0-5");
                }
                else if(Penokohan > 5){
                    JOptionPane.showMessageDialog(null, "Input harus antara 0-5");
                }
                else if(Akting > 5){
                    JOptionPane.showMessageDialog(null, "Input harus antara 0-5");
                }
                else if(Nilai > 5){
                    JOptionPane.showMessageDialog(null, "Input harus antara 0-5");
                }
                else{
                    modelTrans.updateData(Judul, Alur, Penokohan, Akting, Nilai);
                }

                String dataTrans[][] = modelTrans.readData();
                transView.tabel.setModel((new JTable(dataTrans, transView.namaKolom)).getModel());
            }
        });

        transView.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                transView.tfjudul.setText("");
                transView.tfalur.setText("");
                transView.tfpenokohan.setText("");
                transView.tfakting.setText("");
            }
        });


        transView.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);

                int baris = transView.tabel.getSelectedRow();
                data = transView.tabel.getValueAt(baris, 0).toString();
                String dataUpdate[] = new String[4];
                dataUpdate[0] = transView.tabel.getValueAt(baris, 0).toString();
                dataUpdate[1] = transView.tabel.getValueAt(baris, 1).toString();


                System.out.println(data);

            }
        });

        transView.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus " + data + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    modelTrans.deleteData(data);
                    String dataTrans[][] = modelTrans.readData();
                    transView.tabel.setModel((new JTable(dataTrans, transView.namaKolom)).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });
    }
}