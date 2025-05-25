package com.example.demo.service.impl;

import com.example.demo.model.dto.ReportRequest;
import com.example.demo.model.dto.ReportResponse;
import com.example.demo.service.ReportService;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {
    @Override
    public ReportResponse generateReport(ReportRequest request) {
        return null;
    }

    @Override
    public byte[] generatePdfReport(ReportRequest request) {
        return new byte[0];
    }

    @Override
    public byte[] generateExcelReport(ReportRequest request) {
        return new byte[0];
    }
    // логика отчёта, генерация PDF/Excel через утилиты
}

