package ordering_system

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
        //Customer
        "/customer/createCustomer"(controller: "customer",action: "createCustomer")
        "/customer/ updateCustomer"(controller: "customer",action: "updateCustomer")
        "/customer/listAllCustomer"(controller: "customer",action: "listAllCustomer")
        "/customer/detailCustomer"(controller: "customer",action: "detailCustomer")
        "/customer/deleteCustomer"(controller: "customer",action: "deleteCustomer")

         //Orders
        "/order/createOrder"(controller: "Order",action: "createOrder")


        //Product
        "/Product/createProduct"(controller: "product",action: "createProduct")
        "/Product/listAllProduct"(controller: "product",action: "listAllProduct")
        "/Product/listDetailProduct"(controller: "product",action: "listDetailProduct")
        "/Product/updateProduct"(controller: "product",action: "updateProduct")


    }

}
