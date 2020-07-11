import org.apache.poi.openxml4j.exceptions.InvalidFormatException
import org.apache.poi.ss.usermodel._
import java.io.File
import java.io.IOException
import java.util
import java.util.Iterator


object routeOptimizer {

  def main(args: Array[String]): Unit = {
    println("Hello abc")

//    var bmw = new Car
//    bmw.topClassExtraCost = 500
//
//    //    println("Road Tax is " + bmw.checkTax())
//
//    println("Road Tax is " + bmw.printTax)
//
//    var result = bmw.cost(10000)
//    println("Total cost of car is " + result)


    // Creating a Workbook from an Excel file (.xls or .xlsx)

    val SAMPLE_XLSX_FILE_PATH = "F:\\Harish\\Classes\\Scala\\project\\projectInput.xlsx"
    val rowNumber = 5

    val workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH))

    // Retrieving the number of sheets in the Workbook
    System.out.println("Workbook has " + workbook.getNumberOfSheets + " Sheets : ")

    //// Get Sheet Names

    // Get name of Sheets
    val sheetIterator = workbook.sheetIterator
    System.out.println("Retrieving Sheets using Iterator")
    while ( {
      sheetIterator.hasNext
    }) {
      val sheet = sheetIterator.next
      System.out.println("=> " + sheet.getSheetName)
    }

    //// Read from Sheet
    // Getting the Sheet at index zero
    val sheet = workbook.getSheetAt(0)

    // Create a DataFormatter to format and get each cell's value as String
    val dataFormatter = new DataFormatter

    // 1. You can obtain a rowIterator and columnIterator and iterate over them
    System.out.println("\n\nIterating over Rows and Columns using Iterator\n")
//    val rowIterator = sheet.rowIterator
//    while ( {
//      rowIterator.hasNext
//    }) {
//      val row = rowIterator.next

      val row =  sheet.getRow(rowNumber - 1 )
      // Now let's iterate over the columns of the current row
      val cellIterator = row.cellIterator
      while ( {
        cellIterator.hasNext
      }) {
        val cell = cellIterator.next
        val cellValue = dataFormatter.formatCellValue(cell)
        System.out.print(cellValue + "\t")
        System.out.println(cell.getColumnIndex)

        if (cellValue.equals("P")){
          addPickUpPoint(cell.getColumnIndex, sheet)
        }

        if (cellValue.equals("D") ){
          addDropOffPoint(cell.getColumnIndex, sheet)
        }

      }
      System.out.println()
//    }

    // Closing the workbook
    workbook.close


  }

  def addPickUpPoint(cell: Int, sheet: Sheet) = {

        val rowIterator = sheet.rowIterator
        while ( {
          rowIterator.hasNext
        }) {
          val row = rowIterator.next
          val cellValue =  row.getCell(4 )
          System.out.println(cellValue)
        }

  }

  def addDropOffPoint(cell: Int, sheet: Sheet) = {

  }


}
