package cores.webCam.view;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author QUOC HUY
 */
public class viewWebCam extends javax.swing.JFrame {

    /**
     * Creates new form viewWebCam
     */
    private WebcamPanel jpanl = null;
    private Webcam webcam1;

    public viewWebCam() {
        initComponents();
        String input = JOptionPane.showInputDialog(this, "Mời bạn chọn cổng (Ví dụ: 0, 1, 2, ... => Cổng mạc định là 0)", "Lựa chọn !!!", JOptionPane.QUESTION_MESSAGE);
        int cong = 0;
        try {
            cong = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        initWebCame(cong);
    }

    public void initWebCame(int cong) {
        try {
            webcam1 = Webcam.getWebcams().get(cong); // Camera 1
            webcam1.setViewSize(WebcamResolution.VGA.getSize()); // set size
            jpanl = new WebcamPanel(webcam1);
            webcam1.open();

            mainCam.add(jpanl);
            mainCam.setLayout(new FlowLayout());
            this.pack();
            jpanl.setVisible(true);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Cam không có kết nối");
            e.printStackTrace();
            this.setVisible(false);
            webcam1.close();
        }

    }
    
        // Function to read the QR file
    public static String readQR(String path, String charset,
                                Map hashMap)
        throws FileNotFoundException, IOException,
               NotFoundException
    {
        BinaryBitmap binaryBitmap
            = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(
                    ImageIO.read(
                        new FileInputStream(path)))));
 
        Result result
            = new MultiFormatReader().decode(binaryBitmap);
 
        return result.getText();
    }

    public void test() throws IOException, FileNotFoundException, NotFoundException {
        BufferedImage image = webcam1.getImage();
//        Thread.sleep(3000);
        File fileImg = new File("D:\\Du_an_1\\src\\main\\resources\\cde.png");
        ImageIO.write(image, "png", fileImg);

            
        // The path where the image will get saved
        String path = "D:\\Du_an_1\\src\\main\\resources\\cde.png";

        // Encoding charset
        String charset = "UTF-8";
        
        Map<EncodeHintType, ErrorCorrectionLevel> hashMap 
                = new HashMap<>();
        
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        
        System.out.println("aaaaa" + readQR(path, charset, hashMap));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new utilities.palette.PanelRound();
        mainCam = new javax.swing.JPanel();
        buttonGradient1 = new utilities.palette.ButtonGradient();
        jLabel1 = new javax.swing.JLabel();
        uWPButton1 = new utilities.palette.UWPButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRound1.setBackground(new java.awt.Color(221, 242, 244));
        panelRound1.setOpaque(true);
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        javax.swing.GroupLayout mainCamLayout = new javax.swing.GroupLayout(mainCam);
        mainCam.setLayout(mainCamLayout);
        mainCamLayout.setHorizontalGroup(
            mainCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
        );
        mainCamLayout.setVerticalGroup(
            mainCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );

        buttonGradient1.setText("Chụp");
        buttonGradient1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        buttonGradient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGradient1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("* note: nhấn chụp và đợi 3 giây");

        uWPButton1.setBackground(new java.awt.Color(255, 51, 51));
        uWPButton1.setText("X");
        uWPButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(uWPButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mainCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(buttonGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(81, Short.MAX_VALUE))))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(uWPButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(mainCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uWPButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton1ActionPerformed
        this.setVisible(false);
        webcam1.close();
        System.exit(0);
    }//GEN-LAST:event_uWPButton1ActionPerformed

    private void buttonGradient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGradient1ActionPerformed
        try {
            test();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException ex) {
            Logger.getLogger(viewWebCam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonGradient1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(viewWebCam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewWebCam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewWebCam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewWebCam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewWebCam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.palette.ButtonGradient buttonGradient1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mainCam;
    private utilities.palette.PanelRound panelRound1;
    private utilities.palette.UWPButton uWPButton1;
    // End of variables declaration//GEN-END:variables
}
