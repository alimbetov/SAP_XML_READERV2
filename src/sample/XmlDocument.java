/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

public class XmlDocument {
    

private String FileName="";
private int err=0;

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
    }



    public String getFileName() {
        return FileName;
    }
    
       public String getCustomer_id() {
           String result="0";
            if (FileName.indexOf("_")==-1){
          result=FileName.substring( (int) FileName.indexOf("bl.")+3 , FileName.length()-".yyyymm.xml".length()); 
          } else
          {result=FileName.substring( (int) FileName.indexOf("bl.")+3 , (int) FileName.indexOf("_"));
          } 
        return result;
    }
    	

    public void setFileName(String FileName) {
        this.FileName = FileName;
    }



    public String getYear() {
   String yyyy= signedConten_date.substring(signedConten_date.length()-4);
        return yyyy;
    }

   

    public String getMonth() {
          String mm=  signedConten_date.substring( signedConten_date.length()-7, signedConten_date.length()-5);  
        return mm;
    }

 

///Element :SignedContent
private String signedConten_date="";
private String signedConten_invoiceType="";
private String signedConten_num;
private String signedConten_operatorFullname="";
private String signedConten_signatureType="";
private String signedConten_turnoverDate="";

///Current Element :customer
private String customer_address="";
private String customer_certificateNum="";
private String customer_certificateSeries="";
private String customer_name="";
private String customer_status="";
private String customer_tin="";


///Current Element :deliveryTerm
private String deliveryTerm_contractDate="";
private String deliveryTerm_contractNum="";

///RelatedInvoice
private String  relatedInvoice_date="";
private String  relatedInvoice_num="";
        
///Current Element :products
private String products_description="";
private String products_ndsAmount="";
private String products_ndsRate="";
private String products_priceWithTax="";
private String products_priceWithoutTax="";
private String products_turnoverSize="";
private String products_currencyCode="";
private String products_totalExciseAmount="";
private String products_totalNdsAmount="";
private String products_totalPriceWithTax="";
private String products_totalPriceWithoutTax="";
private String products_totalTurnoverSize="";


