package com.dlfc.services.load.service.impl;

import com.dlfc.services.load.dto.ContractDTO;
import com.dlfc.services.load.service.PdfService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by K on 6/28/17.
 */

@Service
public class PdfServiceImpl implements PdfService {
    @Override
    public String generate(ContractDTO contractDTO) {
        String path = "/home/K/Documents/test.pdf";
        Document document = new Document(PageSize.A4);

        try {
            PdfWriter.getInstance(document, new FileOutputStream(path));
            document.addTitle("大连市房屋租赁合同");
//            document.addAuthor("author");
//            document.addSubject("subject");
//            document.addKeywords("keyword");
            document.open();
            document.add(new Paragraph("new Paragraph"));
            PdfPTable table1=new PdfPTable(1);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
        return path;
    }
}
