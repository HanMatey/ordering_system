package ordering_system

import grails.converters.JSON
import orderingSystem.UtilDateService

// use relational one to one

class OrderController {
    UtilDateService utilDateService

    def createOrder(){
        ArrayList<OrderDetail> list = []
        Orders order = new Orders()
        def requestData = request.JSON
        order.customerId = requestData.customerId
        order.date = utilDateService.convertStringToDate(requestData.date)
        order.totalAmount = requestData.totalAmount
        if (order.save(flush: true)){
            requestData.orderDetails.each{ json->// new request use for create ban jrern
              OrderDetail orderDetail = new OrderDetail()
                orderDetail.qty = json.qty
                orderDetail.price = json.price
                orderDetail.productId = json.productId
                orderDetail.save(flash:true)
                list.add(orderDetail)// use for add for render all list in loop
            }
        }else {
            render ("Order is not save.please check again!") as JSON
        }
        order.orderDetails = list // render relational
        render order as JSON
    }

}
