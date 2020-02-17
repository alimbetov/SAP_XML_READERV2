/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;


import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

 
public final class Data_xml_loader extends Application {
    
   ETL myETL = new ETL();   
    
 final  TextArea textArea = new TextArea();
 
 final  TextArea textAreaER = new TextArea();
 final  TextField tf = new TextField(); 
 
 
    private Desktop desktop = Desktop.getDesktop();
 int reccount=0;
    @Override
    public void start(final Stage stage) {
        stage.setTitle("File.XML Exporter[schema_pg_dwh.tbl_sap_xml_docs]");
      final FileChooser fileChooser = new FileChooser();
      final   FileChooser.ExtensionFilter csv_fExtensionFilter =  new FileChooser.ExtensionFilter( "xml Files (.xml)", "*.xml");

        
        tf.setText("старший оператор Амина Аутова");
        
        final Button openButton = new Button("Open a XML File (.xml)");
        final Button openMultipleButton = new Button("Open a XML Files (.xml)");

        openButton.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                   fileChooser.setSelectedExtensionFilter(csv_fExtensionFilter);
                    File file = fileChooser.showOpenDialog(stage);
 
                    if (file != null) {
                        ReadXMLFile(file);
                    }
                }
            });
 
        openMultipleButton.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    fileChooser.setSelectedExtensionFilter(csv_fExtensionFilter);
                    List<File> list = fileChooser.showOpenMultipleDialog(stage);
                    if (list != null) {
                        
                        
                        for (File file : list) {
                            ReadXMLFile(file);
                            System.out.println("mark1");
                        }


                     myETL.pushDataFinal();   
                     textArea.setText(myETL.get_DB_TEXT());
                     textAreaER.setText(myETL.get_ERR_TEXT());
                     
                     
                     
                    }
                }
            });
 
 
        final GridPane inputGridPane = new GridPane();
 
        GridPane.setConstraints(tf, 1, 0);
        GridPane.setConstraints(openMultipleButton, 1, 1);
        
        
         textArea.setStyle("-fx-font-size: 11px;");
         textAreaER.setStyle("-fx-font-size: 15px;");
      
        
        
        GridPane.setConstraints(textArea, 1, 2);
        GridPane.setConstraints(textAreaER, 1, 3);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(tf, openMultipleButton,textArea, textAreaER);
 
        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));
 
        stage.setScene(new Scene(rootGroup));
        stage.show();
        
    }
 
    public static void main(String[] args) {
        Application.launch(args);
    }
 
   public static int countOccurrences(String haystack, char needle)
{
    int count = 0;
    for (int i=0; i < haystack.length(); i++)
    {
        if (haystack.charAt(i) == needle)
        {
             count++;
        }
    }
    return count;
} 
 
   private void ReadXMLFile(File file)   {
   
       ReadXMLFile myXmlPars=new ReadXMLFile();
     try {
         
        
         XmlDocument xmlDocument=myXmlPars.getMydoc(file);
       if (tf.getText().length()==0){tf.setText("");}
         xmlDocument.setSignedConten_operatorFullname(tf.getText());
         myETL.add_DataRow(xmlDocument);
         xmlDocument.setErr(0);
         myETL.pushData();
     
        
      
     } catch (SAXException ex) {
           textArea.setText(textArea.getText()+" "+ file.getName() + "ERR:"+ ex);
         Logger.getLogger(Data_xml_loader.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IOException ex) {
          textArea.setText(textArea.getText()+" "+ file.getName() + "ERR:"+ ex);
         Logger.getLogger(Data_xml_loader.class.getName()).log(Level.SEVERE, null, ex);
     }
       
       
       
    }

}