package com.unicesumar.ads.tcc.util;

import com.unicesumar.ads.tcc.dto.IndividualDTO;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PDFGenerator {

    /**
     * Method to create a random code to concatenate the file name
     */
    private UUID createCode(){
        UUID uuid = UUID.randomUUID();
        return uuid;
    }

    /**
     * Method to generate a PDF and open
     */
    public void createPdfReport(final List<IndividualDTO> passengers) throws JRException, IOException {
        UUID code = createCode();
        final InputStream stream = this.getClass().getResourceAsStream("/report.jrxml");
        final JasperReport report = JasperCompileManager.compileReport(stream);
        final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(passengers);
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Squad Go Horse");
        final JasperPrint print = JasperFillManager.fillReport(report, parameters, source);
        final String filePath = System.getProperty("java.io.tmpdir");
        JasperExportManager.exportReportToPdfFile(print, filePath + "lista" + code + ".pdf");
        Runtime.getRuntime().exec("cmd /c start " + filePath + "lista" + code + ".pdf");
        File file = new File(filePath + "lista" + code + ".pdf");
        file.deleteOnExit();
    }
}
