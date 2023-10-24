package ordering_system

import grails.converters.JSON

class ProductController {

    def createProduct() {
        Product product = new Product()
        def requestData = request.JSON
        product.productName = requestData.productName
        product.description = requestData.description
        product.price = requestData.price
        product.stockQty = requestData.stockQty
        product.save(flush :true)
        render product as JSON
    }
    def listAllProduct(){
        def product = Product.list()
        render product as JSON
    }

    def listDetailProduct(){
        Long id = params.long("id")
        Product product = Product.get(id)
        render product as JSON
    }

    def updateProduct(){
        Long id = params.long("id")
        Product product = Product.get(id)
        def requestData = request.JSON
        product.productName = requestData.productName?: product.productName// use for the same price (jenh pricr ddea )
        product.description = requestData.description?: product.description
        product.price = requestData.price?: product.price
        product.stockQty = requestData.stockQty?: product.stockQty
        product.save(flush: true)
        render product as JSON
    }

    def deleteProduct(){
        Long id = params.long("id")
        Product product = Product.get(id)
        product.delete(flush: true)
        render product as JSON
    }
}
