import java.awt.Color;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

public class AplikasiCekCuaca extends javax.swing.JFrame {
    static class WeatherData {
        String kota;
        String kondisi;
        double suhu;
        String waktu;

        public WeatherData(String kota, String kondisi, double suhu) {
            this.kota = kota;
            this.kondisi = kondisi;
            this.suhu = suhu;
            this.waktu = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        }
    }

    private DefaultTableModel tableModel;
    private List<String> favoriteCities = new ArrayList<>();
    private List<WeatherData> weatherHistory = new ArrayList<>();

    private static final String API_KEY = "7fb787c8360560fa6301d33c544e1eda";
    private static final String WEATHER_FILE = "weather_history.csv";

    public AplikasiCekCuaca() {
        initComponents();

        // Inisialisasi tabel
        String[] columns = {"Kota", "Kondisi", "Suhu (°C)", "Waktu"};
        tableModel = new DefaultTableModel(columns, 0);
        tblHistori.setModel(tableModel);
        tblHistori.setRowHeight(25);

        // Styling
        getContentPane().setBackground(new Color(245, 248, 250));
        btnCekCuaca.setBackground(new Color(70, 130, 180));
        btnCekCuaca.setForeground(Color.WHITE);
        btnTambahFavorit.setBackground(new Color(255, 215, 0));
        btnTambahFavorit.setForeground(Color.BLACK);
        lblIconCuaca.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 2));

        // Listener untuk combo box
        cmbFavorit.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedCity = (String) cmbFavorit.getSelectedItem();
                if (selectedCity != null && !selectedCity.isEmpty()) {
                    txtKota.setText(selectedCity);
                    cekCuaca();
                }
            }
        });
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblKota = new javax.swing.JLabel();
        txtKota = new javax.swing.JTextField();
        btnCekCuaca = new javax.swing.JButton();
        lblFavorit = new javax.swing.JLabel();
        cmbFavorit = new javax.swing.JComboBox<>();
        btnTambahFavorit = new javax.swing.JButton();
        lblCuaca = new javax.swing.JLabel();
        lblSuhu = new javax.swing.JLabel();
        lblIconCuaca = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        scrollHistori = new javax.swing.JScrollPane();
        tblHistori = new javax.swing.JTable();
        btnSimpanCSV = new javax.swing.JButton();
        btnMuatCSV = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Cek Cuaca Sederhana");
        setMinimumSize(new java.awt.Dimension(435, 530));
        setPreferredSize(new java.awt.Dimension(450, 520));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("APLIKASI CEK CUACA SEDERHANA");
        jPanel1.add(jLabel1, "card2");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 30));

        lblKota.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblKota.setText("Kota :");

        btnCekCuaca.setText("🔍 Cek Cuaca");
        btnCekCuaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekCuacaActionPerformed(evt);
            }
        });

        lblFavorit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFavorit.setText("Kota Favorit :");

        btnTambahFavorit.setText("⭐ Tambah ke Favorit");
        btnTambahFavorit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahFavoritActionPerformed(evt);
            }
        });

        lblCuaca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCuaca.setText("Kondisi : ");

        lblSuhu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSuhu.setText("Suhu : ");

        lblIconCuaca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconCuaca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        lblIconCuaca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblIconCuaca.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCuaca)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(lblKota, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtKota, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(lblFavorit)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cmbFavorit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(lblSuhu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblIconCuaca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTambahFavorit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCekCuaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKota, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCekCuaca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFavorit)
                    .addComponent(cmbFavorit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambahFavorit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCuaca)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSuhu)
                    .addComponent(lblIconCuaca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 430, 230));

        tblHistori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kota", "Kondisi", "Suhu", "Waktu"
            }
        ));
        scrollHistori.setViewportView(tblHistori);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollHistori, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollHistori, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 430, 160));

        btnSimpanCSV.setText("💾 Simpan ke CSV");
        btnSimpanCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanCSVActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpanCSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, -1, -1));

        btnMuatCSV.setText("📂 Muat dari CSV");
        btnMuatCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuatCSVActionPerformed(evt);
            }
        });
        getContentPane().add(btnMuatCSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCekCuacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekCuacaActionPerformed
        cekCuaca();
    }//GEN-LAST:event_btnCekCuacaActionPerformed

    private void btnTambahFavoritActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahFavoritActionPerformed
        tambahKeFavorit();
    }//GEN-LAST:event_btnTambahFavoritActionPerformed

    private void btnSimpanCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanCSVActionPerformed
        simpanKeCSV();
    }//GEN-LAST:event_btnSimpanCSVActionPerformed

    private void btnMuatCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatCSVActionPerformed
        muatDariCSV();
    }//GEN-LAST:event_btnMuatCSVActionPerformed
    
    private void cekCuaca() {
        String kota = txtKota.getText().trim();
        if (kota.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan nama kota!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String urlStr = "https://api.openweathermap.org/data/2.5/weather?q=" +
                    URLEncoder.encode(kota, "UTF-8") +
                    "&appid=" + API_KEY + "&units=metric&lang=id";

            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                JSONObject json = new JSONObject(response.toString());
                String kondisi = json.getJSONArray("weather").getJSONObject(0).getString("main");
                double suhu = json.getJSONObject("main").getDouble("temp");
                String iconCode = json.getJSONArray("weather").getJSONObject(0).getString("icon");

                lblCuaca.setText("Kondisi: " + kondisi);
                lblSuhu.setText("Suhu: " + String.format("%.1f", suhu) + "°C");

                tampilkanIkonCuaca(iconCode);

                weatherHistory.add(new WeatherData(kota, kondisi, suhu));
                updateTabel();

            } else {
                JOptionPane.showMessageDialog(this, "Kota tidak ditemukan atau API error.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal mengambil data cuaca. Periksa koneksi internet atau API Key.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void tampilkanIkonCuaca(String iconCode) {
        try {
            String iconUrl = "https://openweathermap.org/img/wn/" + iconCode + "@2x.png";
            ImageIcon icon = new ImageIcon(new URL(iconUrl));
            Image scaled = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            lblIconCuaca.setIcon(new ImageIcon(scaled));
        } catch (Exception e) {
            lblIconCuaca.setIcon(null);
            lblIconCuaca.setText("Icon");
        }
    }
    
    private void tambahKeFavorit() {
        String kota = txtKota.getText().trim();
        if (kota.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan nama kota terlebih dahulu!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!favoriteCities.contains(kota)) {
            favoriteCities.add(kota);
            cmbFavorit.addItem(kota);
            JOptionPane.showMessageDialog(this, "Kota \"" + kota + "\" ditambahkan ke favorit.");
        } else {
            JOptionPane.showMessageDialog(this, "Kota \"" + kota + "\" sudah ada di favorit.");
        }
    }
    
    private void simpanKeCSV() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(WEATHER_FILE))) {
            pw.println("Kota,Kondisi,Suhu,Waktu");
            for (WeatherData data : weatherHistory) {
                pw.printf("%s,%s,%.1f,%s%n", data.kota, data.kondisi, data.suhu, data.waktu);
            }
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke " + WEATHER_FILE, "Sukses", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     private void muatDariCSV() {
        weatherHistory.clear();
        tableModel.setRowCount(0);
        try (BufferedReader br = new BufferedReader(new FileReader(WEATHER_FILE))) {
            String line = br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String kota = parts[0];
                    String kondisi = parts[1];
                    double suhu = Double.parseDouble(parts[2]);
                    WeatherData data = new WeatherData(kota, kondisi, suhu);
                    weatherHistory.add(data);
                }
            }
            updateTabel();
            JOptionPane.showMessageDialog(this, "Data berhasil dimuat dari " + WEATHER_FILE, "Sukses", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "File " + WEATHER_FILE + " tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     
     private void updateTabel() {
        tableModel.setRowCount(0);
        for (WeatherData data : weatherHistory) {
            tableModel.addRow(new Object[]{
                    data.kota,
                    data.kondisi,
                    String.format("%.1f", data.suhu),
                    data.waktu
            });
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AplikasiCekCuaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplikasiCekCuaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplikasiCekCuaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplikasiCekCuaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikasiCekCuaca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCekCuaca;
    private javax.swing.JButton btnMuatCSV;
    private javax.swing.JButton btnSimpanCSV;
    private javax.swing.JButton btnTambahFavorit;
    private javax.swing.JComboBox<String> cmbFavorit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCuaca;
    private javax.swing.JLabel lblFavorit;
    private javax.swing.JLabel lblIconCuaca;
    private javax.swing.JLabel lblKota;
    private javax.swing.JLabel lblSuhu;
    private javax.swing.JScrollPane scrollHistori;
    private javax.swing.JTable tblHistori;
    private javax.swing.JTextField txtKota;
    // End of variables declaration//GEN-END:variables
}