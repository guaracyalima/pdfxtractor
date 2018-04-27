package pdxtractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.sax.xpath.XPathParser;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws IOException, TikaException, SAXException{
		
		BodyContentHandler handler = new BodyContentHandler();
		
		Metadata metadata = new Metadata();
		FileInputStream inputstream = new FileInputStream(new File("/Users/guabirabadev/Desktop/apolices/exibePdf.pdf"));
		ParseContext pcontext = new ParseContext();
		
		//parse da pora do documento
		PDFParser pdfparser = new PDFParser();
		pdfparser.parse(inputstream, handler, metadata, pcontext);
				
		System.out.println("Conteudo da mizera do PD:" + handler.toString());
		String xpto = handler.toString();
		String searchTerm = "Franquias (R$)";
		
		xpto.toLowerCase().contains(searchTerm.toLowerCase());
		
		//System.out.println("O resultado da busca" + xpto);
		String[] metadataNames = metadata.names();
		for(String name : metadataNames) {
			System.out.println(name+ " : " + metadata.get(name));
		}
		

	}
	
	
	
	

}
