package leetcode.normal.n1603

object Solution {

}

/**
  * https://leetcode-cn.com/problems/design-parking-system/
  * 1603. 设计停车系统
  *
  * @param _big 大车车位
  * @param _medium 中车车位
  * @param _small 小车车位
  */
class ParkingSystem(_big: Int, _medium: Int, _small: Int) {

  val numCars = Array(0, _big, _medium, _small)

  def addCar(carType: Int): Boolean = {
    if (numCars(carType) > 0) {
      numCars(carType) -= 1
      true
    } else false
  }
}
