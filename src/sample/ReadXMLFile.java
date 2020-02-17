/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class ReadXMLFile {
  private  XmlDocument mydoc=null;
    public ReadXMLFile() {
      mydoc= new XmlDocument();
    }

    public XmlDocument getMydoc(File myxml_File) throws SAXException, IOException {
        
        try {
            mydoc.setFileName(myxml_File.getName());
            
            File fXmlFile = myxml_File;
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
///XmlDocument mydoc= new XmlDocument();

///	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
 	

NodeList nList = doc.getElementsByTagName("SignedContent");	
 //System.out.println("----------------------------");
 for (int temp = 0; temp < nList.getLength(); temp++) {
         Node nNode = nList.item(temp);		
       // System.out.println("\nCurrent Element :" + nNode.getNodeName());	
         if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                 Element eElement = (Element) nNode;
                 
          if (eElement.getElementsByTagName("date").item(0)!=null){        
         mydoc.setSignedConten_date(eElement.getElementsByTagName("date").item(0).getTextContent());
          }
          if (eElement.getElementsByTagName("invoiceType").item(0)!=null){  
         mydoc.setSignedConten_invoiceType(eElement.getElementsByTagName("invoiceType").item(0).getTextContent());
          }
          if (eElement.getElementsByTagName("num").item(0)!=null){  
         mydoc.setSignedConten_num(eElement.getElementsByTagName("num").item(0).getTextContent());
          }
           if (eElement.getElementsByTagName("operatorFullname").item(0)!=null){  
         mydoc.setSignedConten_operatorFullname(eElement.getElementsByTagName("operatorFullname").item(0).getTextContent());
           }
                if (eElement.getElementsByTagName("signatureType").item(0)!=null){  
         mydoc.setSignedConten_signatureType(eElement.getElementsByTagName("signatureType").item(0).getTextContent());
                }
           if (eElement.getElementsByTagName("turnoverDate").item(0)!=null){       
         mydoc.setSignedConten_turnoverDate(eElement.getElementsByTagName("turnoverDate").item(0).getTextContent());
           }
         }

 }         
  nList = doc.getElementsByTagName("customer");	
	//System.out.println("----------------------------");
	for (int temp = 0; temp < nList.getLength(); temp++) {
		Node nNode = nList.item(temp);		
//System.out.println("\nCurrent Element :" + nNode.getNodeName());	
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
                   if (eElement.getElementsByTagName("address").item(0)!=null){         
                 mydoc.setCustomer_address(eElement.getElementsByTagName("address").item(0).getTextContent());
                   }
                    if (eElement.getElementsByTagName("certificateNum").item(0)!=null){   
                 mydoc.setCustomer_certificateNum(eElement.getElementsByTagName("certificateNum").item(0).getTextContent());
                    }
                     if (eElement.getElementsByTagName("certificateSeries").item(0)!=null){   
                 mydoc.setCustomer_certificateSeries(eElement.getElementsByTagName("certificateSeries").item(0).getTextContent());
                     }
                      if (eElement.getElementsByTagName("name").item(0)!=null){   
                 mydoc.setCustomer_name(eElement.getElementsByTagName("name").item(0).getTextContent());
                      }
                       if (eElement.getElementsByTagName("status").item(0)!=null){
                           System.out.println("condition0");
                           if (eElement.getElementsByTagName("status").item(0).getTextContent()!=null) {
                               System.out.println("condition1");
                               mydoc.setCustomer_status(
                                       eElement.getElementsByTagName("status").item(0).getTextContent() );
                           } else {
                               System.out.println("condition2");
                               mydoc.setCustomer_status("empty");
                           }

                       }
                        if (eElement.getElementsByTagName("tin").item(0)!=null){   
                 mydoc.setCustomer_tin(eElement.getElementsByTagName("tin").item(0).getTextContent()); 
                        }
                }
	}       
        

 nList = doc.getElementsByTagName("deliveryTerm");	
	//System.out.println("----------------------------");
	for (int temp = 0; temp < nList.getLength(); temp++) {
		Node nNode = nList.item(temp);		
	//	System.out.println("\nCurrent Element :" + nNode.getNodeName());	
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
                        
                    
                 if (eElement.getElementsByTagName("contractDate").item(0)!=null){         
                 mydoc.setDeliveryTerm_contractDate(eElement.getElementsByTagName("contractDate").item(0).getTextContent());
                 }
                 if (eElement.getElementsByTagName("contractNum").item(0)!=null){ 
                 mydoc.setDeliveryTerm_contractNum(eElement.getElementsByTagName("contractNum").item(0).getTextContent());
                 }
		}
	}
    	///System.out.println("----------------------------");
        
 nList = doc.getElementsByTagName("RelatedInvoice");	

   if (nList!=null)  {
  
   for (int temp = 0; temp < nList.getLength(); temp++) {
		Node nNode = nList.item(temp);		
	//System.out.println("\nCurrent Element :" + nNode.getNodeName());
               // System.out.println("-------------RelatedInvoice-----IN----------");  
        
              
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
                 
                 
                            if (eElement.getElementsByTagName("contractDate").item(0)!=null){
                            mydoc.setRelatedInvoice_date(eElement.getElementsByTagName("contractDate").item(0).getTextContent());
                            }
                             if (eElement.getElementsByTagName("contractNum").item(0)!=null){
                            mydoc.setRelatedInvoice_num(eElement.getElementsByTagName("contractNum").item(0).getTextContent());
                            }
                    
                  
		}
        
	}
   
   }  
        
	
        
  nList = doc.getElementsByTagName("products");	
	//System.out.println("---------products----------0---------");
	for (int temp = 0; temp < nList.getLength(); temp++) {
		Node nNode = nList.item(temp);		
//		System.out.println("\nCurrent Element :" + nNode.getNodeName());	
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;  
if (eElement.getElementsByTagName("description").item(0)!=null){    
mydoc.setProducts_description(eElement.getElementsByTagName("description").item(0).getTextContent());   
}
if (eElement.getElementsByTagName("ndsAmount").item(0)!=null){
mydoc.setProducts_ndsAmount(eElement.getElementsByTagName("ndsAmount").item(0).getTextContent());
}
if (eElement.getElementsByTagName("ndsRate").item(0)!=null){
mydoc.setProducts_ndsRate(eElement.getElementsByTagName("ndsRate").item(0).getTextContent());
}
if (eElement.getElementsByTagName("priceWithTax").item(0)!=null){
mydoc.setProducts_priceWithTax(eElement.getElementsByTagName("priceWithTax").item(0).getTextContent());
}
if (eElement.getElementsByTagName("priceWithoutTax").item(0)!=null){
mydoc.setProducts_priceWithoutTax(eElement.getElementsByTagName("priceWithoutTax").item(0).getTextContent());
}
if (eElement.getElementsByTagName("turnoverSize").item(0)!=null){
mydoc.setProducts_turnoverSize(eElement.getElementsByTagName("turnoverSize").item(0).getTextContent());
}
if (eElement.getElementsByTagName("currencyCode").item(0)!=null){
mydoc.setProducts_currencyCode(eElement.getElementsByTagName("currencyCode").item(0).getTextContent());
}
if (eElement.getElementsByTagName("totalExciseAmount").item(0)!=null){
mydoc.setProducts_totalExciseAmount(eElement.getElementsByTagName("totalExciseAmount").item(0).getTextContent());
}
if (eElement.getElementsByTagName("totalNdsAmount").item(0)!=null){
mydoc.setProducts_totalNdsAmount(eElement.getElementsByTagName("totalNdsAmount").item(0).getTextContent());
}
if (eElement.getElementsByTagName("totalPriceWithTax").item(0)!=null){
mydoc.setProducts_totalPriceWithTax(eElement.getElementsByTagName("totalPriceWithTax").item(0).getTextContent());
}
if (eElement.getElementsByTagName("totalPriceWithoutTax").item(0)!=null){
mydoc.setProducts_totalPriceWithoutTax(eElement.getElementsByTagName("totalPriceWithoutTax").item(0).getTextContent());
}
if (eElement.getElementsByTagName("totalTurnoverSize").item(0)!=null){
mydoc.setProducts_totalTurnoverSize(eElement.getElementsByTagName("totalTurnoverSize").item(0).getTextContent());
}
                }
	}       
        
          nList = doc.getElementsByTagName("sellers");	
	///System.out.println("----------------------------");
	for (int temp = 0; temp < nList.getLength(); temp++) {
		Node nNode = nList.item(temp);		
		///System.out.println("\nCurrent Element :" + nNode.getNodeName());	
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
if (eElement.getElementsByTagName("address").item(0)!=null){                        
mydoc.setSellers_address(eElement.getElementsByTagName("address").item(0).getTextContent());
}
if (eElement.getElementsByTagName("bank").item(0)!=null){
mydoc.setSellers_bank(eElement.getElementsByTagName("bank").item(0).getTextContent());
}
if (eElement.getElementsByTagName("bik").item(0)!=null){
mydoc.setSellers_bik(eElement.getElementsByTagName("bik").item(0).getTextContent());
}
if (eElement.getElementsByTagName("certificateNum").item(0)!=null){
mydoc.setSellers_certificateNum(eElement.getElementsByTagName("certificateNum").item(0).getTextContent());
}
if (eElement.getElementsByTagName("certificateSeries").item(0)!=null){
mydoc.setSellers_certificateSeries(eElement.getElementsByTagName("certificateSeries").item(0).getTextContent());
}
if (eElement.getElementsByTagName("deliveryDocDate").item(0)!=null){
mydoc.setSellers_deliveryDocDate(eElement.getElementsByTagName("deliveryDocDate").item(0).getTextContent());
}
if (eElement.getElementsByTagName("deliveryDocNum").item(0)!=null){
mydoc.setSellers_deliveryDocNum(eElement.getElementsByTagName("deliveryDocNum").item(0).getTextContent());
}
if (eElement.getElementsByTagName("iik").item(0)!=null){
mydoc.setSellers_iik (eElement.getElementsByTagName("iik").item(0).getTextContent());
}
if (eElement.getElementsByTagName("kbe").item(0)!=null){
mydoc.setSellers_kbe(eElement.getElementsByTagName("kbe").item(0).getTextContent());
}
if (eElement.getElementsByTagName("name").item(0)!=null){
mydoc.setSellers_name(eElement.getElementsByTagName("name").item(0).getTextContent());
}
if (eElement.getElementsByTagName("tin").item(0)!=null){
mydoc.setSellers_tin(eElement.getElementsByTagName("tin").item(0).getTextContent()); 
}
                }
	}  

            
            return mydoc;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ReadXMLFile.class.getName()).log(Level.SEVERE, null, ex);
        }
      return mydoc;
    }


}
