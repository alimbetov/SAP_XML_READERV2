/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class ETL implements ETL_DAO{
 public static volatile ArrayList<XmlDocument> myDataRowList = new ArrayList<XmlDocument>();
 public static volatile HashMap<String, Integer> errFilelist = new HashMap<String, Integer>();
 public static volatile  HashMap<String, Integer> loadeFilelist = new HashMap<String, Integer>();
  public void add_DataRow(XmlDocument myDataRow) {
        this.myDataRowList.add(myDataRow);
        
    }
  
   public void add_DataERow(XmlDocument myDataRow) {
       this.errFilelist.put(myDataRow.getFileName(), myDataRow.getErr());
        
    }
   
      public void add_DatadbLOAD(XmlDocument V_myDataRow) {
       this.loadeFilelist.put(V_myDataRow.getFileName(), V_myDataRow.getErr());
    }
      public void del_DataERow(XmlDocument V_myDataRow) {
       this.errFilelist.remove(V_myDataRow.getFileName());
    }
    
      
         public void clear_ERR_TEXT() {  
        this.errFilelist.clear();
        } 
         public void clear_DB_TEXT() {  
        this.loadeFilelist.clear();
        }   
         
        public String get_ERR_TEXT() {
              String result="";
            if (errFilelist.size()>0){
                result="Error LIST:"+"\n"; 
                for (String key : errFilelist.keySet()) {
               result=result+key+";\n"; 
             } 
              this.clear_ERR_TEXT();  
            }
           
           return  result;
    }  
    
                public String get_DB_TEXT() {
              String result="";
            if (loadeFilelist.size()>0){
                result="DB LIST:"+"\n"; 
                for (String key : loadeFilelist.keySet()) {
               result=result+key+";\n"; 
             } 
              this.clear_DB_TEXT();  
            }
           
           return  result;
    }  
        
   public void pushData() {
       if (this.myDataRowList.size()>100){
            System.out.println("Push Start by pushData" );
            for(XmlDocument v: this.myDataRowList){

              this.Start_push(v);
            }
             this.myDataRowList.clear();
            
            
            
         }
    } 
    public void pushDataFinal() {
       if (this.myDataRowList.size()>0){
            System.out.println("Push Start by pushDataFinal" );

            for(XmlDocument v: this.myDataRowList){

                System.out.println("*** mark2");

              this.Start_push(v);
            }
             this.myDataRowList.clear();
            
            
            
         }
            
            
    } 
   
     private void  Start_push(XmlDocument myDataRow) {
       
        String sql = "";
    Connection con = null;
      Statement stmt = null;
     try {
            Class.forName(DRIVER);
             con = DriverManager.getConnection
                    (DB_URL, USER, PASS);
             stmt = (Statement) con.createStatement();   

     myDataRow.setErr(1);
     this.add_DataERow(myDataRow);



sql="DELETE from  schema_pg_dwh.tbl_sap_xml_docs T WHERE T.DOC_DATE="+data_col_form(myDataRow.getSignedConten_date(),1)+" " +
        "AND T.DOC_NUMBER=LTRIM("+data_col_form(myDataRow.getSignedConten_num(),3)+",'0')";

         System.out.println("*DELETE *"+sql);

stmt.executeUpdate(sql);

sql="insert into schema_pg_dwh.tbl_sap_xml_docs\n" +
"  (cycle_year_month,\n" +
"   doc_date,\n" +
"   doc_number,\n" +
"   month,\n" +
"   year,\n" +
"   currency_code,\n" +
"   executor_eds,\n" +
"   executor_name,\n" +
"   related_doc_id,\n" +
"   amount,\n" +
"   price_without_vat,\n" +
"   services,\n" +
        
"   turnover_size,\n" +
"   unit_price,\n" +
"   vat_amount,\n" +
"   vat_rate,\n" +
"   customer_addr,\n" +
"   customer_bin,\n" +
"   customer_id,\n" +
"   customer_name,\n" +
"   customer_type,\n" +
"   filial_addr,\n" +
"   filial_bank_name,\n" +
"   filial_bik,\n" +
"   filial_bin,\n" +
"   filial_full_name,\n" +
        
"   filial_iik,\n" +
"   filial_kbe,\n" +
"   filial_name,\n" +
"   filial_vat_num,\n" +
"   filial_vat_series,\n" +
"   services_date,\n" +
        
"   esf_type,\n" +
"   agr_date,\n" +
"   agr_number)\n" +
"values\n" +
"  ( " + data_col_form(myDataRow.getYear(),2) + " * 100 + " + data_col_form(myDataRow.getMonth(),2) + ",\n" +
" "+ data_col_form(myDataRow.getSignedConten_date(),1) +",\n" +
" "+ data_col_form(myDataRow.getSignedConten_num(),2) +",\n" +
" "+ data_col_form(myDataRow.getMonth(),2) +",\n" +
" "+ data_col_form(myDataRow.getYear(),2) +",\n" +
" "+ data_col_form(myDataRow.getProducts_currencyCode(),3) +",\n" +
" "+ data_col_form(myDataRow.getSignedConten_signatureType(),3) +",\n" +
" "+ data_col_form(myDataRow.getSignedConten_operatorFullname(),3) +",\n" +
" "+ data_col_form(myDataRow.getRelatedInvoice_num(),3) +",\n" +
" "+ data_col_form(myDataRow.getProducts_priceWithTax(),4) +",\n" +
" "+ data_col_form(myDataRow.getProducts_totalPriceWithoutTax(),4) +",\n" +
" "+ data_col_form(myDataRow.getProducts_description(),3) +",\n" +
" "+ data_col_form(myDataRow.getProducts_totalTurnoverSize(),4) +",\n" +
" "+ data_col_form(myDataRow.getProducts_totalPriceWithoutTax(),4) +",\n" +
" "+ data_col_form(myDataRow.getProducts_ndsAmount(),4) +",\n" +
" "+ data_col_form(myDataRow.getProducts_ndsRate(),4) +",\n" +
" "+ data_col_form(myDataRow.getCustomer_address(),3) +",\n" +       
" "+ data_col_form(myDataRow.getCustomer_tin(),3) +",\n" +
" "+ data_col_form(myDataRow.getCustomer_id(),3) +",\n" +
" "+ data_col_form(myDataRow.getCustomer_name(),3) +",\n" +     
" "+ data_col_form(myDataRow.getCustomer_status(),3) +",\n" +  
" "+ data_col_form(myDataRow.getSellers_address(),3) +",\n" +     
" "+ data_col_form(myDataRow.getSellers_bank(),3) +",\n" +   
" "+ data_col_form(myDataRow.getSellers_bik(),3) +",\n" +  
" "+ data_col_form(myDataRow.getSellers_tin(),3) +",\n" +  
" "+ data_col_form(myDataRow.getSellers_name(),3) +",\n" +  
" "+ data_col_form(myDataRow.getSellers_iik(),3) +",\n" +
" "+ data_col_form(myDataRow.getSellers_kbe(),3) +",\n" +
" "+ data_col_form(myDataRow.getSellers_name(),3) +",\n" +
" "+ data_col_form(myDataRow.getSellers_certificateNum(),3) +",\n" +
" "+ data_col_form(myDataRow.getSellers_certificateSeries(),3) +",\n" +
" "+ data_col_form(myDataRow.getSignedConten_turnoverDate(),1) +",\n" +
" "+ data_col_form(myDataRow.getSignedConten_invoiceType(),3) +",\n" +
" "+ data_col_form(myDataRow.getDeliveryTerm_contractDate(),1) +",\n" +
" "+ data_col_form(myDataRow.getDeliveryTerm_contractNum(),3)  + ")";

         System.out.println(sql);
stmt.executeUpdate(sql);
myDataRow.setErr(0);
 this.del_DataERow(myDataRow);
 this.add_DatadbLOAD(myDataRow);
               
            con.close();
        } catch (Exception e) {
            
          

        }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            con.close();
      }catch(SQLException se){
        
      }// do nothing
      try{
         if(con!=null)
            con.close();
      }catch(SQLException se){
          System.out.println(se);
      }//end finally try
   }//end 
    
 
     } 
  
  String data_col_form (String col, int typc) {
  String result="null";
  
  if (!col.equals("")){
  if (typc==1){
  result=" to_date(\'"+col.trim() +"\', 'dd.mm.yyyy')";
  }
  if (typc==2){
   if(col.indexOf(".")!=-1)
             {
            col=col.replaceAll("\\.", ",");
        
             }
  result=" to_number(\'"+ col +"\','9999999999')";
  }
  if (typc==4){
          if(col.indexOf(".")!=-1)
          {
              col=col.replaceAll("\\.", ",");

          }
          result=" to_number(\'"+ col +"\','9999999999.99')";
      }

  if (typc==3){
  result=" \'"+col.trim() +"\'";
  }
  }

  if (col.equals("")){
          if (typc==4){
              result=" to_number('0','9999999999.99')";
          }
          if (typc==3){
              result= result;
          }
      }
      return result;
  }


}
