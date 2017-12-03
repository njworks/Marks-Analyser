/**
 * Created by lrodrib 10/03/17
 * Contributed by tramch 1502020
 */

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Export {

    private static final String pfdTitle = "group16.pdf";
    private static void addEmptyLine(Paragraph empty, int number) {
        for (int i = 0; i < number; i++) {
            empty.add(new Paragraph(" "));
        }
    }
    private static Font mainTitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 24,
            Font.BOLD);

    public static void pdfexport() {

        Document frame = new Document(PageSize.A4.rotate());
        frame.setMargins(30, 30, 10, 10);


        try {

            PdfWriter.getInstance(frame, new FileOutputStream(new File(pfdTitle)));
            frame.open();

            Image image = Image.getInstance("chart.png");
            Image image2 = Image.getInstance("chart2.png");
            Image image3 = Image.getInstance("chart3.png");
            Image image4 = Image.getInstance("chart4.png");
            Image image5 = Image.getInstance("chart5.png");
            Image image6 = Image.getInstance("chart6.png");
            Image essexlogo = Image.getInstance("essexlogo.png");
            Image fTable = Image.getInstance("Ftable.png");
            Image sTable = Image.getInstance("Stable.png");
            Image wTable = Image.getInstance("Wtable.png");
            essexlogo.setAlignment(Image.MIDDLE);

            //open

            Paragraph maintitle = new Paragraph("Group 16 Module Analyser Report", mainTitleFont);
            maintitle.setAlignment(Element.ALIGN_CENTER);
            Paragraph dash = new Paragraph(" ", mainTitleFont);
            dash.setAlignment(Element.ALIGN_CENTER);
            Paragraph title = new Paragraph("Report Created By:" + "\n" +
                    "Nelvin Joseph" + "\n" +
                    "Luis Rodrigues" + "\n" +
                    "Christopher Gray" + "\n" +
                    "Tanya Ramchandani" + "\n" +
                    "Matthew Noble");
            title.setAlignment(Element.ALIGN_CENTER);
            addEmptyLine(dash,7);
            addEmptyLine(maintitle,6);
            frame.add(maintitle);
            frame.add(essexlogo);
            frame.add(dash);
            frame.add(title);
            frame.add(image6);
            Paragraph pieDetail = new Paragraph("The pie chart shows the in general how will each modules performed," +
                    "such as the bigger the slice, the better the students performed in that module and small slices," +
                    "respectfully mean the students performed worse within that module. " +
                    "However, this isn't very useful in determining how each students performed.");
            pieDetail.setAlignment(Element.ALIGN_CENTER);
            frame.add(pieDetail);
            frame.add(image);
            Paragraph fBarDetail = new Paragraph("The first class bar chart shows the data of students whom overall obtained " +
                    "first class in their degree. The bars then show what the collective average mark of these students by module." +
                    "The lower the average mark, the harder these particular set of students found the module.");
            fBarDetail.setAlignment(Element.ALIGN_CENTER);
            addEmptyLine(fBarDetail,1);
            frame.add(fBarDetail);
            frame.add(image2);
            Paragraph toBarDetail = new Paragraph("The 2:1 class bar chart shows the data of students whom overall obtained " +
                    "2:1 class in their degree. The bars then show what the collective average mark of these students by module."+
                    "The lower the average mark, the harder these particular set of students found the module.");
            toBarDetail.setAlignment(Element.ALIGN_CENTER);
            addEmptyLine(toBarDetail,1);
            frame.add(toBarDetail);
            frame.add(image3);
            Paragraph ttBarDetail = new Paragraph("The 2:2 class bar chart shows the data of students whom overall obtained " +
                    "2:2 class in their degree. The bars then show what the collective average mark of these students by module."+
                    "The lower the average mark, the harder these particular set of students found the module.");
            ttBarDetail.setAlignment(Element.ALIGN_CENTER);
            addEmptyLine(ttBarDetail,1);
            frame.add(ttBarDetail);
            frame.add(image4);
            Paragraph pBarDetail = new Paragraph("The pass class bar chart shows the data of students whom overall obtained " +
                    "pass class in their degree. The bars then show what the collective average mark of these students by module."+
                    "The lower the average mark, the harder these particular set of students found the module.");
            pBarDetail.setAlignment(Element.ALIGN_CENTER);
            addEmptyLine(pBarDetail,1);
            frame.add(pBarDetail);
            frame.add(image5);
            Paragraph failBarDetail = new Paragraph("The fail class bar chart shows the data of students whom overall obtained " +
                    "fail class in their degree. The bars then show what the collective average mark of these students by module."+
                    "The lower the average mark, the harder these particular set of students found the module.");
            failBarDetail.setAlignment(Element.ALIGN_CENTER);
            addEmptyLine(failBarDetail,1);
            frame.add(failBarDetail);
            frame.add(fTable);
            Paragraph fTableDetail = new Paragraph("This table displays the hardest modules to the easiest modules, going from top to bottom. The data includes both strong and weak students.");
            fTableDetail.setAlignment(Element.ALIGN_CENTER);
            addEmptyLine(fTableDetail,1);
            frame.add(fTableDetail);
            frame.add(sTable);
            Paragraph f1TableDetail = new Paragraph("This table displays the hardest modules to the easiest modules, going from top to bottom. The data includes strong students which are first and 2:1.");
            f1TableDetail.setAlignment(Element.ALIGN_CENTER);
            addEmptyLine(f1TableDetail,1);
            frame.add(f1TableDetail);
            frame.add(wTable);
            Paragraph f2TableDetail = new Paragraph("This table displays the hardest modules to the easiest modules, going from top to bottom. The data includes weak students which are 2:2, Pass and Fail.");
            f2TableDetail.setAlignment(Element.ALIGN_CENTER);
            addEmptyLine(f2TableDetail,1);
            frame.add(f2TableDetail);

            frame.close();

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}