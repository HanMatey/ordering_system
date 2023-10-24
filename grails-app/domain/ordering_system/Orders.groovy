package ordering_system

import grails.converters.JSON
import org.hibernate.criterion.Order

class Orders {

    Long customerId
    Double totalAmount
    Date date

    static hasMany = [orderDetails: OrderDetail]

    static constraints = {
    }

//    static {
//        JSON.registerObjectMarshaller(this){ Order order ->
//            Map map =new LinkedHashMap(order.properties)
//            map.orderDetails = orderDetails.collect{
//                [
//                        id : it.id,
//                        qty : it.qty,
//                        price: it.price,
//                        productId : it.productId
//                ]
//            }
//
//        }
//    }
}
