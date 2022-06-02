package Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class view extends JFrame {
        JLabel ljudul = new JLabel("Judul");
        JLabel lalur = new JLabel("Alur");
        JLabel lpenokohan = new JLabel("Penokohan");
        JLabel lakting = new JLabel("Akting");

        public JTextField tfjudul = new JTextField();
        public JTextField tfalur = new JTextField();
        public JTextField tfpenokohan = new JTextField();
        public JTextField tfakting = new JTextField();

        public JButton btnTambah = new JButton("Tambah");
        public JButton btnUpdate = new JButton("Update");
        public JButton btnDelete = new JButton("Delete");
        public JButton btnReset = new JButton("Clear");

        public JTable tabel;
        DefaultTableModel dtm;
        JScrollPane scrollPane;
        public Object namaKolom[] = {"Judul", "Alur", "Penokohan", "Akting", "Nilai"};

        public view() {
            dtm = new DefaultTableModel(namaKolom, 0);
            tabel = new JTable(dtm);
            scrollPane = new JScrollPane(tabel);

            setTitle("Data Film");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
            setResizable(false);
            setLayout(null);
            setSize(745,500);
            setLocationRelativeTo(null);

            add(scrollPane);
            scrollPane.setBounds(20, 20, 570, 400);

            add(ljudul);
            ljudul.setBounds(600, 20, 90, 20);
            add(tfjudul);
            tfjudul.setBounds(600, 40, 120, 20);

            add(lalur);
            lalur.setBounds(600, 60, 90, 20);
            add(tfalur);
            tfalur.setBounds(600, 80, 120, 20);

            add(lpenokohan);
            lpenokohan.setBounds(600, 100, 90, 20);
            add(tfpenokohan);
            tfpenokohan.setBounds(600, 120, 120, 20);

            add(lakting);
            lakting.setBounds(600, 140, 90, 20);
            add(tfakting);
            tfakting.setBounds(600, 160, 120, 20);

            add(btnTambah);
            btnTambah.setBounds(600, 270, 90, 20);

            add(btnUpdate);
            btnUpdate.setBounds(600, 300, 90, 20);

            add(btnDelete);
            btnDelete.setBounds(600, 330, 90, 20);

            add(btnReset);
            btnReset.setBounds(600, 360, 90, 20);
        }

        public String getJudul(){ return tfjudul.getText();
        }

        public int getAlur(){
            if(tfalur.getText().isEmpty()) {
                int al = 0;
                return al;
            }
            else return Integer.parseInt(tfalur.getText());
        }

        public int getPenokohan(){
            if(tfpenokohan.getText().isEmpty()){
                int pe = 0;
                return pe;
             }
            else return Integer.parseInt(tfpenokohan.getText());
        }

        public int getAkting(){
            if(tfakting.getText().isEmpty()){
                int ak = 0;
                return ak;
            }
            else{
                return Integer.parseInt(tfakting.getText());
            }

        }
}
