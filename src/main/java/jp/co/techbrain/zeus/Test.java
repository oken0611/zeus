package jp.co.techbrain.zeus;

import com.spire.xls.*;
import org.springframework.util.ResourceUtils;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Workbook wb = new Workbook();
            System.out.println("start" + new Date());
            wb.loadFromFile("invoice.xlsx");
            wb.saveToFile("ToPDF.pdf",FileFormat.PDF);
            System.out.println("  end" + new Date());


    }
}
