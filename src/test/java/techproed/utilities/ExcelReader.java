package techproed.utilities;

import com.github.dockerjava.api.model.CpuUsageConfig;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    Workbook workbook;
    Sheet sheet;
    public ExcelReader(String dosyaYolu , String sayfaIsmi){

        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sayfaIsmi);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Satir ve sutun sayilarini girdigimizde, O hucredeki veriyi return edebilmesi icin;
    public String getCellData (int satir, int sutun){
        Cell cell = sheet.getRow(satir).getCell(sutun);
        return cell.toString();
    }
    //Exceldeki satir sayisi icin;
    public int rowCount(){
        return sheet.getLastRowNum();
    }

}