///Current Element :sellers
private String  sellers_address="";
private String  sellers_bank="";
private String  sellers_bik="";
private String  sellers_certificateNum="";
private String  sellers_certificateSeries="";
private String  sellers_deliveryDocDate="";
private String  sellers_deliveryDocNum="";
private String  sellers_iik="";
private String  sellers_kbe="";
private String  sellers_name="";
private String  sellers_tin="";

    @Override
    public String toString() {
        return "XmlDocument{" + "signedConten_date=" + signedConten_date + ", signedConten_invoiceType=" + signedConten_invoiceType + ", signedConten_num=" + signedConten_num + ", signedConten_operatorFullname=" + signedConten_operatorFullname + ", signedConten_signatureType=" + signedConten_signatureType + ", signedConten_turnoverDate=" + signedConten_turnoverDate + ", customer_address=" + customer_address + ", customer_certificateNum=" + customer_certificateNum + ", customer_certificateSeries=" + customer_certificateSeries + ", customer_name=" + customer_name + ", customer_status=" + customer_status + ", customer_tin=" + customer_tin + ", deliveryTerm_contractDate=" + deliveryTerm_contractDate + ", deliveryTerm_contractNum=" + deliveryTerm_contractNum + ", relatedInvoice_date=" + relatedInvoice_date + ", relatedInvoice_num=" + relatedInvoice_num + ", products_description=" + products_description + ", products_ndsAmount=" + products_ndsAmount + ", products_ndsRate=" + products_ndsRate + ", products_priceWithTax=" + products_priceWithTax + ", products_priceWithoutTax=" + products_priceWithoutTax + ", products_turnoverSize=" + products_turnoverSize + ", products_currencyCode=" + products_currencyCode + ", products_totalExciseAmount=" + products_totalExciseAmount + ", products_totalNdsAmount=" + products_totalNdsAmount + ", products_totalPriceWithTax=" + products_totalPriceWithTax + ", products_totalPriceWithoutTax=" + products_totalPriceWithoutTax + ", products_totalTurnoverSize=" + products_totalTurnoverSize + ", sellers_address=" + sellers_address + ", sellers_bank=" + sellers_bank + ", sellers_bik=" + sellers_bik + ", sellers_certificateNum=" + sellers_certificateNum + ", sellers_certificateSeries=" + sellers_certificateSeries + ", sellers_deliveryDocDate=" + sellers_deliveryDocDate + ", sellers_deliveryDocNum=" + sellers_deliveryDocNum + ", sellers_iik=" + sellers_iik + ", sellers_kbe=" + sellers_kbe + ", sellers_name=" + sellers_name + ", sellers_tin=" + sellers_tin + '}';
    }




    public String getSignedConten_date() {
        return signedConten_date;
    }

    public void setSignedConten_date(String signedConten_date) {
        this.signedConten_date = signedConten_date;
    }

    public String getSignedConten_invoiceType() {
        return signedConten_invoiceType;
    }

    public void setSignedConten_invoiceType(String signedConten_invoiceType) {
        this.signedConten_invoiceType = signedConten_invoiceType;
    }

    public String getSignedConten_num() {
        return signedConten_num;
    }

    public void setSignedConten_num(String signedConten_num) {
        this.signedConten_num = signedConten_num;
    }

    public String getSignedConten_operatorFullname() {
        return signedConten_operatorFullname;
    }

    public void setSignedConten_operatorFullname(String signedConten_operatorFullname) {
        this.signedConten_operatorFullname = signedConten_operatorFullname;
    }

    public String getSignedConten_signatureType() {
        return signedConten_signatureType;
    }

    public void setSignedConten_signatureType(String signedConten_signatureType) {
        this.signedConten_signatureType = signedConten_signatureType;
    }

    public String getSignedConten_turnoverDate() {
        return signedConten_turnoverDate;
    }

    public void setSignedConten_turnoverDate(String signedConten_turnoverDate) {
        this.signedConten_turnoverDate = signedConten_turnoverDate;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_certificateNum() {
        return customer_certificateNum;
    }

    public void setCustomer_certificateNum(String customer_certificateNum) {
        this.customer_certificateNum = customer_certificateNum;
    }

    public String getCustomer_certificateSeries() {
        return customer_certificateSeries;
    }

    public void setCustomer_certificateSeries(String customer_certificateSeries) {
        this.customer_certificateSeries = customer_certificateSeries;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_status() {
        return customer_status;
    }

    public void setCustomer_status(String customer_status) {
        this.customer_status = customer_status;
    }

    public String getCustomer_tin() {
        return customer_tin;
    }

    public void setCustomer_tin(String customer_tin) {
        this.customer_tin = customer_tin;
    }

    public String getDeliveryTerm_contractDate() {
        return deliveryTerm_contractDate;
    }

    public void setDeliveryTerm_contractDate(String deliveryTerm_contractDate) {
        this.deliveryTerm_contractDate = deliveryTerm_contractDate;
    }

    public String getDeliveryTerm_contractNum() {
        return deliveryTerm_contractNum;
    }

    public void setDeliveryTerm_contractNum(String deliveryTerm_contractNum) {
        this.deliveryTerm_contractNum = deliveryTerm_contractNum;
    }

    public String getProducts_description() {
        return products_description;
    }

    public void setProducts_description(String products_description) {
        this.products_description = products_description;
    }

    public String getProducts_ndsAmount() {
        return products_ndsAmount;
    }

    public void setProducts_ndsAmount(String products_ndsAmount) {
        this.products_ndsAmount = products_ndsAmount;
    }

    public String getProducts_ndsRate() {
        return products_ndsRate;
    }

    public void setProducts_ndsRate(String products_ndsRate) {
        this.products_ndsRate = products_ndsRate;
    }

    public String getProducts_priceWithTax() {
        return products_priceWithTax;
    }

    public void setProducts_priceWithTax(String products_priceWithTax) {
        this.products_priceWithTax = products_priceWithTax;
    }

    public String getProducts_priceWithoutTax() {
        return products_priceWithoutTax;
    }

    public void setProducts_priceWithoutTax(String products_priceWithoutTax) {
        this.products_priceWithoutTax = products_priceWithoutTax;
    }

    public String getProducts_turnoverSize() {
        return products_turnoverSize;
    }

    public void setProducts_turnoverSize(String products_turnoverSize) {
        this.products_turnoverSize = products_turnoverSize;
    }

    public String getProducts_currencyCode() {
        return products_currencyCode;
    }

    public void setProducts_currencyCode(String products_currencyCode) {
        this.products_currencyCode = products_currencyCode;
    }

    public String getProducts_totalExciseAmount() {
        return products_totalExciseAmount;
    }

    public void setProducts_totalExciseAmount(String products_totalExciseAmount) {
        this.products_totalExciseAmount = products_totalExciseAmount;
    }

    public String getProducts_totalNdsAmount() {
        return products_totalNdsAmount;
    }

    public void setProducts_totalNdsAmount(String products_totalNdsAmount) {
        this.products_totalNdsAmount = products_totalNdsAmount;
    }

    public String getProducts_totalPriceWithTax() {
        return products_totalPriceWithTax;
    }

    public void setProducts_totalPriceWithTax(String products_totalPriceWithTax) {
        this.products_totalPriceWithTax = products_totalPriceWithTax;
    }

    public String getProducts_totalPriceWithoutTax() {
        return products_totalPriceWithoutTax;
    }

    public void setProducts_totalPriceWithoutTax(String products_totalPriceWithoutTax) {
        this.products_totalPriceWithoutTax = products_totalPriceWithoutTax;
    }

    public String getProducts_totalTurnoverSize() {
        return products_totalTurnoverSize;
    }

    public void setProducts_totalTurnoverSize(String products_totalTurnoverSize) {
        this.products_totalTurnoverSize = products_totalTurnoverSize;
    }

    public String getSellers_address() {
        return sellers_address;
    }

    public void setSellers_address(String sellers_address) {
        this.sellers_address = sellers_address;
    }

    public String getSellers_bank() {
        return sellers_bank;
    }

    public void setSellers_bank(String sellers_bank) {
        this.sellers_bank = sellers_bank;
    }

    public String getSellers_bik() {
        return sellers_bik;
    }

    public void setSellers_bik(String sellers_bik) {
        this.sellers_bik = sellers_bik;
    }

    public String getSellers_certificateNum() {
        return sellers_certificateNum;
    }

    public void setSellers_certificateNum(String sellers_certificateNum) {
        this.sellers_certificateNum = sellers_certificateNum;
    }

    public String getSellers_certificateSeries() {
        return sellers_certificateSeries;
    }

    public void setSellers_certificateSeries(String sellers_certificateSeries) {
        this.sellers_certificateSeries = sellers_certificateSeries;
    }

    public String getSellers_deliveryDocDate() {
        return sellers_deliveryDocDate;
    }

    public void setSellers_deliveryDocDate(String sellers_deliveryDocDate) {
        this.sellers_deliveryDocDate = sellers_deliveryDocDate;
    }

    public String getSellers_deliveryDocNum() {
        return sellers_deliveryDocNum;
    }

    public void setSellers_deliveryDocNum(String sellers_deliveryDocNum) {
        this.sellers_deliveryDocNum = sellers_deliveryDocNum;
    }

    public String getSellers_iik() {
        return sellers_iik;
    }

    public void setSellers_iik(String sellers_iik) {
        this.sellers_iik = sellers_iik;
    }

    public String getSellers_kbe() {
        return sellers_kbe;
    }

    public void setSellers_kbe(String sellers_kbe) {
        this.sellers_kbe = sellers_kbe;
    }

    public String getSellers_name() {
        return sellers_name;
    }

    public void setSellers_name(String sellers_name) {
        this.sellers_name = sellers_name;
    }

    public String getSellers_tin() {
        return sellers_tin;
    }

    public void setSellers_tin(String sellers_tin) {
        this.sellers_tin = sellers_tin;
    }

    public String getRelatedInvoice_date() {
        return relatedInvoice_date;
    }

    public void setRelatedInvoice_date(String relatedInvoice_date) {
        this.relatedInvoice_date = relatedInvoice_date;
    }

    public String getRelatedInvoice_num() {
        return relatedInvoice_num;
    }

    public void setRelatedInvoice_num(String relatedInvoice_num) {
        this.relatedInvoice_num = relatedInvoice_num;
    }
    
 

}
