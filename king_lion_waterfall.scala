//1
import scala.collection.mutable.HashMap

//2
class CarbonOffsetCalculator {

 //3
    def calculateOffset(travelDetails: HashMap[String, Double]): Double = {
        //4
        var totalOffset = 0.0
        //5
        travelDetails.foreach{case (mode, distance) =>
            //6
            if (mode == "car") {
                totalOffset += distance * 0.02
            }
            else if (mode == "train") {
                totalOffset += distance * 0.01
            }
            else if (mode == "plane") {
                totalOffset += distance * 0.05
            }
            else {
                //7
                throw new IllegalArgumentException("Invalid transport mode")
            }
        }
        //8
        totalOffset
    }
}

//9
object CarbonOffsetCalculator {
    //10
    def calculateOffset(travelDetails: HashMap[String, Double]): Double = {
        //11
        val calculator = new CarbonOffsetCalculator
        //12
        calculator.calculateOffset(travelDetails)
    }
}

//13
object CarbonOffsetPlatform {
    //14
    def main(args: Array[String]): Unit = {
        //15
        val travelDetails = new HashMap[String, Double]
        //16
        travelDetails.put("car", 200.0)
        travelDetails.put("train", 300.0)
        travelDetails.put("plane", 500.0)
        //17
        val totalOffset = CarbonOffsetCalculator.calculateOffset(travelDetails)
        //18
        println("Total carbon offset = " + totalOffset)
    }
}