package com.unicesumar.ads.tcc.util;

import com.unicesumar.ads.tcc.dto.IndividualListPdfDTO;
import com.unicesumar.ads.tcc.dto.contractDTO.TravelContractPdfDTO;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

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
    public JasperPrint createPdfReport(final List<IndividualListPdfDTO> passengers) throws JRException, IOException {
        UUID code = createCode();
        final InputStream stream = this.getClass().getResourceAsStream("/report.jrxml");
        final JasperReport report = JasperCompileManager.compileReport(stream);
        final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(passengers);
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Squad Go Horse");
        final JasperPrint print = JasperFillManager.fillReport(report, parameters, source);
        return print;
    }

    public JasperPrint createPdfReportContract(final TravelContractPdfDTO contract) throws JRException, IOException {
        UUID code = createCode();
        List<TravelContractPdfDTO> travelContractPdfDTOS = new ArrayList<>();
        travelContractPdfDTOS.add(contract);
        final InputStream stream = this.getClass().getResourceAsStream("/reportContract.jrxml");
        final JasperReport report = JasperCompileManager.compileReport(stream);
        final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(travelContractPdfDTOS);
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Squad Go Horse");
        final JasperPrint print = JasperFillManager.fillReport(report, parameters, source);
        return print;
    }

}