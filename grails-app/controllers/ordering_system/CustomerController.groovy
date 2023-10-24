package ordering_system

import grails.converters.JSON

class CustomerController {
    def createCustomer(){
        Customer customer=new Customer()
        def request=request.JSON
        customer.name=request.name
        customer.email=request.email
        customer.address=request.address
        customer.save(flush:true)
        render customer as JSON

    }
    def updateCustomer() {
        Long id=params.long("id")// call id for update
        Customer customer=Customer.get(id)// create object use for ចាប់យកតម្លៃ list from ID
        if (!customer){
            render ("This ID not exist")
        }
        def request=request.JSON//request
        customer.name=request.name
        customer.email=request.email
        customer.address=request.address
        customer.save(flush:true)
        render customer as JSON

    }
    def listAllCustomer(){
        def customer=Customer.list()
        render customer as JSON

    }
    def detailCustomer(){
        Long id =params.long("id")
        Customer customer=Customer.get(id)
        render customer as JSON
    }
    def deleteCustomer(){
        Long id=params.long("id")
        Customer customer=Customer.get(id)
        if(!customer){
            render("The ID not exist")
        }
        customer.delete(flush:true)
        render customer as JSON
    }

}
